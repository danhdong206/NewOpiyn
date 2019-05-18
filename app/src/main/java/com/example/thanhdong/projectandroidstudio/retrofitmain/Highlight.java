package com.example.thanhdong.projectandroidstudio.retrofitmain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Highlight {
    @SerializedName("highlight_type")
    private String highlightType;
    @SerializedName("page_id")
    private String pageID;
    @SerializedName("page_url")
    private String pageURL;
    @SerializedName("page_title")
    private String pageTitle;
    @SerializedName("page_sub_title")
    private String pageSubTitle;
    @SerializedName("page_view_counts")
    private String pageViewCounts;
    @SerializedName("page_bookmarked")
    private boolean pageBookMarked;
    @SerializedName("page_web_url")
    private String pageWebURL;
    @SerializedName("page_slug")
    private String pageSlug;
    @SerializedName("page_image_url")
    private String pageImageURL;
    @SerializedName("page_image_width")
    private Integer pageImageWidth;
    @SerializedName("page_image_height")
    private Integer pageImageHeight;
    @SerializedName("page_image_aspect_ratio")
    private double pageImageAspectRatio;
    @SerializedName("page_address")
    private String pageAddress;
    @SerializedName("user_name")
    private String username;
    @SerializedName("user_image_url")
    private String userImageURL;
    @SerializedName("user_profile_url")
    private String userProfileURL;
    @SerializedName("opiyn_statement")
    private String opiynStatement;
    @SerializedName("statements")
    private List<Statements> statements;

    public Highlight(String highlightType, String pageID, String pageURL, String pageTitle, String pageSubTitle, String pageViewCounts, boolean pageBookMarked, String pageWebURL, String pageSlug, String pageImageURL, Integer pageImageWidth, Integer pageImageHeight, double pageImageAspectRatio, String pageAddress, String username, String userImageURL, String userProfileURL, String opiynStatement, List<Statements> statements) {
        this.highlightType = highlightType;
        this.pageID = pageID;
        this.pageURL = pageURL;
        this.pageTitle = pageTitle;
        this.pageSubTitle = pageSubTitle;
        this.pageViewCounts = pageViewCounts;
        this.pageBookMarked = pageBookMarked;
        this.pageWebURL = pageWebURL;
        this.pageSlug = pageSlug;
        this.pageImageURL = pageImageURL;
        this.pageImageWidth = pageImageWidth;
        this.pageImageHeight = pageImageHeight;
        this.pageImageAspectRatio = pageImageAspectRatio;
        this.pageAddress = pageAddress;
        this.username = username;
        this.userImageURL = userImageURL;
        this.userProfileURL = userProfileURL;
        this.opiynStatement = opiynStatement;
        this.statements = statements;
    }

    public String getHighlightType() {
        return highlightType;
    }

    public void setHighlightType(String highlightType) {
        this.highlightType = highlightType;
    }

    public String getPageID() {
        return pageID;
    }

    public void setPageID(String pageID) {
        this.pageID = pageID;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageSubTitle() {
        return pageSubTitle;
    }

    public void setPageSubTitle(String pageSubTitle) {
        this.pageSubTitle = pageSubTitle;
    }

    public String getPageViewCounts() {
        return pageViewCounts;
    }

    public void setPageViewCounts(String pageViewCounts) {
        this.pageViewCounts = pageViewCounts;
    }

    public boolean isPageBookMarked() {
        return pageBookMarked;
    }

    public void setPageBookMarked(boolean pageBookMarked) {
        this.pageBookMarked = pageBookMarked;
    }

    public String getPageWebURL() {
        return pageWebURL;
    }

    public void setPageWebURL(String pageWebURL) {
        this.pageWebURL = pageWebURL;
    }

    public String getPageSlug() {
        return pageSlug;
    }

    public void setPageSlug(String pageSlug) {
        this.pageSlug = pageSlug;
    }

    public String getPageImageURL() {
        return pageImageURL;
    }

    public void setPageImageURL(String pageImageURL) {
        this.pageImageURL = pageImageURL;
    }

    public Integer getPageImageWidth() {
        return pageImageWidth;
    }

    public void setPageImageWidth(Integer pageImageWidth) {
        this.pageImageWidth = pageImageWidth;
    }

    public Integer getPageImageHeight() {
        return pageImageHeight;
    }

    public void setPageImageHeight(Integer pageImageHeight) {
        this.pageImageHeight = pageImageHeight;
    }

    public double getPageImageAspectRatio() {
        return pageImageAspectRatio;
    }

    public void setPageImageAspectRatio(double pageImageAspectRatio) {
        this.pageImageAspectRatio = pageImageAspectRatio;
    }

    public String getPageAddress() {
        return pageAddress;
    }

    public void setPageAddress(String pageAddress) {
        this.pageAddress = pageAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }

    public String getUserProfileURL() {
        return userProfileURL;
    }

    public void setUserProfileURL(String userProfileURL) {
        this.userProfileURL = userProfileURL;
    }

    public String getOpiynStatement() {
        return opiynStatement;
    }

    public void setOpiynStatement(String opiynStatement) {
        this.opiynStatement = opiynStatement;
    }

    public List<Statements> getStatements() {
        return statements;
    }

    public void setStatements(List<Statements> statements) {
        this.statements = statements;
    }
}
