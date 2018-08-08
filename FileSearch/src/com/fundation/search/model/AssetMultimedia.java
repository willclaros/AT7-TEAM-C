/**
 * @(#)AssetMultimedia.java Copyright (c) 2018 Jala Foundation.
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
 * Class that creates the basic search panel.
 *
 * @author William Claros Revollo - AT - [07]
 * @version 1.0.
 */
public class AssetMultimedia extends Asset {

    /**
     * Duration of the multimedia file.
     */
    private int durationTime;
    /**
     * Unit of the multimedia file. Example: sec, min, hour.
     */
    private String unitDuration;
    /**
     * Video codec unit.
     */
    private String videoCodec;
    /**
     * Video frame rate.
     */
    private String frameRate;
    /**
     * Video resolution
     */
    private String resolutionVideo;
    /**
     * Audio codec of the music file.
     */
    private String audioCodec;

    /**
     * Constructor of the class Asset Multimedia.
     *
     * @param path           is a patch of file search.
     * @param filename       name file search.
     * @param fileExtension  extent of file.
     * @param owner          of file.
     * @param rangeSize      this is a delimiter search for size minor to <, major to >, equal to =.
     * @param unitSize       type size of file MB, GB, KB.
     * @param size           size of file.
     * @param hidden         true or false is hidden.
     * @param readOnly       is only file read.
     * @param keySensitive   is equal to word tyoe search.
     * @param selectAll      search for all files and folder.
     * @param selectAll      search for only folder.
     * @param selectFiles    search for only files.
     * @param starWord       title contain with this word.
     * @param contentWord    contain with this word.
     * @param endWord        end with this word.
     * @param otherExtension distint extension the common list.
     * @param dateCreated    distint extension the common list.
     * @param dateModify     distint extension the common list.
     * @param dateAccess     distint extension the common list.
     */
    public AssetMultimedia(String path, String filename, String fileExtension, String otherExtension, long size, String unitSize, String rangeSize, String owner,
                           boolean selectAll, boolean selectFiles, boolean hidden, boolean readOnly, boolean keySensitive, boolean starWord,
                           boolean contentWord, boolean endWord, long dateCreated, long dateModify, long dateAccess, int durationTime, String unitDuration, String videoCodec, String frameRate,
                           String resolutionVideo, String audioCodec) {
        super(path, filename, fileExtension, otherExtension, size, unitSize, rangeSize, owner, selectAll, selectFiles, hidden,
                readOnly, keySensitive, starWord, contentWord, endWord, dateCreated, dateModify, dateAccess);

        this.durationTime = durationTime;
        this.unitDuration = unitDuration;
        this.videoCodec = videoCodec;
        this.frameRate = frameRate;
        this.resolutionVideo = resolutionVideo;
        this.audioCodec = audioCodec;
    }

    /**
     * Constructor free of the class Asset Multimedia.
     */
    public AssetMultimedia() {

    }

    /**
     * Method that returns the duration of the multimedia file.
     *
     * @return durationTime.
     */
    public int getDurationTime() {
        return durationTime;
    }

    /**
     * Method that sets the duration time of a music.
     *
     * @param durationTime .
     */
    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }

    /**
     * Method that returns the duration of the multimedia file.
     *
     * @return durationTime.
     */
    public String getUnitDuration() {
        return unitDuration;
    }

    /**
     * Method that sets the time unit of the multimedia file.
     *
     * @param unitDuration .
     */
    public void setUnitDuration(String unitDuration) {
        this.unitDuration = unitDuration;
    }

    /**
     * Method that returns the unit of duration of the multimedia file.
     *
     * @return videoCodec.
     */
    public String getVideoCodec() {
        return videoCodec;
    }

    /**
     * Method that sets the video codec of the video.
     *
     * @param videoCodec .
     */
    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    /**
     * Method that returns the frame rate of the video..
     *
     * @return frameRate.
     */
    public String getFrameRate() {
        return frameRate;
    }

    /**
     * Method that sets the frame rate of the video.
     *
     * @param frameRate .
     */
    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    /**
     * Method that returns the resolution of the video.
     *
     * @return resolutionVideo.
     */
    public String getResolutionVideo() {
        return resolutionVideo;
    }

    /**
     * Method that sets the resolution of the video.
     *
     * @param resolutionVideo .
     */
    public void setResolutionVideo(String resolutionVideo) {
        this.resolutionVideo = resolutionVideo;
    }

    /**
     * Method that returns the audio codec of the music file.
     *
     * @return audioCodec.
     */
    public String getAudioCodec() {
        return audioCodec;
    }

    /**
     * Method that sets the audio codec of the music file.
     *
     * @param audioCodec .
     */
    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }

}
