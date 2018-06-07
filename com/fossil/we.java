package com.fossil;

import android.net.Uri;

final class we {
    private static final int aDg = "file:///android_asset/".length();

    public static boolean m13980h(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    public static String m13981i(Uri uri) {
        return uri.toString().substring(aDg);
    }
}
