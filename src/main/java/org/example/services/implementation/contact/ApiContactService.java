package org.example.services.implementation.contact;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.designpatterns.designpatterns.dto.request.HttpRequestFactory;
import org.example.designpatterns.designpatterns.dto.request.JsonHttpRequestFactory;
import org.example.designpatterns.designpatterns.dto.response.HttpResponseFactory;
import org.example.designpatterns.designpatterns.dto.response.JsonHttpResponce;
import org.example.entity.Contact;
import org.example.entity.User;
import org.example.services.ContactService;
import org.example.services.UsersService;
import org.example.services.implementation.dto.RequestContactName;
import org.example.services.implementation.dto.ResponceContacts;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.util.List;

public class ApiContactService implements ContactService {

    UsersService usersServic;
    ObjectMapper objectMapp;
    public String urladd;
    public String urlget;
    public String urlsearch;
    User user;

    HttpClient httpClie;
    boolean check = false;

    HttpRequestFactory jsonHttpRequestFactory = new JsonHttpRequestFactory();
    HttpResponseFactory jsonHttpResponce = new JsonHttpResponce();

    public String checkingService() {
        return "ApiContactService";
    }

    @Override
    public void setUser(User user) throws IOException, InterruptedException, SQLException {
        this.user=user;
    }

    public ApiContactService(UsersService usersService,
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

        HttpRequest httpRequest = jsonHttpRequestFactory.createPostRequest(
                urlsearch,
                objectMapp.writeValueAsString(requestContactName),
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

        HttpRequest httpRequest = jsonHttpRequestFactory.createGetRequest(urlget,usersServic.getToken());

        HttpResponse<String> response = httpClie.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String status = response.body();

        ResponceContacts usersService = objectMapper.readValue(status, ResponceContacts.class);
        contacts = usersService.getContacts();

        return contacts;

    }
}
