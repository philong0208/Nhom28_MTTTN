package com.laptrinhjavaweb.dto;

public class ChapterDTO extends AbstractDTO<ChapterDTO> {
    private boolean approved;
    public boolean isApproved() {
        return approved;
    }
    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    private String createdByFullName;
    public String getCreatedByFullName() {
        return createdByFullName;
    }
    public void setCreatedByFullName(String createdByFullName) {
        this.createdByFullName = createdByFullName;
    }
    private String shortTitle;
    private String thumbnail;
    private String content;
    private Long postId;
    private String postShortTitle;
    public Long getPostId() {
        return postId;
    }
    public void setPostId(Long postId) {
        this.postId = postId;
    }
    public String getPostShortTitle() {
        return postShortTitle;
    }
    public void setPostShortTitle(String postShortTitle) {
        this.postShortTitle = postShortTitle;
    }

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