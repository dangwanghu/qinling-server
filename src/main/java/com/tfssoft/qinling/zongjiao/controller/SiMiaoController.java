package com.tfssoft.qinling.zongjiao.controller;

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
import com.tfssoft.qinling.zongjiao.service.SiMiaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "SiMiao" }, description = "Api list")
@Controller
@RequestMapping("/simiao")
public class SiMiaoController extends BaseController {

	@Autowired
	private SiMiaoService siMiaoService;

	@ApiOperation(value = "获取寺庙列表", httpMethod = "GET")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getSiMiaoList(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "skip", required = false) Integer skip,
			@RequestParam(value = "limit", required = false) Integer limit, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Topic> jingdianList = siMiaoService.getSiMiaoList(name, userId, skip, limit);
			writeJson(jingdianList, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "获取寺庙总数", httpMethod = "GET")
	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public void getSiMiaoCount(
			@RequestParam(value = "name", required = false) String name,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			long count = siMiaoService.getSiMiaoCount(name);
			writeJson(count, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "新增寺庙", httpMethod = "POST")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void postSiMiao(@RequestBody Topic topic, HttpServletRequest request, HttpServletResponse response) {
		try {
			siMiaoService.addSiMiao(topic);
			success("保存成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("保存出错！", response);
		}
	}

	@ApiOperation(value = "修改寺庙", httpMethod = "PUT")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void putSiMiao(@RequestBody Topic topic, HttpServletRequest request, HttpServletResponse response) {
		try {
			siMiaoService.updateSiMiao(topic);
			success("更新成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("更新出错！", response);
		}
	}

	@ApiOperation(value = "删除寺庙", httpMethod = "DELETE")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deleteSiMiao(@RequestParam(required = true) Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			siMiaoService.deleteSiMiao(id.intValue());
			success("删除成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("删除出错！", response);
		}
	}

	
}
