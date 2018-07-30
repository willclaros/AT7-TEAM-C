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

import java.util.Objects;

/**
 * This class AssetFile can be FileResult, MultimediaResult and maybe SearchFolder.
 * @author Erik Vargas - AT-[07].
 * @version 1.0.
 */
public class AssetFile {

    private String path;
    private String filename;
    private long size;
    private String extension;
    private String owner;

    private boolean hidden;
    private String countSearch;
    private boolean readOnly;
    private boolean keySensitive;
    private boolean selectAll;
    private boolean selectFolder;
    private boolean selectfiles;
    private boolean starWord;
    private boolean contentWord;
    private boolean endWord;
    private String otherExtension;

    public AssetFile(String path, String filename, long size, String extension, String owner,
                     boolean hidden, String countSearch, boolean readOnly, boolean keySensitive, boolean selectAll,
                     boolean selectFolder, boolean selectfiles, boolean starWord, boolean contentWord, boolean endWord, String otherExtension) {
        this.path = path;
        this.filename = filename;
        this.size = size;
        this.extension = extension;
        this.owner = owner;
        this.hidden = hidden;
        this.countSearch = countSearch;
        this.readOnly = readOnly;
        this.keySensitive = keySensitive;
        this.selectAll = selectAll;
        this.selectFolder = selectFolder;
        this.selectfiles = selectfiles;
        this.starWord =  starWord;
        this.contentWord = contentWord;
        this.endWord = endWord;
        this.otherExtension = otherExtension;
                
    }

    /**
     * this is method getPath.
     * @return path file.
     */
    public String getPath() {
        return path;
    }

    /**
     * this is method setPath.
     * @param path string whit valid path.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * this is method getFilename.
     * @return file name.
     */
    public String getFilename() {
        return filename;
    }

    /**
     * this is method setFilename.
     * @param filename string whit filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * this is method getSize.
     * @return size.
     */
    public long getSize() {
        return size;
    }

    /**
     * this is method setSize.
     * @param size of type long.
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * this is method getExtention.
     * @return extension.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * this is method setExtention.
     * @param extension string of extension.
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void setCountSearch(String countSearch) {
        this.countSearch = countSearch;
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

    public boolean isSelectFolder() {
        return selectFolder;
    }

    public void setSelectFolder(boolean selectFolder) {
        this.selectFolder = selectFolder;
    }

    public boolean isSelectfiles() {
        return selectfiles;
    }

    public void setSelectfiles(boolean selectfiles) {
        this.selectfiles = selectfiles;
    }

    public boolean isStarWord() {
        return starWord;
    }

    public void setStarWord(boolean starWord) {
        this.starWord = starWord;
    }

    public boolean getContentWord() {
        return contentWord;
    }

    public void setContentWord(boolean contentWord) {
        this.contentWord = contentWord;
    }

    public boolean getEndWord() {
        return endWord;
    }

    public void setEndWord(boolean endWord) {
        this.endWord = endWord;
    }

    public String getOtherExtension() {
        return otherExtension;
    }

    public void setOtherExtension(String otherExtension) {
        this.otherExtension = otherExtension;
    }

    public String getCountSearch() {
        return countSearch;
    }
}
