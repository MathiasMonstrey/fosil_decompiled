package com.fossil;

import android.util.Log;

public final class bif {
    private final String bhC;
    private final ave bvm;
    private final int bvn;
    private final String mTag;

    private bif(String str, String str2) {
        this.bhC = str2;
        this.mTag = str;
        this.bvm = new ave(str);
        this.bvn = Ov();
    }

    public bif(String str, String... strArr) {
        this(str, m5194d(strArr));
    }

    private final int Ov() {
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.mTag, i)) {
            i++;
        }
        return i;
    }

    private static String m5194d(String... strArr) {
        if (strArr.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (String str : strArr) {
            if (stringBuilder.length() > 1) {
                stringBuilder.append(",");
            }
            stringBuilder.append(str);
        }
        stringBuilder.append(']').append(' ');
        return stringBuilder.toString();
    }

    private final String format(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return this.bhC.concat(str);
    }

    private final boolean ig(int i) {
        return this.bvn <= i;
    }

    public final void m5195a(String str, Object... objArr) {
        if (ig(3)) {
            Log.d(this.mTag, format(str, objArr));
        }
    }
}
