package org.example.designpatterns.designpatterns.facade;

import org.example.configuration.ApplicationGetPropertys;
import org.example.configuration.ConfigLoader;
import org.example.designpatterns.designpatterns.createservice.fix.createapiservice.ApiСontactServiceFactory;
import org.example.designpatterns.designpatterns.createservice.fix.createapiservice.ApiСontactServiceFactoryсlass;
import org.example.designpatterns.designpatterns.createservice.fix.createfileservice.FileСontactServiceFactory;
import org.example.designpatterns.designpatterns.createservice.fix.createfileservice.FileСontactServiceFactoryclass;
import org.example.designpatterns.designpatterns.createservice.fix.creatememorycontactservice.InMemoryContactServiceFactory;
import org.example.designpatterns.designpatterns.createservice.fix.creatememorycontactservice.InMemoryContactServiceFactoryclass;
import org.example.services.ContactService;
import org.example.services.UsersService;

import java.io.IOException;

public class ApplicationFasad {


    public ContactService getContactService() {
        return contactService;
    }

    public UsersService getUsersService() {
        return usersService;
    }

    ContactService contactService;
    UsersService usersService;


    ConfigLoader configLoader = new ConfigLoader(); // загружает properties из файла
    String profile = configLoader.getProfile(); // получаем профиль из системы
    String configFile = "app-" + profile + ".properties"; // получаем имя файла
    ApplicationGetPropertys properties = new ApplicationGetPropertys();



    FileСontactServiceFactory fileСontactServiceFactory = new FileСontactServiceFactoryclass(properties);
    ApiСontactServiceFactory apiСontactServiceFactory = new ApiСontactServiceFactoryсlass(properties);
    InMemoryContactServiceFactory inMemoryContactServiceFactory = new InMemoryContactServiceFactoryclass(properties);

    {
        try {
            properties = configLoader.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void createServices() {
        switch (properties.getWorkmode()) {
            case "file":
                contactService = fileСontactServiceFactory.createContactService();
                usersService = fileСontactServiceFactory.createUsersService();
                break;
            case "api":
                contactService = apiСontactServiceFactory.createContactService();
                usersService = apiСontactServiceFactory.createUsersService();
                break;
            case "memory":
                contactService = inMemoryContactServiceFactory.createContactService();
                usersService = inMemoryContactServiceFactory.createUsersService();
        }
    }


}
