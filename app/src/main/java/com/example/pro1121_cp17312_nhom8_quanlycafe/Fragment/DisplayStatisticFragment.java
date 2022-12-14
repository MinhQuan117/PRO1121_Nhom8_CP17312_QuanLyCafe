package com.example.pro1121_cp17312_nhom8_quanlycafe.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.pro1121_cp17312_nhom8_quanlycafe.Activities.DetailStatisticActivity;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Adapter.AdapterDisplayStatistic;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DAO.DonDatDAO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.DonDatDTO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.MainActivity;
import com.example.pro1121_cp17312_nhom8_quanlycafe.R;


import java.util.List;

public class DisplayStatisticFragment extends Fragment {

    ListView lvStatistic;
    List<DonDatDTO> donDatDTOS;
    DonDatDAO donDatDAO;
    AdapterDisplayStatistic adapterDisplayStatistic;
    FragmentManager fragmentManager;
    int madon, makh, maban;
    String ngaydat, tongtien, tenkhachhang;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.displaystatistic_layout,container,false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Đơn Trong Ngày");
        setHasOptionsMenu(true);

        lvStatistic = (ListView)view.findViewById(R.id.lvStatistic);
        donDatDAO = new DonDatDAO(getActivity());

        donDatDTOS = donDatDAO.LayDSDonDat();
        adapterDisplayStatistic = new AdapterDisplayStatistic(getActivity(),R.layout.custom_layout_displaystatistic,donDatDTOS);
        lvStatistic.setAdapter(adapterDisplayStatistic);
        adapterDisplayStatistic.notifyDataSetChanged();

        lvStatistic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                madon = donDatDTOS.get(position).getMaDonDat();
                makh = donDatDTOS.get(position).getMaKH();
                maban = donDatDTOS.get(position).getMaBan();
                ngaydat = donDatDTOS.get(position).getNgayDat();
                tongtien = donDatDTOS.get(position).getTongTien();
                tenkhachhang = donDatDTOS.get(position).getTenkhachhang();

                Intent intent = new Intent(getActivity(), DetailStatisticActivity.class);
                intent.putExtra("madon",madon);
                intent.putExtra("makh",makh);
                intent.putExtra("maban",maban);
                intent.putExtra("ngaydat",ngaydat);
                intent.putExtra("tongtien",tongtien);
                intent.putExtra("tenkhachhang", tenkhachhang);
                startActivity(intent);
            }
        });

        return view;
    }
}
