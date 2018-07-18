/*
 * @(#)MainPanel.java
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

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Class that creates intermediate panels.
 *
 * @author William Claros Revollo - AT - [07]
 * @version 1.0
 */
public class MainPanel extends JPanel {

    /**
     * Constructor that creates the primary panels that will contain the search
     * panels.
     *
     * @param width  Parameters that we use to initialize the widths of the
     *               secondary panels.
     * @param height Parameters that we use to initialize the highs of the
     *               secondary panels.
     */
    public MainPanel(int width, int height) {
        setBounds(0, 0, width, height);
        int searchHeight = 490;
        int contentHeight = height - searchHeight;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel searchPanel = new PanelSearchBar(width, 500);
        JPanel contentPanel = new PanelSearchResult(width, contentHeight);
        add(searchPanel);
        add(contentPanel);
    }
}
