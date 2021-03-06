package org.example.menu;
import org.example.entity.User;
import org.example.menu.points.AddContactMenuitem;
import org.example.menu.points.ExistMenuitem;
import org.example.menu.points.GetAllContactMenuitem;
import org.example.menu.points.SearchnameMenuitem;
import org.example.services.ContactService;
import org.example.services.UsersService;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookCOPY {

    List<MenuItem> lists = new ArrayList();
    ContactService contactService;
    User user;
    ArrayList<String> usersfordatabase = new ArrayList<>();
    UsersService usersService;
    String status;

    DataSource source;
    String userbas = "postgres";
    String password = "10n11m87g";
    String dsn = "jdbc:postgresql://localhost:5432/telefonbooks";




    public PhoneBookCOPY(ContactService contactService, UsersService usersService, User use) throws IOException, SQLException, InterruptedException {
        this.user = use;
        this.contactService = contactService;
        this.usersService = usersService;
        contactService.setUser(user, usersService);
        lists.add(new AddContactMenuitem(contactService));
        lists.add(new SearchnameMenuitem(contactService));
        lists.add(new GetAllContactMenuitem(contactService));
        lists.add(new ExistMenuitem(contactService));
    }

    private void showMenu() throws IOException, InterruptedException, SQLException {
        Menu menu = new Menu(lists);
        menu.starting();

    }

    private void runProgram() throws IOException, InterruptedException, SQLException {

        String service = contactService.checkingService();

        Connection connection = DriverManager.getConnection(dsn, userbas, password);


        while (true) {

            сheckservice(contactService.checkingService());


        }

    }

    private void сheckservice(String checkingService) throws InterruptedException, SQLException, IOException {

       switch (checkingService){
           case "ApiContactService": runServiceApi();
           break;
           case "DataBaseContactService":runServiceData();
           break;
       }

    }

    private void runServiceData() throws IOException, SQLException, InterruptedException {

        user = getDataUser(user);
        if (usersService.login(user) == null) {
            System.out.println("Логин отсутсвет");
            System.out.println("Просим ввести данные для регистрации");
            user = getDataUser(user);
            status = usersService.register(user);
            System.out.println(status);
        }
        {
            showMenu();
        }
    }

    private void runServiceApi() throws IOException, SQLException, InterruptedException {
        String status;
        user = getDataUser(user);
        if (usersService.login(user) == null) {
            System.out.println("Логин отсутсвует");
            System.out.println("Просим ввести данные для регистрации");
            user = getDataUser(user);
            status = usersService.register(user);
            System.out.println("status1 " + status);
            if (status.equals("error")) {
                int count = 0;
                String status1;
                while (true) {
                    System.out.println("------------------");
                    User user1 = getDataUser(new User());

                    status1 = usersService.register(user1);
                    System.out.println("status ==== " + status1);
                    if (status1 != "error") {
                        usersService.login(user1);
                        break;
                    }
                    count++;
                }
            }
            System.out.println(status);
        }
        {
            showMenu();
        }
    }





    private User getDataUser(User user) throws IOException {
        getText("Просим ввести данные :");
        String login;
        String password;
        String date;
        login = getLogin();
        password = getPassword();
        date = getDate();
        User us = user;

        us.setLogin(login);
        us.setPassword(password);
        us.setDate_born(date);
        return us;
    }

    private void getText(String s) {
        System.out.println(s);
    }

    private String getDate() throws IOException {
        System.out.println("Введите Вашу дату рождения в формате [yyyy-MM-dd] ");
        BufferedReader dat = new BufferedReader(new InputStreamReader(System.in));
        return dat.readLine();
    }

    private String getPassword() throws IOException {
        System.out.println("Введите password ");
        BufferedReader passw = new BufferedReader(new InputStreamReader(System.in)); //
        return passw.readLine();

    }

    private String getLogin() throws IOException {
        System.out.println("Введите login ");
        BufferedReader log = new BufferedReader(new InputStreamReader(System.in)); //
        return log.readLine();
    }

    public void start() throws IOException, InterruptedException, SQLException {
        runProgram();
    }
}
