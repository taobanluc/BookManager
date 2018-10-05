package com.linhcr.poly.bookmanager;

public interface Constant {

    boolean isDEBUG = true;

//    USER TABLE
    String TABLE_NAME = "users";
    String COLUMN_USER_NAME = "user_name";
    String COLUMN_NAME = "name";
    String COLUMN_PHONE = "phone";
    String COLUMN_PASSWORD = "password";


    String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_USER_NAME + " NVARCHAR PRIMARY KEY,"
            + COLUMN_PASSWORD + " NVARCHAR,"
            + COLUMN_NAME + " NVARCHAR,"
            + COLUMN_PHONE + " NVARCHAR"
            +")";


// TYPE BOOK TABLE

    //    Create typebook (MaTheLoai CHAR(5) PRIMARY KEY NOT NULL,
//    TypeNAME NVARCHAR(50) NOT NULL,
//    Description NVARCHAR(255),
//    Position INT
//    )

    String TYPE_BOOK_TABLE = "TypeBook";
    String TB_COLUMN_TYPE_BOOK_ID = "MaTheLoai";
    String TB_COLUMN_TYPE_NAME = "TypeName";
    String TB_COLUMN_DESCRIPTION = "Description";
    String TB_COLUMN_POSITION = "Position";



    String CREATE_TYPE_BOOK_TABLE = "CREATE TABLE " + TYPE_BOOK_TABLE + "("
            + TB_COLUMN_TYPE_BOOK_ID + " CHAR(5) PRIMARY KEY NOT NULL,"
            + TB_COLUMN_TYPE_NAME + " NVARCHAR(50) NOT NULL,"
            + TB_COLUMN_DESCRIPTION + " NVARCHAR(255),"
            + TB_COLUMN_POSITION + "INT"
            +")";


    // BOOK TABLE

    String CREATE_BOOK_TABLE = "";


//    Bill DB
    String TABLE_BILL = "HoaDon";
    String B_ID = "MaHoaDon";
    String B_DATE = "NgayMua";

    String CREATE_BILL_TABLE = "CREATE TABLE" + TABLE_BILL +"("
            + B_ID + " NCHAR(7) PRIMARY KEY,"
            + B_DATE + " FLOAT NOT NULL"
            + ")";

}
