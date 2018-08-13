package com.fundation.search.controller;

import java.util.Date;

public class CriterialFile extends ACriterialSearchBuilder{
    private String directory;
    private String nameFile;
    private boolean hidden;
    private String type;
    private String owner;
    private long size;
    private String delimitSizeSearch;
    private String unitSize;
    private boolean readOnly;
    private boolean keySensitive;
    private boolean selectAll;
    private boolean selectOnlyfolder;
    private boolean selectOnlyfiles;
    private boolean starWord;
    private boolean contentWord;
    private boolean endWord;
    private String otherExtencion;
    private String containWordInFile;
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

    public CriterialFile(String directory, String nameFile, boolean hidden, String type, String owner, long size,
                         String delimitSizeSearch, String unitSize, boolean readOnly, boolean keySensitive,
                         boolean selectAll, boolean selectOnlyfolder, boolean selectOnlyfiles, boolean starWord,
                         boolean contentWord, boolean endWord, String otherExtencion, String containWordInFile,
                         Date dateChoserCreateIni, Date dateChooserCreateEnd, Date dateChoiserModifyIni,
                         Date dateChoiserModifyEnd, Date dateChoiserAccessedIni, Date dateChoiserAccessedEnd,
                         boolean dateCreatedSelected, boolean dateModifySelected, boolean dateAccessedSelected,
                         String nameCriterialDatabase) {
        this.directory = directory;
        this.nameFile = nameFile;
        this.hidden = hidden;
        this.type = type;
        this.owner = owner;
        this.size = size;
        this.delimitSizeSearch = delimitSizeSearch;
        this.unitSize = unitSize;
        this.readOnly = readOnly;
        this.keySensitive = keySensitive;
        this.selectAll = selectAll;
        this.selectOnlyfolder = selectOnlyfolder;
        this.selectOnlyfiles = selectOnlyfiles;
        this.starWord = starWord;
        this.contentWord = contentWord;
        this.endWord = endWord;
        this.otherExtencion = otherExtencion;
        this.containWordInFile = containWordInFile;
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
    public void buildType() {
        criterialSearch.setType(type);
    }

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
    public void buildSelectAll() {
        criterialSearch.setSelectAll(selectAll);
    }

    @Override
    public void buildSelectOnlyfolder() {
        criterialSearch.setSelectOnlyfolder(selectOnlyfolder);
    }

    @Override
    public void buildSelectOnlyfiles() {
        criterialSearch.setSelectOnlyfiles(selectOnlyfiles);
    }

    @Override
    public void buildStarWord() {
        criterialSearch.setStarWord(starWord);
    }

    @Override
    public void buildContentWord() {
        criterialSearch.setContentWord(contentWord);
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
    public void buildContainWordInFile() {
        criterialSearch.setContainWordInFile(containWordInFile);
    }

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

    }

    @Override
    public void buildExtencionMultimedia() {

    }

    @Override
    public void buildCountMultimedia() {

    }

    @Override
    public void buildInputSizeMultimedia() {

    }

    @Override
    public void buildDurationTypeMultimedia() {

    }

    @Override
    public void buildVideoCode() {

    }

    @Override
    public void buildAudioCode() {

    }

    @Override
    public void buildFrameRate() {

    }

    @Override
    public void buildResolution() {

    }
}
