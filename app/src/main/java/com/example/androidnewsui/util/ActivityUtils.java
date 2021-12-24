package com.example.androidnewsui.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * android活动工具类
 */
public class ActivityUtils {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    /**
     * 一次性关闭所有活动
     */
    public static void finishAll(){
        for (Activity activity: activities) {
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
