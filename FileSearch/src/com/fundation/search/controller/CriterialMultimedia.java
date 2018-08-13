package com.fundation.search.controller;

import java.util.Date;

public class CriterialMultimedia extends ACriterialSearchBuilder{
    private String directory;
    private String nameFile;
    private boolean hidden;
    private String owner;
    private long size;
    private String delimitSizeSearch;
    private String unitSize;
    private boolean readOnly;
    private boolean keySensitive;
    private boolean starWord;
    private boolean contendWord;
    private boolean endWord;
    private String otherExtencion;
    private Date dateChoserCreateIni;
    private Date dateChooserCreateEnd;
    private Date dateChoiserModifyIni;
    private Date dateChoiserModifyEnd;
    private Date dateChoiserAccessedIni;
    private Date dateChoiserAccessedEnd;
    private boolean dateCreatedSelected;
    private boolean dateModifySelected;
    private boolean dateAccessedSelected;
    private String nameCriterialDatabase;
    private boolean isSelectedMultimediaSearch;
    private String extencionMultimedia;
    private String countMultimedia;
    private String inputSizeMultimedia;
    private String durationTypeMultimedia;
    private String videoCode;
    private String audioCode;
    private String frameRate;
    private String resolution;

    public CriterialMultimedia(String directory, String nameFile, boolean hidden, String owner, long size,
                               String delimitSizeSearch, String unitSize, boolean readOnly, boolean keySensitive,
                               boolean starWord, boolean contendWord,boolean endWord, String otherExtencion, Date dateChoserCreateIni,
                               Date dateChooserCreateEnd, Date dateChoiserModifyIni, Date dateChoiserModifyEnd,
                               Date dateChoiserAccessedIni, Date dateChoiserAccessedEnd, boolean dateCreatedSelected,
                               boolean dateModifySelected, boolean dateAccessedSelected, String nameCriterialDatabase,
                               boolean isSelectedMultimediaSearch, String extencionMultimedia, String countMultimedia,
                               String inputSizeMultimedia, String durationTypeMultimedia, String videoCode,
                               String audioCode, String frameRate, String resolution) {
        this.directory = directory;
        this.nameFile = nameFile;
        this.hidden = hidden;
        this.owner = owner;
        this.size = size;
        this.delimitSizeSearch = delimitSizeSearch;
        this.unitSize = unitSize;
        this.readOnly = readOnly;
        this.keySensitive = keySensitive;
        this.starWord = starWord;
        this.contendWord = contendWord;
        this.endWord = endWord;
        this.otherExtencion = otherExtencion;
        this.dateChoserCreateIni = dateChoserCreateIni;
        this.dateChooserCreateEnd = dateChooserCreateEnd;
        this.dateChoiserModifyIni = dateChoiserModifyIni;
        this.dateChoiserModifyEnd = dateChoiserModifyEnd;
        this.dateChoiserAccessedIni = dateChoiserAccessedIni;
        this.dateChoiserAccessedEnd = dateChoiserAccessedEnd;
        this.dateCreatedSelected = dateCreatedSelected;
        this.dateModifySelected = dateModifySelected;
        this.dateAccessedSelected = dateAccessedSelected;
        this.nameCriterialDatabase = nameCriterialDatabase;
        this.isSelectedMultimediaSearch = isSelectedMultimediaSearch;
        this.extencionMultimedia = extencionMultimedia;
        this.countMultimedia = countMultimedia;
        this.inputSizeMultimedia = inputSizeMultimedia;
        this.durationTypeMultimedia = durationTypeMultimedia;
        this.videoCode = videoCode;
        this.audioCode = audioCode;
        this.frameRate = frameRate;
        this.resolution = resolution;
    }

    @Override
    public void buildDirectory() {
       criterialSearch.setDirectory(directory);
    }

    @Override
    public void buildNameFile() {
        criterialSearch.setNameFile(nameFile);
    }

    @Override
    public void buildHidden() {
        criterialSearch.setHidden(hidden);
    }

    @Override
    public void buildType() { }

    @Override
    public void buildOwner() {
        criterialSearch.setOwner(owner);
    }

    @Override
    public void buildSize() {
        criterialSearch.setSize(size);
    }

    @Override
    public void buildDelimitSizeSearch() {
        criterialSearch.setDelimitSizeSearch(delimitSizeSearch);
    }

    @Override
    public void buildUnitSize() {
        criterialSearch.setUnitSize(unitSize);
    }

    @Override
    public void buildReadOnly() {
        criterialSearch.setReadOnly(readOnly);
    }

    @Override
    public void buildKeySensitive() {
        criterialSearch.setKeySensitive(keySensitive);
    }

    @Override
    public void buildSelectAll() { }

    @Override
    public void buildSelectOnlyfolder() { }

    @Override
    public void buildSelectOnlyfiles() { }

    @Override
    public void buildStarWord() {
        criterialSearch.setStarWord(starWord);
    }

    @Override
    public void buildContentWord() {
        criterialSearch.setContentWord(contendWord);
    }

    @Override
    public void buildEndWord() {
        criterialSearch.setEndWord(endWord);
    }

    @Override
    public void buildOtherExtencion() {
        criterialSearch.setOtherExtencion(otherExtencion);
    }

    @Override
    public void buildContainWordInFile() { }

    @Override
    public void buildDateChoserCreateIni() {
        criterialSearch.setDateChoserCreateIni(dateChoserCreateIni);
    }

    @Override
    public void buildDateChooserCreateEnd() {
        criterialSearch.setDateChooserCreateEnd(dateChooserCreateEnd);
    }

    @Override
    public void buildDateChoiserModifyIni() {
        criterialSearch.setDateChoiserModifyIni(dateChoiserModifyIni);
    }

    @Override
    public void buildDateChoiserModifyEnd() {
        criterialSearch.setDateChoiserModifyEnd(dateChoiserModifyEnd);
    }

    @Override
    public void buildDateChoiserAccessedIni() {
        criterialSearch.setDateChoiserAccessedIni(dateChoiserAccessedIni);
    }

    @Override
    public void buildDateChoiserAccessedEnd() {
        criterialSearch.setDateChoiserAccessedEnd(dateChoiserAccessedEnd);
    }

    @Override
    public void buildDateCreatedSelected() {
        criterialSearch.setDateCreatedSelected(dateCreatedSelected);
    }

    @Override
    public void buildDateModifySelected() {
        criterialSearch.setDateModifySelected(dateModifySelected);
    }

    @Override
    public void buildDateAccessedSelected() {
        criterialSearch.setDateAccessedSelected(dateAccessedSelected);
    }

    @Override
    public void buildNameCriterialDatabase() {
        criterialSearch.setNameCriterialDatabase(nameCriterialDatabase);
    }

    @Override
    public void buildIsSelectedMultimediaSearch() {
        criterialSearch.setSelectedMultimediaSearch(isSelectedMultimediaSearch);
    }

    @Override
    public void buildExtencionMultimedia() {
        criterialSearch.setExtencionMultimedia(extencionMultimedia);
    }

    @Override
    public void buildCountMultimedia() {
        criterialSearch.setCountMultimedia(countMultimedia);
    }

    @Override
    public void buildInputSizeMultimedia() {
        criterialSearch.setInputSizeMultimedia(inputSizeMultimedia);
    }

    @Override
    public void buildDurationTypeMultimedia() {
        criterialSearch.setDurationTypeMultimedia(durationTypeMultimedia);
    }

    @Override
    public void buildVideoCode() {
        criterialSearch.setVideoCode(videoCode);
    }

    @Override
    public void buildAudioCode() {
        criterialSearch.setAudioCode(audioCode);
    }

    @Override
    public void buildFrameRate() {
        criterialSearch.setFrameRate(frameRate);
    }

    @Override
    public void buildResolution() {
        criterialSearch.setResolution(resolution);
    }
}
