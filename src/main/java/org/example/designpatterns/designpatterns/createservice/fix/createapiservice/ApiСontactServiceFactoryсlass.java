package org.example.designpatterns.designpatterns.createservice.fix.createapiservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.configuration.ApplicationGetPropertys;
import org.example.configuration.ConfigLoader;
import org.example.services.ContactService;
import org.example.services.UsersService;
import org.example.services.implementation.contact.ApiContactService;
import org.example.services.implementation.user.ApiUserService;

import java.net.http.HttpClient;
import java.util.Map;

public class ApiСontactServiceFactoryсlass implements ApiСontactServiceFactory {


    UsersService usersService;
    ContactService contactService;


    public ApiСontactServiceFactoryсlass(ApplicationGetPropertys applicationGetPropertys) {
        this.applicationGetPropertys = applicationGetPropertys;
    }

    ApplicationGetPropertys applicationGetPropertys;

    ObjectMapper objectMapper = new ObjectMapper();
    HttpClient httpClient = HttpClient.newBuilder().build();


    @Override
    public ContactService createContactService() {

            usersService = new ApiUserService(
                    applicationGetPropertys.getBaseURLregistration(),
                    applicationGetPropertys.getBaseURLlogin(), objectMapper, httpClient);

            contactService=new  ApiContactService(
                    usersService,
                    objectMapper, httpClient,
                    applicationGetPropertys.getBaseURLadd(),
                    applicationGetPropertys.getBaseURLsearch(),
                    applicationGetPropertys.getBaseURLadd());
            return contactService;
    }


    public UsersService createUsersService() {

        if (usersService != null) {
            return usersService;
        } else {
            return new ApiUserService(
                    applicationGetPropertys.getBaseURLregistration(),
                    applicationGetPropertys.getBaseURLlogin(), objectMapper, httpClient);
        }
    }
}
