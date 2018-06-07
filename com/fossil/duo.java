package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.fossil.dsk.C3178a;

public class duo {
    public static boolean m9788j(Context context, Intent intent) {
        boolean z = false;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, z);
            if (resolveActivity != null) {
                try {
                    z = m9787a(packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures, "18da2bf10352443a00a5e046d9fca6bd");
                } catch (NameNotFoundException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return z;
    }

    public static boolean m9786a(Context context, C3178a c3178a, Intent intent) {
        if ((c3178a != null && c3178a.awv() <= 10352) || c3178a == null) {
            return true;
        }
        String stringExtra = intent != null ? intent.getStringExtra("_weibo_appPackage") : null;
        if (stringExtra == null || intent.getStringExtra("_weibo_transaction") == null || !dsi.m9619H(context, stringExtra)) {
            return false;
        }
        return true;
    }

    public static boolean m9787a(Signature[] signatureArr, String str) {
        if (signatureArr == null || str == null) {
            return false;
        }
        for (Signature toByteArray : signatureArr) {
            if (str.equals(duk.aq(toByteArray.toByteArray()))) {
                return true;
            }
        }
        return false;
    }
}
