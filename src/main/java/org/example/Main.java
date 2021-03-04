package org.example;

import org.example.configuration.ConfigLoader;
import org.example.designpatterns.designpatterns.facade.ApplicationFasad;
import org.example.entity.User;
import org.example.menu.PhoneBook;
import org.example.services.ContactService;
import org.example.services.UsersService;

import java.io.IOException;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

//        ApplicationFasad applicationFasad = new ApplicationFasad(); // создали фасад под капотом
//        // которого у нас находятся фабрики , которые создают наши сервиса ContactService и UsersService
//        applicationFasad.createConfiguration(); // создаём конфигурации из файла внутри фасада
//        applicationFasad.createServices(); // создаём сервиса с помощью наших фабрик внутри фасада
//
//        ContactService contactService = applicationFasad.getContactService(); // забираем уже готовый
//        //сервис для работы с контактами
//        UsersService usersService = applicationFasad.getUsersService();// забираем уже готовый
//        //сервис для работы с users
//
//        PhoneBook phoneBook = new PhoneBook(contactService, usersService, new User());
//        // добавляем их в нашу телефонную книгу
//        phoneBook.start();
//        //запускаем нашу книгу


        String USER = "postgres";
        String PASSWORD = "10n11m87g";
        String DSN = "jdbc:postgresql://localhost:5432/books";


        try (Connection connection = DriverManager.getConnection(DSN, USER, PASSWORD)) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(" SELECT name_book FROM books");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name_book"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
