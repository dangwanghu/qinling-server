package com.tfssoft.qinling.base.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public abstract class BaseController {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	/***
	 * 将对象转换成JSON字符串，并响应回前台
	 * @param object
	 * @param response
	 */
	public void writeJson(Object object, HttpServletResponse response) {
		try {
			response.setContentType("text/html;charset=utf-8");
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", true);
			map.put("msg", object);
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(response.getOutputStream(),JsonEncoding.UTF8);
			jsonGenerator.writeObject(map);
			
			jsonGenerator.flush();
			jsonGenerator.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void success(HttpServletResponse response) {
		try {
			response.setContentType("text/html;charset=utf-8");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", true);
			map.put("msg", null);

			ObjectMapper objectMapper = new ObjectMapper();
			JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(response.getOutputStream(), JsonEncoding.UTF8);
			jsonGenerator.writeObject(map);
			
			jsonGenerator.flush();
			jsonGenerator.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void error(String msg, HttpServletResponse response) {
		try {
			response.setContentType("text/html;charset=utf-8");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", false);
			map.put("msg", msg);

			ObjectMapper objectMapper = new ObjectMapper();
			JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(response.getOutputStream(), JsonEncoding.UTF8);
			jsonGenerator.writeObject(map);
			
			jsonGenerator.flush();
			jsonGenerator.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
