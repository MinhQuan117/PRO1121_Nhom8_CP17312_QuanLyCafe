package com.example.pro1121_cp17312_nhom8_quanlycafe.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pro1121_cp17312_nhom8_quanlycafe.Database.DbHelper;
import com.example.pro1121_cp17312_nhom8_quanlycafe.model.Mon;


import java.util.ArrayList;
import java.util.List;

public class MonDAO {
//    SQLiteDatabase database;
//    public MonDAO(Context context){
//        DbHelper createDatabase = new DbHelper(context);
//        database = createDatabase.open();
//    }
//
//    public boolean ThemMon(Mon mon){
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DbHelper.MALOAI,mon.getMaLoai());
//        contentValues.put(DbHelper.TENMON,mon.getTenMon());
//        contentValues.put(DbHelper.GIATIEN,mon.getGiaTien());
//        contentValues.put(DbHelper.HINHANH,mon.getHinhAnh());
//        contentValues.put(DbHelper.TINHTRANG,"true");
//
//        long ktra = database.insert(DbHelper.TBL_MON,null,contentValues);
//
//        if(ktra !=0){
//            return true;
//        }else {
//            return false;
//        }
//    }
//
//    public boolean XoaMon(int mamon){
//        long ktra = database.delete(DbHelper.TBL_MON,DbHelper.MAMON+ " = " +mamon
//                ,null);
//        if(ktra !=0 ){
//            return true;
//        }else {
//            return false;
//        }
//    }
//
//    public boolean SuaMon(Mon mon,int mamon){
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DbHelper.MALOAI,mon.getMaLoai());
//        contentValues.put(DbHelper.TENMON,mon.getTenMon());
//        contentValues.put(DbHelper.GIATIEN,mon.getGiaTien());
//        contentValues.put(DbHelper.HINHANH,mon.getHinhAnh());
//        contentValues.put(DbHelper.TINHTRANG,mon.getTinhTrang());
//
//        long ktra = database.update(DbHelper.TBL_MON,contentValues,
//                DbHelper.MAMON+" = "+mamon,null);
//        if(ktra !=0){
//            return true;
//        }else {
//            return false;
//        }
//    }
//
//    public List<Mon> LayDSMonTheoLoai(int maloai){
//        List<Mon> monDTOList = new ArrayList<Mon>();
//        String query = "SELECT * FROM " +DbHelper.TBL_MON+ " WHERE " +DbHelper.MALOAI+ " = '" +maloai+ "' ";
//        Cursor cursor = database.rawQuery(query,null);
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()){
//            Mon monDTO = new Mon();
//            monDTO.setHinhAnh(cursor.getBlob(cursor.getColumnIndex(DbHelper.HINHANH)));
//            monDTO.setTenMon(cursor.getString(cursor.getColumnIndex(DbHelper.TENMON)));
//            monDTO.setMaLoai(cursor.getInt(cursor.getColumnIndex(DbHelper.MALOAI)));
//            monDTO.setMaMon(cursor.getInt(cursor.getColumnIndex(DbHelper.MAMON)));
//            monDTO.setGiaTien(cursor.getString(cursor.getColumnIndex(DbHelper.GIATIEN)));
//            monDTO.setTinhTrang(cursor.getString(cursor.getColumnIndex(DbHelper.TINHTRANG)));
//            monDTOList.add(monDTO);
//
//            cursor.moveToNext();
//        }
//        return monDTOList;
//    }
//
//    public Mon LayMonTheoMa(int mamon){
//        Mon monDTO = new Mon();
//        String query = "SELECT * FROM "+DbHelper.TBL_MON+" WHERE "+DbHelper.MAMON+" = "+mamon;
//        Cursor cursor = database.rawQuery(query,null);
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()){
//            monDTO.setHinhAnh(cursor.getBlob(cursor.getColumnIndex(DbHelper.HINHANH)));
//            monDTO.setTenMon(cursor.getString(cursor.getColumnIndex(DbHelper.TENMON)));
//            monDTO.setMaLoai(cursor.getInt(cursor.getColumnIndex(DbHelper.MALOAI)));
//            monDTO.setMaMon(cursor.getInt(cursor.getColumnIndex(DbHelper.MAMON)));
//            monDTO.setGiaTien(cursor.getString(cursor.getColumnIndex(DbHelper.GIATIEN)));
//            monDTO.setTinhTrang(cursor.getString(cursor.getColumnIndex(DbHelper.TINHTRANG)));
//
//            cursor.moveToNext();
//        }
//        return monDTO;
//    }

}
