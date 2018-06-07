package com.fossil;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

public class xh extends wu<InputStream> implements xe<Uri> {

    public static class C4212a implements wq<Uri, InputStream> {
        public wp<Uri, InputStream> mo4423a(Context context, wg wgVar) {
            return new xh(context, wgVar.m13993c(wh.class, InputStream.class));
        }

        public void vz() {
        }
    }

    public xh(Context context, wp<wh, InputStream> wpVar) {
        super(context, wpVar);
    }

    protected us<InputStream> mo4425a(Context context, Uri uri) {
        return new uy(context, uri);
    }

    protected us<InputStream> mo4426f(Context context, String str) {
        return new ux(context.getApplicationContext().getAssets(), str);
    }
}
