package com.example.mindmattersapp.models;

public class UserModel {
    String fullname;
    String pwd;

    public UserModel(String fullname, String pwd) {
        this.fullname = fullname;
        this.pwd = pwd;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
