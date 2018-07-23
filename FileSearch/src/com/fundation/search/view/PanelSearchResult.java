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

    private JTable table;
    private JScrollPane scroll;

    /**
     * Constructor that creates the display panel of search results.
     */
    public PanelSearchResult() {
        initComponent();
        settingPanelSearchResult();
    }

    /**
     * General settings of the Panel.
     */
    private void settingPanelSearchResult() {
        setLayout(null);
        setBackground(Color.BLACK);
    }

    /**
     * Method that contains the components of the PanelSearchResult.
     */
    public void initComponent() {
        String column[] = {"NAME", "EXT", "SIZE", "PATH"};
        String data[][] = {{"yerel", ".exe", "636", "https:\\"}, {"micho", ".exe", "636", "https:\\"}};
        table = new JTable(data, column);
        add(table);
        int borderSpace = 8;
        scroll = new JScrollPane(table);
        scroll.setSize(1360, 330);
        scroll.setLocation(0, borderSpace);
        add(scroll);
    }

    /**
     * Method that returns an object of the JTable class.
     *
     * @return table an object of the JTable class.
     */
    public JTable getTable() {
        return table;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JTable class.
     *
     * @param newTable new object of the JTable class.
     */
    public void setTable(JTable newTable) {
        table = newTable;
    }

    /**
     * Method that returns an object of the JScrollPane class.
     *
     * @return scroll an object of the JScrollPane class.
     */
    public JScrollPane getScroll() {
        return scroll;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JScrollPane class.
     *
     * @param newScroll new object of the JScrollPane class.
     */
    public void setScroll(JScrollPane newScroll) {
        scroll = newScroll;
    }
}
