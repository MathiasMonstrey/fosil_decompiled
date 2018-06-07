package com.fossil;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

public class xg extends wt<InputStream> implements xe<String> {

    public static class C4211a implements wq<String, InputStream> {
        public wp<String, InputStream> mo4423a(Context context, wg wgVar) {
            return new xg(wgVar.m13993c(Uri.class, InputStream.class));
        }

        public void vz() {
        }
    }

    public xg(wp<Uri, InputStream> wpVar) {
        super(wpVar);
    }
}
