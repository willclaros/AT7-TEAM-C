/**
 * @(#)Convert.java
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
/**
 * This class Validate can be FileResult, MultimediaResult and maybe SearchFolder.
 * @author Erik Vargas - AT-[07].
 * @version 1.0. 
 */
public class Convert {
	/**
	 * This is a date constant.
	 */
	private static final int SIZE = 1024;
	/**
	 * This is a convert of units.
	 * @param num is a size of a file.
	 * @param unid is a unit of measurement.
	 * @return a units in bytes.
	 */
	public long convertSize (long num, String unid){
		if(unid == "Gb"){
			num *=SIZE*SIZE*SIZE;
		}else{
			if(unid == "Mb"){
				num *=SIZE*SIZE;
			}
			num *= SIZE;
		}
		return num;
	}
}
