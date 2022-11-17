package com.example.pro1121_cp17312_nhom8_quanlycafe.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pro1121_cp17312_nhom8_quanlycafe.Database.DbHelper;
import com.example.pro1121_cp17312_nhom8_quanlycafe.model.ChiTietDonDat;


public class ChiTietDonDatDAO {

    SQLiteDatabase database;
    public ChiTietDonDatDAO(Context context){
        DbHelper dbHelper = new DbHelper(context);
        database = dbHelper.open();
    }

    public boolean KiemTraMonTonTai(int madondat, int mamon){
        String query = "SELECT * FROM " +DbHelper.TBL_CHITIETDONDAT+ " WHERE " +DbHelper.MAMONCT+
                " = " +mamon+ " AND " +DbHelper.MADONDATCT+ " = "+madondat;
        Cursor cursor = database.rawQuery(query,null);
        if(cursor.getCount() != 0){
            return true;
        }else {
            return false;
        }
    }

    public int LaySLMonTheoMaDon(int madondat, int mamon){
        int soluong = 0;
        String query = "SELECT * FROM " +DbHelper.TBL_CHITIETDONDAT+ " WHERE " +DbHelper.MAMONCT+
                " = " +mamon+ " AND " +DbHelper.MADONDATCT+ " = "+madondat;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            soluong = cursor.getInt(cursor.getColumnIndex(DbHelper.SOLUONG));
            cursor.moveToNext();
        }
        return soluong;
    }

    public boolean CapNhatSL(ChiTietDonDat chiTietDonDatDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.SOLUONG, chiTietDonDatDTO.getSoLuong());

        long ktra = database.update(DbHelper.TBL_CHITIETDONDAT,contentValues,DbHelper.MADONDATCT+ " = "
                +chiTietDonDatDTO.getMaDonDat()+ " AND " +DbHelper.MAMONCT+ " = "
                +chiTietDonDatDTO.getMaMon(),null);
        if(ktra !=0){
            return true;
        }else {
            return false;
        }
    }

    public boolean ThemChiTietDonDat(ChiTietDonDat chiTietDonDatDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.SOLUONG,chiTietDonDatDTO.getSoLuong());
        contentValues.put(DbHelper.MADONDATCT,chiTietDonDatDTO.getMaDonDat());
        contentValues.put(DbHelper.MAMONCT,chiTietDonDatDTO.getMaMon());

        long ktra = database.insert(DbHelper.TBL_CHITIETDONDAT,null,contentValues);
        if(ktra !=0){
            return true;
        }else {
            return false;
        }
    }

}
