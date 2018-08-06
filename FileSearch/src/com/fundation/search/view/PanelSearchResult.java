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

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


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
        //setBackground(Color.BLACK);
    }

    /**
     * Method that contains the components of the PanelSearchResult.
     */
    public void initComponent() {
        String column[] = {"NAME", "EXT", "SIZE", "HIDDEN", "OWNER", "PATH","TYPE", "DATE CREATED", "DATE MODIFICATED", "ACCESS DATE"};
        modelTable = new DefaultTableModel(column, 0);
        table = new JTable(modelTable);
        //String data[][] = {};
        //table = new JTable(data, column);
        int borderSpace = 8;
        scroll = new JScrollPane(table);
        scroll.setSize(1350, 330);
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


    /**
     * Method that adds to the table.
     * @param path  of the file.
     * @param fileName of the file.
     * @param fileType of the file.
     * @param fileSize of the file.
     * @param fileHidden of the file.
     * @param owner of the file.
     * @param type of the file.
     * @param fecha1 of the file.
     * @param fecha2 of the file.
     * @param fecha3 of the file.
     * @param readOnly of the file.
     */
    public void addRowTable(String path, String fileName, String fileType, long fileSize, String fileHidden, String owner, String type, String fecha1, String fecha2, String fecha3, boolean readOnly) {
        modelTable.addRow(new String[]{fileName, fileType, String.valueOf(fileSize), path, fileHidden, owner,null,null,null,null,String.valueOf(readOnly)});

    }

    /**
     * Method to clean the table.
     */
    public void cleanTable() {
        modelTable.setNumRows(0);
    }

    /**
     * Method that returns the table.
     * @return returns a defaultModelTable.
     */
    public DefaultTableModel getModelTable() {
        return modelTable;
    }


    /**
     * Method that set a defaultModelTable.
     * @param modelTable set a defaultModelTable.
     */
    public void setModelTable(DefaultTableModel modelTable) {
        this.modelTable = modelTable;
    }
}
