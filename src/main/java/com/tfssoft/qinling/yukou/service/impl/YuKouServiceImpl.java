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
	
	public List<Topic> getYuKouList(Integer xiangzhen) {
		return yuKouRepository.getYuKouList(xiangzhen);
	}	

}