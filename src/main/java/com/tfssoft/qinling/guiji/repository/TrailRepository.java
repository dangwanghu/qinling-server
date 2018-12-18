package com.tfssoft.qinling.guiji.repository;

import java.util.Date;
import java.util.List;

import com.tfssoft.qinling.guiji.domain.Trail;
import com.tfssoft.qinling.guiji.domain.TrailVO;

public interface TrailRepository {

	public void addGuiJiPoint(TrailVO trail);
	
	public void addGuiJiPointBatch(String userId, List<Trail> trails);

	public List<Trail> getGuiJiPointListCurrentWeek(String userId);
	
	public List<Trail> getGuiJiPointList(String userId, Date startDate, Date endDate);

	public List<Trail> getGuiJiPointByIds(String ids);	
}
