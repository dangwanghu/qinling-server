package com.tfssoft.qinling.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfssoft.qinling.user.domain.Manager;
import com.tfssoft.qinling.user.domain.ManagerPostVO;
import com.tfssoft.qinling.user.domain.Role;
import com.tfssoft.qinling.user.domain.RolePostVO;
import com.tfssoft.qinling.user.domain.TopicCollectVO;
import com.tfssoft.qinling.user.domain.User;
import com.tfssoft.qinling.user.domain.UserAction;
import com.tfssoft.qinling.user.domain.UserActionPostVO;
import com.tfssoft.qinling.user.domain.UserThirdPartyVO;
import com.tfssoft.qinling.user.repository.ManagerRepository;
import com.tfssoft.qinling.user.repository.RoleRepository;
import com.tfssoft.qinling.user.repository.UserActionRepository;
import com.tfssoft.qinling.user.repository.UserRepository;
import com.tfssoft.qinling.user.service.UserService;
import com.tfssoft.qinling.util.EncryptionByMD5;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private UserActionRepository userActionRepository;
	
	@Autowired
	private RoleRepository roleRepository;

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

	@Override
	public List<TopicCollectVO> getUserCollectList(String userId) {
		List<UserAction> list = userActionRepository.getUserCollectList(userId, null, null);
		List<TopicCollectVO> result = new ArrayList<TopicCollectVO>();
		for (UserAction action : list) {
			TopicCollectVO instance = new TopicCollectVO();
			instance.setId(action.getRelId());
			instance.setType(action.getRelType());
			instance.setName(action.getRelName());
			instance.setLocationDescription(action.getAddress());
			result.add(instance);
		}
		return result;
	}

	@Override
	public String addUserCollect(UserActionPostVO action) {
		List<UserAction> list = userActionRepository.getUserCollectList(action.getUserId(),
				String.valueOf(action.getRelId()), action.getRelType());

		if (list.size() > 0) {
			return "重复收藏";
		}
		userActionRepository.addUserCollect(action);
		return null;
	}

	@Override
	public void deleteUserCollect(List<UserActionPostVO> actions) {
		List<String> ids = new ArrayList<String>();

		for (UserActionPostVO action : actions) {
			List<UserAction> list = userActionRepository.getUserCollectList(action.getUserId(),
					String.valueOf(action.getRelId()), action.getRelType());

			if (list.size() > 0) {
				ids.add(String.valueOf(list.get(0).getId()));
			}
		}

		userActionRepository.deleteUserCollect(String.join(",", ids));
	}

	@Override
	public String updatePassword(String userId, String oldPassword, String password) {
		// validate old password
		User dbUser = userRepository.queryById(Integer.parseInt(userId));
		if (!new String(EncryptionByMD5.getMD5(oldPassword.getBytes())).equals(dbUser.getPassword())) {
			return "原密码错误";
		}

		// update password
		User user = new User();
		user.setId(Integer.parseInt(userId));
		user.setPassword(password);
		userRepository.updateUser(user);
		return null;
	}

	@Override
	public List<Manager> getManagerList(Integer skip, Integer limit, String name) {
		if (null == skip && null != limit) {
			return managerRepository.getManagerPageList(name, 0, limit.intValue());
		} else if (null != skip && null == limit) {
			return managerRepository.getManagerPageList(name, skip.intValue(), 10);
		} else if (null != skip && null != limit) {
			return managerRepository.getManagerPageList(name, skip.intValue(), limit.intValue());
		} else {
			return managerRepository.getManagerList(name);
		}
	}

	@Override
	public long getManagerCount(String name) {
		return managerRepository.getManagerCount(name);
	}

	@Override
	public void addManager(ManagerPostVO instance) {
		managerRepository.addManager(instance);
	}

	@Override
	public void updateManager(ManagerPostVO instance) {
		managerRepository.updateManager(instance);
	}

	@Override
	public void deleteManager(int id) {
		managerRepository.deleteManager(id);
	}

	@Override
	public List<Role> getRoleList(Integer skip, Integer limit, String name) {
		if (null == skip && null != limit) {
			return roleRepository.getRolePageList(name, 0, limit.intValue());
		} else if (null != skip && null == limit) {
			return roleRepository.getRolePageList(name, skip.intValue(), 10);
		} else if (null != skip && null != limit) {
			return roleRepository.getRolePageList(name, skip.intValue(), limit.intValue());
		} else {
			return roleRepository.getRoleList(name);
		}
	}

	@Override
	public long getRoleCount(String name) {
		return roleRepository.getRoleCount(name);
	}

	@Override
	public void addRole(RolePostVO instance) {
		roleRepository.addRole(instance);
	}

	@Override
	public void updateRole(RolePostVO instance) {
		roleRepository.updateRole(instance);
	}

	@Override
	public void deleteRole(int id) {
		roleRepository.deleteRole(id);
	}

	@Override
	public Manager managerLogin(String email, String password) {
		Manager instance = managerRepository.queryByEmailAndPassword(email, password);
		if (null != instance) {
			// set token
			instance.setToken(null);
			// TODO: update manager
		}
		return instance;
	}

	@Override
	public List<User> getUserList(Integer skip, Integer limit, String name) {
		if (null == skip && null != limit) {
			return userRepository.getUserPageList(name, 0, limit.intValue());
		} else if (null != skip && null == limit) {
			return userRepository.getUserPageList(name, skip.intValue(), 10);
		} else if (null != skip && null != limit) {
			return userRepository.getUserPageList(name, skip.intValue(), limit.intValue());
		} else {
			return userRepository.getUserList(name);
		}
	}

	@Override
	public long getUserCount(String name) {
		return userRepository.getUserCount(name);
	}

	@Override
	public void updateUserStatus(int id, String status) {
		userRepository.updateUserStatus(id, status);
	}
}