package com.shenny.test.util;


import java.io.IOException;
import java.io.StringWriter;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class JsonUtil {
	private JsonUtil(){
		
	}
	
	private static JsonUtil js;
	private static JsonFactory jf;
	private static ObjectMapper mapper;
	
	public  static JsonUtil getInstance(){
		if(js ==null){
			synchronized (JsonUtil.class) {
				if(js==null){
					js = new JsonUtil();
				}
			}
		}
		if(jf ==null){
			synchronized (JsonUtil.class) {
				if(jf==null){
					jf = new JsonFactory();
				}
			}
		}
		if(mapper ==null){
			synchronized (JsonUtil.class) {
				if(mapper==null){
					mapper = new ObjectMapper();
				}
			}
		}
		return js;
		
	}
	
	
	public String obj2Json(Object obj){
		JsonGenerator js =null;
		try {
			StringWriter sw = new StringWriter();
			js  = jf.createJsonGenerator(sw);
			mapper.writeValue(js, obj);
			return sw.toString();
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(js!=null)
				try {
					js.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}
	
	public Object json2Obj(String json, Class<?> clazz){
		try {
			return mapper.readValue(json, clazz);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public JsonNode json2Node(String json){
		try {
			return mapper.readTree(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
