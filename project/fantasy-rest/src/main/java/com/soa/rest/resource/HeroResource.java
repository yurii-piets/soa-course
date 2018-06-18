package com.soa.rest.resource;

import com.soa.domain.UserData;
import com.soa.domain.hero.Dragon;
import com.soa.domain.hero.Elf;
import com.soa.domain.hero.Mag;
import com.soa.rest.service.TranslateService;
import com.soa.service.DataAccessService;
import com.soa.ws.hero.WSDragon;
import com.soa.ws.hero.WSElf;
import com.soa.ws.hero.WSMag;
import com.soa.ws.hero.response.WSDragonResponse;
import com.soa.ws.hero.response.WSElfResponse;
import com.soa.ws.hero.response.WSMagResponse;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Path("/heroes")
public class HeroResource {

    public static final MediaType PL_APPLICATION_JSON = new MediaType("application", "json-pl");

    @EJB
    private DataAccessService dataService;

    @Inject
    private Principal principal;

    @EJB
    private TranslateService transalateService;

    @GET
    @Path("/dragons")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dragons(@HeaderParam("Content-Type") MediaType mediaType) {
        List<Dragon> allDragons = dataService.findAllDragons();
        if (PL_APPLICATION_JSON.equals(mediaType)) {
            List<WSDragonResponse> wsDragons = allDragons.stream()
                    .map(WSDragonResponse::new)
                    .map(transalateService::translate)
                    .collect(Collectors.toList());
            return Response.ok(wsDragons).build();
        }
        List<WSDragonResponse> wsDragons = allDragons.stream()
                .map(WSDragonResponse::new)
                .collect(Collectors.toList());
        return Response.ok(wsDragons).build();
    }

    @GET
    @Path("/elves")
    @Produces(MediaType.APPLICATION_JSON)
    public Response elves(@HeaderParam("Content-Type") MediaType mediaType) {
        List<Elf> allElves = dataService.findAllElfs();
        if (PL_APPLICATION_JSON.equals(mediaType)) {
            List<WSElfResponse> wsElves = allElves.stream()
                    .map(WSElfResponse::new)
                    .map(transalateService::translate)
                    .collect(Collectors.toList());
            return Response.ok(wsElves).build();
        }
        List<WSElfResponse> wsElves = allElves.stream()
                .map(WSElfResponse::new)
                .collect(Collectors.toList());
        return Response.ok(wsElves).build();
    }

    @GET
    @Path("/mags")
    @Produces(MediaType.APPLICATION_JSON)
    public Response mags(@HeaderParam("Content-Type") MediaType mediaType) {
        List<Mag> mags = dataService.findAllMags();
        if (PL_APPLICATION_JSON.equals(mediaType)) {
            List<WSMagResponse> wsMags = mags.stream()
                    .map(WSMagResponse::new)
                    .map(transalateService::translate)
                    .collect(Collectors.toList());
            return Response.ok(wsMags).build();
        }
        List<WSMagResponse> wsMags = mags.stream()
                .map(WSMagResponse::new)
                .collect(Collectors.toList());
        return Response.ok(wsMags).build();
    }

    @GET
    @Path("/dragons/{dragonId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dragonById(@HeaderParam("Content-Type") MediaType mediaType, @PathParam("dragonId") Long dragonId) {
        Dragon dragonById = dataService.findDragonById(dragonId);
        if (dragonById == null) {
            return Response.status(404).build();
        }
        if (PL_APPLICATION_JSON.equals(mediaType)) {
            return Response.ok(transalateService.translate(new WSDragonResponse(dragonById))).build();
        }
        return Response.ok(new WSDragonResponse(dragonById)).build();
    }

    @GET
    @Path("/elves/{elfId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response elfById(@HeaderParam("Content-Type") MediaType mediaType, @PathParam("elfId") Long elfId) {
        Elf elfById = dataService.findElfById(elfId);
        if (elfById == null) {
            return Response.status(404).build();
        }
        if (PL_APPLICATION_JSON.equals(mediaType)) {
            return Response.ok(transalateService.translate(new WSElfResponse(elfById))).build();
        }
        return Response.ok(new WSElfResponse(elfById)).build();
    }

    @GET
    @Path("/mags/{magId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response magById(@HeaderParam("Content-Type") MediaType mediaType, @PathParam("magId") Long magId) {
        Mag magById = dataService.findMagById(magId);
        if (magById == null) {
            return Response.status(404).build();
        }
        if (PL_APPLICATION_JSON.equals(mediaType)) {
            return Response.ok(transalateService.translate(new WSMagResponse(magById))).build();
        }
        return Response.ok(new WSMagResponse(magById)).build();
    }

    @POST
    @Path("/dragons")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dragons(WSDragon dragonRequest) {
        Dragon dragon = dragonRequest.toDragon();
        dragon.setCave(dataService.findCaveById(dragonRequest.getCaveId()));
        UserData user = dataService.findUserDataByLogin(principal.getName());
        if (user.getRole() != UserData.UserRole.ADMIN) {
            if (!user.getId().equals(dragon.getOwner().getId())) {
                return Response.status(403).build();
            }
        }
        dataService.save(dragon);
        return Response.accepted().build();
    }

    @POST
    @Path("/elves")
    @Produces(MediaType.APPLICATION_JSON)
    public Response elves(WSElf elfRequest) {
        Elf elf = elfRequest.toElf();
        elf.setForest(dataService.findForestById(elfRequest.getForestId()));
        UserData user = dataService.findUserDataByLogin(principal.getName());
        if (user.getRole() != UserData.UserRole.ADMIN) {
            if (!user.getId().equals(elf.getOwner().getId())) {
                return Response.status(403).build();
            }
        }
        dataService.save(elf);
        return Response.accepted().build();
    }

    @POST
    @Path("/mags")
    @Produces(MediaType.APPLICATION_JSON)
    public Response mags(WSMag magRequest) {
        Mag mag = magRequest.toMag();
        mag.setTower(dataService.findTowerById(magRequest.getTowerId()));
        UserData user = dataService.findUserDataByLogin(principal.getName());
        if (user.getRole() != UserData.UserRole.ADMIN) {
            if (!user.getId().equals(mag.getOwner().getId())) {
                return Response.status(403).build();
            }
        }
        dataService.save(mag);
        return Response.accepted().build();
    }

}
