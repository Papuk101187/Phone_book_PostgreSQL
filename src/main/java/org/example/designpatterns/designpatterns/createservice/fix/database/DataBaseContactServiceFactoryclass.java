package org.example.designpatterns.designpatterns.createservice.fix.database;

import org.example.configuration.ApplicationGetPropertys;
import org.example.services.ContactService;
import org.example.services.UsersService;
import org.example.services.implementation.contact.DataBaseContactService;
import org.example.services.implementation.user.UserServiceDataBase;

public class DataBaseContactServiceFactoryclass implements DataBaseContactServiceFactory {

    UsersService usersService;
    ContactService contactService;


    public DataBaseContactServiceFactoryclass(ApplicationGetPropertys applicationGetPropertys) {
        this.applicationGetPropertys = applicationGetPropertys;
    }

    ApplicationGetPropertys applicationGetPropertys;


    @Override
    public ContactService createContactService() {

        return new DataBaseContactService();

    }

    @Override
    public UserServiceDataBase createUsersService() {

        return new UserServiceDataBase();
    }


}
