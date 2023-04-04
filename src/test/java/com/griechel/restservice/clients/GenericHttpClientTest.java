package com.griechel.restservice.clients;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.griechel.restservice.types.WeatherPointData;
import com.griechel.restservice.types.WeatherPointResponse;

public class GenericHttpClientTest {

    private final ObjectMapper om = new ObjectMapper().registerModule(new GuavaModule());
    private GenericHttpClient client = new GenericHttpClient("https://meteostat.p.rapidapi.com/point/daily");

    @Test
    public void testGet() throws JsonProcessingException {
        String responseString = client.get("?lat=43.6667&lon=-79.4&start=2020-01-01&end=2020-01-01&alt=184",
                "x-rapidapi-host", "meteostat.p.rapidapi.com",
                "x-rapidapi-key", "3264402e48msh8b99bdc540b6a68p17240ejsncea4481ccdac");
        WeatherPointResponse response = om.readValue(responseString, WeatherPointResponse.class);
        assertEquals(1, response.getData().size());
        WeatherPointData data = response.getData().get(0);
        assertEquals(0.3, data.getAverageTemp(), 0);
    }
}
