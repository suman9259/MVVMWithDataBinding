package com.example.demomvvmwithdatabinding.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.demomvvmwithdatabinding.R;
import com.example.demomvvmwithdatabinding.databinding.ActivityMainBinding;
import com.example.demomvvmwithdatabinding.interfaces.LoginResultCallBack;
import com.example.demomvvmwithdatabinding.viewmodels.LoginViewModel;
import com.example.demomvvmwithdatabinding.viewmodels.StartActivityUtils;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginResultCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setLoginViewModel(new LoginViewModel(this));
        activityMainBinding.executePendingBindings();
    }

    @Override
    public void onSuccess(String msg) {
        Toasty.success(this,msg, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this,NewActivity.class);
        StartActivityUtils.doStartActivityWithBottomToTopAnimationWithIntent(this,intent);

    }

    @Override
    public void onError(String msg) {
        Toasty.error(this,msg, Toast.LENGTH_LONG).show();
    }
}
