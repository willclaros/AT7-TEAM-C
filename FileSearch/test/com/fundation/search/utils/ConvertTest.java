/**
 * @(#)ConvertTest.java
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

import static org.junit.Assert.*;

/**
 * This class ConvertTest can be FileResult, MultimediaResult and maybe SearchFolder.
 * @author Erik Vargas - AT-[07].
 * @version 1.0.
 */
public class ConvertTest {
    private Convert test;
    @Before
    /**
     * this is method ini.
     */
    public void before(){
        test = new Convert();
    }

    /**
     * this is method for convert files size.
     */
    @Test
    public void convertSize() {
        assertEquals(51200,test.convertSize(50,"kb"));
    }
}