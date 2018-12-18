package com.tfssoft.qinling.jingdian.controller;

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
import com.tfssoft.qinling.jingdian.service.JingDianService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "JingDian" }, description = "Api list")
@Controller
@RequestMapping("/jingdian")
public class JingDianController extends BaseController {

	@Autowired
	private JingDianService jingDianService;

	@ApiOperation(value = "获取景点列表", httpMethod = "GET")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getJingDianList(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "skip", required = false) Integer skip,
			@RequestParam(value = "limit", required = false) Integer limit, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Topic> jingdianList = jingDianService.getJingDianList(skip, limit, name, userId);
			writeJson(jingdianList, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "获取景点总数", httpMethod = "GET")
	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public void getJingDianCount(
			@RequestParam(value = "name", required = false) String name,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			long count = jingDianService.getJingDianCount(name);
			writeJson(count, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "新增景点", httpMethod = "POST")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void postJingDian(@RequestBody Topic topic, HttpServletRequest request, HttpServletResponse response) {
		try {
			jingDianService.addJingDian(topic);
			success("保存成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("保存出错！", response);
		}
	}

	@ApiOperation(value = "修改景点", httpMethod = "PUT")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void putJingDian(@RequestBody Topic topic, HttpServletRequest request, HttpServletResponse response) {
		try {
			jingDianService.updateJingDian(topic);
			success("更新成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("更新出错！", response);
		}
	}

	@ApiOperation(value = "删除景点", httpMethod = "DELETE")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deleteJingDian(@RequestParam(required = true) Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			jingDianService.deleteJingDian(id.intValue());
			success("删除成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("删除出错！", response);
		}
	}

}
