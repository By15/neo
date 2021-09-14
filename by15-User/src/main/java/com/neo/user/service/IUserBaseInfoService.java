package com.neo.user.service;

import com.neo.user.entity.UserBaseInfoEntity;

import java.util.List;

/**
 * @author By15
 * @date 2021/9/14 14:14
 */
public interface IUserBaseInfoService {

	/**
	 * 保存用户信息
	 * @param users users
	 */
	void saveUsers(List<UserBaseInfoEntity> users);
}
