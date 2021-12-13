package com.neo.user.service.impl;

import com.neo.user.entity.UserBaseInfoEntity;
import com.neo.user.mapper.UserBaseInfoMapper;
import com.neo.user.service.IUserBaseInfoService;
import com.neo.user.util.CommonUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author By15
 * @date 2021/9/14 14:24
 */
@Slf4j
@Service
public class UserBaseInfoServiceImpl implements IUserBaseInfoService {

	@Autowired
	private UserBaseInfoMapper userBaseInfoMapper;
	/**
	 * 保存用户信息
	 * @param users users
	 */
	@Override
	public void saveUsers(List<UserBaseInfoEntity> users) {
		users.forEach(item -> {item.setUserId(CommonUtil.getUUID());
		item.setId(CommonUtil.getUUIDBits(16));});
		userBaseInfoMapper.insertBatch(users);
	}

	/**
	 * 查询用户信息
	 *
	 * @param users users
	 */
	@Override
	public List<UserBaseInfoEntity> queryUserInfo(UserBaseInfoEntity users) {
		return userBaseInfoMapper.selectList(new QueryWrapper<>());
	}
}
