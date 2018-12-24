package com.connext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.connext.pojo.LoginTest;
import com.connext.service.LoginTestService;

@Controller
@RequestMapping("/logintest")
public class LoginTestController {
	
	private LoginTestService loginTestService;
	
	@RequestMapping("/test")
	public String logintime(LoginTest logintest) {
		loginTestService.loginTime(logintest);
		return "login";
	}
	
	@RequestMapping("/countlogin")
	public boolean countlogin(String phone) {
		if (loginTestService.countLogin(phone)<=3) {
			return true;
		}else {
			return false;
		} 
	}
}
