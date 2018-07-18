package com.ptp.phamtanphat.quanlynhahangretrofit2.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ptp.phamtanphat.quanlynhahangretrofit2.Model.Monan;
import com.ptp.phamtanphat.quanlynhahangretrofit2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MonanAdapter extends ArrayAdapter<Monan> {
    public MonanAdapter(@NonNull Context context, int resource, @NonNull List<Monan> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        ImageView imgmonan;
        TextView txttenmonan,txtgiamonan;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.dong_item_monan,null);
            viewHolder = new ViewHolder();
            viewHolder.imgmonan = convertView.findViewById(R.id.imageviewMonan);
            viewHolder.txttenmonan = convertView.findViewById(R.id.textviewTenmonan);
            viewHolder.txtgiamonan = convertView.findViewById(R.id.textviewGiamonan);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Monan monan = getItem(position);

        viewHolder.txttenmonan.setText(monan.getTenmonan());
        viewHolder.txtgiamonan.setText(monan.getGiamonan() + " Dong");
        Picasso.get().load(monan.getHinhanh()).into(viewHolder.imgmonan);
        return convertView;
    }
}
