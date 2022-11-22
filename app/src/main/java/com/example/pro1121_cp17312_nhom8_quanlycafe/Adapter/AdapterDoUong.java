package com.example.pro1121_cp17312_nhom8_quanlycafe.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pro1121_cp17312_nhom8_quanlycafe.R;
import com.example.pro1121_cp17312_nhom8_quanlycafe.model.Mon;

import java.util.ArrayList;

public class AdapterDoUong extends BaseAdapter {
    private Context context;
    private ArrayList<Mon> list;


    public AdapterDoUong(Context context, ArrayList<Mon> list) {
        this.context = context;
        this.list = list;
    }

    public final class ViewHolderDoUong{
        private ImageView imgDoUong;
        private TextView tvTenMon,tvGiaTien,tvTinhTrang;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderDoUong holderDoUong = null;
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        if(convertView==null){
            holderDoUong = new ViewHolderDoUong();
            convertView= inflater.inflate(R.layout.item_listview_mon,null);
            holderDoUong.imgDoUong = convertView.findViewById(R.id.imgDoUong);
            holderDoUong.tvGiaTien = convertView.findViewById(R.id.tvGiaTienDoUong);
            holderDoUong.tvTenMon= convertView.findViewById(R.id.tvTenDoUong);
            holderDoUong.tvTinhTrang = convertView.findViewById(R.id.tvTinhTrangDoUong);
            convertView.setTag(holderDoUong);

        }
        else {
            holderDoUong= (ViewHolderDoUong) convertView.getTag();
        }
        holderDoUong.imgDoUong.setImageResource(list.get(position).getHinhAnh());
        holderDoUong.tvTinhTrang.setText(list.get(position).getTinhTrang());
        holderDoUong.tvGiaTien.setText(list.get(position).getGiaTien());
        holderDoUong.tvTenMon.setText(list.get(position).getTenMon());


        return convertView;
    }
}
