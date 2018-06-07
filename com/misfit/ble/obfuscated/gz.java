package com.misfit.ble.obfuscated;

import android.content.Context;
import java.io.File;

public class gz {
    public static boolean m15151a(byte[] bArr, String str, String str2) {
        Context applicationContext = C4592s.getApplicationContext();
        if (applicationContext == null) {
            return false;
        }
        return hd.m15179a(bArr, new File(applicationContext.getDir(str, 0), str2));
    }

    public static boolean m15150a(String str, String str2, String str3) {
        Context applicationContext = C4592s.getApplicationContext();
        if (applicationContext == null) {
            return false;
        }
        return hd.m15178a(str, new File(applicationContext.getDir(str2, 0), str3));
    }

    public static byte[] m15152h(String str, String str2) {
        Context applicationContext = C4592s.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return hd.m15184f(new File(applicationContext.getDir(str, 0), str2));
    }

    public static File[] m15148G(String str) {
        Context applicationContext = C4592s.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getDir(str, 0).listFiles();
    }

    public static File m15153i(String str, String str2) {
        Context applicationContext = C4592s.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return new File(applicationContext.getDir(str, 0), str2);
    }

    public static boolean m15154j(String str, String str2) {
        Context applicationContext = C4592s.getApplicationContext();
        if (applicationContext == null) {
            return false;
        }
        return hd.m15178a(str, new File(applicationContext.getCacheDir(), str2));
    }

    public static String m15149H(String str) {
        Context applicationContext = C4592s.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return hd.m15182e(new File(applicationContext.getCacheDir(), str));
    }
}
