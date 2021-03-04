//package org.example.services.implementation.contact;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.example.designpatterns.designpatterns.dto.request.HttpRequestFactory;
//import org.example.designpatterns.designpatterns.dto.request.JsonHttpRequestFactory;
//import org.example.designpatterns.designpatterns.dto.response.HttpResponseFactory;
//import org.example.designpatterns.designpatterns.dto.response.JsonHttpResponce;
//import org.example.entity.Contact;
//import org.example.services.ContactService;
//import org.example.services.UsersService;
//import org.example.services.implementation.database.Postgres;
//import org.example.services.implementation.dto.RequestContactName;
//import org.example.services.implementation.dto.ResponceContacts;
//
//import java.io.IOException;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.util.List;
//
//public class DataBaseContactService implements ContactService {
//
//    UsersService usersServic;
//    ObjectMapper objectMapp;
//    public String urladd;
//    public String urlget;
//    public String urlsearch;
//
//    HttpClient httpClie;
//    boolean check = false;
//
//
//
//    public boolean checkingService() {
//        return check;
//    }
//
//    public DataBaseContactService(UsersService usersService,
//                                  ObjectMapper objectMapper,
//                                  HttpClient client,
//                                  String urladdcontact,
//                                  String urlsearchcontact,
//                                  String urlget) {
//        this.usersServic = usersService;
//        this.check = true;
//        this.objectMapp = objectMapper;
//        this.httpClie = client;
//        this.urladd = urladdcontact;
//        this.urlsearch = urlsearchcontact;
//        this.urlget = urlget;
//    }
//
//    public String add(Contact contact) throws IOException, InterruptedException {
//
//
//    }
//
//    public List<Contact> searchContact(String name) throws IOException, InterruptedException {
//
//
//    }
//
//    public List<Contact> getAllcontact() throws IOException, InterruptedException {
//
//
//    }
//}
