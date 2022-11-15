package com.example.pro1121_cp17312_nhom8_quanlycafe.model;

public class DonDat {
    int MaDonDat,MaBan ,MaNV;
    String TinhTrang,NgayDat,TongTien;

    public DonDat(int maDonDat, int maBan, int maNV, String tinhTrang, String ngayDat, String tongTien) {
        MaDonDat = maDonDat;
        MaBan = maBan;
        MaNV = maNV;
        TinhTrang = tinhTrang;
        NgayDat = ngayDat;
        TongTien = tongTien;
    }

    public int getMaDonDat() {
        return MaDonDat;
    }

    public void setMaDonDat(int maDonDat) {
        MaDonDat = maDonDat;
    }

    public int getMaBan() {
        return MaBan;
    }

    public void setMaBan(int maBan) {
        MaBan = maBan;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int maNV) {
        MaNV = maNV;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
    }

    public String getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(String ngayDat) {
        NgayDat = ngayDat;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String tongTien) {
        TongTien = tongTien;
    }
}
