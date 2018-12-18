package com.tfssoft.qinling.shanfeng.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfssoft.qinling.base.controller.BaseController;
import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.shanfeng.service.ShanFengService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "ShanFeng" }, description = "Api list")
@Controller
@RequestMapping("/shanfeng")
public class ShanFengController extends BaseController {

	@Autowired
	private ShanFengService shanFengService;

	@ApiOperation(value = "获取山峰列表", httpMethod = "GET")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getShanFengList(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "skip", required = false) Integer skip,
			@RequestParam(value = "limit", required = false) Integer limit, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Topic> ShanFengList = shanFengService.getShanFengList(skip, limit, name, userId);
			writeJson(ShanFengList, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "获取山峰总数", httpMethod = "GET")
	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public void getShanFengCount(
			@RequestParam(value = "name", required = false) String name,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			long count = shanFengService.getShanFengCount(name);
			writeJson(count, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "新增山峰", httpMethod = "POST")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void postShanFeng(@RequestBody Topic topic, HttpServletRequest request, HttpServletResponse response) {
		try {
			shanFengService.addShanFeng(topic);
			success("保存成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("保存出错！", response);
		}
	}

	@ApiOperation(value = "修改山峰", httpMethod = "PUT")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void putShanFeng(@RequestBody Topic topic, HttpServletRequest request, HttpServletResponse response) {
		try {
			shanFengService.updateShanFeng(topic);
			success("更新成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("更新出错！", response);
		}
	}

	@ApiOperation(value = "删除山峰", httpMethod = "DELETE")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deleteShanFeng(@RequestParam(required = true) Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			shanFengService.deleteShanFeng(id.intValue());
			success("删除成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("删除出错！", response);
		}
	}


}
