/**
 * @(#)Asset.java Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.fundation.search.model;

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime;

/**
 * This class Asset can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Erik Vargas - AT-[07].
 * @author William Claros Revollo - AT-[07].
 * @version 1.0.
 */
public class Asset {

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
     * Date of creation of the file.
     */
    private long dateCreated;
    /**
     * Date of modification of the file.
     */
    private long dateModify;
    /**
     * Access date of the file.
     */
    private long dateAccess;

    /**
     * Constructor of the class Asset.
     *
     * @param path           is a patch of file search.
     * @param filename       name file search.
     * @param fileExtension  extent of file.
     * @param owner          of file.
     * @param rangeSize      this is a delimiter search for size minor to <, major to >, equal to =.
     * @param unitSize       type size of file MB, GB, KB.
     * @param size           size of file.
     * @param hidden         true or false is hidden.
     * @param readOnly       is only file read.
     * @param keySensitive   is equal to word tyoe search.
     * @param selectAll      search for all files and folder.
     * @param selectAll      search for only folder.
     * @param selectFiles    search for only files.
     * @param starWord       title contain with this word.
     * @param contentWord    contain with this word.
     * @param endWord        end with this word.
     * @param otherExtension distint extension the common list.
     */
    public Asset(String path, String filename, String fileExtension, String otherExtension, long size, String unitSize, String rangeSize, String owner,
                 boolean selectAll, boolean selectFiles, boolean hidden, boolean readOnly, boolean keySensitive, boolean starWord,
                 boolean contentWord, boolean endWord, long dateCreated, long dateModify, long dateAccess) {
        this.path = path;
        this.filename = filename;
        this.size = size;
        this.fileExtension = fileExtension;
        this.owner = owner;
        this.hidden = hidden;
        this.readOnly = readOnly;
        this.keySensitive = keySensitive;
        this.selectAll = selectAll;
        this.selectFiles = selectFiles;
        this.starWord = starWord;
        this.contentWord = contentWord;
        this.endWord = endWord;
        this.otherExtension = otherExtension;
        this.dateCreated = dateCreated;
        this.dateModify = dateModify;
        this.dateAccess = dateAccess;
    }

    /**
     * Constructor free of the class Asset.
     */
    public Asset() {

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
     * @param endWord end word of title file o folder.
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

    public String getUnitSize() {
        return unitSize;
    }

    public String getRangeSize() {
        return rangeSize;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public long getDateModify() {
        return dateModify;
    }

    public void setDateModify(long dateModify) {
        this.dateModify = dateModify;
    }

    public long getDateAccess() {
        return dateAccess;
    }

    public void setDateAccess(long dateAccess) {
        this.dateAccess = dateAccess;
    }
}
