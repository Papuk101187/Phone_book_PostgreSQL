package org.example.services.implementation.contact;

import org.example.entity.Contact;
import org.example.entity.ContactBuffers;
import org.example.entity.ContactParser;
import org.example.entity.User;
import org.example.services.ContactService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;


public class NioContactService implements ContactService {

    User user;

    ContactParser contactParser = new ContactParser();
    ContactBuffers contactBuffers = new ContactBuffers();
    String inputFileName = "Phone book.txt";


    @Override
    public String add(Contact contact) throws IOException, InterruptedException {
        System.out.println("CotactsNioServiceFileTEST.add");
        String contacts = contactParser.deserializationСontact(contact);
        contactBuffers.writeContact(contacts);
        return null;
    }

    @Override
    public List<Contact> searchContact(String name) throws IOException, InterruptedException {

        List<String> arraycontact = contactBuffers.getArraycontact();
        ArrayList<Contact> list = new ArrayList<>();

        for (String contact : arraycontact) {
            System.out.println(name);
            System.out.println(contact);
            System.out.println("------------");
            if (contact.startsWith(name)) {
                Contact contact1 = contactParser.deserializationСontact(contact);
                list.add(contact1);
            }
        }
        return list;
    }

    @Override
    public List<Contact> getAllcontact() throws IOException, InterruptedException {
        List<String> arraycontact = contactBuffers.getArraycontact();
        List<Contact> contacts = new ArrayList<>();

        for (String s : arraycontact) {
            Contact contact = contactParser.deserializationСontact(s);
            contacts.add(contact);
        }
        return contacts;

    }

    @Override
    public String checkingService() {
        return "NioContactService";
    }

    @Override
    public void setUser(User user) throws IOException, InterruptedException, SQLException {
        this.user=user;
    }


}
