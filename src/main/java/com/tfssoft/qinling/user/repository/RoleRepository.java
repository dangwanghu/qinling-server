package com.tfssoft.qinling.user.repository;

import java.util.List;

import com.tfssoft.qinling.user.domain.Role;
import com.tfssoft.qinling.user.domain.RolePostVO;

public interface RoleRepository {

	public List<Role> getRolePageList(String name, int skip, int limit);

	public List<Role> getRoleList(String name);

	public long getRoleCount(String name);

	public void addRole(RolePostVO instance);

	public void updateRole(RolePostVO instance);

	public void deleteRole(int id);

}
