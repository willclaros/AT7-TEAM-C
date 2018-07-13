/**
 * @(#)Validate.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.fundation.search.utils;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * This class Asset can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Erik Vargas - AT-[07].
 * @version 1.0.
 */
public class Validate {
    /**
     * This is method validate a path.
     * @param path is a directory.
     * @return true if the path is correct.
     */
    public boolean isValidatePath(String path) {
        //String path = "C:\\Users\\Admin\\Desktop\\temas bug advocac";
        File file = new File(path);
        return file.isDirectory();
    }
    /**
     * This is method validate a path.
     * @param path is a directory.
     * @return true if the path is correct.
     */
    public boolean isValidateExistPath(String path){
        File file = new File(path);
        return file.exists();
    }
    /**
     * This is method validate a size.
     * @param number is a directory.
     * @return true if the path is correct.
     */
    public boolean isNumber(String number){
        try{
            Integer.parseInt(number);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    /**
     * This is method validate a size major that ciro.
     * @param number is a directory.
     * @return true if the path is correct.
     */
    public boolean isPositive(String number){
        try{
            return Integer.parseInt(number) > 0;
        }catch(NumberFormatException e){
            return false;
        }
    }
    /**
     * This is method that validate format.
     * @param date
     * @return
     */
    public boolean isDateFormat(String date){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            dateFormat.setLenient(false);
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
