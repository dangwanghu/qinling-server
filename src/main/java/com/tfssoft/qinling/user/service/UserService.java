package com.tfssoft.qinling.user.service;

import java.util.List;

import com.tfssoft.qinling.user.domain.User;
import com.tfssoft.qinling.user.domain.UserAction;
import com.tfssoft.qinling.user.domain.UserActionPostVO;
import com.tfssoft.qinling.user.domain.UserThirdPartyVO;

public interface UserService {
	
	public User userLogin(String phone, String password);

	public User userThirdPartyLogin(UserThirdPartyVO user);
	
	public User phoneUserLogin(String phone);

	public String bindingPhone(Integer userId, String phone);

	public void resetPassword(String phone, String password) throws Exception;

	public User bindingThirdParty(Integer userId, String openId, String openType) throws Exception;

	public List<UserAction> getUserCollectList(String userId);

	public void addUserCollect(UserActionPostVO action);

	public void deleteUserCollect(String ids);

}
