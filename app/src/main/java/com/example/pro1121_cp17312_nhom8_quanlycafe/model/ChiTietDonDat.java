package com.example.pro1121_cp17312_nhom8_quanlycafe.model;

public class ChiTietDonDat {
    int MaDonDat, MaMon, SoLuong;

    public ChiTietDonDat(int maDonDat, int maMon, int soLuong) {
        MaDonDat = maDonDat;
        MaMon = maMon;
        SoLuong = soLuong;
    }

    public int getMaDonDat() {
        return MaDonDat;
    }

    public void setMaDonDat(int maDonDat) {
        MaDonDat = maDonDat;
    }

    public int getMaMon() {
        return MaMon;
    }

    public void setMaMon(int maMon) {
        MaMon = maMon;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
}
