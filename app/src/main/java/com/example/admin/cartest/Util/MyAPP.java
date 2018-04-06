package com.example.admin.cartest.Util;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by admin on 2018/4/5.
 */

public class MyAPP extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
