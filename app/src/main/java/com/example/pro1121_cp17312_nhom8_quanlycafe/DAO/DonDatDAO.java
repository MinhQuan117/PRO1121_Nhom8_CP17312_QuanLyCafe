package com.example.pro1121_cp17312_nhom8_quanlycafe.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pro1121_cp17312_nhom8_quanlycafe.Database.DbHelper;
import com.example.pro1121_cp17312_nhom8_quanlycafe.model.DonDat;


import java.util.ArrayList;
import java.util.List;

public class DonDatDAO {

    SQLiteDatabase database;
    public DonDatDAO(Context context){
        DbHelper createDatabase = new DbHelper(context);
        database = createDatabase.open();
    }

    public long ThemDonDat(DonDat dondat){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.MABAN,dondat.getMaBan());
        contentValues.put(DbHelper.MANV,dondat.getMaNV());
        contentValues.put(DbHelper.NGAYDAT,dondat.getNgayDat());
        contentValues.put(DbHelper.TINHTRANG,dondat.getTinhTrang());
        contentValues.put(DbHelper.TONGTIEN,dondat.getTongTien());

        long madondat = database.insert(DbHelper.TBL_DONDAT,null,contentValues);

        return madondat;
    }

    public List<DonDat> LayDSDonDat(){
        List<DonDat> donDats = new ArrayList<DonDat>();
        String query = "SELECT * FROM "+DbHelper.TBL_DONDAT;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            DonDat donDatDTO = new DonDat();
            donDatDTO.setMaDonDat(cursor.getInt(cursor.getColumnIndex(DbHelper.MADONDAT)));
            donDatDTO.setMaBan(cursor.getInt(cursor.getColumnIndex(DbHelper.MABAN)));
            donDatDTO.setTongTien(cursor.getString(cursor.getColumnIndex(DbHelper.TONGTIEN)));
            donDatDTO.setTinhTrang(cursor.getString(cursor.getColumnIndex(DbHelper.TINHTRANG)));
            donDatDTO.setNgayDat(cursor.getString(cursor.getColumnIndex(DbHelper.NGAYDAT)));
            donDatDTO.setMaNV(cursor.getInt(cursor.getColumnIndex(DbHelper.MANV)));
            donDats.add(donDatDTO);

            cursor.moveToNext();
        }
        return donDats;
    }

    public List<DonDat> LayDSDonDatNgay(String ngaythang){
        List<DonDat> donDat = new ArrayList<DonDat>();
        String query = "SELECT * FROM "+DbHelper.TBL_DONDAT+" WHERE "+DbHelper.NGAYDAT+" like '"+ngaythang+"'";
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            DonDat donDatDTO = new DonDat();
            donDatDTO.setMaDonDat(cursor.getInt(cursor.getColumnIndex(DbHelper.MADONDAT)));
            donDatDTO.setMaBan(cursor.getInt(cursor.getColumnIndex(DbHelper.MABAN)));
            donDatDTO.setTongTien(cursor.getString(cursor.getColumnIndex(DbHelper.TONGTIEN)));
            donDatDTO.setTinhTrang(cursor.getString(cursor.getColumnIndex(DbHelper.TINHTRANG)));
            donDatDTO.setNgayDat(cursor.getString(cursor.getColumnIndex(DbHelper.NGAYDAT)));
            donDatDTO.setMaNV(cursor.getInt(cursor.getColumnIndex(DbHelper.MANV)));
            donDat.add(donDatDTO);

            cursor.moveToNext();
        }
        return donDat;
    }

    public long LayMaDonTheoMaBan(int maban, String tinhtrang){
        String query = "SELECT * FROM " +DbHelper.TBL_DONDAT+ " WHERE " +DbHelper.MABAN+ " = '" +maban+ "' AND "
                +DbHelper.TINHTRANG+ " = '" +tinhtrang+ "' ";
        long magoimon = 0;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            magoimon = cursor.getInt(cursor.getColumnIndex(DbHelper.MADONDAT));

            cursor.moveToNext();
        }
        return magoimon;
    }

    public boolean UpdateTongTienDonDat(int madondat,String tongtien){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.TONGTIEN,tongtien);
        long ktra  = database.update(DbHelper.TBL_DONDAT,contentValues,
                DbHelper.MADONDAT+" = "+madondat,null);
        if(ktra != 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean UpdateTThaiDonTheoMaBan(int maban,String tinhtrang){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.TINHTRANG,tinhtrang);
        long ktra = database.update(DbHelper.TBL_DONDAT,contentValues,DbHelper.MABAN+
                " = '"+maban+"'",null);
        if(ktra !=0){
            return true;
        }else {
            return false;
        }
    }

}
