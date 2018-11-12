package com.tfssoft.qinling.jianyi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tfssoft.qinling.base.controller.BaseController;
import com.tfssoft.qinling.jianyi.domain.Suggest;
import com.tfssoft.qinling.jianyi.service.JianYiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"JianYi"}, description = "Api list")
@Controller
@RequestMapping("/jianyi")
public class JianYiController extends BaseController {

	@Autowired
	private JianYiService jianYiService;

	@ApiOperation(value = "提交建议", httpMethod = "POST")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void postJianYi(@RequestBody Suggest suggest, HttpServletRequest request, HttpServletResponse response) {
		try {
			jianYiService.addJianYi(suggest);
			success(response);
		} catch (Exception e) {
			e.printStackTrace();
			error("保存出错！", response);
		}
	}

}
