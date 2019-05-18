package com.example.thanhdong.projectandroidstudio.retrofitmain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Highlights {
    @SerializedName("highlights")
    private List<Highlight> highlights;
    private int totalPages = 0;
    private int totalResults = 0;
    private int page = 0;

    public Highlights(List<Highlight> highlights) {
        this.highlights = highlights;
    }

    public List<Highlight> getHighlights() {
        return highlights;
    }

    public void setHighlights(List<Highlight> highlights) {
        this.highlights = highlights;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
