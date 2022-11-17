package com.example.pro1121_cp17312_nhom8_quanlycafe.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static String TBL_NHANVIEN = "NHANVIEN";
    public static String TBL_MON = "MON";
    public static String TBL_LOAIMON = "LOAIMON";
    public static String TBL_BAN = "BAN";
    public static String TBL_DONDAT = "DONDAT";
    public static String TBL_CHITIETDONDAT = "CHITIETDONDAT";
    public static String TBL_QUYEN = "QUYEN";

    //Bảng nhân viên
    public static String MANV = "MANV";
    public static String HOTENNV = "HOTENNV";
    public static String TENDN = "TENDN";
    public static String MATKHAU = "MATKHAU";
    public static String EMAIL = "EMAIL";
    public static String SDT = "SDT";
    public static String GIOITINH = "GIOITINH";
    public static String NGAYSINH = "NGAYSINH";
    public static String MAQUYENNV= "MAQUYEN";

    //Bảng quyền
    public static String MAQUYEN = "MAQUYEN";
    public static String TENQUYEN = "TENQUYEN";

    //Bảng món
    public static String MAMON = "MAMON";
    public static String TENMON = "TENMON";
    public static String GIATIEN = "GIATIEN";
    public static String TINHTRANG = "TINHTRANG";
    public static String HINHANH = "HINHANH";
    public static String MALOAI = "MALOAI";

    //Bảng loại món
    public static String MALOAIMON = "MALOAIMON";
    public static String TENLOAI = "TENLOAI";
    public static String HINHANHMON = "HINHANHMON";

    //Bảng bàn
    public static String MABAN = "MABAN";
    public static String TENBAN = "TENBAN";
    public static String TINHTRANGBAN = "TINHTRANGBAN";

    //Bảng đơn đặt
    public static String MADONDAT = "MADONDAT";
    public static String MANVTT = "MANVTT";
    public static String NGAYDAT = "NGAYDAT";
    public static String TINHTRANGDON = "TINHTRANGDON";
    public static String TONGTIEN = "TONGTIEN";
    public static String MABANTT = "MABANTT";

    //Bảng chi tiết đơn đặt
    public static String MADONDATCT = "MADONDATCT";
    public static String MAMONCT = "MAMONCT";
    public static String SOLUONG = "SOLUONG";


    public DbHelper(Context context) {
        super(context, "OrderDrink", null, 1);
    }

    //thực hiện tạo bảng
    @Override
    public void onCreate(SQLiteDatabase db) {
        String NHANVIEN = "CREATE TABLE " +TBL_NHANVIEN+ " ( " +MANV+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +HOTENNV+ " TEXT, " +TENDN+ " TEXT, " +MATKHAU+ " TEXT, " +EMAIL+ " TEXT, "
                +SDT+ " TEXT, " +GIOITINH+ " TEXT, " +NGAYSINH+ " TEXT , "+MAQUYENNV+" INTEGER)";

        String QUYEN = "CREATE TABLE " +TBL_QUYEN+ " ( " +MAQUYEN+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +TENQUYEN+ " TEXT)" ;

        String BAN = "CREATE TABLE " +TBL_BAN+ " ( " +MABAN+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +TENBAN+ " TEXT, " +TINHTRANGBAN+ " TEXT )";

        String MON = "CREATE TABLE " +TBL_MON+ " ( " +MAMON+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +TENMON+ " TEXT, " +GIATIEN+ " TEXT, " +TINHTRANG+ " TEXT, "
                +HINHANH+ " BLOB, "+MALOAI+ " INTEGER )";

        String LOAIMON = "CREATE TABLE " +TBL_LOAIMON+ " ( " +MALOAIMON+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +HINHANHMON+ " BLOB, " +TENLOAI+ " TEXT)" ;

        String DONDAT = "CREATE TABLE " +TBL_DONDAT+ " ( " +MADONDAT+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +MABANTT+ " INTEGER, " +MANVTT+ " INTEGER, " +NGAYDAT+ " TEXT, "+TONGTIEN+" TEXT,"
                +TINHTRANGDON+ " TEXT )" ;

        String CHITIETDONDAT = "CREATE TABLE " +TBL_CHITIETDONDAT+ " ( " +MADONDATCT+ " INTEGER, "
                +MAMONCT+ " INTEGER, " +SOLUONG+ " INTEGER, "
                + " PRIMARY KEY ( " +MADONDAT+ "," +MAMON+ "))";

        db.execSQL(NHANVIEN);
        db.execSQL(QUYEN);
        db.execSQL(BAN);
        db.execSQL(MON);
        db.execSQL(LOAIMON);
        db.execSQL(DONDAT);
        db.execSQL(CHITIETDONDAT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //mở kết nối csdl
    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}
