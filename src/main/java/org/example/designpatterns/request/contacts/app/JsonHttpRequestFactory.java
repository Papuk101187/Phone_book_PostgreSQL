package org.example.designpatterns.request.contacts.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;

import java.net.URI;
import java.net.http.HttpRequest;

@Data
public class JsonHttpRequestFactory implements HttpRequestFactory {

    String url;
    Object object;
    String token;
    String serialiobject;


    @Override
    public HttpRequest createGetRequest(String url,String token) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .build();
    }

    @Override
    public HttpRequest createPostRequest(String url, String object, String token) throws JsonProcessingException {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .POST(HttpRequest.BodyPublishers.ofString(object))
                .build();
    }

}
