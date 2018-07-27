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

import com.toedter.calendar.JDateChooser;

import java.awt.Dimension;
import java.util.Vector;
import javax.swing.*;

/**
 * Class that creates the advanced search panel.
 *
 * @author William Claros Revollo - AT - [07]
 * @version 1.0.
 */
public class PanelSearchAdvanced extends JPanel {

    private JLabel labelTypeMultimedia;
    private JCheckBox multimedia;
    private JTextField writeExtensionMult;

    private Vector<String> typeFormat;
    private JComboBox<String> type;


    private Vector<String> typeFile;
    private JComboBox<String> fileType;
    private JLabel labelFileSize;
    private Vector<String> typeCount;
    private JComboBox<String> count;
    private JSpinner sizeFile;
    private Vector<String> typeSize;
    private JComboBox sizeType;
    private JLabel labelOwner;
    private JTextField owner;
    private JLabel labelDateCreated;
    private JLabel labelDateModificated;

    private JLabel labelIntervalDate;

    private JLabel labelIntervalSymbol;
    private JLabel labelPanelAdvanced;

    private JDateChooser dateChoserCreateIni;
    private JDateChooser dateChooserCreateEnd;
    private JDateChooser dateChooserModifyIni;
    private JDateChooser dateChooserModifyEnd;
    private JDateChooser dateChooserAccessedIni;
    private JDateChooser dateChooserAccessedEnd;

    private JCheckBox datecreated;
    private JCheckBox datemodificate;
    private JCheckBox accessDate;

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

        labelTypeMultimedia = new JLabel();
        labelTypeMultimedia.setText("Multimedia");
        labelTypeMultimedia.setBounds(50, 50, 80, 30);
        add(labelTypeMultimedia);

        multimedia = new JCheckBox();
        multimedia.setBounds(120, 50, 30, 30);
        add(multimedia);
        writeExtensionMult = new JTextField();
        writeExtensionMult.setBounds(20, 80, 70, 30);
        add(writeExtensionMult);
        typeFormat = new Vector<String>();
        typeFormat.add("Mp3");
        typeFormat.add("Mp4");
        typeFormat.add("Mpeg");
        type = new JComboBox<String>(typeFormat);
        type.setBounds(100, 80, 60, 30);
        add(type);


        labelFileSize = new JLabel();
        labelFileSize.setText("Duration");
        labelFileSize.setBounds(270, 50, 80, 30);
        add(labelFileSize);

        typeCount = new Vector<String>();
        typeCount.add(" < ");
        typeCount.add(" > ");
        typeCount.add(" = ");
        count = new JComboBox<String>(typeCount);
        count.setBounds(200, 80, 50, 30);
        add(count);

        sizeFile = new JSpinner();
        sizeFile.setBounds(260, 80, 70, 30);
        add(sizeFile);
        typeSize = new Vector<String>();
        typeSize.add("Hora");
        typeSize.add("Minutes");
        typeSize.add("Seconds");
        sizeType = new JComboBox<String>(typeSize);
        sizeType.setBounds(340, 80, 70, 30);
        add(sizeType);

        labelOwner = new JLabel();
        labelOwner.setText("Owner");
        labelOwner.setBounds(540, 50, 80, 30);
        add(labelOwner);
        owner = new JTextField();
        owner.setBounds(510, 80, 100, 30);
        add(owner);

        labelDateCreated = new JLabel();
        labelDateCreated.setText("Date Created");
        labelDateCreated.setBounds(100, 250, 110, 30);
        add(labelDateCreated);

        datecreated = new JCheckBox();
        datecreated.setBounds(180, 250, 30, 30);
        add(datecreated);

        dateChoserCreateIni = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChoserCreateIni.setBounds(60,290,90,30);
        add(dateChoserCreateIni);
        dateChooserCreateEnd = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChooserCreateEnd.setBounds(160,290,90,30);
        add(dateChooserCreateEnd);


        labelDateModificated = new JLabel();
        labelDateModificated.setText("Date Modificated");
        labelDateModificated.setBounds(290, 250, 100, 30);
        add(labelDateModificated);

        datemodificate = new JCheckBox();
        datemodificate.setBounds(390, 250, 30, 30);
        add(datemodificate);

        dateChooserModifyIni = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChooserModifyIni.setBounds(270,290,90,30);
        add(dateChooserModifyIni);
        dateChooserModifyEnd = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChooserModifyEnd.setBounds(370,290,90,30);
        add(dateChooserModifyEnd);
        labelIntervalDate = new JLabel();
        labelIntervalDate.setText("Accessed Date");
        labelIntervalDate.setBounds(520, 250, 100, 30);

        accessDate = new JCheckBox();
        accessDate.setBounds(610, 250, 30, 30);
        add(accessDate);

        add(labelIntervalDate);
        dateChooserAccessedIni = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChooserAccessedIni.setBounds(480,290,90,30);
        add(dateChooserAccessedIni);
        labelIntervalSymbol = new JLabel();
        labelIntervalSymbol.setText(" - ");
        labelIntervalSymbol.setBounds(514, 290, 10, 10);
        add(labelIntervalSymbol);
        dateChooserAccessedEnd = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChooserAccessedEnd.setBounds(580,290,90,30);
        add(dateChooserAccessedEnd);
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
    public void setSizeType(JComboBox newSizeType) {
        sizeType = newSizeType;
    }

    /**
     * Method that returns an object of the JComboBox class.
     *
     * @return sizeType an object of the JComboBox class.
     */
    public JComboBox getFileType() {
        return fileType;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JComboBox class.
     *
     * @param newFile new object of the JComboBox class.
     */
    public void setFileType(JComboBox newFile) {
        fileType = newFile;
    }

    public JDateChooser getDateChoserCreateIni() {
        return dateChoserCreateIni;
    }

    public void setDateChoserCreateIni(JDateChooser dateChoserCreateIni) {
        this.dateChoserCreateIni = dateChoserCreateIni;
    }

    public JDateChooser getDateChooserCreateEnd() {
        return dateChooserCreateEnd;
    }

    public void setDateChooserCreateEnd(JDateChooser dateChooserCreateEnd) {
        this.dateChooserCreateEnd = dateChooserCreateEnd;
    }

    public JDateChooser getDateChooserModifyIni() {
        return dateChooserModifyIni;
    }

    public void setDateChooserModifyIni(JDateChooser dateChooserModifyIni) {
        this.dateChooserModifyIni = dateChooserModifyIni;
    }

    public JDateChooser getDateChooserModifyEnd() {
        return dateChooserModifyEnd;
    }

    public void setDateChooserModifyEnd(JDateChooser dateChooserModifyEnd) {
        this.dateChooserModifyEnd = dateChooserModifyEnd;
    }

    public JDateChooser getDateChooserAccessedIni() {
        return dateChooserAccessedIni;
    }

    public void setDateChooserAccessedIni(JDateChooser dateChooserAccessedIni) {
        this.dateChooserAccessedIni = dateChooserAccessedIni;
    }

    public JDateChooser getDateChooserAccessedEnd() {
        return dateChooserAccessedEnd;
    }

    public void setDateChooserAccessedEnd(JDateChooser dateChooserAccessedEnd) {
        this.dateChooserAccessedEnd = dateChooserAccessedEnd;
    }

    public JCheckBox getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(JCheckBox datecreated) {
        this.datecreated = datecreated;
    }

    public JCheckBox getDatemodificate() {
        return datemodificate;
    }

    public void setDatemodificate(JCheckBox datemodificate) {
        this.datemodificate = datemodificate;
    }

    public JCheckBox getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(JCheckBox accessDate) {
        this.accessDate = accessDate;
    }

    public JCheckBox getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(JCheckBox multimedia) {
        this.multimedia = multimedia;
    }

    public JTextField getOwner() {
        return owner;
    }

    public void setOwner(JTextField owner) {
        this.owner = owner;
    }
}
