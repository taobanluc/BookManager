package com.linhcr.poly.bookmanager.databasedao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.linhcr.poly.bookmanager.Constant;
import com.linhcr.poly.bookmanager.database.DatabaseHelper;
import com.linhcr.poly.bookmanager.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO implements Constant {
    DatabaseHelper databaseHelper;

    public UserDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public long insertUser(User user) {
        // ghi dữ liệu vào cơ sở dữ liệu
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
//        Chứa dữ liệu cần chuyền vào database
        values.put(COLUMN_USER_NAME, user.getUser_name());
        values.put(COLUMN_PASSWORD, user.getPass_word());
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_PHONE, user.getPhone_number());


        // insert vào hàng
        long id = db.insert(TABLE_NAME, null, values);
        Log.e("Xong", String.valueOf(id));

        // đóng
        db.close();

        // return newly inserted row id
        return id;
    }



    public User getUser(String username) {
//        Lấy giữ liệu người dùng
        User user = null;

        SQLiteDatabase db = databaseHelper.getReadableDatabase();
// Lấy cơ sở dữ liệu có thể đọc từ Database

//        Cursor để nhận dữ liệu truy vấn từ database
        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_USER_NAME, COLUMN_PASSWORD, COLUMN_NAME, COLUMN_PHONE},
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


    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
//        Lấy cơ sở dữ liệu có thể ghi vào Database
        Cursor cursor = db.rawQuery(selectQuery, null);
//      lặp qua tất cả các hàng và thêm chúng vào danh sách
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setUser_name(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setPass_word(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                user.setPhone_number(cursor.getString(cursor.getColumnIndex(COLUMN_PHONE)));


                userList.add(user);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return userList;
    }

    public int updateUser(User user) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
//        Lấy cơ sở dữ liệu có thể ghi vào Database
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getUser_name());
        values.put(COLUMN_PASSWORD, user.getPass_word());
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_PHONE, user.getPhone_number());


        // updating hàng
        return db.update(TABLE_NAME, values, COLUMN_USER_NAME + " = ?",
                new String[]{String.valueOf(user.getUser_name())});

    }

    public void deleteUser(User user) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_USER_NAME + " = ?",
                new String[]{String.valueOf(user.getUser_name())});
        db.close();
    }
}
