//package org.example.services.implementation.contact;
//
//
//import org.example.entity.ContactBuffers;
//import org.example.entity.ContactParser;
//import org.example.services.ContactService;
//
//import java.io.*;
//import java.nio.channels.FileChannel;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//
//public class CotactsNioServiceFile implements ContactService {
//    ContactParser contactParser = new ContactParser();
//    ContactBuffers contactBuffers = new ContactBuffers();
//    String inputFileName = "Phone book.txt";
//
//    @Override
//    public List<Contact> getAll() throws IOException {
//        List<Contact> allContacts = new LinkedList();
//        String contact;
//        String[] contacts = contactBuffers.getArraycontact();
//        for (String cont : contacts) {
//            Contact contact1 = contactParser.stringifyContact(cont);
//            allContacts.add(contact1);
//        }
//        return allContacts;
//    }
//
//    @Override
//    public void remove(Contact contact) throws IOException {
//        List<String> repository = getStrings(contact.name);
//        CleanFile();
//        PushFile(repository);
//    }
//
//
//    private void CleanFile() throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(inputFileName));
//        bw.write(" ");
//    }
//
//    private void PushFile(List<String> repository) throws IOException {
//        for (String s : repository) {
//
//            contactBuffers.writeContact(s);
//
//        }
//    }
//
//
//    private List<String> getStrings(String cont) throws IOException {
//        String string = cont;
//        String contacts = null;
//        List<String> repository = new ArrayList();
//        String[] contact = contactBuffers.getArraycontact();
//        for (String con : contact) {
//            if (con.contains(cont)) {
//                contacts = con;
//            } else {
//                repository.add(con);
//            }
//        }
//        return repository;
//    }
//
//    @Override
//    public void add(Contact contact) throws IOException {
//        String contacts = contactParser.stringifyContact(contact);
//        System.out.println(contact);
//        contactBuffers.writeContact(contacts);
//    }
//
//    @Override
//    public List<Contact> getContactsWhereNameStartsWith(String startOfName) throws IOException {
//        List<Contact> newcontacts = new LinkedList();
//        String contactsnames = startOfName;
//        String[] arraycontact = contactBuffers.getArraycontact();
//        List<Contact> contacts = GetListContact(arraycontact);
//        for (Contact contact : contacts) {
//            if (contact.name.startsWith(contactsnames)) {
//                newcontacts.add(contact);
//            }
//        }
//
//        return newcontacts;
//    }
//
//    @Override
//    public List<Contact> getPartsPhone(String phone) throws IOException {
//        List<Contact> newcontacts = new LinkedList();
//        String contactsnames = phone;
//        String[] arraycontact = contactBuffers.getArraycontact();
//        List<Contact> contacts = GetListContact(arraycontact);
//        for (Contact contact : contacts) {
//            if (contact.phone.contains(phone)) {
//                newcontacts.add(contact);
//            }
//        }
//
//        return newcontacts;
//    }
//
//    private List<Contact> GetListContact(String[] contacts) {
//        List<Contact> buffContact1 = new LinkedList();
//        List<Contact> buffContact2 = new LinkedList();
//        for (String cont : contacts) {
//            Contact newcontact = contactParser.stringifyContact(cont);
//            buffContact1.add(newcontact);
//        }
//        for (Contact contactss : buffContact1) {
//            if (contactss != null) {
//                buffContact2.add(contactss);
//            }
//        }
//        return buffContact2;
//    }
//
//    public boolean check(Contact contact) {
//        System.out.println(contact.phone);
//        return contact.phone.matches("\\+380\\d{9}");
//    }
//
//
//}
