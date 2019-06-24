package com.example.thanhdong.projectandroidstudio.retrofitmain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Highlights {
    @SerializedName("highlights")
    private List<Highlight> highlights;

    public Highlights(List<Highlight> highlights) {
        this.highlights = highlights;
    }

    public List<Highlight> getHighlights() {
        return highlights;
    }

    public void setHighlights(List<Highlight> highlights) {
        this.highlights = highlights;
    }
}
