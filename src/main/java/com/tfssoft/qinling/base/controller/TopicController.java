package com.tfssoft.qinling.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tfssoft.qinling.base.domain.TopicAuth;
import com.tfssoft.qinling.base.service.TopicService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "Topic" }, description = "Api list")
@Controller
@RequestMapping("/topic")
public class TopicController extends BaseController {
	@Autowired
	private TopicService topicService;

	@ApiOperation(value = "上报新增地点", httpMethod = "POST")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void searchTopic(@RequestBody TopicAuth topic, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			topicService.addTopicAuth(topic);
			success("上报成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("上报出错！", response);
		}
	}

}
