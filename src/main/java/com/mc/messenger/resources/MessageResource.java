package com.mc.messenger.resources;

import java.net.URI;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

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

	// Insert data and return 201 Created status
	@POST
	public Response addMessageJSON(Message message, @Context UriInfo uriInfo) {
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response
				.created(uri)
				.entity(newMessage)
				.build();
	}

	// Update message using messageId in JSON format
	@PUT
	@Path("/{messageId}")
	public Message updateMessageJSON(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}

	// Delete message by messageId in JSON format
	@DELETE
	@Path("/{messageId}")
	public Message deleteMessageJSON(@PathParam("messageId") long messageId) {
		return messageService.removeMessage(messageId);
	}
	
	// Retrieving sub resources
//	@GET
	@Path("/{messageId}/comments")
	public CommentResource test() {
		return new CommentResource();
	}
}
