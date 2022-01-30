package com.prathmeshadsod.thehindustanprime.Retrofit;

import com.prathmeshadsod.thehindustanprime.Models.ModelMain;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("news")

    Call<ModelMain> getCategoryNews(

                            /* Important for Authorization passed as Query apikey */
            @Query("apikey") String apikey,

                           /* Other Queries */
            @Query("category") String category,
            @Query("language") String language,
            @Query("country") String country

    );

    @GET("news")

    Call<ModelMain> getNews(
            /* Important for Authorization passed as Query apikey */
            @Query("apikey") String apikey,

           // Other Queries
            @Query("country") String country,
            @Query("language") String language



    );


    /*
    NewsData.io API is not giving access to us for there archives
       They wan't primium subscription for this that's why we created it but can't use it
     */

    @GET("archive")

    Call<ModelMain> getArchives(
            /* Important for Authorization passed as Query apikey */
            @Query("apikey") String apikey,

            /* Other Queries */
            @Query("country") String country,
            @Query("language") String language

    );

    /*
    For getting News of World we don't want to pass country  as parameter/query that's why we
    created special query to fetch new by world
     */

    @GET("news")
    Call<ModelMain> getWorld(
            @Query("apikey") String apikey,
            @Query("language") String language,
            @Query("category") String category

    );





}
