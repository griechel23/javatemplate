package com.griechel.restservice.clients;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class GenericHttpClientTest {

    private final GenericHttpClient client = new GenericHttpClient("https://meteostat.p.rapidapi.com/point/daily");

    @Test
    public void testGet() {
        String key = System.getenv("WEATHER_KEY");
        String response = client.get("?lat=43.6667&lon=-79.4&start=2020-01-01&end=2020-01-31&alt=184",
            "x-rapidapi-host", "meteostat.p.rapidapi.com",
            "x-rapidapi-key", key);
        assertNotNull(response);
    }
}
