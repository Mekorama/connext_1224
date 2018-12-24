package com.connext.service;

import org.springframework.stereotype.Service;

import com.connext.pojo.LoginTest;

@Service
public interface LoginTestService {
	public void loginTime(LoginTest logintest);

	public int countLogin(String phone);
}
