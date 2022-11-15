package com.example.pro1121_cp17312_nhom8_quanlycafe.model;

public class LoaiMon {
    int MaLoai;
    String TenLoai;
    byte[] HinhAnh;

    public LoaiMon(int maLoai, String tenLoai, byte[] hinhAnh) {
        MaLoai = maLoai;
        TenLoai = tenLoai;
        HinhAnh = hinhAnh;
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

    public byte[] getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        HinhAnh = hinhAnh;
    }
}
