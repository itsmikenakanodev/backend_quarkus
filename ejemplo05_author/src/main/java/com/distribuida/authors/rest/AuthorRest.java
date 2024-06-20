package com.distribuida.authors.rest;

import com.distribuida.authors.db.Author;
import com.distribuida.authors.repo.AuthorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class AuthorRest {

    @Inject
    AuthorRepository repo;

    @GET
    public List<Author> findAll(){
        return repo.listAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id){
        var op=repo.findByIdOptional(id);
        if (op.isEmpty()){
            //No encontrado
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(op.get()).build();
    }

    @POST
    public Response create(Author author){
        author.setId(null);
        repo.persist(author);
        return Response.status(Response.Status.CREATED).build();
    }


    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, Author author){
        var obj=repo.findById(id);

        obj.setName(author.getName());
        obj.setAverageRating(author.getAverageRating());
        obj.setNationality(author.getNationality());

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id){
        repo.deleteById(id);

        return Response.ok().build();
    }



}
