package com.example.pro1121_cp17312_nhom8_quanlycafe.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.NhanVienDTO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Database.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {

    SQLiteDatabase database;
    public NhanVienDAO(Context context){
        DbHelper createDatabase = new DbHelper(context);
        database = createDatabase.open();
    }

    public long ThemNhanVien(NhanVienDTO nhanVienDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.HOTENNV,nhanVienDTO.getHOTENNV());
        contentValues.put(DbHelper.TENDN,nhanVienDTO.getTENDN());
        contentValues.put(DbHelper.MATKHAU,nhanVienDTO.getMATKHAU());
        contentValues.put(DbHelper.EMAIL,nhanVienDTO.getEMAIL());
        contentValues.put(DbHelper.SDT,nhanVienDTO.getSDT());
        contentValues.put(DbHelper.GIOITINH,nhanVienDTO.getGIOITINH());
        contentValues.put(DbHelper.NGAYSINH,nhanVienDTO.getNGAYSINH());
        contentValues.put(DbHelper.MAQUYEN,nhanVienDTO.getMAQUYEN());

        long ktra = database.insert(DbHelper.TBL_NHANVIEN,null,contentValues);
        return ktra;
    }

    public long SuaNhanVien(NhanVienDTO nhanVienDTO,int manv){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.HOTENNV,nhanVienDTO.getHOTENNV());
        contentValues.put(DbHelper.TENDN,nhanVienDTO.getTENDN());
        contentValues.put(DbHelper.MATKHAU,nhanVienDTO.getMATKHAU());
        contentValues.put(DbHelper.EMAIL,nhanVienDTO.getEMAIL());
        contentValues.put(DbHelper.SDT,nhanVienDTO.getSDT());
        contentValues.put(DbHelper.GIOITINH,nhanVienDTO.getGIOITINH());
        contentValues.put(DbHelper.NGAYSINH,nhanVienDTO.getNGAYSINH());
        contentValues.put(DbHelper.MAQUYEN,nhanVienDTO.getMAQUYEN());

        long ktra = database.update(DbHelper.TBL_NHANVIEN,contentValues,
                DbHelper.MANV+" = "+manv,null);
        return ktra;
    }

    public int KiemTraDN(String tenDN, String matKhau){
        String query = "SELECT * FROM " +DbHelper.TBL_NHANVIEN+ " WHERE "
                +DbHelper.TENDN +" = '"+ tenDN+"' AND "+DbHelper.MATKHAU +" = '" +matKhau +"'";
        int manv = 0;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            manv = cursor.getInt(cursor.getColumnIndex(DbHelper.MANV)) ;
            cursor.moveToNext();
        }
        return manv;
    }

    public boolean KtraTonTaiNV(){
        String query = "SELECT * FROM "+DbHelper.TBL_NHANVIEN;
        Cursor cursor =database.rawQuery(query,null);
        if(cursor.getCount() != 0){
            return true;
        }else {
            return false;
        }
    }

    public List<NhanVienDTO> LayDSNV(){
        List<NhanVienDTO> nhanVienDTOS = new ArrayList<NhanVienDTO>();
        String query = "SELECT * FROM "+DbHelper.TBL_NHANVIEN;

        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            NhanVienDTO nhanVienDTO = new NhanVienDTO();
            nhanVienDTO.setHOTENNV(cursor.getString(cursor.getColumnIndex(DbHelper.HOTENNV)));
            nhanVienDTO.setEMAIL(cursor.getString(cursor.getColumnIndex(DbHelper.EMAIL)));
            nhanVienDTO.setGIOITINH(cursor.getString(cursor.getColumnIndex(DbHelper.GIOITINH)));
            nhanVienDTO.setNGAYSINH(cursor.getString(cursor.getColumnIndex(DbHelper.NGAYSINH)));
            nhanVienDTO.setSDT(cursor.getString(cursor.getColumnIndex(DbHelper.SDT)));
            nhanVienDTO.setTENDN(cursor.getString(cursor.getColumnIndex(DbHelper.TENDN)));
            nhanVienDTO.setMATKHAU(cursor.getString(cursor.getColumnIndex(DbHelper.MATKHAU)));
            nhanVienDTO.setMANV(cursor.getInt(cursor.getColumnIndex(DbHelper.MANV)));
            nhanVienDTO.setMAQUYEN(cursor.getInt(cursor.getColumnIndex(DbHelper.MAQUYEN)));

            nhanVienDTOS.add(nhanVienDTO);
            cursor.moveToNext();
        }
        return nhanVienDTOS;
    }

    public boolean XoaNV(int manv){
        long ktra = database.delete(DbHelper.TBL_NHANVIEN,DbHelper.MANV+ " = " +manv
                ,null);
        if(ktra !=0 ){
            return true;
        }else {
            return false;
        }
    }

    public NhanVienDTO LayNVTheoMa(int manv){
        NhanVienDTO nhanVienDTO = new NhanVienDTO();
        String query = "SELECT * FROM "+DbHelper.TBL_NHANVIEN+" WHERE "+DbHelper.MANV+" = "+manv;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            nhanVienDTO.setHOTENNV(cursor.getString(cursor.getColumnIndex(DbHelper.HOTENNV)));
            nhanVienDTO.setEMAIL(cursor.getString(cursor.getColumnIndex(DbHelper.EMAIL)));
            nhanVienDTO.setGIOITINH(cursor.getString(cursor.getColumnIndex(DbHelper.GIOITINH)));
            nhanVienDTO.setNGAYSINH(cursor.getString(cursor.getColumnIndex(DbHelper.NGAYSINH)));
            nhanVienDTO.setSDT(cursor.getString(cursor.getColumnIndex(DbHelper.SDT)));
            nhanVienDTO.setTENDN(cursor.getString(cursor.getColumnIndex(DbHelper.TENDN)));
            nhanVienDTO.setMATKHAU(cursor.getString(cursor.getColumnIndex(DbHelper.MATKHAU)));
            nhanVienDTO.setMANV(cursor.getInt(cursor.getColumnIndex(DbHelper.MANV)));
            nhanVienDTO.setMAQUYEN(cursor.getInt(cursor.getColumnIndex(DbHelper.MAQUYEN)));

            cursor.moveToNext();
        }
        return nhanVienDTO;
    }

    public int LayQuyenNV(int manv){
        int maquyen = 0;
        String query = "SELECT * FROM "+DbHelper.TBL_NHANVIEN+" WHERE "+DbHelper.MANV+" = "+manv;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            maquyen = cursor.getInt(cursor.getColumnIndex(DbHelper.MAQUYEN));

            cursor.moveToNext();
        }
        return maquyen;
    }


}
