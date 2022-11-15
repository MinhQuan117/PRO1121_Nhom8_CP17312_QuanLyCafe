package com.example.pro1121_cp17312_nhom8_quanlycafe.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {


    public DbHelper( Context context) {
        super(context, "Coffee", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tblNHANVIEN = "CREATE TABLE TBL_NHANVIEN ( MANV INTEGER PRIMARY KEY AUTOINCREMENT, HOTENNV TEXT, TENDN TEXT, MATKHAU TEXT, EMAIL TEXT, SDT TEXT, GIOITINH TEXT, NGAYSINH TEXT)";
        db.execSQL(tblNHANVIEN);

        String tblBAN = "CREATE TABLE TBL_BAN ( MABAN INTEGER PRIMARY KEY AUTOINCREMENT, TENBAN TEXT, TINHTRANG TEXT )";
        db.execSQL(tblBAN);

        String tblMON = "CREATE TABLE TBL_MON ( MAMON INTEGER PRIMARY KEY AUTOINCREMENT, TENMON TEXT, GIATIEN TEXT, TINHTRANG TEXT, HINHANH BLOB, MALOAI INTEGER )";
        db.execSQL(tblMON);

        String tblLOAIMON = "CREATE TABLE TBL_LOAIMON ( MALOAI INTEGER PRIMARY KEY AUTOINCREMENT, HINHANH BLOB, TENLOAI TEXT)" ;
        db.execSQL(tblLOAIMON);

        String tblDONDAT = "CREATE TABLE TBL_DONDAT( MADONDAT INTEGER PRIMARY KEY AUTOINCREMENT,MABAN INTEGER, MANV INTEGER, NGAYDAT TEXT, TONGTIEN TEXT,TINHTRANG TEXT )" ;
        db.execSQL(tblDONDAT);

        String tblCHITIETDONDAT = "CREATE TABLE TBL_CHITIETDONDAT( MADONDAT INTEGER, MAMON INTEGER, SOLUONG INTEGER,  PRIMARY KEY ( MADONDAT,MAMON))";
        db.execSQL(tblCHITIETDONDAT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tblNHANVIEN");
        db.execSQL("drop table if exists tblBAN");
        db.execSQL("drop table if exists tblMON");
        db.execSQL("drop table if exists tblLOAIMON");
        db.execSQL("drop table if exists tblDONDAT");
        db.execSQL("drop table if exists tblCHITIETDONDAT");
        onCreate(db);
    }
}
