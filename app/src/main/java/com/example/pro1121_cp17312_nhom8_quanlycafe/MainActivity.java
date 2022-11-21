package com.example.pro1121_cp17312_nhom8_quanlycafe;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.pro1121_cp17312_nhom8_quanlycafe.Fragment.FragmentBan;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Fragment.FragmentHoaDon;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Fragment.FragmentThongKe;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Fragment.FragmentThucDon;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Fragment.FragmentTrangChu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        FragmentTrangChu fragmentTrangChu = new FragmentTrangChu();
        FragmentHoaDon fragmentHoaDon = new FragmentHoaDon();
        FragmentThucDon fragmentThucDon = new FragmentThucDon();
        FragmentBan fragmentBan = new FragmentBan();
        FragmentThongKe fragmentThongKe = new FragmentThongKe();

        //mặc định vào màn hình sẽ hiển thị trong Fragment Trang Chủ
        fragmentManager.beginTransaction().add(R.id.container_fragment, fragmentTrangChu).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav01);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_trangChu:
                        fragmentManager.beginTransaction().replace(R.id.container_fragment, fragmentTrangChu).commit();
                        break;
                    case R.id.menu_thucDon:
                        fragmentManager.beginTransaction().replace(R.id.container_fragment, fragmentThucDon).commit();
                        break;
                    case R.id.menu_hoaDon:
                        fragmentManager.beginTransaction().replace(R.id.container_fragment, fragmentHoaDon).commit();
                        break;
                    case R.id.menu_Ban:
                        fragmentManager.beginTransaction().replace(R.id.container_fragment, fragmentBan).commit();
                        break;
                    case R.id.menu_thongKe:
                        fragmentManager.beginTransaction().replace(R.id.container_fragment, fragmentThongKe).commit();
                        break;
                }
                return true;
            }
        });
    }
}