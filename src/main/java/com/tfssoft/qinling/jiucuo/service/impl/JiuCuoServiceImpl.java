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
	public List<Correction> getJiuCuoList(Integer skip, Integer limit, String content, String status, String source,
			String userId) {
		String statusIn = "0,1,2,9";
		if (!"ADMIN".equals(source)) {
			statusIn = "0,1,2";
		}
		if (null == skip && null != limit) {
			return jiuCuoRepository.getJiuCuoPageList(content, 0, limit.intValue(), status, statusIn, userId);
		} else if (null != skip && null == limit) {
			return jiuCuoRepository.getJiuCuoPageList(content, skip.intValue(), 10, status, statusIn, userId);
		} else if (null != skip && null != limit) {
			return jiuCuoRepository.getJiuCuoPageList(content, skip.intValue(), limit.intValue(), status, statusIn, userId);
		} else {
			return jiuCuoRepository.getJiuCuoList(content, status, statusIn, userId);
		}
	}

	@Override
	public long getJiuCuoCount(String content, String status, String source, String userId) {
		String statusIn = "0,1,2,9";
		if (!"ADMIN".equals(source)) {
			statusIn = "0,1,2";
		}
		return jiuCuoRepository.getJiuCuoCount(content, status, statusIn, userId);
	}

	@Override
	public void updateJiuCuoToHandled(int id, String comments) {
		Correction instance = new Correction();
		instance.setId(id);
		instance.setStatus("1");
		instance.setComments(comments);
		jiuCuoRepository.updateJiuCuo(instance);
	}

	@Override
	public void deleteJiuCuo(int id) {
		jiuCuoRepository.deleteJiuCuo(id);
	}

	@Override
	public void deleteJiuCuoBatch(String ids) {
		jiuCuoRepository.updateJiuCuoBatch(ids, "9");
	}	

}