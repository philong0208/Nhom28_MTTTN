package com.laptrinhjavaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class PostEntity extends BaseEntity {

    private static final long serialVersionUID = 1444028163589745435L;

    @Column(length = 1000)
    private String title;

    @Column(name = "shorttitle")
    private String shortTitle;

    @Column
    private String thumbnail;

    @Column(name = "altthumbnail")
    private String altThumbnail;

    @Column(name = "titlethumbnail")
    private String titleThumbnail;

    @Column(name = "shortdescription", columnDefinition = "TEXT")
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String content1;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String content2;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String content3;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String content4;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String content5;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String content6;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String content7;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String content8;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String content9;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String content10;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String content11;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String content12;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String content13;

    @Column(name = "metadescription", columnDefinition = "TEXT")
    private String metaDescription;

    @Column(name = "metakeywords", columnDefinition = "TEXT")
    private String metaKeywords;

    @Column(name = "ogtitle", length = 1000)
    private String ogTitle;

    @Column(name = "ogdescription", columnDefinition = "TEXT")
    private String ogDescription;

    @Column(name = "ogurl", length = 1000)
    private String ogUrl;

    @Column(name = "ogimage")
    private String ogImage;

    @Column(name = "seourl", length = 1000)
    private String seoUrl;

    @Column(name = "hotpost")
    private String hotPost;

    @Column(name = "slideconfiguration")
    private String slideConfiguration;

    @Column(name = "slideconfigurationnumber")
    private Integer slideConfigurationNumber;

    @Column(name = "menuconfiguration")
    private String menuConfiguration;

    @Column(name = "menuconfigurationnumber")
    private Integer menuConfigurationNumber;

    @Column(name = "blogconfiguration")
    private String blogConfiguration;

    @Column(name = "tomails", columnDefinition = "TEXT")
    private String toMails;

    @Column(name = "shorturl", unique = true)
    private String shortUrl;

    @Column(name = "redirecturl")
    private String redirectUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

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

    public String getOgImage() {
        return ogImage;
    }

    public void setOgImage(String ogImage) {
        this.ogImage = ogImage;
    }

    public String getSeoUrl() {
        return seoUrl;
    }

    public void setSeoUrl(String seoUrl) {
        this.seoUrl = seoUrl;
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
