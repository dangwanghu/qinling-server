package com.tfssoft.qinling.yukou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public void getYuKouList(@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "xiangzhen", required = false) Integer xiangzhen, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Topic> yukouList = yuKouService.getYuKouList(xiangzhen, userId);
			writeJson(yukouList, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

}
