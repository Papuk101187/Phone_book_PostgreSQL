package org.example.services.implementation.contact;

import org.example.entity.Contact;
import org.example.entity.User;
import org.example.services.ContactService;
import org.example.services.UsersService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DataBaseContactService implements ContactService {

    String userbas = "postgres";
    String password = "10n11m87g";
    String dsn = "jdbc:postgresql://localhost:5432/telefonbooks";
    UsersService usersService;
    User user;


    public String checkingService() {
        return "DataBaseContactService";
    }

    @Override
    public void setUser(User user) throws IOException, InterruptedException, SQLException {
        this.user=user;
    }


    public String add(Contact contact) throws IOException, InterruptedException, SQLException {

        Connection connection = DriverManager.getConnection(dsn, userbas, password);
        String sql = "INSERT INTO contacts (name_contact,type_contact,value_contact,id_user)" +
                " VALUES ('Contact№1 ','Email','oleg.privatbank.ua',(SELECT id_user FROM users WHERE login_user=?))";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.executeUpdate();

        return "Контакт в базу данных добавлен";
    }


    public List<Contact> searchContact(String name) throws IOException, InterruptedException {


        System.out.println("DataBaseContactService.searchContact");
        return null;
    }


    public List<Contact> getAllcontact() throws IOException, InterruptedException {
        System.out.println("DataBaseContactService.getAllcontact");

        return null;

    }


}
