package org.example.designpatterns.factory.response;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface HttpResponseFactory {

    public HttpResponse createResponse();



}
