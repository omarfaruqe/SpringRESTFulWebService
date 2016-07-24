package com.mc.messenger.resources;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.mc.messenger.model.Message;
import com.mc.messenger.service.MessageService;

@Path("messages")
public class MessageResource {
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getMessages(){
//		return "Hello World!";
//	}
	
	MessageService messageService = new MessageService();
	
	@GET
	@Path("/allMessageXML")
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessagesXML(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/allMessageJSON")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessagesJSON(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/xml/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessageByIdXML(@PathParam("messageId") long messageId){
		return  messageService.getMessage(messageId);
	}
	
	@GET
	@Path("/json/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessageByIdJSON(@PathParam("messageId") long messageId){
		return  messageService.getMessage(messageId);
	}
}
