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

import com.fundation.search.model.CriterialSearch;
import com.fundation.search.model.CriterialSearchMultimedia;
import com.fundation.search.model.ModelSearch;
import com.fundation.search.model.ModelSearchMultimedia;
import com.fundation.search.model.Asset;
import com.fundation.search.model.AssetFile;
import com.fundation.search.model.Asset;
import com.fundation.search.model.AssetMultimedia;

import com.fundation.search.model.CriterialSearch;
import com.fundation.search.model.ModelSearch;
import com.fundation.search.utils.LoggerWrapper;
import com.fundation.search.view.View;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    private CriterialSearchMultimedia criterialSearchMultimedia;

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
        boolean checkOtherExtension = view.getPanelGeneral().getSearchPanel().panelSearchBasic.getCheckOtherExtention().isSelected();
        String containWordInFile = view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getContent().getText();

        Date dateChoserCreateIni = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDateChoserCreateIni().getDate();
        Date dateChooserCreateEnd = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDateChooserCreateEnd().getDate();
        Date dateChoiserModifyIni = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDateChooserModifyIni().getDate();
        Date dateChoiserModifyEnd = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDateChooserModifyEnd().getDate();
        Date dateChoiserAccessedIni = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDateChooserAccessedIni().getDate();
        Date dateChoiserAccessedEnd = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDateChooserAccessedEnd().getDate();

        String otherExtencionMultimedia = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getWriteExtensionMult().getText();
        String extencionList = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getType().getSelectedItem().toString();
        String countMultimedia = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getCountMultimedia().getSelectedItem().toString();
        String inputSizeMultimedia = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getSizeMutimedia().getValue().toString();
        String durationTypeMultimedia = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getSizeTypeMultimedia().getSelectedItem().toString();
        String videoCode = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getVideo().getSelectedItem().toString();
        String audioCode = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getAudio().getSelectedItem().toString();
        String frameRate = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getRate().getSelectedItem().toString();
        String resolution = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getResol().getSelectedItem().toString();
        boolean checkOtherExtentionMult =  view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getCheckOtherExtentionMult().isSelected();

        if (checkOtherExtension && !otherExtension.isEmpty()){
            fileType = otherExtension;
        }
        
        if (!keySensiteve) {
            fileName = fileName.toLowerCase();
        }
      
        criterialSearch = new CriterialSearch(pathName,fileName,fileHidden,fileType,owner,fileSize,countSearch,sizeType,
                readOnly,keySensiteve,selectAll,selectFolder,selectfiles,starWord,contentWord,endWord,otherExtension,
                containWordInFile);

        ModelSearch model = new ModelSearch();
	boolean isCheckMultimedia = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getCheckMultimedia().isSelected();
        if(checkOtherExtentionMult && !otherExtencionMultimedia.isEmpty()) extencionList = otherExtencionMultimedia;
        if(isCheckMultimedia){
            criterialSearchMultimedia = new CriterialSearchMultimedia(pathName, fileName, fileHidden, fileType, owner,
                                                                        keySensiteve, starWord, contentWord, endWord,
                                                                 extencionList, countMultimedia, inputSizeMultimedia,
                                                   durationTypeMultimedia, videoCode, audioCode, frameRate, resolution);
            ModelSearchMultimedia modelSearchMultimedia = new ModelSearchMultimedia();
            try {
                List<Asset> multimediaList = modelSearchMultimedia.searchMultimedia(criterialSearchMultimedia);
                view.getPanelGeneral().getResultPanel().cleanTable();
                for (Asset asset : multimediaList) {
                    AssetMultimedia assetMultimedia = (AssetMultimedia) asset;
                    view.getPanelGeneral().getResultPanel().addRowTable(asset.getPath(), asset.getFilename(),
                            asset.getExtension(), asset.getSize(), String.valueOf(asset.isHidden()), asset.getOwner(),null,null,null,asset.isReadOnly(), assetMultimedia.getDuration(),
                            assetMultimedia.getFrameRate(), assetMultimedia.getHeigth(), assetMultimedia.getWidth(),
                            assetMultimedia.getAspectRatio(), assetMultimedia.getCodec());
                    //System.out.println(dateChoserCreateIni +"  "+DateChooserCreateEnd);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            criterialSearch = new CriterialSearch(pathName,fileName,fileHidden,fileType,owner,fileSize,countSearch,sizeType,
                    readOnly,keySensiteve,selectAll,selectFolder,selectfiles,starWord,contentWord,endWord,otherExtension,
                    containWordInFile,dateChoserCreateIni,dateChooserCreateEnd,dateChoiserModifyIni,dateChoiserModifyEnd,
                    dateChoiserAccessedIni,dateChoiserAccessedEnd);
            try {
                List<Asset> fileList = model.searchPathName(criterialSearch);
                view.getPanelGeneral().getResultPanel().cleanTable();
                for (Asset asset : fileList) {
                    if(asset instanceof AssetFile){
                        AssetFile assetFile = (AssetFile) asset;
                        view.getPanelGeneral().getResultPanel().addRowTable(assetFile.getPath(), assetFile.getFilename(),
                                assetFile.getExtension(), assetFile.getSize(), String.valueOf(assetFile.isHidden()),
                                assetFile.getOwner(),null,null,null,assetFile.isReadOnly(),
                                0,0,0,0,null,null);
                    }else{
                        AssetMultimedia assetMultimedia = (AssetMultimedia) asset;
                    }
                }
            } catch (Exception e) {
                System.out.println("hola mundo");
            }
        }
	
        LOGGER.info("Controller init: exit");
    }
}
