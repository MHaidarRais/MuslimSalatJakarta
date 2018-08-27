package com.rais.haidar.muslimsalatjakarta.ApiRetrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Hoidar on 8/27/18.
 */

public class InstanceRetrofit {
    public static final String WebUrl = "http://muslimsalat.com/";

    public static Retrofit setInit() {
        return new Retrofit.Builder()
                .baseUrl(WebUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static ApiService getInstance() {
        return setInit().create(ApiService.class);
    }
}
