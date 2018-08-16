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

import com.fundation.search.model.*;
import com.fundation.search.utils.LoggerWrapper;
import com.fundation.search.view.View;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
    private Search search;
    private String writeDescritionCritera;
    private Map <Integer,CriterialSearch> searchCriteriaMapOfDataBase;
    private String pathAux;
    private CriterialSearch criterialSearch;

    /**
     * A constructor of the Controller class that receives 2 parameters that are a ModelSearch object and an object
     * in the SearchFrame view.
     */
    public void init() {
        LOGGER.info("Controller init: enter");
        this.view = new View();
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getSearchButton().addActionListener(e -> {
            try {
                getData();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        view.getPanelGeneral().getSearchPanel().getPanelDataBase().getLoadCriteriaButton().addActionListener(e -> listenLoadButton());
        view.getPanelGeneral().getSearchPanel().getPanelDataBase().getSaveCriteriaButton().addActionListener(e -> saveDataBase(criterialSearch));
        updateDataBase();
        LOGGER.info("Controller init: exit");
    }

    /**
     * Method that is charge of making the data capture and the setting of the View. And also the communication
     * with the Model.
     */
    private void getData() throws IOException {
        //LOGGER.info("Controller getData: enter");
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
        boolean dateCreatedSelected = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDatecreated().isSelected();
        boolean dateModifySelected = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDatemodificate().isSelected();
        boolean dateAccessedSelected = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getAccessDate().isSelected();

        boolean isCheckMultimedia = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getCheckMultimedia().isSelected();
        boolean checkOtherExtentionMult = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getCheckOtherExtentionMult().isSelected();
        String otherExtencionMultimedia = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getWriteExtensionMult().getText();
        String extencionList = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getType().getSelectedItem().toString();
        String countMultimedia = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getCountMultimedia().getSelectedItem().toString();
        String inputSizeMultimedia = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getSizeMutimedia().getValue().toString();
        String durationTypeMultimedia = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getSizeTypeMultimedia().getSelectedItem().toString();
        String videoCode = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getVideo().getSelectedItem().toString();
        String audioCode = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getAudio().getSelectedItem().toString();
        String frameRate = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getRate().getSelectedItem().toString();
        String resolution = view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getResol().getSelectedItem().toString();
        pathAux = pathName;
        if (checkOtherExtension && !otherExtension.isEmpty()) {
            fileType = otherExtension;
        }
        if (!keySensiteve) {
            fileName = fileName.toLowerCase();
        }

        SearchMultimedia modelMultimedia = new SearchMultimedia();
        DirectorCriterialSearch directorCriterialSearch = new DirectorCriterialSearch();
        if (checkOtherExtentionMult && !otherExtencionMultimedia.isEmpty())
            extencionList = otherExtencionMultimedia;
        if (isCheckMultimedia) {
            ACriterialSearchBuilder multimedia = new CriterialMultimedia(pathName, fileName,fileHidden,owner, fileSize,
                    countSearch, sizeType,readOnly, keySensiteve, starWord,contentWord,endWord, otherExtension, dateChoserCreateIni,
                    dateChooserCreateEnd, dateChoiserModifyIni, dateChoiserModifyEnd, dateChoiserAccessedIni,
                    dateChoiserAccessedEnd, dateCreatedSelected, dateModifySelected,dateAccessedSelected, "",
                    isCheckMultimedia, extencionList, countMultimedia, inputSizeMultimedia, durationTypeMultimedia,videoCode,
                    audioCode, frameRate, resolution);
            directorCriterialSearch.setCriterialBuilder(multimedia);
            directorCriterialSearch.buildCriterialSearch();
            criterialSearch = directorCriterialSearch.getCriterialSearch();
            try {
                List<Asset> multimediaList = modelMultimedia.searchCriterial(criterialSearch);
                view.getPanelGeneral().getResultPanel().cleanTable();
                for (Asset asset : multimediaList) {
                    AssetMultimedia assetMultimedia = (AssetMultimedia) asset;
                    view.getPanelGeneral().getResultPanel().addRowTable(asset.getPath(), asset.getFilename(),
                            asset.getExtension(), asset.getSize(), String.valueOf(asset.isHidden()), asset.getOwner(),
                            assetMultimedia.getDateCreate(), assetMultimedia.getDatAccessed(), assetMultimedia.getDateModify(), asset.isReadOnly(), assetMultimedia.getDuration(),
                            assetMultimedia.getFrameRate(), assetMultimedia.getHeigth(), assetMultimedia.getWidth(),
                            assetMultimedia.getAspectRatio(), assetMultimedia.getCodec());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            SearchFile searchFile = new SearchFile();
            ACriterialSearchBuilder files = new CriterialFile(pathName,fileName,fileHidden,fileType,owner,fileSize,
                    countSearch,sizeType,readOnly,keySensiteve, selectAll,selectFolder,selectfiles,starWord,
                    contentWord,endWord,otherExtension,checkOtherExtension,containWordInFile, dateChoserCreateIni,dateChooserCreateEnd,
                    dateChoiserModifyIni, dateChoiserModifyEnd, dateChoiserAccessedIni,dateChoiserAccessedEnd,
                    dateCreatedSelected, dateModifySelected, dateAccessedSelected, "");
            directorCriterialSearch.setCriterialBuilder(files);
            directorCriterialSearch.buildCriterialSearch();
            criterialSearch = directorCriterialSearch.getCriterialSearch();
            List<Asset> filesList = searchFile.searchCriterial(criterialSearch);
            view.getPanelGeneral().getResultPanel().cleanTable();
            for(Asset asset: filesList){
                AssetFile assetFile = (AssetFile) asset;
                view.getPanelGeneral().getResultPanel().addRowTable(assetFile.getPath(), assetFile.getFilename(),
                        assetFile.getExtension(), assetFile.getSize(), String.valueOf(assetFile.isHidden()),
                        assetFile.getOwner(), assetFile.getDateCreate(), assetFile.getDateModify(), assetFile.getDatAccessed(),
                        assetFile.isReadOnly(), 0, 0, 0, 0, null, null);
            }
        }
        //LOGGER.info("Controller init: exit");
    }

    private void saveDataBase(CriterialSearch criterialSearch){
        LOGGER.info("Controller saveDataBase: enter");
        writeDescritionCritera =  view.getPanelGeneral().getSearchPanel().getPanelDataBase().getWriteDescritionCritera().getText();
        if (!writeDescritionCritera.isEmpty()){
            search = new SearchFile();
            criterialSearch.setNameCriterialDatabase(writeDescritionCritera);
            criterialSearch.setDirectory(pathAux);
            search.saveCriteriaDataBase(criterialSearch);
            updateDataBase();
        }
        LOGGER.info("Controller saveDataBase: exit");
    }

    private void listenLoadButton() {
        searchCriteriaMapOfDataBase = search.getAllDataCriteriaDataBase();
        int row =  view.getPanelGeneral().getSearchPanel().getPanelDataBase().getTable().getSelectedRow();
        String id=view.getPanelGeneral().getSearchPanel().getPanelDataBase().getTable().getValueAt(row, 0).toString();
        int aux2 = Integer.parseInt(id);

        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getPath().setText(searchCriteriaMapOfDataBase.get(aux2).getDirectory());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getNameFile().setText(searchCriteriaMapOfDataBase.get(aux2).getNameFile());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getHiddenFile().setSelected(searchCriteriaMapOfDataBase.get(aux2).isHidden());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getFileType().setSelectedItem(searchCriteriaMapOfDataBase.get(aux2).getType());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getOwner().setText(searchCriteriaMapOfDataBase.get(aux2).getOwner());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getSizeFile().setValue(searchCriteriaMapOfDataBase.get(aux2).getSize());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getCount().setSelectedItem(searchCriteriaMapOfDataBase.get(aux2).getDelimitSizeSearch());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getSizeType().setSelectedItem(searchCriteriaMapOfDataBase.get(aux2).getUnitSize());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getReadOnly().setSelected(searchCriteriaMapOfDataBase.get(aux2).isReadOnly());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getKeySensitive().setSelected(searchCriteriaMapOfDataBase.get(aux2).isKeySensitive());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getAll().setSelected(searchCriteriaMapOfDataBase.get(aux2).isSelectAll());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getFolder().setSelected(searchCriteriaMapOfDataBase.get(aux2).isSelectOnlyfolder());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getFile().setSelected(searchCriteriaMapOfDataBase.get(aux2).isSelectOnlyfiles());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getStartWord().setSelected(searchCriteriaMapOfDataBase.get(aux2).isStarWord());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getContentWord().setSelected(searchCriteriaMapOfDataBase.get(aux2).isContentWord());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getEndWord().setSelected(searchCriteriaMapOfDataBase.get(aux2).isEndWord());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getWriteExtension().setText(searchCriteriaMapOfDataBase.get(aux2).getOtherExtencion());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getCheckOtherExtention().setSelected(searchCriteriaMapOfDataBase.get(aux2).isCheckOtherExtension());
        view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getContent().setText(searchCriteriaMapOfDataBase.get(aux2).getContainWordInFile());

        view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDateChoserCreateIni().setDate(searchCriteriaMapOfDataBase.get(aux2).getDateChoserCreateIni());
        view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDateChooserCreateEnd().setDate(searchCriteriaMapOfDataBase.get(aux2).getDateChooserCreateEnd());
        view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDateChooserModifyIni().setDate(searchCriteriaMapOfDataBase.get(aux2).getDateChoiserModifyIni());
        view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDateChooserModifyEnd().setDate(searchCriteriaMapOfDataBase.get(aux2).getDateChoiserModifyEnd());
        view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDateChooserAccessedIni().setDate(searchCriteriaMapOfDataBase.get(aux2).getDateChoiserAccessedIni());
        view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDateChooserAccessedEnd().setDate(searchCriteriaMapOfDataBase.get(aux2).getDateChoiserAccessedEnd());
        view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDatecreated().setSelected(searchCriteriaMapOfDataBase.get(aux2).isDateCreatedSelected());
        view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getDatemodificate().setSelected(searchCriteriaMapOfDataBase.get(aux2).isDateModifySelected());
        view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getAccessDate().setSelected(searchCriteriaMapOfDataBase.get(aux2).isDateAccessedSelected());
        view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getCheckMultimedia().setSelected(false);
        boolean isSelect = searchCriteriaMapOfDataBase.get(aux2).isSelectedMultimediaSearch();
        if (isSelect){
            view.getPanelGeneral().getSearchPanel().getPanelSearchBasic().getFileType().setSelectedItem(" ");
            view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getCheckMultimedia().setSelected(searchCriteriaMapOfDataBase.get(aux2).isSelectedMultimediaSearch());
            view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getCheckOtherExtentionMult().setSelected(searchCriteriaMapOfDataBase.get(aux2).isCheckOtherExtentionMult());
            view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getType().setSelectedItem(searchCriteriaMapOfDataBase.get(aux2).getExtencionMultimedia());
            view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getCountMultimedia().setSelectedItem(searchCriteriaMapOfDataBase.get(aux2).getCountMultimedia());
            view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getSizeMutimedia().setValue(Long.parseLong(searchCriteriaMapOfDataBase.get(aux2).getInputSizeMultimedia()));
            view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getSizeTypeMultimedia().setSelectedItem(searchCriteriaMapOfDataBase.get(aux2).getDurationTypeMultimedia());
            view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getVideo().setSelectedItem(searchCriteriaMapOfDataBase.get(aux2).getVideoCode());
            view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getAudio().setSelectedItem(searchCriteriaMapOfDataBase.get(aux2).getAudioCode());
            view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getRate().setSelectedItem(searchCriteriaMapOfDataBase.get(aux2).getFrameRate());
            view.getPanelGeneral().getSearchPanel().getPanelSearchAdvanced().getResol().setSelectedItem(searchCriteriaMapOfDataBase.get(aux2).getResolution());
        }
    }

    /**
     * This method is complement of getDataFromCriteriaMap.
     *
     * @param (idOfCriteria, searchCriteria) .
     */
    private Object[] getDataFromCriteriaMap(Integer idOfCriteria, CriterialSearch searchCriteria) {
        LOGGER.info("getDataFromAsset Entry");
        // Object[] for create row and sent this to table result on User Interface
        Object[] dataFromAsset = new Object[3]; // number of columns
        // Getting data for table result
        dataFromAsset[0] = idOfCriteria;
        dataFromAsset[1] = searchCriteria.getNameCriterialDatabase();
        LOGGER.info("getDataFromAsset Exit");
        return dataFromAsset;
    }
    private void updateDataBase(){
        LOGGER.info("Controller updateDataBase: enter");
        view.getPanelGeneral().getSearchPanel().getPanelDataBase().cleanTable();
        Map<Integer, CriterialSearch> searchCriteriaMapOfDataBase;
        search = new SearchFile();
        searchCriteriaMapOfDataBase = search.getAllDataCriteriaDataBase();
        searchCriteriaMapOfDataBase.forEach((k,v) -> view.getPanelGeneral().getSearchPanel().getPanelDataBase().
                addRowTable(this.getDataFromCriteriaMap(k,v)));
        LOGGER.info("Controller updateDataBase: exit");
    }
}
