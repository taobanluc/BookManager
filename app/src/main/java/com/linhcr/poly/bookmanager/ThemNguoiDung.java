package com.linhcr.poly.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.linhcr.poly.bookmanager.database.DatabaseHelper;
import com.linhcr.poly.bookmanager.model.User;

import java.util.List;

public class ThemNguoiDung extends AppCompatActivity {
    private List<User> list;
    private DatabaseHelper databaseHelper;
    private EditText edtAddUserName;
    private EditText edtAddPassword;
    private EditText edtAddName;
    private EditText edtAddSoDienThoai;
    private Button btnThemNguoiDung;
    private Button btnHuyNguoiDung;
    private Button btnDanhSachNguoiDung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nguoi_dung);
        databaseHelper = new DatabaseHelper(this);
        intiView();
        initActions();

    }

    public void CloseNguoiDung(View view) {
        Intent intent = new Intent(ThemNguoiDung.this, GiaoDienChinh.class);
        startActivity(intent);
    }

    public void ShowDanhSachNguoiDung(View view) {
        Intent intent = new Intent(ThemNguoiDung.this, QuanLiNguoiDung.class);
        startActivity(intent);
    }


    public void intiView(){
        edtAddUserName = findViewById(R.id.edtAddUserName);
        edtAddPassword = findViewById(R.id.edtAddPassword);
        edtAddName = findViewById(R.id.edtAddName);
        edtAddSoDienThoai = findViewById(R.id.edtAddSoDienThoai);
        btnThemNguoiDung = findViewById(R.id.btnThemNguoiDung);
        btnHuyNguoiDung = findViewById(R.id.btnHuyNguoiDung);
        btnDanhSachNguoiDung = findViewById(R.id.btnDanhSachNguoiDung);
    }

    public void initActions(){
        btnThemNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtAddUserName.getText().toString().trim();
                String password = edtAddPassword.getText().toString().trim();
                String name = edtAddName.getText().toString().trim();
                String phone = edtAddSoDienThoai.getText().toString().trim();

                User user = databaseHelper.getUser(userName);

                if (user != null) {
                    Toast.makeText(ThemNguoiDung.this, getString(R.string.da_ton_tai),
                            Toast.LENGTH_SHORT).show();
                } else{
                    User user1 = new User();
                    user1.setUser_name(userName);
                    user1.setPass_word(password);
                    user1.setName(name);
                    user1.setPhone_number(phone);

                    databaseHelper.insertUser(user1);

                    Toast.makeText(ThemNguoiDung.this, "Đã thêm người dùng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
