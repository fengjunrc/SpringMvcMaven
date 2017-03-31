package com.danmo.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.danmo.base.BaseMapper;
import com.danmo.base.BaseService;
import com.danmo.controller.UserController;
import com.danmo.dao.UserMapper;
import com.danmo.model.User;
import com.danmo.utils.BeanUtil;
import com.danmo.utils.PageResult;
import com.github.pagehelper.PageHelper;

@Service
public  class UserService extends BaseService<User>{
	private final static Logger log= Logger.getLogger(UserService.class);
	@Resource
	private UserMapper userMapper;

	@Override
	public BaseMapper<User> baseMapper() {
		return userMapper;
	}

	
	public PageResult<User> queryByPage(String userName,Integer pageNo,Integer pageSize ) {  
	    pageNo = pageNo == null?1:pageNo;  
	    pageSize = pageSize == null?10:pageSize;  
	    PageHelper.startPage(pageNo,pageSize);  //startPage
	    List<User> list = userMapper.selectUserByUserName(userName);
	    return BeanUtil.toPageResult(list);  
	} 

	
	 @Transactional(propagation=Propagation.REQUIRED)
	public void addUser(User user) {
		userMapper.addUser(user);
	   /* String string  = null;
	    if(string.equals("")) {
	        int i = 0;
	    }*/
	}
	
	
	
}
