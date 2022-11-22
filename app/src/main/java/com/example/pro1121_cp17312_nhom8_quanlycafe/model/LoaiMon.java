package com.example.pro1121_cp17312_nhom8_quanlycafe.model;

public class LoaiMon {
    int MaLoai;
    String TenLoai;
    int HinhAnh;

    public LoaiMon(int maLoai, String tenLoai, int hinhAnh) {
        MaLoai = maLoai;
        TenLoai = tenLoai;
        HinhAnh = hinhAnh;
    }

    public LoaiMon() {
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int maLoai) {
        MaLoai = maLoai;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String tenLoai) {
        TenLoai = tenLoai;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }
}
