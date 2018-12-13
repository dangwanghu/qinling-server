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
	public List<Suggest> getJianYiList(Integer skip, Integer limit, String content, String status) {
		if (null == skip && null != limit) {
			return jianYiRepository.getJianYiPageList(content, 0, limit.intValue(), status);
		} else if (null != skip && null == limit) {
			return jianYiRepository.getJianYiPageList(content, skip.intValue(), 10, status);
		} else if (null != skip && null != limit) {
			return jianYiRepository.getJianYiPageList(content, skip.intValue(), limit.intValue(), status);
		} else {
			return jianYiRepository.getJianYiList(content, status);
		}
	}

	@Override
	public long getJianYiCount(String content, String status) {
		return jianYiRepository.getJianYiCount(content, status);
	}

	@Override
	public void updateJianYiToHandled(int id, String comments) {
		Suggest instance = new Suggest();
		instance.setId(id);
		instance.setStatus("1");
		instance.setComments(comments);
		jianYiRepository.updateJianYi(instance);
	}

	@Override
	public void deleteJianYi(int id) {
		jianYiRepository.deleteJianYi(id);
	}

	@Override
	public void deleteJianYiBatch(String ids) {
		jianYiRepository.updateJianYiBatch(ids, "9");
	}	

}