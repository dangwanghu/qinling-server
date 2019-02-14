package com.tfssoft.qinling.user.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.user.domain.Manager;
import com.tfssoft.qinling.user.domain.ManagerPostVO;
import com.tfssoft.qinling.user.domain.ManagerSql;
import com.tfssoft.qinling.user.repository.ManagerRepository;

@Repository
public class ManagerRepositoryImpl extends AbstractRepository<Manager> implements ManagerRepository {

	@Override
	public List<Manager> getManagerPageList(String name, int skip, int limit) {
		return this.findAll(ManagerSql.getPageListSql(name, skip, limit));
	}

	@Override
	public List<Manager> getManagerList(String name) {
		return this.findAll(ManagerSql.getListSql(name));
	}

	@Override
	public long getManagerCount(String name) {
		return this.findCount(ManagerSql.getCountSql(name));
	}

	@Override
	public void addManager(ManagerPostVO instance) {
		this.insert(ManagerSql.INSERT_MANAGER, ManagerSql.getInsertObject(instance));
	}

	@Override
	public void updateManager(ManagerPostVO instance) {
		this.update(ManagerSql.getUpdateManagerSql(instance));
	}

	@Override
	public void deleteManager(int id) {
		this.removeOne(ManagerSql.DELETE_MANAGER, id);
	}

	@Override
	public Manager queryByEmailAndPassword(String email, String password) {
		return this.findOne(ManagerSql.getManagerLoginSql(email, password));
	}

}
