package com.soa.rest;

import com.soa.domain.categories.Cave;
import com.soa.domain.categories.Forest;
import com.soa.domain.categories.Tower;
import com.soa.request.WSCave;
import com.soa.request.WSForest;
import com.soa.request.WSTower;
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
        List<WSCave> wsCave = allCaves.stream()
                .map(WSCave::new)
                .collect(Collectors.toList());
        return Response.ok(wsCave).build();
    }

    @GET
    @Path("/forests")
    @Produces(MediaType.APPLICATION_JSON)
    public Response forests() {
        List<Forest> forests = dataService.findAllForests();
        List<WSForest> wsForests = forests.stream()
                .map(WSForest::new)
                .collect(Collectors.toList());
        return Response.ok(wsForests).build();
    }

    @GET
    @Path("/towers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response towers() {
        List<Tower> towers = dataService.findAllTowers();
        List<WSTower> wsTowers = towers.stream()
                .map(WSTower::new)
                .collect(Collectors.toList());
        return Response.ok(wsTowers).build();
    }

    @GET
    @Path("/caves/{caveId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cavesById(@PathParam("caveId") Long caveId) {
        Cave caveById = dataService.findCaveById(caveId);
        return Response.ok(new WSCave(caveById)).build();
    }

    @GET
    @Path("/forests/{forestId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response forestById(@PathParam("forestId") Long forestId) {
        Forest forestById = dataService.findForestById(forestId);
        return Response.ok(new WSForest(forestById)).build();
    }

    @GET
    @Path("/towers/{towerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response towerById(@PathParam("towerId") Long towerId) {
        Tower towerById = dataService.findTowerById(towerId);
        return Response.ok(new WSTower(towerById)).build();
    }

    @POST
    @Path("/caves")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response caves(WSCave wsCave) {
        dataService.save(wsCave.toCave());
        return Response.accepted().build();
    }

    @POST
    @Path("/forests")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response forests(WSForest wsForest) {
        dataService.save(wsForest.toForest());
        return Response.accepted().build();
    }

    @POST
    @Path("/towers")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response towers(WSTower wsTower) {
        dataService.save(wsTower.toTower());
        return Response.accepted().build();
    }
}
