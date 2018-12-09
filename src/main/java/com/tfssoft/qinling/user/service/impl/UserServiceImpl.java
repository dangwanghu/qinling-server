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
		instance.setOpenId(null);
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
			instance.setOpenType(dbUser.getOpenType());
			userRepository.updateUser(instance);
		} else {
			// add user
			instance.setOpenId(user.getOpenId());
			instance.setOpenType(user.getOpenType());
			instance.setUserPlatform("APP");
			userRepository.addUser(instance);
			User newUser = userRepository.queryByOpenIdAndType(user.getOpenId(), user.getOpenType());
			instance.setId(newUser.getId());
			instance.setOpenId(null);
			// set token
		}
		return instance;
	}
	

	@Override
	public User phoneUserLogin(String phone) {
		// if not exits phone then create user
		User user = userRepository.queryByPhone(phone);
		if (null == user) {
			user = new User();
			user.setPhone(phone);
			user.setUserPlatform("APP");
			userRepository.addUser(user);
			
			user = userRepository.queryByPhone(phone);
		}
		user.setOpenId(null);
		return user;
	}

	@Override
	public String bindingPhone(Integer userId, String phone) {
		// if exits phone then error
		User user = userRepository.queryByPhone(phone);
		if (null != user) {
			return "手机号已占用";
		}
		
		// binding phone
		user = new User();
		user.setId(userId);
		user.setPhone(phone);
		userRepository.updateUser(user);
		return null;
	}

	@Override
	public void resetPassword(String phone, String password) throws Exception {
		
		User user = userRepository.queryByPhone(phone);
		if (null == user) {
			throw new Exception();
		}
		
		user.setPassword(password);
		userRepository.updateUser(user);
	}

	@Override
	public User bindingThirdParty(Integer userId, String openId, String openType) throws Exception {
		User dbUser = userRepository.queryById(userId.intValue());
		
		User instance = new User();
		instance.setId(dbUser.getId());
		if (null != dbUser.getOpenType()) {
			if (dbUser.getOpenType().indexOf(openType) != -1) {
				throw new Exception();
			} else {
				instance.setOpenId(dbUser.getOpenId() + "," + openId);
				instance.setOpenType(dbUser.getOpenType() + "," + openType);
			}
		} else {
			instance.setOpenId(openId);
			instance.setOpenType(openType);
		}
		userRepository.updateUser(instance);
		User newUser = userRepository.queryById(userId.intValue());
		newUser.setOpenId(null);
		return newUser;
	}
}