package com.tfssoft.qinling.jubao.controller;

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
	public void postJuBao(@RequestBody Report report, HttpServletRequest request, HttpServletResponse response) {
		try {
			juBaoService.addJuBao(report);
			success("保存成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("保存出错！", response);
		}
	}
	
	@ApiOperation(value = "获取举报列表", httpMethod = "GET")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getJuBaoList(@RequestParam(value = "skip", required = false) Integer skip,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "content", required = false) String content, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Report> jianyiList = juBaoService.getJuBaoList(skip, limit, content, status);
			writeJson(jianyiList, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "获取举报总数", httpMethod = "GET")
	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public void getJuBaoCount(@RequestParam(value = "content", required = false) String content,
			@RequestParam(value = "status", required = false) String status,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			long count = juBaoService.getJuBaoCount(content, status);
			writeJson(count, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "标记举报已处理", httpMethod = "PUT")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void putJuBao(@RequestBody CommentsVO instance, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			juBaoService.updateJuBaoToHandled(instance.getId().intValue(), instance.getComments());
			success("更新成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("更新出错！", response);
		}
	}

	@ApiOperation(value = "删除举报", httpMethod = "DELETE")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deleteJuBao(@RequestParam(required = true) Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			juBaoService.deleteJuBao(id.intValue());
			success("删除成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("删除出错！", response);
		}
	}

}
