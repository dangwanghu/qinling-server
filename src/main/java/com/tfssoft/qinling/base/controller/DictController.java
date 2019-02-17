package com.tfssoft.qinling.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfssoft.qinling.base.domain.Dict;
import com.tfssoft.qinling.base.domain.ResourceTree;
import com.tfssoft.qinling.base.service.DictService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "Dict" }, description = "Api list")
@Controller
@RequestMapping("/dict")
public class DictController extends BaseController {
	@Autowired
	private DictService dictService;

	@ApiOperation(value = "区县列表", httpMethod = "GET")
	@RequestMapping(value = "/quxian/list", method = RequestMethod.GET)
	public void getCountyDict(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Dict> result = dictService.getQxList();
			writeJson(result, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "乡镇列表", httpMethod = "GET")
	@RequestMapping(value = "/xiangzhen/list", method = RequestMethod.GET)
	public void getCountyDict(@RequestParam(value = "quxian", required = false) Integer quxian,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Dict> result = dictService.getXzList(quxian);
			writeJson(result, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}
	
	@ApiOperation(value = "资源列表", httpMethod = "GET")
	@RequestMapping(value = "/resource/list", method = RequestMethod.GET)
	public void getResourceDict(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<ResourceTree> result = dictService.getResources(null);
			writeJson(result, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

}
