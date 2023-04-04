package com.griechel.restservice.types;

import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@JsonDeserialize(as = ImmutableWeatherPointResponse.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface WeatherPointResponse {

    @JsonProperty
    List<WeatherPointData> getData();
}
