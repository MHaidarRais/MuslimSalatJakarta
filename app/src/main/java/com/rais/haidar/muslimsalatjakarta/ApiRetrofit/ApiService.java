package com.rais.haidar.muslimsalatjakarta.ApiRetrofit;

import com.rais.haidar.muslimsalatjakarta.ResponseServer.Response;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hoidar on 8/27/18.
 */

public interface ApiService {
    @GET("jakarta.json?key=7f4a49bbadddcd34a3bc717539cb083a")
    Call<Response> readJadwalSholat();
}
