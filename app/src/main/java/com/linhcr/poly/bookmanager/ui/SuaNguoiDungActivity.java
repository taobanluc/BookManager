package com.linhcr.poly.bookmanager.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.linhcr.poly.bookmanager.R;
import com.linhcr.poly.bookmanager.adapter.UserAdapter;
import com.linhcr.poly.bookmanager.database.DatabaseHelper;
import com.linhcr.poly.bookmanager.databasedao.UserDAO;
import com.linhcr.poly.bookmanager.model.User;

import java.util.List;

public class SuaNguoiDungActivity extends AppCompatActivity {
    private EditText edtEditUserName;
    private EditText edtEditName;
    private EditText edtEditSoDienThoai;
    private Button btnEditNguoiDung;
    private Button btnEditCancel;
    private DatabaseHelper databaseHelper;
    private UserDAO userDAO;
    private List<User> userList;
    private UserAdapter userAdapter;
    private int positon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        edtEditUserName = (EditText) findViewById(R.id.edtEditUserName);
        edtEditName = (EditText) findViewById(R.id.edtEditName);
        edtEditSoDienThoai = (EditText) findViewById(R.id.edtEditSoDienThoai);
        btnEditNguoiDung = (Button) findViewById(R.id.btnEditNguoiDung);
        btnEditCancel = (Button) findViewById(R.id.btnEditCancel);


        databaseHelper = new DatabaseHelper(this);
        userDAO = new UserDAO(databaseHelper);
        userList = userDAO.getAllUser();
        userAdapter = new UserAdapter(this, R.layout.item_nguoi_dung, userList);

        positon = getIntent().getIntExtra("position", -1);
        String Username = userList.get(positon).getUser_name();
        String Name = userList.get(positon).getName();
        String Phone = userList.get(positon).getPhone_number();
        edtEditUserName.setText(Username);
        edtEditName.setText(Name);
        edtEditSoDienThoai.setText(Phone);

        btnEditNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtEditName.getText().toString().trim();
                String phone = edtEditSoDienThoai.getText().toString().trim();
                User user = userList.get(positon);
                user.setName(name);
                user.setPhone_number(phone);
                userDAO.updateUser(user);
                userAdapter.notifyDataSetChanged();
            }
        });

        btnEditCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
