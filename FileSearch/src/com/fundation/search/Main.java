package com.fundation.search;

import com.fundation.search.controller.Controller;
import com.fundation.search.utils.LoggerWrapper;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LoggerWrapper.getInstance().getLogger();
    public static void main(String[] args) {
        LOGGER.info("Main: enter");
        Controller controller = new Controller();
        controller.init();
        LOGGER.info("Main: exit");
    }
}
