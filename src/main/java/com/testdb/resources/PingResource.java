package com.testdb.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ping")
public class PingResource {

    private final String response;

    public PingResource(String response) {
        this.response = response;
    }
    @GET
    public String ping() {
        return response;
    }
}
