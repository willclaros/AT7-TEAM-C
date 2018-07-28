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
 * @version 1.0.
 */
public class CriterialSearch {
    /**
     * this is a patch to search e.g. c:\foldertosearch.
     */
    private String directory;
    /**
     * this is a name of file to search.
     */
    private String nameFile;
    /**
     * content into to file.
     */
    private String content;
    /**
     * type of file e.g. mp3, xml, pdf.
     */
    private String type;
    /**
     * this is a owner of file to search.
     */
    private String owner;

    /**
     * this is a delimiter search for size minor to <, major to >, equal to =.
     */
    private String delimitSizeSearch;
    /**
     * this is a type size of file MB, GB, KB, Bytes.
     */
    private String unitSize;
    /**
     * this is a size to file in bytes.
     */
    private long size;
    /**
     * parameter to true o false to exact search.
     */
    private boolean keySesitive;
    /**
     * search if true file with hidden o folder hidden.
     */

    private boolean hidden;
    /**
     * search only folder.
     */
    private boolean folder;
    /**
     * search if only read.
     */
    private boolean readOnly;

    /**
     * @param directory is a patch of file search.
     * @param nameFile name file search.
     * @param content content into file.
     * @param type extent of file.
     * @param owner of file.
     * @param delimitSizeSearch this is a delimiter search for size minor to <, major to >, equal to =.
     * @param unitSize  type size of file MB, GB, KB.
     * @param size size of file.
     * @param hidden true or false is hidden.
     * @param folder is a folder true or false.
     * @param readOnly is only file read.
     * @param keySesitive is equal to word tyoe search.
     */
    public CriterialSearch(String directory, String nameFile, String content,
                           String type, String owner, String delimitSizeSearch, String unitSize, long size, boolean hidden,
                           boolean folder, boolean readOnly, boolean keySesitive) {
        this.directory = directory;
        this.nameFile = nameFile;
        this.content = content;
        this.type = type;
        this.owner = owner;
        this.delimitSizeSearch = delimitSizeSearch;
        this.unitSize = unitSize;
        this.size = size;
        this.hidden = hidden;
        this.folder = folder;
        this.readOnly = readOnly;
        this.keySesitive = keySesitive;
    }

    /**
     * @return a patch of directory
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * @param directory directory.
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    /**
     * @return a name of file.
     */
    public String getNameFile() {
        return nameFile;
    }

    /**
     * @param nameFile a new name of file.
     */
    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    /**
     * @return a content of file.
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content  new content.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return a type (extent) of file.
     */
    public String getType() {
        return type;
    }

    /**
     * @param type a new type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return a owner of file.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner new owner file.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return size of file.
     */
    public long getSize() {
        return size;
    }

    /**
     * @param size new file of file.
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * @return is hidden this file.
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * @param hidden set a new hidden.
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * @return is folder true o false.
     */
    public boolean isFolder() {
        return folder;
    }

    /**
     * @param folder set a new folder.
     */
    public void setFolder(boolean folder) {
        this.folder = folder;
    }

    /**
     * @return is file only read.
     */
    public boolean isReadOnly() {
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
    public boolean isKeySesitive() {
        return keySesitive;
    }

    /**
     * @param keySesitive set a new keysensitive.
     */
    public void setKeySesitive(boolean keySesitive) {
        this.keySesitive = keySesitive;
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
}
