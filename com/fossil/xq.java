package com.fossil;

import android.content.Context;
import android.graphics.Bitmap;

public abstract class xq implements up<Bitmap> {
    private vl axR;

    protected abstract Bitmap mo4429a(vl vlVar, Bitmap bitmap, int i, int i2);

    public xq(Context context) {
        this(tx.m13751E(context).tE());
    }

    public xq(vl vlVar) {
        this.axR = vlVar;
    }

    public final vh<Bitmap> mo4427a(vh<Bitmap> vhVar, int i, int i2) {
        if (abl.bg(i, i2)) {
            Bitmap bitmap = (Bitmap) vhVar.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap a = mo4429a(this.axR, bitmap, i, i2);
            if (bitmap.equals(a)) {
                return vhVar;
            }
            return xp.m14042a(a, this.axR);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
