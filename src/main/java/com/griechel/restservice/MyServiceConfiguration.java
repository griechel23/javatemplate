package com.griechel.restservice;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.dropwizard.Configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableMyServiceConfiguration.class)
public abstract class MyServiceConfiguration extends Configuration {

    @JsonProperty
    public abstract String getPingResponse();

    @Override
    public abstract String toString();
}
