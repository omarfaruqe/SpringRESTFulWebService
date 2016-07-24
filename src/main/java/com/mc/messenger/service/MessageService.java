package com.mc.messenger.service;

import java.util.*;

import com.mc.messenger.model.Message;

public class MessageService {

	public List<Message>getAllMessages(){
		Message m1 = new Message(1L,"Hello World", "Omar");
		Message m2 = new Message(2L,"Hi World", "Faruqe");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
	}
}
