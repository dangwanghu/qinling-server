package com.tfssoft.qinling.guiji.service;

import java.util.Date;
import java.util.List;

import com.tfssoft.qinling.guiji.domain.Track;
import com.tfssoft.qinling.guiji.domain.TrackVO;
import com.tfssoft.qinling.guiji.domain.Trail;
import com.tfssoft.qinling.guiji.domain.TrailVO;

public interface GuiJiService {

	public void addGuiJiPoint(List<TrailVO> trails);

	public List<Trail> getGuiJiPointListCurrentWeek(String userId);
	
	public List<Trail> getGuiJiPointList(String userId, Date startDate, Date endDate);

	public List<Track> getGuiJiList(String userId);

	public Track getGuiJiDetail(Integer id);

	public void addGuiJi(TrackVO track);

	public void deleteGuiJiBatch(String ids);

}
