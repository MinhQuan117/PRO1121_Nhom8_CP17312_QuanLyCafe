package com.example.pro1121_cp17312_nhom8_quanlycafe.model;

public class NhanVien {
    String HOTENNV,TENDN,MATKHAU,EMAIL,SDT,GIOITINH,NGAYSINH;
    int MANV;

    public NhanVien(String HOTENNV, String TENDN, String MATKHAU, String EMAIL, String SDT, String GIOITINH, String NGAYSINH, int MANV) {
        this.HOTENNV = HOTENNV;
        this.TENDN = TENDN;
        this.MATKHAU = MATKHAU;
        this.EMAIL = EMAIL;
        this.SDT = SDT;
        this.GIOITINH = GIOITINH;
        this.NGAYSINH = NGAYSINH;
        this.MANV = MANV;
    }

    public String getHOTENNV() {
        return HOTENNV;
    }

    public void setHOTENNV(String HOTENNV) {
        this.HOTENNV = HOTENNV;
    }

    public String getTENDN() {
        return TENDN;
    }

    public void setTENDN(String TENDN) {
        this.TENDN = TENDN;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(String NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    public int getMANV() {
        return MANV;
    }

    public void setMANV(int MANV) {
        this.MANV = MANV;
    }
}
