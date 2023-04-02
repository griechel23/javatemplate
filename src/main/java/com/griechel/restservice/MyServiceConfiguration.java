package com.griechel.restservice;

import io.dropwizard.Configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyServiceConfiguration extends Configuration {

    private String test;

    @JsonProperty
    public void setPingResponse(String test) {
        this.test = test;
    }

    @JsonProperty
    public String getPingResponse() {
        return test;
    }
}
