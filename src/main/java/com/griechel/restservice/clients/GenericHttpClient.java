package com.griechel.restservice.clients;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.inject.Named;

public class GenericHttpClient {

    private final String endpointBaseUrl;

    public GenericHttpClient(@Named("endpointBaseUrl") String endpointBaseUrl) {
        this.endpointBaseUrl = endpointBaseUrl;
    }

    public String get(String urlSuffix, String... headers) {
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
        try {
            return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error when executing HTTP get", e);
        }
    }
}
