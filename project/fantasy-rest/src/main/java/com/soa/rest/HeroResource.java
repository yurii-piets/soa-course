package com.soa.rest;

import com.soa.service.DataAccessService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/heroes")
public class HeroResource {

    @EJB
    private DataAccessService dataService;

    @GET
    @Path("/dragons")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dragons() {
        return Response.ok(dataService.findAllDragons()).build();
    }

    @GET
    @Path("/elfs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response elfs() {
        return Response.ok(dataService.findAllElfs()).build();
    }

    @GET
    @Path("/mags")
    @Produces(MediaType.APPLICATION_JSON)
    public Response mags() {
        return Response.ok(dataService.findAllMags()).build();
    }

    @GET
    @Path("/dragons/{dragonId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dragonById(@PathParam("dragonId") Long dragonId) {
        return Response.ok(dataService.findDragonById(dragonId)).build();
    }

    @GET
    @Path("/elfs/{elfId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response elfById(@PathParam("elfId") Long elfId) {
        return Response.ok(dataService.findElfById(elfId)).build();
    }

    @GET
    @Path("/mags/{magId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response magById(@PathParam("magId") Long magId) {
        return Response.ok(dataService.findMagById(magId)).build();
    }
}
