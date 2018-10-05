package com.linhcr.poly.bookmanager.databasedao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.linhcr.poly.bookmanager.Constant;
import com.linhcr.poly.bookmanager.database.DatabaseHelper;
import com.linhcr.poly.bookmanager.model.Bill;

import java.util.ArrayList;
import java.util.List;

public class BillDAO implements Constant {
    private SQLiteDatabase db;
    private DatabaseHelper databaseHelper;

    public BillDAO(SQLiteDatabase db, DatabaseHelper databaseHelper) {
        this.db = db;
        this.databaseHelper = databaseHelper;
    }

    public long insertBill(Bill bill){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(B_ID,bill.billId);
        contentValues.put(B_DATE, bill.date);
        long result = sqLiteDatabase.insert(TABLE_BILL,null,contentValues);
        return result;
    }

    public long updateBill(Bill bill){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(B_ID, bill.getBillId());
        contentValues.put(B_DATE, bill.getDate());

        return db.update(TABLE_BILL, contentValues, B_ID + "?",
                new String[]{String.valueOf(bill.getBillId())});
    }

    public void deleteBill(Bill bill){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.delete(TABLE_NAME, B_ID + "?",
                new String[]{String.valueOf(bill.getBillId())});
    db.close();
    }

    public Bill getBill(String id){
        Bill bill = null;
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BILL, new String[]{B_ID, B_DATE},
                B_ID + "=?", new String[]{id}, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()){
            String bill_id = cursor.getString(cursor.getColumnIndex(B_ID));
            long date = cursor.getLong(cursor.getColumnIndex(B_DATE));

            bill = new Bill(bill_id,date);
        }
        cursor.close();

        return bill;
    }

    public List<Bill> getAllBills(){
        List<Bill> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_BILL;
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Bill bill = new Bill();
                bill.setBillId(cursor.getString(cursor.getColumnIndex(B_ID)));
                bill.setDate(cursor.getLong(cursor.getColumnIndex(B_DATE)));
                list.add(bill);
            }while (cursor.moveToNext());
        }
        db.close();
        return list;
    }



}
