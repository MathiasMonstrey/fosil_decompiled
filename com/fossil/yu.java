package com.fossil;

import android.graphics.Bitmap;

public class yu {
    private final vh<yl> aFf;
    private final vh<Bitmap> aFg;

    public yu(vh<Bitmap> vhVar, vh<yl> vhVar2) {
        if (vhVar != null && vhVar2 != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        } else if (vhVar == null && vhVar2 == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        } else {
            this.aFg = vhVar;
            this.aFf = vhVar2;
        }
    }

    public int getSize() {
        if (this.aFg != null) {
            return this.aFg.getSize();
        }
        return this.aFf.getSize();
    }

    public vh<Bitmap> we() {
        return this.aFg;
    }

    public vh<yl> wf() {
        return this.aFf;
    }
}
