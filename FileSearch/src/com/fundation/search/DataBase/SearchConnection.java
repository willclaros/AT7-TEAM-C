package com.fundation.search.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchConnection {

    private static SearchConnection searchConnection;

    private static Connection connection;

    public SearchConnection() throws ClassNotFoundException, SQLException {
        initConnection();
    }
    private void initConnection() throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");

        connection = DriverManager.getConnection("jdbc:sqlite:search.db");

        Statement statement = connection.createStatement();
        String sqlQuery = "CREATE TABLE IF NOT EXISTS CRITERIA (ID INTEGER, CRITERIAJSON VARCHAR(400), PRIMARY KEY(ID))";

        statement.execute(sqlQuery);
    }

    public static SearchConnection getInstance() throws ClassNotFoundException, SQLException {
        if (searchConnection == null) {
            searchConnection = new SearchConnection();
        }
        return searchConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
