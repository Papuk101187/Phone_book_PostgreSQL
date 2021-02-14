package org.example.configuration;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.example.designpatterns.services.contacts.CreateContactsServiceFactory;
import org.example.designpatterns.services.contacts.CreateContactsServicesFactory;
import org.example.designpatterns.services.user.CreateUserServiceFactory;
import org.example.designpatterns.services.user.CreateUsersFactory;
import org.example.services.ContactService;
import org.example.services.UsersService;
import org.example.services.implementation.contact.ApiContactService;
import org.example.services.implementation.contact.FileContactService;
import org.example.services.implementation.contact.InMemoryContactService;
import org.example.services.implementation.user.ApiUserService;

import java.net.http.HttpClient;

@Data
public class CreateService {

    CreateContactsServiceFactory createContactsServiceFactory = new CreateContactsServicesFactory();
    CreateUsersFactory createUsersFactory = new CreateUserServiceFactory();


    public ContactService getContactservice() {
        return contactservice;
    }

    ApplicationGetPropertys properties;

    public UsersService getUsersService() {
        return usersService;
    }

    ContactService contactservice;
    UsersService usersService;

    ObjectMapper objectMapper = new ObjectMapper();
    HttpClient client = HttpClient.newBuilder().build();


    public CreateService(ApplicationGetPropertys prop) {
        this.properties = prop;
    }


    public void BuildService() {
        if (properties.getWorkmode() == "file") {
            contactservice = new FileContactService(properties.getFile());
        }

        switch (properties.getWorkmode()) {

            case "file":
                contactservice = createContactsServiceFactory.getContactServiceFile(properties.getFile());
                break;
            case "api":
                usersService = createUsersFactory.getUserServiceApi(properties.baseURLregistration,
                        properties.baseURLlogin, objectMapper, client);

                contactservice = createContactsServiceFactory.getContactServiceApi(
                        usersService,
                        objectMapper,
                        client,
                        properties.baseURLadd,
                        properties.getBaseURLsearch(),
                        properties.getBaseURLget());
                break;
            case "memory":
                contactservice = createContactsServiceFactory.getInMemoryContactService();

        }
    }
}


