package com.fossil;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.File;

public class ww extends wf<ParcelFileDescriptor> implements wx<File> {

    public static class C4203a implements wq<File, ParcelFileDescriptor> {
        public wp<File, ParcelFileDescriptor> mo4423a(Context context, wg wgVar) {
            return new ww(wgVar.m13993c(Uri.class, ParcelFileDescriptor.class));
        }

        public void vz() {
        }
    }

    public ww(wp<Uri, ParcelFileDescriptor> wpVar) {
        super(wpVar);
    }
}
