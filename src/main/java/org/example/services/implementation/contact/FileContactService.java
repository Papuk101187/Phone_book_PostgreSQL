package org.example.services.implementation.contact;

import org.example.entity.Contact;
import org.example.entity.ContactParser;
import org.example.entity.User;
import org.example.services.ContactService;
import org.example.services.UsersService;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileContactService implements ContactService {

    User user;


    public FileContactService(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    String inputFileName;
    ContactParser contactParser = new ContactParser();

    @Override
    public String add(Contact contact) {
        String string = contactParser.deserialization–°ontact(contact);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(inputFileName, true))) {
            bw.write(string + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Contact> searchContact(String name) throws IOException, InterruptedException {
        ArrayList<Contact> list = new ArrayList<>();

        String startOfNa = name;
        String contact;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            while ((contact = br.readLine()) != null) {

                if (contact.startsWith(startOfNa)) {
                    Contact contact1 = contactParser.deserialization–°ontact(contact);
                    list.add(contact1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public List<Contact> getAllcontact() throws IOException, InterruptedException {

        List<Contact> allContacts = new LinkedList();
        String contact;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            while ((contact = br.readLine()) != null) {
                Contact contact1 = contactParser.deserialization–°ontact(contact);
                allContacts.add(contact1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allContacts;
    }

    @Override
    public String checkingService() {
        return "FileContactService";
    }

    @Override
    public void setUser(User user, UsersService usersService) throws IOException, InterruptedException, SQLException {
        this.user=user;
    }


}
