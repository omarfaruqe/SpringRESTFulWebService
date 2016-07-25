package com.mc.messenger.resources;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.mc.messenger.model.Message;
import com.mc.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getMessages(){
//		return "Hello World!";
//	}
	
	MessageService messageService = new MessageService();
	

	
	//Retrieving all data in JSON format
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessagesJSON(){
		return messageService.getAllMessages();
	}

	
	//Retrieving data by messageId in JSON format
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessageByIdJSON(@PathParam("messageId") long messageId){
		return  messageService.getMessage(messageId);
	}
		
	//Insert or add test (Need to specify body as message and content type)
	@POST
//	@Path("/addMessage")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessageJSON(Message message){
		return messageService.addMessage(message);
	}
	
	//Update message using messageId in JSON format
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessageJSON(@PathParam("messageId") long messageId, Message message){
		//message.setId(messageId);
		return messageService.addMessage(message);
	}
		
	//Delete message by messageId in JSON format
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessageJSON(@PathParam("messageId") long messageId){
		return messageService.removeMessage(messageId);
	}
	
	
	//****************** XML Format **************************************//
//	
//	//Retrieving all data in XML format
//	@GET
//	@Path("/allMessageXML")
//	@Produces(MediaType.APPLICATION_XML)
//	public List<Message> getMessagesXML(){
//		return messageService.getAllMessages();
//	}
//	
//	//Retrieving data by messageId in XML format
//	@GET
//	@Path("/xml/{messageId}")
//	@Produces(MediaType.APPLICATION_XML)
//	public Message getMessageByIdXML(@PathParam("messageId") long messageId){
//		return  messageService.getMessage(messageId);
//	}
//	
//	
//	//Update message using messageId in XML format
//	@PUT
//	@Path("/updateMessageXML/{messageId}")
//	@Consumes(MediaType.APPLICATION_XML)
//	@Produces(MediaType.APPLICATION_XML)
//	public Message updateMessageXML(@PathParam("messageId") long messageId, Message message){
//		message.setId(messageId);
//		return messageService.addMessage(message);
//	}
//	
//	//Delete message by messageId in XML format
//	@DELETE
//	@Path("deleteMessageXML/{messageId}")
//	@Produces(MediaType.APPLICATION_XML)
//	public Message deleteMessageXML(@PathParam("messageId") long messageId){
//		return messageService.removeMessage(messageId);
//	}
	
	
}
