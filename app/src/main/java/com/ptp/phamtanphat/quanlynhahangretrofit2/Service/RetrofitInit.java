package com.ptp.phamtanphat.quanlynhahangretrofit2.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class RetrofitInit {
    public static Retrofit retrofit = null;

    //Phương thức cấu hình retrofit
    public static Retrofit getRetrofit(String base_url){

        //Cấu hình những tương tác về internet
        OkHttpClient builder = new OkHttpClient.Builder()
                                .readTimeout(10, TimeUnit.SECONDS)
                                .writeTimeout(10,TimeUnit.SECONDS)
                                .connectTimeout(10,TimeUnit.SECONDS)
                                .retryOnConnectionFailure(true)
                                .build();
        //Bộ chuyển đổi gson
        Gson gson = new GsonBuilder().setLenient().create();

    }
}
