package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.configuration.ApplicationGetPropertys;
import org.example.configuration.ConfigLoader;
import org.example.configuration.CreateService;
import org.example.designpatterns.designpatterns.createservice.fix.createapiservice.ApiСontactServiceFactory;
import org.example.designpatterns.designpatterns.createservice.fix.createapiservice.ApiСontactServiceFactoryсlass;
import org.example.entity.BulderTools;
import org.example.entity.Tools;
import org.example.entity.User;
import org.example.menu.PhoneBook;
import org.example.services.ContactService;
import org.example.services.UsersService;
import org.example.services.implementation.contact.NioContactService;

import java.io.IOException;
import java.net.http.HttpClient;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        ConfigLoader configLoader = new ConfigLoader(); // загружает properties из файла


        Tools tools = BulderTools.bulderTools // наполняем необходимыми инструментами
                .addToolsforHttpClient(HttpClient.newBuilder().build())
                .addToolsforObjectMapper(new ObjectMapper())
                .addToolsforConfig(configLoader).build();
        tools.packing(); // упаковуем наши инструменты для передачи в фабрику


        ApiСontactServiceFactory apiСontactServiceFactory =
                new ApiСontactServiceFactoryсlass(tools.getTools());







        String profile = configLoader.getProfile(); // получаем профиль из системы
        String configFile = "app-"+profile+".properties"; // получаем имя файла

        ApplicationGetPropertys properties = configLoader.load(configFile); // единый класс с properties

        CreateService createService = new CreateService(properties); // создаём сервис по нашим properties
        createService.BuildService(); // строим сервис

        ContactService contactService = createService.getContactservice(); // получаем сервис по контактам
        UsersService usersService = createService.getUsersService(); // получаем сервис по user

        ContactService contactService1 = new NioContactService();

        PhoneBook phoneBook = new PhoneBook(contactService1, usersService, new User()); // наша телефонная книга
        phoneBook.start();




    }

}
