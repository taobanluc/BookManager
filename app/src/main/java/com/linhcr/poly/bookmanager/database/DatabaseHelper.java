package com.linhcr.poly.bookmanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.linhcr.poly.bookmanager.Constant;
import com.linhcr.poly.bookmanager.model.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper implements Constant {

    public static final String DATABASE_NAME = "BookManager";
    public static final int DATABASE_VERSION = 2;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        Tạo bảng
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_TYPE_BOOK_TABLE);
//        db.execSQL(CREATE_BILL_TABLE);
        if (Constant.isDEBUG) Log.e("CREATE_USER_TABLE", CREATE_USER_TABLE);
        if (Constant.isDEBUG) Log.e("CREATE_TYPE_TABLE", CREATE_TYPE_BOOK_TABLE);
        if (Constant.isDEBUG) Log.e("CREATE BILL", CREATE_BILL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
