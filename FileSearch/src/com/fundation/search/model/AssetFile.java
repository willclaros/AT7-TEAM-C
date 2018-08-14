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

import java.util.Date;

/**
 * This class AssetFile can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Erik Vargas - AT-[07].
 * @author William Claros Revollo - AT-[07].
 * @@author Estalin Yerel Hurtado Arias - AT-[07].
 * @version 1.0.
 */
public class AssetFile extends Asset {


    /**
     * Attribute to determine if it is content word in file.
     */
    private boolean contentWord;

    /**
     * Builder of the Asset File class.
     *
     * @param path              is a patch of file search.
     * @param filename          name file search.
     * @param extension         extent of file.
     * @param owner             of file.
     * @param size              size of file.
     * @param hidden            true or false is hidden.
     * @param readOnly          is only file read.
     * @param contentWord       contain with this word.
     */
    public AssetFile(String path, String filename, long size, String extension, String owner, boolean hidden, boolean readOnly,
                     String dateCreate, String dateModify, String dateAccessed, boolean contentWord){
        super(path, filename, size, extension, owner, hidden, readOnly, dateCreate, dateModify, dateAccessed);
        this.contentWord = contentWord;
    }

    public void setContentWord(boolean contentWord) {
        this.contentWord = contentWord;
    }
}
