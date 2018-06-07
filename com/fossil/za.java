package com.fossil;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

public class za implements zx<wk, yu> {
    private final un<File, yu> aBW;
    private final uo<yu> aBY;
    private final uk<wk> aBZ;
    private final un<wk, yu> aFt;

    public za(zx<wk, Bitmap> zxVar, zx<InputStream, yl> zxVar2, vl vlVar) {
        un ywVar = new yw(zxVar.vG(), zxVar2.vG(), vlVar);
        this.aBW = new yi(new yy(ywVar));
        this.aFt = ywVar;
        this.aBY = new yx(zxVar.vI(), zxVar2.vI());
        this.aBZ = zxVar.vH();
    }

    public un<File, yu> vF() {
        return this.aBW;
    }

    public un<wk, yu> vG() {
        return this.aFt;
    }

    public uk<wk> vH() {
        return this.aBZ;
    }

    public uo<yu> vI() {
        return this.aBY;
    }
}
