package com.mc.messenger.service;

import java.util.*;

import com.mc.messenger.database.DatabaseClass;
import com.mc.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messagesDatabase = DatabaseClass.getMessages();
	
	public MessageService(){
		messagesDatabase.put(1L, new Message(1L, "Montreal", "Omar"));
		messagesDatabase.put(2L, new Message(2L, "College", "Faruqe"));
		messagesDatabase.put(3L, new Message(3L, "Technology", "Omar"));
	}
	
	//Retrieving all messages
	public List<Message>getAllMessages(){
		return new ArrayList<Message>(messagesDatabase.values());
	}
	
	// Retrieving specific message by its id
	public Message getMessage(long id){
		return messagesDatabase.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messagesDatabase.size()+1);
		messagesDatabase.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messagesDatabase.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messagesDatabase.remove(id);
	}	
}
