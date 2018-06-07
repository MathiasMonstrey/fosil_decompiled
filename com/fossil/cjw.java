package com.fossil;

import android.os.Build;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class cjw {
    private static cjw cmy = null;
    private final String TAG = cjw.class.getName();
    private ExecutorService aIj;
    private final int cmz = 5;

    public static cjw ZP() {
        if (cmy == null) {
            cmy = new cjw();
        }
        return cmy;
    }

    private cjw() {
        int i = 5;
        if (Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
            i = 1;
        }
        this.aIj = Executors.newFixedThreadPool(i);
    }

    public static void init() {
        cmy = new cjw();
    }

    public void m6836l(Runnable runnable) {
        try {
            this.aIj.submit(runnable);
        } catch (Exception e) {
            MFLogger.m12670d(this.TAG, "Error in " + this.TAG + " .submit method with error: " + e);
        }
    }
}
