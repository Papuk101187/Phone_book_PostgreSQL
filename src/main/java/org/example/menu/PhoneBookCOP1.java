//package org.example.menu;
//import org.example.entity.User;
//import org.example.menu.points.AddContactMenuitem;
//import org.example.menu.points.ExistMenuitem;
//import org.example.menu.points.GetAllContactMenuitem;
//import org.example.menu.points.SearchnameMenuitem;
//import org.example.services.ContactService;
//import org.example.services.UsersServiceApi;
//
//import javax.sql.DataSource;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class PhoneBookCOP1 {
//
//
//    List<MenuItem> lists = new ArrayList();
//    ContactService contactService;
//    UsersServiceApi usersServiceApi;
//    User user;
//    ArrayList<String> usersfordatabase = new ArrayList<>();
//
//    DataSource source;
//    String userbas = "postgres";
//    String password = "10n11m87g";
//    String dsn = "jdbc:postgresql://localhost:5432/telefonbooks";
//
//
//
//    public PhoneBookCOP1(ContactService contactServ, UsersServiceApi usersServiceApi, User use) throws IOException, SQLException {
//        this.user = use;
//        this.contactService = contactServ;
//        this.usersServiceApi = usersServiceApi;
//        lists.add(new AddContactMenuitem(contactService));
//        lists.add(new SearchnameMenuitem(contactService));
//        lists.add(new GetAllContactMenuitem(contactService));
//        lists.add(new ExistMenuitem(contactService));
//    }
//
//    private void showMenu() throws IOException, InterruptedException {
//        Menu menu = new Menu(lists);
//        menu.starting();
//
//    }
//
//
//    private void runProgram() throws IOException, InterruptedException, SQLException {
//
//        user = getDataUser(user);
//        Connection connection = DriverManager.getConnection(dsn, userbas, password);
//
//
//
//        while (true) {
//
//            String login = null;
//            String password = null;
//            String databorn = null;
//
//            if (contactService.checkingService() == "DataBaseContactService") {
//
//                PreparedStatement statement1 = connection.prepareStatement(
//                        "SELECT login_user,login_password,date_born FROM users WHERE login_user=?;");
//                statement1.setString(1, user.getLogin());
//
//                ResultSet resultSet = statement1.executeQuery();
//
//                while (resultSet.next()) {
//                    login = resultSet.getString("login_user");
//                    password = resultSet.getString("login_password");
//                    databorn = resultSet.getString("date_born");
//                }
//                if (login.equals(user.getLogin()) && password.equals(user.getPassword()) && databorn.equals(user.getDate_born())) {
//                    System.out.println("Данные совпадают");
//                } else {
//                    String sql = "INSERT INTO users (login_user, login_password, date_born) Values (?, ? ,?)";
//                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                    preparedStatement.setString(1, user.getLogin());
//                    preparedStatement.setString(2, user.getPassword());
//                    preparedStatement.setString(3, user.getDate_born());
//                    preparedStatement.executeUpdate();
//                    break;
//                }
//
//
//        }
//
//    }}
//
//
//    private User getDataUser(User user) throws IOException {
//        getText("Просим ввести данные аккаунта");
//        String login;
//        String password;
//        String date;
//        login = getLogin();
//        password = getPassword();
//        date = getDate();
//        User us = user;
//
//        us.setLogin(login);
//        us.setPassword(password);
//        us.setDate_born(date);
//        return us;
//    }
//
//    private void getText(String s) {
//        System.out.println(s);
//    }
//
//    private String getDate() throws IOException {
//        System.out.println("Введите Вашу дату рождения в формате [yyyy-MM-dd] ");
//        BufferedReader dat = new BufferedReader(new InputStreamReader(System.in));
//        return dat.readLine();
//    }
//
//    private String getPassword() throws IOException {
//        System.out.println("Введите password ");
//        BufferedReader passw = new BufferedReader(new InputStreamReader(System.in)); //
//        return passw.readLine();
//
//    }
//
//    private String getLogin() throws IOException {
//        System.out.println("Введите login ");
//        BufferedReader log = new BufferedReader(new InputStreamReader(System.in)); //
//        return log.readLine();
//    }
//
//    public void start() throws IOException, InterruptedException, SQLException {
//        runProgram();
//    }
//}
