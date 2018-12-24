package com.connext.mapper;

import java.util.ArrayList;

import com.connext.pojo.Message;

public interface MessageMapper {
	public void delete(Integer id);
	public ArrayList<Message> queryAll();
	public Message queryById(Integer id);
	public void updateById(Message message);
}
