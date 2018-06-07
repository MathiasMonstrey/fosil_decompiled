package com.fossil;

import android.graphics.Bitmap;

public class yz implements up<yu> {
    private final up<Bitmap> aFr;
    private final up<yl> aFs;

    public yz(vl vlVar, up<Bitmap> upVar) {
        this((up) upVar, new yo(upVar, vlVar));
    }

    yz(up<Bitmap> upVar, up<yl> upVar2) {
        this.aFr = upVar;
        this.aFs = upVar2;
    }

    public vh<yu> mo4427a(vh<yu> vhVar, int i, int i2) {
        vh we = ((yu) vhVar.get()).we();
        vh wf = ((yu) vhVar.get()).wf();
        if (we != null && this.aFr != null) {
            vh a = this.aFr.mo4427a(we, i, i2);
            if (we.equals(a)) {
                return vhVar;
            }
            return new yv(new yu(a, ((yu) vhVar.get()).wf()));
        } else if (wf == null || this.aFs == null) {
            return vhVar;
        } else {
            we = this.aFs.mo4427a(wf, i, i2);
            if (wf.equals(we)) {
                return vhVar;
            }
            return new yv(new yu(((yu) vhVar.get()).we(), we));
        }
    }

    public String getId() {
        return this.aFr.getId();
    }
}
