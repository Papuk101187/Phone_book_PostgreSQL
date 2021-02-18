package org.example.designpatterns.designpatterns.createservice.fix.creatememorycontactservice;

import org.example.designpatterns.designpatterns.createservice.fix.createapiservice.ApiСontactServiceFactory;
import org.example.services.ContactService;

public interface InMemoryContactServiceFactory {

    ContactService createService();
}
