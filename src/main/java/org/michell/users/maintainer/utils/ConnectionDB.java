package org.michell.users.maintainer.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static String username = "root";
    private static String password = "sasa";
    private static String url = "jdbc:mysql://localhost:3306/java_haru?serverTimezone=America/Bogota";

    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(url, username, password);

    }
}
