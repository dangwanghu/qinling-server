package com.tfssoft.qinling.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.user.domain.User;
import com.tfssoft.qinling.user.domain.UserThirdPartyVO;
import com.tfssoft.qinling.user.repository.UserRepository;
import com.tfssoft.qinling.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User userLogin(String phone, String password) {
		User instance = userRepository.queryByPhoneAndPassword(phone, password);
		if (null != instance) {
			// set token
			instance.setToken(null);
			userRepository.updateUser(instance);
		}
		return instance;
	}

	@Override
	public User userThirdPartyLogin(UserThirdPartyVO user) {
		User dbUser = userRepository.queryByOpenIdAndType(user.getOpenId(), user.getOpenType());
		
		User instance = new User();
		instance.setAvatar(user.getAvatar());
		instance.setNickName(user.getNickName());
		instance.setSex(user.getSex());
		// set token
		instance.setToken(null);

		if (null != dbUser) {
			// update user
			instance.setId(dbUser.getId());
			userRepository.updateUser(instance);
		} else {
			// add user
			instance.setOpenId(user.getOpenId());
			instance.setOpenType(user.getOpenType());
			instance.setUserPlatform("APP");
			userRepository.addUser(instance);
			// set token
		}
		return instance;
	}

}