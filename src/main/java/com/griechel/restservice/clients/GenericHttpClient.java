package com.griechel.restservice.clients;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.inject.Named;

import com.fasterxml.jackson.core.JsonProcessingException;

public class GenericHttpClient {

    private final String endpointBaseUrl;

    public GenericHttpClient(@Named("endpointBaseUrl") String endpointBaseUrl) {
        this.endpointBaseUrl = endpointBaseUrl;
    }

    // Returns the body of an HTTP request if it has a 200 response, otherwise throws exception.
    public String get(String urlSuffix, String... headers) throws JsonProcessingException {
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder()
                                 .uri(new URI(endpointBaseUrl + urlSuffix))
                                 .headers(headers)
                                 .GET()
                                 .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException("Error when creating HTTP request", e);
        }

        HttpResponse<String> response;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error when executing HTTP get", e);
        }

        if (response.statusCode() != 200) {
            throw new RuntimeException("Non 200 response " + response.statusCode());
        }

        return response.body();
    }
}
