package com.testdb.config;

import io.dropwizard.Configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceConfiguration extends Configuration {

    private String test;

    @JsonProperty
    public void setTest(String test) {
        this.test = test;
    }

    @JsonProperty
    public String getTest() {
        return test;
    }
}
