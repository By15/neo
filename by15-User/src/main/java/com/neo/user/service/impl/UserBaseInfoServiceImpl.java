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
		QueryWrapper<UserBaseInfoEntity> wrapper = new QueryWrapper<>();
		userBaseInfoMapper.selectList(wrapper);
		users.forEach(item -> {item.setUserId(CommonUtil.getUUID());
		item.setId(CommonUtil.getUUIDBits(16));});
		//QueryWrapper<UserBaseInfoEntity> queryWrapper = new QueryWrapper();
		userBaseInfoMapper.insertBatch(users);
	}
}
