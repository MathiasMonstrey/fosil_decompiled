package com.fossil;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;
import java.io.InputStream;

public class ya implements zx<InputStream, Bitmap> {
    private final xo aDX;
    private final yb aEq;
    private final ws aEr = new ws();
    private final yi<Bitmap> aEs;

    public ya(vl vlVar, DecodeFormat decodeFormat) {
        this.aEq = new yb(vlVar, decodeFormat);
        this.aDX = new xo();
        this.aEs = new yi(this.aEq);
    }

    public un<File, Bitmap> vF() {
        return this.aEs;
    }

    public un<InputStream, Bitmap> vG() {
        return this.aEq;
    }

    public uk<InputStream> vH() {
        return this.aEr;
    }

    public uo<Bitmap> vI() {
        return this.aDX;
    }
}
