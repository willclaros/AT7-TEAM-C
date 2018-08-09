package com.fundation.search.model;

/**
 * Class that creates the basic search panel.
 *
 * @author William Claros Revollo - AT - [07]
 * @version 1.0.
 */
public class AssetMultimedia extends Asset {
    private double duration;
    private double frameRate;
    private int heigth;
    private int width;
    private String aspectRatio;
    private String codec;
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
                           boolean endWord, String otherExtension, double duration, double frameRate, int heigth, int width,
                           String aspectRatio, String codec) {
        super(path, filename, size, extension, owner, hidden, countSearch, readOnly, keySensitive, selectAll, selectfiles, starWord, contentWord,
                endWord, otherExtension);
        this.duration = duration;
        this.frameRate = frameRate;
        this.heigth = heigth;
        this.width = width;
        this.aspectRatio = aspectRatio;
        this.codec = codec;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(double frameRate) {
        this.frameRate = frameRate;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }
}
