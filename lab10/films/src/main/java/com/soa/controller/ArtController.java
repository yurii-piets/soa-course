package com.soa.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/art")
public class ArtController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response art(){
        return Response.temporaryRedirect(URI.create("/films")).build();
    }
}
