package com.tfssoft.qinling.user.service;

import java.util.List;

import com.tfssoft.qinling.user.domain.Manager;
import com.tfssoft.qinling.user.domain.ManagerPostVO;
import com.tfssoft.qinling.user.domain.Role;
import com.tfssoft.qinling.user.domain.RolePostVO;
import com.tfssoft.qinling.user.domain.TopicCollectVO;
import com.tfssoft.qinling.user.domain.User;
import com.tfssoft.qinling.user.domain.UserActionPostVO;
import com.tfssoft.qinling.user.domain.UserThirdPartyVO;

public interface UserService {
	
	public User userLogin(String phone, String password);

	public User userThirdPartyLogin(UserThirdPartyVO user);
	
	public User phoneUserLogin(String phone);

	public String bindingPhone(Integer userId, String phone);

	public void resetPassword(String phone, String password) throws Exception;

	public User bindingThirdParty(Integer userId, String openId, String openType) throws Exception;

	public List<TopicCollectVO> getUserCollectList(String userId);

	public String addUserCollect(UserActionPostVO action);

	public void deleteUserCollect(List<UserActionPostVO> actions);

	public String updatePassword(String userId, String oldPassword, String password);

	public List<Manager> getManagerList(Integer skip, Integer limit, String name);

	public long getManagerCount(String name);

	public void addManager(ManagerPostVO instance);

	public void updateManager(ManagerPostVO instance);

	public void deleteManager(int id);

	public List<Role> getRoleList(Integer skip, Integer limit, String name);

	public long getRoleCount(String name);

	public void addRole(RolePostVO instance);

	public void updateRole(RolePostVO instance);

	public void deleteRole(int id);

	public Manager managerLogin(String email, String password);

	public List<User> getUserList(Integer skip, Integer limit, String name);

	public long getUserCount(String name);

	public void updateUserStatus(int id, String status);

}
