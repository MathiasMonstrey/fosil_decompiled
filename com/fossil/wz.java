package com.fossil;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

public class wz extends wt<ParcelFileDescriptor> implements wx<String> {

    public static class C4205a implements wq<String, ParcelFileDescriptor> {
        public wp<String, ParcelFileDescriptor> mo4423a(Context context, wg wgVar) {
            return new wz(wgVar.m13993c(Uri.class, ParcelFileDescriptor.class));
        }

        public void vz() {
        }
    }

    public wz(wp<Uri, ParcelFileDescriptor> wpVar) {
        super(wpVar);
    }
}
