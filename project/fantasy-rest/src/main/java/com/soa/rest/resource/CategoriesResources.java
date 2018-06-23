package com.soa.rest.resource;

import com.soa.domain.UserData;
import com.soa.domain.categories.Cave;
import com.soa.domain.categories.Forest;
import com.soa.domain.categories.Tower;
import com.soa.rest.service.TranslateService;
import com.soa.service.DataAccessService;
import com.soa.ws.category.WSCave;
import com.soa.ws.category.WSForest;
import com.soa.ws.category.WSTower;
import com.soa.ws.category.response.WSCaveResponse;
import com.soa.ws.category.response.WSForestResponse;
import com.soa.ws.category.response.WSTowerResponse;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
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

import static com.soa.rest.resource.HeroResource.PL_APPLICATION_JSON;

@Path("/categories")
public class CategoriesResources {

    @EJB
    private DataAccessService dataService;

    @Inject
    private Principal principal;

    @EJB
    private TranslateService transalateService;

    @GET
    @Path("/caves")
    @Produces(MediaType.APPLICATION_JSON)
    public Response caves(@HeaderParam("Content-Type") MediaType mediaType) {
        List<Cave> allCaves = dataService.findAllCaves();
        if (PL_APPLICATION_JSON.equals(mediaType)) {
            List<WSCaveResponse> wsCave = allCaves.stream()
                    .map(WSCaveResponse::new)
                    .map(transalateService::translate)
                    .collect(Collectors.toList());
            return Response.ok(wsCave).build();
        }
        List<WSCaveResponse> wsCave = allCaves.stream()
                .map(WSCaveResponse::new)
                .collect(Collectors.toList());
        return Response.ok(wsCave).build();
    }

    @GET
    @Path("/forests")
    @Produces(MediaType.APPLICATION_JSON)
    public Response forests(@HeaderParam("Content-Type") MediaType mediaType) {
        List<Forest> forests = dataService.findAllForests();
        if (PL_APPLICATION_JSON.equals(mediaType)) {
            List<WSForestResponse> wsForests = forests.stream()
                    .map(WSForestResponse::new)
                    .map(transalateService::translate)
                    .collect(Collectors.toList());
            return Response.ok(wsForests).build();
        }
        List<WSForestResponse> wsForests = forests.stream()
                .map(WSForestResponse::new)
                .collect(Collectors.toList());
        return Response.ok(wsForests).build();
    }

    @GET
    @Path("/towers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response towers(@HeaderParam("Content-Type") MediaType mediaType) {
        List<Tower> towers = dataService.findAllTowers();
        if (PL_APPLICATION_JSON.equals(mediaType)) {
            List<WSTowerResponse> wsTowers = towers.stream()
                    .map(WSTowerResponse::new)
                    .map(transalateService::translate)
                    .collect(Collectors.toList());
            return Response.ok(wsTowers).build();
        }
        List<WSTowerResponse> wsTowers = towers.stream()
                .map(WSTowerResponse::new)
                .collect(Collectors.toList());
        return Response.ok(wsTowers).build();
    }

    @GET
    @Path("/caves/{caveId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cavesById(@HeaderParam("Content-Type") MediaType mediaType, @PathParam("caveId") Long caveId) {
        Cave caveById = dataService.findCaveById(caveId);
        if(caveById == null){
            return Response.status(404).build();
        }
        if (PL_APPLICATION_JSON.equals(mediaType)) {
            return Response.ok(transalateService.translate(new WSCaveResponse(caveById))).build();
        }
        return Response.ok(new WSCaveResponse(caveById)).build();
    }

    @GET
    @Path("/forests/{forestId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response forestById(@HeaderParam("Content-Type") MediaType mediaType, @PathParam("forestId") Long forestId) {
        Forest forestById = dataService.findForestById(forestId);
        if(forestById == null){
            return Response.status(404).build();
        }
        if (PL_APPLICATION_JSON.equals(mediaType)) {
            return Response.ok(transalateService.translate(new WSForestResponse(forestById))).build();
        }
        return Response.ok(new WSForestResponse(forestById)).build();
    }

    @GET
    @Path("/towers/{towerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response towerById(@HeaderParam("Content-Type") MediaType mediaType, @PathParam("towerId") Long towerId) {
        Tower towerById = dataService.findTowerById(towerId);
        if(towerById == null){
            return Response.status(404).build();
        }
        if (PL_APPLICATION_JSON.equals(mediaType)) {
            return Response.ok(transalateService.translate(new WSTowerResponse(towerById))).build();
        }
        return Response.ok(new WSTowerResponse(towerById)).build();
    }

    @POST
    @Path("/caves")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response caves(WSCave wsCave) {
        Cave cave = wsCave.toCave();
        UserData user = dataService.findUserDataByLogin(principal.getName());
        if (user.getRole() != UserData.UserRole.ADMIN) {
            cave.setOwner(user);
        }
        dataService.save(cave);
        return Response.accepted().build();
    }

    @POST
    @Path("/forests")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response forests(WSForest wsForest) {
        Forest forest = wsForest.toForest();
        UserData user = dataService.findUserDataByLogin(principal.getName());
        if (user.getRole() != UserData.UserRole.ADMIN) {
            forest.setOwner(user);
        }
        dataService.save(forest);
        return Response.accepted().build();
    }

    @POST
    @Path("/towers")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response towers(WSTower wsTower) {
        Tower tower = wsTower.toTower();
        UserData user = dataService.findUserDataByLogin(principal.getName());
        if (user.getRole() != UserData.UserRole.ADMIN) {
            tower.setOwner(user);
        }
        dataService.save(tower);
        return Response.accepted().build();
    }
}
