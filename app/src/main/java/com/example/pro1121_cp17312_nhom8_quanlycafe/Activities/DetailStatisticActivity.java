package com.example.pro1121_cp17312_nhom8_quanlycafe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pro1121_cp17312_nhom8_quanlycafe.Adapter.AdapterDisplayPayment;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DAO.BanAnDAO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DAO.KhachHangDAO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DAO.NhanVienDAO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DAO.ThanhToanDAO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.KhachHangDTO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.NhanVienDTO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.ThanhToanDTO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.R;


import java.util.List;

public class DetailStatisticActivity extends AppCompatActivity {

    ImageView img_detailstatistic_backbtn;
    TextView txt_detailstatistic_MaDon,txt_detailstatistic_NgayDat,txt_detailstatistic_TenBan
            ,txt_detailstatistic_TenKH,txt_detailstatistic_TongTien;
    GridView gvDetailStatistic;
    int madon, makh, maban;
    String ngaydat, tongtien, tenkhachhang;
    KhachHangDAO khachHangDAO;
    BanAnDAO banAnDAO;
    List<ThanhToanDTO> thanhToanDTOList;
    ThanhToanDAO thanhToanDAO;
    AdapterDisplayPayment adapterDisplayPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailstatistic_layout);

        Intent intent = getIntent();
        madon = intent.getIntExtra("madon",0);
        makh = intent.getIntExtra("makh",0);
        maban = intent.getIntExtra("maban",0);
        ngaydat = intent.getStringExtra("ngaydat");
        tongtien = intent.getStringExtra("tongtien");
        tenkhachhang = intent.getStringExtra("tenkhachhang");

        img_detailstatistic_backbtn = (ImageView)findViewById(R.id.img_detailstatistic_backbtn);
        txt_detailstatistic_MaDon = (TextView)findViewById(R.id.txt_detailstatistic_MaDon);
        txt_detailstatistic_NgayDat = (TextView)findViewById(R.id.txt_detailstatistic_NgayDat);
        txt_detailstatistic_TenBan = (TextView)findViewById(R.id.txt_detailstatistic_TenBan);
        txt_detailstatistic_TenKH = (TextView)findViewById(R.id.txt_detailstatistic_TenKH);
        txt_detailstatistic_TongTien = (TextView)findViewById(R.id.txt_detailstatistic_TongTien);
        gvDetailStatistic = (GridView)findViewById(R.id.gvDetailStatistic);

        khachHangDAO = new KhachHangDAO(this);
        banAnDAO = new BanAnDAO(this);
        thanhToanDAO = new ThanhToanDAO(this);

        if (madon !=0){
            txt_detailstatistic_MaDon.setText("M?? ????n: "+madon);
            txt_detailstatistic_NgayDat.setText(ngaydat);
            txt_detailstatistic_TongTien.setText(tongtien+" VN??");

            KhachHangDTO khachHangDTO = khachHangDAO.LayKHTheoMa(makh);
            txt_detailstatistic_TenKH.setText(khachHangDTO.getHOTENKH());
            txt_detailstatistic_TenBan.setText(banAnDAO.LayTenBanTheoMa(maban));

            HienThiDSCTDD();
        }

        img_detailstatistic_backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }

    private void HienThiDSCTDD(){
        thanhToanDTOList = thanhToanDAO.LayDSMonTheoMaDon(madon);
        adapterDisplayPayment = new AdapterDisplayPayment(this,R.layout.custom_layout_paymentmenu,thanhToanDTOList);
        gvDetailStatistic.setAdapter(adapterDisplayPayment);
        adapterDisplayPayment.notifyDataSetChanged();
    }
}