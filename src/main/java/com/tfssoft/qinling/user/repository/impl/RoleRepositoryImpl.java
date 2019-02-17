package com.tfssoft.qinling.user.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.user.domain.Role;
import com.tfssoft.qinling.user.domain.RolePostVO;
import com.tfssoft.qinling.user.domain.RoleSql;
import com.tfssoft.qinling.user.repository.RoleRepository;

@Repository
public class RoleRepositoryImpl extends AbstractRepository<Role> implements RoleRepository {

	@Override
	public List<Role> getRolePageList(String name, int skip, int limit) {
		List<Role> list = this.findAll(RoleSql.getPageListSql(name, skip, limit));
		for (Role role : list) {
			Role tmp = this.findOne(RoleSql.getRoleIdsSql(role.getScope()));
			role.setScopeIds(tmp.getScopeIds());
		}
		return list;
	}

	@Override
	public List<Role> getRoleList(String name) {
		List<Role> list =  this.findAll(RoleSql.getListSql(name));
		for (Role role : list) {
			Role tmp = this.findOne(RoleSql.getRoleIdsSql(role.getScope()));
			role.setScopeIds(tmp.getScopeIds());
		}
		return list;
	}

	@Override
	public long getRoleCount(String name) {
		return this.findCount(RoleSql.getCountSql(name));
	}

	@Override
	public void addRole(RolePostVO instance) {
		this.insert(RoleSql.INSERT_ROLE, RoleSql.getInsertObject(instance));
	}

	@Override
	public void updateRole(RolePostVO instance) {
		this.updatePrepared(RoleSql.getUpdateRoleSql(instance), RoleSql.getUpdatePreparedObject(instance));
	}

	@Override
	public void deleteRole(int id) {
		this.removeOne(RoleSql.DELETE_ROLE, id);
	}
	
}
