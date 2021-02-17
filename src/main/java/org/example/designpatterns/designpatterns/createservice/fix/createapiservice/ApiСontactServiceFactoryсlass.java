package org.example.designpatterns.designpatterns.createservice.fix.createapiservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.example.configuration.ConfigLoader;
import org.example.services.ContactService;
import org.example.services.UsersService;
import org.example.services.implementation.contact.ApiContactService;
import org.example.services.implementation.user.ApiUserService;

import java.net.http.HttpClient;
import java.util.Map;


public class ApiСontactServiceFactoryсlass implements ApiСontactServiceFactory {
    Map<String,Object> tools;
    public ApiСontactServiceFactoryсlass(Map<String, Object> tools) {
        this.tools = tools;
    }

    HttpClient httpClient = (HttpClient) tools.get("HttpClient");
    ObjectMapper objectMapper  = (ObjectMapper) tools.get("ObjectMapper");
    ConfigLoader configLoader = (ConfigLoader) tools.get("ConfigLoader");


    UsersService usersService;
    ContactService contactService;

    @Override
    public ContactService createService() {
        usersService = new ApiUserService();
        contactService = new ApiContactService()
        return contactService;
    }



}
