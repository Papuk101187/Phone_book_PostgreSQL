package org.example.designpatterns.designpatterns.createservice.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.services.ContactService;
import org.example.services.UsersService;

import java.net.http.HttpClient;

public interface CreateUsersServiceFactory {

    public UsersService getUserServiceApi(String getBaseURLregistration,
                                          String getBaseURLlogin,
                                          ObjectMapper objectMapper,
                                          HttpClient httpClient);


}
