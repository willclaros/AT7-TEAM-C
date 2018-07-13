package com.fundation.search.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ModelSearch {

    public List<String> searchPathName(String pathName) {

        File folder = new File(pathName);
        File[] listOfFiles = folder.listFiles();
        List<String> pathList = new ArrayList<>();
        assert listOfFiles != null;
        for (File listOfFile : listOfFiles) {
            System.out.println("File " + listOfFile.getName());
            pathList.add(listOfFile.getName());
        }
        return pathList;
    }
}
