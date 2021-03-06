package org.example.services;

import org.example.entity.Contact;
import org.example.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ContactService {

    String add (Contact contact) throws IOException, InterruptedException, SQLException;
    List<Contact> searchContact(String name)throws IOException, InterruptedException;
    List<Contact> getAllcontact() throws IOException, InterruptedException;
    public String checkingService();
    void setUser (User user) throws IOException, InterruptedException, SQLException;


}
