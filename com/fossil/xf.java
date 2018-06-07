package com.fossil;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

public class xf extends wr<InputStream> implements xe<Integer> {

    public static class C4210a implements wq<Integer, InputStream> {
        public wp<Integer, InputStream> mo4423a(Context context, wg wgVar) {
            return new xf(context, wgVar.m13993c(Uri.class, InputStream.class));
        }

        public void vz() {
        }
    }

    public xf(Context context, wp<Uri, InputStream> wpVar) {
        super(context, (wp) wpVar);
    }
}
