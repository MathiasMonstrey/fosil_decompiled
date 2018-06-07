package com.fossil;

import android.content.Context;
import android.os.Process;

public final class gz {
    public static int m11539a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String permissionToOp = el.permissionToOp(str);
        if (permissionToOp == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return el.m10848a(context, permissionToOp, str2) != 0 ? -2 : 0;
    }

    public static int m11540b(Context context, String str) {
        return m11539a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
