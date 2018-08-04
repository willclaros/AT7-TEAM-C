package com.fundation.search.model;

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
     * this is a extension of file to search.
     */
    private String extension;
    /**
     * this is a owner of file to search.
     */
    private String owner;
    /**
     * search if true file with hidden o folder hidden.
     */
    private boolean hidden;

    private String countSearch;
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
    private boolean selectfiles;
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
    private String otherExtension;


    /**
     * Constructor of the class Asset.
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
    public Asset(String path, String filename, long size, String extension, String owner,
                 boolean hidden, String countSearch, boolean readOnly, boolean keySensitive, boolean selectAll,
                 boolean selectfiles, boolean starWord, boolean contentWord, boolean endWord, String otherExtension) {
        this.filename = filename;
        this.size = size;
        this.extension = extension;
        this.owner = owner;
        this.hidden = hidden;
        this.countSearch = countSearch;
        this.readOnly = readOnly;
        this.keySensitive = keySensitive;
        this.selectAll = selectAll;
        this.selectfiles = selectfiles;
        this.starWord = starWord;
        this.contentWord = contentWord;
        this.endWord = endWord;
        this.otherExtension = otherExtension;
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
    public String getExtension() {
        return extension;
    }

    /**
     * this is method setExtention.
     *
     * @param extension string of extension.
     */
    public void setExtension(String extension) {
        this.extension = extension;
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
    public boolean isHidden() {
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
    public boolean isKeySensitive() {
        return keySensitive;
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
     * Method that selects only files.
     * @return returns a Boolean to see if it is a file.
     */
    public boolean isSelectfiles() {
        return selectfiles;
    }

    /**
     * Method that selects only files.
     * @param selectfiles set a Boolean to see if it is a file.
     */
    public void setSelectfiles(boolean selectfiles) {
        this.selectfiles = selectfiles;
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
     * @param otherExtencion a new extension.
     */
    public void setOtherExtension(String otherExtension) {
        this.otherExtension = otherExtension;
    }

    /**
     * Method that contains the word in the document.
     * @return Word that contains the document.
     */
    public String getCountSearch() {
        return countSearch;
    }

    /**
     * Method that contains the word in the document.
     * @param countSearch hat contains the document
     */
    public void setCountSearch(String countSearch) {
        this.countSearch = countSearch;
    }

}
