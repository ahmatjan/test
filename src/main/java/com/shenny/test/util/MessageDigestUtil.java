/**
 * 
 */
package com.shenny.test.util;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

/**
 * 消息摘要(密码加密用,如果需要改动请联系author)
 *
 * @author boen
 * @createDate 2013年7月24日
 */
public class MessageDigestUtil {
	private final static char[] HEX = "0123456789abcdef".toCharArray();
	/**
	 * default UTF-8
	 */
	private final static String CHARSET = "UTF-8";

	/**
	 * and
	 */
	private final static String UTIL_AND = ":";
	
	
	//base64
   public static String base64HashByMD5(String password, String salt) {
		return base64Hash(password, salt, "MD5");
	}
    public static String base64HashBySHA(String password, String salt) {
    	return base64Hash(password, salt, "SHA");
    }
    public static String base64HashBySHA256(String password, String salt) {
    	return base64Hash(password, salt, "SHA-256");
    }

    //hex
    public static String hexHashByMD5(String password, String salt) {
    	return hexHash(password, salt, "MD5");
    }
    public static String hexHashBySHA(String password, String salt) {
    	return hexHash(password, salt, "SHA");
    }
    public static String hexHashBySHA256(String password, String salt) {
    	return hexHash(password, salt, "SHA-256");
    }
    
	private static String base64Hash(String password, String salt, String algorithm) {
		byte[] bys = byteHash(password, salt, algorithm);
		return  new  String (Base64.encodeBase64(bys));
	}
	private static String hexHash(String password, String salt, String algorithm) {
		byte[] bys = byteHash(password, salt, algorithm);
		return  hex(bys);
	}

	public static String hex(byte[] bys) {
		char[] chs = new char[bys.length * 2];
		for (int i = 0, k = 0; i < bys.length; i++) {
			chs[k++] = HEX[(bys[i] & 0xf0) >>> 4];
			chs[k++] = HEX[bys[i] & 0xf];
		}
		return new String(chs);
	}
	public static byte[] byteHash(String password, String salt, String algorithm) {
		if (password == null || algorithm == null) {
			return null;
		}
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm.trim());
			if (salt != null) {
				// salt lower case
				String saltTemp=salt.toLowerCase();
				StringBuilder passBuilder=new StringBuilder();
				passBuilder.append(saltTemp).append(UTIL_AND).append(password);
				
				md.update(( passBuilder.toString()).getBytes(CHARSET));
			/*	byte[] bys = md.digest();
				md.reset();
				md.update(password.getBytes(CHARSET));
				md.update(DEFAULT_ADD.getBytes(CHARSET));
				md.update(bys);*/
			} else {
				md.update(password.getBytes(CHARSET));
			}
			return md.digest();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String sf[]) {
		String salt = "adminforwk";
		System.out.println(salt);
		System.out.println(MessageDigestUtil.hexHashBySHA256("admin", salt));
		System.out.println(MessageDigestUtil.hexHashBySHA256("admin", salt).length());

		System.out.println(MessageDigestUtil.base64HashBySHA256("admin", salt));
		System.out.println(MessageDigestUtil.base64HashBySHA256("admin", salt).length());

	}

}
