package com.soa.controller;

import com.soa.config.MongoConnection;
import com.soa.dao.FilmDao;
import com.soa.domain.Film;
import org.apache.http.HttpStatus;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/films")
public class FilmsController {

    private FilmDao dao = new FilmDao(MongoConnection.getInstance().getDatastore());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response films() {
        List<Film> films = dao.find().asList();
        return Response.ok(films).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response film(@PathParam("id") Long id) {
        Film film = dao.get(id);
        return Response.ok(film).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Film film) {
        dao.save(film);
        return Response.accepted().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Film film){
        Film oldFilm = dao.get(id);
        if(oldFilm == null) {
            return Response.status(HttpStatus.SC_NOT_FOUND).build();
        }
        dao.save(film);
        return Response.accepted().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        Film oldFilm = dao.get(id);
        if(oldFilm == null) {
            return Response.status(HttpStatus.SC_NOT_FOUND).build();
        }
        dao.deleteById(id);
        return Response.ok().build();
    }
}
