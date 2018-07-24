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
        labelNameFile.setBounds(40, 60, 100, 30);
        add(labelNameFile);

        nameFile = new JTextField();
        nameFile.setBounds(150, 60, 340, 30);
        add(nameFile);

        labelSearchPath = new JLabel();
        labelSearchPath.setText("Document Path: ");
        labelSearchPath.setBounds(40, 120, 120, 30);
        add(labelSearchPath);

        path = new JTextField();
        path.setBounds(150, 120, 340, 30);
        add(path);

        buttonPath = new JButton("Path");
        buttonPath.addActionListener(this);
        buttonPath.setBounds(520, 120, 120, 30);
        add(buttonPath);

        searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.setBounds(520, 190, 120, 30);
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
}
