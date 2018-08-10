package com.fundation.search.model;

public class CriterialSearchMultimedia {
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
     * parameter to true o false to exact search.
     */
    private boolean keySensitive;
    /**
     * for files or folder title only initialize with word.
     */
    private boolean starWord;
    private boolean contentWord;
    /**
     * for files or folder title end with this word.
     */
    private boolean endWord;
    /**
     * other extension distint to common list.
     */
    private String extencionMultimedia;
    private String countMultimedia;
    private String inputSizeMultimedia;
    private String durationTypeMultimedia;
    private String videoCode;
    private String audioCode;
    private String frameRate;
    private String resolution;

    public CriterialSearchMultimedia(String directory, String nameFile, boolean hidden, String type, String owner,
                                     boolean keySensitive, boolean starWord, boolean contentWord, boolean endWord,
                                     String extencionMultimedia, String countMultimedia, String inputSizeMultimedia,
                                     String durationTypeMultimedia, String videoCode, String audioCode, String frameRate,
                                     String resolution) {
        this.directory = directory;
        this.nameFile = nameFile;
        this.hidden = hidden;
        this.type = type;
        this.owner = owner;
        this.keySensitive = keySensitive;
        this.starWord = starWord;
        this.contentWord = contentWord;
        this.endWord = endWord;
        this.extencionMultimedia = extencionMultimedia;
        this.countMultimedia = countMultimedia;
        this.inputSizeMultimedia = inputSizeMultimedia;
        this.durationTypeMultimedia = durationTypeMultimedia;
        this.videoCode = videoCode;
        this.audioCode = audioCode;
        this.frameRate = frameRate;
        this.resolution = resolution;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isKeySensitive() {
        return keySensitive;
    }

    public void setKeySensitive(boolean keySensitive) {
        this.keySensitive = keySensitive;
    }

    public boolean isStarWord() {
        return starWord;
    }

    public void setStarWord(boolean starWord) {
        this.starWord = starWord;
    }

    public boolean isContentWord() {
        return contentWord;
    }

    public void setContentWord(boolean contentWord) {
        this.contentWord = contentWord;
    }

    public boolean isEndWord() {
        return endWord;
    }

    public void setEndWord(boolean endWord) {
        this.endWord = endWord;
    }

    public String getExtencionMultimedia() {
        return extencionMultimedia;
    }

    public void setExtencionMultimedia(String extencionMultimedia) {
        this.extencionMultimedia = extencionMultimedia;
    }

    public String getCountMultimedia() {
        return countMultimedia;
    }

    public void setCountMultimedia(String countMultimedia) {
        this.countMultimedia = countMultimedia;
    }

    public String getInputSizeMultimedia() {
        return inputSizeMultimedia;
    }

    public void setInputSizeMultimedia(String inputSizeMultimedia) {
        this.inputSizeMultimedia = inputSizeMultimedia;
    }

    public String getDurationTypeMultimedia() {
        return durationTypeMultimedia;
    }

    public void setDurationTypeMultimedia(String durationTypeMultimedia) {
        this.durationTypeMultimedia = durationTypeMultimedia;
    }

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }

    public String getAudioCode() {
        return audioCode;
    }

    public void setAudioCode(String audioCode) {
        this.audioCode = audioCode;
    }

    public String getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}
