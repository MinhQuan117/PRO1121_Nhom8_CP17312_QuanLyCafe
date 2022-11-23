package com.example.pro1121_cp17312_nhom8_quanlycafe.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pro1121_cp17312_nhom8_quanlycafe.R;

public class FragmentBan extends Fragment {
    ImageView img_customtable_GoiMon;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment_ban, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        img_customtable_GoiMon = view.findViewById(R.id.img_customtable_GoiMon);

        img_customtable_GoiMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentThucDon fragmentThucDon = new FragmentThucDon();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, fragmentThucDon, null).commit();
            }
        });
    }
}