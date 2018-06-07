package com.fossil;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class abb {
    private static final ConcurrentHashMap<String, ul> aGQ = new ConcurrentHashMap();

    public static ul m2851K(Context context) {
        String packageName = context.getPackageName();
        ul ulVar = (ul) aGQ.get(packageName);
        if (ulVar != null) {
            return ulVar;
        }
        ul L = m2852L(context);
        ulVar = (ul) aGQ.putIfAbsent(packageName, L);
        if (ulVar == null) {
            return L;
        }
        return ulVar;
    }

    private static ul m2852L(Context context) {
        PackageInfo packageInfo;
        String valueOf;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            valueOf = String.valueOf(packageInfo.versionCode);
        } else {
            valueOf = UUID.randomUUID().toString();
        }
        return new abd(valueOf);
    }
}
