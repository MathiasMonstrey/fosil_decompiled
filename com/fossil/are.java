package com.fossil;

import android.content.Context;
import com.fossil.ari.C1856a;
import java.io.File;

public class are {
    public static boolean m4276a(Context context, String str, String str2, String str3, String str4, String str5, C1856a c1856a) {
        String str6 = context.getFilesDir().getAbsolutePath() + "/" + str2 + "-" + str3 + "-" + str4;
        String str7 = str6 + "/" + str5 + ".webp";
        if (!cF(str7)) {
            str6 = str6 + "/" + str5 + ".png";
            if (!cF(str6)) {
                return false;
            }
            if (c1856a == null) {
                return true;
            }
            c1856a.mo1879C(str, str6);
            return true;
        } else if (c1856a == null) {
            return true;
        } else {
            c1856a.mo1879C(str, str7);
            return true;
        }
    }

    public static boolean cF(String str) {
        return new File(str).exists();
    }
}
