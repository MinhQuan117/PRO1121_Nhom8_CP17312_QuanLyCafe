package com.example.pro1121_cp17312_nhom8_quanlycafe.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.DonDatDTO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Database.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class DonDatDAO {

    SQLiteDatabase database;
    public DonDatDAO(Context context){
        DbHelper createDatabase = new DbHelper(context);
        database = createDatabase.open();
    }

    public long ThemDonDat(DonDatDTO donDatDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.MABAN,donDatDTO.getMaBan());
        contentValues.put(DbHelper.MANV,donDatDTO.getMaNV());
        contentValues.put(DbHelper.NGAYDAT,donDatDTO.getNgayDat());
        contentValues.put(DbHelper.TINHTRANG,donDatDTO.getTinhTrang());
        contentValues.put(DbHelper.TONGTIEN,donDatDTO.getTongTien());

        long madondat = database.insert(DbHelper.TBL_DONDAT,null,contentValues);

        return madondat;
    }

    public List<DonDatDTO> LayDSDonDat(){
        List<DonDatDTO> donDatDTOS = new ArrayList<DonDatDTO>();
        String query = "SELECT * FROM "+DbHelper.TBL_DONDAT;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            DonDatDTO donDatDTO = new DonDatDTO();
            donDatDTO.setMaDonDat(cursor.getInt(cursor.getColumnIndex(DbHelper.MADONDAT)));
            donDatDTO.setMaBan(cursor.getInt(cursor.getColumnIndex(DbHelper.MABAN)));
            donDatDTO.setTongTien(cursor.getString(cursor.getColumnIndex(DbHelper.TONGTIEN)));
            donDatDTO.setTinhTrang(cursor.getString(cursor.getColumnIndex(DbHelper.TINHTRANG)));
            donDatDTO.setNgayDat(cursor.getString(cursor.getColumnIndex(DbHelper.NGAYDAT)));
            donDatDTO.setMaNV(cursor.getInt(cursor.getColumnIndex(DbHelper.MANV)));
            donDatDTOS.add(donDatDTO);

            cursor.moveToNext();
        }
        return donDatDTOS;
    }

    public List<DonDatDTO> LayDSDonDatNgay(String ngaythang){
        List<DonDatDTO> donDatDTOS = new ArrayList<DonDatDTO>();
        String query = "SELECT * FROM "+DbHelper.TBL_DONDAT+" WHERE "+DbHelper.NGAYDAT+" like '"+ngaythang+"'";
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            DonDatDTO donDatDTO = new DonDatDTO();
            donDatDTO.setMaDonDat(cursor.getInt(cursor.getColumnIndex(DbHelper.MADONDAT)));
            donDatDTO.setMaBan(cursor.getInt(cursor.getColumnIndex(DbHelper.MABAN)));
            donDatDTO.setTongTien(cursor.getString(cursor.getColumnIndex(DbHelper.TONGTIEN)));
            donDatDTO.setTinhTrang(cursor.getString(cursor.getColumnIndex(DbHelper.TINHTRANG)));
            donDatDTO.setNgayDat(cursor.getString(cursor.getColumnIndex(DbHelper.NGAYDAT)));
            donDatDTO.setMaNV(cursor.getInt(cursor.getColumnIndex(DbHelper.MANV)));
            donDatDTOS.add(donDatDTO);

            cursor.moveToNext();
        }
        return donDatDTOS;
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
