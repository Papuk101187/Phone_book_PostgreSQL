package org.example.designpatterns.designpatterns.createservice.fix.createfileservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.configuration.ApplicationGetPropertys;
import org.example.designpatterns.designpatterns.createservice.fix.createapiservice.ApiСontactServiceFactory;
import org.example.services.ContactService;
import org.example.services.UsersService;
import org.example.services.implementation.contact.ApiContactService;
import org.example.services.implementation.contact.FileContactService;
import org.example.services.implementation.user.ApiUserService;
import org.example.services.implementation.user.FictiApiUserService;

import java.net.http.HttpClient;

public class FileСontactServiceFactoryclass implements FileСontactServiceFactory {

    UsersService usersService;
    ContactService contactService;


    public FileСontactServiceFactoryclass(ApplicationGetPropertys applicationGetPropertys) {
        this.applicationGetPropertys = applicationGetPropertys;
    }

    ApplicationGetPropertys applicationGetPropertys;


    ObjectMapper objectMapper = new ObjectMapper();
    HttpClient httpClient = HttpClient.newBuilder().build();


    @Override
    public ContactService createContactService() {

        return new FileContactService(applicationGetPropertys.getFile());
    }


    public UsersService createUsersService() {

        if(usersService!=null){
            return usersService;
        }else {
            return new ApiUserService(
                    applicationGetPropertys.getBaseURLregistration(),
                    applicationGetPropertys.getBaseURLlogin(), objectMapper, httpClient);
        }


    }
}
