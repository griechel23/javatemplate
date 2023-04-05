package com.griechel.restservice.persistance;

import com.griechel.restservice.types.Foo;
import com.griechel.restservice.types.ImmutableFoo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class DatabaseControllerTest {

    private static final Foo FOO = ImmutableFoo.builder()
            .id("foo")
            .bar("bar")
            .build();

    private DatabaseController db = new DatabaseController("jdbc:sqlite:data.db");

    @Before
    public void beforeEach() {
        try {
            db.storeRecord(FOO);
        } catch (RuntimeException e) {
            if (!e.getCause().getMessage().contains("A PRIMARY KEY constraint failed")) {
                throw (e);
            }
        }
    }

    @Test
    public void testGetRecord() {
        Optional<Foo> city = db.getRecord("foo");
        assertEquals(FOO.getBar(), city.get().getBar());
    }
}
