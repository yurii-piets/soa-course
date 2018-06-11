package com.soa.rest;

import com.soa.service.DataAccessService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/categories")
public class CategoriesResources {

    @EJB
    private DataAccessService dataService;

    @GET
    @Path("/caves")
    @Produces(MediaType.APPLICATION_JSON)
    public Response caves(){
        return Response.ok(dataService.findAllCaves()).build();
    }

    @GET
    @Path("/forests")
    @Produces(MediaType.APPLICATION_JSON)
    public Response forests(){
        return Response.ok(dataService.findAllForests()).build();
    }

    @GET
    @Path("/towers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response towers(){
        return Response.ok(dataService.findAllTowers()).build();
    }

    @GET
    @Path("/caves/{caveId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cavesById(@PathParam("caveId") Long caveId){
        return Response.ok(dataService.findCaveById(caveId)).build();
    }

    @GET
    @Path("/forests/{forestId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response forestById(@PathParam("forestId") Long forestId){
        return Response.ok(dataService.findForestById(forestId)).build();
    }

    @GET
    @Path("/towers/{towerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response towerById(@PathParam("towerId") Long towerId){
        return Response.ok(dataService.findTowerById(towerId)).build();
    }
}
