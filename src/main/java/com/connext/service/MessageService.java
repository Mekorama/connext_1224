package com.connext.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.connext.pojo.Message;

@Service
public interface MessageService {
	public void delete(Integer id);
	public ArrayList<Message> queryAll();
	public Message queryById(Integer id);
	public void updateById(Message message);

}
