package com.fossil;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

public class tg {
    private Uri axj;
    private List<C4108a> axk;
    private Uri axl;

    public static class C4108a {
        private final String appName;
        private final Uri axm;
        private final String className;
        private final String packageName;

        public C4108a(String str, String str2, Uri uri, String str3) {
            this.packageName = str;
            this.className = str2;
            this.axm = uri;
            this.appName = str3;
        }
    }

    public tg(Uri uri, List<C4108a> list, Uri uri2) {
        this.axj = uri;
        if (list == null) {
            list = Collections.emptyList();
        }
        this.axk = list;
        this.axl = uri2;
    }
}
