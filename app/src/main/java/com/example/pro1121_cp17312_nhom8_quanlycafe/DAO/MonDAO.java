package com.example.pro1121_cp17312_nhom8_quanlycafe.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.MonDTO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Database.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class MonDAO {
    SQLiteDatabase database;
    public MonDAO(Context context){
        DbHelper createDatabase = new DbHelper(context);
        database = createDatabase.open();
    }

    public boolean ThemMon(MonDTO monDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.MALOAI,monDTO.getMaLoai());
        contentValues.put(DbHelper.TENMON,monDTO.getTenMon());
        contentValues.put(DbHelper.GIATIEN,monDTO.getGiaTien());
        contentValues.put(DbHelper.HINHANH,monDTO.getHinhAnh());
        contentValues.put(DbHelper.TINHTRANG,"true");

        long ktra = database.insert(DbHelper.TBL_MON,null,contentValues);

        if(ktra !=0){
            return true;
        }else {
            return false;
        }
    }

    public boolean XoaMon(int mamon){
        long ktra = database.delete(DbHelper.TBL_MON,DbHelper.MAMON+ " = " +mamon
                ,null);
        if(ktra !=0 ){
            return true;
        }else {
            return false;
        }
    }

    public boolean SuaMon(MonDTO monDTO,int mamon){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.MALOAI,monDTO.getMaLoai());
        contentValues.put(DbHelper.TENMON,monDTO.getTenMon());
        contentValues.put(DbHelper.GIATIEN,monDTO.getGiaTien());
        contentValues.put(DbHelper.HINHANH,monDTO.getHinhAnh());
        contentValues.put(DbHelper.TINHTRANG,monDTO.getTinhTrang());

        long ktra = database.update(DbHelper.TBL_MON,contentValues,
                DbHelper.MAMON+" = "+mamon,null);
        if(ktra !=0){
            return true;
        }else {
            return false;
        }
    }

    public List<MonDTO> LayDSMonTheoLoai(int maloai){
        List<MonDTO> monDTOList = new ArrayList<MonDTO>();
        String query = "SELECT * FROM " +DbHelper.TBL_MON+ " WHERE " +DbHelper.MALOAI+ " = '" +maloai+ "' ";
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            MonDTO monDTO = new MonDTO();
            monDTO.setHinhAnh(cursor.getBlob(cursor.getColumnIndex(DbHelper.HINHANH)));
            monDTO.setTenMon(cursor.getString(cursor.getColumnIndex(DbHelper.TENMON)));
            monDTO.setMaLoai(cursor.getInt(cursor.getColumnIndex(DbHelper.MALOAI)));
            monDTO.setMaMon(cursor.getInt(cursor.getColumnIndex(DbHelper.MAMON)));
            monDTO.setGiaTien(cursor.getString(cursor.getColumnIndex(DbHelper.GIATIEN)));
            monDTO.setTinhTrang(cursor.getString(cursor.getColumnIndex(DbHelper.TINHTRANG)));
            monDTOList.add(monDTO);

            cursor.moveToNext();
        }
        return monDTOList;
    }

    public MonDTO LayMonTheoMa(int mamon){
        MonDTO monDTO = new MonDTO();
        String query = "SELECT * FROM "+DbHelper.TBL_MON+" WHERE "+DbHelper.MAMON+" = "+mamon;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            monDTO.setHinhAnh(cursor.getBlob(cursor.getColumnIndex(DbHelper.HINHANH)));
            monDTO.setTenMon(cursor.getString(cursor.getColumnIndex(DbHelper.TENMON)));
            monDTO.setMaLoai(cursor.getInt(cursor.getColumnIndex(DbHelper.MALOAI)));
            monDTO.setMaMon(cursor.getInt(cursor.getColumnIndex(DbHelper.MAMON)));
            monDTO.setGiaTien(cursor.getString(cursor.getColumnIndex(DbHelper.GIATIEN)));
            monDTO.setTinhTrang(cursor.getString(cursor.getColumnIndex(DbHelper.TINHTRANG)));

            cursor.moveToNext();
        }
        return monDTO;
    }

}
