package com.fossil;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

public class wy extends wr<ParcelFileDescriptor> implements wx<Integer> {

    public static class C4204a implements wq<Integer, ParcelFileDescriptor> {
        public wp<Integer, ParcelFileDescriptor> mo4423a(Context context, wg wgVar) {
            return new wy(context, wgVar.m13993c(Uri.class, ParcelFileDescriptor.class));
        }

        public void vz() {
        }
    }

    public wy(Context context, wp<Uri, ParcelFileDescriptor> wpVar) {
        super(context, (wp) wpVar);
    }
}
