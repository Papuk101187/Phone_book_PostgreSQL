package org.example.services.implementation.user;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.services.implementation.dto.StatusResponce;
import org.example.services.implementation.dto.TokenResponse;
import org.example.entity.User;
import org.example.services.UsersService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;


public class ApiUserService implements UsersService {

    private String TOKEN;
    private LocalDateTime localDateTime;
    private String baseURLregistration;
    private String baseURLlogin;

    HttpClient httpCli;
    ObjectMapper objectMapper;
    private boolean Y;

    public ApiUserService(String baseURLregistra,
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
        return TOKEN;
    }


    @Override
    public String register(User user) throws IOException, InterruptedException {

        User user1 = user;

        System.out.println(user.getLogin());
        System.out.println(user.getDate_born());
        System.out.println(user.getPassword());


        System.out.println(user1.getLogin());


        String uze = objectMapper.writeValueAsString(user1);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseURLregistration))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(uze))
                .build();

        HttpResponse<String> response = httpCli.send(request, HttpResponse.BodyHandlers.ofString());
        String responce = response.body();
        System.out.println("responce "+responce);

        StatusResponce statusResponce = objectMapper.readValue(responce,StatusResponce.class);
        String s = statusResponce.status;

        return s;







    }

    @Override
    public String login(User user) throws IOException, InterruptedException {

        User user1 = user;

        ObjectMapper objectMapper =new ObjectMapper();
        String uze = objectMapper.writeValueAsString(user1);


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseURLlogin))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(uze))
                .build();

        HttpResponse<String> response = httpCli.send(request, HttpResponse.BodyHandlers.ofString());
        String responce = response.body();

        TokenResponse tokenResponse = objectMapper.readValue(responce,TokenResponse.class);
        TOKEN =tokenResponse.token;
        System.out.println("Получили "+TOKEN);
        return TOKEN;
    }




    @Override
    public String checkingService() {
        return "ApiUserService";
    }

}
