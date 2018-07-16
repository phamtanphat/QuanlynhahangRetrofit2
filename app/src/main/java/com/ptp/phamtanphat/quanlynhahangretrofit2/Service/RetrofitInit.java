package com.ptp.phamtanphat.quanlynhahangretrofit2.Service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class RetrofitInit {
    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit(String base_url){
        OkHttpClient builder = new OkHttpClient.Builder()
                                .readTimeout(10, TimeUnit.SECONDS)
                                .writeTimeout(10,TimeUnit.SECONDS)
                                .connectTimeout(10,TimeUnit.SECONDS)
                                .retryOnConnectionFailure(true)
                                .build();



    }
}
