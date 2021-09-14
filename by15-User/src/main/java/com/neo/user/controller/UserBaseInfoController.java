package com.neo.user.controller;

import com.neo.user.entity.UserBaseInfoEntity;
import com.neo.user.service.IUserBaseInfoService;
import com.neo.user.util.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import java.util.List;

/**
 * @author By15
 * @since 2021/9/13 17:10
 */
@RestController
@RequestMapping("userBase")
@Api("用户基本信息")
public class UserBaseInfoController {
	@Autowired
	public IUserBaseInfoService userBaseInfoService;

	@PostMapping("saveUsers")
	@ApiOperation("保存用户信息")
	public Response saveUsers(@RequestBody List<UserBaseInfoEntity> users){
		userBaseInfoService.saveUsers(users);
		return Response.sucess(null);
	}
}
