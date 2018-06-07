package com.fossil;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;

@TargetApi(23)
class em {
    public static String permissionToOp(String str) {
        return AppOpsManager.permissionToOp(str);
    }

    public static int m10871a(Context context, String str, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }
}
