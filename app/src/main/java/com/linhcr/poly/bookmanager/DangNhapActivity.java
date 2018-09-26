package com.linhcr.poly.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.linhcr.poly.bookmanager.database.DatabaseHelperUser;
import com.linhcr.poly.bookmanager.model.User;

public class DangNhapActivity extends AppCompatActivity {
    private EditText edtUserName, edtPassWord;
    private Button btnSignIn;
    private CheckBox cbRememberPassword;
    private DatabaseHelperUser databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseHelper = new DatabaseHelperUser(this);
        initViews();



        User user = new User();
        user.setUser_name("linhcr123");
        user.setName("linh ");
        user.setPass_word("linhcr123");
        user.setPhone_number("01666271387");

        databaseHelper.insertUser(user);

        btnSignIn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtUserName.getText().toString().trim();
                String password = edtPassWord.getText().toString().trim();

                if (password.length() < 6 || userName.isEmpty() || password.isEmpty()) {
//                   isEmpty(): kiểm tra xem có trống ko
                    if (userName.isEmpty()) {
                        edtUserName.setError(getString(R.string.notify_empty_user_name));
                    }
                    if (password.isEmpty()) {
                        edtUserName.setError(getString(R.string.notify_empty_password2));
                    }
                    if (password.length() < 6) {
                        edtPassWord.setError(getString(R.string.notify_empty_password));
                    }
                } else {

                    User user = databaseHelper.getUser(userName);

                    if (user == null) {
                        Toast.makeText(DangNhapActivity.this, getString(R.string.notify_username_password),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        String passwordData = user.getPass_word();

                        if (passwordData.equals(password)) {
                            Intent cc = new Intent(DangNhapActivity.this, GiaoDienChinhActivity.class);
                            startActivity(cc);
                            finish();
                        }else {
                            Toast.makeText(DangNhapActivity.this,getString(R.string.notify_username_password), Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            }
        });
    }

    public void initViews() {
        edtUserName = findViewById(R.id.edtUserNameLogin);
        edtPassWord = findViewById(R.id.edtPasswordLogin);
        cbRememberPassword = findViewById(R.id.cbRememberPassword);
        btnSignIn = findViewById(R.id.btnSignin);
    }


//                Intent intent = new Intent(DangNhapActivity.this, GiaoDienChinhActivity.class);
//                startActivity(intent);
            }


