package com.neo.user.service.impl;

import com.neo.user.entity.UserBaseInfoEntity;
import com.neo.user.mapper.UserBaseInfoMapper;
import com.neo.user.service.IUserBaseInfoService;
import com.neo.user.util.CommonUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author By15
 * @date 2021/9/14 14:24
 */
public class UserBaseInfoServiceImpl implements IUserBaseInfoService {

	@Autowired
	private UserBaseInfoMapper userBaseInfoMapper;
	/**
	 * 保存用户信息
	 * @param users users
	 */
	@Override
	public void saveUsers(List<UserBaseInfoEntity> users) {
		users.forEach(item -> item.setUserId(CommonUtil.getUUID()));
		QueryWrapper<UserBaseInfoEntity> queryWrapper = new QueryWrapper();
	}
}
