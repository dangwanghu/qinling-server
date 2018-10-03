package com.tfssoft.qinling.fagui.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tfssoft.qinling.base.controller.BaseController;
import com.tfssoft.qinling.fagui.domain.Rule;
import com.tfssoft.qinling.fagui.service.FaGuiService;

@Controller
@RequestMapping("/fagui")
public class FaGuiController extends BaseController {

	@Autowired
	private FaGuiService faGuiService;

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getFaGuiList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Rule> faguiList = faGuiService.getFaGuiList();
			writeJson(faguiList, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

}
