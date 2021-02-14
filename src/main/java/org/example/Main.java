package org.example;

import org.example.configuration.ApplicationGetPropertys;
import org.example.configuration.ConfigLoader;
import org.example.configuration.CreateService;
import org.example.entity.User;
import org.example.menu.PhoneBook;
import org.example.services.ContactService;
import org.example.services.UsersService;
import org.example.services.implementation.contact.NioContactService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {



        ConfigLoader configLoader = new ConfigLoader(); // загружает properties из файла
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


//        ContactBuffers contactBuffers = new ContactBuffers();
//        contactBuffers.readBuffer();
//
//        String a = "[oleg [email :vasia@i.ua],";
//
//        String b = a.substring(a.length()-1);
//        System.out.println(b);




    }

}
