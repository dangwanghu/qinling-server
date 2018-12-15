package com.tfssoft.qinling.guiji.service;

import java.util.List;

import com.tfssoft.qinling.guiji.domain.Track;
import com.tfssoft.qinling.guiji.domain.TrackVO;
import com.tfssoft.qinling.guiji.domain.Trail;
import com.tfssoft.qinling.guiji.domain.TrailVO;

public interface GuiJiService {

	public void addGuiJiPoint(TrailVO trail);

	public List<Trail> getGuiJiPointListCurrentWeek(String userId);
	
	public List<Trail> getGuiJiPointList(String userId, String startDate, String endDate);

	public List<Track> getGuiJiList(String userId, String startDate, String endDate);

	public Track getGuiJiDetail(Integer id);

	public void addGuiJi(TrackVO track);

	public void deleteGuiJiBatch(String ids);

}
