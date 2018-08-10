package com.fundation.search;

import com.fundation.search.DataBase.SearchConnection;
import com.fundation.search.controller.Controller;
import com.fundation.search.utils.LoggerWrapper;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LoggerWrapper.getInstance().getLogger();
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        LOGGER.info("Main: enter");
        Controller controller = new Controller();
        controller.init();
        SearchConnection connection = new SearchConnection();
        connection.getConnection();
        LOGGER.info("Main: exit");
    }
}
