package com.connext.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.connext.pojo.User;

@Service
public interface UserService {

	public User login(Map<String, String> map);
	
	public void register(User user);
	
	public int checkRegister(@Param("phone") String phone);

}