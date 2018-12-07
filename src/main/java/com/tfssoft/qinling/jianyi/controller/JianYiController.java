package com.tfssoft.qinling.jianyi.controller;

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
import com.tfssoft.qinling.base.domain.BaseVO;
import com.tfssoft.qinling.jianyi.domain.Suggest;
import com.tfssoft.qinling.jianyi.service.JianYiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "JianYi" }, description = "Api list")
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
			success("保存成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("保存出错！", response);
		}
	}

	@ApiOperation(value = "获取建议列表", httpMethod = "GET")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getJianYiList(@RequestParam(value = "skip", required = false) Integer skip,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "content", required = false) String content,
			@RequestParam(value = "status", required = false) String status, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Suggest> jianyiList = jianYiService.getJianYiList(skip, limit, content, status);
			writeJson(jianyiList, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "获取建议总数", httpMethod = "GET")
	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public void getJianYiCount(@RequestParam(value = "content", required = false) String content,
			@RequestParam(value = "status", required = false) String status,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			long count = jianYiService.getJianYiCount(content, status);
			writeJson(count, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "标记建议已处理", httpMethod = "PUT")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void putJianYi(@RequestBody BaseVO instance, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			jianYiService.updateJianYiToHandled(instance.getId().intValue());
			success("更新成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("更新出错！", response);
		}
	}

	@ApiOperation(value = "删除建议", httpMethod = "DELETE")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deleteJianYi(@RequestParam(required = true) Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			jianYiService.deleteJianYi(id.intValue());
			success("删除成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("删除出错！", response);
		}
	}

}
