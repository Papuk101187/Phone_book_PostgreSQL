package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.configuration.ApplicationGetPropertys;
import org.example.configuration.ConfigLoader;
import org.example.entity.User;
import org.example.menu.PhoneBook;
import org.example.services.ContactService;
import org.example.services.UsersService;
import org.example.services.implementation.contact.ApiContactService;
import org.example.services.implementation.contact.FileContactService;
import org.example.services.implementation.contact.InMemoryContactService;
import org.example.services.implementation.user.ApiUserService;

import java.io.IOException;
import java.net.http.HttpClient;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {



        ConfigLoader configLoader = new ConfigLoader();
        String profile = configLoader.getProfile();
        String configFile = "app-"+profile+".properties";

        ApplicationGetPropertys propertys = configLoader.load(configFile);


        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient client = HttpClient.newBuilder().build();


        UsersService usersService = new ApiUserService(propertys.getBaseURLregistration()
                , propertys.getBaseURLlogin(), objectMapper, client);

        ContactService contactService = new ApiContactService(
                usersService,
                objectMapper,
                client,
                propertys.getUriadd(),
                propertys.getUrisearchcontact(),
                propertys.getGetcontact());

        ContactService contactService1 = new InMemoryContactService();
        ContactService contactService2 = new FileContactService("Phone book.txt");

        PhoneBook phoneBook = new PhoneBook(contactService, usersService, new User());
        phoneBook.start();


    }

}
