package com.fossil;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;

public class xz implements zx<wk, Bitmap> {
    private final un<File, Bitmap> aBW;
    private final uo<Bitmap> aBY;
    private final xy aEo;
    private final wl aEp;

    public xz(zx<InputStream, Bitmap> zxVar, zx<ParcelFileDescriptor, Bitmap> zxVar2) {
        this.aBY = zxVar.vI();
        this.aEp = new wl(zxVar.vH(), zxVar2.vH());
        this.aBW = zxVar.vF();
        this.aEo = new xy(zxVar.vG(), zxVar2.vG());
    }

    public un<File, Bitmap> vF() {
        return this.aBW;
    }

    public un<wk, Bitmap> vG() {
        return this.aEo;
    }

    public uk<wk> vH() {
        return this.aEp;
    }

    public uo<Bitmap> vI() {
        return this.aBY;
    }
}
