package com.danmo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.danmo.base.BaseMapper;
import com.danmo.model.User;

public interface UserMapper  extends BaseMapper<User>{

	List<User> selectUserByUserName(@Param("username") String username);

	void addUser(User user); 
}
