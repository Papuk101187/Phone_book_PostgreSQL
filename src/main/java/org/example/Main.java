package org.example;

import org.example.designpatterns.designpatterns.facade.ApplicationFasad;
import org.example.entity.User;
import org.example.menu.PhoneBook;
import org.example.services.ContactService;
import org.example.services.UsersService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        ApplicationFasad applicationFasad = new ApplicationFasad();
        applicationFasad.createServices();

        ContactService contactService = applicationFasad.getContactService();
        UsersService usersService = applicationFasad.getUsersService();


        PhoneBook phoneBook = new PhoneBook(contactService, usersService, new User()); // наша телефонная книга
        phoneBook.start();

    }

}
