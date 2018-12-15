package com.tfssoft.qinling.guiji.repository;

import java.util.List;

import com.tfssoft.qinling.guiji.domain.Track;
import com.tfssoft.qinling.guiji.domain.TrackVO;

public interface TrackRepository {

	public List<Track> getGuiJiList(String userId, String startDate, String endDate);

	public Track getGuiJiDetail(int id);

	public void addGuiJi(TrackVO track);

	public void deleteGuiJiBatch(String ids);

}
