package org.labarranca.barrancapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:./cattle.db";

    public static Connection connect() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has benn established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
