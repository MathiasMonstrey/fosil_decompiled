package com.fossil;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class ks {
    static final C3806d RC;

    interface C3806d {
        int mo3297c(MotionEvent motionEvent);

        float mo3298f(MotionEvent motionEvent, int i);
    }

    static class C3807a implements C3806d {
        C3807a() {
        }

        public float mo3298f(MotionEvent motionEvent, int i) {
            return 0.0f;
        }

        public int mo3297c(MotionEvent motionEvent) {
            return 0;
        }
    }

    static class C3808b extends C3807a {
        C3808b() {
        }

        public float mo3298f(MotionEvent motionEvent, int i) {
            return kt.m12051f(motionEvent, i);
        }
    }

    static class C3809c extends C3808b {
        C3809c() {
        }

        public int mo3297c(MotionEvent motionEvent) {
            return ku.m12052c(motionEvent);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            RC = new C3809c();
        } else if (VERSION.SDK_INT >= 12) {
            RC = new C3808b();
        } else {
            RC = new C3807a();
        }
    }

    public static int m12043a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m12044b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    @Deprecated
    public static int m12045b(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    @Deprecated
    public static int m12047c(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    @Deprecated
    public static float m12048d(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static boolean m12049e(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }

    public static float m12050f(MotionEvent motionEvent, int i) {
        return RC.mo3298f(motionEvent, i);
    }

    public static int m12046c(MotionEvent motionEvent) {
        return RC.mo3297c(motionEvent);
    }
}
