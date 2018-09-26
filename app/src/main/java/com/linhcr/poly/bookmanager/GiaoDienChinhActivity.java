package com.linhcr.poly.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GiaoDienChinhActivity extends AppCompatActivity {
    private ImageView imgNguoiDung;
    private ImageView imgTheLoai;
    private ImageView imgSach;
    private ImageView imgHoaDon;
    private ImageView imgSachBanChay;
    private ImageView imgThongKe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_dien_chinh);
        imgNguoiDung = (ImageView) findViewById(R.id.imgNguoiDung);
        imgTheLoai = (ImageView) findViewById(R.id.imgTheLoai);
        imgSach = (ImageView) findViewById(R.id.imgSach);
        imgHoaDon = (ImageView) findViewById(R.id.imgHoaDon);
        imgSachBanChay = (ImageView) findViewById(R.id.imgSachBanChay);
        imgThongKe = (ImageView) findViewById(R.id.imgThongKe);
    }


    public void ShowNguoiDung(View view) {

        Intent intent = new Intent(GiaoDienChinhActivity.this, ThemNguoiDungActivity.class);
        startActivity(intent);
    }


    public void ShowTheLoai(View view) {
        Intent intent = new Intent(GiaoDienChinhActivity.this, ThemTheLoaiActivity.class);
        startActivity(intent);
    }

    public void ShowSach(View view) {
        Intent intent = new Intent(GiaoDienChinhActivity.this, ThemSachActivity.class);
        startActivity(intent);
    }

    public void ShowThongKe(View view) {
    }

    public void ShowSachBanChay(View view) {
    }

    public void ShowHoaDon(View view) {
    }
}
