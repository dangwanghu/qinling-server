package com.tfssoft.qinling.zongjiao.controller;

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
	public void getSiMiaoList(@RequestParam(value = "userId", required = false) String userId,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Topic> simiaoList = siMiaoService.getSiMiaoList(userId);
			writeJson(simiaoList, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}
	
}
