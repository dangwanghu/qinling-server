package com.tfssoft.qinling.zongjiao.controller;

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
	
	@ApiOperation(value = "获取村庄总数", httpMethod = "GET")
	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public void getCunZhuangCount(@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			long count = cunZhuangService.getCunZhuangCount(name);
			writeJson(count, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "新增村庄", httpMethod = "POST")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void postCunZhuang(@RequestBody Topic topic, HttpServletRequest request, HttpServletResponse response) {
		try {
			cunZhuangService.addCunZhuang(topic);
			success("保存成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("保存出错！", response);
		}
	}
	
	@ApiOperation(value = "修改村庄", httpMethod = "PUT")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void putCunZhuang(@RequestBody Topic topic, HttpServletRequest request, HttpServletResponse response) {
		try {
			cunZhuangService.updateCunZhuang(topic);
			success("更新成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("更新出错！", response);
		}
	}
	
	@ApiOperation(value = "删除村庄", httpMethod = "DELETE")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deleteCunZhuang(@RequestParam(required = true) Integer id, HttpServletRequest request, HttpServletResponse response) {
		try {
			cunZhuangService.deleteCunZhuang(id.intValue());
			success("删除成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("删除出错！", response);
		}
	}

}
