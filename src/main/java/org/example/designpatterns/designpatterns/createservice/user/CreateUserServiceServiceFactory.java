package org.example.designpatterns.designpatterns.createservice.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.services.UsersService;
import org.example.services.implementation.user.ApiUserService;

import java.net.http.HttpClient;

public class CreateUserServiceServiceFactory implements CreateUsersServiceFactory {
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
