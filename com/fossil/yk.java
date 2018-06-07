package com.fossil;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.fossil.ud.C4136a;

class yk implements C4136a {
    private final vl axR;

    public yk(vl vlVar) {
        this.axR = vlVar;
    }

    public Bitmap mo4440a(int i, int i2, Config config) {
        return this.axR.mo4216h(i, i2, config);
    }

    public void mo4441d(Bitmap bitmap) {
        if (!this.axR.mo4217j(bitmap)) {
            bitmap.recycle();
        }
    }
}
