package com.fossil;

import android.graphics.Bitmap;

public class zb implements zd<yu, yf> {
    private final zd<Bitmap, xw> aFu;

    public zb(zd<Bitmap, xw> zdVar) {
        this.aFu = zdVar;
    }

    public vh<yf> mo4443d(vh<yu> vhVar) {
        yu yuVar = (yu) vhVar.get();
        vh we = yuVar.we();
        if (we != null) {
            return this.aFu.mo4443d(we);
        }
        return yuVar.wf();
    }

    public String getId() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
