package com.ptp.phamtanphat.quanlynhahangretrofit2.Service;

public class RetrofitData {
    //Chỉ có localhost không thể phân giải ra địa chỉ ip còn server online thì được
    //Địa chỉ ip sẽ bị thay đổi theo mạng
    private static final String baseurl = "http://192.168.1.14/Quanlynhahang/";

    public static RetrofitAPI getData(){
        //Khởi tạo retrofit và truyền request len cho server
        return RetrofitInit.getRetrofit(baseurl).create(RetrofitAPI.class);
    }
}
