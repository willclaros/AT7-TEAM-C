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

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Vector;

/**
 * Class that creates the advanced search panel.
 *
 * @author William Claros Revollo - AT - [07]
 * @version 1.0.
 */
public class PanelSearchAdvanced extends JPanel {

    private Vector<String> typeFormat;
    private JComboBox<String> type;


    private Vector<String> typeFile;
    private JComboBox<String> fileType;

    private JLabel labelMultimediaSize;
    private Vector<String> typeCountMultimedia;
    private JComboBox<String> countMultimedia;
    private JSpinner sizeMutimedia;

    private Vector<String> typeSizeMultimeia;
    private JComboBox sizeTypeMultimedia;

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
        labelPanelAdvanced = new JLabel("SEARCH MULTIMEDIA");
        labelPanelAdvanced.setBounds(270, 10, 130, 30);
        add(labelPanelAdvanced);

        JLabel labelTypeMultimedia = new JLabel();
        labelTypeMultimedia.setText("Other Extension");
        labelTypeMultimedia.setBounds(20, 50, 100, 30);
        add(labelTypeMultimedia);

        JTextField writeExtensionMult = new JTextField();
        writeExtensionMult.setBounds(120, 50, 70, 30);
        add(writeExtensionMult);

        JLabel labelExtension = new JLabel("Extension");
        labelExtension.setBounds(20, 80, 80, 30);
        add(labelExtension);

        typeFormat = new Vector();
        typeFormat.add("Mp3");
        typeFormat.add("Mp4");
        typeFormat.add("Mpeg");
        type = new JComboBox(typeFormat);
        type.setBounds(120, 80, 70, 30);
        add(type);


        labelMultimediaSize = new JLabel();
        labelMultimediaSize.setText("Duration");
        labelMultimediaSize.setBounds(290, 50, 80, 30);
        add(labelMultimediaSize);

        typeCountMultimedia = new Vector();
        typeCountMultimedia.add(" < ");
        typeCountMultimedia.add(" > ");
        typeCountMultimedia.add(" = ");
        countMultimedia = new JComboBox(typeCountMultimedia);
        countMultimedia.setBounds(220, 80, 50, 30);
        add(countMultimedia);

        sizeMutimedia = new JSpinner();
        sizeMutimedia.setBounds(280, 80, 70, 30);
        add(sizeMutimedia);

        typeSizeMultimeia = new Vector();
        typeSizeMultimeia.add("Hora");
        typeSizeMultimeia.add("Minutes");
        typeSizeMultimeia.add("Seconds");
        sizeTypeMultimedia = new JComboBox(typeSizeMultimeia);
        sizeTypeMultimedia.setBounds(360, 80, 70, 30);
        add(sizeTypeMultimedia);


        JLabel labelDateCreated = new JLabel("Date Created");
        labelDateCreated.setBounds(70, 250, 110, 30);
        add(labelDateCreated);

        datecreated = new JCheckBox();
        datecreated.setBounds(150, 250, 30, 30);
        add(datecreated);

        dateChoserCreateIni = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChoserCreateIni.setBounds(20,290,90,30);
        add(dateChoserCreateIni);
        dateChooserCreateEnd = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChooserCreateEnd.setBounds(120,290,90,30);
        add(dateChooserCreateEnd);


        JLabel labelDateModificated = new JLabel("Date Modificated");
        labelDateModificated.setBounds(270, 250, 100, 30);
        add(labelDateModificated);

        datemodificate = new JCheckBox();
        datemodificate.setBounds(370, 250, 30, 30);
        add(datemodificate);

        dateChooserModifyIni = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChooserModifyIni.setBounds(240,290,90,30);
        add(dateChooserModifyIni);
        dateChooserModifyEnd = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChooserModifyEnd.setBounds(340,290,90,30);
        add(dateChooserModifyEnd);

        JLabel labelIntervalDate = new JLabel("Accessed Date");
        labelIntervalDate.setBounds(480, 250, 100, 30);

        accessDate = new JCheckBox();
        accessDate.setBounds(580, 250, 30, 30);
        add(accessDate);

        add(labelIntervalDate);
        dateChooserAccessedIni = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChooserAccessedIni.setBounds(450,290,90,30);
        add(dateChooserAccessedIni);
        JLabel labelIntervalSymbol = new JLabel();
        labelIntervalSymbol.setText(" - ");
        labelIntervalSymbol.setBounds(514, 290, 10, 10);
        add(labelIntervalSymbol);
        dateChooserAccessedEnd = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChooserAccessedEnd.setBounds(550,290,90,30);
        add(dateChooserAccessedEnd);


        JLabel labelVideoCodec = new JLabel("Video Codec");
        labelVideoCodec.setBounds(40, 160, 100, 10);
        add(labelVideoCodec);

        Vector<String> videoCodec = new Vector();
        videoCodec.add("H264");
        videoCodec.add("H263");
        videoCodec.add("MPEG4");
        videoCodec.add("WMV1");
        videoCodec.add("AVC");
        JComboBox<String> video = new JComboBox(videoCodec);
        video.setBounds(120, 150, 90, 30);
        add(video);

        JLabel labelAudioCodec = new JLabel("Audio Codec");
        labelAudioCodec.setBounds(40, 200,100,10);
        add(labelAudioCodec);

        Vector<String> audioCodec = new Vector();
        audioCodec.add("DoD CELP");
        audioCodec.add("LPC10");
        audioCodec.add("Speex");
        audioCodec.add("ITU G.729");
        audioCodec.add("GSM ");
        JComboBox<String> audio = new JComboBox(audioCodec);
        audio.setBounds(120, 190, 90, 30);
        add(audio);

        JLabel labelFrameRate = new JLabel("Frame Rate");
        labelFrameRate.setBounds(250, 160,100,10);
        add(labelFrameRate);

        Vector<String> frameRate = new Vector();
        frameRate.add("24 fps");
        frameRate.add("25 fps");
        frameRate.add("27 fps");
        frameRate.add("30 fps");
        frameRate.add("64 fps ");
        JComboBox<String> rate = new JComboBox(frameRate);
        rate.setBounds(320, 150, 90, 30);
        add(rate);


        JLabel labelResolution = new JLabel("Resolution");
        labelResolution.setBounds(250, 200,100,10);
        add(labelResolution);

        Vector<String> resolution = new Vector();
        resolution.add("320 x 240");
        resolution.add("512 x 384");
        resolution.add("640 x 480");
        resolution.add("1280 x 768");
        JComboBox<String> resol = new JComboBox(resolution);
        resol.setBounds(320, 190, 90, 30);
        add(resol);

    }

    public Vector<String> getTypeFormat() {
        return typeFormat;
    }

    public void setTypeFormat(Vector<String> typeFormat) {
        this.typeFormat = typeFormat;
    }

    public JComboBox<String> getType() {
        return type;
    }

    public void setType(JComboBox<String> type) {
        this.type = type;
    }

    public Vector<String> getTypeFile() {
        return typeFile;
    }

    public void setTypeFile(Vector<String> typeFile) {
        this.typeFile = typeFile;
    }

    public JComboBox<String> getFileType() {
        return fileType;
    }

    public void setFileType(JComboBox<String> fileType) {
        this.fileType = fileType;
    }

    public Vector<String> getTypeCountMultimedia() {
        return typeCountMultimedia;
    }

    public void setTypeCountMultimedia(Vector<String> typeCountMultimedia) {
        this.typeCountMultimedia = typeCountMultimedia;
    }

    /**
     * Method that returns an object of the JComboBox class.
     * @return
     */
    public JComboBox<String> getCountMultimedia() {
        return countMultimedia;
    }

    public void setCountMultimedia(JComboBox<String> countMultimedia) {
        this.countMultimedia = countMultimedia;
    }

    /**
     * Method that returns an object of the JSpinner class.
     * @return size multimedia an object of the JSpinner class.
     */
    public JSpinner getSizeMutimedia() {
        return sizeMutimedia;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JSpinner class.
     * @param sizeMutimedia new object of the JSpinner class.
     */
    public void setSizeMutimedia(JSpinner sizeMutimedia) {
        this.sizeMutimedia = sizeMutimedia;
    }

    /**
     * Method that returns an object of the vector.
     * @return typeSizeMultimeia
     */
    public Vector<String> getTypeSizeMultimeia() {
        return typeSizeMultimeia;
    }

    public void setTypeSizeMultimeia(Vector<String> typeSizeMultimeia) {
        this.typeSizeMultimeia = typeSizeMultimeia;
    }

    public JComboBox getSizeTypeMultimedia() {
        return sizeTypeMultimedia;
    }

    public void setSizeTypeMultimedia(JComboBox sizeTypeMultimedia) {
        this.sizeTypeMultimedia = sizeTypeMultimedia;
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


}
