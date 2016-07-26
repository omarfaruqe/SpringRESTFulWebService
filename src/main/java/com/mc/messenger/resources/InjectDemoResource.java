package com.mc.messenger.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotation")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
											@HeaderParam("customHeaderParam") String header,
											@CookieParam("cookieName") String cookie){
		return "Matrix Parameter: "+matrixParam+" and Header value: "+header + " And cookie is: "+cookie;
	}
}
