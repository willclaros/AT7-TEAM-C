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
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;

/**
 * This class ModelSearch can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Yerel Hurtado - AT-[07].
 * @author William Claros Revollo - AT-[07]
 * @version 1.0.
 */
public class ModelSearch {
    private static final Logger LOGGER = LoggerWrapper.getInstance().getLogger();
    /**
     * this Array storage files find with specific arguments.
     */
    private List<Asset> pathList = new ArrayList<>();

    /**
     * Method that performs the search of files.
     *
     * @param criteria is object of type Criteria that contains the information that was recovered from the View.
     * @return List String name file.
     * @throws IOException file.
     */
    public List<Asset> searchPathName(CriterialSearch criteria) throws IOException {
        LOGGER.info("init search");
        File files = new File(criteria.getPath());
        File[] ficheros = files.listFiles();

        for (File fileIterate : ficheros) {
            if (fileIterate.isDirectory()) {
                criteria.setPath(fileIterate.getPath());
                searchPathName(criteria);
            } else {
                Path filePath = Paths.get(fileIterate.getPath());
                UserPrincipal ownerFile = Files.getOwner(filePath, LinkOption.NOFOLLOW_LINKS);
                if (fileIterate.isHidden() != criteria.getHidden()) {
                    continue;
                }
                if (criteria.getFileExtension() != null && !fileIterate.getName().toLowerCase().endsWith(criteria.getFileExtension())) {
                    continue;
                }

                if (criteria.getFilename() != null && !fileIterate.getName().contains(criteria.getFilename())) {
                    continue;
                }
                if (criteria.getKeySensitive() && fileIterate.getName().toLowerCase().startsWith(criteria.getFilename())) {
                    continue;
                }
                if (!criteria.getOwner().isEmpty() && !ownerFile.getName().equals(criteria.getOwner())) {
                    continue;
                }
                if (fileIterate.canWrite() == criteria.getReadOnly() && fileIterate.canRead() == criteria.getReadOnly()) {
                    continue;
                }
                if (criteria.getContainWordInFile() != null && !findContentFile(fileIterate, criteria.getContainWordInFile())) {
                    continue;
                }

                pathList.add(new AssetFile(fileIterate.getAbsolutePath(),
                        fileIterate.getName(), getFileExtension(fileIterate), null, fileIterate.length(), null, null,
                        ownerFile.getName(), false, false, fileIterate.isHidden(), fileIterate.canWrite(),
                        criteria.getKeySensitive(), criteria.getStarWord(), criteria.getContentWord(), criteria.getEndWord(), criteria.getDateCreatedIni(),
                        criteria.getDateModifyEnd(), criteria.getDateAccessEnd(), criteria.getSelectFolder(), criteria.getContainWordInFile()));
            }
        }
        LOGGER.info("menseje exit");
        return pathList;
    }


    /**
     * Method that returns a string with the extension of the document.
     *
     * @param file receive a file.
     * @return returns a string with the extension of the document.
     */
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }

    /**
     * @param patch       is a patch absolute to file.
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
}
