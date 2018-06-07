package com.fossil;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.Process;

public final class bjd {
    private Context mContext;

    public bjd(Context context) {
        this.mContext = context;
    }

    public final boolean OG() {
        return Binder.getCallingUid() == Process.myUid() ? bjc.aO(this.mContext) : false;
    }

    public final int checkCallingOrSelfPermission(String str) {
        return this.mContext.checkCallingOrSelfPermission(str);
    }

    public final CharSequence dL(String str) throws NameNotFoundException {
        return this.mContext.getPackageManager().getApplicationLabel(this.mContext.getPackageManager().getApplicationInfo(str, 0));
    }

    public final ApplicationInfo getApplicationInfo(String str, int i) throws NameNotFoundException {
        return this.mContext.getPackageManager().getApplicationInfo(str, i);
    }

    public final PackageInfo getPackageInfo(String str, int i) throws NameNotFoundException {
        return this.mContext.getPackageManager().getPackageInfo(str, i);
    }

    public final String[] getPackagesForUid(int i) {
        return this.mContext.getPackageManager().getPackagesForUid(i);
    }

    @TargetApi(19)
    public final boolean m5225l(int i, String str) {
        if (axt.LH()) {
            try {
                ((AppOpsManager) this.mContext.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = this.mContext.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }
}
