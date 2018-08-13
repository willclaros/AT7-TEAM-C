package com.fundation.search.model;

import com.fundation.search.DataBase.SearchQuery;
import com.fundation.search.controller.CriterialSearch;
import com.google.gson.Gson;

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

    protected abstract List<Asset> searchCriterial (CriterialSearch criterialSearch) throws IOException;

    /*public boolean verifyRangeSizeFile(CriterialSearch criterialSearch, long size){
        if(criterialSearch.getDelimitSizeSearch() == " = "){
            if(criterialSearch.getUnitSize() == ){

            }
        }
        return false;
    }*/
    /**
     * Method that returns a string with the extension of the document.
     * @param file receive a file.
     * @return returns a string with the extension of the document.
     */
    protected static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    public String formatDateString(long date) throws IOException {
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

    public void saveCriteriaDataBase(CriterialSearch criteriaSearch) {
        try {
            SearchQuery insertCriteriaDb = new SearchQuery();
            Gson jsonCriteria = new Gson();
            String saveCriteria = jsonCriteria.toJson(criteriaSearch);
            //System.out.println(saveCriteria);
            insertCriteriaDb.insertCriteria(saveCriteria);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, CriterialSearch> getAllDataCriteriaDataBase() {
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
        System.out.println(criteriaList);
        return criteriaList;
    }

    protected boolean search (File fileIterate, CriterialSearch criteria) throws IOException {
        filePath = Paths.get(fileIterate.getPath());
        ownerFile = Files.getOwner(filePath, LinkOption.NOFOLLOW_LINKS);
        if (fileIterate.isHidden() != criteria.isHidden()) {
            return false;
        }
        if (criteria.getSize() > 0 && fileIterate.length() != criteria.getSize()) {
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
        //BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
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
        return true;
    }
}
