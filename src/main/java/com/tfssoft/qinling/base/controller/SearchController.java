package com.tfssoft.qinling.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.base.service.TopicService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "Search" }, description = "Api list")
@Controller
@RequestMapping("/search")
public class SearchController extends BaseController {
	@Autowired
	private TopicService topicService;

	@ApiOperation(value = "专题搜索", httpMethod = "GET")
	@RequestMapping(value = "/subject", method = RequestMethod.GET)
	public void searchTopic(@RequestParam(value = "userId", required = false) String userId,
			@RequestParam("keywords") String keywords, HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Topic> result = topicService.getTopicList(keywords, userId);
			writeJson(result, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

}
