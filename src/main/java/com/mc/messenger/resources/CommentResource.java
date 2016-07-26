package com.mc.messenger.resources;

import javax.ws.rs.*;

@Path("/")
public class CommentResource {
	
	@GET
	public String test(){
		return "GET new Sub Resource";
	}
	
	@PUT
	public String test1(){
		return "PUT new Sub Resource";
	}
	
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("commentId") long commentId, @PathParam("messageId") long messageId){
		return "GET new Sub Resource with ID: "+commentId+" For message ID: "+ messageId;
	}
}
