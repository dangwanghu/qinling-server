package com.tfssoft.qinling.user.repository;

import java.util.List;

import com.tfssoft.qinling.user.domain.User;

public interface UserRepository {

	public User queryByPhoneAndPassword(String phone, String password);

	public User queryByOpenIdAndType(String openId, String openType);

	public void updateUser(User user);

	public void addUser(User user);
	
	public User queryByPhone(String phone);

	public User queryById(int id);

	public List<User> getUserPageList(String name, int skip, int limit);

	public List<User> getUserList(String name);

	public long getUserCount(String name);

	public void updateUserStatus(int id, String status);
}
