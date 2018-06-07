package com.fossil;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

public class xa extends wu<ParcelFileDescriptor> implements wx<Uri> {

    public static class C4207a implements wq<Uri, ParcelFileDescriptor> {
        public wp<Uri, ParcelFileDescriptor> mo4423a(Context context, wg wgVar) {
            return new xa(context, wgVar.m13993c(wh.class, ParcelFileDescriptor.class));
        }

        public void vz() {
        }
    }

    public xa(Context context, wp<wh, ParcelFileDescriptor> wpVar) {
        super(context, wpVar);
    }

    protected us<ParcelFileDescriptor> mo4425a(Context context, Uri uri) {
        return new uu(context, uri);
    }

    protected us<ParcelFileDescriptor> mo4426f(Context context, String str) {
        return new ut(context.getApplicationContext().getAssets(), str);
    }
}
