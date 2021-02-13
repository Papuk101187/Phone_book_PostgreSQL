package org.example.designpatterns.services.contacts;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.services.ContactService;
import org.example.services.UsersService;
import org.example.services.implementation.contact.ApiContactService;
import org.example.services.implementation.contact.FileContactService;
import org.example.services.implementation.contact.InMemoryContactService;

import java.net.http.HttpClient;

public class CreateContactsServicesFactory implements CreateContactsServiceFactory {


    ContactService contactService;


    @Override
    public ContactService getContactServiceFile(String files) {
        return contactService = new FileContactService(files);
    }

    @Override
    public ContactService getContactServiceApi(UsersService usersService, ObjectMapper objectMapper, HttpClient httpClient, String getBaseURLadd, String getBaseURLsearch, String getBaseURLget) {
        return contactService = new ApiContactService(
                usersService,
                objectMapper,
                httpClient,
                getBaseURLadd,
                getBaseURLsearch,
                getBaseURLget);
    }

    public ContactService getServiceContactArrays() {
        return contactService = new InMemoryContactService();
    }


}
