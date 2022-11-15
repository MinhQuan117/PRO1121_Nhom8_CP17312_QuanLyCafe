package com.example.pro1121_cp17312_nhom8_quanlycafe.model;

public class Ban {
    int MaBan;
    String TenBan;
    boolean DuocChon;

    public Ban(int maBan, String tenBan, boolean duocChon) {
        MaBan = maBan;
        TenBan = tenBan;
        DuocChon = duocChon;
    }

    public int getMaBan() {
        return MaBan;
    }

    public void setMaBan(int maBan) {
        MaBan = maBan;
    }

    public String getTenBan() {
        return TenBan;
    }

    public void setTenBan(String tenBan) {
        TenBan = tenBan;
    }

    public boolean isDuocChon() {
        return DuocChon;
    }

    public void setDuocChon(boolean duocChon) {
        DuocChon = duocChon;
    }
}
