package com.griechel.restservice.resources;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ping")
public class PingResource {

    private final String response;

    @Inject
    public PingResource(@Named("pingResponse") String response) {
        this.response = response;
    }
    @GET
    public String ping() {
        return response;
    }
}
