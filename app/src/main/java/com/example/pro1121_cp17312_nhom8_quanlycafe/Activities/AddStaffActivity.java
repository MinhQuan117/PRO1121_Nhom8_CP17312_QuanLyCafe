package com.example.pro1121_cp17312_nhom8_quanlycafe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pro1121_cp17312_nhom8_quanlycafe.DAO.NhanVienDAO;
import com.google.android.material.textfield.TextInputLayout;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.NhanVienDTO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.R;

import java.util.Calendar;
import java.util.regex.Pattern;

public class AddStaffActivity extends AppCompatActivity implements View.OnClickListener {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{6,}" +
                    "$");

    ImageView IMG_addstaff_back;
    TextView TXT_addstaff_title;
    TextInputLayout TXTL_addstaff_HoVaTen, TXTL_addstaff_TenDN, TXTL_addstaff_Email, TXTL_addstaff_SDT, TXTL_addstaff_MatKhau;
    RadioGroup RG_addstaff_GioiTinh, rg_addstaff_Quyen;
    RadioButton RD_addstaff_Nam, RD_addstaff_Nu, RD_addstaff_Khac, rd_addstaff_QuanLy, rd_addstaff_NhanVien;
    DatePicker DT_addstaff_NgaySinh;
    Button BTN_addstaff_ThemNV;
    NhanVienDAO nhanVienDAO;
    String hoTen, tenDN, eMail, sDT, matKhau, gioiTinh, ngaySinh;
    int manv = 0, quyen = 0;
    long ktra = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstaff_layout);

        TXT_addstaff_title = (TextView) findViewById(R.id.txt_addstaff_title);
        IMG_addstaff_back = (ImageView) findViewById(R.id.img_addstaff_back);
        TXTL_addstaff_HoVaTen = (TextInputLayout) findViewById(R.id.txtl_addstaff_HoVaTen);
        TXTL_addstaff_TenDN = (TextInputLayout) findViewById(R.id.txtl_addstaff_TenDN);
        TXTL_addstaff_Email = (TextInputLayout) findViewById(R.id.txtl_addstaff_Email);
        TXTL_addstaff_SDT = (TextInputLayout) findViewById(R.id.txtl_addstaff_SDT);
        TXTL_addstaff_MatKhau = (TextInputLayout) findViewById(R.id.txtl_addstaff_MatKhau);
        RG_addstaff_GioiTinh = (RadioGroup) findViewById(R.id.rg_addstaff_GioiTinh);
        rg_addstaff_Quyen = (RadioGroup) findViewById(R.id.rg_addstaff_Quyen);
        RD_addstaff_Nam = (RadioButton) findViewById(R.id.rd_addstaff_Nam);
        RD_addstaff_Nu = (RadioButton) findViewById(R.id.rd_addstaff_Nu);
        RD_addstaff_Khac = (RadioButton) findViewById(R.id.rd_addstaff_Khac);
        rd_addstaff_QuanLy = (RadioButton) findViewById(R.id.rd_addstaff_QuanLy);
        rd_addstaff_NhanVien = (RadioButton) findViewById(R.id.rd_addstaff_NhanVien);
        DT_addstaff_NgaySinh = (DatePicker) findViewById(R.id.dt_addstaff_NgaySinh);
        BTN_addstaff_ThemNV = (Button) findViewById(R.id.btn_addstaff_ThemNV);


        nhanVienDAO = new NhanVienDAO(this);

        manv = getIntent().getIntExtra("manv", 0);
        if (manv != 0) {
            TXT_addstaff_title.setText("Sửa nhân viên");
            NhanVienDTO nhanVienDTO = nhanVienDAO.LayNVTheoMa(manv);

            TXTL_addstaff_HoVaTen.getEditText().setText(nhanVienDTO.getHOTENNV());
            TXTL_addstaff_TenDN.getEditText().setText(nhanVienDTO.getTENDN());
            TXTL_addstaff_Email.getEditText().setText(nhanVienDTO.getEMAIL());
            TXTL_addstaff_SDT.getEditText().setText(nhanVienDTO.getSDT());
            TXTL_addstaff_MatKhau.getEditText().setText(nhanVienDTO.getMATKHAU());

            String gioitinh = nhanVienDTO.getGIOITINH();
            if (gioitinh.equals("Nam")) {
                RD_addstaff_Nam.setChecked(true);
            } else if (gioitinh.equals("Nữ")) {
                RD_addstaff_Nu.setChecked(true);
            } else {
                RD_addstaff_Khac.setChecked(true);
            }

            if (nhanVienDTO.getMAQUYEN() == 1) {
                rd_addstaff_QuanLy.setChecked(true);
            } else {
                rd_addstaff_NhanVien.setChecked(true);
            }

            String date = nhanVienDTO.getNGAYSINH();
            String[] items = date.split("/");
            int day = Integer.parseInt(items[0]);
            int month = Integer.parseInt(items[1]) - 1;
            int year = Integer.parseInt(items[2]);
            DT_addstaff_NgaySinh.updateDate(year, month, day);
            BTN_addstaff_ThemNV.setText("Sửa nhân viên");
        }

        BTN_addstaff_ThemNV.setOnClickListener(this);
        IMG_addstaff_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}