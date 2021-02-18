package org.example.designpatterns.designpatterns.createservice.fix.creatememorycontactservice;

import org.example.designpatterns.designpatterns.createservice.fix.createapiservice.ApiСontactServiceFactory;
import org.example.services.ContactService;
import org.example.services.UsersService;

public interface InMemoryContactServiceFactory {

    ContactService createContactService();
    UsersService createUsersService();
}
