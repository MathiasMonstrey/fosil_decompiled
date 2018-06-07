package com.fossil;

import android.content.Context;
import java.io.File;
import java.io.InputStream;

public class ym implements zx<InputStream, yl> {
    private final ys aEL;
    private final yt aEM;
    private final ws aEr;
    private final yi<yl> aEs = new yi(this.aEL);

    public ym(Context context, vl vlVar) {
        this.aEL = new ys(context, vlVar);
        this.aEM = new yt(vlVar);
        this.aEr = new ws();
    }

    public un<File, yl> vF() {
        return this.aEs;
    }

    public un<InputStream, yl> vG() {
        return this.aEL;
    }

    public uk<InputStream> vH() {
        return this.aEr;
    }

    public uo<yl> vI() {
        return this.aEM;
    }
}
