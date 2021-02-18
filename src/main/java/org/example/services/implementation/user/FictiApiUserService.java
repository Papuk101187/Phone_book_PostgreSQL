package org.example.services.implementation.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.User;
import org.example.services.UsersService;

import java.io.IOException;
import java.net.http.HttpClient;
import java.time.LocalDateTime;

public class FictiApiUserService implements UsersService {

    private String token;
    private LocalDateTime localDateTime;
    private String baseURLregistration;
    private String baseURLlogin;

    HttpClient httpCli;
    ObjectMapper objectMapper;
    private boolean Y;

    public FictiApiUserService(String baseURLregistra,
                          String baseURLlo,
                          ObjectMapper objectMap,
                          HttpClient client) {
        this.baseURLregistration=baseURLregistra;
        this.baseURLlogin=baseURLlo;
        this.objectMapper=objectMap;
        this.httpCli=client;
    }


    @Override
    public String getToken() {
        return "not supported";
    }

    @Override
    public String register(User user) throws IOException, InterruptedException {
        return "not supported";
    }

    @Override
    public String login(User user) throws IOException, InterruptedException {
        return "not supported";
    }
}
