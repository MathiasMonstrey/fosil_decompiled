package com.fossil;

import android.net.Uri;

public class cmb {
    private String cxk;
    private final String mName;
    private Uri mUri;

    public cmb(String str, String str2) {
        this.cxk = str;
        this.mName = str2;
    }

    public cmb(Uri uri, String str) {
        this.mUri = uri;
        this.mName = str;
    }

    public String getUrl() {
        return this.cxk;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public String getName() {
        return this.mName;
    }
}
