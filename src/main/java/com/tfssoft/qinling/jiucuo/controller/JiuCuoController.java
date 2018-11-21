package com.tfssoft.qinling.jiucuo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tfssoft.qinling.base.controller.BaseController;
import com.tfssoft.qinling.jiucuo.domain.Correction;
import com.tfssoft.qinling.jiucuo.service.JiuCuoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"JiuCuo"}, description = "Api list")
@Controller
@RequestMapping("/jiucuo")
public class JiuCuoController extends BaseController {

	@Autowired
	private JiuCuoService jiuCuoService;

	@ApiOperation(value = "发布纠错", httpMethod = "POST")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void postJiuCuo(@RequestBody Correction correction, HttpServletRequest request, HttpServletResponse response) {
		try {
			jiuCuoService.addJiuCuo(correction);
			success("保存成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("保存出错！", response);
		}
	}

}
