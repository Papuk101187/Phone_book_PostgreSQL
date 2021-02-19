package org.example.designpatterns.designpatterns.createservice.fix.creatememorycontactservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.configuration.ApplicationGetPropertys;
import org.example.designpatterns.designpatterns.createservice.fix.createapiservice.ApiСontactServiceFactory;
import org.example.services.ContactService;
import org.example.services.UsersService;
import org.example.services.implementation.contact.FileContactService;
import org.example.services.implementation.contact.InMemoryContactService;
import org.example.services.implementation.user.ApiUserService;
import org.example.services.implementation.user.FictiApiUserService;

import java.net.http.HttpClient;

public class InMemoryContactServiceFactoryclass implements InMemoryContactServiceFactory{

    UsersService usersService;
    ContactService contactService;


    public InMemoryContactServiceFactoryclass(ApplicationGetPropertys applicationGetPropertys) {
        this.applicationGetPropertys = applicationGetPropertys;
    }

    ApplicationGetPropertys applicationGetPropertys;


    ObjectMapper objectMapper = new ObjectMapper();
    HttpClient httpClient = HttpClient.newBuilder().build();


    @Override
    public ContactService createContactService() {

        return new InMemoryContactService();
    }


    public UsersService createUsersService() {

        if(usersService!=null){
            return usersService;
        }else {
            return new FictiApiUserService(
                    applicationGetPropertys.getBaseURLregistration(),
                    applicationGetPropertys.getBaseURLlogin(), objectMapper, httpClient);
        }


    }
}
