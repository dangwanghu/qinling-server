package com.tfssoft.qinling.jiucuo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.jiucuo.domain.Correction;
import com.tfssoft.qinling.jiucuo.repository.JiuCuoRepository;
import com.tfssoft.qinling.jiucuo.service.JiuCuoService;


@Service
public class JiuCuoServiceImpl implements JiuCuoService {
	
	@Autowired
	private JiuCuoRepository jiuCuoRepository;
	
	@Override
	public void addJiuCuo(Correction instance) {
		jiuCuoRepository.addJiuCuo(instance);
	}

	@Override
	public List<Correction> getJiuCuoList(Integer skip, Integer limit, String content) {
		if (null == skip && null != limit) {
			return jiuCuoRepository.getJiuCuoPageList(content, 0, limit.intValue());
		} else if (null != skip && null == limit) {
			return jiuCuoRepository.getJiuCuoPageList(content, skip.intValue(), 10);
		} else if (null != skip && null != limit) {
			return jiuCuoRepository.getJiuCuoPageList(content, skip.intValue(), limit.intValue());
		} else {
			return jiuCuoRepository.getJiuCuoList(content);
		}
	}

	@Override
	public long getJiuCuoCount(String content) {
		return jiuCuoRepository.getJiuCuoCount(content);
	}

	@Override
	public void updateJiuCuoToHandled(int id) {
		Correction instance = new Correction();
		instance.setId(id);
		instance.setStatus("1");
		jiuCuoRepository.updateJiuCuo(instance);
	}

	@Override
	public void deleteJiuCuo(int id) {
		jiuCuoRepository.deleteJiuCuo(id);
	}	

}