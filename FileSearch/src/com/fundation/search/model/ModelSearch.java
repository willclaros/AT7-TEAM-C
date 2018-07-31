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

import java.io.File;
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
 *
 * @version 1.0.
 */
public class ModelSearch {
    /**
     * this Array storage files find with specific arguments.
     */
    private List<AssetFile> pathList = new ArrayList<>();

    /**
     * @param directory patch to search files.
     * @param nameFile  is file to search.
     * @param type      extension to file.
     * @param size      file to search.
     * @param hidden    if file hidden true.
     * @param owner     of file create.
     * @return List String name file.
     * @throws IOException file.
     * @throws IOException file.
     */
    public List<AssetFile> searchPathName(CriterialSearch criteria) throws IOException {

        File files = new File(criteria.getDirectory());
        File[] ficheros = files.listFiles();

        for (File fileIterate : ficheros) {

            if (fileIterate.isDirectory()) {
                searchPathName(criteria);
            } else {
                Path filePath = Paths.get(fileIterate.getPath());
                UserPrincipal ownerFile = Files.getOwner(filePath, LinkOption.NOFOLLOW_LINKS);
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
                if (criteria.getOwner() != null && ownerFile.getName().equals(criteria.getOwner())) {
                    continue;
                }
                if (fileIterate.canWrite() == criteria.isReadOnly()) {
                    continue;
                }

                pathList.add(new AssetFile(
                        fileIterate.getPath(),fileIterate.getName(), fileIterate.length(),getFileExtension(fileIterate),
                        ownerFile.getName(), fileIterate.isHidden(),
                        criteria.getDelimitSizeSearch(), fileIterate.canWrite(), criteria.isKeySesitive(), criteria.isSelectAll(),
                criteria.isSelectOnlyfolder(), criteria.isSelectOnlyfiles(), criteria.isStarWord(), criteria.isContentWord(),
                criteria.isEndWord(), criteria.getOtherExtencion()));
            }
        }
        return pathList;
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
