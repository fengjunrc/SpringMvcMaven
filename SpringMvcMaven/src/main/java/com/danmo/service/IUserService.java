package com.danmo.service;

import com.danmo.model.User;
import com.danmo.utils.PageResult;

public interface IUserService {

	PageResult<User> queryByPage(String userName,Integer pageNo,Integer pageSize);  
}
