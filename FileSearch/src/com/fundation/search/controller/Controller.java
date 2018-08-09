/*
 *
 *  * @(#)Asset.java
 *  *
 *  * Copyright (c) 2018 Jala Foundation.
 *  * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  * All rights reserved.
 *  *
 *  * This software is the confidential and proprietary information of
 *  * Jala Foundation, ("Confidential Information").  You shall not
 *  * disclose such Confidential Information and shall use it only in
 *  * accordance with the terms of the license agreement you entered into
 *  * with Jala Foundation.
 *
 */

package com.fundation.search.controller;

import com.fundation.search.model.Asset;
import com.fundation.search.model.AssetFile;
import com.fundation.search.model.AssetMultimedia;
import com.fundation.search.model.CriterialSearch;
import com.fundation.search.model.ModelSearch;
import com.fundation.search.utils.LoggerWrapper;
import com.fundation.search.view.View;
import java.util.List;
import java.util.Objects;
import org.apache.log4j.Logger;

/**
 * Controller class where the communication will be made with the view.
 *
 * @author William Claros Revollo - AT - [07]
 * @version 1.0.
 */
public class Controller {

    private static final Logger LOGGER = LoggerWrapper.getInstance().getLogger();
    private View view;
    private ModelSearch model;
    private CriterialSearch criterialSearch;

    /**
     * A constructor of the Controller class that receives 2 parameters that are a ModelSearch object and an object
     * in the SearchFrame view.
     */
    public void init() {
        LOGGER.info("Controller init: enter");
        this.view = new View();
        /*view.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo)
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.SaharaSkin");*/
        this.model = new ModelSearch();
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getSearchButton().addActionListener(e -> getData());
        LOGGER.info("Controller init: exit");
    }

    /**
     * Method that is charge of making the data capture and the setting of the View. And also the communication
     * with the Model.
     */
    private void getData() {
        LOGGER.info("Controller getData: enter");
        String pathName = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getPath().getText();
        String fileName = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getNameFile().getText();
        boolean fileHidden = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getHiddenFile().isSelected();
        String fileType = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getFileType().getSelectedItem().toString();
        String owner = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getOwner().getText();
        long fileSize = Long.parseLong(view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getSizeFile().getValue().toString());
        String countSearch = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getCount().getSelectedItem().toString();
        String sizeType = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getSizeType().getSelectedItem().toString();
        boolean readOnly = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getReadOnly().isSelected();
        boolean keySensitive = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getKeySensitive().isSelected();
        boolean selectAll = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getAll().isSelected();
        boolean selectFolder = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getFolder().isSelected();
        boolean selectfiles = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getFile().isSelected();
        boolean starWord = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getStartWord().isSelected();
        boolean contentWord = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getContentWord().isSelected();
        boolean endWord = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getEndWord().isSelected();
        String otherExtension = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getWriteExtension().getText();
        boolean checkOtherExtension = view.getPanelGeneral().getSearchPanel().panelSearchBasic.getCheckOtherExtention().isSelected();
        String containWordInFile = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getContent().getText();

        if (checkOtherExtension && !otherExtension.isEmpty()){
            fileType = otherExtension;
        }
        
        if (!keySensitive) {
            fileName = fileName.toLowerCase();
        }
      
        criterialSearch = new CriterialSearch(pathName,fileName,fileHidden,fileType,owner,fileSize,countSearch,sizeType,
                readOnly,keySensiteve,selectAll,selectFolder,selectfiles,starWord,contentWord,endWord,"",

        ModelSearch model = new ModelSearch();
        //model.saveCriteriaDataBase(criterialSearch);

        try {
            List<Asset> fileList = model.searchPathName(criterialSearch);
            view.getPanelGeneral().getResultPanel().cleanTable();
            for (Asset asset : fileList) {
                if (asset instanceof AssetFile) {
                    AssetFile assetFile = (AssetFile) asset;
                    view.getPanelGeneral().getResultPanel().addRowTable(assetFile.getPath(), assetFile.getFilename(), assetFile.getFileExtension(), assetFile.getSize(), String.valueOf(assetFile.getHidden()), assetFile.getOwner(), null, null, null, null, assetFile.getReadOnly());
                } else {
                    AssetMultimedia assetMultimedia = (AssetMultimedia) asset;
                }
            }
        } catch (Exception e) {
            System.out.println("Hello World...");
        }
        LOGGER.info("Controller init: exit");
    }
}
