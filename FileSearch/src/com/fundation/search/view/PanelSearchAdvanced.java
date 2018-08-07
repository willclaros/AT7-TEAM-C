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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.util.Vector;

/**
 * Class that creates the advanced search panel.
 * @author William Claros Revollo - AT - [07]
 * @author Erik Vargas - AT - [07]
 * @version 1.0.
 */
public class PanelSearchAdvanced extends JPanel {
    private JLabel labelPanelAdvanced;
    private JCheckBox checkMultimedia;
    private JCheckBox checkOtherExtentionMult;
    private JTextField writeExtensionMult;
    private JLabel labelExtension;
    private Vector<String> typeFormat;
    private JComboBox<String> type;
    private JLabel labelVideoCodec;
    private JLabel labelAudioCodec;
    private JLabel labelFrameRate;
    private JLabel labelResolution;
    private JComboBox<String> video;
    private Vector<String> videoCodec;
    private Vector<String> audioCodec;
    private JComboBox<String> audio;
    private Vector<String> frameRate;
    private JComboBox<String> rate;
    private Vector<String> resolution;
    private JComboBox<String> resol;
    private Vector<String> typeFile;
    private JComboBox<String> fileType;
    private JLabel labelMultimediaSize;
    private Vector<String> typeCountMultimedia;
    private JComboBox<String> countMultimedia;
    private JSpinner sizeMutimedia;
    private Vector<String> typeSizeMultimeia;
    private JComboBox sizeTypeMultimedia;
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
        labelPanelAdvanced.setBounds(170, 10, 130, 30);
        add(labelPanelAdvanced);

        checkMultimedia = new JCheckBox();
        checkMultimedia.setBounds(360, 0, 70, 70);
        Icon iconMultimedia = new ImageIcon("Icons/multimedia.png");
        checkMultimedia.setIcon(iconMultimedia);
        add(checkMultimedia);

        checkOtherExtentionMult = new JCheckBox("Other extension");
        checkOtherExtentionMult.setBounds(20, 60, 120, 30);
        add(checkOtherExtentionMult);
        checkOtherExtentionMult.setEnabled(false);

        writeExtensionMult = new JTextField();
        writeExtensionMult.setBounds(140, 60, 70, 30);
        add(writeExtensionMult);
        writeExtensionMult.setEnabled(false);

        labelExtension = new JLabel("Extension");
        labelExtension.setBounds(22, 90, 80, 30);
        add(labelExtension);
        labelExtension.setEnabled(false);

        typeFormat = new Vector();
        typeFormat.add("");
        typeFormat.add("Mp3");
        typeFormat.add("Mp4");
        typeFormat.add("Mpeg");
        type = new JComboBox(typeFormat);
        type.setBounds(140, 90, 70, 30);
        add(type);
        type.setEnabled(false);

        labelMultimediaSize = new JLabel("Duration");
        labelMultimediaSize.setBounds(290, 50, 80, 30);
        add(labelMultimediaSize);
        labelMultimediaSize.setEnabled(false);

        typeCountMultimedia = new Vector();
        typeCountMultimedia.add(" = ");
        typeCountMultimedia.add(" < ");
        typeCountMultimedia.add(" > ");
        countMultimedia = new JComboBox(typeCountMultimedia);
        countMultimedia.setBounds(220, 80, 50, 30);
        add(countMultimedia);
        countMultimedia.setEnabled(false);

        sizeMutimedia = new JSpinner();
        sizeMutimedia.setBounds(280, 80, 70, 30);
        add(sizeMutimedia);
        sizeMutimedia.setEnabled(false);

        typeSizeMultimeia = new Vector();
        typeSizeMultimeia.add("Hora");
        typeSizeMultimeia.add("Minutes");
        typeSizeMultimeia.add("Seconds");
        sizeTypeMultimedia = new JComboBox(typeSizeMultimeia);
        sizeTypeMultimedia.setBounds(360, 80, 70, 30);
        add(sizeTypeMultimedia);
        sizeTypeMultimedia.setEnabled(false);

        labelVideoCodec = new JLabel("Video Codec");
        labelVideoCodec.setBounds(40, 160, 100, 10);
        add(labelVideoCodec);
        labelVideoCodec.setEnabled(false);

        videoCodec = new Vector();
        videoCodec.add("");
        videoCodec.add("H264");
        videoCodec.add("H263");
        videoCodec.add("MPEG4");
        videoCodec.add("WMV1");
        videoCodec.add("AVC");
        video = new JComboBox(videoCodec);
        video.setBounds(120, 150, 90, 30);
        add(video);
        video.setEnabled(false);

        labelAudioCodec = new JLabel("Audio Codec");
        labelAudioCodec.setBounds(40, 200,100,10);
        add(labelAudioCodec);
        labelAudioCodec.setEnabled(false);

        audioCodec = new Vector();
        audioCodec.add("");
        audioCodec.add("DoD CELP");
        audioCodec.add("LPC10");
        audioCodec.add("Speex");
        audioCodec.add("ITU G.729");
        audioCodec.add("GSM ");
        audio = new JComboBox(audioCodec);
        audio.setBounds(120, 190, 90, 30);
        add(audio);
        audio.setEnabled(false);

        labelFrameRate = new JLabel("Frame Rate");
        labelFrameRate.setBounds(250, 160,100,10);
        add(labelFrameRate);
        labelFrameRate.setEnabled(false);

        frameRate = new Vector();
        frameRate.add("");
        frameRate.add("24 fps");
        frameRate.add("25 fps");
        frameRate.add("27 fps");
        frameRate.add("30 fps");
        frameRate.add("64 fps ");
        rate = new JComboBox(frameRate);
        rate.setBounds(320, 150, 90, 30);
        add(rate);
        rate.setEnabled(false);

        labelResolution = new JLabel("Resolution");
        labelResolution.setBounds(250, 200,100,10);
        add(labelResolution);
        labelResolution.setEnabled(false);

        resolution = new Vector();
        resolution.add("");
        resolution.add("320 x 240");
        resolution.add("512 x 384");
        resolution.add("640 x 480");
        resolution.add("1280 x 768");
        resol = new JComboBox(resolution);
        resol.setBounds(320, 190, 90, 30);
        add(resol);
        resol.setEnabled(false);

        JLabel labelDateCreated = new JLabel("Date Created");
        labelDateCreated.setBounds(30, 254, 110, 30);//110
        add(labelDateCreated);

        datecreated = new JCheckBox();
        datecreated.setBounds(110, 254, 30, 30);//110
        add(datecreated);

        dateChoserCreateIni = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChoserCreateIni.setBounds(30,284,90,30);
        add(dateChoserCreateIni);
        dateChoserCreateIni.setEnabled(false);

        dateChooserCreateEnd = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChooserCreateEnd.setBounds(30,310,90,30);
        add(dateChooserCreateEnd);
        dateChooserCreateEnd.setEnabled(false);

        JLabel labelDateModificated = new JLabel("Date Modificated");
        labelDateModificated.setBounds(160, 254, 100, 30);
        add(labelDateModificated);

        datemodificate = new JCheckBox();
        datemodificate.setBounds(260, 254, 30, 30);
        add(datemodificate);

        dateChooserModifyIni = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChooserModifyIni.setBounds(170,284,90,30);
        add(dateChooserModifyIni);
        dateChooserModifyIni.setEnabled(false);

        dateChooserModifyEnd = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChooserModifyEnd.setBounds(170,310,90,30);
        add(dateChooserModifyEnd);
        dateChooserModifyEnd.setEnabled(false);

        JLabel labelIntervalDate = new JLabel("Accessed Date");
        labelIntervalDate.setBounds(320, 254, 100, 30);

        accessDate = new JCheckBox();
        accessDate.setBounds(410, 254, 30, 30);
        add(accessDate);

        add(labelIntervalDate);
        dateChooserAccessedIni = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChooserAccessedIni.setBounds(330,284,90,30);
        add(dateChooserAccessedIni);
        dateChooserAccessedIni.setEnabled(false);

        JLabel labelIntervalSymbol = new JLabel();
        labelIntervalSymbol.setText(" - ");
        labelIntervalSymbol.setBounds(514, 300, 10, 10);
        add(labelIntervalSymbol);
        dateChooserAccessedEnd = new JDateChooser("MM/dd/yyyy","##/##/####",'_');
        dateChooserAccessedEnd.setBounds(330,310,90,30);
        add(dateChooserAccessedEnd);
        dateChooserAccessedEnd.setEnabled(false);

        // Enable and disable options of multimedia
        checkMultimedia.addChangeListener(eve -> CheckBoxMultimedia(eve));

        // Enable and disable check other extension of the multimedia
        checkOtherExtentionMult.addChangeListener(eve -> CheckBoxOtherExtension(eve));

        //Enable and disable checkbox calendar
        datecreated.addChangeListener(eve -> CheckBoxCalendar(eve));
        datemodificate.addChangeListener(eve -> CheckBoxCalendar(eve));
        accessDate.addChangeListener(eve -> CheckBoxCalendar(eve));

    }

    /**
     * This method is for enable and disable checkbox of other extension.
     * @param event
     */
    public void CheckBoxOtherExtension (ChangeEvent event) {
        if (checkOtherExtentionMult.isSelected()) {
            writeExtensionMult.setEnabled(true);;
            type.setEnabled(false);
        }else{
            writeExtensionMult.setEnabled(false);
            type.setEnabled(true);
        }
    }

    /**
     * This method is for enable and disable chekbox of the calendar.
     * @param e
     */
    public void CheckBoxCalendar(ChangeEvent e){
        if(datecreated.isSelected()){
            dateChoserCreateIni.setEnabled(true);
            dateChooserCreateEnd.setEnabled(true);
        }else{
            dateChoserCreateIni.setEnabled(false);
            dateChooserCreateEnd.setEnabled(false);
        }
        if(datemodificate.isSelected()){
            dateChooserModifyIni.setEnabled(true);
            dateChooserModifyEnd.setEnabled(true);
        }else{
            dateChooserModifyIni.setEnabled(false);
            dateChooserModifyEnd.setEnabled(false);
        }
        if(accessDate.isSelected()){
            dateChooserAccessedIni.setEnabled(true);
            dateChooserAccessedEnd.setEnabled(true);
        }else{
            dateChooserAccessedIni.setEnabled(false);
            dateChooserAccessedEnd.setEnabled(false);
        }
    }

    /**
     * This method is for enable and disable chekbox of the multimedia.
     * @param event
     */
    public void CheckBoxMultimedia (ChangeEvent event){
        if(checkMultimedia.isSelected()){
            checkOtherExtentionMult.setEnabled(true);
            writeExtensionMult.setEnabled(false);
            type.setEnabled(true);
            countMultimedia.setEnabled(true);
            sizeMutimedia.setEnabled(true);
            sizeTypeMultimedia.setEnabled(true);
            video.setEnabled(true);
            audio.setEnabled(true);
            rate.setEnabled(true);
            resol.setEnabled(true);

            labelExtension.setEnabled(true);
            labelMultimediaSize.setEnabled(true);
            labelVideoCodec.setEnabled(true);
            labelAudioCodec.setEnabled(true);
            labelFrameRate.setEnabled(true);
            labelResolution.setEnabled(true);
        }else{
            checkOtherExtentionMult.setEnabled(false);
            writeExtensionMult.setEnabled(false);
            type.setEnabled(false);
            countMultimedia.setEnabled(false);
            sizeMutimedia.setEnabled(false);
            sizeTypeMultimedia.setEnabled(false);
            video.setEnabled(false);
            audio.setEnabled(false);
            rate.setEnabled(false);
            resol.setEnabled(false);

            labelExtension.setEnabled(false);
            labelMultimediaSize.setEnabled(false);
            labelVideoCodec.setEnabled(false);
            labelAudioCodec.setEnabled(false);
            labelFrameRate.setEnabled(false);
            labelResolution.setEnabled(false);
        }
    }

    /**
     * Method that returns an object of the vector.
     * @return type format.
     */
    public Vector<String> getTypeFormat() {
        return typeFormat;
    }

    /**
     * Method that is responsible for modifying the value of the object of the Vector.
     * @param typeFormat new object of the JTextField class.
     */
    public void setTypeFormat(Vector<String> typeFormat) {
        this.typeFormat = typeFormat;
    }

    /**
     * Method that returns an object of the JComboBox class.
     * @return type.
     */
    public JComboBox<String> getType() {
        return type;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JComboBox class.
     * @param type new object of the JTextField class.
     */
    public void setType(JComboBox<String> type) {
        this.type = type;
    }

    /**
     * Method that is responsible for modifying the value of the object of the Vector.
     * @return new object of the JTextField class.
     */
    public Vector<String> getTypeFile() {
        return typeFile;
    }

    /**
     * Method that is responsible for modifying the value of the object of the Vector.
     * @param typeFile new object of the JTextField class.
     */
    public void setTypeFile(Vector<String> typeFile) {
        this.typeFile = typeFile;
    }

    /**
     * Method that returns an object of the JComboBox class.
     * @return file type.
     */
    public JComboBox<String> getFileType() {
        return fileType;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JComboBox class.
     * @param fileType new object of the JTextField class.
     */
    public void setFileType(JComboBox<String> fileType) {
        this.fileType = fileType;
    }

    /**
     * Method that is responsible for modifying the value of the object of the Vector.
     * @return new object of the JTextField class.
     */
    public Vector<String> getTypeCountMultimedia() {
        return typeCountMultimedia;
    }

    /**
     * Method that is responsible for modifying the value of the object of the Vector.
     * @param typeCountMultimedia new object of the JTextField class.
     */
    public void setTypeCountMultimedia(Vector<String> typeCountMultimedia) {
        this.typeCountMultimedia = typeCountMultimedia;
    }

    /**
     * Method that returns an object of the JComboBox class.
     * @return new object of the JTextField class.
     */
    public JComboBox<String> getCountMultimedia() {
        return countMultimedia;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JComboBox class.
     * @param countMultimedia object of the JTextField class.
     */
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

    /**
     * Method that is responsible for modifying the value of the object of the Vector.
     * @param typeSizeMultimedia new object of the JTextField class.
     */
    public void setTypeSizeMultimeia(Vector<String> typeSizeMultimedia) {
        this.typeSizeMultimeia = typeSizeMultimedia;
    }

    /**
     * Method that returns an object of the JComboBox.
     * @return sizeTypeMultimedia.
     */
    public JComboBox getSizeTypeMultimedia() {
        return sizeTypeMultimedia;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JComboBox.
     * @param sizeTypeMultimedia new object of the JComboBox class.
     */
    public void setSizeTypeMultimedia(JComboBox sizeTypeMultimedia) {
        this.sizeTypeMultimedia = sizeTypeMultimedia;
    }

    /**
     * Method that returns an object of the JDateChooser class.
     * @return date chooser create.
     */
    public JDateChooser getDateChoserCreateIni() {
        return dateChoserCreateIni;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JDateChooser.
     * @param dateChooserCreateIni new object of the JDateChooser class.
     */
    public void setDateChoserCreateIni(JDateChooser dateChooserCreateIni) {
        this.dateChoserCreateIni = dateChooserCreateIni;
    }

    /**
     * Method that returns an object of the JDateChooser class.
     * @return dateChooserCreateEnd.
     */
    public JDateChooser getDateChooserCreateEnd() {
        return dateChooserCreateEnd;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JDateChooser class.
     * @param dateChooserCreateEnd new object of the JDateChooser class.
     */
    public void setDateChooserCreateEnd(JDateChooser dateChooserCreateEnd) {
        this.dateChooserCreateEnd = dateChooserCreateEnd;
    }

    /**
     * Method that returns an object of the JDateChooser class.
     * @return dateChooserModifyIni.
     */
    public JDateChooser getDateChooserModifyIni() {
        return dateChooserModifyIni;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JDateChooser class.
     * @param dateChooserModifyIni new object of the JDateChooser class.
     */
    public void setDateChooserModifyIni(JDateChooser dateChooserModifyIni) {
        this.dateChooserModifyIni = dateChooserModifyIni;
    }

    /**
     * Method that returns an object of the JDateChooser class.
     * @return dateChooserModifyEnd.
     */
    public JDateChooser getDateChooserModifyEnd() {
        return dateChooserModifyEnd;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JDateChooser class.
     * @param dateChooserModifyEnd new object of the JDateChooser class.
     */
    public void setDateChooserModifyEnd(JDateChooser dateChooserModifyEnd) {
        this.dateChooserModifyEnd = dateChooserModifyEnd;
    }

    /**
     * Method that returns an object of the JDateChooser class.
     * @return dateChooserAccessedIni.
     */
    public JDateChooser getDateChooserAccessedIni() {
        return dateChooserAccessedIni;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JDateChooser class.
     * @param dateChooserAccessedIni new object of the JDateChooser class.
     */
    public void setDateChooserAccessedIni(JDateChooser dateChooserAccessedIni) {
        this.dateChooserAccessedIni = dateChooserAccessedIni;
    }

    /**
     * Method that returns an object of the JDateChooser class.
     * @return dateChooserAccessedEnd.
     */
    public JDateChooser getDateChooserAccessedEnd() {
        return dateChooserAccessedEnd;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JDateChooser class.
     * @param dateChooserAccessedEnd new object of the JDateChooser class.
     */
    public void setDateChooserAccessedEnd(JDateChooser dateChooserAccessedEnd) {
        this.dateChooserAccessedEnd = dateChooserAccessedEnd;
    }

    /**
     * Method that returns an object of the JCheckBox class.
     * @return datecreated.
     */
    public JCheckBox getDatecreated() {
        return datecreated;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JCheckBox class.
     * @param datecreated new object of the JCheckBox class.
     */
    public void setDatecreated(JCheckBox datecreated) {
        this.datecreated = datecreated;
    }

    /**
     * Method that returns an object of the JCheckBox class.
     * @return datemodificate.
     */
    public JCheckBox getDatemodificate() {
        return datemodificate;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JCheckBox class.
     * @param datemodificate new object of the JCheckBox class.
     */
    public void setDatemodificate(JCheckBox datemodificate) {
        this.datemodificate = datemodificate;
    }

    /**
     * Method that returns an object of the JCheckBox class.
     * @return accessDate
     */
    public JCheckBox getAccessDate() {
        return accessDate;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JCheckBox class.
     * @param accessDate new object of the JCheckBox class.
     */
    public void setAccessDate(JCheckBox accessDate) {
        this.accessDate = accessDate;
    }

    /**
     * Method that returns an object of the JCheckBox class.
     * @return checkMultimedia.
     */
    public JCheckBox getCheckMultimedia() {
        return checkMultimedia;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JCheckBox class.
     * @param checkMultimedia new object of the JCheckBox class.
     */
    public void setCheckMultimedia(JCheckBox checkMultimedia) {
        this.checkMultimedia = checkMultimedia;
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
     * Method that returns an object of the JComboBox class.
     * @return video.
     */
    public JComboBox<String> getVideo() {
        return video;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JComboBox class.
     * @param video new object of the JComboBox class.
     */
    public void setVideo(JComboBox<String> video) {
        this.video = video;
    }

    /**
     * Method that returns an object of the vector.
     * @return video codec.
     */
    public Vector<String> getVideoCodec() {
        return videoCodec;
    }

    /**
     * Method that is responsible for modifying the value of the object of the Vector.
     * @param videoCodec new object of the Vector.
     */
    public void setVideoCodec(Vector<String> videoCodec) {
        this.videoCodec = videoCodec;
    }

    /**
     * Method that returns an object of the vector.
     * @return audio codec.
     */
    public Vector<String> getAudioCodec() {
        return audioCodec;
    }

    /**
     * Method that is responsible for modifying the value of the object of the Vector.
     * @param audioCodec new object of the Vector.
     */
    public void setAudioCodec(Vector<String> audioCodec) {
        this.audioCodec = audioCodec;
    }

    /**
     * Method that returns an object of the JComboBox class.
     * @return audio.
     */
    public JComboBox<String> getAudio() {
        return audio;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JComboBox class.
     * @param audio new object of the JComboBox class.
     */
    public void setAudio(JComboBox<String> audio) {
        this.audio = audio;
    }

    /**
     * Method that returns an object of the vector.
     * @return frameRate.
     */
    public Vector<String> getFrameRate() {
        return frameRate;
    }

    /**
     * Method that is responsible for modifying the value of the object of the Vector.
     * @param frameRate new object of the Vector.
     */
    public void setFrameRate(Vector<String> frameRate) {
        this.frameRate = frameRate;
    }

    /**
     * Method that returns an object of the JComboBox class.
     * @return rate.
     */
    public JComboBox<String> getRate() {
        return rate;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JComboBox class
     * @param rate new object of the JComboBox class.
     */
    public void setRate(JComboBox<String> rate) {
        this.rate = rate;
    }

    /**
     * Method that returns an object of the Vector.
     * @return resolution.
     */
    public Vector<String> getResolution() {
        return resolution;
    }

    /**
     * Method that is responsible for modifying the value of the object of the vector.
     * @param resolution new object of the vector.
     */
    public void setResolution(Vector<String> resolution) {
        this.resolution = resolution;
    }

    /**
     * Method that returns an object of the JComboBox class.
     * @return resol.
     */
    public JComboBox<String> getResol() {
        return resol;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JComboBox class
     * @param resol new object of the JComboBox class.
     */
    public void setResol(JComboBox<String> resol) {
        this.resol = resol;
    }

    /**
     * Method that returns an object of the JCheckBox class.
     * @return checkOtherExtentionMult.
     */
    public JCheckBox getCheckOtherExtentionMult() {
        return checkOtherExtentionMult;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JCheckBox class.
     * @param checkOtherExtentionMult new object of the JCheckBox class.
     */
    public void setCheckOtherExtentionMult(JCheckBox checkOtherExtentionMult) {
        this.checkOtherExtentionMult = checkOtherExtentionMult;
    }
}
