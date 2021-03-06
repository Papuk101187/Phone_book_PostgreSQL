package org.example.designpatterns.designpatterns.createservice.fix.database;

import org.example.services.ContactService;
import org.example.services.implementation.user.UserServiceDataBase;

public interface DataBaseContactServiceFactory {

    ContactService createContactService();
    UserServiceDataBase createUsersService();
}
