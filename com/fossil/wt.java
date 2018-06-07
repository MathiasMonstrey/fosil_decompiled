package com.fossil;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

public class wt<T> implements wp<String, T> {
    private final wp<Uri, T> aDh;

    public /* synthetic */ us mo4419c(Object obj, int i, int i2) {
        return m14010b((String) obj, i, i2);
    }

    public wt(wp<Uri, T> wpVar) {
        this.aDh = wpVar;
    }

    public us<T> m14010b(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object am;
        if (str.startsWith("/")) {
            am = am(str);
        } else {
            am = Uri.parse(str);
            if (am.getScheme() == null) {
                am = am(str);
            }
        }
        return this.aDh.mo4419c(am, i, i2);
    }

    private static Uri am(String str) {
        return Uri.fromFile(new File(str));
    }
}
