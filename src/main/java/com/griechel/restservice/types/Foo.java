package com.griechel.restservice.types;

import org.immutables.value.Value;

@Value.Immutable
public interface Foo {
    String getId();
    String getBar();
}
