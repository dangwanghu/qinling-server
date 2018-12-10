package com.tfssoft.qinling.user.repository;

import java.util.List;

import com.tfssoft.qinling.user.domain.UserAction;
import com.tfssoft.qinling.user.domain.UserActionPostVO;

public interface UserActionRepository {

	public List<UserAction> getUserCollectList(String userId, String relId, String relType);

	public void addUserCollect(UserActionPostVO action);

	public void deleteUserCollect(String ids);	
}
