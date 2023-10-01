package com.laptrinhjavaweb.dto;

public class EmailDTO {

    private String fullName;
    private String email;
    private String seoUrl;
    private String toMails;
    private String title;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSeoUrl() {
        return seoUrl;
    }

    public void setSeoUrl(String seoUrl) {
        this.seoUrl = seoUrl;
    }

    public String getToMails() {
        return toMails;
    }

    public void setToMails(String toMails) {
        this.toMails = toMails;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
