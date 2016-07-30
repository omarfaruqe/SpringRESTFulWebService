package com.mc.messenger.service;

import java.util.*;

import com.mc.messenger.database.DatabaseClass;
import com.mc.messenger.exception.DataNotFoundException;
import com.mc.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messagesDatabase = DatabaseClass.getMessages();

	public MessageService() {
		messagesDatabase.put(1L, new Message(1L, "Montreal", "Omar"));
		messagesDatabase.put(2L, new Message(2L, "College", "Faruqe"));
		messagesDatabase.put(3L, new Message(3L, "Technology", "Omar"));
		messagesDatabase.put(4L, new Message(4L, "Engineering", "Faruqe"));
	}

	// Retrieving all messages
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messagesDatabase.values());
	}

	// Retrieving all messages in a specific year
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messagesDatabase.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}

	// Retrieving all messages in paginated
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messagesDatabase.values());
		if (start + size > list.size())
			return new ArrayList<Message>();
		return list.subList(start, start + size);
	}

	// Retrieving specific message by its id
	public Message getMessage(long id) {
		Message message = messagesDatabase.get(id);
		if(message == null){
			throw new DataNotFoundException("Message with id "+id+" not found");
		}
		return message;
	}

	public Message addMessage(Message message) {
		message.setId(messagesDatabase.size() + 1);
		messagesDatabase.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messagesDatabase.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long id) {
		return messagesDatabase.remove(id);
	}
}
