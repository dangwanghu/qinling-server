package com.tfssoft.qinling.user.service;

import com.tfssoft.qinling.user.domain.User;
import com.tfssoft.qinling.user.domain.UserThirdPartyVO;

public interface UserService {
	
	public User userLogin(String phone, String password);

	public User userThirdPartyLogin(UserThirdPartyVO user);
	
	public User phoneUserLogin(String phone);

	public String bindingPhone(Integer userId, String phone);

	public void resetPassword(Integer userId, String password);

}
