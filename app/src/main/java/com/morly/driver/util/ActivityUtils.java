package com.morly.driver.util;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * Created by riven_chris on 2017/4/1.
 */

public class ActivityUtils {

    public static void finishAll() {

    }

    public static void finish(Context context, String componentName) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(Integer.MAX_VALUE);
        for (ActivityManager.RunningTaskInfo info : tasks) {

        }


        String runningActivity = activityManager.getRunningTasks(1).get(0).topActivity.getClassName();
    }
}
