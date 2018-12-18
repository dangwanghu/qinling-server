package com.tfssoft.qinling.guiji.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.guiji.domain.Track;
import com.tfssoft.qinling.guiji.domain.TrackSql;
import com.tfssoft.qinling.guiji.domain.TrackVO;
import com.tfssoft.qinling.guiji.repository.TrackRepository;

@Repository	
public class TrackRepositoryImpl extends AbstractRepository<Track> implements TrackRepository {

	@Override
	public List<Track> getGuiJiList(String userId) {
		return this.findAll(TrackSql.getListSql(userId));
	}

	@Override
	public Track getGuiJiDetail(int id) {
		return this.findOne(TrackSql.getByIdSql(id));
	}

	@Override
	public void addGuiJi(TrackVO track) {
		this.insert(TrackSql.INSERT_TRACK, TrackSql.getInsertObject(track));
	}

	@Override
	public void deleteGuiJiBatch(String ids) {
		this.update(TrackSql.getDeleteTrackSql(ids));
	}
	
}
