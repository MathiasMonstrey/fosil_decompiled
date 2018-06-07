package com.fossil;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.IOException;

public class xu implements un<ParcelFileDescriptor, Bitmap> {
    private final yd aDY;
    private final vl axR;
    private DecodeFormat axT;

    public /* synthetic */ vh mo4436b(Object obj, int i, int i2) throws IOException {
        return m14060a((ParcelFileDescriptor) obj, i, i2);
    }

    public xu(vl vlVar, DecodeFormat decodeFormat) {
        this(new yd(), vlVar, decodeFormat);
    }

    public xu(yd ydVar, vl vlVar, DecodeFormat decodeFormat) {
        this.aDY = ydVar;
        this.axR = vlVar;
        this.axT = decodeFormat;
    }

    public vh<Bitmap> m14060a(ParcelFileDescriptor parcelFileDescriptor, int i, int i2) throws IOException {
        return xp.m14042a(this.aDY.m14073a(parcelFileDescriptor, this.axR, i, i2, this.axT), this.axR);
    }

    public String getId() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }
}
