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
package com.fundation.search.model;

/**
 * Class that creates the basic search panel.
 *
 * @author Estalin Yerel Hurtado Arias - AT - [07]
 * @author William Claros Revollo - AT - [07]
 * @version 1.0.
 */
public class CriterialSearch {
    /**
     * this is a patch to search e.g. c:\foldertosearch.
     */
    private String path;
    /**
     * this is a name of file to search.
     */
    private String filename;
    /**
     * this is a size to file in bytes.
     */
    private long size;
    /**
     * this is a unit size to file in bytes, Kbyte, GByte.
     */
    private String unitSize;
    /**
     * this is a range size to file in bytes, Kbyte, GByte.
     */
    private String rangeSize;
    /**
     * this is a extension of file to search.
     */
    private String fileExtension;
    /**
     * other extension distint to common list.
     */
    private String otherExtension;
    /**
     * this is a owner of file to search.
     */
    private String owner;
    /**
     * search if true file with hidden o folder hidden.
     */
    private boolean hidden;
    /**
     * search if only read.
     */
    private boolean readOnly;
    /**
     * parameter to true o false to exact search.
     */
    private boolean keySensitive;
    /**
     * search all folder, files.
     */
    private boolean selectAll;
    /**
     * search only files.
     */
    private boolean selectFiles;
    /**
     * for files or folder title only initialize with word.
     */
    private boolean starWord;
    /**
     * for files or folder title contain with this word.
     */
    private boolean contentWord;
    /**
     * for files or folder title end with this word.
     */
    private boolean endWord;
    /**
     * Attribute to determine if it is folder.
     */
    private boolean selectFolder;

    /**
     * Attribute to determine a word contains within in folder.
     */
    private String containWordInFile;
    /**
     * Duration of the multimedia file.
     */
    private int durationTime;
    /**
     * Unit of the multimedia file. Example: sec, min, hour.
     */
    private String unitDuration;
    /**
     * Video codec unit.
     */
    private String videoCodec;
    /**
     * Video frame rate.
     */
    private String frameRate;
    /**
     * Video resolution
     */
    private String resolutionVideo;
    /**
     * Audio codec of the music file.
     */
    private String audioCodec;


    private long dateCreatedIni;
    private long dateCreatedEnd;

    private long dateModifyIni;
    private long dateModifyEnd;

    private long dateAccessIni;
    private long dateAccessEnd;


    /**
     * Method that receives all the input parameters of the View.
     *
     * @param path         is a patch of file search.
     * @param filename          name file search.
     * @param fileExtension              extent of file.
     * @param owner             of file.
     * @param rangeSize this is a delimiter search for size minor to <, major to >, equal to =.
     * @param unitSize          type size of file MB, GB, KB.
     * @param size              size of file.
     * @param hidden            true or false is hidden.
     * @param readOnly          is only file read.
     * @param keySensitive       is equal to word tyoe search.
     * @param selectAll         search for all files and folder.
     * @param selectOnlyfolder  search for only folder.
     * @param selectOnlyfiles   search for only files.
     * @param starWord          title contain with this word.
     * @param contentWord       contain with this word.
     * @param endWord           end with this word.
     * @param otherExtension    distint extension the common list.
     */
    public CriterialSearch(String path, String filename, boolean hidden, String fileExtension, String owner,
                           long size, String rangeSize, String unitSize, boolean readOnly, boolean keySensitive,
                           boolean selectAll, boolean selectOnlyfolder, boolean selectOnlyfiles, boolean starWord,
                           boolean contentWord, boolean endWord, String otherExtension, String containWordInFile) {
        this.path = path;
        this.filename = filename;
        this.hidden = hidden;
        this.fileExtension = fileExtension;
        this.owner = owner;
        this.size = size;
        this.rangeSize = rangeSize;
        this.unitSize = unitSize;
        this.readOnly = readOnly;
        this.keySensitive = keySensitive;
        this.selectAll = selectAll;
        this.selectFolder = selectOnlyfolder;
        this.selectFiles = selectOnlyfiles;
        this.starWord = starWord;
        this.contentWord = contentWord;
        this.endWord = endWord;
        this.otherExtension = otherExtension;
        this.containWordInFile = containWordInFile;
    }

    /**
     * this is method getPath.
     *
     * @return path file.
     */
    public String getPath() {
        return path;
    }

    /**
     * this is method setPath.
     *
     * @param path string whit valid path.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * this is method getFilename.
     *
     * @return file name.
     */
    public String getFilename() {
        return filename;
    }

    /**
     * this is method setFilename.
     *
     * @param filename string whit filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * this is method getSize.
     *
     * @return size.
     */
    public long getSize() {
        return size;
    }

    /**
     * this is method setSize.
     *
     * @param size of type long.
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * this is method getExtention.
     *
     * @return extension.
     */
    public String getFileExtension() {
        return fileExtension;
    }

    /**
     * this is method setExtention.
     *
     * @param fileExtension string of extension.
     */
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    /**
     * This is the getOwner () method that returns the owner of the file.
     *
     * @return returns a string with the name of the owner.
     */
    public String getOwner() {
        return owner;
    }

    /*
     * This is the setOwner () method that modifies the owner of the file.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * This is the method returns a Boolean value indicating if the file is hidden.
     *
     * @return returns a boolean with the name of the owner.
     */
    public boolean getHidden() {
        return hidden;
    }

    /*
     * This is the setHidden () method that modifies the properties of the file.
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * @return is file only read.
     */
    public boolean getReadOnly() {
        return readOnly;
    }

    /**
     * @param readOnly set a new value readOnly.
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * @return is a same search.
     */
    public boolean getKeySensitive() {
        return keySensitive;
    }

    /**
     * @return select all.
     */
    public boolean getSelectAll() {
        return selectAll;
    }

    /**
     * @param selectAll select all.
     */
    public void setSelectAll(boolean selectAll) {
        this.selectAll = selectAll;
    }

    /**
     * Method that selects only files.
     *
     * @return returns a Boolean to see if it is a file.
     */
    public boolean getSelectfiles() {
        return selectFiles;
    }

    /**
     * Method that selects only files.
     *
     * @param selectfiles set a Boolean to see if it is a file.
     */
    public void setSelectfiles(boolean selectfiles) {
        this.selectFiles = selectfiles;
    }


    /**
     * @return word search in title start.
     */
    public boolean getStarWord() {
        return starWord;
    }

    /**
     * @param starWord word search in title start.
     */
    public void setStarWord(boolean starWord) {
        this.starWord = starWord;
    }


    /**
     * @return contain a word in title true.
     */
    public boolean getContentWord() {
        return contentWord;
    }

    /**
     * @param contentWord contain a word in title.
     */
    public void setContentWord(boolean contentWord) {
        this.contentWord = contentWord;
    }

    /**
     * @return end to word of title file o folder.
     */
    public boolean getEndWord() {
        return endWord;
    }

    /**
     * @param endWord end to word of title file o folder.
     */
    public void setEndWord(boolean endWord) {
        this.endWord = endWord;
    }

    /**
     * @return write other extension.
     */
    public String getOtherExtension() {
        return otherExtension;
    }

    /**
     * @param otherExtension a new extension.
     */
    public void setOtherExtension(String otherExtension) {
        this.otherExtension = otherExtension;
    }
    /**
     * Method that determines whether or not it is a folder.
     *
     * @return returns a boolean that determines whether or not it is a folder.
     */
    public boolean getSelectFolder() {
        return selectFolder;
    }

    /**
     * @return a contain word in file to search.
     */
    public String getContainWordInFile() {
        return containWordInFile;
    }

    /**
     * @param containWordInFile a contain file to search.
     */
    public void setContainWordInFile(String containWordInFile) {
        this.containWordInFile = containWordInFile;
    }

    /**
     * Method that returns the duration of the multimedia file.
     *
     * @return durationTime.
     */
    public int getDurationTime() {
        return durationTime;
    }

    /**
     * Method that sets the duration time of a music.
     *
     * @param durationTime .
     */
    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }

    /**
     * Method that returns the duration of the multimedia file.
     *
     * @return durationTime.
     */
    public String getUnitDuration() {
        return unitDuration;
    }

    /**
     * Method that sets the time unit of the multimedia file.
     *
     * @param unitDuration .
     */
    public void setUnitDuration(String unitDuration) {
        this.unitDuration = unitDuration;
    }

    /**
     * Method that returns the unit of duration of the multimedia file.
     *
     * @return videoCodec.
     */
    public String getVideoCodec() {
        return videoCodec;
    }

    /**
     * Method that sets the video codec of the video.
     *
     * @param videoCodec .
     */
    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    /**
     * Method that returns the frame rate of the video..
     *
     * @return frameRate.
     */
    public String getFrameRate() {
        return frameRate;
    }

    /**
     * Method that sets the frame rate of the video.
     *
     * @param frameRate .
     */
    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    /**
     * Method that returns the resolution of the video.
     *
     * @return resolutionVideo.
     */
    public String getResolutionVideo() {
        return resolutionVideo;
    }

    /**
     * Method that sets the resolution of the video.
     *
     * @param resolutionVideo .
     */
    public void setResolutionVideo(String resolutionVideo) {
        this.resolutionVideo = resolutionVideo;
    }

    /**
     * Method that returns the audio codec of the music file.
     *
     * @return audioCodec.
     */
    public String getAudioCodec() {
        return audioCodec;
    }

    /**
     * Method that sets the audio codec of the music file.
     *
     * @param audioCodec .
     */
    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }
    /**
     * Initial creation date.
     * @return dateCreatedIni .
     */
    public long getDateCreatedIni() {
        return dateCreatedIni;
    }
    /**
     * Initial creation final date.
     * @return dateCreatedEnd .
     */
    public long getDateCreatedEnd() {
        return dateCreatedEnd;
    }
    /**
     * Date of initial modification.
     * @return dateModifyIni .
     */
    public long getDateModifyIni() {
        return dateModifyIni;
    }
    /**
     * Date of final modification.
     * @return dateModifyEnd .
     */
    public long getDateModifyEnd() {
        return dateModifyEnd;
    }
    /**
     * Date of last initial access.
     * @return dateAccessIni;
     */
    public long getDateAccessIni() {
        return dateAccessIni;
    }
    /**
     * Date of last final access.
     * @return dateAccessEnd .
     */
    public long getDateAccessEnd() {
        return dateAccessEnd;
    }
}
