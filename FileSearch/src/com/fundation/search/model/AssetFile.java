/**
 * @(#)AssetFile.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.fundation.search.model;
/**
 * This class AssetFile can be FileResult, MultimediaResult and maybe SearchFolder.
 * @author Erik Vargas - AT-[07].
 * @version 1.0.
 */
public class AssetFile {

    public AssetFile(String path, String filename, long size, String type, String extension) {
        this.path = path;
        this.filename = filename;
        this.size = size;
        this.extension = extension;
    }

    /**
     * this is variable contains the path.
     */
    private String path;

    /**
     *
     * this is variable contains file name.
     */
    private String filename;

    /**
     * this is variable contains size file.
     */
    private long size;

    /**
     * this is variable contains extension file.
     */
    private String extension;

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
}
