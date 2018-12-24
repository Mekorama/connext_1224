package com.connext.mapper;

import com.connext.pojo.LoginTest;

public interface LoginTestMapper {
	public void loginTime(LoginTest logintest);
	
	public int countLogin(String phone);
}
