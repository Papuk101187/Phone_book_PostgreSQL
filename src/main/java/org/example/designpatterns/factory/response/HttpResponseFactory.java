package org.example.designpatterns.factory.response;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface HttpResponseFactory {

    public HttpResponse createResponse(HttpRequest httpRequest, HttpClient httpClient) throws IOException, InterruptedException;



}
