package com.example.pro1121_cp17312_nhom8_quanlycafe.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.pro1121_cp17312_nhom8_quanlycafe.Database.DbHelper;
import com.example.pro1121_cp17312_nhom8_quanlycafe.model.ThanhToan;

import java.util.ArrayList;
import java.util.List;

public class ThanhToanDAO {

    SQLiteDatabase database;
    public ThanhToanDAO(Context context){
        DbHelper createDatabase = new DbHelper(context);
        database = createDatabase.open();
    }

    public List<ThanhToan> LayDSMonTheoMaDon(int madondat){
        List<ThanhToan> thanhToanDTOS = new ArrayList<ThanhToan>();
        String query = "SELECT * FROM "+DbHelper.TBL_CHITIETDONDAT+" ctdd,"+DbHelper.TBL_MON+" mon WHERE "
                +"ctdd."+DbHelper.MAMON+" = mon."+DbHelper.MAMON+" AND "
                +DbHelper.MADONDAT+" = '"+madondat+"'";

        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ThanhToan thanhToanDTO = new ThanhToan();
            thanhToanDTO.setSoLuong(cursor.getInt(cursor.getColumnIndex(DbHelper.SOLUONG)));
            thanhToanDTO.setGiaTien(cursor.getInt(cursor.getColumnIndex(DbHelper.GIATIEN)));
            thanhToanDTO.setTenMon(cursor.getString(cursor.getColumnIndex(DbHelper.TENMON)));
            thanhToanDTO.setHinhAnh(cursor.getBlob(cursor.getColumnIndex(DbHelper.HINHANH)));
            thanhToanDTOS.add(thanhToanDTO);

            cursor.moveToNext();
        }

        return thanhToanDTOS;
    }
}
