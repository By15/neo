package com.neo.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neo.user.entity.UserBaseInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author By15
 * @date 2021/9/14 16:10
 */
@Repository
@Mapper
public interface UserBaseInfoMapper extends BaseMapper<UserBaseInfoEntity> {
	void insertBatch(@Param("users") List<UserBaseInfoEntity> users);
}
