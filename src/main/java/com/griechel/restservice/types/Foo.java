package com.griechel.restservice.types;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonProperty;

@Value.Immutable
public interface Foo {
    @JsonProperty
    String getBar();
}
