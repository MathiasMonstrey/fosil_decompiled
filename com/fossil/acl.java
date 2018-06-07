package com.fossil;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class acl implements emz<String> {
    public /* synthetic */ Object mo812Q(Context context) throws Exception {
        return m2940O(context);
    }

    public String m2940O(Context context) throws Exception {
        long nanoTime = System.nanoTime();
        String str = "";
        ZipInputStream zipInputStream = null;
        try {
            zipInputStream = m2941P(context);
            str = m2943a(zipInputStream);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e) {
                    emm.aEU().mo2953g("Beta", "Failed to close the APK file", e);
                }
            }
        } catch (Throwable e2) {
            emm.aEU().mo2953g("Beta", "Failed to find this app in the PackageManager", e2);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e22) {
                    emm.aEU().mo2953g("Beta", "Failed to close the APK file", e22);
                }
            }
        } catch (Throwable e222) {
            emm.aEU().mo2953g("Beta", "Failed to find the APK file", e222);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e2222) {
                    emm.aEU().mo2953g("Beta", "Failed to close the APK file", e2222);
                }
            }
        } catch (Throwable e22222) {
            emm.aEU().mo2953g("Beta", "Failed to read the APK file", e22222);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e222222) {
                    emm.aEU().mo2953g("Beta", "Failed to close the APK file", e222222);
                }
            }
        } catch (Throwable th) {
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e2222222) {
                    emm.aEU().mo2953g("Beta", "Failed to close the APK file", e2222222);
                }
            }
        }
        emm.aEU().mo2950d("Beta", "Beta device token load took " + (((double) (System.nanoTime() - nanoTime)) / 1000000.0d) + "ms");
        return str;
    }

    ZipInputStream m2941P(Context context) throws NameNotFoundException, FileNotFoundException {
        return new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir));
    }

    String m2943a(ZipInputStream zipInputStream) throws IOException {
        String name;
        do {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return "";
            }
            name = nextEntry.getName();
        } while (!name.startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token="));
        return name.substring("assets/com.crashlytics.android.beta/dirfactor-device-token=".length(), name.length() - 1);
    }
}
