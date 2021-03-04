package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.example.configuration.ConfigLoader;
import org.example.designpatterns.designpatterns.facade.ApplicationFasad;
import org.example.entity.User;
import org.example.menu.PhoneBook;
import org.example.services.ContactService;
import org.example.services.UsersService;
import org.example.services.implementation.database.Postgres;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, SQLException {

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


//        Connection connection = null;
//        PreparedStatement preparedStatement;
//        Postgres postgres = new Postgres();
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT name_user FROM users");
//
//        while (resultSet.next()){
//            System.out.println(resultSet.getString("name_user"));
//        }





    }
}
