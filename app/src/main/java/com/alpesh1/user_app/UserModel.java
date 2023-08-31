package com.alpesh1.user_app;

public class UserModel {

    public String key,title,date,des,content;

    public UserModel() {

    }

    public UserModel(String key, String title, String date, String des, String content) {
        this.key = key;
        this.title = title;
        this.date = date;
        this.des = des;
        this.content = content;
    }
}
