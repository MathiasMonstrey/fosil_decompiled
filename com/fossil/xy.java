package com.fossil;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

public class xy implements un<wk, Bitmap> {
    private final un<InputStream, Bitmap> aEm;
    private final un<ParcelFileDescriptor, Bitmap> aEn;

    public /* synthetic */ vh mo4436b(Object obj, int i, int i2) throws IOException {
        return m14063a((wk) obj, i, i2);
    }

    public xy(un<InputStream, Bitmap> unVar, un<ParcelFileDescriptor, Bitmap> unVar2) {
        this.aEm = unVar;
        this.aEn = unVar2;
    }

    public vh<Bitmap> m14063a(wk wkVar, int i, int i2) throws IOException {
        vh<Bitmap> b;
        ParcelFileDescriptor vv;
        InputStream vu = wkVar.vu();
        if (vu != null) {
            try {
                b = this.aEm.mo4436b(vu, i, i2);
            } catch (Throwable e) {
                if (Log.isLoggable("ImageVideoDecoder", 2)) {
                    Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", e);
                }
            }
            if (b == null) {
                return b;
            }
            vv = wkVar.vv();
            if (vv == null) {
                return this.aEn.mo4436b(vv, i, i2);
            }
            return b;
        }
        b = null;
        if (b == null) {
            return b;
        }
        vv = wkVar.vv();
        if (vv == null) {
            return b;
        }
        return this.aEn.mo4436b(vv, i, i2);
    }

    public String getId() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
