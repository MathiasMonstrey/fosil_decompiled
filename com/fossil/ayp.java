package com.fossil;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public class ayp {
    private static ayp bjC;
    private final Context mContext;

    private ayp(Context context) {
        this.mContext = context.getApplicationContext();
    }

    static ayg m4698a(PackageInfo packageInfo, ayg... com_fossil_aygArr) {
        int i = 0;
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        ayh com_fossil_ayh = new ayh(packageInfo.signatures[0].toByteArray());
        while (i < com_fossil_aygArr.length) {
            if (com_fossil_aygArr[i].equals(com_fossil_ayh)) {
                return com_fossil_aygArr[i];
            }
            i++;
        }
        return null;
    }

    private static boolean m4699a(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            ayg a;
            if (z) {
                a = m4698a(packageInfo, ayj.bjs);
            } else {
                a = m4698a(packageInfo, ayj.bjs[0]);
            }
            if (a != null) {
                return true;
            }
        }
        return false;
    }

    public static ayp aA(Context context) {
        awa.bO(context);
        synchronized (ayp.class) {
            if (bjC == null) {
                ayf.ay(context);
                bjC = new ayp(context);
            }
        }
        return bjC;
    }

    private static boolean m4700b(PackageInfo packageInfo, boolean z) {
        boolean z2 = false;
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
        } else {
            ayg com_fossil_ayh = new ayh(packageInfo.signatures[0].toByteArray());
            String str = packageInfo.packageName;
            z2 = z ? ayf.m4696b(str, com_fossil_ayh) : ayf.m4694a(str, com_fossil_ayh);
            if (!z2) {
                Log.d("GoogleSignatureVerifier", "Cert not in list. atk=" + z);
            }
        }
        return z2;
    }

    private final boolean dl(String str) {
        try {
            PackageInfo packageInfo = bje.aQ(this.mContext).getPackageInfo(str, 64);
            if (packageInfo == null) {
                return false;
            }
            if (ayo.az(this.mContext)) {
                return m4700b(packageInfo, true);
            }
            boolean b = m4700b(packageInfo, false);
            if (!b && m4700b(packageInfo, true)) {
                Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
            }
            return b;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    @Deprecated
    public final boolean m4701a(PackageManager packageManager, int i) {
        String[] packagesForUid = bje.aQ(this.mContext).getPackagesForUid(i);
        if (packagesForUid == null || packagesForUid.length == 0) {
            return false;
        }
        for (String dl : packagesForUid) {
            if (dl(dl)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public final boolean m4702a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo != null) {
            if (m4699a(packageInfo, false)) {
                return true;
            }
            if (m4699a(packageInfo, true)) {
                if (ayo.az(this.mContext)) {
                    return true;
                }
                Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
            }
        }
        return false;
    }
}
