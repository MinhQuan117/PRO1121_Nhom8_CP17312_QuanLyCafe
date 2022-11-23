package com.example.pro1121_cp17312_nhom8_quanlycafe.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.BanAnDTO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Database.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class BanAnDAO {
    SQLiteDatabase database;
    public BanAnDAO(Context context){
        DbHelper createDatabase = new DbHelper(context);
        database = createDatabase.open();
    }

    //Hàm thêm bàn ăn mới
    public boolean ThemBanAn(String tenban){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.TENBAN,tenban);
        contentValues.put(DbHelper.TINHTRANG,"false");

        long ktra = database.insert(DbHelper.TBL_BAN,null,contentValues);
        if(ktra != 0){
            return true;
        }else {
            return false;
        }
    }

    //Hàm xóa bàn ăn theo mã
    public boolean XoaBanTheoMa(int maban){
        long ktra =database.delete(DbHelper.TBL_BAN,DbHelper.MABAN+" = "+maban,null);
        if(ktra != 0){
            return true;
        }else {
            return false;
        }
    }

    //Sửa tên bàn
    public boolean CapNhatTenBan(int maban, String tenban){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.TENBAN,tenban);

        long ktra = database.update(DbHelper.TBL_BAN,contentValues,DbHelper.MABAN+ " = '"+maban+"' ",null);
        if(ktra != 0){
            return true;
        }else {
            return false;
        }
    }

    //Hàm lấy ds các bàn ăn đổ vào gridview
    public List<BanAnDTO> LayTatCaBanAn(){
        List<BanAnDTO> banAnDTOList = new ArrayList<BanAnDTO>();
        String query = "SELECT * FROM " +DbHelper.TBL_BAN;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            BanAnDTO banAnDTO = new BanAnDTO();
            banAnDTO.setMaBan(cursor.getInt(cursor.getColumnIndex(DbHelper.MABAN)));
            banAnDTO.setTenBan(cursor.getString(cursor.getColumnIndex(DbHelper.TENBAN)));

            banAnDTOList.add(banAnDTO);
            cursor.moveToNext();
        }
        return banAnDTOList;
    }

    public String LayTinhTrangBanTheoMa(int maban){
        String tinhtrang="";
        String query = "SELECT * FROM "+DbHelper.TBL_BAN + " WHERE " +DbHelper.MABAN+ " = '" +maban+ "' ";
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            tinhtrang = cursor.getString(cursor.getColumnIndex(DbHelper.TINHTRANG));
            cursor.moveToNext();
        }

        return tinhtrang;
    }

    public boolean CapNhatTinhTrangBan(int maban, String tinhtrang){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.TINHTRANG,tinhtrang);

        long ktra = database.update(DbHelper.TBL_BAN,contentValues,DbHelper.MABAN+ " = '"+maban+"' ",null);
        if(ktra != 0){
            return true;
        }else {
            return false;
        }
    }

    public String LayTenBanTheoMa(int maban){
        String tenban="";
        String query = "SELECT * FROM "+DbHelper.TBL_BAN + " WHERE " +DbHelper.MABAN+ " = '" +maban+ "' ";
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            tenban = cursor.getString(cursor.getColumnIndex(DbHelper.TENBAN));
            cursor.moveToNext();
        }

        return tenban;
    }
}
