/*
 * @(#)PanelSearchBasic.java
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
import com.fundation.search.model.ModelSearch;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Vector;

/**
 * Class that creates the basic search panel.
 *
 * @author William Claros Revollo - AT - [07]
 * @version 1.0.
 */
public class PanelSearchBasic extends JPanel implements ActionListener {

    private JLabel labelNameFile;
    private JTextField nameFile;
    private JLabel labelSearchPath;
    private JTextField path;

    private JLabel labelReadOnly;
    private JCheckBox readOnly;

    private JLabel labelKeyEnsitive;
    private JCheckBox keySensitive;

    private JLabel labelHiddenFile;
    private JCheckBox hiddenFile;

    private ButtonGroup group;
    private JLabel labelAll;
    private JRadioButton all;
    private JLabel labelFile;
    private JRadioButton file;
    private JLabel labelfolder;
    private JRadioButton folder;


    private JLabel labelTypeDocument;
    private JCheckBox document;
    private JTextField writeExtension;
    private Vector<String> typeFile;
    private JComboBox<String> fileType;

    private JLabel labelContent;
    private JTextField content;

    private JLabel labelFileSize;
    private Vector<String> typeCount;
    private JComboBox<String> count;
    private JSpinner sizeFile;
    private Vector<String> typeSize;
    private JComboBox sizeType;


    private JButton buttonPath;
    private JButton searchButton;
    private JLabel labelPanelBasic;
    private PanelSearchResult panelResult;

    private ModelSearch modelSearch;

    /**
     * Constructor that creates the basic search panel.
     */
    public PanelSearchBasic(PanelSearchResult panelResult) {
        settingPanel();
        initComponent();
        this.panelResult = panelResult;
        modelSearch = new ModelSearch();
    }

    public PanelSearchBasic() {
        settingPanel();
        initComponent();
    }

    /**
     * Method that contains the Basic Panel settings.
     */
    public void settingPanel() {
        setBorder(BorderFactory.createRaisedBevelBorder());
        setLayout(null);
        setVisible(true);
    }

    /**
     * Method that contains the components of the Advanced Basic.
     */
    public void initComponent() {
        labelPanelBasic = new JLabel();
        labelPanelBasic.setText("SEARCH BASIC");
        labelPanelBasic.setBounds(30, 10, 130, 30);
        add(labelPanelBasic);

        labelNameFile = new JLabel();
        labelNameFile.setText("Name file: ");
        labelNameFile.setBounds(40, 120, 120, 30);
        add(labelNameFile);

        nameFile = new JTextField();
        nameFile.setBounds(150, 120, 340, 30);
        add(nameFile);

        labelSearchPath = new JLabel();
        labelSearchPath.setText("Document Path: ");
        labelSearchPath.setBounds(40, 60, 100, 30); // 40, 60, 100, 30
        add(labelSearchPath);

        path = new JTextField();
        path.setBounds(150, 60, 340, 30); // 150, 60, 340, 30
        add(path);



        labelAll = new JLabel();
        labelAll.setText("All");
        labelAll.setBounds(150, 90, 80, 30);
        add(labelAll);
        all = new JRadioButton();
        all.setBounds(170, 90, 30, 30);
        add(all);

        labelFile = new JLabel();
        labelFile.setText("File");
        labelFile.setBounds(200, 90, 80, 30);
        add(labelFile);
        file = new JRadioButton();
        file.setBounds(220, 90, 30, 30);
        add(file);

        labelfolder = new JLabel();
        labelfolder.setText("Folder");
        labelfolder.setBounds(250, 90, 80, 30);
        add(labelfolder);
        folder = new JRadioButton();
        folder.setBounds(290, 90, 30, 30);
        add(folder);

        group = new ButtonGroup();
        group.add(all);
        group.add(file);
        group.add(folder);


        labelReadOnly = new JLabel();
        labelReadOnly.setText("Read Only");
        labelReadOnly.setBounds(150, 150, 80, 30);
        add(labelReadOnly);
        readOnly = new JCheckBox();
        readOnly.setBounds(210, 150, 30, 30);
        add(readOnly);

        labelHiddenFile = new JLabel();
        labelHiddenFile.setText("Hidden");
        labelHiddenFile.setBounds(250, 150, 50, 30);
        add(labelHiddenFile);
        hiddenFile = new JCheckBox();
        hiddenFile.setBounds(290, 150, 30, 30);
        add(hiddenFile);

        labelKeyEnsitive = new JLabel();
        labelKeyEnsitive.setText("Key Sensitive");
        labelKeyEnsitive.setBounds(330, 150, 90, 30);
        add(labelKeyEnsitive);
        keySensitive = new JCheckBox();
        keySensitive.setBounds(410, 150, 30, 30);
        add(keySensitive);

        labelTypeDocument = new JLabel();
        labelTypeDocument.setText("Documents");
        labelTypeDocument.setBounds(60, 180, 80, 30);
        add(labelTypeDocument);
        document = new JCheckBox();
        document.setBounds(130, 180, 30, 30);
        add(document);

        writeExtension = new JTextField();
        writeExtension.setBounds(30, 210, 60, 30);
        add(writeExtension);

        typeFile = new Vector<String>();
        typeFile.add("txt");
        typeFile.add("doc");
        typeFile.add("pdf");
        typeFile.add("xml");
        fileType = new JComboBox<String>(typeFile);
        fileType.setBounds(100, 210, 60, 30);
        add(fileType);

        labelContent = new JLabel();
        labelContent.setText("Content Search");
        labelContent.setBounds(175, 180, 100, 30);
        add(labelContent);
        content = new JTextField();
        content.setBounds(175, 210, 90, 30);
        add(content);

        labelFileSize = new JLabel();
        labelFileSize.setText("File Size");
        labelFileSize.setBounds(355, 180, 80, 30);
        add(labelFileSize);
        typeCount = new Vector<String>();
        typeCount.add(" < ");
        typeCount.add(" > ");
        typeCount.add(" = ");
        count = new JComboBox<String>(typeCount);
        count.setBounds(280, 210, 50, 30);
        add(count);

        sizeFile = new JSpinner();
        sizeFile.setBounds(340, 210, 70, 30);
        add(sizeFile);
        typeSize = new Vector<String>();
        typeSize.add("Byte");
        typeSize.add("KByte");
        typeSize.add("MByte");
        typeSize.add("GByte");
        sizeType = new JComboBox<String>(typeSize);
        sizeType.setBounds(420, 210, 70, 30);
        add(sizeType);


        buttonPath = new JButton("Path");
        buttonPath.addActionListener(this);
        buttonPath.setBounds(520, 60, 120, 30);
        add(buttonPath);

        searchButton = new JButton("Search");
        searchButton.setText("Search");
        searchButton.setBounds(520, 300, 120, 30);
        searchButton.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<AssetFile> listPaths = modelSearch.searchPathName(path.getText(), nameFile.getText(), null, 0L, false, null);
                    panelResult.updageFilesList(listPaths);
                } catch (Exception ez) {
                }
                }
        });
        add(searchButton);
    }

    /**
     * Override the method of the ActionListener interface to search for a  document by PATH.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(this);
        if (result != JFileChooser.CANCEL_OPTION) {
            File fileName = fileChooser.getSelectedFile();
            if ((fileName == null) || (fileName.getName().equals(""))) {
                path.setText("...");
            } else {
                path.setText(fileName.getAbsolutePath());
            }
        }
    }

    /**
     * Method that returns an object of the JButton class.
     *
     * @return searchButton an object of the JButton class.
     */
    public JButton getSearchButton() {
        return searchButton;
    }

    /**
     * Method that returns an object of the JTextField class.
     *
     * @return nameFile an object of the JTextField class.
     */
    public JTextField getNameFile() {
        return nameFile;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JTextField class.
     *
     * @param newNameFile new object of the JTextField class.
     */
    public void setNameFile(JTextField newNameFile) {
        nameFile = newNameFile;
    }

    /**
     * Method that returns an object of the JTextField class.
     *
     * @return path an object of the JTextField class.
     */
    public JTextField getPath() {
        return path;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JTextField class.
     *
     * @param newPath new object of the JTextField class.
     */
    public void setPath(JTextField newPath) {
        path = newPath;
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
    public void setHiddenFile(JCheckBox newHiddenFile) {
        hiddenFile = newHiddenFile;
    }

    public JCheckBox getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(JCheckBox readOnly) {
        this.readOnly = readOnly;
    }

    public JCheckBox getKeySensitive() {
        return keySensitive;
    }

    public void setKeySensitive(JCheckBox keySensitive) {
        this.keySensitive = keySensitive;
    }

    public JCheckBox getDocument() {
        return document;
    }

    public void setDocument(JCheckBox document) {
        this.document = document;
    }

    public JTextField getWriteExtension() {
        return writeExtension;
    }

    public void setWriteExtension(JTextField writeExtension) {
        this.writeExtension = writeExtension;
    }

    public JComboBox<String> getFileType() {
        return fileType;
    }

    public void setFileType(JComboBox<String> fileType) {
        this.fileType = fileType;
    }

    public JTextField getContent() {
        return content;
    }

    public void setContent(JTextField content) {
        this.content = content;
    }

    public Vector<String> getTypeCount() {
        return typeCount;
    }

    public void setTypeCount(Vector<String> typeCount) {
        this.typeCount = typeCount;
    }

    public JComboBox<String> getCount() {
        return count;
    }

    public void setCount(JComboBox<String> count) {
        this.count = count;
    }

    public JSpinner getSizeFile() {
        return sizeFile;
    }

    public void setSizeFile(JSpinner sizeFile) {
        this.sizeFile = sizeFile;
    }

    public Vector<String> getTypeSize() {
        return typeSize;
    }

    public void setTypeSize(Vector<String> typeSize) {
        this.typeSize = typeSize;
    }

    public JComboBox getSizeType() {
        return sizeType;
    }

    public void setSizeType(JComboBox sizeType) {
        this.sizeType = sizeType;
    }

}
