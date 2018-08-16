package com.fundation.search.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchQuery {

    private Connection connection;

    public SearchQuery() throws SQLException, ClassNotFoundException {
        connection = SearchConnection.getInstance().getConnection();
    }

    public String insertCriteria(String criteriaJSon) {
        try {
            String insertQuery = "insert into criteria values(?,?);";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(2, criteriaJSon);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error Connection";
        }
        return "Success Connection";
    }


    ResultSet resultSet = null;
    public ResultSet getAllCriteria() {
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("select id,criteriajson from criteria");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
