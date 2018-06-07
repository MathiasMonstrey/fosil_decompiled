package com.fossil;

import android.os.Bundle;

public final class dyb {
    public static String m10276i(Bundle bundle, String str) {
        String str2 = null;
        if (bundle != null) {
            try {
                str2 = bundle.getString(str);
            } catch (Exception e) {
                dyc.m10279a("MicroMsg.IntentUtil", "getStringExtra exception:%s", e.getMessage());
            }
        }
        return str2;
    }
}
