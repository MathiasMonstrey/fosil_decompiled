package com.fossil;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import java.io.IOException;
import java.io.InputStream;

public class yb implements un<InputStream, Bitmap> {
    private vl axR;
    private final xs axS;
    private DecodeFormat axT;
    private String id;

    public /* synthetic */ vh mo4436b(Object obj, int i, int i2) throws IOException {
        return m14065a((InputStream) obj, i, i2);
    }

    public yb(vl vlVar, DecodeFormat decodeFormat) {
        this(xs.aDT, vlVar, decodeFormat);
    }

    public yb(xs xsVar, vl vlVar, DecodeFormat decodeFormat) {
        this.axS = xsVar;
        this.axR = vlVar;
        this.axT = decodeFormat;
    }

    public vh<Bitmap> m14065a(InputStream inputStream, int i, int i2) {
        return xp.m14042a(this.axS.m14054a(inputStream, this.axR, i, i2, this.axT), this.axR);
    }

    public String getId() {
        if (this.id == null) {
            this.id = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.axS.getId() + this.axT.name();
        }
        return this.id;
    }
}
