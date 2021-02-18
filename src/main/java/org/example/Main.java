package org.example;

import org.example.designpatterns.designpatterns.facade.Application;
import org.example.entity.User;
import org.example.menu.PhoneBook;
import org.example.services.ContactService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Application application = new Application();


        ContactService service = application.ContactService();



        PhoneBook phoneBook = new PhoneBook(contactService1, usersService, new User()); // наша телефонная книга
        phoneBook.start();


    }

}
