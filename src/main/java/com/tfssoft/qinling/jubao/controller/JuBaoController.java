package com.tfssoft.qinling.jubao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tfssoft.qinling.base.controller.BaseController;
import com.tfssoft.qinling.jubao.domain.Report;
import com.tfssoft.qinling.jubao.service.JuBaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"JuBao"}, description = "Api list")
@Controller
@RequestMapping("/jubao")
public class JuBaoController extends BaseController {

	@Autowired
	private JuBaoService juBaoService;

	@ApiOperation(value = "提交举报", httpMethod = "POST")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void postJianYi(@RequestBody Report report, HttpServletRequest request, HttpServletResponse response) {
		try {
			juBaoService.addJuBao(report);
			success("保存成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("保存出错！", response);
		}
	}

}
