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
 * @author William Claros Revollo
 */
public class PanelSearchResult extends JPanel {

    /**
     * Constructor that creates the display panel of search results.
     *
     * @param width  Parameters to create the results panel, the width.
     * @param height Parameters to create the results panel, the height.
     */
    public PanelSearchResult(int width, int height) {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(width, height));
        this.setSize(new Dimension(width, height));
        this.setBackground(new Color(0, 0, 81, 90));
        String data[][] = {};
        String column[] = {"NAME", "EXT", "SIZE", "DATE"};
        JTable table = new JTable(data, column);
        int borderSpace = 5;

        table.setSize(width, 700);

        this.add(table);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setSize(width - (borderSpace * 2), height);
        scroll.setLocation(0, borderSpace);
        ;
        add(scroll);

    }
}

