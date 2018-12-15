package com.tfssoft.qinling.guiji.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.guiji.domain.Trail;
import com.tfssoft.qinling.guiji.domain.TrailSql;
import com.tfssoft.qinling.guiji.domain.TrailVO;
import com.tfssoft.qinling.guiji.repository.TrailRepository;

@Repository	
public class TrailRepositoryImpl extends AbstractRepository<Trail> implements TrailRepository {

	@Override
	public void addGuiJiPoint(TrailVO trail) {
		this.insert(TrailSql.INSERT_TRAIL, TrailSql.getInsertObject(trail));
	}
	
	@Override
	public void addGuiJiPointBatch(String userId, List<Trail> trails) {
		this.insertBatch(TrailSql.INSERT_TRAIL, TrailSql.getInsertObjectBatch(userId, trails));
	}

	@Override
	public List<Trail> getGuiJiPointListCurrentWeek(String userId) {
		return this.findAll(TrailSql.getListCurrentWeekSql(userId));
	}

	@Override
	public List<Trail> getGuiJiPointByIds(String ids) {
		return this.findAll(TrailSql.getListByIdsSql(ids));
	}

	@Override
	public List<Trail> getGuiJiPointList(String userId, String startDate, String endDate) {
		return this.findAll(TrailSql.getListSql(userId, startDate, endDate));
	}
	
}
