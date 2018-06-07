package com.fossil;

import android.graphics.Bitmap;

public class yo implements up<yl> {
    private final up<Bitmap> aEN;
    private final vl axR;

    public yo(up<Bitmap> upVar, vl vlVar) {
        this.aEN = upVar;
        this.axR = vlVar;
    }

    public vh<yl> mo4427a(vh<yl> vhVar, int i, int i2) {
        yl ylVar = (yl) vhVar.get();
        Bitmap vU = ((yl) vhVar.get()).vU();
        Bitmap bitmap = (Bitmap) this.aEN.mo4427a(new xp(vU, this.axR), i, i2).get();
        if (bitmap.equals(vU)) {
            return vhVar;
        }
        return new yn(new yl(ylVar, bitmap, this.aEN));
    }

    public String getId() {
        return this.aEN.getId();
    }
}
