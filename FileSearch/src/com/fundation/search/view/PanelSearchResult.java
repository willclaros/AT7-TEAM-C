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

import com.fundation.search.model.AssetFile;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;


/**
 * Panel that creates the display panel of search results.
 *
 * @author William Claros Revollo - AT - [07]
 * @version 1.0.
 */
public class PanelSearchResult extends JPanel {

    private JTable table;
    private DefaultTableModel modelTable;

    private JScrollPane scroll;
    private PanelUpSearch panelUpSearch;

    /**
     * Constructor that creates the display panel of search results.
     */
    public PanelSearchResult() {
        initComponent();
        settingPanelSearchResult();
    }

    public PanelSearchResult(PanelUpSearch panelUpSearch) {
        initComponent();
        settingPanelSearchResult();
        this.panelUpSearch = panelUpSearch;
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
        String column[] = {"NAME", "EXT", "SIZE", "PATH", "HIDDEN", "OWNER", "TYPE", "DATE CREATED", "DATE MODIFICATED", "ACCESS DATE", "READ ONLY", "KEY SENSITIVE"};
        modelTable = new DefaultTableModel(column, 0);
        table = new JTable(modelTable);
        //String data[][] = {};
        //table = new JTable(data, column);
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


    public void addRowTable(String path, String fileName, String fileType, long fileSize, String fileHidden, String owner) {
        modelTable.addRow(new String[]{path, fileName, fileType, String.valueOf(fileSize), fileHidden, owner});
    }

    public void cleanTable(){
        modelTable.setNumRows(0);
    }

    public DefaultTableModel getModelTable() {
        return modelTable;
    }

    public void setModelTable(DefaultTableModel modelTable) {
        this.modelTable = modelTable;
    }
}
