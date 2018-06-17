package com.soa.rest;

import com.soa.domain.categories.Cave;
import com.soa.domain.categories.Forest;
import com.soa.domain.categories.Tower;
import com.soa.request.WSCaveRequest;
import com.soa.request.WSForestRequest;
import com.soa.request.WSTowerRequest;
import com.soa.service.DataAccessService;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/categories")
public class CategoriesResources {

    @EJB
    private DataAccessService dataService;

    @GET
    @Path("/caves")
    @Produces(MediaType.APPLICATION_JSON)
    public Response caves() {
        List<Cave> allCaves = dataService.findAllCaves();
        List<WSCaveRequest> wsCave = allCaves.stream()
                .map(WSCaveRequest::new)
                .collect(Collectors.toList());
        return Response.ok(wsCave).build();
    }

    @GET
    @Path("/forests")
    @Produces(MediaType.APPLICATION_JSON)
    public Response forests() {
        List<Forest> forests = dataService.findAllForests();
        List<WSForestRequest> wsForests = forests.stream()
                .map(WSForestRequest::new)
                .collect(Collectors.toList());
        return Response.ok(wsForests).build();
    }

    @GET
    @Path("/towers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response towers() {
        List<Tower> towers = dataService.findAllTowers();
        List<WSTowerRequest> wsTowers = towers.stream()
                .map(WSTowerRequest::new)
                .collect(Collectors.toList());
        return Response.ok(wsTowers).build();
    }

    @GET
    @Path("/caves/{caveId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cavesById(@PathParam("caveId") Long caveId) {
        Cave caveById = dataService.findCaveById(caveId);
        return Response.ok(new WSCaveRequest(caveById)).build();
    }

    @GET
    @Path("/forests/{forestId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response forestById(@PathParam("forestId") Long forestId) {
        Forest forestById = dataService.findForestById(forestId);
        return Response.ok(new WSForestRequest(forestById)).build();
    }

    @GET
    @Path("/towers/{towerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response towerById(@PathParam("towerId") Long towerId) {
        Tower towerById = dataService.findTowerById(towerId);
        return Response.ok(new WSTowerRequest(towerById)).build();
    }

    @POST
    @Path("/caves")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response caves(WSCaveRequest wsCave) {
        dataService.save(wsCave.toCave());
        return Response.accepted().build();
    }

    @POST
    @Path("/forests")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response forests(WSForestRequest wsForest) {
        dataService.save(wsForest.toForest());
        return Response.accepted().build();
    }

    @POST
    @Path("/towers")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response towers(WSTowerRequest wsTower) {
        dataService.save(wsTower.toTower());
        return Response.accepted().build();
    }
}
