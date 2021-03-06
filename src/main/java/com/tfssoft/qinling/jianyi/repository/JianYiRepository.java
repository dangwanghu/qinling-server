package com.tfssoft.qinling.jianyi.repository;

import java.util.List;

import com.tfssoft.qinling.jianyi.domain.Suggest;

public interface JianYiRepository {

	public void addJianYi(Suggest instance);

	public List<Suggest> getJianYiPageList(String content, int skip, int limit, String status, String statusIn, String userId);

	public List<Suggest> getJianYiList(String content, String status, String statusIn, String userId);

	public long getJianYiCount(String content, String status, String statusIn, String userId);

	public void updateJianYi(Suggest instance);

	public void deleteJianYi(int id);

	public void updateJianYiBatch(String ids, String status);
}
