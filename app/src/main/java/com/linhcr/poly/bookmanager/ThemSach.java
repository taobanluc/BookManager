package com.linhcr.poly.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThemSach extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sach);
    }

    public void ShowDanhSachSach(View view) {
        Intent intent = new Intent(ThemSach.this, QuanLiSach.class);
        startActivity(intent);
    }

    public void CloseSach(View view) {
        Intent intent = new Intent(ThemSach.this, GiaoDienChinh.class);
        startActivity(intent);
    }
}