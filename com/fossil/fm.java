package com.fossil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

@TargetApi(16)
class fm {
    public static Intent m11444g(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static boolean m11442a(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }

    public static void m11443b(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }

    public static String m11441a(ActivityInfo activityInfo) {
        return activityInfo.parentActivityName;
    }
}
