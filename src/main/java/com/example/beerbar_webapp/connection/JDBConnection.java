package com.example.beerbar_webapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/social";
    private static final String JDBC_NAME = "root";
    private static final String JDBC_PASSWORD = "170299Artem_";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private Connection connection;

    public Connection getConnection() throws ClassNotFoundException {
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(JDBC_URL, JDBC_NAME, JDBC_PASSWORD);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
