/**
 * @(#)AssetFile.java Copyright (c) 2018 Jala Foundation.
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

/**
 * This class AssetFile can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Erik Vargas - AT-[07].
 * @author William Claros Revollo - AT-[07].
 * @version 1.0.
 */
public class AssetFile extends Asset {


    /**
     * Attribute to determine if it is folder.
     */
    private boolean selectFolder;

    /**
     * Attribute to determine a word contains within in folder.
     */
    private String containWord;

    /**
     * Constructor of the class Asset File.
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
     * @param dateCreated    distint extension the common list.
     * @param dateModify     distint extension the common list.
     * @param dateAccess     distint extension the common list.
     */
    public AssetFile(String path, String filename, String fileExtension, String otherExtension, long size, String unitSize, String rangeSize, String owner,
                     boolean selectAll, boolean selectFiles, boolean hidden, boolean readOnly, boolean keySensitive, boolean starWord,
                     boolean contentWord, boolean endWord, long dateCreated, long dateModify, long dateAccess, boolean selectFolder, String containWord) {
        super(path, filename, fileExtension, otherExtension, size, unitSize, rangeSize, owner, selectAll, selectFiles, hidden,
                readOnly, keySensitive, contentWord, endWord, starWord, dateCreated, dateModify, dateAccess);
        this.selectFolder = selectFolder;
        this.containWord = containWord;
    }

    /**
     * Constructor free of the class Asset File.
     */
    public AssetFile() {

    }

    /**
     * Method that determines whether not it is a folder.
     *
     * @return returns a boolean that determines whether or not it is a folder.
     */
    public boolean getSelectFolder() {
        return selectFolder;
    }

    /**
     * Method that determines whether or not it is a folder.
     *
     * @return returns a String that determines within word in a file.
     */
    public String getContainWord() {
        return containWord;
    }
}
