package com.example.pro1121_cp17312_nhom8_quanlycafe.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pro1121_cp17312_nhom8_quanlycafe.Database.DbHelper;
import com.example.pro1121_cp17312_nhom8_quanlycafe.model.LoaiMon;

import java.util.ArrayList;
import java.util.List;

public class LoaiMonDAO {
    SQLiteDatabase sqLiteDatabase;

    public LoaiMonDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        sqLiteDatabase = dbHelper.open();
    }

    public boolean ThemLoaiMon(LoaiMon loaiMon){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.TENLOAI,loaiMon.getTenLoai());
        contentValues.put(DbHelper.HINHANHMON,loaiMon.getHinhAnh());
        long check = sqLiteDatabase.insert(DbHelper.TBL_LOAIMON,null,contentValues);

        if (check !=0){
            return true;
        }else {
            return false;
        }
    }
    public boolean XoaLoaiMon(int maloai){
        long check = sqLiteDatabase.delete(DbHelper.TBL_LOAIMON,DbHelper.MALOAIMON+"="+maloai,null);
        if (check !=0){
            return true;
        }else {
            return false;
        }
    }
    public boolean SuaLoai(LoaiMon loaiMon, int maloai){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.TENLOAI,loaiMon.getTenLoai());
        contentValues.put(DbHelper.HINHANHMON,loaiMon.getHinhAnh());
        long check = sqLiteDatabase.update(DbHelper.TBL_LOAIMON,contentValues,DbHelper.MALOAIMON+"="+maloai,null);
        if (check !=0){
            return true;
        }else {
            return false;
        }

    }
    public List<LoaiMon> getDSLoaiMon(){
        List<LoaiMon> loaiMonList = new ArrayList<>();
        String query = "SELECT * FROM " +DbHelper.TBL_LOAIMON;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            LoaiMon loaiMon = new LoaiMon();
            loaiMon.setMaLoai(cursor.getInt(cursor.getColumnIndex(DbHelper.MALOAIMON)));
            loaiMon.setTenLoai(cursor.getString(cursor.getColumnIndex(DbHelper.TENLOAI)));
            loaiMon.setHinhAnh(cursor.getBlob(cursor.getColumnIndex(DbHelper.HINHANHMON)));
            loaiMonList.add(loaiMon);
            cursor.moveToNext();

        }
        return loaiMonList;
    }
    public LoaiMon getLoaiMon(int maloai){
        LoaiMon loaiMon = new LoaiMon();
        String query = "SELECT * FROM " +DbHelper.TBL_LOAIMON+" WHERE "+DbHelper.MALOAIMON+" = "+maloai;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        while (!cursor.isAfterLast()){
            loaiMon.setMaLoai(cursor.getInt(cursor.getColumnIndex(DbHelper.MALOAI)));
            loaiMon.setTenLoai(cursor.getString(cursor.getColumnIndex(DbHelper.TENLOAI)));
            loaiMon.setHinhAnh(cursor.getBlob(cursor.getColumnIndex(DbHelper.HINHANHMON)));
            cursor.moveToNext();
        }
        return loaiMon;
    }
}
