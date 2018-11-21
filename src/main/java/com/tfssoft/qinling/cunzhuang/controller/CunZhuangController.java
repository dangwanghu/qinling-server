package com.tfssoft.qinling.cunzhuang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tfssoft.qinling.base.controller.BaseController;
import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.cunzhuang.service.CunZhuangService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"CunZhuang"}, description = "Api list")
@Controller
@RequestMapping("/cunzhuang")
public class CunZhuangController extends BaseController {

	@Autowired
	private CunZhuangService cunZhuangService;

	@ApiOperation(value = "获取村庄列表", httpMethod = "GET")
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
	
	@ApiOperation(value = "新增村庄", httpMethod = "POST")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void postCunZhuang(@RequestBody Topic topic, HttpServletRequest request, HttpServletResponse response) {
		try {
			cunZhuangService.addCunZhuang(topic);
			success("保存成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("保存出错！", response);
		}
	}

}
