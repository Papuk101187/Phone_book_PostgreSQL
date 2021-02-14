package org.example.designpatterns.services.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.designpatterns.services.contacts.CreateContactsServiceFactory;
import org.example.services.ContactService;
import org.example.services.UsersService;
import org.example.services.implementation.contact.FileContactService;
import org.example.services.implementation.user.ApiUserService;

import java.net.http.HttpClient;

public class CreateUserServiceFactory implements CreateUsersFactory {
    UsersService usersService;

    @Override
    public UsersService getUserServiceApi(
            String getBaseURLregistration,
            String getBaseURLlogin,
            ObjectMapper objectMapper,
            HttpClient httpClient) {
        return usersService = new ApiUserService(
                getBaseURLregistration,
                getBaseURLlogin,
                objectMapper,
                httpClient);
    }
}
