package com.tfssoft.qinling.guiji.controller;

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
import com.tfssoft.qinling.base.domain.BatchIds;
import com.tfssoft.qinling.guiji.domain.Track;
import com.tfssoft.qinling.guiji.domain.TrackVO;
import com.tfssoft.qinling.guiji.domain.Trail;
import com.tfssoft.qinling.guiji.domain.TrailVO;
import com.tfssoft.qinling.guiji.service.GuiJiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "GuiJi" }, description = "Api list")
@Controller
@RequestMapping("/guiji")
public class GuiJiController extends BaseController {

	@Autowired
	private GuiJiService guiJiService;

	@ApiOperation(value = "发送位置点", httpMethod = "POST")
	@RequestMapping(value = "/location/point", method = RequestMethod.POST)
	public void postGuiJiPoint(@RequestBody TrailVO trail, HttpServletRequest request, HttpServletResponse response) {
		try {
			guiJiService.addGuiJiPoint(trail);
			success("保存成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("保存出错！", response);
		}
	}

	@ApiOperation(value = "查询我的轨迹-当前（目前只查当天）", httpMethod = "GET")
	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public void getGuiJiPointListCurrentWeek(@RequestParam(value = "userId", required = true) String userId,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Trail> trails = guiJiService.getGuiJiPointListCurrentWeek(userId);
			writeJson(trails, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "搜索轨迹", httpMethod = "GET")
	@RequestMapping(value = "/search/location/points", method = RequestMethod.GET)
	public void getGuiJiPointList(@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Trail> trails = guiJiService.getGuiJiPointList(userId, startDate, endDate);
			writeJson(trails, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "轨迹记录", httpMethod = "GET")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getGuiJiList(@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Track> tracks = guiJiService.getGuiJiList(userId, startDate, endDate);
			writeJson(tracks, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "查询一条轨迹详细信息", httpMethod = "GET")
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public void getGuiJiDetail(@RequestParam(value = "id", required = true) Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Track track = guiJiService.getGuiJiDetail(id);
			writeJson(track, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("查询出错！", response);
		}
	}

	@ApiOperation(value = "保存轨迹记录", httpMethod = "POST")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void postGuiJi(@RequestBody TrackVO track, HttpServletRequest request, HttpServletResponse response) {
		try {
			guiJiService.addGuiJi(track);
			success("保存成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("更新出错！", response);
		}
	}

	@ApiOperation(value = "删除轨迹记录", httpMethod = "DELETE")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deleteGuiJi(@RequestBody BatchIds ids, HttpServletRequest request, HttpServletResponse response) {
		try {
			guiJiService.deleteGuiJiBatch(ids.getIds());
			success("删除成功", response);
		} catch (Exception e) {
			e.printStackTrace();
			error("删除出错！", response);
		}
	}

}
