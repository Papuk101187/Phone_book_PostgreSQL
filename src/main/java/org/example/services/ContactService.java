package org.example.services;

import org.example.entity.Contact;
import org.example.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ContactService {

    String add (Contact contact) throws IOException, InterruptedException, SQLException;
    List<Contact> searchContact(String name) throws IOException, InterruptedException, SQLException;
    List<Contact> getAllcontact() throws IOException, InterruptedException, SQLException;
    public String checkingService();
    void setUser(User user, UsersService usersService) throws IOException, InterruptedException, SQLException;


}
