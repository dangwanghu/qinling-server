package com.tfssoft.qinling.jingdian.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tfssoft.qinling.base.controller.BaseController;
import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.jingdian.service.JingDianService;

@Controller
@RequestMapping("/jingdian")
public class JingDianController extends BaseController {

	@Autowired
	private JingDianService jingdianService;

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getJingDianList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Topic> jingdianList = jingdianService.getJingDianList();
			writeJson(jingdianList, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

}
