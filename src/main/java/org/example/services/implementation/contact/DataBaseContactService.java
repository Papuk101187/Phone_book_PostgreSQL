package org.example.services.implementation.contact;

import org.example.entity.Contact;
import org.example.entity.User;
import org.example.services.ContactService;
import org.example.services.UsersService;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseContactService implements ContactService {

    String userbas = "postgres";
    String password = "10n11m87g";
    String dsn = "jdbc:postgresql://localhost:5432/telefonbooks";
    UsersService usersService;
    User user;


    String nam = "";
    String valio = "";
    String typ = "";


    public String checkingService() {
        return "DataBaseContactService";
    }

    @Override
    public void setUser(User user) throws IOException, InterruptedException, SQLException {
        this.user = user;
    }


    public String add(Contact contact) throws IOException, InterruptedException, SQLException {

        Connection connection = DriverManager.getConnection(dsn, userbas, password);
        String sql = "INSERT INTO contacts (name_contact,type_contact,value_contact,id_user)" +
                " VALUES (?,?,?,(SELECT id_user FROM users WHERE login_user=?))";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, contact.getName());
        preparedStatement.setString(2, contact.getType());
        preparedStatement.setString(3, contact.getValue());
        preparedStatement.setString(4, user.getLogin());
        preparedStatement.executeUpdate();

        return "Контакт в базу данных добавлен";
    }


    public List<Contact> searchContact(String name) throws IOException, InterruptedException, SQLException {

        Connection connection = DriverManager.getConnection(dsn, userbas, password);
        ArrayList<Contact> contacts = new ArrayList<>();
        Contact contact = null;


        PreparedStatement statement1 = connection.prepareStatement(
                "SELECT name_contact , value_contact , type_contact  FROM contacts;");

        ResultSet resultSet = statement1.executeQuery();

        while (resultSet.next()) {
            if (name.equals(resultSet.getString("name_contact"))) {
                Contact contact1 = new Contact();
                contact1.setName(resultSet.getString("name_contact"));
                contact1.setValue(resultSet.getString("value_contact"));
                contact1.setType(resultSet.getString("type_contact"));
                contacts.add(contact1);
            }
        }


        return contacts;
    }


    public List<Contact> getAllcontact() throws IOException, InterruptedException, SQLException {

        Connection connection = DriverManager.getConnection(dsn, userbas, password);
        ArrayList<Contact> contacts = new ArrayList<>();
        Contact contact = null;


        PreparedStatement statement1 = connection.prepareStatement(
                "SELECT name_contact , value_contact , type_contact  FROM contacts;");

        ResultSet resultSet = statement1.executeQuery();

        while (resultSet.next()) {
            Contact contact1 = new Contact();
            contact1.setName(resultSet.getString("name_contact"));
            contact1.setValue(resultSet.getString("value_contact"));
            contact1.setType(resultSet.getString("type_contact"));
            contacts.add(contact1);
        }


        return contacts;

    }


}
