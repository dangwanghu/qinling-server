package com.tfssoft.qinling.user.repository;

import com.tfssoft.qinling.user.domain.User;

public interface UserRepository {

	public User queryByPhoneAndPassword(String phone, String password);

	public User queryByOpenIdAndType(String openId, String openType);

	public void updateUser(User user);

	public void addUser(User user);
	
	public User queryByPhone(String phone);	
}
