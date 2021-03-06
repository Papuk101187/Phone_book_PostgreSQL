package org.example.menu;

import java.io.IOException;
import java.sql.SQLException;

public interface MenuItem {

    public void doAction() throws IOException, InterruptedException, SQLException;
    public String getName();
    public boolean closeAfter();


}
