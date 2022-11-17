package com.example.pro1121_cp17312_nhom8_quanlycafe.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.pro1121_cp17312_nhom8_quanlycafe.R;
import com.example.pro1121_cp17312_nhom8_quanlycafe.adapter.AdapterThucDon;
import com.example.pro1121_cp17312_nhom8_quanlycafe.model.Cagetory;

import java.util.ArrayList;
import java.util.List;

public class FragmentThucDon extends Fragment {
    private AdapterThucDon adapterThucDon;
    private RecyclerView recyclerView;
    private ArrayList<Cagetory> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_thuc_don, container, false);
        list = new ArrayList<>();
        recyclerView = view.findViewById(R.id.RecyclerViewMenu);
        list.add(new Cagetory(0,"các loại đồ uống",R.drawable.img_ca_phe_menu));
        loadData(list);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public void loadData(ArrayList<Cagetory> list){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapterThucDon = new AdapterThucDon(getContext(),list);
        recyclerView.setAdapter(adapterThucDon);
    }

}