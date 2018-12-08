package com.tfssoft.qinling.jiucuo.controller;

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
import com.tfssoft.qinling.base.domain.CommentsVO;
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
	
	@ApiOperation(value = "获取纠错列表", httpMethod = "GET")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getJiuCuoList(@RequestParam(value = "skip", required = false) Integer skip,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "content", required = false) String content,
			@RequestParam(value = "status", required = false) String status, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Correction> jianyiList = jiuCuoService.getJiuCuoList(skip, limit, content, status);
			writeJson(jianyiList, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "获取纠错总数", httpMethod = "GET")
	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public void getJiuCuoCount(@RequestParam(value = "content", required = false) String content,
			@RequestParam(value = "status", required = false) String status,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			long count = jiuCuoService.getJiuCuoCount(content, status);
			writeJson(count, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "标记纠错已处理", httpMethod = "PUT")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void putJiuCuo(@RequestBody CommentsVO instance, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			jiuCuoService.updateJiuCuoToHandled(instance.getId().intValue(), instance.getComments());
			success("更新成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("更新出错！", response);
		}
	}

	@ApiOperation(value = "删除纠错", httpMethod = "DELETE")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deleteJiuCuo(@RequestParam(required = true) Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			jiuCuoService.deleteJiuCuo(id.intValue());
			success("删除成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("删除出错！", response);
		}
	}

}
