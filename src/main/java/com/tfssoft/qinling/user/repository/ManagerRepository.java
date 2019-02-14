package com.tfssoft.qinling.user.repository;

import java.util.List;

import com.tfssoft.qinling.user.domain.Manager;
import com.tfssoft.qinling.user.domain.ManagerPostVO;

public interface ManagerRepository {

	public List<Manager> getManagerPageList(String name, int skip, int limit);

	public List<Manager> getManagerList(String name);

	public long getManagerCount(String name);

	public void addManager(ManagerPostVO instance);

	public void updateManager(ManagerPostVO instance);

	public void deleteManager(int id);

	public Manager queryByEmailAndPassword(String email, String password);
	
}
