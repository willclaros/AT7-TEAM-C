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

import com.fundation.search.DataBase.SearchQuery;
import com.fundation.search.controller.CriterialSearch;
import com.fundation.search.utils.LoggerWrapper;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Search {
    protected UserPrincipal ownerFile;
    protected Path filePath;
    protected BasicFileAttributes attr;
    private static final Logger LOGGER = LoggerWrapper.getInstance().getLogger();

    protected abstract List<Asset> searchCriterial (CriterialSearch criterialSearch) throws IOException;

    /**
     * @param delimitSize is a > < =.
     * @param criterialSize is a input size search.
     * @param unitSize is a unid to search MB, GB, Bytes.
     * @param size is a size the file.
     * @return true if file usseful criterial.
     */
    public boolean verifyRangeSizeFile(String delimitSize,long criterialSize,String unitSize,long size) {
        LOGGER.info("Search verifyRangeSizeFile: enter");
        // Get length of file in bytes
        long fileSizeInBytes = size;
        // Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
        long fileSizeInKB = fileSizeInBytes / 1024;
        // Convert the KB to MegaBytes (1 MB = 1024 KBytes)
        long fileSizeInMB = fileSizeInKB / 1024;
        // Convert the MB to GygaBytes (1 GB = 1024 MegaBytes)
        long fileSizeInGB = fileSizeInMB / 1024;
        if (delimitSize == " = " && unitSize == "Byte" && fileSizeInBytes == criterialSize) {
            return true;
        }
        if (delimitSize == " > " && unitSize == "Byte" && fileSizeInBytes > criterialSize) {
            return true;
        }
        if (delimitSize == " < " && unitSize == "Byte" && fileSizeInBytes < criterialSize) {
            return true;
        }
        if (delimitSize == " = " && unitSize == "KByte" && fileSizeInKB == criterialSize) {
            return true;
        }
        if (delimitSize == " > " && unitSize == "KByte" && fileSizeInKB > criterialSize) {
            return true;
        }
        if (delimitSize == " < " && unitSize == "KByte" && fileSizeInKB < criterialSize) {
            return true;
        }
        if (delimitSize == " = " && unitSize == "MByte" && fileSizeInMB == criterialSize) {
            return true;
        }
        if (delimitSize == " > " && unitSize == "MByte" && fileSizeInMB > criterialSize) {
            return true;
        }
        if (delimitSize == " < " && unitSize == "MByte" && fileSizeInMB < criterialSize) {
            return true;
        }
        if (delimitSize == " = " && unitSize == "GByte" && fileSizeInGB == criterialSize) {
            return true;
        }
        if (delimitSize == " > " && unitSize == "GByte" && fileSizeInGB > criterialSize) {
            return true;
        }
        if (delimitSize == " < " && unitSize == "GByte" && fileSizeInGB == criterialSize) {
            return true;
        }
        LOGGER.info("Search verifyRangeSizeFile: exit");
        return false;
    }
    /**
     * Method that returns a string with the extension of the document.
     * @param file receive a file.
     * @return returns a string with the extension of the document.
     */
    protected static String getFileExtension(File file) {
        LOGGER.info("Search getFileExtension: enter");
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".")+1);
        }
        LOGGER.info("Search getFileExtension: exit");
        return "";
    }

    public String formatDateString(long date) throws IOException {
        LOGGER.info("Search formatDateString: enter");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        LOGGER.info("Search formatDateString: exit");
        return sdf.format(date);
    }

    public boolean isRangeDate(String dateInitial, String dateFinal, String dateFile){
        LOGGER.info("Search isRangeDate: enter");
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
        LOGGER.info("Search isRangeDate: exit");
        return false;
    }

    public void saveCriteriaDataBase(CriterialSearch criteriaSearch) {
        LOGGER.info("Search saveCriteriaDataBase: enter");
        try {
            SearchQuery insertCriteriaDb = new SearchQuery();
            Gson jsonCriteria = new Gson();
            String saveCriteria = jsonCriteria.toJson(criteriaSearch);
            insertCriteriaDb.insertCriteria(saveCriteria);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        LOGGER.info("Search saveCriteriaDataBase: exit");
    }

    public Map<Integer, CriterialSearch> getAllDataCriteriaDataBase() {
        LOGGER.info("Search getAllDataCriteriaDataBase: enter");
        ResultSet resultSet = null;
        CriterialSearch searchCriteria;
        int index;
        Map<Integer, CriterialSearch> criteriaList = new HashMap<>();
        Gson gSonCriteria = new Gson();
        try {
            SearchQuery searchQuery = new SearchQuery();
            resultSet = searchQuery.getAllCriteria();
            while (resultSet.next()) {

                index = resultSet.getInt("ID");
                searchCriteria = gSonCriteria.fromJson(resultSet.getString("CRITERIAJSON"), CriterialSearch.class);
                criteriaList.put(index, searchCriteria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        LOGGER.info("Search getAllDataCriteriaDataBase: exit");
        return criteriaList;
    }

    protected boolean search (File fileIterate, CriterialSearch criteria) throws IOException {
        LOGGER.info("Search search: enter");
        filePath = Paths.get(fileIterate.getPath());
        ownerFile = Files.getOwner(filePath, LinkOption.NOFOLLOW_LINKS);
        if (fileIterate.isHidden() != criteria.isHidden()) {
            return false;
        }
        if (criteria.getNameFile() != null && !fileIterate.getName().contains(criteria.getNameFile())) {
            return false;
        }
        if (criteria.isKeySensitive() && fileIterate.getName().toLowerCase().startsWith(criteria.getNameFile())) {
            return false;
        }
        if (!criteria.getOwner().isEmpty() && !ownerFile.getName().equals(criteria.getOwner())) {
            return false;
        }
        if (fileIterate.canWrite() == criteria.isReadOnly() && fileIterate.canRead() == criteria.isReadOnly()) {
            return false;
        }
        if (criteria.getSize() > 0 && !verifyRangeSizeFile(criteria.getDelimitSizeSearch(), criteria.getSize(), criteria.getUnitSize(), fileIterate.length())){
            return false;
        }
        if (criteria.getDateChoserCreateIni() != null && criteria.getDateChooserCreateEnd() != null && criteria.isDateCreatedSelected()) {
            String formatFileCreate =  formatDateString(attr.creationTime().toMillis());
            String formatCreateIni = formatDateString(criteria.getDateChoserCreateIni().toInstant().toEpochMilli());
            String formatCreateEnd = formatDateString(criteria.getDateChooserCreateEnd().toInstant().toEpochMilli());
            if (!isRangeDate(formatCreateIni, formatCreateEnd, formatFileCreate)){
                return false;
            }
        }
        if (criteria.getDateChoiserAccessedIni() != null && criteria.getDateChoiserAccessedEnd() != null && criteria.isDateAccessedSelected()) {
            String formatlastAccessTimeFile =  formatDateString(attr.lastAccessTime().toMillis());
            String formatAccessedIni = formatDateString(criteria.getDateChoiserAccessedIni().toInstant().toEpochMilli());
            String formatAccessedEnd = formatDateString(criteria.getDateChoiserAccessedEnd().toInstant().toEpochMilli());
            if(!isRangeDate(formatAccessedIni, formatAccessedEnd, formatlastAccessTimeFile)){
                return false;
            }
        }

        if (criteria.getDateChoiserModifyIni() != null && criteria.getDateChoiserModifyEnd() != null && criteria.isDateModifySelected()) {
            String formatlastModifiedFile =  formatDateString(attr.lastModifiedTime().toMillis());
            String formatModifyIni = formatDateString(criteria.getDateChoiserModifyIni().toInstant().toEpochMilli());
            String formatModifyEnd = formatDateString(criteria.getDateChoiserModifyEnd().toInstant().toEpochMilli());
            if(!isRangeDate(formatModifyIni, formatModifyEnd, formatlastModifiedFile)){
                return false;
            }
        }
        LOGGER.info("Search search: exit");
        return true;
    }
}
