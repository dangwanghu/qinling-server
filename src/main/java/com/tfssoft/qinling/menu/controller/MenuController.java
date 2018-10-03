package com.tfssoft.qinling.menu.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tfssoft.qinling.base.controller.BaseController;
import com.tfssoft.qinling.util.JsonReader;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

	@Value(value="classpath:config/menus.json")
	private Resource data;

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getContactByName(HttpServletRequest request, HttpServletResponse response) {
		try {
			File file = data.getFile();
			String jsonData = JsonReader.read(file);
			JSONArray jsonArray = JSONArray.fromObject(jsonData);
			writeJson(jsonArray, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

}
