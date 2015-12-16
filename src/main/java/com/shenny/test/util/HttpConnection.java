/**
 * SBHttpConnection.java
 * SBCommon
 * 
 * Copyright (c) 2011, Apple Inc.
 * All rights reserved.
 */

package com.shenny.test.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpConnection {

	// =================================================
	// Class Variables
	// =================================================
	private static final Logger logger = LoggerFactory.getLogger(HttpConnection.class);
	public static enum REQUEST_TYPE {
		GET, POST
	};

	// =================================================
	// Instance Variables
	// =================================================
	private String urlString;
	private int statusCode;
	private int connectionTimeOut;
	private int soTimeOut;
	private int retryAttempts ; 
	private String postBodyString;
	private Map<String, String> postBodyMap;
	private String responseString;
	private byte[] responseBytes;
	private String encoding = HTTP.UTF_8;

	// =================================================
	// Constructors
	// =================================================
	public HttpConnection(final String iURLString, final Map<String, String> iPostBodyMap, final String iPostBodyString) {
		urlString = iURLString;
		postBodyMap = iPostBodyMap;
		postBodyString = iPostBodyString;
	}
	public HttpConnection(final String iURLString, final Map<String, String> iPostBodyMap, final String iPostBodyString, final String iEncoding) {
		urlString = iURLString;
		postBodyMap = iPostBodyMap;
		postBodyString = iPostBodyString;
		encoding = iEncoding;
	}

	public HttpConnection(final String iURLString, final Map<String, String> iPostBodyMap, final String iPostBodyString, final int iConnectionTimeOut, final int iSoTimeOut) {
		urlString = iURLString;
		postBodyMap = iPostBodyMap;
		postBodyString = iPostBodyString;
		connectionTimeOut = iConnectionTimeOut;
		soTimeOut = iSoTimeOut;
	}
	
	public HttpConnection(final String iURLString, final Map<String, String> iPostBodyMap, final String iPostBodyString, final int iConnectionTimeOut, final int iSoTimeOut, final int iRetryAttempts) {
		urlString = iURLString;
		postBodyMap = iPostBodyMap;
		postBodyString = iPostBodyString;
		connectionTimeOut = iConnectionTimeOut;
		soTimeOut = iSoTimeOut;
		retryAttempts = iRetryAttempts ;
	}
	
	// =================================================
	// Overridden Methods
	// =================================================
	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (postBodyMap != null) {
			String aValue = null;
			final Set<String> aKeys = postBodyMap.keySet();
			final StringBuilder aBuilder = new StringBuilder();
			for (String aKey : aKeys) {
				aValue = postBodyMap.get(aKey);
				aBuilder.append(aKey);
				aBuilder.append("=");
				aBuilder.append(aValue);
				aBuilder.append("&");
			}
			final int anIndex = aBuilder.lastIndexOf("&");
			aBuilder.deleteCharAt(anIndex);
			return urlString + "?" + aBuilder;
		}
		return urlString;
	}

	// =================================================
	// Class Methods
	// =================================================
	// =================================================
	// Instance Methods
	// =================================================
	/**
	 * Used for invoking GET requests
	 */
	public void invokeGet() {
		HttpParams aHttpParams; 
		if (connectionTimeOut == 0) {
			connectionTimeOut = Constants.CONNECTION_TIMEOUT;
		}
		if (soTimeOut == 0) {
			soTimeOut = Constants.CONNECTION_SO_TIMEOUT;
		}
		boolean isSuccessfull = false ;
		while(retryAttempts >=0 && !isSuccessfull){
			aHttpParams = new BasicHttpParams();
			aHttpParams.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
			aHttpParams.setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, connectionTimeOut);
			aHttpParams.setIntParameter(HttpConnectionParams.SO_TIMEOUT, soTimeOut);
			final HttpClient aHttpClient = new DefaultHttpClient(aHttpParams);
			try {
				final HttpGet aHttpGet = new HttpGet(urlString);
				try {
					final HttpResponse aHTTPResponse = aHttpClient.execute(aHttpGet);
					statusCode = aHTTPResponse.getStatusLine().getStatusCode();
					if (logger.isDebugEnabled()) {
						logger.debug("Message=\"Made a GET request for the URL\" URL=\"{}\"" , urlString);
					}
					if (statusCode == HttpStatus.SC_OK && aHTTPResponse.getEntity() != null) {
						responseBytes = IOUtils.toByteArray(aHTTPResponse.getEntity().getContent());
						responseString = new String(responseBytes, Constants.UTF8).trim();
						isSuccessfull = true ; 
					}
				} catch (final ClientProtocolException aClientProtocolException) {
					logger.error("Message=\"Exception occured while invoking GET\" Exception=\"{}\"" , aClientProtocolException.getMessage());
				} catch (final SocketTimeoutException aSocketTimeoutException) {
					logger.error("Message=\"Request timed out while invoking GET\" Exception=\"{}\"" , aSocketTimeoutException.getMessage());
				} catch (final IOException anIOException) {
					logger.error("Message=\"IO Exception occured while invoking GET\"", anIOException);
				}
				if (logger.isDebugEnabled()) {
					logger.debug("Message=\"Response Recieved from the remote server\"");
				}
			} catch (final IllegalStateException anIllegalStateException) {
				logger.error("Message=\"Illegal State Exception\" Exception=\"{}\"" , anIllegalStateException.getMessage());
			} finally {
				retryAttempts-- ; 
				aHttpClient.getConnectionManager().shutdown();
			}
		}
	}

	/**
	 * Used for invoking POST requests
	 * 
	 * @return
	 */
	public void invokePost() {
		HttpParams aHttpParams ;
		if (connectionTimeOut == 0) {
			connectionTimeOut = Constants.CONNECTION_TIMEOUT;
		}
		if (soTimeOut == 0) {
			soTimeOut = Constants.CONNECTION_SO_TIMEOUT;
		}
		boolean isSuccessful = false ; 
		while (retryAttempts >= 0 && !isSuccessful) {
			aHttpParams = new BasicHttpParams();
			aHttpParams.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
			aHttpParams.setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, connectionTimeOut);
			aHttpParams.setIntParameter(HttpConnectionParams.SO_TIMEOUT, soTimeOut);
			final HttpClient aHttpClient = new DefaultHttpClient(aHttpParams);
			try {
				final HttpPost aHttpPost = new HttpPost(urlString);
				this.updatePostBodyParameters(aHttpPost);
				if (logger.isDebugEnabled()) {
					logger.debug("Message=\"About to make a POST request\" URL=\"{}\"" , urlString);
				}
				try {
					final HttpResponse aHTTPResponse = aHttpClient.execute(aHttpPost);
					statusCode = aHTTPResponse.getStatusLine().getStatusCode();
					if (statusCode == HttpStatus.SC_OK && aHTTPResponse.getEntity() != null) {
						responseBytes = IOUtils.toByteArray(aHTTPResponse.getEntity().getContent());
						responseString = new String(responseBytes, Constants.UTF8).trim();
					}
					isSuccessful = true ; 
				} catch (final ClientProtocolException aClientProtocolException) {
					logger.error("Message=\"Exception occured while invoking POST\" Exception=\"{}\"" , aClientProtocolException.getMessage());
				} catch (final SocketTimeoutException aSocketTimeoutException) {
					logger.error("Message=\"Request timed out while invoking POST\" Exception=\"{}\"" , aSocketTimeoutException.getMessage());
				} catch (final IOException anIOException) {
					logger.error("Message=\"IO Exception occured while invoking POST\"" , anIOException);
				}
				if (logger.isDebugEnabled()) {
					logger.debug("Message=\"Response Recieved from the remote server\"");
				}
			} catch (final IllegalStateException anIllegalStateException) {
				logger.error("Message=\"Illegal State Exception\" Exception=\"{}\"" , anIllegalStateException.getMessage() );
			} finally {
				aHttpClient.getConnectionManager().shutdown();
				retryAttempts--  ;
			}
		}
	}

	/**
	 * Returns true if 200 is returned
	 * 
	 * @return boolean
	 * @throws SBException
	 */
	public boolean didSucceed()  {
		boolean didSucceed = false;
		if (this.statusCode == HttpStatus.SC_OK && StringUtils.isNotEmpty(responseString)) {
			didSucceed = true;
		}
		return didSucceed;
	}
	
	/**
	 * Returns true if 200 is returned
	 * 
	 * @return boolean
	 * @throws SBException
	 */
	public boolean didPingSucceed()  {
		boolean didSucceed = false;
		if (this.statusCode == HttpStatus.SC_OK ) {
			didSucceed = true;
		}
		return didSucceed;
	}

	// =================================================
	// Private Methods
	// =================================================
	/**
	 * @param iPostMethod
	 */
	private void updatePostBodyParameters(final HttpPost iHttpPost) {
		if (postBodyMap != null && !postBodyMap.isEmpty()) {
			final List<NameValuePair> aParamList = new ArrayList<NameValuePair>();
			for (final Map.Entry<String, String> anEntry : postBodyMap.entrySet()) {
				aParamList.add(new BasicNameValuePair(anEntry.getKey(), anEntry.getValue()));
			}
			try {
				iHttpPost.setEntity(new UrlEncodedFormEntity(aParamList, encoding));
			} catch (final UnsupportedEncodingException anUnsupportedEncodingException) {
				logger.error("Message=\"UnsupportedEncodingException exception occured while updating post map\" Exception=\"{}\"" , anUnsupportedEncodingException.getMessage());
			}
		}
		if (StringUtils.isNotEmpty(postBodyString)) {
			iHttpPost.setEntity(new StringEntity(postBodyString, encoding));
		}
	}

	// =================================================
	// Accessors
	// =================================================
	public String getResponseString() {
		return this.responseString;
	}

	public void setResponseString(String iResponseString) {
		this.responseString = iResponseString;
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(int iStatusCode) {
		this.statusCode = iStatusCode;
	}

	public byte[] getResponseBytes() {
		return this.responseBytes;
	}

	public void setResponseBytes(byte[] iResponseBytes) {
		this.responseBytes = iResponseBytes;
	}
	
	public int getConnectionTimeOut() {
		return this.connectionTimeOut;
	}

	public void setConnectionTimeOut(int iConnectionTimeOut) {
		this.connectionTimeOut = iConnectionTimeOut;
	}

	public int getSoTimeOut() {
		return this.soTimeOut;
	}

	public void setSoTimeOut(int iSoTimeOut) {
		this.soTimeOut = iSoTimeOut;
	}
}
