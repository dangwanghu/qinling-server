package com.tfssoft.qinling.user.service;

import com.tfssoft.qinling.user.domain.User;
import com.tfssoft.qinling.user.domain.UserThirdPartyVO;

public interface UserService {
	
	public User userLogin(String phone, String password);

	public User userThirdPartyLogin(UserThirdPartyVO user);

}
