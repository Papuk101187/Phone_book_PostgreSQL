package org.example.designpatterns.services.contacts;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.services.ContactService;
import org.example.services.UsersService;

import java.net.http.HttpClient;

public interface CreateContactsServiceFactory {


    public ContactService getContactServiceFile(String file);

    public ContactService getContactServiceApi(UsersService usersService,
                                               ObjectMapper objectMapper,
                                               HttpClient httpClient,
                                               String getBaseURLadd,
                                               String getBaseURLsearch,
                                               String getBaseURLget);


}
