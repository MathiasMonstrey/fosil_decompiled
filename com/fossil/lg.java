package com.fossil;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class lg {
    static final C3815c St;

    interface C3815c {
        float mo3300a(VelocityTracker velocityTracker, int i);

        float mo3301b(VelocityTracker velocityTracker, int i);
    }

    static class C3816a implements C3815c {
        C3816a() {
        }

        public float mo3300a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        public float mo3301b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    static class C3817b implements C3815c {
        C3817b() {
        }

        public float mo3300a(VelocityTracker velocityTracker, int i) {
            return lh.m12077a(velocityTracker, i);
        }

        public float mo3301b(VelocityTracker velocityTracker, int i) {
            return lh.m12078b(velocityTracker, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            St = new C3817b();
        } else {
            St = new C3816a();
        }
    }

    public static float m12075a(VelocityTracker velocityTracker, int i) {
        return St.mo3300a(velocityTracker, i);
    }

    public static float m12076b(VelocityTracker velocityTracker, int i) {
        return St.mo3301b(velocityTracker, i);
    }
}
