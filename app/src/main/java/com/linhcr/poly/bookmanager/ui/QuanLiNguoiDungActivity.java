package com.linhcr.poly.bookmanager.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.linhcr.poly.bookmanager.R;
import com.linhcr.poly.bookmanager.adapter.UserAdapter;
import com.linhcr.poly.bookmanager.database.DatabaseHelperUser;
import com.linhcr.poly.bookmanager.model.User;

import java.util.List;

public class QuanLiNguoiDungActivity extends AppCompatActivity {
    private ListView lvQuanLiNguoiDung;
    private List<User> userList;
    private UserAdapter userAdapter;
    private DatabaseHelperUser databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li_nguoi_dung);

        lvQuanLiNguoiDung = (ListView) findViewById(R.id.lvQuanLiNguoiDung);
        databaseHelper = new DatabaseHelperUser(this);
        userList = databaseHelper.getAllUser();

        userAdapter = new UserAdapter(this,R.layout.item_nguoi_dung,userList);
        lvQuanLiNguoiDung.setAdapter(userAdapter);
    }
}
