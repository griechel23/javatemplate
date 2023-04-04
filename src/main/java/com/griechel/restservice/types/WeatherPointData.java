package com.griechel.restservice.types;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@JsonDeserialize(as = ImmutableWeatherPointData.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface WeatherPointData {
    @JsonProperty
    String getDate();
    @JsonProperty("tavg")
    double getAverageTemp();
}
