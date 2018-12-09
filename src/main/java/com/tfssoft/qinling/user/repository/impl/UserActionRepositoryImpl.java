package com.tfssoft.qinling.user.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.user.domain.UserAction;
import com.tfssoft.qinling.user.domain.UserActionPostVO;
import com.tfssoft.qinling.user.domain.UserSql;
import com.tfssoft.qinling.user.repository.UserActionRepository;

@Repository
public class UserActionRepositoryImpl extends AbstractRepository<UserAction> implements UserActionRepository {

	@Override
	public List<UserAction> getUserCollectList(String userId) {
		return this.findAll(UserSql.getUserCollectListSql(userId));
	}

	@Override
	public void addUserCollect(UserActionPostVO action) {
		this.insert(UserSql.INSERT_USER_ACTION, UserSql.getUserActionInsertObject(action));
	}

	@Override
	public void deleteUserCollect(String ids) {
		String[] temps = ids.split(",");
		String ins = "";
		for (int i = 0; i < temps.length; i++) {
			if (i != 0) {
				ins += "," + temps[i];
			} else {
				ins += temps[i];
			}
		}
		this.update(UserSql.getDeleteUserActionSql(ins));
	}

}
