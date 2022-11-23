package com.example.pro1121_cp17312_nhom8_quanlycafe.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pro1121_cp17312_nhom8_quanlycafe.R;

public class FragmentTrangChu extends Fragment {
    TextView txt_displayhome_ViewAllCategory, txt_displayhome_ViewAllStatistic;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment_trang_chu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txt_displayhome_ViewAllCategory = view.findViewById(R.id.txt_displayhome_ViewAllCategory);
        txt_displayhome_ViewAllStatistic = view.findViewById(R.id.txt_displayhome_ViewAllStatistic);

        txt_displayhome_ViewAllCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentThucDon fragmentThucDon = new FragmentThucDon();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, fragmentThucDon, null).commit();
            }
        });

        txt_displayhome_ViewAllStatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHoaDon fragmentHoaDon = new FragmentHoaDon();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, fragmentHoaDon, null).commit();
            }
        });
    }
}