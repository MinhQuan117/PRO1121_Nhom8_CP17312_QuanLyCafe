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
import com.example.pro1121_cp17312_nhom8_quanlycafe.model.LoaiMon;

import java.util.ArrayList;

public class AdapterThucDon extends BaseAdapter {
    private Context context;
    private ArrayList<LoaiMon> list;
    private OnclickItem onclickItem;

    public AdapterThucDon(Context context, ArrayList<LoaiMon> list,OnclickItem onclickItem) {
        this.context = context;
        this.list = list;
        this.onclickItem = onclickItem;
    }



    public interface OnclickItem{
        void OnclickLoaiMon(LoaiMon loaiMon);
    }

//    public void setData(ArrayList<LoaiMon> list){
//        this.list = list;
//        notifyDataSetChanged();
//    }

    public final class ViewHolder{
        private ImageView imgAnhThucDon;
        private TextView tvCacLoaiDoUong;
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
        final LoaiMon loaiMon = list.get(position);
        ViewHolder holder = null;
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        if(convertView==null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_listview_thuc_don,null);
            holder.tvCacLoaiDoUong = convertView.findViewById(R.id.tvCacLoaiDoUong);
            holder.imgAnhThucDon = convertView.findViewById(R.id.imgAnhThucDon);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvCacLoaiDoUong.setText(list.get(position).getTenLoai());
        holder.imgAnhThucDon.setImageResource(list.get(position).getHinhAnh());
        holder.imgAnhThucDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickItem.OnclickLoaiMon(loaiMon);
            }
        });
        return convertView;
    }
}
