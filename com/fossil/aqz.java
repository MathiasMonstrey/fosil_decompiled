package com.fossil;

import android.text.TextUtils;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

public final class aqz {
    private static final Pattern bbm = Pattern.compile("/");

    private static URI cD(String str) {
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public static boolean cE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        URI cD = cD(str);
        if (cD == null) {
            return false;
        }
        if (cD.getScheme() == null || "http".equalsIgnoreCase(cD.getScheme()) || UpPlatformSdkConstants.URI_SCHEME.equalsIgnoreCase(cD.getScheme())) {
            return true;
        }
        return false;
    }

    public static String m4258A(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (!(new URI(str).isAbsolute() || TextUtils.isEmpty(str2))) {
                    URI uri = new URI(str2);
                    str = uri.getScheme() + "://" + uri.getHost() + str;
                }
            } catch (Exception e) {
            }
        }
        return str;
    }
}
