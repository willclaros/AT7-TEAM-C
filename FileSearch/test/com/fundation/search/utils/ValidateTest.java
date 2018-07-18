/**
 * @(#)ValidateTest.java
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

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * This class ValidateTest can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Erik Vargas - AT-[07].
 * @version 1.0.
 */
public class ValidateTest {
    private Validate test;

    /**
     * this is method ini.
     */
    @Before
    public void before(){
        test = new Validate();
    }

    /**
     * this is a method test validate is ValidatePath.
     */
    @Test
    public void isValidatePathTrue() {
        assertTrue(test.isValidatePath("C:\\Users\\Admin\\Desktop\\yoo\\AT7-TEAM-C\\src\\com\\fundation\\search\\testPath"));
    }

    /**
     * this is a method test validate is existPath.
     */
    @Test
    public void existPathTrue() {
        assertTrue(test.existPath("C:\\Users\\Admin\\Desktop\\yoo\\AT7-TEAM-C\\src\\com\\fundation\\search\\testPath"));
    }

    /**
     * this is a method test validate isEmpty.
     */
    @Test
    public void isEmpty() {
        assertTrue(test.isEmpty(""));
    }

    /**
     * this is a method test validate isNumber.
     */
    @Test
    public void isNumber() {
        assertTrue(test.isNumber("200"));
    }

    /**
     * this is a method test validate isPositive.
     */
    @Test
    public void isPositive() {
        assertTrue(test.isPositive("10"));
    }

    /**
     * this is a method test validate isDateFormat.
     */
    @Test
    public void isDateFormat() {
        assertTrue(test.isDateFormat("07/18/2018"));
    }

    /**
     * this is a method tes validate is Extention.
     */
    @Test
    public void isExtensions() {
        assertTrue(test.isExtensions(".Mp4"));
    }

    /**
     * this is a method test validate isSpace.
     */
    @Test
    public void isSpaces() {
        assertTrue(test.isSpaces(" "));
    }

    /**
     * this is a method test validate isStringSpaces.
     */
    @Test
    public void isStringSpaces() {
        assertTrue(test.isStringSpaces("   "));
    }

    /**
     * this is a method test validate isHidden.
     */
    @Test
    public void isHidden() {
        assertTrue(test.isHidden(1));
    }
}