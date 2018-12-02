package com.tfssoft.qinling.user.repository.impl;

import org.springframework.stereotype.Repository;

import com.tfssoft.qinling.base.repository.impl.AbstractRepository;
import com.tfssoft.qinling.user.domain.User;
import com.tfssoft.qinling.user.domain.UserSql;
import com.tfssoft.qinling.user.repository.UserRepository;

@Repository
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

	@Override
	public User queryByPhoneAndPassword(String phone, String password) {
		return this.findOne(UserSql.getUserLoginSql(phone, password));
	}

	@Override
	public User queryByOpenIdAndType(String openId, String openType) {
		return this.findOne(UserSql.getUserThirdPartyLoginSql(openId, openType));

	}

	@Override
	public void updateUser(User user) {
		this.update(UserSql.getUpdateUserSql(user));
	}

	@Override
	public void addUser(User user) {
		this.insert(UserSql.INSRT_USER, UserSql.getInsertObject(user));
	}

	@Override
	public User queryByPhone(String phone) {
		return this.findOne(UserSql.getUserByPhoneSql(phone));
	}

}
