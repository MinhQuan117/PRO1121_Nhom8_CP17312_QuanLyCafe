package com.example.pro1121_cp17312_nhom8_quanlycafe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ManHinhChoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_cho);

        ImageView ivLogo = findViewById(R.id.ivLogo);

        Glide.with(this).load(R.drawable.loadingicon).into(ivLogo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ManHinhChoActivity.this, DangNhapActivity.class));
            }
        },4000);
    }
}