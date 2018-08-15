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

import com.fundation.search.controller.CriterialSearch;
import com.fundation.search.utils.LoggerWrapper;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFile extends Search{
    private static final Logger LOGGER = LoggerWrapper.getInstance().getLogger();
    private List<Asset> modelSearch = new ArrayList<>();

    @Override
    public List<Asset> searchCriterial(CriterialSearch criteria) throws IOException {
        LOGGER.info("SearchFile searchCriterial: enter");
        File files = new File(criteria.getDirectory());
        File[] ficheros = files.listFiles();
        for(File fileIterate : ficheros){
            if(criteria.isSelectAll()){
                filePath = Paths.get(fileIterate.getPath());
                attr = Files.readAttributes(filePath, BasicFileAttributes.class);
                if (fileIterate.isDirectory()) {
                    if (search(fileIterate, criteria)){
                        modelSearch.add(new AssetFile(fileIterate.getPath(),  fileIterate.getName(), fileIterate.length(),
                                getFileExtension(fileIterate), ownerFile.getName(), fileIterate.isHidden(), !fileIterate.canWrite(),
                                formatDateString(attr.creationTime().toMillis()),formatDateString(attr.lastModifiedTime().toMillis()),
                                formatDateString(attr.lastAccessTime().toMillis()), true));
                        criteria.setDirectory(fileIterate.getPath());
                        searchCriterial(criteria);
                    }
                } else {
                    if (search(fileIterate, criteria)) {
                        modelSearch.add(new AssetFile(fileIterate.getPath(), fileIterate.getName(), fileIterate.length(),
                                getFileExtension(fileIterate), ownerFile.getName(), fileIterate.isHidden(), !fileIterate.canWrite(),
                                formatDateString(attr.creationTime().toMillis()), formatDateString(attr.lastModifiedTime().toMillis()),
                                formatDateString(attr.lastAccessTime().toMillis()), false));
                    }
                }
            }
            if(criteria.isSelectOnlyfolder()){
                filePath = Paths.get(fileIterate.getPath());
                attr = Files.readAttributes(filePath, BasicFileAttributes.class);
                if (fileIterate.isDirectory()) {
                    if (search(fileIterate, criteria)){
                        modelSearch.add(new AssetFile(fileIterate.getPath(),  fileIterate.getName(), fileIterate.length(),
                                getFileExtension(fileIterate), ownerFile.getName(), fileIterate.isHidden(), !fileIterate.canWrite(),
                                formatDateString(attr.creationTime().toMillis()),formatDateString(attr.lastModifiedTime().toMillis()),
                                formatDateString(attr.lastAccessTime().toMillis()), true));
                    }
                    criteria.setDirectory(fileIterate.getPath());
                    searchCriterial(criteria);
                }
            }
            if (criteria.isSelectOnlyfiles()){
                filePath = Paths.get(fileIterate.getPath());
                attr = Files.readAttributes(filePath, BasicFileAttributes.class);
                if (fileIterate.isDirectory()) {
                    criteria.setDirectory(fileIterate.getPath());
                    searchCriterial(criteria);
                } else {
                    filePath = Paths.get(fileIterate.getPath());
                    if (!search(fileIterate, criteria)){
                        continue;
                    }
                    if (!criteria.getType().equals(" ")  && !fileIterate.getName().toLowerCase().endsWith(criteria.getType())) {
                        continue;
                    }
                    if (criteria.getContainWordInFile() != null && !findContentFile(fileIterate, criteria.getContainWordInFile())) {
                        continue;
                    }
                    modelSearch.add(new AssetFile(fileIterate.getPath(),  fileIterate.getName(), fileIterate.length(),
                            getFileExtension(fileIterate), ownerFile.getName(), fileIterate.isHidden(), !fileIterate.canWrite(),
                            formatDateString(attr.creationTime().toMillis()),formatDateString(attr.lastModifiedTime().toMillis()),
                            formatDateString(attr.lastAccessTime().toMillis()), false));
                }
            }
        }
        LOGGER.info("SearchFile searchCriterial: exit");
        return modelSearch;
    }

    /**
     * @param patch is a patch absolute to file.
     * @param contentFile word to find in file.
     * @return boolean if find.
     * @throws IOException to file error.
     */
    private boolean findContentFile(File patch, String contentFile) throws IOException {
        LOGGER.info("SearchFile findContentFile: init");
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
        LOGGER.info("SearchFile findContentFile: exit");
        return false;
    }

}
