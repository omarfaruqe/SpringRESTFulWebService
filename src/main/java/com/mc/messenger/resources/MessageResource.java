package com.mc.messenger.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("messages")
public class MessageResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages(){
		return "Hello World!";
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public String getMessagesJSON(){
//		return "Hello World!";
//	}
}
