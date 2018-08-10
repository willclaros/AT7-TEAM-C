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
     * Builder of the Asset File class.
     *
     * @param directory         is a patch of file search.
     * @param nameFile          name file search.
     * @param type              extent of file.
     * @param owner             of file.
     * @param delimitSizeSearch this is a delimiter search for size minor to <, major to >, equal to =.
     * @param unitSize          type size of file MB, GB, KB.
     * @param size              size of file.
     * @param hidden            true or false is hidden.
     * @param readOnly          is only file read.
     * @param keySesitive       is equal to word tyoe search.
     * @param selectAll         search for all files and folder.
     * @param selectOnlyfolder  search for only folder.
     * @param selectOnlyfiles   search for only files.
     * @param starWord          title contain with this word.
     * @param contentWord       contain with this word.
     * @param endWord           end with this word.
     * @param otherExtencion    distint extension the common list.
     * @param selectFolder      boolean parameter that determines whether or not it is a folder.
     */
    public AssetFile(String path, String filename, long size, String extension, String owner, boolean hidden, String countSearch, boolean readOnly,
                     boolean keySensitive, boolean selectAll, boolean selectfiles, boolean starWord, boolean contentWord,
                     boolean endWord, String otherExtension, boolean selectFolder) {
        super(path, filename, size, extension, owner, hidden, countSearch, readOnly, keySensitive, selectAll, selectfiles, starWord, contentWord,
                endWord, otherExtension);
        this.selectFolder = selectFolder;
    }

    /**
     * Method that determines whether or not it is a folder.
     * @return returns a boolean that determines whether or not it is a folder.
     */
    public boolean isSelectFolder() {
        return selectFolder;
    }
}
