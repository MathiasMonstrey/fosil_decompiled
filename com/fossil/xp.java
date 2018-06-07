package com.fossil;

import android.graphics.Bitmap;

public class xp implements vh<Bitmap> {
    private final vl axR;
    private final Bitmap bitmap;

    public /* synthetic */ Object get() {
        return vD();
    }

    public static xp m14042a(Bitmap bitmap, vl vlVar) {
        if (bitmap == null) {
            return null;
        }
        return new xp(bitmap, vlVar);
    }

    public xp(Bitmap bitmap, vl vlVar) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (vlVar == null) {
            throw new NullPointerException("BitmapPool must not be null");
        } else {
            this.bitmap = bitmap;
            this.axR = vlVar;
        }
    }

    public Bitmap vD() {
        return this.bitmap;
    }

    public int getSize() {
        return abl.p(this.bitmap);
    }

    public void recycle() {
        if (!this.axR.mo4217j(this.bitmap)) {
            this.bitmap.recycle();
        }
    }
}
