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

/**
 * Class that determines the size of the Frame.
 *
 * @author William Claros Revollo
 *
 */
public class SearchFrame extends JFrame {

    private JPanel panelGeneral;

    /**
     * Constructor to create the main Frame.
     */
    public SearchFrame() {
        super("File Search");
        settingMainFrame();
        initComponent();

    }

    private void settingMainFrame(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    private void initComponent(){
        panelGeneral = new MainPanel(1400, 700);
        this.setContentPane(panelGeneral);
    }

    /**
     * Main method to initialize the View.
     *
     * @param args
     *            argument.
     */
    public static void main(String[] args) {
        new SearchFrame();
    }

}
