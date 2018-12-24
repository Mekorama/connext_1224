package com.connext.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.connext.mapper.MessageMapper;
import com.connext.pojo.Message;
import com.connext.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService {
	@Resource
	private MessageMapper messagemapper;

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.messagemapper.delete(id);
	}

	@Override
	public ArrayList<Message> queryAll() {
		// TODO Auto-generated method stub
		return this.messagemapper.queryAll();
	}

	@Override
	public Message queryById(Integer id) {
		// TODO Auto-generated method stub
		return this.messagemapper.queryById(id);
	}

	@Override
	public void updateById(Message message) {
		// TODO Auto-generated method stub
		this.messagemapper.updateById(message);
	}
}
