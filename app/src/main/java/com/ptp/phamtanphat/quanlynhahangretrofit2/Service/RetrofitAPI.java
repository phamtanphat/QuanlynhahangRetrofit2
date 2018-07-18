package com.ptp.phamtanphat.quanlynhahangretrofit2.Service;

import com.ptp.phamtanphat.quanlynhahangretrofit2.Model.Monan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {

    //Truyền url còn lại từ góc nhìn baseurl
    //Tạo request method
    @GET("getdata.php")
    Call<List<Monan>> getMonan();
}
