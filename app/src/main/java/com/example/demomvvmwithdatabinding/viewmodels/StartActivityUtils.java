package com.example.demomvvmwithdatabinding.viewmodels;

import android.app.Activity;
import android.content.Intent;

import com.example.demomvvmwithdatabinding.R;


public class StartActivityUtils {

    /***
     * start activity  with top up animation
     ***/
    public static void doStartActivityWithBottomToTopAnimation(Activity activity, Class cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }

    /***
     * start activity  with top up animation with intent
     ***/
    public static void doStartActivityWithBottomToTopAnimationWithIntent(Activity activity, Intent intent) {
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }





}
