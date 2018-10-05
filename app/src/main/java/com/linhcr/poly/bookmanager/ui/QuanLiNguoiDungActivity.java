package com.linhcr.poly.bookmanager.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.linhcr.poly.bookmanager.R;
import com.linhcr.poly.bookmanager.adapter.UserAdapter;
import com.linhcr.poly.bookmanager.database.DatabaseHelper;
import com.linhcr.poly.bookmanager.databasedao.UserDAO;
import com.linhcr.poly.bookmanager.listener.onDelete;
import com.linhcr.poly.bookmanager.model.User;

import java.util.List;

public class QuanLiNguoiDungActivity extends AppCompatActivity {
    private ListView lvQuanLiNguoiDung;
    private List<User> userList;
    private UserAdapter userAdapter;
    private DatabaseHelper databaseHelper;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li_nguoi_dung);

        final User user = new User();

        lvQuanLiNguoiDung = (ListView) findViewById(R.id.lvQuanLiNguoiDung);
        databaseHelper = new DatabaseHelper(this);
        userDAO = new UserDAO(databaseHelper);
        userList = userDAO.getAllUser();

        userAdapter = new UserAdapter(this, R.layout.item_nguoi_dung, userList);
        lvQuanLiNguoiDung.setAdapter(userAdapter);

        lvQuanLiNguoiDung.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                CharSequence action[] = new CharSequence[]{"Sửa", "Xóa"};
                AlertDialog.Builder builder = new AlertDialog.Builder(QuanLiNguoiDungActivity.this);
                builder.setTitle("Chọn chức năng :");
                builder.setItems(action, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            Intent intent = new Intent(QuanLiNguoiDungActivity.this, SuaNguoiDungActivity.class);
                            intent.putExtra("position", position);
                            startActivity(intent);
                        } else {
                            AlertDialog.Builder aler = new AlertDialog.Builder(QuanLiNguoiDungActivity.this);
                            aler.setMessage("Bạn có chắc chắn xóa ?");
                            aler.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    userDAO.deleteUser(userList.get(position));
                                    userList.remove(position);
                                    Toast.makeText(QuanLiNguoiDungActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                                    userAdapter.notifyDataSetChanged();
                                }
                            });
                            aler.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            aler.show();
                        }
                    }
                });
                builder.show();
                return true;
            }
        });

    }

}


