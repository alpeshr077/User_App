package com.alpesh1.user_app;

public class UserModel {

    public String key,title,date,des,content,UploadImages;

    public UserModel() {

    }

    public UserModel(String key, String title, String date, String des, String content, String UploadImages) {
        this.key = key;
        this.title = title;
        this.date = date;
        this.des = des;
        this.content = content;
        this.UploadImages = UploadImages;
    }

}
