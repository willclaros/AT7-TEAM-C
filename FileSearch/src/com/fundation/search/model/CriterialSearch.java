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

import java.util.Date;

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
     * search if true file with hidden o folder hidden.
     */

    private boolean hidden;
    /**
     * type of file e.g. mp3, xml, pdf.
     */
    private String type;
    /**
     * this is a owner of file to search.
     */
    private String owner;

    /**
     * this is a size to file in bytes.
     */
    private long size;
    /**
     * this is a delimiter search for size minor to <, major to >, equal to =.
     */
    private String delimitSizeSearch;
    /**
     * this is a type size of file MB, GB, KB, Bytes.
     */
    private String unitSize;
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
     * search only folder.
     */
    private boolean selectOnlyfolder;
    /**
     * search for only files.
     */
    private boolean selectOnlyfiles;
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
     * other extension distint to common list.
     */
    private String otherExtencion;

    private String containWordInFile;
    private Date dateChoserCreateIni;
    private Date dateChooserCreateEnd;
    private Date dateChoiserModifyIni;
    private Date dateChoiserModifyEnd;
    private Date dateChoiserAccessedIni;
    private Date dateChoiserAccessedEnd;
    /**
     * Method that receives all the input parameters of the View.
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
     */
    public CriterialSearch(String directory, String nameFile, boolean hidden, String type, String owner,
                           long size, String delimitSizeSearch, String unitSize, boolean readOnly, boolean keySesitive,
                           boolean selectAll, boolean selectOnlyfolder, boolean selectOnlyfiles, boolean starWord,
                           boolean contentWord, boolean endWord, String otherExtencion, String containWordInFile) {
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

    }

    public CriterialSearch(String directory, String nameFile, boolean hidden, String type, String owner, long size,
                           String delimitSizeSearch, String unitSize, boolean readOnly, boolean keySensitive,
                           boolean selectAll, boolean selectOnlyfolder, boolean selectOnlyfiles, boolean starWord,
                           boolean contentWord, boolean endWord, String otherExtencion, String containWordInFile,
                           Date dateChoserCreateIni, Date dateChooserCreateEnd, Date dateChoiserModifyIni,
                           Date dateChoiserModifyEnd, Date dateChoiserAccessedIni, Date dateChoiserAccessedEnd) {
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
        return keySensitive;
    }

    /**
     * @param keySesitive set a new keysensitive.
     */
    public void setKeySensitive(boolean keySensitive) {
        this.keySensitive = keySensitive;
    }

    /**
     * @return a delimit size search.
     */
    public String getDelimitSizeSearch() {
        return delimitSizeSearch;
    }

    /**
     * @param delimitSizeSearch a delimit size search.
     */
    public void setDelimitSizeSearch(String delimitSizeSearch) {
        this.delimitSizeSearch = delimitSizeSearch;
    }

    /**
     * @return unit size to search.
     */
    public String getUnitSize() {
        return unitSize;
    }

    /**
     * @param unitSize unit size to search.
     */
    public void setUnitSize(String unitSize) {
        this.unitSize = unitSize;
    }

    /**
     * @return select all.
     */
    public boolean isSelectAll() {
        return selectAll;
    }

    /**
     * @param selectAll select all.
     */
    public void setSelectAll(boolean selectAll) {
        this.selectAll = selectAll;
    }

    /**
     * @return only folder search true or not is false.
     */
    public boolean isSelectOnlyfolder() {
        return selectOnlyfolder;
    }

    /**
     * @param selectOnlyfolder folder search true or not is false.
     */
    public void setSelectOnlyfolder(boolean selectOnlyfolder) {
        this.selectOnlyfolder = selectOnlyfolder;
    }

    /**
     * @return only files search true or not is false.
     */
    public boolean isSelectOnlyfiles() {
        return selectOnlyfiles;
    }

    /**
     * @param selectOnlyfiles files search true or not is false.
     */
    public void setSelectOnlyfiles(boolean selectOnlyfiles) {
        this.selectOnlyfiles = selectOnlyfiles;
    }

    /**
     * @return word search in title start.
     */
    public boolean isStarWord() {
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
    public boolean isContentWord() {
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
    public boolean isEndWord() {
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
    public String getOtherExtencion() {
        return otherExtencion;
    }

    /**
     * @param otherExtencion a new extension.
     */
    public void setOtherExtencion(String otherExtencion) {
        this.otherExtencion = otherExtencion;
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

    public boolean isKeySensitive() {
        return keySensitive;
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
}
