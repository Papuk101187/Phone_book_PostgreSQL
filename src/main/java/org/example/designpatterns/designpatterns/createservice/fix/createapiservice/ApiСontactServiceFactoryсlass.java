package org.example.designpatterns.designpatterns.createservice.fix.createapiservice;

import lombok.Data;
import org.example.configuration.ConfigLoader;
import org.example.services.UsersService;

import java.util.Map;

@Data
public class ApiСontactServiceFactoryсlass implements ApiСontactServiceFactory {

    ConfigLoader configLoader;
    UsersService usersService;
    Map<String, Object> tools;

    @Override
    public ApiСontactServiceFactory createService() {

        return null;
    }



}
