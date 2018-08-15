package com.fundation.search.controller;

public abstract class ACriterialSearchBuilder {
    protected CriterialSearch criterialSearch;
    public CriterialSearch getCriterialSearch() {
        return criterialSearch;
    }
    public void createNewCriterialSearch(){
            criterialSearch = new CriterialSearch();
    }
    public abstract void buildDirectory();
    public abstract void buildNameFile();
    public abstract void buildHidden();
    public abstract void buildType();
    public abstract void buildOwner();
    public abstract void buildSize();
    public abstract void buildDelimitSizeSearch();
    public abstract void buildUnitSize();
    public abstract void buildReadOnly();
    public abstract void buildKeySensitive();
    public abstract void buildSelectAll();
    public abstract void buildSelectOnlyfolder();
    public abstract void buildSelectOnlyfiles();
    public abstract void buildStarWord();
    public abstract void buildContentWord();
    public abstract void buildEndWord();
    public abstract void buildOtherExtencion();
    public abstract void buildCheckOtherExtension();
    public abstract void buildContainWordInFile();
    public abstract void buildDateChoserCreateIni();
    public abstract void buildDateChooserCreateEnd();
    public abstract void buildDateChoiserModifyIni();
    public abstract void buildDateChoiserModifyEnd();
    public abstract void buildDateChoiserAccessedIni();
    public abstract void buildDateChoiserAccessedEnd();
    public abstract void buildDateCreatedSelected();
    public abstract void buildDateModifySelected();
    public abstract void buildDateAccessedSelected();
    public abstract void buildNameCriterialDatabase();

    /**
     * multimedia specific.
     */
    public abstract void buildIsSelectedMultimediaSearch();
    public abstract void buildExtencionMultimedia();
    public abstract void buildCountMultimedia();
    public abstract void buildInputSizeMultimedia();
    public abstract void buildDurationTypeMultimedia();
    public abstract void buildVideoCode();
    public abstract void buildAudioCode();
    public abstract void buildFrameRate();
    public abstract void buildResolution();
}
