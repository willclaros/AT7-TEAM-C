/*
 * @(#)ModelSearch.java
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

import com.fundation.search.utils.LoggerWrapper;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class ModelSearch can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Yerel Hurtado - AT-[07].
 * @author William Claros Revollo - AT-[07]
 *
 * @version 1.0.
 */
public class ModelSearch {
    private static final Logger LOGGER = LoggerWrapper.getInstance().getLogger();
    /**
     * this Array storage files find with specific arguments.
     */
    private List<Asset> pathList = new ArrayList<>();
    private UserPrincipal ownerFile;

    /**
     * Method that performs the search of files.
     * @param criteria is an object of type Criteria that contains the information that was recovered from the View.
     * @return List String name file.
     * @throws IOException file.
     */
    public List<Asset> searchPathName(CriterialSearch criteria) throws IOException {
        LOGGER.info("init search");
        File files = new File(criteria.getDirectory());
        File[] ficheros = files.listFiles();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        for (File fileIterate : ficheros) {
            if(criteria.isSelectAll()) {
                if (fileIterate.isDirectory()) {
                    pathList.add(new AssetFile(fileIterate.getAbsolutePath(),
                            fileIterate.getName(), fileIterate.length(),getFileExtension(fileIterate),
                            ownerFile.getName(), fileIterate.isHidden(),
                            criteria.getDelimitSizeSearch(), fileIterate.canWrite(), criteria.isKeySesitive(), criteria.isSelectAll()
                            , criteria.isSelectOnlyfiles(), criteria.isStarWord(), criteria.isContentWord(),
                            criteria.isEndWord(), criteria.getOtherExtencion(),criteria.isSelectOnlyfolder()));
                    criteria.setDirectory(fileIterate.getPath());
                    searchPathName(criteria);
                }
            } else {
                if(criteria.isSelectOnlyfiles()){
                    if (fileIterate.isDirectory()) {

                        criteria.setDirectory(fileIterate.getPath());
                        searchPathName(criteria);
                    } else {
                        Path filePath = Paths.get(fileIterate.getPath());
                        ownerFile = Files.getOwner(filePath, LinkOption.NOFOLLOW_LINKS);
                        if (fileIterate.isHidden() != criteria.isHidden()) {
                            continue;
                        }
                        if (criteria.getType() != null && !fileIterate.getName().toLowerCase().endsWith(criteria.getType())) {
                            continue;
                        }
                        if (criteria.getSize() > 0 && fileIterate.length() != criteria.getSize()) {
                            continue;
                        }
                        if (criteria.getNameFile() != null && !fileIterate.getName().contains(criteria.getNameFile())) {
                            continue;
                        }
                        if (criteria.isKeySesitive() && fileIterate.getName().toLowerCase().startsWith(criteria.getNameFile())) {
                            continue;
                        }
                        if (!criteria.getOwner().isEmpty() && !ownerFile.getName().equals(criteria.getOwner())) {
                            continue;
                        }
                        if (fileIterate.canWrite() == criteria.isReadOnly() && fileIterate.canRead() == criteria.isReadOnly()) {
                            continue;
                        }
                        if (criteria.getContainWordInFile() != null && !findContentFile(fileIterate, criteria.getContainWordInFile())) {
                            continue;
                        }

                        BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
                        /*String formatFileCreate =  formatDateString(attr.creationTime().toMillis());
                        String formatCreateIni = formatDateString(criteria.getDateChoserCreateIni().toInstant().toEpochMilli());
                        String formatCreateEnd = formatDateString(criteria.getDateChooserCreateEnd().toInstant().toEpochMilli());*/
                        if (criteria.getDateChoserCreateIni() != null && criteria.getDateChooserCreateEnd() != null) {
                            String formatFileCreate =  formatDateString(attr.creationTime().toMillis());
                            String formatCreateIni = formatDateString(criteria.getDateChoserCreateIni().toInstant().toEpochMilli());
                            String formatCreateEnd = formatDateString(criteria.getDateChooserCreateEnd().toInstant().toEpochMilli());
                            if (!isRangeDate(formatCreateIni, formatCreateEnd, formatFileCreate)){
                                continue;
                            }
                        }
                        if (criteria.getDateChoiserAccessedIni() != null && criteria.getDateChoiserAccessedEnd() != null) {
                            String formatlastAccessTimeFile =  formatDateString(attr.lastAccessTime().toMillis());
                            String formatAccessedIni = formatDateString(criteria.getDateChoiserAccessedIni().toInstant().toEpochMilli());
                            String formatAccessedEnd = formatDateString(criteria.getDateChoiserAccessedEnd().toInstant().toEpochMilli());
                            if(!isRangeDate(formatAccessedIni, formatAccessedEnd, formatlastAccessTimeFile)){
                                continue;
                            }
                        }

                        if (criteria.getDateChoiserModifyIni() != null && criteria.getDateChoiserModifyEnd() != null) {
                            String formatlastModifiedFile =  formatDateString(attr.lastModifiedTime().toMillis());
                            String formatModifyIni = formatDateString(criteria.getDateChoiserModifyIni().toInstant().toEpochMilli());
                            String formatModifyEnd = formatDateString(criteria.getDateChoiserModifyEnd().toInstant().toEpochMilli());
                            if(!isRangeDate(formatModifyIni, formatModifyEnd, formatlastModifiedFile)){
                                continue;
                            }
                        }

                        pathList.add(new AssetFile(fileIterate.getAbsolutePath(),
                                fileIterate.getName(), fileIterate.length(),getFileExtension(fileIterate),
                                ownerFile.getName(), fileIterate.isHidden(),
                                criteria.getDelimitSizeSearch(), fileIterate.canWrite(), criteria.isKeySesitive(), criteria.isSelectAll()
                                , criteria.isSelectOnlyfiles(), criteria.isStarWord(), criteria.isContentWord(),
                                criteria.isEndWord(), criteria.getOtherExtencion(),criteria.isSelectOnlyfolder()));
                        criteria.setDirectory(fileIterate.getPath());
                    }
                }else{

                    if (fileIterate.isDirectory()) {

                        criteria.setDirectory(fileIterate.getPath());
                        searchPathName(criteria);
                        Path filePath = Paths.get(fileIterate.getPath());
                        ownerFile = Files.getOwner(filePath, LinkOption.NOFOLLOW_LINKS);
                        pathList.add(new AssetFile(fileIterate.getAbsolutePath(),
                                fileIterate.getName(), fileIterate.length(),getFileExtension(fileIterate),
                                ownerFile.getName(), fileIterate.isHidden(),
                                criteria.getDelimitSizeSearch(), fileIterate.canWrite(), criteria.isKeySesitive(), criteria.isSelectAll()
                                , criteria.isSelectOnlyfiles(), criteria.isStarWord(), criteria.isContentWord(),
                                criteria.isEndWord(), criteria.getOtherExtencion(),criteria.isSelectOnlyfolder()));
                        criteria.setDirectory(fileIterate.getPath());
                    }
                }
            }
        }
        LOGGER.info("menseje exit");
        return pathList;
    }

    /**
     * Method that returns a string with the extension of the document.
     * @param file receive a file.
     * @return returns a string with the extension of the document.
     */
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    /**
     * @param patch is a patch absolute to file.
     * @param contentFile word to find in file.
     * @return boolean if find.
     * @throws IOException to file error.
     */
    private boolean findContentFile(File patch, String contentFile) throws IOException {
        LOGGER.info("ModelSearch findContentFile: init");
        FileReader fr = new FileReader(patch.getAbsolutePath());
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            int indexfound = s.indexOf(contentFile);
            if (indexfound > -1) {
                return true;
            }
        }
        fr.close();
        LOGGER.info("ModelSearch findContentFile: exit");
        return false;
    }
    public String formatDateString(long date){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(date);
    }
    public boolean isRangeDate(String dateInitial, String dateFinal, String dateFile){
        String[] dateInittialArray = dateInitial.split("/");
        String[] dateFinalArray = dateFinal.split("/");
        String[] dateFileArray = dateFile.split("/");
        if (Integer.parseInt(dateFileArray[0]) >= Integer.parseInt(dateInittialArray[0]) &&
                Integer.parseInt(dateFileArray[0]) <= Integer.parseInt(dateFinalArray[0])) {
            if(Integer.parseInt(dateFileArray[1]) >= Integer.parseInt(dateInittialArray[1]) &&
                    Integer.parseInt(dateFileArray[1]) <= Integer.parseInt(dateFinalArray[1])){
                if(Integer.parseInt(dateFileArray[2]) >= Integer.parseInt(dateInittialArray[2]) &&
                        Integer.parseInt(dateFileArray[2]) <= Integer.parseInt(dateFinalArray[2])){
                    return true;
                }
            }
        }
        return false;
    }
}
