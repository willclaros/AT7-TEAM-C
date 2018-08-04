package com.fundation.search.model;

/**
 * Class that creates the basic search panel.
 *
 * @author William Claros Revollo - AT - [07]
 * @version 1.0.
 */
public class AssetMultimedia extends Asset {

    /**
     * Builder of the Asset Multimedia class.
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
    public AssetMultimedia(String path, String filename, long size, String extension, String owner, boolean hidden, String countSearch, boolean readOnly,
                           boolean keySensitive, boolean selectAll, boolean selectfiles, boolean starWord, boolean contentWord,
                           boolean endWord, String otherExtension) {
        super(path, filename, size, extension, owner, hidden, countSearch, readOnly, keySensitive, selectAll, selectfiles, starWord, contentWord,
                endWord, otherExtension);
    }
}
