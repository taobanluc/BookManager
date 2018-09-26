package com.linhcr.poly.bookmanager.model;

public class User {

    String user_name;
    String name;
    String phone_number;
    String pass_word;




    public User(String user_name, String name, String phone_number, String pass_word) {
        this.user_name = user_name;
        this.name = name;
        this.phone_number = phone_number;
        this.pass_word = pass_word;
    }

    public User(String name, String phone_number, String pass_word) {
        this.name = name;
        this.phone_number = phone_number;
        this.pass_word = pass_word;
    }

    public User(){

    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }
}
