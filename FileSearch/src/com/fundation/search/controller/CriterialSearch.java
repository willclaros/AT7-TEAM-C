package com.fundation.search.controller;

import java.util.Date;

public class CriterialSearch {
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
    private boolean checkOtherExtension;
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

    /**
     * multimedia specific.
     */
    private boolean isSelectedMultimediaSearch;
    private boolean checkOtherExtentionMult;
    private String extencionMultimedia;
    private String countMultimedia;
    private String inputSizeMultimedia;
    private String durationTypeMultimedia;
    private String videoCode;
    private String audioCode;
    private String frameRate;
    private String resolution;

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getDelimitSizeSearch() {
        return delimitSizeSearch;
    }

    public void setDelimitSizeSearch(String delimitSizeSearch) {
        this.delimitSizeSearch = delimitSizeSearch;
    }

    public String getUnitSize() {
        return unitSize;
    }

    public void setUnitSize(String unitSize) {
        this.unitSize = unitSize;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isKeySensitive() {
        return keySensitive;
    }

    public void setKeySensitive(boolean keySensitive) {
        this.keySensitive = keySensitive;
    }

    public boolean isSelectAll() {
        return selectAll;
    }

    public void setSelectAll(boolean selectAll) {
        this.selectAll = selectAll;
    }

    public boolean isSelectOnlyfolder() {
        return selectOnlyfolder;
    }

    public void setSelectOnlyfolder(boolean selectOnlyfolder) {
        this.selectOnlyfolder = selectOnlyfolder;
    }

    public boolean isSelectOnlyfiles() {
        return selectOnlyfiles;
    }

    public void setSelectOnlyfiles(boolean selectOnlyfiles) {
        this.selectOnlyfiles = selectOnlyfiles;
    }

    public boolean isStarWord() {
        return starWord;
    }

    public void setStarWord(boolean starWord) {
        this.starWord = starWord;
    }

    public boolean isContentWord() {
        return contentWord;
    }

    public void setContentWord(boolean contentWord) {
        this.contentWord = contentWord;
    }

    public boolean isEndWord() {
        return endWord;
    }

    public void setEndWord(boolean endWord) {
        this.endWord = endWord;
    }

    public String getOtherExtencion() {
        return otherExtencion;
    }

    public void setOtherExtencion(String otherExtencion) {
        this.otherExtencion = otherExtencion;
    }

    public boolean isCheckOtherExtension() {
        return checkOtherExtension;
    }

    public void setCheckOtherExtension(boolean checkOtherExtension) {
        this.checkOtherExtension = checkOtherExtension;
    }

    public String getContainWordInFile() {
        return containWordInFile;
    }

    public void setContainWordInFile(String containWordInFile) {
        this.containWordInFile = containWordInFile;
    }

    public Date getDateChoserCreateIni() {
        return dateChoserCreateIni;
    }

    public void setDateChoserCreateIni(Date dateChoserCreateIni) {
        this.dateChoserCreateIni = dateChoserCreateIni;
    }

    public Date getDateChooserCreateEnd() {
        return dateChooserCreateEnd;
    }

    public void setDateChooserCreateEnd(Date dateChooserCreateEnd) {
        this.dateChooserCreateEnd = dateChooserCreateEnd;
    }

    public Date getDateChoiserModifyIni() {
        return dateChoiserModifyIni;
    }

    public void setDateChoiserModifyIni(Date dateChoiserModifyIni) {
        this.dateChoiserModifyIni = dateChoiserModifyIni;
    }

    public Date getDateChoiserModifyEnd() {
        return dateChoiserModifyEnd;
    }

    public void setDateChoiserModifyEnd(Date dateChoiserModifyEnd) {
        this.dateChoiserModifyEnd = dateChoiserModifyEnd;
    }

    public Date getDateChoiserAccessedIni() {
        return dateChoiserAccessedIni;
    }

    public void setDateChoiserAccessedIni(Date dateChoiserAccessedIni) {
        this.dateChoiserAccessedIni = dateChoiserAccessedIni;
    }

    public Date getDateChoiserAccessedEnd() {
        return dateChoiserAccessedEnd;
    }

    public void setDateChoiserAccessedEnd(Date dateChoiserAccessedEnd) {
        this.dateChoiserAccessedEnd = dateChoiserAccessedEnd;
    }

    public boolean isDateCreatedSelected() {
        return dateCreatedSelected;
    }

    public void setDateCreatedSelected(boolean dateCreatedSelected) {
        this.dateCreatedSelected = dateCreatedSelected;
    }

    public boolean isDateModifySelected() {
        return dateModifySelected;
    }

    public void setDateModifySelected(boolean dateModifySelected) {
        this.dateModifySelected = dateModifySelected;
    }

    public boolean isDateAccessedSelected() {
        return dateAccessedSelected;
    }

    public void setDateAccessedSelected(boolean dateAccessedSelected) {
        this.dateAccessedSelected = dateAccessedSelected;
    }

    public String getNameCriterialDatabase() {
        return nameCriterialDatabase;
    }

    public void setNameCriterialDatabase(String nameCriterialDatabase) {
        this.nameCriterialDatabase = nameCriterialDatabase;
    }

    public String getExtencionMultimedia() {
        return extencionMultimedia;
    }

    public void setExtencionMultimedia(String extencionMultimedia) {
        this.extencionMultimedia = extencionMultimedia;
    }

    public String getCountMultimedia() {
        return countMultimedia;
    }

    public void setCountMultimedia(String countMultimedia) {
        this.countMultimedia = countMultimedia;
    }

    public String getInputSizeMultimedia() {
        return inputSizeMultimedia;
    }

    public void setInputSizeMultimedia(String inputSizeMultimedia) {
        this.inputSizeMultimedia = inputSizeMultimedia;
    }

    public String getDurationTypeMultimedia() {
        return durationTypeMultimedia;
    }

    public void setDurationTypeMultimedia(String durationTypeMultimedia) {
        this.durationTypeMultimedia = durationTypeMultimedia;
    }

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }

    public String getAudioCode() {
        return audioCode;
    }

    public void setAudioCode(String audioCode) {
        this.audioCode = audioCode;
    }

    public String getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public boolean isSelectedMultimediaSearch() {
        return isSelectedMultimediaSearch;
    }

    public void setSelectedMultimediaSearch(boolean selectedMultimediaSearch) {
        isSelectedMultimediaSearch = selectedMultimediaSearch;
    }

    public boolean isCheckOtherExtentionMult() {
        return checkOtherExtentionMult;
    }

    public void setCheckOtherExtentionMult(boolean checkOtherExtentionMult) {
        this.checkOtherExtentionMult = checkOtherExtentionMult;
    }
}
