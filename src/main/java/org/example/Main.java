package org.example;

import org.example.designpatterns.designpatterns.facade.Application;
import org.example.entity.User;
import org.example.menu.PhoneBook;
import org.example.services.ContactService;
import org.example.services.UsersService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Application application = new Application();


        ContactService contactService = application.getContactService();
        UsersService usersService = application.getUsersService();


        PhoneBook phoneBook = new PhoneBook(contactService, usersService, new User()); // наша телефонная книга
        phoneBook.start();


    }

}
