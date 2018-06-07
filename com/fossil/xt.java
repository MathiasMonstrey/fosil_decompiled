package com.fossil;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

public class xt implements zx<ParcelFileDescriptor, Bitmap> {
    private final un<File, Bitmap> aBW;
    private final uk<ParcelFileDescriptor> aBZ = xj.vA();
    private final xu aDW;
    private final xo aDX = new xo();

    public xt(vl vlVar, DecodeFormat decodeFormat) {
        this.aBW = new yi(new yb(vlVar, decodeFormat));
        this.aDW = new xu(vlVar, decodeFormat);
    }

    public un<File, Bitmap> vF() {
        return this.aBW;
    }

    public un<ParcelFileDescriptor, Bitmap> vG() {
        return this.aDW;
    }

    public uk<ParcelFileDescriptor> vH() {
        return this.aBZ;
    }

    public uo<Bitmap> vI() {
        return this.aDX;
    }
}
