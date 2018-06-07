package com.fossil;

import android.annotation.TargetApi;
import android.view.VelocityTracker;

@TargetApi(11)
class lh {
    public static float m12077a(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getXVelocity(i);
    }

    public static float m12078b(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getYVelocity(i);
    }
}
