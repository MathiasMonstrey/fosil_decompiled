package com.fossil;

import android.content.Context;
import java.util.Map.Entry;

public class aru {
    private static final String TAG = ("Localization_" + aru.class.getSimpleName());
    private static art bdL = new art();
    private static Context mContext;

    private aru() {
    }

    public static void setContext(Context context) {
        mContext = context;
    }

    public static void m4341i(String str, boolean z) {
        bdL.m4340a(mContext, str, z);
    }

    public static String cP(String str) {
        return bdL.cO(str);
    }

    public static void Jy() {
        if (bdL != null && bdL.JF() != null) {
            aro Jw = aro.Jw();
            for (Entry entry : bdL.JF().entrySet()) {
                if (Jw.cL((String) entry.getKey())) {
                    Jw.cM((String) entry.getKey());
                }
                Jw.m4316H((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    public static void clearCache() {
        bdL.JE();
        aro.Jw().clearCache();
    }
}
