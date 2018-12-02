package com.tfssoft.qinling.jianyi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.jianyi.domain.Suggest;
import com.tfssoft.qinling.jianyi.repository.JianYiRepository;
import com.tfssoft.qinling.jianyi.service.JianYiService;


@Service
public class JianYiServiceImpl implements JianYiService {
	
	@Autowired
	private JianYiRepository jianYiRepository;

	@Override
	public void addJianYi(Suggest instance) {
		jianYiRepository.addJianYi(instance);
	}

	@Override
	public List<Suggest> getJianYiList(Integer skip, Integer limit, String content) {
		if (null == skip && null != limit) {
			return jianYiRepository.getJianYiPageList(content, 0, limit.intValue());
		} else if (null != skip && null == limit) {
			return jianYiRepository.getJianYiPageList(content, skip.intValue(), 10);
		} else if (null != skip && null != limit) {
			return jianYiRepository.getJianYiPageList(content, skip.intValue(), limit.intValue());
		} else {
			return jianYiRepository.getJianYiList(content);
		}
	}

	@Override
	public long getJianYiCount(String content) {
		return jianYiRepository.getJianYiCount(content);
	}

	@Override
	public void updateJianYiToHandled(int id) {
		Suggest instance = new Suggest();
		instance.setId(id);
		instance.setStatus("1");
		jianYiRepository.updateJianYi(instance);
	}

	@Override
	public void deleteJianYi(int id) {
		jianYiRepository.deleteJianYi(id);
	}	

}