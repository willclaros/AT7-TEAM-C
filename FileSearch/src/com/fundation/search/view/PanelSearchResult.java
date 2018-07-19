/*
 * @(#)PanelSearchResult.java
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

package com.fundation.search.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Panel that creates the display panel of search results.
 *
 * @author William Claros Revollo - AT - [07]
 * @version 1.0.
 */
public class PanelSearchResult extends JPanel {

    /**
     * Constructor that creates the display panel of search results.
     *
     */
    public PanelSearchResult() {
        this.setLayout(null);
        setBackground(Color.BLACK);
        String column[] = {"NAME", "EXT", "SIZE", "DATE"};
        String data[][] = {{"yerel", ".exe", "636", "28282"}, {"micho", ".exe", "636", "28282"}};
        JTable table = new JTable(data, column);
        int borderSpace = 8;
        JScrollPane scroll = new JScrollPane(table);
        scroll.setSize(1360, 330);
        scroll.setLocation(0, borderSpace);
        add(scroll);
    }
}
