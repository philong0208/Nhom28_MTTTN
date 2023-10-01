package com.laptrinhjavaweb.dto;

public class UploadRsDTO {
    private String fileName;
    private String src;
    private String fileType;
    private long size;

    public UploadRsDTO(String fileName, String src, String fileType, long size) {
        this.fileName = fileName;
        this.src = src;
        this.fileType = fileType;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
