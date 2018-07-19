/*
 * @(#)SearchFrame.java
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

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;

/**
 * Class that determines the size of the Frame.
 *
 * @author William Claros Revollo - AT - [07]
 * @version 1.0.
 */
public class SearchFrame extends JFrame {

    private final Dimension dim = getToolkit().getScreenSize();
    private JPanel panelGeneral;

    /**
     * Constructor to create the main Frame.
     */
    public SearchFrame() {
        settingMainFrame();
        initComponent();
    }

    /**
     * General settings of the Frame.
     */
    private void settingMainFrame() {
        setTitle("File Search");
        setSize(dim);
        setUndecorated(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * General configurations of the main panel that will contain the other panels.
     */
    private void initComponent() {
        panelGeneral = new MainPanel(dim);
        panelGeneral.setBackground(Color.GREEN);
        panelGeneral.setSize(dim);
        add(panelGeneral);
    }

    /**
     * Main method to initialize the View.
     *
     * @param args argument that we use by default when we use a main method.
     */
    public static void main(String[] args) {
        new SearchFrame();
    }
}
