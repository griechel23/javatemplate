package com.griechel.restservice.clients;

import static org.junit.Assert.assertNotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;

public class GenericHttpClientTest {

    private final ObjectMapper om = new ObjectMapper().registerModule(new GuavaModule());
    private GenericHttpClient client = new GenericHttpClient("https://meteostat.p.rapidapi.com/point/daily");

    @Test
    public void testGet() throws JsonProcessingException {
        String key = System.getenv("WEATHER_KEY");
        String response = client.get("?lat=43.6667&lon=-79.4&start=2020-01-01&end=2020-01-31&alt=184",
            "x-rapidapi-host", "meteostat.p.rapidapi.com",
            "x-rapidapi-key", key);
        assertNotNull(response);
    }
}
