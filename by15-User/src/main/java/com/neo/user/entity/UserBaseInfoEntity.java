package com.neo.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * @author By15
 * @date 2021/9/14 14:50
 */
@Data
@TableName("user_base_info_t")
public class UserBaseInfoEntity {
	@TableId(value = "id", type = IdType.UUID)
	@ApiModelProperty("主键id")
	private String id;

	@TableField(value = "user_name")
	@ApiModelProperty("用户名称")
	private String userName;

	@TableField(value = "user_id")
	@ApiModelProperty("用户ID")
	private Long userId;

	@TableField(value = "age")
	@ApiModelProperty("年龄")
	private Integer age;

	@TableField(value = "tel_Phone")
	@ApiModelProperty("手机号")
	private String telPhone;

	@TableField(value = "address")
	@ApiModelProperty("用户地址")
	private String address;

	@TableField(value = "sex")
	@ApiModelProperty("性别")
	private String sex;

	@TableField(value = "create_Time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("创建时间")
	private Date createTime;

	@TableField(value = "update_Time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("修改时间")
	private Date updateTime;

	@TableField(value = "is_Delete")
	@ApiModelProperty("是否删除")
	private String isDelete;
}
