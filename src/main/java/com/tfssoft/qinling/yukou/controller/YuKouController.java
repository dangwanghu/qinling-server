package com.tfssoft.qinling.yukou.controller;

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
import com.tfssoft.qinling.yukou.service.YuKouService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "YuKou" }, description = "Api list")
@Controller
@RequestMapping("/yukou")
public class YuKouController extends BaseController {

	@Autowired
	private YuKouService yuKouService;

	@ApiOperation(value = "获取峪口列表", httpMethod = "GET")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getYuKouList(
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "xiangzhen", required = false) Integer xiangzhen, 
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "skip", required = false) Integer skip,
			@RequestParam(value = "limit", required = false) Integer limit,
			HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Topic> yukouList = yuKouService.getYuKouList(xiangzhen, name, userId, skip, limit);
			writeJson(yukouList, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}
	
	
	@ApiOperation(value = "获取峪口总数", httpMethod = "GET")
	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public void getYuKouCount(
			@RequestParam(value = "xiangzhen", required = false) Integer xiangzhen, 
			@RequestParam(value = "name", required = false) String name,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			long count = yuKouService.getYuKouCount(xiangzhen, name);
			writeJson(count, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "新增峪口", httpMethod = "POST")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void postYuKou(@RequestBody Topic topic, HttpServletRequest request, HttpServletResponse response) {
		try {
			yuKouService.addYuKou(topic);
			success("保存成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("保存出错！", response);
		}
	}

	@ApiOperation(value = "修改峪口", httpMethod = "PUT")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void putYuKou(@RequestBody Topic topic, HttpServletRequest request, HttpServletResponse response) {
		try {
			yuKouService.updateYuKou(topic);
			success("更新成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("更新出错！", response);
		}
	}

	@ApiOperation(value = "删除峪口", httpMethod = "DELETE")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deleteYuKou(@RequestParam(required = true) Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			yuKouService.deleteYuKou(id.intValue());
			success("删除成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("删除出错！", response);
		}
	}


}
