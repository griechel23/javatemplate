package com.griechel.restservice.resources;

import com.griechel.restservice.dagger.modules.ApplicationModule;
import com.griechel.restservice.persistance.DatabaseController;
import com.griechel.restservice.types.Foo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ping")
public class PingResource {
    private final DatabaseController databaseController;
    private final String pingResponse;

    @Inject
    public PingResource(@Named(ApplicationModule.PING_RESPONSE) String pingResponse, DatabaseController databaseController) {
        this.pingResponse = pingResponse;
        this.databaseController = databaseController;
    }

    @GET
    public String ping() {
        return pingResponse;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Foo pingWithId(@PathParam("id") String id) {
        return databaseController.getRecord(id).orElse(null);
    }
}
