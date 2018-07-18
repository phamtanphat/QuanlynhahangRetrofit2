package com.ptp.phamtanphat.quanlynhahangretrofit2;

import com.ptp.phamtanphat.quanlynhahangretrofit2.Model.Monan;

import java.util.List;

public interface ListenData {
    void DataOnResponse(List<Monan> mangmonan);
    void Fail(Throwable t);
}
