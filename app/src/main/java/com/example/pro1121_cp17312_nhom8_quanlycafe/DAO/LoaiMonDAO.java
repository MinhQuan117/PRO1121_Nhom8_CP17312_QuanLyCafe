package com.example.pro1121_cp17312_nhom8_quanlycafe.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.LoaiMonDTO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Database.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class LoaiMonDAO {

    SQLiteDatabase database;
    public LoaiMonDAO(Context context){
        DbHelper createDatabase = new DbHelper(context);
        database = createDatabase.open();
    }

    public boolean ThemLoaiMon(LoaiMonDTO loaiMonDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.TENLOAI,loaiMonDTO.getTenLoai());
        contentValues.put(DbHelper.HINHANH,loaiMonDTO.getHinhAnh());
        long ktra = database.insert(DbHelper.TBL_LOAIMON,null,contentValues);

        if(ktra != 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean XoaLoaiMon(int maloai){
        long ktra = database.delete(DbHelper.TBL_LOAIMON,DbHelper.MALOAI+ " = " +maloai
                ,null);
        if(ktra !=0 ){
            return true;
        }else {
            return false;
        }
    }

    public boolean SuaLoaiMon(LoaiMonDTO loaiMonDTO,int maloai){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.TENLOAI,loaiMonDTO.getTenLoai());
        contentValues.put(DbHelper.HINHANH,loaiMonDTO.getHinhAnh());
        long ktra = database.update(DbHelper.TBL_LOAIMON,contentValues
                ,DbHelper.MALOAI+" = "+maloai,null);
        if(ktra != 0){
            return true;
        }else {
            return false;
        }
    }

    public List<LoaiMonDTO> LayDSLoaiMon(){
        List<LoaiMonDTO> loaiMonDTOList = new ArrayList<LoaiMonDTO>();
        String query = "SELECT * FROM " +DbHelper.TBL_LOAIMON;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            LoaiMonDTO loaiMonDTO = new LoaiMonDTO();
            loaiMonDTO.setMaLoai(cursor.getInt(cursor.getColumnIndex(DbHelper.MALOAI)));
            loaiMonDTO.setTenLoai(cursor.getString(cursor.getColumnIndex(DbHelper.TENLOAI)));
            loaiMonDTO.setHinhAnh(cursor.getBlob(cursor.getColumnIndex(DbHelper.HINHANH)));
            loaiMonDTOList.add(loaiMonDTO);

            cursor.moveToNext();
        }
        return loaiMonDTOList;
    }

    public LoaiMonDTO LayLoaiMonTheoMa(int maloai){
        LoaiMonDTO loaiMonDTO = new LoaiMonDTO();
        String query = "SELECT * FROM " +DbHelper.TBL_LOAIMON+" WHERE "+DbHelper.MALOAI+" = "+maloai;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            loaiMonDTO.setMaLoai(cursor.getInt(cursor.getColumnIndex(DbHelper.MALOAI)));
            loaiMonDTO.setTenLoai(cursor.getString(cursor.getColumnIndex(DbHelper.TENLOAI)));
            loaiMonDTO.setHinhAnh(cursor.getBlob(cursor.getColumnIndex(DbHelper.HINHANH)));

            cursor.moveToNext();
        }
        return loaiMonDTO;
    }

}
