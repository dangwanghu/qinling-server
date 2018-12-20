package com.tfssoft.qinling.yukou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.base.domain.Topic;
import com.tfssoft.qinling.yukou.repository.YuKouRepository;
import com.tfssoft.qinling.yukou.service.YuKouService;


@Service
public class YuKouServiceImpl implements YuKouService {
	
	@Autowired
	private YuKouRepository yuKouRepository;
	
	@Override
	public List<Topic> getYuKouList(Integer xiangzhen, String name, String userId, Integer skip, Integer limit) {
		if (null == skip && null != limit) {
			return yuKouRepository.getYuKouPageList(xiangzhen, name, userId, 0, limit.intValue());
		} else if (null != skip && null == limit) {
			return yuKouRepository.getYuKouPageList(xiangzhen, name, userId, skip.intValue(), 10);
		} else if (null != skip && null != limit) {
			return yuKouRepository.getYuKouPageList(xiangzhen, name, userId, skip.intValue(), limit.intValue());
		} else {
			return yuKouRepository.getYuKouList(xiangzhen, name, userId);
		}
	}

	@Override
	public long getYuKouCount(Integer xiangzhen, String name) {
		return yuKouRepository.getYuKouCount(xiangzhen, name);
	}

	@Override
	public void addYuKou(Topic instance) {
		yuKouRepository.addYuKou(instance);
	}

	@Override
	public void updateYuKou(Topic instance) {
		yuKouRepository.updateYuKou(instance);
	}

	@Override
	public void deleteYuKou(int id) {
		yuKouRepository.deleteYuKou(id);
	}	

}