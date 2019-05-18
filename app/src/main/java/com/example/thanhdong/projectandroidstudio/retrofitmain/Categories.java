package com.example.thanhdong.projectandroidstudio.retrofitmain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Categories {
    @SerializedName("page_categories")
    private List<Category> categories;

    public Categories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
