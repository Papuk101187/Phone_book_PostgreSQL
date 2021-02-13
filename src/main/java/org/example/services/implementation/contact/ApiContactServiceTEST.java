package org.example.services.implementation.contact;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.designpatterns.factory.request.JsonHttpRequestFactory;
import org.example.designpatterns.factory.response.JsonHttpResponce;
import org.example.entity.Contact;
import org.example.services.ContactService;
import org.example.services.UsersService;
import org.example.services.implementation.dto.RequestContactName;
import org.example.services.implementation.dto.ResponceContacts;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ApiContactServiceTEST implements ContactService {

    UsersService usersServic;
    ObjectMapper objectMapp;
    public String urladd;
    public String urlget;
    public String urlsearch;

    HttpClient httpClie;
    boolean check = false;

    JsonHttpRequestFactory jsonHttpRequestFactory = new JsonHttpRequestFactory();
    JsonHttpResponce jsonHttpResponce = new JsonHttpResponce();

    public boolean checkingService() {
        return check;
    }

    public ApiContactServiceTEST(UsersService usersService,
                                 ObjectMapper objectMapper,
                                 HttpClient client,
                                 String urladdcontact,
                                 String urlsearchcontact,
                                 String urlget) {
        this.usersServic = usersService;
        this.check = true;
        this.objectMapp = objectMapper;
        this.httpClie = client;
        this.urladd = urladdcontact;
        this.urlsearch = urlsearchcontact;
        this.urlget = urlget;
    }

    public String add(Contact contact) throws IOException, InterruptedException {

        HttpRequest httpRequest = jsonHttpRequestFactory.createPostRequest(
                urladd,
                objectMapp.writeValueAsString(contact),
                usersServic.getToken());

        HttpResponse<String> httpResponse = jsonHttpResponce.createResponse(httpRequest, httpClie);
        String status = httpResponse.body();

        return status;

    }

    public List<Contact> searchContact(String name) throws IOException, InterruptedException {

        List<Contact> contacts = null;

        RequestContactName requestContactName = new RequestContactName();
        requestContactName.setName(name);


        ObjectMapper objectMapper = new ObjectMapper();
        String status;

        String uzers = objectMapper.writeValueAsString(requestContactName);

        HttpRequest httpRequest = jsonHttpRequestFactory.createPostRequest(
                urlsearch,
                objectMapp.writeValueAsString(uzers),
                usersServic.getToken());

        HttpResponse<String> httpResponse = jsonHttpResponce.createResponse(httpRequest, httpClie);
        status = httpResponse.body();

        ResponceContacts usersService = objectMapper.readValue(httpResponse.body(), ResponceContacts.class);
        contacts = usersService.getContacts();

        return contacts;

    }

    public List<Contact> getAllcontact() throws IOException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Contact> contacts;

        HttpRequest httpRequest = jsonHttpRequestFactory.createGetRequest(urlget);

        HttpResponse<String> response = httpClie.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String status = response.body();

        ResponceContacts usersService = objectMapper.readValue(status, ResponceContacts.class);
        contacts = usersService.getContacts();

        return contacts;


    }
}
