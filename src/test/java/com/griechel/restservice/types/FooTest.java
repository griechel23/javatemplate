package com.griechel.restservice.types;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FooTest {
    @Test
    public void testFoo() {
        Foo foo = ImmutableFoo.builder().bar("bar").build();
        assertThat(foo.getBar()).isEqualTo("bar");
    }
}
