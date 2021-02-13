package org.example.designpatterns.services.contacts;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.example.services.UsersService;

import java.io.File;
import java.net.http.HttpClient;

public interface CreateContactsServiceFactory {


    public void SetFile(File file);

    public void SetURI(UsersService usersService,
                       ObjectMapper objectMapper,
                       HttpClient httpClient,
                       String getBaseURLadd,
                       String getBaseURLsearch,
                       String getBaseURLget);

}
