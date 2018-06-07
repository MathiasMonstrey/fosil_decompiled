package com.fossil;

import android.content.Context;
import android.net.Uri;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;

public abstract class wu<T> implements wp<Uri, T> {
    private final wp<wh, T> aDK;
    private final Context context;

    protected abstract us<T> mo4425a(Context context, Uri uri);

    protected abstract us<T> mo4426f(Context context, String str);

    public /* synthetic */ us mo4419c(Object obj, int i, int i2) {
        return m14013a((Uri) obj, i, i2);
    }

    public wu(Context context, wp<wh, T> wpVar) {
        this.context = context;
        this.aDK = wpVar;
    }

    public final us<T> m14013a(Uri uri, int i, int i2) {
        String scheme = uri.getScheme();
        if (an(scheme)) {
            if (!we.m13980h(uri)) {
                return mo4425a(this.context, uri);
            }
            return mo4426f(this.context, we.m13981i(uri));
        } else if (this.aDK == null) {
            return null;
        } else {
            if ("http".equals(scheme) || UpPlatformSdkConstants.URI_SCHEME.equals(scheme)) {
                return this.aDK.mo4419c(new wh(uri.toString()), i, i2);
            }
            return null;
        }
    }

    private static boolean an(String str) {
        return "file".equals(str) || "content".equals(str) || "android.resource".equals(str);
    }
}
