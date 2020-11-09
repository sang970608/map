package com.example.map.data;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface SearchInterface {
    @GET("v2/local/search/keyword.json")
    Call<SearchItem> getSearch(
                               @Header("Authorization") String key,
                               @Query("query") String query,
                               @Query("x") Double latitude,
                               @Query("y") Double longitude,
                               @Query("radius") int radius);
}

