package com.tfssoft.qinling.shanfeng.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tfssoft.qinling.base.controller.BaseController;
import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.shanfeng.service.ShanFengService;

@Controller
@RequestMapping("/shanfeng")
public class ShanFengController extends BaseController {

	@Autowired
	private ShanFengService shanFengService;

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getShanFengList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Topic> shanfengList = shanFengService.getShanFengList();
			writeJson(shanfengList, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

}
