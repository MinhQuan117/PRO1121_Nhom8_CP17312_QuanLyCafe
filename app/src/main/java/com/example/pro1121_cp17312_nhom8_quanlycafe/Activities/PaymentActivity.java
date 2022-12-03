package com.example.pro1121_cp17312_nhom8_quanlycafe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.pro1121_cp17312_nhom8_quanlycafe.Adapter.AdapterDisplayPayment;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Adapter.AdapterDisplayStatistic;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DAO.BanAnDAO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DAO.DonDatDAO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DAO.KhachHangDAO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DAO.ThanhToanDAO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.KhachHangDTO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.ThanhToanDTO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Fragment.DisplayStatisticFragment;
import com.example.pro1121_cp17312_nhom8_quanlycafe.R;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {
    CheckBox ChkisVIP;

    ImageView IMG_payment_backbtn;
    TextView TXT_payment_TenBan, TXT_payment_NgayDat, TXT_payment_TongTien;
    Button BTN_payment_ThanhToan;
    GridView gvDisplayPayment;
    DonDatDAO donDatDAO;
    BanAnDAO banAnDAO;
    ThanhToanDAO thanhToanDAO;
    List<ThanhToanDTO> thanhToanDTOS;
    AdapterDisplayPayment adapterDisplayPayment;
    long tongtien = 0;
    int maban, madondat;
    FragmentManager fragmentManager;
    Spinner spinnerKhachHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_layout);

        gvDisplayPayment= (GridView)findViewById(R.id.gvDisplayPayment);
        IMG_payment_backbtn = (ImageView)findViewById(R.id.img_payment_backbtn);
        TXT_payment_TenBan = (TextView)findViewById(R.id.txt_payment_TenBan);
        TXT_payment_NgayDat = (TextView)findViewById(R.id.txt_payment_NgayDat);
        TXT_payment_TongTien = (TextView)findViewById(R.id.txt_payment_TongTien);
        BTN_payment_ThanhToan = (Button)findViewById(R.id.btn_payment_ThanhToan);
        ChkisVIP = (CheckBox) findViewById(R.id.ChkVip);
        spinnerKhachHang = findViewById(R.id.SpinnerKhachHang);

        donDatDAO = new DonDatDAO(this);
        thanhToanDAO = new ThanhToanDAO(this);
        banAnDAO = new BanAnDAO(this);

        fragmentManager = getSupportFragmentManager();

        Intent intent = getIntent();
        maban = intent.getIntExtra("maban",0);
        String tenban = intent.getStringExtra("tenban");
        String ngaydat = intent.getStringExtra("ngaydat");

        TXT_payment_TenBan.setText(tenban);
        TXT_payment_NgayDat.setText(ngaydat);

        KhachHangDAO khachHangDAO = new KhachHangDAO(PaymentActivity.this);
        Bundle bundle = getIntent().getExtras();

        ArrayList<KhachHangDTO> list = (ArrayList<KhachHangDTO>) khachHangDAO.LayDSKH();
        ArrayList<HashMap<String,String>> listSPN = new ArrayList<>();

        for(KhachHangDTO khachHangDTO : list){
            HashMap<String,String> hashMap = new HashMap<>();

            hashMap.put("tenKH",khachHangDTO.getHOTENKH());

            listSPN.add(hashMap);
        }
        SimpleAdapter adapter = new SimpleAdapter(PaymentActivity.this,
                listSPN,
                R.layout.item_spinnerkh,
                new String[]{"tenKH"},
                new int[]{R.id.txtTenKH});
        spinnerKhachHang.setAdapter(adapter);
        spinnerKhachHang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        if(maban !=0 ){
            HienThiThanhToan();


            for (int i=0;i<thanhToanDTOS.size();i++) {
                int soluong = thanhToanDTOS.get(i).getSoLuong();
                String ghichu = thanhToanDTOS.get(i).getGhiChu();
                int giatien = thanhToanDTOS.get(i).getGiaTien();
                tongtien = (soluong * giatien);

                ChkisVIP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        if (ChkisVIP.isChecked()) {
                            tongtien = (long) (tongtien * 0.9);
                            TXT_payment_TongTien.setText(String.valueOf(tongtien) +" VNĐ");
                        } else {
                            tongtien = (soluong*giatien);
                            TXT_payment_TongTien.setText(String.valueOf(tongtien) +" VNĐ");
                        }
                    }

                });
            }
            TXT_payment_TongTien.setText("chưa đặt đồ");

        }

        BTN_payment_ThanhToan.setOnClickListener(this);
        IMG_payment_backbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_payment_ThanhToan:
                boolean ktraban = banAnDAO.CapNhatTinhTrangBan(maban,"false");
                boolean ktradondat = donDatDAO.UpdateTThaiDonTheoMaBan(maban,"true");
                boolean ktratongtien = donDatDAO.UpdateTongTienDonDat(madondat,String.valueOf(tongtien));
                if(ktraban && ktradondat && ktratongtien){
                    HienThiThanhToan();
                    TXT_payment_TongTien.setText("0 VNĐ");
                    Toast.makeText(getApplicationContext(),"Thanh toán thành công!",Toast.LENGTH_SHORT);
                }else{
                    Toast.makeText(getApplicationContext(),"Lỗi thanh toán!",Toast.LENGTH_SHORT);
                }
                break;

            case R.id.img_payment_backbtn:
                finish();
                break;
        }
    }

    //hiển thị data lên gridview
    private void HienThiThanhToan(){
        madondat = (int) donDatDAO.LayMaDonTheoMaBan(maban,"false");
        thanhToanDTOS = thanhToanDAO.LayDSMonTheoMaDon(madondat);
        adapterDisplayPayment = new AdapterDisplayPayment(this,R.layout.custom_layout_paymentmenu,thanhToanDTOS);
        gvDisplayPayment.setAdapter(adapterDisplayPayment);
        adapterDisplayPayment.notifyDataSetChanged();
    }
}