package com.linhcr.poly.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.linhcr.poly.bookmanager.model.User;

import java.util.List;

public class ThemNguoiDung extends AppCompatActivity {
    private List<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nguoi_dung);
        final ThemNguoiDung themNguoiDung = new ThemNguoiDung();
    }

    public void CloseNguoiDung(View view) {
        Intent intent = new Intent(ThemNguoiDung.this, GiaoDienChinh.class);
        startActivity(intent);
    }

    public void ShowDanhSachNguoiDung(View view) {
        Intent intent = new Intent(ThemNguoiDung.this, QuanLiNguoiDung.class);
        startActivity(intent);
    }

    public void AddNguoidung(View view) {

    }
}
