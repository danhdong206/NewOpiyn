package com.example.thanhdong.projectandroidstudio.retrofitmain;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("slug")
    private String slug;
    @SerializedName("i18n_name")
    private String i18NName;
    @SerializedName("i18n_slug")
    private String i18NSlug;
    @SerializedName("image_url")
    private String imageURL;
    @SerializedName("placeholder")
    private boolean placeHolder;

    public Category(String id, String name, String slug, String i18NName, String i18NSlug, String imageURL, boolean placeHolder) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.i18NName = i18NName;
        this.i18NSlug = i18NSlug;
        this.imageURL = imageURL;
        this.placeHolder = placeHolder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getI18NName() {
        return i18NName;
    }

    public void setI18NName(String i18NName) {
        this.i18NName = i18NName;
    }

    public String getI18NSlug() {
        return i18NSlug;
    }

    public void setI18NSlug(String i18NSlug) {
        this.i18NSlug = i18NSlug;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(boolean placeHolder) {
        this.placeHolder = placeHolder;
    }
}
