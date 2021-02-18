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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ApplicationFasad {


    public ContactService getContactService() {
        return contactService;
    }

    public UsersService getUsersService() {
        return usersService;
    }

    ContactService contactService;
    UsersService usersService;
    Properties prop = new Properties();


    ConfigLoader configLoader = new ConfigLoader(); // загружает properties из файла
    String profile = configLoader.getProfile(); // получаем профиль из системы
    String configFile = "app-" + profile + ".properties"; // получаем имя файла
    ApplicationGetPropertys properties = new ApplicationGetPropertys();
    ApplicationGetPropertys applicationGetPropertys = new ApplicationGetPropertys();


    FileСontactServiceFactory fileСontactServiceFactory = new FileСontactServiceFactoryclass(applicationGetPropertys);
    ApiСontactServiceFactory apiСontactServiceFactory = new ApiСontactServiceFactoryсlass(applicationGetPropertys);
    InMemoryContactServiceFactory inMemoryContactServiceFactory = new InMemoryContactServiceFactoryclass(applicationGetPropertys);

    {
        try {
            properties = configLoader.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createConfiguration() throws IOException {
        {
            System.out.println("-> createConfiguration");
        }

        FileInputStream fileInputStream = new FileInputStream(configFile);
        prop.load(fileInputStream);
        applicationGetPropertys.setBaseURLlogin(prop.getProperty("api.base-authorization"));
        applicationGetPropertys.setBaseURLregistration(prop.getProperty("api.base-registration"));
        applicationGetPropertys.setBaseURLadd(prop.getProperty("api.base-addcontact"));
        applicationGetPropertys.setBaseURLsearch(prop.getProperty("api.base-searchcontact"));
        applicationGetPropertys.setBaseURLget(prop.getProperty("api.base-getcontact"));
        applicationGetPropertys.setWorkmode(prop.getProperty("app.service.workmode"));
        applicationGetPropertys.setFile(prop.getProperty("file.path"));

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
