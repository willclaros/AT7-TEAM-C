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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

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
        File files = new File(criteria.getPath());
        File[] ficheros = files.listFiles();

        for (File fileIterate : ficheros) {
            if(criteria.getSelectAll()) {
                if (fileIterate.isDirectory()) {
                    pathList.add(new AssetFile(fileIterate.getCanonicalPath(),
                            fileIterate.getName(), getFileExtension(fileIterate), null, fileIterate.length(), null, null,
                            ownerFile.getName(), false, false, fileIterate.isHidden(), fileIterate.canWrite(),
                            criteria.getKeySensitive(), criteria.getStarWord(), criteria.getContentWord(), criteria.getEndWord(), criteria.getDateCreatedIni(),
                            criteria.getDateModifyEnd(), criteria.getDateAccessEnd(), criteria.getSelectFolder(), criteria.getContainWordInFile()));
                    criteria.setPath(fileIterate.getPath());
                    searchPathName(criteria);
                } else {
                    Path filePath = Paths.get(fileIterate.getPath());
                    ownerFile = Files.getOwner(filePath, LinkOption.NOFOLLOW_LINKS);
                    if (fileIterate.isHidden() != criteria.getHidden()) {
                        continue;
                    }
                    if (criteria.getFileExtension() != null && !fileIterate.getName().toLowerCase().endsWith(criteria.getFileExtension())) {
                        continue;
                    }
                    if (criteria.getSize() > 0 && fileIterate.length() != criteria.getSize()) {
                        continue;
                    }
                    if (criteria.getFilename() != null && !fileIterate.getName().contains(criteria.getFilename())) {
                        continue;
                    }
                    if (criteria.getOwner() != null && ownerFile.getName().equals(criteria.getOwner())) {
                        continue;
                    }
                    if (fileIterate.canWrite() == criteria.getReadOnly() && fileIterate.canRead() == criteria.getReadOnly()) {
                        continue;
                    }
                    if (criteria.getContainWordInFile() != null && !findContentFile(fileIterate, criteria.getContainWordInFile())) {
                        continue;
                    }
                    if (criteria.getDateCreatedIni() != 0 && (criteria.getDateCreatedEnd() - criteria.getDateCreatedEnd() > 0)) {
                        continue;
                    }
                    if (criteria.getDateModifyIni() != 0 && (criteria.getDateModifyEnd() - criteria.getDateModifyIni() > 0)) {
                        continue;
                    }
                    pathList.add(new AssetFile(fileIterate.getCanonicalPath(),
                            fileIterate.getName(), getFileExtension(fileIterate), null, fileIterate.length(), null, null,
                            ownerFile.getName(), false, false, fileIterate.isHidden(), fileIterate.canWrite(),
                            criteria.getKeySensitive(), criteria.getStarWord(), criteria.getContentWord(), criteria.getEndWord(), criteria.getDateCreatedIni(),
                            criteria.getDateModifyEnd(), criteria.getDateAccessEnd(), criteria.getSelectFolder(), criteria.getContainWordInFile()));
                }
            }else {
                if(criteria.getSelectfiles()){

                    if (fileIterate.isDirectory()) {

                        criteria.setPath(fileIterate.getPath());
                        searchPathName(criteria);
                    } else {
                        Path filePath = Paths.get(fileIterate.getPath());
                        ownerFile = Files.getOwner(filePath, LinkOption.NOFOLLOW_LINKS);
                        if (fileIterate.isHidden() != criteria.getHidden()) {
                            continue;
                        }
                        if (criteria.getFileExtension() != null && !fileIterate.getName().toLowerCase().endsWith(criteria.getFileExtension())) {
                            continue;
                        }
                        if (criteria.getSize() > 0 && fileIterate.length() != criteria.getSize()) {
                            continue;
                        }
                        if (criteria.getFilename() != null && !fileIterate.getName().contains(criteria.getFilename())) {
                            continue;
                        }
                        if (criteria.getOwner() != null && ownerFile.getName().equals(criteria.getOwner())) {
                            continue;
                        }
                        if (fileIterate.canWrite() == criteria.getReadOnly() && fileIterate.canRead() == criteria.getReadOnly()) {
                            continue;
                        }
                        if (criteria.getContainWordInFile() != null && !findContentFile(fileIterate, criteria.getContainWordInFile())) {
                            continue;
                        }
                        if (criteria.getDateCreatedIni() != 0 && (criteria.getDateCreatedEnd() - criteria.getDateCreatedEnd() > 0)) {
                            continue;
                        }
                        if (criteria.getDateModifyIni() != 0 && (criteria.getDateModifyEnd() - criteria.getDateModifyIni() > 0)) {
                            continue;
                        }
                        pathList.add(new AssetFile(fileIterate.getCanonicalPath(),
                                fileIterate.getName(), getFileExtension(fileIterate), null, fileIterate.length(), null, null,
                                ownerFile.getName(), false, false, fileIterate.isHidden(), fileIterate.canWrite(),
                                criteria.getKeySensitive(), criteria.getStarWord(), criteria.getContentWord(), criteria.getEndWord(), criteria.getDateCreatedIni(),
                                criteria.getDateModifyEnd(), criteria.getDateAccessEnd(), criteria.getSelectFolder(), criteria.getContainWordInFile()));
                    }
                }else{

                    if (fileIterate.isDirectory()) {

                        criteria.setPath(fileIterate.getPath());
                        searchPathName(criteria);
                        Path filePath = Paths.get(fileIterate.getPath());
                        ownerFile = Files.getOwner(filePath, LinkOption.NOFOLLOW_LINKS);
                        pathList.add(new AssetFile(fileIterate.getCanonicalPath(),
                                fileIterate.getName(), getFileExtension(fileIterate), null, fileIterate.length(), null, null,
                                ownerFile.getName(), false, false, fileIterate.isHidden(), fileIterate.canWrite(),
                                criteria.getKeySensitive(), criteria.getStarWord(), criteria.getContentWord(), criteria.getEndWord(), criteria.getDateCreatedIni(),
                                criteria.getDateModifyEnd(), criteria.getDateAccessEnd(), criteria.getSelectFolder(), criteria.getContainWordInFile()));
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

    /*public void saveCriteriaDataBase(CriterialSearch criteriaSearch) {
        try {
            SearchQuery insertCriteriaDb = new SearchQuery();
            Gson jsonCriteria = new Gson();
            String saveCriteria = jsonCriteria.toJson(criteriaSearch);
            System.out.println(saveCriteria);
            insertCriteriaDb.insertCriteria(saveCriteria);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

}
