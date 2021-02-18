package org.example.designpatterns.designpatterns.createservice.fix.createfileservice;

import org.example.designpatterns.designpatterns.createservice.fix.createapiservice.ApiСontactServiceFactory;
import org.example.services.ContactService;
import org.example.services.UsersService;

public interface FileСontactServiceFactory {

     ContactService createContactService();
    UsersService createUsersService();

}
