package com.fossil;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;

public class dsi {
    private static final String TAG = dsi.class.getName();

    public static boolean m9619H(Context context, String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        try {
            return m9620a(context.getPackageManager().getPackageInfo(str, 64).signatures, "18da2bf10352443a00a5e046d9fca6bd");
        } catch (NameNotFoundException e) {
            return z;
        }
    }

    private static boolean m9620a(Signature[] signatureArr, String str) {
        if (signatureArr == null || str == null) {
            return false;
        }
        for (Signature toByteArray : signatureArr) {
            if (str.equals(duk.aq(toByteArray.toByteArray()))) {
                duj.m9769d(TAG, "check pass");
                return true;
            }
        }
        return false;
    }
}
