package com.tfssoft.qinling.fagui.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfssoft.qinling.base.controller.BaseController;
import com.tfssoft.qinling.fagui.domain.Rule;
import com.tfssoft.qinling.fagui.service.FaGuiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "FaGui" }, description = "Api list")
@Controller
@RequestMapping("/fagui")
public class FaGuiController extends BaseController {

	@Autowired
	private FaGuiService faGuiService;

	@ApiOperation(value = "获取法规列表", httpMethod = "GET")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getFaGuiList(@RequestParam(value = "skip", required = false) Integer skip,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Rule> faguiList = faGuiService.getFaGuiList(skip, limit, name);
			writeJson(faguiList, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}
	
	@ApiOperation(value = "获取法规总数", httpMethod = "GET")
	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public void getFaGuiCount(@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			long count = faGuiService.getFaGuiCount(name);
			writeJson(count, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

}
