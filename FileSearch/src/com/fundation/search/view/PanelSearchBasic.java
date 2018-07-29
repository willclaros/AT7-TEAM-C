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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Vector;

/**
 * Class that creates the basic search panel.
 *
 * @author William Claros Revollo - AT - [07]
 * @author Erik Vargas - AT - [07]
 * @version 1.0.
 */
public class PanelSearchBasic extends JPanel implements ActionListener {

    private JTextField nameFile;

    private JTextField owner;

    private JTextField path;

    private JCheckBox readOnly;

    private JCheckBox keySensitive;

    private JCheckBox hiddenFile;

    private JRadioButton all;
    private JRadioButton file;
    private JRadioButton folder;

    private ButtonGroup group1;
    private ButtonGroup group2;

    private JRadioButton startWord;
    private JRadioButton contentWord;
    private JRadioButton endWord;

    private JTextField writeExtension;
    private Vector<String> typeFile;
    private JComboBox<String> fileType;

    private JTextField content;

    private Vector<String> typeCount;
    private JComboBox<String> count;
    private Vector<String> typeSize;
    private JComboBox sizeType;

    private JButton searchButton;
    private PanelSearchResult panelResult;
    private ModelSearch modelSearch;

    private ImageIcon imagen;
    private Icon icon;

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
     * Method that contains the components of the search Basic.
     */
    public void initComponent() {
        JLabel labelPanelBasic = new JLabel();
        labelPanelBasic.setText("SEARCH");
        labelPanelBasic.setBounds(30, 10, 130, 30);
        add(labelPanelBasic);

        JLabel labelSearchPath = new JLabel();
        labelSearchPath.setText("Document Path: ");
        labelSearchPath.setBounds(20, 60, 100, 30);
        add(labelSearchPath);

        path = new JTextField();
        path.setBounds(130, 60, 340, 30);
        add(path);

        JLabel labelNameFile = new JLabel();
        labelNameFile.setText("File Name: ");
        labelNameFile.setBounds(20, 120, 120, 30);
        add(labelNameFile);

        nameFile = new JTextField();
        nameFile.setBounds(130, 120, 170, 30);
        add(nameFile);

        JLabel labelOwner = new JLabel();
        labelOwner.setText("Owner");
        labelOwner.setBounds(320, 120, 80, 30);
        add(labelOwner);
        owner = new JTextField();
        owner.setBounds(370, 120, 100, 30);
        add(owner);

        JLabel labelContent = new JLabel();
        labelContent.setText("Contains");
        labelContent.setBounds(490, 120, 100, 30);
        add(labelContent);

        content = new JTextField();
        content.setBounds(550, 120, 100, 30);
        add(content);

        all = new JRadioButton("All");
        all.setBounds(150, 170, 80, 20);
        add(all);

        file = new JRadioButton("File");
        file.setBounds(150, 190, 80, 20);
        add(file);

        folder = new JRadioButton("Folder");
        folder.setBounds(150, 210, 80, 20);
        add(folder);

        group1 = new ButtonGroup();
        group1.add(all);
        group1.add(file);
        group1.add(folder);

        startWord = new JRadioButton("Start Word");
        startWord.setBounds(250, 170, 100, 20);
        add(startWord);

        contentWord = new JRadioButton("Content Word");
        contentWord.setBounds(250, 190, 120, 20);
        add(contentWord);

        endWord = new JRadioButton("End Word");
        endWord.setBounds(250, 210, 100, 20);
        add(endWord);

        group2 = new ButtonGroup();
        group2.add(startWord);
        group2.add(contentWord);
        group2.add(endWord);

        readOnly = new JCheckBox("Read Only");
        readOnly.setBounds(400, 172, 100, 20);
        add(readOnly);

        hiddenFile = new JCheckBox("Hidden");
        hiddenFile.setBounds(400, 193, 100, 20);
        add(hiddenFile);

        keySensitive = new JCheckBox("Key Sensitive");
        keySensitive.setBounds(400, 214, 120, 20);
        add(keySensitive);

        JLabel labelTypeDocument = new JLabel();
        labelTypeDocument.setText("Documents");
        labelTypeDocument.setBounds(60, 240, 80, 30);
        add(labelTypeDocument);

        JLabel labelOtherExtension = new JLabel();
        labelOtherExtension.setText("Other extension");
        labelOtherExtension.setBounds(10, 270, 100, 30);
        add(labelOtherExtension);

        writeExtension = new JTextField();
        writeExtension.setBounds(120, 270, 100, 30);
        add(writeExtension);

        JLabel labelExtension = new JLabel("extension");
        labelExtension.setBounds(10, 300, 80, 30);
        add(labelExtension);

        typeFile = new Vector();
        typeFile.add("txt");
        typeFile.add("doc");
        typeFile.add("pdf");
        typeFile.add("xlsx");
        fileType = new JComboBox(typeFile);
        fileType.setBounds(120, 300, 100, 30);
        add(fileType);

        JLabel labelFileSize = new JLabel();
        labelFileSize.setText("File Size");
        labelFileSize.setBounds(355, 270, 80, 30);
        add(labelFileSize);
        typeCount = new Vector();
        typeCount.add(" < ");
        typeCount.add(" > ");
        typeCount.add(" = ");
        count = new JComboBox(typeCount);
        count.setBounds(280, 300, 50, 30);
        add(count);

        JSpinner sizeFile = new JSpinner();
        sizeFile.setBounds(340, 300, 70, 30);
        add(sizeFile);
        typeSize = new Vector();
        typeSize.add("Byte");
        typeSize.add("KByte");
        typeSize.add("MByte");
        typeSize.add("GByte");
        sizeType = new JComboBox(typeSize);
        sizeType.setBounds(420, 300, 70, 30);
        add(sizeType);

        JButton buttonPath = new JButton("Path");
        buttonPath.addActionListener(this);
        buttonPath.setBounds(520, 60, 120, 30);
        add(buttonPath);

        searchButton = new JButton();
        imagen = new ImageIcon("64.png");
        searchButton.setIcon(imagen);
        searchButton.setBounds(540, 270, 100, 70);

        /*icon = new ImageIcon(imagen.getImage().getScaledInstance(searchButton.getWidth(), searchButton.getHeight(), Image.SCALE_DEFAULT));
        searchButton.setIcon(icon);*/
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
     * @param newHiddenFile new object of the JCheckBox class.
     */
    public void setHiddenFile(JCheckBox newHiddenFile) {
        hiddenFile = newHiddenFile;
    }

    /**
     * Method that returns an object of the JTextField class.
     * @return owner.
     */
    public JTextField getOwner() {
        return owner;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JTextField class.
     * @param owner new object of the JTextField class.
     */
    public void setOwner(JTextField owner) {
        this.owner = owner;
    }

    /**
     * Method that returns an object of the JTextField class.
     * @return content.
     */
    public JTextField getContent() {
        return content;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JTextField class.
     * @param content new object of the JTextField class.
     */
    public void setContent(JTextField content) {
        this.content = content;
    }

    /**
     * Method that returns an object of the JCheckBox class.
     * @return read only.
     */
    public JCheckBox getReadOnly() {
        return readOnly;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JCheckBox class.
     * @param readOnly new object of the JTextField class.
     */
    public void setReadOnly(JCheckBox readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * Method that returns an object of the JCheckBox class.
     * @return key sensitive.
     */
    public JCheckBox getKeySensitive() {
        return keySensitive;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JCheckBox class.
     * @param keySensitive new object of the JTextField class.
     */
    public void setKeySensitive(JCheckBox keySensitive) {
        this.keySensitive = keySensitive;
    }

    /**
     * Method that returns an object of the ButtonGroup class.
     * @return
     */
    public ButtonGroup getGroup1() {
        return group1;
    }

    /**
     * Method that is responsible for modifying the value of the object of the ButtonGroup class.
     * @param group1 new object of the ButtonGroup class.
     */
    public void setGroup1(ButtonGroup group1) {
        this.group1 = group1;
    }

    /**
     * Method that returns an object of the ButtonGroup class.
     * @return
     */
    public ButtonGroup getGroup2() {
        return group2;
    }

    /**
     * Method that is responsible for modifying the value of the object of the ButtonGroup class.
     * @param group2 new object of the ButtonGroup class.
     */
    public void setGroup2(ButtonGroup group2) {
        this.group2 = group2;
    }

    /**
     * Method that returns an object of the JTextField class.
     * @return write extension.
     */
    public JTextField getWriteExtension() {
        return writeExtension;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JTextField class.
     * @param writeExtension new object of the JTextField class.
     */
    public void setWriteExtension(JTextField writeExtension) {
        this.writeExtension = writeExtension;
    }

    /**
     * Method that returns an object of the vector.
     * @return type file.
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
     * Method that returns an object of the Vector.
     * @return type count.
     */
    public Vector<String> getTypeCount() {
        return typeCount;
    }

    /**
     * Method that is responsible for modifying the value of the object of the vector.
     * @param typeCount new object of the JTextField class.
     */
    public void setTypeCount(Vector<String> typeCount) {
        this.typeCount = typeCount;
    }

    /**
     * Method that returns an object of the JComboBox class.
     * @return count.
     */
    public JComboBox<String> getCount() {
        return count;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JComboBox class.
     * @param count new object of the JTextField class.
     */
    public void setCount(JComboBox<String> count) {
        this.count = count;
    }

    /**
     * Method that returns an object of the Vector type size.
     * @return type size.
     */
    public Vector<String> getTypeSize() {
        return typeSize;
    }

    /**
     * Method that is responsible for modifying the value of the object of the vector type size.
     * @param typeSize new object of the JTextField class.
     */
    public void setTypeSize(Vector<String> typeSize) {
        this.typeSize = typeSize;
    }

    /**
     * Method that returns an object of the JComboBox class.
     * @return size type.
     */
    public JComboBox getSizeType() {
        return sizeType;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JComboBox class.
     * @param sizeType new object of the JTextField class.
     */
    public void setSizeType(JComboBox sizeType) {
        this.sizeType = sizeType;
    }


}
