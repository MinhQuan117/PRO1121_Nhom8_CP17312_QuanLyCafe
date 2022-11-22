package com.example.pro1121_cp17312_nhom8_quanlycafe.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pro1121_cp17312_nhom8_quanlycafe.Adapter.AdapterDoUong;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Adapter.AdapterThucDon;
import com.example.pro1121_cp17312_nhom8_quanlycafe.R;
import com.example.pro1121_cp17312_nhom8_quanlycafe.model.LoaiMon;
import com.example.pro1121_cp17312_nhom8_quanlycafe.model.Mon;

import java.util.ArrayList;

public class FragmentLoaiDoUong extends Fragment {
    public static final String TAG = FragmentLoaiDoUong.class.getName();
    private ImageView imgBack;
    private ListView listView;
    private ArrayList<Mon> list;
    private AdapterDoUong adapterDoUong;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_cacloaidouong,container,false);
        imgBack = view.findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        listView = view.findViewById(R.id.lvLoaiDoUong);
        list = new ArrayList<>();
        list.add(new Mon(0,0,"cappuccino","40.000","còn hàng",R.drawable.img_capuccino));
        list.add(new Mon(1,0,"cà phê đen","20.000","còn hàng",R.drawable.img_ca_phe_den));
        list.add(new Mon(2,0,"cà phê sữa","15.000","còn hàng",R.drawable.img_ca_phe_sua));

        show(list);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public void show(ArrayList<Mon>list){
        adapterDoUong = new AdapterDoUong(getContext(),list);
        listView.setAdapter(adapterDoUong);
    }

}
