package com.example.pro1121_cp17312_nhom8_quanlycafe.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.ChiTietDonDatDTO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Database.DbHelper;

public class ChiTietDonDatDAO {

    SQLiteDatabase database;
    public ChiTietDonDatDAO(Context context){
        DbHelper createDatabase = new DbHelper(context);
        database = createDatabase.open();
    }

    public boolean KiemTraMonTonTai(int madondat, int mamon){
        String query = "SELECT * FROM " +DbHelper.TBL_CHITIETDONDAT+ " WHERE " +DbHelper.MAMON+
                " = " +mamon+ " AND " +DbHelper.MADONDAT+ " = "+madondat;
        Cursor cursor = database.rawQuery(query,null);
        if(cursor.getCount() != 0){
            return true;
        }else {
            return false;
        }
    }

    public int LaySLMonTheoMaDon(int madondat, int mamon){
        int soluong = 0;
        String query = "SELECT * FROM " +DbHelper.TBL_CHITIETDONDAT+ " WHERE " +DbHelper.MAMON+
                " = " +mamon+ " AND " +DbHelper.MADONDAT+ " = "+madondat;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            soluong = cursor.getInt(cursor.getColumnIndex(DbHelper.SOLUONG));
            cursor.moveToNext();
        }
        return soluong;
    }

    public boolean CapNhatSL(ChiTietDonDatDTO chiTietDonDatDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.SOLUONG, chiTietDonDatDTO.getSoLuong());

        long ktra = database.update(DbHelper.TBL_CHITIETDONDAT,contentValues,DbHelper.MADONDAT+ " = "
                +chiTietDonDatDTO.getMaDonDat()+ " AND " +DbHelper.MAMON+ " = "
                +chiTietDonDatDTO.getMaMon(),null);
        if(ktra !=0){
            return true;
        }else {
            return false;
        }
    }

    public boolean ThemChiTietDonDat(ChiTietDonDatDTO chiTietDonDatDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.SOLUONG,chiTietDonDatDTO.getSoLuong());
        contentValues.put(DbHelper.MADONDAT,chiTietDonDatDTO.getMaDonDat());
        contentValues.put(DbHelper.MAMON,chiTietDonDatDTO.getMaMon());

        long ktra = database.insert(DbHelper.TBL_CHITIETDONDAT,null,contentValues);
        if(ktra !=0){
            return true;
        }else {
            return false;
        }
    }

}
