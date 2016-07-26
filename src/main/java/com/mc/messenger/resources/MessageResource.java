package com.mc.messenger.resources;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.mc.messenger.model.Message;
import com.mc.messenger.resources.beans.MessageFilterBean;
import com.mc.messenger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();

//	// Retrieving all data in JSON format
//	@GET
//	public List<Message> getMessagesJSON() {
//		return messageService.getAllMessages();
//	}
	
	// Retrieving all data in JSON format (accepting parameter using BeanParam)
	@GET
	public List<Message> getMessagesJSON(@BeanParam MessageFilterBean filterBean) {
		if(filterBean.getYear()>0){
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if(filterBean.getStart() >= 0 && filterBean.getSize() >= 0){
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		else{
			return messageService.getAllMessages();
		}		
	}
	

	// Retrieving data by messageId in JSON format
	@GET
	@Path("/{messageId}")
	public Message getMessageByIdJSON(@PathParam("messageId") long messageId) {
		return messageService.getMessage(messageId);
	}

	// Insert or add test (Need to specify body as message and content type)
	@POST
	public Message addMessageJSON(Message message) {
		return messageService.addMessage(message);
	}

	// Update message using messageId in JSON format
	@PUT
	@Path("/{messageId}")
	public Message updateMessageJSON(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return messageService.addMessage(message);
	}

	// Delete message by messageId in JSON format
	@DELETE
	@Path("/{messageId}")
	public Message deleteMessageJSON(@PathParam("messageId") long messageId) {
		return messageService.removeMessage(messageId);
	}
}
