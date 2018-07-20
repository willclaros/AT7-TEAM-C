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
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class ModelSearch can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Yerel Hurtado - AT-[07].
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
    public List<AssetFile> searchPathName(String directory, String nameFile, String type, long size, boolean hidden, String owner) throws IOException {

        File files = new File(directory);
        File[] ficheros = files.listFiles();
        //File[] childrenFiles = files.listFiles(filter);
        for (File fileIterate : ficheros) {
            //FilenameFilter filter = (dir1, name) -> name.contains(nameFile);
            Path filePath = Paths.get(fileIterate.getPath());
            FileOwnerAttributeView ownerInfo = Files.getFileAttributeView(filePath, FileOwnerAttributeView.class);
            UserPrincipal fileOwner = ownerInfo.getOwner();
            if (fileIterate.isHidden() != hidden) {
                break;
            }
            if (type != null && !fileIterate.getName().toLowerCase().endsWith(type)) {
                break;
            }
            if (size >= 0 && fileIterate.length() != size) {
                break;
            }
            if (nameFile != null && !fileIterate.getName().contains(nameFile)) {
                break;
            }
            if (owner != null && !fileOwner.getName().equalsIgnoreCase(owner)) {
                break;
            }

            pathList.add(new AssetFile(fileIterate.getAbsolutePath(), fileIterate.getName(), fileIterate.length(), type, fileOwner.getName()));
        }
        assert ficheros != null;
        for (File fichero : ficheros) {
            if (fichero.isDirectory()) {
                searchPathName(fichero.getPath(), nameFile, type, size, hidden, owner);
            }
        }
        return pathList;
    }
}
