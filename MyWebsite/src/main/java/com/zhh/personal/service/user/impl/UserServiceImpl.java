package com.zhh.personal.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhh.personal.dao.user.UserMapper;
import com.zhh.personal.entity.user.User;
import com.zhh.personal.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public User getUser() {
		return userMapper.queryUser().get(0);
	}

}
