package com.fundation.search.controller;

public class DirectorCriterialSearch {

    private ACriterialSearchBuilder criterialSearchBuilder;

    public void setCriterialBuilder(ACriterialSearchBuilder criterialSearch){
        criterialSearchBuilder = criterialSearch;
    }
    public CriterialSearch getCriterialSearch(){
        return criterialSearchBuilder.getCriterialSearch();
    }
    public void buildCriterialSearch(){
        criterialSearchBuilder.createNewCriterialSearch();
        criterialSearchBuilder.buildDirectory();
        criterialSearchBuilder.buildNameFile();
        criterialSearchBuilder.buildHidden();
        criterialSearchBuilder.buildType();
        criterialSearchBuilder.buildOwner();
        criterialSearchBuilder.buildSize();
        criterialSearchBuilder.buildDelimitSizeSearch();
        criterialSearchBuilder.buildUnitSize();
        criterialSearchBuilder.buildReadOnly();
        criterialSearchBuilder.buildKeySensitive();
        criterialSearchBuilder.buildSelectAll();
        criterialSearchBuilder.buildSelectOnlyfolder();
        criterialSearchBuilder.buildSelectOnlyfiles();
        criterialSearchBuilder.buildStarWord();
        criterialSearchBuilder.buildContentWord();
        criterialSearchBuilder.buildEndWord();
        criterialSearchBuilder.buildOtherExtencion();
        criterialSearchBuilder.buildContainWordInFile();
        criterialSearchBuilder.buildDateChoserCreateIni();
        criterialSearchBuilder.buildDateChooserCreateEnd();
        criterialSearchBuilder.buildDateChoiserModifyIni();
        criterialSearchBuilder.buildDateChoiserModifyEnd();
        criterialSearchBuilder.buildDateChoiserAccessedIni();
        criterialSearchBuilder.buildDateChoiserAccessedEnd();
        criterialSearchBuilder.buildDateCreatedSelected();
        criterialSearchBuilder.buildDateModifySelected();
        criterialSearchBuilder.buildDateAccessedSelected();
        criterialSearchBuilder.buildNameCriterialDatabase();

        /**
         * multimedia specific.
         */
        criterialSearchBuilder.buildIsSelectedMultimediaSearch();
        criterialSearchBuilder.buildExtencionMultimedia();
        criterialSearchBuilder.buildCountMultimedia();
        criterialSearchBuilder.buildInputSizeMultimedia();
        criterialSearchBuilder.buildDurationTypeMultimedia();
        criterialSearchBuilder.buildVideoCode();
        criterialSearchBuilder.buildAudioCode();
        criterialSearchBuilder.buildFrameRate();
        criterialSearchBuilder.buildResolution();
    }
}
