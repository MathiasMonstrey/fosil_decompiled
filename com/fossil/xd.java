package com.fossil;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.InputStream;

public class xd extends wf<InputStream> implements xe<File> {

    public static class C4209a implements wq<File, InputStream> {
        public wp<File, InputStream> mo4423a(Context context, wg wgVar) {
            return new xd(wgVar.m13993c(Uri.class, InputStream.class));
        }

        public void vz() {
        }
    }

    public xd(wp<Uri, InputStream> wpVar) {
        super(wpVar);
    }
}
