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

import java.awt.Dimension;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 * Class that creates the advanced search panel.
 *
 * @author William Claros Revollo - AT - [07]
 * @version 1.0.
 */
public class PanelSearchAdvanced extends JPanel {

    private JLabel labelTypeFormat;
    private Vector<String> typeFormat;
    private JComboBox<String> type;
    private Vector<String> typeFile;
    private JComboBox<String> file;
    private JLabel labelFileSize;
    private Vector<String> typeCount;
    private JComboBox<String> count;
    private JSpinner sizeFile;
    private Vector<String> typeSize;
    private JComboBox sizeType;
    private JLabel labelHiddenFile;
    private JCheckBox hiddenFile;
    private JLabel labelOwner;
    private JTextField owner;
    private JLabel labelDateCreated;
    private JTextField dateCreated;
    private JLabel labelDateModificated;
    private JTextField dateModificated;
    private JLabel labelIntervalDate;
    private JTextField intervalDateInicio;
    private JTextField intervalDateEnd;
    private JLabel labelIntervalSymbol;
    private JLabel labelPanelAdvanced;

    /**
     * Method that creates the advanced search panel.
     */
    public PanelSearchAdvanced() {
        settingPanelAdvanced();
        initComponent();
    }

    /**
     * Method that contains the Advanced Panel settings.
     */
    public void settingPanelAdvanced() {
        setLayout(null);
        setBorder(BorderFactory.createRaisedBevelBorder());
    }

    /**
     * Method that contains the components of the Advanced Panel.
     */
    public void initComponent() {
        labelPanelAdvanced = new JLabel();
        labelPanelAdvanced.setText("SEARCH ADVANCED");
        labelPanelAdvanced.setBounds(30, 10, 130, 30);
        add(labelPanelAdvanced);
        labelTypeFormat = new JLabel();
        labelTypeFormat.setText("File Format");
        labelTypeFormat.setBounds(110, 50, 80, 30);
        add(labelTypeFormat);
        typeFormat = new Vector<String>();
        typeFormat.add("Multimedia");
        typeFormat.add("Images");
        typeFormat.add("Documents");
        typeFormat.add("Executable");
        type = new JComboBox<String>(typeFormat);
        type.setBounds(50, 80, 90, 30);
        add(type);
        labelFileSize = new JLabel();
        labelFileSize.setText("File Size");
        labelFileSize.setBounds(355, 50, 80, 30);
        add(labelFileSize);
        typeFile = new Vector<String>();
        typeFile.add("All");
        typeFile.add(".mp3");
        typeFile.add(".m4a");
        typeFile.add(".wma");
        typeFile.add("acc");
        file = new JComboBox<String>(typeFile);
        file.setBounds(150, 80, 90, 30);
        add(file);
        typeCount = new Vector<String>();
        typeCount.add(" < ");
        typeCount.add(" > ");
        typeCount.add(" = ");
        count = new JComboBox<String>(typeCount);
        count.setBounds(280, 80, 50, 30);
        add(count);

        sizeFile = new JSpinner();
        sizeFile.setBounds(340, 80, 70, 30);
        add(sizeFile);
        typeSize = new Vector<String>();
        typeSize.add("Byte");
        typeSize.add("KByte");
        typeSize.add("MByte");
        typeSize.add("GByte");
        sizeType = new JComboBox<String>(typeSize);
        sizeType.setBounds(420, 80, 70, 30);
        add(sizeType);

        labelHiddenFile = new JLabel();
        labelHiddenFile.setText("Hidden");
        labelHiddenFile.setBounds(520, 50, 50, 30);
        add(labelHiddenFile);
        hiddenFile = new JCheckBox();
        hiddenFile.setBounds(530, 80, 30, 30);
        add(hiddenFile);

        labelOwner = new JLabel();
        labelOwner.setText("Owner");
        labelOwner.setBounds(608, 50, 80, 30);
        add(labelOwner);
        owner = new JTextField();
        owner.setBounds(580, 80, 100, 30);
        add(owner);

        labelDateCreated = new JLabel();
        labelDateCreated.setText("Date Created");
        labelDateCreated.setBounds(80, 150, 110, 30);
        add(labelDateCreated);
        dateCreated = new JTextField();
        dateCreated.setBounds(60, 190, 110, 30);
        add(dateCreated);
        labelDateModificated = new JLabel();
        labelDateModificated.setText("Date Modificated");
        labelDateModificated.setBounds(227, 150, 100, 30);
        add(labelDateModificated);
        dateModificated = new JTextField();
        dateModificated.setBounds(220, 190, 110, 30);
        add(dateModificated);
        labelIntervalDate = new JLabel();
        labelIntervalDate.setText("Interval Date");
        labelIntervalDate.setBounds(480, 150, 100, 30);
        add(labelIntervalDate);
        intervalDateInicio = new JTextField();
        intervalDateInicio.setBounds(400, 190, 110, 30);
        add(intervalDateInicio);
        labelIntervalSymbol = new JLabel();
        labelIntervalSymbol.setText(" - ");
        labelIntervalSymbol.setBounds(514, 196, 10, 10);
        add(labelIntervalSymbol);
        intervalDateEnd = new JTextField();
        intervalDateEnd.setBounds(530, 190, 110, 30);
        add(intervalDateEnd);
    }

    /**
     * Method that returns an object of the JSpinner class.
     *
     * @return sizeFile an object of the JSpinner class.
     */
    public JSpinner getSizeFile() {
        return sizeFile;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JSpinner class.
     *
     * @param newSizeFile new object of the JSpinner class.
     */
    public void setSizeFile(JSpinner newSizeFile) {
        sizeFile = newSizeFile;
    }

    /**
     * Method that returns an object of the JCheckBox class.
     *
     * @return hiddenFile an object of the JCheckBox class.
     */
    public JCheckBox getHiddenFile() {
        return hiddenFile;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JCheckBox class.
     *
     * @param newHiddenFile new object of the JCheckBox class.
     */
    public void getHiddenFile(JCheckBox newHiddenFile) {
        hiddenFile = newHiddenFile;
    }

    /**
     * Method that returns an object of the JComboBox class.
     *
     * @return sizeType an object of the JComboBox class.
     */
    public JComboBox getSizeType() {
        return sizeType;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JComboBox class.
     *
     * @param newSizeType new object of the JComboBox class.
     */
    public void getSizeType(JComboBox newSizeType) {
        sizeType = newSizeType;
    }
}
