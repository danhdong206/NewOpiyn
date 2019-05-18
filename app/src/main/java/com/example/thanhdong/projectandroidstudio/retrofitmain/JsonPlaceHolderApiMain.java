package com.example.thanhdong.projectandroidstudio.retrofitmain;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApiMain {
    @GET("api/v1/feeds/highlights")
    Call<Highlights> getHighlights();

    @GET("api/v1/page-categories")
    Call<Categories> getCategories();
}
