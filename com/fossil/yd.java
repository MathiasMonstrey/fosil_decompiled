package com.fossil;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.IOException;

public class yd implements xn<ParcelFileDescriptor> {
    private static final C4221a aEt = new C4221a();
    private C4221a aEu;
    private int aEv;

    static class C4221a {
        C4221a() {
        }

        public MediaMetadataRetriever vS() {
            return new MediaMetadataRetriever();
        }
    }

    public yd() {
        this(aEt, -1);
    }

    yd(C4221a c4221a, int i) {
        this.aEu = c4221a;
        this.aEv = i;
    }

    public Bitmap m14073a(ParcelFileDescriptor parcelFileDescriptor, vl vlVar, int i, int i2, DecodeFormat decodeFormat) throws IOException {
        Bitmap frameAtTime;
        MediaMetadataRetriever vS = this.aEu.vS();
        vS.setDataSource(parcelFileDescriptor.getFileDescriptor());
        if (this.aEv >= 0) {
            frameAtTime = vS.getFrameAtTime((long) this.aEv);
        } else {
            frameAtTime = vS.getFrameAtTime();
        }
        vS.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    public String getId() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
