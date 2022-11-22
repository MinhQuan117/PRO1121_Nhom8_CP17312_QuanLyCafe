package com.example.pro1121_cp17312_nhom8_quanlycafe.model;

public class Mon {
    int MaMon, MaLoai;
    String TenMon,GiaTien,TinhTrang;
    int HinhAnh;

    public Mon(int maMon, int maLoai, String tenMon, String giaTien, String tinhTrang, int hinhAnh) {
        MaMon = maMon;
        MaLoai = maLoai;
        TenMon = tenMon;
        GiaTien = giaTien;
        TinhTrang = tinhTrang;
        HinhAnh = hinhAnh;
    }

    public int getMaMon() {
        return MaMon;
    }

    public void setMaMon(int maMon) {
        MaMon = maMon;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int maLoai) {
        MaLoai = maLoai;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String tenMon) {
        TenMon = tenMon;
    }

    public String getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(String giaTien) {
        GiaTien = giaTien;
    }
    public String getTinhTrang() {
        return TinhTrang;
    }
    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }
}
