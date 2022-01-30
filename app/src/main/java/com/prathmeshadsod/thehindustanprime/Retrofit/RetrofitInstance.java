package com.prathmeshadsod.thehindustanprime.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;

    private static final String base_url = "https://newsdata.io/api/1/";

    public static Retrofit getRetrofit() {

        if(retrofit == null) {
          retrofit = new Retrofit.Builder().baseUrl(base_url)
                     .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }


}
