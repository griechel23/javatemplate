package com.testdb.types;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import com.griechel.restservice.types.Foo;
import com.griechel.restservice.types.ImmutableFoo;

public class FooTest {
    @Test
    public void testFoo() {
        Foo foo = ImmutableFoo.builder().bar("bar").build();
        assertThat(foo.getBar()).isEqualTo("bar");
    }
}
