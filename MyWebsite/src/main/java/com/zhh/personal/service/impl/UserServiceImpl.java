package com.zhh.personal.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhh.personal.dao.UserMapper;
import com.zhh.personal.entity.User;
import com.zhh.personal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public User getUser() {
		return userMapper.queryUser().get(0);
	}

}
