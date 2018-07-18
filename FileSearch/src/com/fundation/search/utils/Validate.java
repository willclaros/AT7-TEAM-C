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
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This class Validate can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Erik Vargas - AT-[07].
 * @version 1.0.
 */
public class Validate {

	/**
	 * This is method validate a path.
	 * 
	 * @param path is a directory.
	 * @return true if the path is correct.
	 */
	public boolean isValidatePath(String path) {
		File file = new File(path);
		return file.isDirectory();
	}

	/**
	 * This is method validate a exits path.
	 * 
	 * @param path is a directory.
	 * @return true if the path exits.
	 */
	public boolean existPath(String path) {
		File file = new File(path);
		return file.exists();
	}

	/**
	 * This is method validate a path empty.
	 * 
	 * @param path is a directory.
	 * @return true if the path is empty.
	 */
	public boolean isEmpty(String path) {
		return path.isEmpty();
	}

	/**
	 * This is method validate a size.
	 * 
	 * @param size is a directory.
	 * @return true if the path is correct.
	 */
	public boolean isNumber(String size) {
		try {
			Integer.parseInt(size);
			return true;
		} catch (NumberFormatException e) {
			e.getMessage();
			return false;
		}
	}

	/**
	 * This is method validate a size is positive.
	 * 
	 * @param size of a file.
	 * @return true if the size is positive.
	 */
	public boolean isPositive(String size) {
		try {
			return Integer.parseInt(size) > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * This is method that validate format.
	 * 
	 * @param date is a string date.
	 * @return a string data format. 
	 */
	public boolean isDateFormat(String date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateFormat.setLenient(false);
			dateFormat.parse(date);
		} catch (ParseException e) {
			e.getMessage();
			return false;
		}
		return true;
	}
	
	/**
	 * This method is for validate extentions file
	 * @param extensions validate.
	 * @return a string of the content type.
	 */
	public boolean isExtensions(String extensions) {
		File file = new File(extensions);
		try {
			Files.probeContentType(file.toPath());
			return true;
		} catch (IOException e) {
			e.getMessage();
			return false;
		}
	}

	/**
	 * This is method that validate a spaces string.
	 * 
	 * @param filename is a string with filename.
	 * @return true if is a spaces string.
	 */
	public boolean isSpaces(String filename) {
		return filename.trim().length() == 0;
	}

	/**
	 * This is method that validate a spaces in a string.
	 * 
	 * @param filename is a string with filename.
	 * @return true if exits spaces in the filename.
	 */
	public boolean isStringSpaces(String filename) {
		int con = 0;
		for (int i = 0; i < filename.length(); i++) {
			if (filename.charAt(i) == ' ') {
				con++;
			}
		}
		return con > 0;
	}
	
	/**
	 * This method for hidden selected.
	 * @param hidden is a flag 1 or 0.
	 * @return true if hidden selected. 
	 */
	public boolean isHidden(int hidden){
		return hidden == 1;
	}

}
