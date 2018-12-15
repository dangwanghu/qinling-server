package com.tfssoft.qinling.guiji.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.guiji.domain.Track;
import com.tfssoft.qinling.guiji.domain.TrackVO;
import com.tfssoft.qinling.guiji.domain.Trail;
import com.tfssoft.qinling.guiji.domain.TrailRedis;
import com.tfssoft.qinling.guiji.domain.TrailVO;
import com.tfssoft.qinling.guiji.repository.TrackRepository;
import com.tfssoft.qinling.guiji.repository.TrailRepository;
import com.tfssoft.qinling.guiji.service.GuiJiService;
import com.tfssoft.qinling.web.CacheManager;


@Service
public class GuiJiServiceImpl implements GuiJiService {
	
	@Autowired
	private TrackRepository trackRepository;
	
	@Autowired
	private TrailRepository trailRepository;

	@Autowired
	private CacheManager cacheManager;

	@Override
	public void addGuiJiPoint(TrailVO trail) {
		// trailRepository.addGuiJiPoint(trail);
		Object points = cacheManager.get("guiji_" + trail.getUserId());
		
		TrailRedis newRecord = null;
		if (null != points) {
			newRecord = (TrailRedis) points;
		} else {
			newRecord = new TrailRedis();
		}
		
		List<Trail> trails = newRecord.getVals();
		if (null == trails) {
			trails = new ArrayList<Trail>();
		}
		Trail intance = new Trail();
		intance.setxLat(trail.getxLat());
		intance.setyLng(trail.getyLng());
		intance.setzHeg(trail.getzHeg());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		intance.setTime(format.format(new Date()));
		format = null;
		trails.add(intance);
		
		newRecord.setVals(trails);
		
		cacheManager.set("guiji_" + trail.getUserId(), newRecord, 150);

	}

	@Override
	public List<Trail> getGuiJiPointListCurrentWeek(String userId) {
		return trailRepository.getGuiJiPointListCurrentWeek(userId);
	}
	

	@Override
	public List<Trail> getGuiJiPointList(String userId, String startDate, String endDate) {
		return trailRepository.getGuiJiPointList(userId, startDate, endDate);
	}

	@Override
	public List<Track> getGuiJiList(String userId, String startDate, String endDate) {
		return trackRepository.getGuiJiList(userId, startDate, endDate);
	}
	
	@Override
	public Track getGuiJiDetail(Integer id) {
		Track instance = trackRepository.getGuiJiDetail(id.intValue());
		
		List<Trail> points = trailRepository.getGuiJiPointByIds(instance.getPointIds());
		instance.setPoints(points);
		
		return instance;
	}

	@Override
	public void addGuiJi(TrackVO track) {
		trackRepository.addGuiJi(track);
	}

	@Override
	public void deleteGuiJiBatch(String ids) {
		trackRepository.deleteGuiJiBatch(ids);
	}
	
	@Scheduled(cron = "10 * * * * ?")
	public void job() {
		Set<String> keys = cacheManager.keys("guiji_");
		if (null != keys && keys.size() > 0) {
			for (String key : keys) {
				Object points = cacheManager.get(key);
				if (null != points) {
					TrailRedis newRecord = (TrailRedis) points;
					List<Trail> trails = newRecord.getVals();
					if (trails.size() > 0) {
						trailRepository.addGuiJiPointBatch(key.split("_")[1], trails);
					}
				}
			}
		}
	}
	
}