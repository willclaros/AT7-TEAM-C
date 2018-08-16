/*
 * @(#)View.java
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
public class View extends JFrame {

    private final Dimension dim = getToolkit().getScreenSize();
    public MainPanel panelGeneral;

    /**
     * Constructor to create the main Frame.
     */
    public View() {
        initComponent();
        settingMainFrame();
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
    public void initComponent() {
        panelGeneral = new MainPanel(dim);
        panelGeneral.setSize(dim);
        add(panelGeneral);
    }

    /**
     * Method that returns an object of the MainPanel class.
     *
     * @return panelGeneral that is an object of the MainPanel class.
     */
    public MainPanel getPanelGeneral() {
        return panelGeneral;
    }
}
