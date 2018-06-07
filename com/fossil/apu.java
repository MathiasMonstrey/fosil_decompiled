package com.fossil;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class apu {
    private final Pattern bbm = Pattern.compile(".*?(%\\{\\w+\\}).*?");

    public final String m3963a(String str) {
        Matcher matcher = this.bbm.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    public static boolean m3962z(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals("%{" + str + "}");
    }
}
