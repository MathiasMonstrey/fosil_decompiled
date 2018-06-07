package com.fossil;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.fossil.duh.C3207a;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;

public class duq {
    public static Bundle kr(String str) {
        try {
            URL url = new URL(str);
            Bundle kt = kt(url.getQuery());
            kt.putAll(kt(url.getRef()));
            return kt;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    public static Bundle ks(String str) {
        try {
            return kt(new URI(str).getQuery());
        } catch (Exception e) {
            return new Bundle();
        }
    }

    public static Bundle kt(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split(SimpleComparison.EQUAL_TO_OPERATION);
                try {
                    bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }

    public static String m9791T(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            for (Signature toByteArray : packageInfo.signatures) {
                byte[] toByteArray2 = toByteArray.toByteArray();
                if (toByteArray2 != null) {
                    return duk.aq(toByteArray2);
                }
            }
            return null;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static String m9792U(Context context, String str) {
        C3207a kj = duh.cP(context).kj(str);
        if (kj != null) {
            return kj.axW();
        }
        return "";
    }

    public static String df(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MANUFACTURER).append("-").append(Build.MODEL);
        stringBuilder.append("_");
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append("_");
        stringBuilder.append("weibosdk");
        stringBuilder.append("_");
        stringBuilder.append("0031405000");
        stringBuilder.append("_android");
        return stringBuilder.toString();
    }

    public static String dj(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MANUFACTURER).append("-").append(Build.MODEL);
        stringBuilder.append("__");
        stringBuilder.append("weibosdk");
        stringBuilder.append("__");
        try {
            stringBuilder.append("0031405000".replaceAll("\\s+", "_"));
        } catch (Exception e) {
            stringBuilder.append("unknown");
        }
        stringBuilder.append("__").append("android").append("__android").append(VERSION.RELEASE);
        return stringBuilder.toString();
    }
}
