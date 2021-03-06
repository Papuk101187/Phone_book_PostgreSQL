package org.example.services;

import org.example.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UsersService {

    String getToken();
    String register(User user) throws IOException, InterruptedException, SQLException;
    String login(User user) throws IOException, InterruptedException, SQLException;
    public String checkingService();

}
