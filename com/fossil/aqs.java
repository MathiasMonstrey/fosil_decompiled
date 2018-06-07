package com.fossil;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public final class aqs {
    private static final String aWB = aqs.class.getSimpleName();

    public static String m4244Y(Context context) {
        PackageInfo Z = m4245Z(context);
        if (Z == null || Z.packageName == null) {
            return "";
        }
        return Z.packageName;
    }

    private static PackageInfo m4245Z(Context context) {
        PackageInfo packageInfo = null;
        if (context != null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (NameNotFoundException e) {
                app.m4181w(aWB, "Cannot find package info for package: " + context.getPackageName());
            }
        }
        return packageInfo;
    }

    public static String aa(Context context) {
        PackageInfo Z = m4245Z(context);
        if (Z == null || Z.versionName == null) {
            return "";
        }
        return Z.versionName;
    }
}
