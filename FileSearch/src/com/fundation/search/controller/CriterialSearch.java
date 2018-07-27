package com.fundation.search.controller;

public class CriterialSearch {
    private String directory;
    private String nameFile;
    private String content;
    private String type;
    private String owner;
    private long size;
    private boolean keySesitive;
    private boolean hidden;
    private boolean folder;
    private boolean readOnly;

    public CriterialSearch(String directory, String nameFile, String content,
                           String type, String owner, long size, boolean hidden,
                           boolean folder, boolean readOnly, boolean keySesitive) {
        this.directory = directory;
        this.nameFile = nameFile;
        this.content = content;
        this.type = type;
        this.owner = owner;
        this.size = size;
        this.hidden = hidden;
        this.folder = folder;
        this.readOnly = readOnly;
        this.keySesitive = keySesitive;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isFolder() {
        return folder;
    }

    public void setFolder(boolean folder) {
        this.folder = folder;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isKeySesitive() {
        return keySesitive;
    }

    public void setKeySesitive(boolean keySesitive) {
        this.keySesitive = keySesitive;
    }
}
