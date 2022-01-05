package com.example.mymovie.repository.models;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YtsService {

    @GET("list_movies.json")
    Call<YtsData> repoContributors(
            @Query("sort_by") String sort_by,
            @Query("limit") int limit,
            @Query("page") int page
    );

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://yts.mx/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
