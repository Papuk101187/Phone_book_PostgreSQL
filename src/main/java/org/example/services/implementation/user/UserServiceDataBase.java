package org.example.services.implementation.user;
import org.example.entity.User;
import org.example.services.ContactService;
import org.example.services.UsersService;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;


public class UserServiceDataBase implements UsersService {

    ContactService contactService;
    DataSource source;

    String userbas = "postgres";
    String password = "10n11m87g";
    String dsn = "jdbc:postgresql://localhost:5432/telefonbooks";

    String log = "";
    String pass = "";
    String born = "";


    @Override
    public String getToken() {
        return "КуКУУУУу";
    }

    @Override
    public String register(User user) throws IOException, InterruptedException, SQLException {
        Connection connection = DriverManager.getConnection(dsn, userbas, password);

        String sql = "INSERT INTO users (login_user, login_password, date_born) Values (?, ? ,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getDate_born());
        preparedStatement.executeUpdate();


        return "Контакт добавлен";
    }

    @Override
    public String login(User user) throws IOException, InterruptedException, SQLException {

        Connection connection = DriverManager.getConnection(dsn, userbas, password);

        PreparedStatement statement1 = connection.prepareStatement(
                "SELECT login_user,login_password,date_born FROM users WHERE login_user=?;");
        statement1.setString(1, user.getLogin());

        ResultSet resultSet = statement1.executeQuery();

        while (resultSet.next()) {
            log = resultSet.getString("login_user");
            pass = resultSet.getString("login_password");
            born = resultSet.getString("date_born");
        }
        if (log.equals(user.getLogin()) && pass.equals(user.getPassword()) && born.equals(user.getDate_born())) {
            return "контакт есть";
        } else {
            System.out.println("UserServiceDataBase.login");
            return null;
        }


    }


    @Override
    public String checkingService() {
        return "DataBaseContactService";
    }

}
