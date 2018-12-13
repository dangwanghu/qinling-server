package com.tfssoft.qinling.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfssoft.qinling.base.domain.AuthVO;
import com.tfssoft.qinling.base.domain.BatchIds;
import com.tfssoft.qinling.base.domain.Topic;
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
	public void searchTopic(@RequestBody TopicAuth topic, HttpServletRequest request, HttpServletResponse response) {
		try {
			topicService.addTopicAuth(topic);
			success("上报成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("上报出错！", response);
		}
	}

	@ApiOperation(value = "专题详情", httpMethod = "GET")
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public void getTopicDetail(@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "topicId", required = true) String id,
			@RequestParam(value = "topicType", required = true) String type, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Topic instance = topicService.getTopicDetail(userId, id, type);
			writeJson(instance, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "新增地点-列表", httpMethod = "GET")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getTopicAuthList(@RequestParam(value = "skip", required = false) Integer skip,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "locationDesc", required = false) String name,
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "source", required = true, defaultValue = "ADMIN") String source,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			List<TopicAuth> result = topicService.getTopicAuthList(skip, limit, name, source, userId);
			writeJson(result, response);
			;
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "新增地点-总数", httpMethod = "GET")
	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public void getTopicAuthCount(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "source", required = true, defaultValue = "ADMIN") String source,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			long count = topicService.getTopicAuthCount(name, source, userId);
			writeJson(count, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "新增地点-用户删除", httpMethod = "DELETE")
	@RequestMapping(value = "/only-for/user", method = RequestMethod.DELETE)
	public void deleteTopicAuth(@RequestBody BatchIds batchIds, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			topicService.deleteTopicAuth(batchIds.getIds());
			success("处理成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("处理出错！", response);
		}
	}

	@ApiOperation(value = "新增地点-管理员删除", httpMethod = "DELETE")
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public void deleteTopicAuthAdmin(@RequestBody BatchIds batchIds, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			topicService.deleteTopicAuthAdmin(batchIds.getIds());
			success("处理成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("处理出错！", response);
		}
	}

	@ApiOperation(value = "新增地点-审核", httpMethod = "PUT")
	@RequestMapping(value = "auth", method = RequestMethod.PUT)
	public void updateTopicAuth(@RequestBody AuthVO authVO, HttpServletRequest request, HttpServletResponse response) {
		try {
			topicService.updateTopicAuth(authVO);
			success("处理成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("处理出错！", response);
		}
	}

}
