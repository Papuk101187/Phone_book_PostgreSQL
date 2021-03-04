package org.example.services.implementation.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class Postgres {


    public Statement getStatement() {
        return statement;
    }

    Statement statement;
    Connection connection;
    DataSource source;
    String USER = "postgres";
    String PASSWORD = "10n11m87g";
    String DSN = "jdbc:postgresql://localhost:5432/telefonbooks";
    HikariConfig config = new HikariConfig();

    public void create () throws SQLException {
        config.setJdbcUrl(DSN);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        source = new HikariDataSource(config);
        connection = source.getConnection();
        statement = connection.createStatement();
    }












//
//        try (Connection connection = DriverManager.getConnection(DSN, USER, PASSWORD)) {
//
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(" SELECT name_book FROM books");
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("name_book"));
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }




}
