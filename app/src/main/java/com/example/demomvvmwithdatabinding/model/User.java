package com.example.demomvvmwithdatabinding.model;

import android.text.TextUtils;
import android.util.Patterns;


public class User {

    private String userEmail;
    private String userPassword;

    public String getUserEmail() {
        return userEmail;
    }

    public User() { }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public User(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }



    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int isInputDataValid() {
        if (TextUtils.isEmpty(getUserEmail()))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches())
            return 1;
        else if (TextUtils.isEmpty(getUserPassword()))
            return 2;
        else if (getUserPassword().length()<=6 )
            return 3;
        else
            return -1;
    }

}
