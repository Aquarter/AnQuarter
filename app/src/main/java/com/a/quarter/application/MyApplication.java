package com.a.quarter.application;

import android.app.Activity;
import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.mob.MobSDK;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by qizepu on 2017/7/17.
 */

public class MyApplication extends Application {

    private static MyApplication instance;
    private List<Activity> activitys;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        instance = this;
        init();
        //初始化xutils
        x.Ext.init(this);
        x.Ext.setDebug(true);
        MobSDK.init(this,"MobAppkey","MobAppsecret");
    }

    private void init() {
        activitys = new ArrayList<>();
    }

    public static synchronized MyApplication getInstance() {
        return instance;
    }

    /**
     * 添加activity
     */
    public void addActivity(Activity act) {
        if (activitys == null) {
            activitys.add(act);
        }
       
    }

    /**
     * 移除activity
     */
    public void removeActivity(Activity act) {
        if (activitys != null) {
            activitys.remove(act);
        }
    }

    /**
     * 退出app
     */
    public void exitApp() {
        if (activitys != null) {
            synchronized (activitys) {
                for (Activity act : activitys) {
                    act.finish();
                }
            }
        }
        System.exit(0);
    }


}
