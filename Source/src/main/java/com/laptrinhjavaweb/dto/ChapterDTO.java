package com.laptrinhjavaweb.dto;

public class ChapterDTO extends AbstractDTO<ChapterDTO> {
    private String shortTitle;
    private String thumbnail;
    private String content;

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String thumbnailBase64;
    private String thumbnailImageName;
    public String getThumbnailImageName() {
        return thumbnailImageName;
    }
    public void setThumbnailImageName(String thumbnailImageName) {
        this.thumbnailImageName = thumbnailImageName;
    }
    public String getThumbnailBase64() {
        if (thumbnailBase64 != null) {
            return thumbnailBase64.split(",")[1];
        }
        return thumbnailBase64;
    }
    public void setThumbnailBase64(String thumbnailBase64) {
        this.thumbnailBase64 = thumbnailBase64;
    }
}