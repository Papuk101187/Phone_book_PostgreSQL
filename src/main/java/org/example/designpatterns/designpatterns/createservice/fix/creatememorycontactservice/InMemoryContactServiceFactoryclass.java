package org.example.designpatterns.designpatterns.createservice.fix.creatememorycontactservice;

import org.example.configuration.ApplicationGetPropertys;
import org.example.designpatterns.designpatterns.createservice.fix.createapiservice.ApiСontactServiceFactory;
import org.example.services.ContactService;
import org.example.services.implementation.contact.InMemoryContactService;

public class InMemoryContactServiceFactoryclass implements InMemoryContactServiceFactory{

    ApplicationGetPropertys applicationGetPropertys;

    public InMemoryContactServiceFactoryclass(ApplicationGetPropertys applicationGetPropertys) {
        this.applicationGetPropertys = applicationGetPropertys;
    }

    @Override
    public ContactService createService() {
        return new InMemoryContactService();
    }
}
