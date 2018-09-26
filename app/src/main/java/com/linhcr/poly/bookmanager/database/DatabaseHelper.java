package com.linhcr.poly.bookmanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.linhcr.poly.bookmanager.model.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "user_db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "users";
    public static final String COLUMN_USER_NAME = "user_name";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_PASSWORD = "password";
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQLQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_USER_NAME + " text primary key, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_PHONE + " TEXT, " +
                COLUMN_PASSWORD + " TEXT)";
        db.execSQL(SQLQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long insertUser(User user) {
        // ghi dữ liệu vào cơ sở dữ liệu
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
//        Chứa dữ liệu cần chuyền vào database
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_USER_NAME, user.getUser_name());
        values.put(COLUMN_PHONE, user.getPhone_number());
        values.put(COLUMN_PASSWORD, user.getPass_word());

        // insert vào hàng
        long id = db.insert(TABLE_NAME, null, values);

        // đóng
        db.close();

        // return newly inserted row id
        return id;
    }

    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setUser_name(cursor.getString(0));
                user.setPass_word(cursor.getString(1));
                user.setName(cursor.getString(2));
                user.setPhone_number(cursor.getString(3));
                userList.add(user);
            } while (cursor.moveToNext());
        }
        db.close();
        return userList;

    }

    public User getUser(String username) {
//        Lấy giữ liệu người dùng
        User user = null;

        SQLiteDatabase db = this.getReadableDatabase();
// Lấy cơ sở dữ liệu có thể đọc từ Database

//        Cursor để nhận dữ liệu truy vấn từ database
        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_NAME, COLUMN_USER_NAME, COLUMN_PHONE, COLUMN_PASSWORD},
                COLUMN_USER_NAME + "=?", new String[]{username},
                null, null, null, null);
//                Truyền vào tên bảng, array(mảng) gồm tên các cột, tên cột khóa chính,
// giá trị khóa chính khai báo ở đầu phương thức (String username), các tham số còn lại là null

        if (cursor != null && cursor.moveToFirst()) {

            String user_name = cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME));

            String password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));

            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));

            String phoneNumber = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE));

            user = new User(user_name, password, name, phoneNumber);

        }

//        if (cursor != null) {
////            Nếu cursor không rỗng thì chuyển cursor lên đầu
//            cursor.moveToFirst();
//        }

//         user = new User(
//                cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)),
//                cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
//                cursor.getString(cursor.getColumnIndex(COLUMN_PHONE)),
//                cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD))
//        );

//        lấy dữ liệu trong bảng
        cursor.close();

        return user;
    }


    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
//        Lấy cơ sở dữ liệu có thể ghi vào Database
        Cursor cursor = db.rawQuery(selectQuery, null);
//      lặp qua tất cả các hàng và thêm chúng vào danh sách
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setUser_name(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                user.setPhone_number(cursor.getString(cursor.getColumnIndex(COLUMN_PHONE)));
                user.setPass_word(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));

                userList.add(user);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return userList;
    }

    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
//        Lấy cơ sở dữ liệu có thể ghi vào Database
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getUser_name());
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_PHONE, user.getPhone_number());
        values.put(COLUMN_PASSWORD, user.getPass_word());

        // updating hàng
        return db.update(TABLE_NAME, values, COLUMN_USER_NAME + " = ?",
                new String[]{String.valueOf(user.getUser_name())});
    }

    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_USER_NAME + " = ?",
                new String[]{String.valueOf(user.getUser_name())});
        db.close();
    }


}
