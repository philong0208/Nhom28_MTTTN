package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.List;

public class PostDTO extends AbstractDTO<PostDTO> {
    private List<String> nameOfChapters = new ArrayList<>();
    public List<String> getNameOfChapters() {
        return nameOfChapters;
    }
    public void setNameOfChapters(List<String> nameOfChapters) {
        this.nameOfChapters = nameOfChapters;
    }
    public int getTotalChapters() {
        return nameOfChapters.size();
    }
    public String getNameOfChaptersStr() {
        return String.join(", ", nameOfChapters);
    }
    private String tagNameStr;

    public String getTagNameStr() {
        return tagNameStr;
    }

    public void setTagNameStr(String tagNameStr) {
        this.tagNameStr = tagNameStr;
    }

    private String[] tagCodeArray = new String[]{};

    public String[] getTagCodeArray() {
        return tagCodeArray;
    }

    public void setTagCodeArray(String[] tagCodeArray) {
        this.tagCodeArray = tagCodeArray;
    }
    private String authorNameStr;

    public String getAuthorNameStr() {
        return authorNameStr;
    }

    public void setAuthorNameStr(String authorNameStr) {
        this.authorNameStr = authorNameStr;
    }

    private String[] authorCodeArray = new String[]{};

    public String[] getAuthorCodeArray() {
        return authorCodeArray;
    }

    public void setAuthorCodeArray(String[] authorCodeArray) {
        this.authorCodeArray = authorCodeArray;
    }
    private static final long serialVersionUID = -605223606014371190L;

    private String title;
    private String shortTitle;
    private String thumbnail;
    private String shortDescription;
    private String content;
    private String content1;
    private String content2;
    private String content3;

    private String content4;

    private String content5;

    private String content6;

    private String content7;

    private String content8;

    private String content9;

    private String content10;

    private String content11;

    private String content12;

    private String content13;

    private String metaDescription;
    private String metaKeywords;
    private String ogTitle;
    private String ogDescription;
    private String ogUrl;
    private String categoryCode;
    private String categoryName;
    private String thumbnailBase64;
    private String thumbnailImageName;
    private String ogImageBase64;
    private String ogImageName;
    private String seoUrl;
    private String ogImage;
    private String hotPost;
    private String altThumbnail;
    private String titleThumbnail;
    private String slideConfiguration;
    private String menuConfiguration;
    /*private Integer hostPostNumber;*/
    private Integer slideConfigurationNumber;
    private Integer menuConfigurationNumber;
    private String blogConfiguration;
    private String canonicalUrl;
    private String toMails;
    private String shortUrl;
    private String redirectUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getOgTitle() {
        return ogTitle;
    }

    public void setOgTitle(String ogTitle) {
        this.ogTitle = ogTitle;
    }

    public String getOgDescription() {
        return ogDescription;
    }

    public void setOgDescription(String ogDescription) {
        this.ogDescription = ogDescription;
    }

    public String getOgUrl() {
        return ogUrl;
    }

    public void setOgUrl(String ogUrl) {
        this.ogUrl = ogUrl;
    }

    public String getSeoUrl() {
        return seoUrl;
    }

    public void setSeoUrl(String seoUrl) {
        this.seoUrl = seoUrl;
    }

    public String getOgImageName() {
        return ogImageName;
    }

    public void setOgImageName(String ogImageName) {
        this.ogImageName = ogImageName;
    }

    public String getOgImageBase64() {
        if (ogImageBase64 != null) {
            return ogImageBase64.split(",")[1];
        }
        return ogImageBase64;
    }

    public void setOgImageBase64(String ogImageBase64) {
        this.ogImageBase64 = ogImageBase64;
    }

    public String getThumbnailImageName() {
        return thumbnailImageName;
    }

    public void setThumbnailImageName(String thumbnailImageName) {
        this.thumbnailImageName = thumbnailImageName;
    }

    public String getOgImage() {
        return ogImage;
    }

    public void setOgImage(String ogImage) {
        this.ogImage = ogImage;
    }

    public String getHotPost() {
        return hotPost;
    }

    public void setHotPost(String hotPost) {
        this.hotPost = hotPost;
    }

    public String getAltThumbnail() {
        return altThumbnail;
    }

    public void setAltThumbnail(String altThumbnail) {
        this.altThumbnail = altThumbnail;
    }

    public String getTitleThumbnail() {
        return titleThumbnail;
    }

    public void setTitleThumbnail(String titleThumbnail) {
        this.titleThumbnail = titleThumbnail;
    }

    public String getMenuConfiguration() {
        return menuConfiguration;
    }

    public void setMenuConfiguration(String menuConfiguration) {
        this.menuConfiguration = menuConfiguration;
    }

    public String getSlideConfiguration() {
        return slideConfiguration;
    }

    public void setSlideConfiguration(String slideConfiguration) {
        this.slideConfiguration = slideConfiguration;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    /*public Integer getHostPostNumber() {
        return hostPostNumber;
    }

    public void setHostPostNumber(Integer hostPostNumber) {
        this.hostPostNumber = hostPostNumber;
    }*/

    public Integer getSlideConfigurationNumber() {
        return slideConfigurationNumber;
    }

    public void setSlideConfigurationNumber(Integer slideConfigurationNumber) {
        this.slideConfigurationNumber = slideConfigurationNumber;
    }

    public Integer getMenuConfigurationNumber() {
        return menuConfigurationNumber;
    }

    public void setMenuConfigurationNumber(Integer menuConfigurationNumber) {
        this.menuConfigurationNumber = menuConfigurationNumber;
    }

    public String getBlogConfiguration() {
        return blogConfiguration;
    }

    public void setBlogConfiguration(String blogConfiguration) {
        this.blogConfiguration = blogConfiguration;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public String getToMails() {
        return toMails;
    }

    public void setToMails(String toMails) {
        this.toMails = toMails;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }

    public String getContent4() {
        return content4;
    }

    public void setContent4(String content4) {
        this.content4 = content4;
    }

    public String getContent5() {
        return content5;
    }

    public void setContent5(String content5) {
        this.content5 = content5;
    }

    public String getContent6() {
        return content6;
    }

    public void setContent6(String content6) {
        this.content6 = content6;
    }

    public String getContent7() {
        return content7;
    }

    public void setContent7(String content7) {
        this.content7 = content7;
    }

    public String getContent8() {
        return content8;
    }

    public void setContent8(String content8) {
        this.content8 = content8;
    }

    public String getContent9() {
        return content9;
    }

    public void setContent9(String content9) {
        this.content9 = content9;
    }

    public String getContent10() {
        return content10;
    }

    public void setContent10(String content10) {
        this.content10 = content10;
    }

    public String getContent11() {
        return content11;
    }

    public void setContent11(String content11) {
        this.content11 = content11;
    }

    public String getContent12() {
        return content12;
    }

    public void setContent12(String content12) {
        this.content12 = content12;
    }

    public String getContent13() {
        return content13;
    }

    public void setContent13(String content13) {
        this.content13 = content13;
    }
}
