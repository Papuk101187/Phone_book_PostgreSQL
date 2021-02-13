package org.example.designpatterns.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpRequest;

public class JsonHttpRequestFactory implements HttpRequestFactory {


    @Override
    public HttpRequest createGetRequest(String url) {
        return HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .build();
    }

    @Override
    public HttpRequest createPostRequest(String url, Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String obj = objectMapper.writeValueAsString(object);
        return HttpRequest.newBuilder()
                .uri(URI.create(""))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(obj))
                .build();
    }

}
