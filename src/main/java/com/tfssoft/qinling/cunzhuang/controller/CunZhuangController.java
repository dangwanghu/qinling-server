package com.tfssoft.qinling.cunzhuang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tfssoft.qinling.base.controller.BaseController;
import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.cunzhuang.service.CunZhuangService;

@Controller
@RequestMapping("/cunzhuang")
public class CunZhuangController extends BaseController {

	@Autowired
	private CunZhuangService cunZhuangService;

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getCunZhuangList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Topic> cunzhuangList = cunZhuangService.getCunZhuangList();
			writeJson(cunzhuangList, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

}
