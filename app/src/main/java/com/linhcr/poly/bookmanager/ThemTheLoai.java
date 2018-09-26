package com.linhcr.poly.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThemTheLoai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_the_loai);
    }

    public void ShowDanhSachTheLoai(View view) {
        Intent intent = new Intent(ThemTheLoai.this, QuanLiTheLoai.class);
        startActivity(intent);
    }

    public void CloseTheLoai(View view) {
        Intent intent = new Intent(ThemTheLoai.this, GiaoDienChinh.class);
        startActivity(intent);
    }
}
