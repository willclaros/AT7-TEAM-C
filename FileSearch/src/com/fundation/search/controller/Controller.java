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

import com.fundation.search.model.AssetFile;
import com.fundation.search.model.CriterialSearch;
import com.fundation.search.model.ModelSearch;
import com.fundation.search.view.View;

import java.util.List;
import java.util.Objects;

/**
 * Controller class where the communication will be made with the view.
 *
 * @author William Claros Revollo - AT - [07]
 * @version 1.0.
 */
public class Controller {

    private View view;
    private ModelSearch model;
    private CriterialSearch criterialSearch;

    /**
     * A constructor of the Controller class that receives 2 parameters that are a ModelSearch object and an object
     * in the SearchFrame view.
     */
    public void init() {
        this.view = new View();
        this.model = new ModelSearch();
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getSearchButton().addActionListener(e -> getData());
    }

    /**
     * Method that is in charge of making the data capture and the setting of the View. And also the communication
     * with the Model.
     */
    private void getData() {
        String pathName = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getPath().getText();
        String fileName = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getNameFile().getText();
        boolean fileHidden = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getHiddenFile().isSelected();
        String fileType = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getFileType().getSelectedItem().toString();
        String owner = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getOwner().getText();
        long fileSize = Long.parseLong(view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getSizeFile().getValue().toString());
        String countSearch = Objects.requireNonNull(view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getCount().getSelectedItem()).toString();
        String sizeType = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getSizeType().getSelectedItem().toString();
        boolean readOnly = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getReadOnly().isSelected();
        boolean keySensiteve = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getKeySensitive().isSelected();
        boolean selectAll = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getAll().isSelected();
        boolean selectFolder = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getFolder().isSelected();
        boolean selectfiles = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getFile().isSelected();
        boolean starWord = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getStartWord().isSelected();
        boolean contentWord = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getContentWord().isSelected();
        boolean endWord = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getEndWord().isSelected();
        String otherExtension = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getWriteExtension().getText();

        criterialSearch = new CriterialSearch(pathName,fileName,fileHidden,fileType,owner,fileSize,countSearch,sizeType,
                readOnly,keySensiteve,selectAll,selectFolder,selectfiles,starWord,contentWord,endWord,otherExtension);

        ModelSearch model = new ModelSearch();

        try {
            List<AssetFile> fileList = model.searchPathName(criterialSearch);
            //List<AssetFile> fileList = model.searchPathName(pathName, fileName, fileType, fileSize, fileHidden, owner);
            for (AssetFile a : fileList) {
                System.out.println(a.getFilename());
                view.getPanelGeneral().getResultPanel().addRowTable(a.getPath(), a.getFilename(), a.getExtension(), a.getSize(), null, null);
            }
        } catch (Exception e) {
        }
    }
}
