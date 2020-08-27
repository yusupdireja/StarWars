package com.example.startwarsapps.Rest;

import com.example.startwarsapps.Films.FilmModels;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("films/")
    Call<FilmModels> loadFilms();

    @GET("films")
    Call<FilmModels> searchFilms(@Query("episode_id")String episode_id);

}
