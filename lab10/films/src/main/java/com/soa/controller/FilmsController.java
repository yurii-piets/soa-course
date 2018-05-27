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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/films")
public class FilmsController {

    public static final String BASIC_URL = "http://localhost:8080/lab10/films/";

    private FilmDao dao = new FilmDao(MongoConnection.getInstance().getDatastore());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response films(@QueryParam("title") List<String> titles) {
        if (titles != null && !titles.isEmpty()) {
            List<Film> films = dao.find().asList().stream()
                    .filter(f -> titles.contains(f.getName()))
                    .collect(Collectors.toList());
            return Response.ok(films).build();
        }
        List<Film> films = dao.find().asList();
        return Response.ok(films).build();
    }

    @GET
    @Path("/uris")
    @Produces(MediaType.APPLICATION_JSON)
    public Response filmUris() {
        List<String> films = dao.find().asList().stream()
                .map(Film::getUri)
                .collect(Collectors.toList());
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
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAll(List<Film> films){
        dao.find().asList().forEach(dao::delete);
        films.forEach(dao::save);
        return Response.accepted().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Film film) {
        Film oldFilm = dao.get(id);
        if (oldFilm == null) {
            return Response.status(HttpStatus.SC_NOT_FOUND).build();
        }
        dao.save(film);
        return Response.accepted().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Film oldFilm = dao.get(id);
        if (oldFilm == null) {
            return Response.status(HttpStatus.SC_NOT_FOUND).build();
        }
        dao.deleteById(id);
        return Response.noContent().build();
    }
}
