package com.ptp.phamtanphat.quanlynhahangretrofit2.Service;

import com.ptp.phamtanphat.quanlynhahangretrofit2.Model.Monan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitAPI {

    //Truyền url còn lại từ góc nhìn baseurl
    //Tạo request method
    @GET("getdata.php")
    Call<List<Monan>> getMonan();
//    http://localhost/Quanlynhahang/delete.php?id=1
//    @GET("delete.php?id=&ten")
//    Call<String> onDelete(@Query("id")String id,@Query("ten"));
//    @GET("nhahang/{a}/hinhanh.php")
//    Call<String> onChange(@Path());

    @FormUrlEncoded
    @POST("delete.php")
    Call<String> ondelete(@Field("id") String id);
}
