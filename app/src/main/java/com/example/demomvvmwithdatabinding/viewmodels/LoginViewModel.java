package com.example.demomvvmwithdatabinding.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.example.demomvvmwithdatabinding.interfaces.LoginResultCallBack;
import com.example.demomvvmwithdatabinding.model.User;


public class LoginViewModel extends BaseObservable {
    private User user;
    private LoginResultCallBack loginResultCallBack;

    public LoginViewModel(LoginResultCallBack loginResultCallBack) {
        this.loginResultCallBack = loginResultCallBack;
        this.user=new User();
    }

    public void setUserEmail(String email) {
        user.setUserEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserEmail() {
        return user.getUserEmail();
    }

    @Bindable
    public String getUserPassword() {
        return user.getUserPassword();
    }

    public void setUserPassword(String password) {
        user.setUserPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    // on click of Login button

    public void onClickLoginBtn(View view){
        int errorCode = user.isInputDataValid();
        if (errorCode ==0 )
            loginResultCallBack.onError("Enter Email");
        else if (errorCode==1)
            loginResultCallBack.onError("Enter a valid Email");
        else if (errorCode == 2)
            loginResultCallBack.onError("Enter your password ");
        else if (errorCode == 3)
            loginResultCallBack.onError("Enter your password at least in 7 characters");
        else
            loginResultCallBack.onSuccess("Login success");

    }
}
