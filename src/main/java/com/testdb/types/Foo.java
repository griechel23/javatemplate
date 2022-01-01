package com.testdb.types;

import org.immutables.value.Value;

@Value.Immutable
public interface Foo {
    String getBar();
}
