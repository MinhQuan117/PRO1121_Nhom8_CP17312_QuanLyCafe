package com.example.pro1121_cp17312_nhom8_quanlycafe.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;


import com.example.pro1121_cp17312_nhom8_quanlycafe.Adapter.AdapterTop;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DAO.DonDatDAO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DAO.topDAO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.top;
import com.example.pro1121_cp17312_nhom8_quanlycafe.R;

import java.util.ArrayList;


public class FrmTop extends Fragment {

    ListView listView;
    ArrayList<top> listTop;
    AdapterTop adapterTop;

    public FrmTop() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_frm_top, container, false);
        listView = view.findViewById(R.id.lvTop);
        topDAO topDAO = new topDAO(getActivity());
        listTop = (ArrayList<top>)topDAO.getTop();
        adapterTop = new AdapterTop(getActivity() , this , listTop);
        listView.setAdapter(adapterTop);
        return view;
    }
}