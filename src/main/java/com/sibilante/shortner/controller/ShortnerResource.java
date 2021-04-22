package com.sibilante.shortner.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import com.sibilante.shortner.service.ShortnerService;

@Path("shorts")
public class ShortnerResource {

	@Context
    UriInfo uriInfo;
	@Autowired
	ShortnerService shortnerService;

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String post(String url) {
		return UriBuilder.fromUri(uriInfo.getAbsolutePath())
				.path("{shortnedUrl}")
				.build(shortnerService.urlShorter(url))
				.toString();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{shortnedUrl}")
	public Response get(@PathParam("shortnedUrl") String shortnedUrl) {
		String result = shortnerService.getOriginalLink(shortnedUrl);
		if (result == null) {
			throw new NotFoundException("URL not found");
		}
		return Response.seeOther(UriBuilder.fromPath(result).build()).build();
	}

}
