package com.fossil;

import android.content.res.Resources;
import android.graphics.Bitmap;

public class zc implements zd<Bitmap, xw> {
    private final Resources aDJ;
    private final vl axR;

    public zc(Resources resources, vl vlVar) {
        this.aDJ = resources;
        this.axR = vlVar;
    }

    public vh<xw> mo4443d(vh<Bitmap> vhVar) {
        return new xx(new xw(this.aDJ, (Bitmap) vhVar.get()), this.axR);
    }

    public String getId() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
