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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;

import javax.swing.SpinnerNumberModel;
import javax.swing.text.DefaultFormatter;
/**
 * Class that creates the basic search panel.
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
    private JSpinner sizeFile;
    private JButton searchButton;
    private PanelSearchResult panelResult;
    //private ModelSearch modelSearch;
    private JCheckBox checkOtherExtention;

    private ImageIcon openBtn1;
    private ImageIcon openBtn2;
    private ImageIcon openBtn3;

    private ImageIcon searchBtn1;
    private ImageIcon searchBtn2;
    private ImageIcon searchBtn3;

    /**
     * Constructor that creates the basic search panel.
     */
    public PanelSearchBasic(PanelSearchResult panelResult) {
        settingPanel();
        initComponent();
        this.panelResult = panelResult;
        //modelSearch = new ModelSearch();
    }
    public PanelSearchBasic() {
        settingPanel();
        initComponent();
    }

    /**
     * Method that contains Basic Panel settings.
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
        JLabel labelPanelBasic = new JLabel("SEARCH");
        labelPanelBasic.setBounds(190, 10, 130, 30);
        add(labelPanelBasic);

        JLabel labelSearchPath = new JLabel("Path:");
        labelSearchPath.setBounds(20, 50, 50, 30);
        add(labelSearchPath);

        path = new JTextField();
        path.setBounds(90, 50, 300, 30);
        path.setEditable(false);
        //path.setEnabled(false);
        add(path);

        JLabel labelNameFile = new JLabel("File Name: ");
        labelNameFile.setBounds(20, 90, 120, 30);
        add(labelNameFile);

        nameFile = new JTextField();
        nameFile.setBounds(90, 90, 90, 30);
        add(nameFile);

        JLabel labelOwner = new JLabel("Owner");
        labelOwner.setBounds(183, 90, 90, 30);
        add(labelOwner);
        owner = new JTextField();
        owner.setBounds(225, 90, 90, 30);
        add(owner);

        JLabel labelContent = new JLabel("Contains");
        labelContent.setBounds(317, 90, 100, 30);
        add(labelContent);

        content = new JTextField();
        content.setBounds(370, 90, 70, 30);
        add(content);

        all = new JRadioButton("All");
        all.setBounds(70, 160, 50, 20);
        add(all);

        file = new JRadioButton("File", true);
        file.setBounds(70, 180, 50, 20);
        add(file);

        folder = new JRadioButton("Folder");
        folder.setBounds(70, 200, 70, 20);
        add(folder);

        group1 = new ButtonGroup();
        group1.add(all);
        group1.add(file);
        group1.add(folder);

        startWord = new JRadioButton("Start Word");
        startWord.setBounds(160, 160, 100, 20);
        add(startWord);

        contentWord = new JRadioButton("Content Word", true);
        contentWord.setBounds(160, 180, 110, 20);
        add(contentWord);

        endWord = new JRadioButton("End Word");
        endWord.setBounds(160, 200, 100, 20);
        add(endWord);

        group2 = new ButtonGroup();
        group2.add(startWord);
        group2.add(contentWord);
        group2.add(endWord);

        readOnly = new JCheckBox("Read Only");
        readOnly.setBounds(290, 162, 100, 20);
        add(readOnly);

        hiddenFile = new JCheckBox("Hidden");
        hiddenFile.setBounds(290, 183, 100, 20);
        add(hiddenFile);

        keySensitive = new JCheckBox("Key Sensitive");
        keySensitive.setBounds(290, 204, 120, 20);
        add(keySensitive);

        JLabel labelTypeDocument = new JLabel("Documents");
        labelTypeDocument.setBounds(50, 254, 80, 30);
        add(labelTypeDocument);

        checkOtherExtention = new JCheckBox("Other extension");
        checkOtherExtention.setBounds(20, 284, 120, 30);
        add(checkOtherExtention);

        writeExtension = new JTextField();
        writeExtension.setBounds(140, 284, 80, 30);
        add(writeExtension);
        writeExtension.setEnabled(false);

        JLabel labelExtension = new JLabel("Extension");
        labelExtension.setBounds(22, 320, 80, 30);
        add(labelExtension);

        typeFile = new Vector();
        typeFile.add(" ");
        typeFile.add("txt");
        typeFile.add("doc");
        typeFile.add("pdf");
        typeFile.add("xlsx");
        typeFile.add("png");
        typeFile.add("jpg");
        fileType = new JComboBox(typeFile);
        fileType.setBounds(140, 320, 80, 30);
        add(fileType);


        JLabel labelFileSize = new JLabel("File Size");
        labelFileSize.setBounds(255, 254, 80, 30);
        add(labelFileSize);

        typeCount = new Vector();
        typeCount.add(" = ");
        typeCount.add(" < ");
        typeCount.add(" > ");
        count = new JComboBox(typeCount);
        count.setBounds(230, 284, 40, 30);
        add(count);


        sizeFile = new JSpinner(new SpinnerNumberModel(0,0,999999999,1));
        JSpinner.NumberEditor jsEditor = (JSpinner.NumberEditor)sizeFile.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) jsEditor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        sizeFile.setBounds(270, 284, 85, 30);
        add(sizeFile);

        typeSize = new Vector();
        typeSize.add("Byte");
        typeSize.add("KByte");
        typeSize.add("MByte");
        typeSize.add("GByte");
        sizeType = new JComboBox(typeSize);
        sizeType.setBounds(230, 320, 124, 30);
        add(sizeType);

        JButton buttonPath = new JButton();
        buttonPath.addActionListener(this);
        openBtn1 = new ImageIcon("Icons/open1.png");
        openBtn2 = new ImageIcon("Icons/open.png");
        openBtn3 = new ImageIcon("Icons/open.png");

        buttonPath.setBounds(376, 50, 80, 30);
        ConfigurationButton(buttonPath, openBtn1, openBtn2, openBtn3);
        add(buttonPath);

        searchButton = new JButton("Search");
        searchButton.setHorizontalTextPosition( SwingConstants.CENTER );
        searchButton.setVerticalTextPosition( SwingConstants.BOTTOM );
        searchButton.setBounds(360, 260, 80, 100);

        searchBtn1 = new ImageIcon("Icons/busqueda2.png");
        searchBtn2 = new ImageIcon("Icons/busqueda1.png");
        searchBtn3 = new ImageIcon("Icons/busqueda1.png");
        ConfigurationButton(searchButton, searchBtn1, searchBtn2, searchBtn3);
        add(searchButton);

        // Enable and disable check other extension of the documents
        checkOtherExtention.addChangeListener(eve -> CheckBoxOtherExtension(eve));
    }

    /**
     * Method for configuration buttons.
     * @param button object JButton.
     * @param img1 first image.
     * @param img2 second image.
     * @param img3 third image.
     */
    public void ConfigurationButton(JButton button, ImageIcon img1, ImageIcon img2, ImageIcon img3) {

        button.setIcon(img1);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setRolloverEnabled(true);
        button.setRolloverIcon(img2);
        button.setPressedIcon(img3);
    }

    /**
     * This method is for enable and disable checkbox of other extension.
     * @param event
     */
    public void CheckBoxOtherExtension (ChangeEvent event) {
        if (checkOtherExtention.isSelected()) {
            writeExtension.setEnabled(true);
            fileType.setEnabled(false);
        }else{
            writeExtension.setEnabled(false);
            fileType.setEnabled(true);
        }
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
     * Method that returns an object of the JRadioButton class.
     * @return all
     */
    public JRadioButton getAll() {
        return all;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JRadioButton class.
     * @param all new object of the JRadioButton class.
     */
    public void setAll(JRadioButton all) {
        this.all = all;
    }

    /**
     * Method that returns an object of the JRadioButton class.
     * @return file
     */
    public JRadioButton getFile() {
        return file;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JRadioButton class.
     * @param file new object of the JRadioButton class.
     */
    public void setFile(JRadioButton file) {
        this.file = file;
    }

    /**
     * Method that returns an object of the JRadioButton class.
     * @return folder
     */
    public JRadioButton getFolder() {
        return folder;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JRadioButton class.
     * @param folder new object of the JRadioButton class.
     */
    public void setFolder(JRadioButton folder) {
        this.folder = folder;
    }

    /**
     * Method that returns an object of the JRadioButton class.
     * @return startWord
     */
    public JRadioButton getStartWord() {
        return startWord;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JRadioButton class.
     * @param startWord new object of the JRadioButton class.
     */
    public void setStartWord(JRadioButton startWord) {
        this.startWord = startWord;
    }

    /**
     * Method that returns an object of the JRadioButton class.
     * @return contentWord
     */
    public JRadioButton getContentWord() {
        return contentWord;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JRadioButton class.
     * @param contentWord new object of the JRadioButton class.
     */
    public void setContentWord(JRadioButton contentWord) {
        this.contentWord = contentWord;
    }

    /**
     * Method that returns an object of the JRadioButton class.
     * @return endWord
     */
    public JRadioButton getEndWord() {
        return endWord;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JRadioButton class.
     * @param endWord new object of the JRadioButton class.
     */
    public void setEndWord(JRadioButton endWord) {
        this.endWord = endWord;
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

    /**
     * Method that returns an object of the JSpinner class.
     * @return sizeFile.
     */
    public JSpinner getSizeFile() {
        return sizeFile;
    }

    /**
     * Method that returns an object of the JCheckBox class.
     * @return checkOtherExtention.
     */
    public JCheckBox getCheckOtherExtention() {
        return checkOtherExtention;
    }

    /**
     * Method that is responsible for modifying the value of the object of the JCheckBox class.
     * @param checkOtherExtention new object of the JCheckBox class.
     */
    public void setCheckOtherExtention(JCheckBox checkOtherExtention) {
        this.checkOtherExtention = checkOtherExtention;
    }
}
