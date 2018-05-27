package com.soa;

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
import java.util.HashSet;
import java.util.Set;

@Path("/cats")
public class CatsController {

    private final static Set<Cat> cats = new HashSet<Cat>() {{
        add(new Cat(1L, "a1", "c1"));
        add(new Cat(2L, "a2", "c2"));
        add(new Cat(3L, "a3", "c3"));
        add(new Cat(4L, "a4", "c4"));
        add(new Cat(5L, "a5", "c5"));
    }};

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Cat> cats() {
        return cats;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response catById(@PathParam("id") Long id) {
        return cats.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(c -> Response.ok(c).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Cat cat) {
        cats.add(cat);
        return Response.accepted().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Cat cat) {
        Cat oldCat = cats.stream()
                .filter(c -> c.getId().equals(id))
                .findAny()
                .orElse(null);
        cats.remove(oldCat);
        cat.setId(id);
        cats.add(cat);
        return Response.accepted().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBydId(@PathParam("id") Long id) {
        Cat cat = cats.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .get();
        cats.remove(cat);
        return Response.ok().build();
    }
}
