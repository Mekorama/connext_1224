package com.connext.service.impl;

import javax.annotation.Resource;

import com.connext.mapper.LoginTestMapper;
import com.connext.pojo.LoginTest;
import com.connext.service.LoginTestService;

public class LoginTestServiceImpl implements LoginTestService{

	@Resource
	private LoginTestMapper loginTestMapper;
	
	@Override
	public void loginTime(LoginTest logintest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countLogin(String phone) {
		// TODO Auto-generated method stub
		return this.loginTestMapper.countLogin(phone);
	}

}
