/*
 *
 *  * @(#)Asset.java
 *  *
 *  * Copyright (c) 2018 Jala Foundation.
 *  * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  * All rights reserved.
 *  *
 *  * This software is the confidential and proprietary information of
 *  * Jala Foundation, ("Confidential Information").  You shall not
 *  * disclose such Confidential Information and shall use it only in
 *  * accordance with the terms of the license agreement you entered into
 *  * with Jala Foundation.
 *
 */
package com.fundation.search.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This is a class loggerWrapper capture activity of search.
 *
 * @author Estalin Yerel Hurtado Arias - AT - [07]
 * @version 1.0.
 */
public class LoggerWrapper {
    private static LoggerWrapper loggerWrapper;
    private Logger log;

    /**
     * get a log4j configure.
     */
    private LoggerWrapper() {
        log = Logger.getLogger("search");
        try {
            PropertyConfigurator.configure(new FileInputStream("config\\log4j.properties"));
        } catch (FileNotFoundException e) {

        }
    }

    /**
     * @return loggerWraper insstance.
     */
    public static LoggerWrapper getInstance() {
        if (loggerWrapper == null) {
            loggerWrapper = new LoggerWrapper();
        }
        return loggerWrapper;
    }

    /**
     * @return a log of Logger.
     */
    public Logger getLogger() {
        return log;
    }
}
