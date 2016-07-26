package com.mc.messenger.resources;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.mc.messenger.model.Message;
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
	
	// Retrieving all data in JSON format (accepting parameter)
	@GET
	public List<Message> getMessagesJSON(@QueryParam("year") int year,
										@QueryParam("start") int start,
										@QueryParam("size") int size) {
		if(year>0){
			return messageService.getAllMessagesForYear(year);
		}
		if(start >= 0 && size >= 0){
			return messageService.getAllMessagesPaginated(start, size);
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
