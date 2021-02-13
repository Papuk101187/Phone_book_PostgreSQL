package org.example.designpatterns.contacts.response;

import lombok.Data;
import org.example.designpatterns.contacts.response.HttpResponseFactory;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Data
public class JsonHttpResponce implements HttpResponseFactory {

    @Override
    public HttpResponse <String>  createResponse(HttpRequest httpRequest,HttpClient httpClient) throws IOException, InterruptedException {
        return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

}
