package com.fossil;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.concurrent.atomic.AtomicInteger;

public class bbp {
    public static int bpj = 5000000;
    private static int bpk = 6500000;
    private static int bpl = 7000000;
    private static final AtomicInteger bpm = new AtomicInteger(1);

    public static int aG(Context context) {
        String aK = bcd.aK(context);
        if (aK != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(aK, 0);
                if (packageInfo != null) {
                    return packageInfo.versionCode;
                }
            } catch (NameNotFoundException e) {
            }
        }
        return -1;
    }
}
