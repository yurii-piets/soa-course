package com.soa.rest;

import com.soa.domain.hero.Dragon;
import com.soa.domain.hero.Elf;
import com.soa.domain.hero.Mag;
import com.soa.request.WSDragonRequest;
import com.soa.request.WSElfRequest;
import com.soa.request.WSMagRequest;
import com.soa.service.DataAccessService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/heroes")
public class HeroResource {

    @EJB
    private DataAccessService dataService;

    @GET
    @Path("/dragons")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dragons() {
        List<Dragon> allDragons = dataService.findAllDragons();
        List<WSDragonRequest> wsDragons = allDragons.stream()
                .map(WSDragonRequest::new)
                .collect(Collectors.toList());
        return Response.ok(wsDragons).build();
    }

    @GET
    @Path("/elfs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response elfs() {
        List<Elf> allElfs = dataService.findAllElfs();
        List<WSElfRequest> wsElfs = allElfs.stream()
                .map(WSElfRequest::new)
                .collect(Collectors.toList());
        return Response.ok(wsElfs).build();
    }

    @GET
    @Path("/mags")
    @Produces(MediaType.APPLICATION_JSON)
    public Response mags() {
        List<Mag> mags = dataService.findAllMags();
        List<WSMagRequest> wsMags = mags.stream()
                .map(WSMagRequest::new)
                .collect(Collectors.toList());
        return Response.ok(wsMags).build();
    }

    @GET
    @Path("/dragons/{dragonId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dragonById(@PathParam("dragonId") Long dragonId) {
        Dragon dragonById = dataService.findDragonById(dragonId);
        if (dragonById == null) {
            return Response.status(404).build();
        }
        return Response.ok(new WSDragonRequest(dragonById)).build();
    }

    @GET
    @Path("/elfs/{elfId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response elfById(@PathParam("elfId") Long elfId) {
        Elf elfById = dataService.findElfById(elfId);
        if (elfById == null) {
            return Response.status(404).build();
        }
        return Response.ok(new WSElfRequest(elfById)).build();
    }

    @GET
    @Path("/mags/{magId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response magById(@PathParam("magId") Long magId) {
        Mag magById = dataService.findMagById(magId);
        if (magById == null) {
            return Response.status(404).build();
        }
        return Response.ok(new WSMagRequest(magById)).build();
    }

    @POST
    @Path("/dragons")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dragons(WSDragonRequest dragonRequest) {
        Dragon dragon = dragonRequest.toDragon();
        dragon.setCave(dataService.findCaveById(dragonRequest.getCaveId()));
        dataService.save(dragon);
        return Response.accepted().build();
    }

    @POST
    @Path("/elfs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response elfs(WSElfRequest elfRequest) {
        Elf elf = elfRequest.toElf();
        elf.setForest(dataService.findForestById(elfRequest.getForestId()));
        dataService.save(elf);
        return Response.accepted().build();
    }

    @POST
    @Path("/mags")
    @Produces(MediaType.APPLICATION_JSON)
    public Response mags(WSMagRequest magRequest) {
        Mag mag = magRequest.toMag();
        mag.setTower(dataService.findTowerById(magRequest.getTowerId()));
        dataService.save(mag);
        return Response.accepted().build();
    }

}
