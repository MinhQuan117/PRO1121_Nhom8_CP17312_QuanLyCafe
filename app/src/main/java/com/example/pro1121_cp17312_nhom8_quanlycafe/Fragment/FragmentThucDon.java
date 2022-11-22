package com.example.pro1121_cp17312_nhom8_quanlycafe.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.pro1121_cp17312_nhom8_quanlycafe.Adapter.AdapterThucDon;
import com.example.pro1121_cp17312_nhom8_quanlycafe.MainActivity;
import com.example.pro1121_cp17312_nhom8_quanlycafe.R;
import com.example.pro1121_cp17312_nhom8_quanlycafe.model.LoaiMon;

import java.util.ArrayList;

public class FragmentThucDon extends Fragment {
    private ArrayList<LoaiMon> list = new ArrayList<>();
    private AdapterThucDon adapterThucDon;
    private MainActivity mainActivity;
    ListView lvThucDon;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_thucdon,container,false);
        lvThucDon = view.findViewById(R.id.lvStatistic);
        list= new ArrayList<>();
        list.add(new LoaiMon(0,"các loại đồ uống",R.drawable.img_anh_ca_phe_thucdon));
        mainActivity = (MainActivity) getActivity();
//        lvThucDon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Intent intent = new Intent(getContext(),FragmentLoaiDoUong.class);
////                startActivity(intent);
//                mainActivity.gotoFragmentLoaiDoUong();
//            }
//        });
        Show(list);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public void Show(ArrayList<LoaiMon> list){
        adapterThucDon = new AdapterThucDon(getContext(), list, new AdapterThucDon.OnclickItem() {
            @Override
            public void OnclickLoaiMon(LoaiMon loaiMon) {
                mainActivity.gotoFragmentLoaiDoUong(loaiMon);
            }
        });
        lvThucDon.setAdapter(adapterThucDon);
    }


}
