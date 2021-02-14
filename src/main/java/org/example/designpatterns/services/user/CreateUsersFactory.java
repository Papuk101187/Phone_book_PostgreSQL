package org.example.designpatterns.services.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.services.ContactService;
import org.example.services.UsersService;

import java.net.http.HttpClient;

public interface CreateUsersFactory {

    public UsersService getUserServiceApi(String getBaseURLregistration,
                                          String getBaseURLlogin,
                                          ObjectMapper objectMapper,
                                          HttpClient httpClient);


}
