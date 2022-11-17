package com.example.pro1121_cp17312_nhom8_quanlycafe.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pro1121_cp17312_nhom8_quanlycafe.Database.DbHelper;

public class QuyenDAO {

    SQLiteDatabase database;
    public QuyenDAO(Context context){
        DbHelper createDatabase = new DbHelper(context);
        database = createDatabase.open();
    }

    public void ThemQuyen(String tenquyen){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.TENQUYEN,tenquyen);
        database.insert(DbHelper.TBL_QUYEN,null,contentValues);
    }
    

    public String LayTenQuyenTheoMa(int maquyen){
        String tenquyen ="";
        String query = "SELECT * FROM "+DbHelper.TBL_QUYEN+" WHERE "+DbHelper.MAQUYEN+" = "+maquyen;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            tenquyen = cursor.getString(cursor.getColumnIndex(DbHelper.TENQUYEN));
            cursor.moveToNext();
        }
        return tenquyen;
    }
}
