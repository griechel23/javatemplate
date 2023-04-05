package com.griechel.restservice.resources;

import com.griechel.restservice.persistance.DatabaseController;
import com.griechel.restservice.types.Foo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ping")
public class PingResource {
    private final DatabaseController databaseController;

    @Inject
    public PingResource(DatabaseController databaseController) {
        this.databaseController = databaseController;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Foo ping(@PathParam("id") String id) {
        return databaseController.getRecord(id).orElse(null);
    }
}
