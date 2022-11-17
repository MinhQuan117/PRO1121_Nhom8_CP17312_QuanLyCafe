package com.example.pro1121_cp17312_nhom8_quanlycafe.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pro1121_cp17312_nhom8_quanlycafe.R;
import com.example.pro1121_cp17312_nhom8_quanlycafe.model.Cagetory;

import java.util.ArrayList;
import java.util.List;

public class AdapterThucDon extends RecyclerView.Adapter<AdapterThucDon.ViewHolder> {
    private Context context;
    private ArrayList<Cagetory> list;

    public AdapterThucDon(Context context, ArrayList<Cagetory> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_recyclerview_menu,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cagetory cagetory = list.get(position);
        holder.tvLoaiThucUong.setText(cagetory.getTenLoai());
        holder.imgCaPheMenu.setImageResource(cagetory.getHinhAnh());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCaPheMenu;
        private TextView tvLoaiThucUong;

        public ViewHolder(View view) {
            super(view);
            imgCaPheMenu = view.findViewById(R.id.imgCaPheMenu);
            tvLoaiThucUong = view.findViewById(R.id.tvLoaiThucUong);
        }

    }
}
