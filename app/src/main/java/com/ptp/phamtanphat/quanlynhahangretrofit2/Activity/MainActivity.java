package com.ptp.phamtanphat.quanlynhahangretrofit2.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.ptp.phamtanphat.quanlynhahangretrofit2.Adapter.MonanAdapter;
import com.ptp.phamtanphat.quanlynhahangretrofit2.Model.Monan;
import com.ptp.phamtanphat.quanlynhahangretrofit2.R;
import com.ptp.phamtanphat.quanlynhahangretrofit2.Service.RetrofitAPI;
import com.ptp.phamtanphat.quanlynhahangretrofit2.Service.RetrofitData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

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
            public void onResponse(Call<List<Monan>> call, Response<List<Monan>> resposne) {
                mangmonan = (ArrayList<Monan>) resposne.body();
                monanAdapter = new MonanAdapter(MainActivity.this,android.R.layout.simple_list_item_1,mangmonan);
                lvMonan.setAdapter(monanAdapter);
            }

            @Override
            public void onFailure(Call<List<Monan>> call, Throwable t) {

            }
        });

    }
}
