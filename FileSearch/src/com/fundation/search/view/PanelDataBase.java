/*
 * @(#)PanelSearchAdvanced.java
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

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Class that creates the data base search panel.
 * @author Erik Vargas - AT - [07]
 * @version 1.0.
 */
public class PanelDataBase extends JPanel {

    private JCheckBox checkDataBase;
    private JLabel labelPanelDataBase;
    private JLabel labelTypeMultimedia;
    private JTable table;
    private DefaultTableModel modelTable;
    private JScrollPane scroll;
    private JTextField writeExtensionMult;
    private JButton saveCriteriaButton;
    private JButton loadCriteriaButton;

    /**
     * Method that creates the data base search panel.
     */
    public PanelDataBase() {
        settingPanel();
        initComponent();
    }

    /**
     * Method that contains the data base Panel settings.
     */
    public void settingPanel() {
        setBorder(BorderFactory.createRaisedBevelBorder());
        setLayout(null);
        setVisible(true);
    }

    /**
     * Method that contains the components of the data base Panel.
     */
    public void initComponent() {

        labelPanelDataBase = new JLabel("DATA BASE");
        labelPanelDataBase.setBounds(190, 10, 130, 30);
        add(labelPanelDataBase);

        checkDataBase = new JCheckBox();
        checkDataBase.setBounds(260, 10, 30, 30);
        add(checkDataBase);

        labelTypeMultimedia = new JLabel("Criteria");
        labelTypeMultimedia.setBounds(20, 50, 100, 30);
        add(labelTypeMultimedia);
        labelTypeMultimedia.setEnabled(false);

        writeExtensionMult = new JTextField();
        writeExtensionMult.setBounds(90, 50, 230, 30);
        add(writeExtensionMult);
        writeExtensionMult.setEnabled(false);

        saveCriteriaButton = new JButton("Save");
        saveCriteriaButton.setHorizontalTextPosition( SwingConstants.CENTER );
        saveCriteriaButton.setVerticalTextPosition( SwingConstants.BOTTOM );
        saveCriteriaButton.setBounds(330, 50, 90, 30);
        add(saveCriteriaButton);
        saveCriteriaButton.setEnabled(false);

        String column[] = {"N°","DESCRIPTION"};
        modelTable = new DefaultTableModel(column, 0);
        table = new JTable(modelTable);
        int borderSpace = 8;
        scroll = new JScrollPane(table);
        scroll.setSize(400, 170);
        scroll.setLocation(20, 90);
        add(scroll);
        scroll.setEnabled(false);

        loadCriteriaButton = new JButton("LOAD");
        loadCriteriaButton.setHorizontalTextPosition( SwingConstants.CENTER );
        loadCriteriaButton.setVerticalTextPosition( SwingConstants.BOTTOM );
        loadCriteriaButton.setBounds(190, 284, 90, 30);
        add(loadCriteriaButton);
        loadCriteriaButton.setEnabled(false);

        // enable and disable options data base
        checkDataBase.addChangeListener(eve -> CheckBoxDataBase(eve));

    }

    /**
     * This method is for enable and disable chekbox of the options database.
     * @param event
     */
    public void CheckBoxDataBase(ChangeEvent event){
        if(checkDataBase.isSelected()){
            labelTypeMultimedia.setEnabled(true);
            writeExtensionMult.setEnabled(true);
            saveCriteriaButton.setEnabled(true);
            scroll.setEnabled(true);
            loadCriteriaButton.setEnabled(true);
        }else{
            labelTypeMultimedia.setEnabled(false);
            writeExtensionMult.setEnabled(false);
            saveCriteriaButton.setEnabled(false);
            scroll.setEnabled(false);
            loadCriteriaButton.setEnabled(false);
        }
    }

    /**
     * Method that returns an object of the JCheckBox class.
     * @return checkDataBase
     */
    public JCheckBox getCheckDataBase() {
        return checkDataBase;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JCheckBox class.
     * @param checkDataBase new object of the JCheckBox class.
     */
    public void setCheckDataBase(JCheckBox checkDataBase) {
        this.checkDataBase = checkDataBase;
    }

    /**
     * Method that returns an object of the JTable class.
     * @return a table.
     */
    public JTable getTable() {
        return table;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JTable class.
     * @param table new object of the JTable class.
     */
    public void setTable(JTable table) {
        this.table = table;
    }

    /**
     * Method that returns an object of the DefaultTableModel class.
     * @return modelTable.
     */
    public DefaultTableModel getModelTable() {
        return modelTable;
    }

    /**
     * Method that is responsible for modifying the value of the object of the DefaultTableModel class.
     * @param modelTable new object of the DefaultTableModel class.
     */
    public void setModelTable(DefaultTableModel modelTable) {
        this.modelTable = modelTable;
    }

    /**
     * Method that returns an object of the JTextField class.
     * @return writeExtensionMult.
     */
    public JTextField getWriteExtensionMult() {
        return writeExtensionMult;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JTextField class.
     * @param writeExtensionMult new object of the JTextField class.
     */
    public void setWriteExtensionMult(JTextField writeExtensionMult) {
        this.writeExtensionMult = writeExtensionMult;
    }

    /**
     * Method that returns an object of the JButton class.
     * @return saveCriteriaButton.
     */
    public JButton getSaveCriteriaButton() {
        return saveCriteriaButton;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JButton class.
     * @param saveCriteriaButton new object of the JButton class.
     */
    public void setSaveCriteriaButton(JButton saveCriteriaButton) {
        this.saveCriteriaButton = saveCriteriaButton;
    }

    /**
     * Method that returns an object of the JButton class.
     * @return loadCriteriaButton
     */
    public JButton getLoadCriteriaButton() {
        return loadCriteriaButton;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JButton class.
     * @param loadCriteriaButton new object of the JButton class.
     */
    public void setLoadCriteriaButton(JButton loadCriteriaButton) {
        this.loadCriteriaButton = loadCriteriaButton;
    }
}
