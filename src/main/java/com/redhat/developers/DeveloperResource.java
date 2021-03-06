package com.redhat.developers;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/developer")
public class DeveloperResource {

    @Inject
    DeveloperRepository developerRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Developer> developers(@QueryParam("brazilian") boolean brazilian) {
        if (brazilian) {
            return developerRepository.findBrazilianJapanese();
        }
        return Developer.listAll();
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newDeveloper(@Valid Developer developer) {
        developer.id = null;
        developer.persist();
        return Response.status(Status.CREATED).entity(developer).build();        
    }

}