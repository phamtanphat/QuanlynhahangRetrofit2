package com.ptp.phamtanphat.quanlynhahangretrofit2.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ptp.phamtanphat.quanlynhahangretrofit2.Adapter.MonanAdapter;
import com.ptp.phamtanphat.quanlynhahangretrofit2.Model.Monan;
import com.ptp.phamtanphat.quanlynhahangretrofit2.R;
import com.ptp.phamtanphat.quanlynhahangretrofit2.Service.RetrofitAPI;
import com.ptp.phamtanphat.quanlynhahangretrofit2.Service.RetrofitData;
import com.ptp.phamtanphat.quanlynhahangretrofit2.Service.RetrofitInit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    ListView lvMonan;
    MonanAdapter monanAdapter;
    ArrayList<Monan> mangmonan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonan = findViewById(R.id.listview);

        RetrofitAPI retrofitAPI = RetrofitData.getData();
        Call<List<Monan>> callback = retrofitAPI.getMonan();
        callback.enqueue(new Callback<List<Monan>>() {
            @Override
            public void onResponse(Call<List<Monan>> call, Response<List<Monan>> resposne){
                mangmonan = (ArrayList<Monan>) resposne.body();
                monanAdapter = new MonanAdapter(MainActivity.this,android.R.layout.simple_list_item_1,mangmonan);
                lvMonan.setAdapter(monanAdapter);
            }

            @Override
            public void onFailure(Call<List<Monan>> call, Throwable t) {

            }
        });
        lvMonan.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                RetrofitAPI retrofitAPI1 = RetrofitData.getData();
                Call<String> callback = retrofitAPI1.ondelete(mangmonan.get(position).getId());
                callback.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String ketqua = (response.body().equals("Success")) ? "Thanh cong" : "That bai";
                        Toast.makeText(MainActivity.this, ketqua, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
                return true;
            }
        });
    }
}
