package com.fossil;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class xr extends xq {
    public xr(vl vlVar) {
        super(vlVar);
    }

    protected Bitmap mo4429a(vl vlVar, Bitmap bitmap, int i, int i2) {
        Bitmap b = vlVar.mo4214b(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
        Bitmap a = yc.m14067a(b, bitmap, i, i2);
        if (!(b == null || b == a || vlVar.mo4217j(b))) {
            b.recycle();
        }
        return a;
    }

    public String getId() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }
}
