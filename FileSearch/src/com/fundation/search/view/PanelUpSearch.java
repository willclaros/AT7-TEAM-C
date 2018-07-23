/*
 * @(#)PanelUpSearch.java
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
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Class that creates the basic search and advanced search panels.
 *
 * @author William Claros Revollo - AT - [07]
 * @version 1.0.
 */
public class PanelUpSearch extends JPanel {

    public PanelSearchBasic panelSearchBasic;
    public PanelSearchAdvanced panelSearchAdvanced;

    /**
     * Constructor that creates the primary panels that will contain the search panels.
     */
    public PanelUpSearch() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        panelSearchBasic = new PanelSearchBasic();
        panelSearchAdvanced = new PanelSearchAdvanced();
        this.add(panelSearchBasic);
        this.add(panelSearchAdvanced);
    }

    /**
     * Method that returns an object of the PanelSearchBasic class.
     *
     * @return panelSearchBasic an object of the PanelSearchBasic class.
     */
    public PanelSearchBasic getPanelSearchBasic() {
        return panelSearchBasic;
    }

    /**
     * Method that returns an object of the PanelSearchAdvanced class.
     *
     * @return panelSearchAdvanced an object of the PanelSearchAdvanced class.
     */
    public PanelSearchAdvanced getPanelSearchAdvanced() {
        return panelSearchAdvanced;
    }
}
