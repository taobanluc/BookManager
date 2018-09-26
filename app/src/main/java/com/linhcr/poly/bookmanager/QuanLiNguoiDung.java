package com.linhcr.poly.bookmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.linhcr.poly.bookmanager.adapter.CustomAdapterUser;
import com.linhcr.poly.bookmanager.database.DatabaseHelper;
import com.linhcr.poly.bookmanager.model.User;

import java.util.List;

public class QuanLiNguoiDung extends AppCompatActivity {
    private ListView lvQuanLiNguoiDung;
    private List<User> userList;
    private CustomAdapterUser customAdapterUser;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li_nguoi_dung);

        lvQuanLiNguoiDung = (ListView) findViewById(R.id.lvQuanLiNguoiDung);
        databaseHelper = new DatabaseHelper(this);
        userList = databaseHelper.getAllUser();

        customAdapterUser = new CustomAdapterUser(this,R.layout.item_nguoi_dung,userList);
        lvQuanLiNguoiDung.setAdapter(customAdapterUser);
    }
}
