package com.huaijie.android_hacks.ui.activity;

import android.app.Activity;

/**
 * Created by fenghb on 2014/4/30.
 */
public class ActivityInfo {
    private String title;
    private Class clazz;

    public ActivityInfo(String title, Class clazz) {
        this.title = title;
        this.clazz = clazz;
    }

    public String getTitle() {
        return title;
    }

    public Class<Activity> getClazz() {
        return clazz;
    }
}
