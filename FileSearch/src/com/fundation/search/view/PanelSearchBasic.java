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

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    private JTextField textPath;
    private JButton buttonPath;
    private JButton searchButton;

    private JLabel labelPanelBasic;

    /**
     * Constructor that creates the basic search panel.
     */
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

        textPath = new JTextField();
        textPath.setBounds(150, 120, 340, 30);
        add(textPath);

        buttonPath = new JButton("Path");
        buttonPath.addActionListener(this);
        buttonPath.setBounds(520, 120, 120, 30);
        add(buttonPath);

        searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.setBounds(520, 190, 120, 30);
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
                textPath.setText("...");
            } else {
                textPath.setText(fileName.getAbsolutePath());
            }
        }
    }
}
