package com.dao;

import com.entity.UserInfo;

public interface UserDao {
	UserInfo findOneById(int id);
}
