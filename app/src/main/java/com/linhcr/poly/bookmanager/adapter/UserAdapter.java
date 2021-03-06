package com.linhcr.poly.bookmanager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.linhcr.poly.bookmanager.R;
import com.linhcr.poly.bookmanager.listener.onDelete;
import com.linhcr.poly.bookmanager.model.User;
import com.linhcr.poly.bookmanager.ui.QuanLiNguoiDungActivity;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    private Context context;
    private int resource;
    private List<User> listUser;

    public UserAdapter(@NonNull Context context, int resource, List<User> listUser) {
        super(context, resource, listUser);
        this.context = context;
        this.resource = resource;
        this.listUser = listUser;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_nguoi_dung, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = convertView.findViewById(R.id.tvname_item_user);
            viewHolder.tvPhone = convertView.findViewById(R.id.tvphone_item_user);


            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        User user = listUser.get(position);
        viewHolder.tvPhone.setText(user.getName());
        viewHolder.tvName.setText(user.getPhone_number());
            return convertView;
    }


    public class ViewHolder {
        private TextView tvUserName;
        private TextView tvName;
        private TextView tvPassword;
        private TextView tvPhone;


    }
}
