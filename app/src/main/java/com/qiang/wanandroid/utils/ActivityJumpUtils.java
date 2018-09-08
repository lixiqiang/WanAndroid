package com.qiang.wanandroid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;


/**
 * @auther lixiqiang
 * @data：2018/9/8
 */
public class ActivityJumpUtils {


    public static void startActivity(Activity startActivity, Class toActivity) {
        startActivity(startActivity, toActivity, false);
    }

    public static void startActivity(Activity startActivity, Class toActivity, boolean isFinish) {
        Intent intent = new Intent(startActivity, toActivity);
        startActivity.startActivity(intent);
        if (isFinish) {
            startActivity.finish();
        }
        startActivity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }


}
