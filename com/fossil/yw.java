package com.fossil;

import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class yw implements un<wk, yu> {
    private static final C4236b aFi = new C4236b();
    private static final C4235a aFj = new C4235a();
    private final un<wk, Bitmap> aFk;
    private final un<InputStream, yl> aFl;
    private final C4236b aFm;
    private final C4235a aFn;
    private final vl axR;
    private String id;

    static class C4235a {
        C4235a() {
        }

        public InputStream m14113b(InputStream inputStream, byte[] bArr) {
            return new RecyclableBufferedInputStream(inputStream, bArr);
        }
    }

    static class C4236b {
        C4236b() {
        }

        public ImageType m14114f(InputStream inputStream) throws IOException {
            return new ImageHeaderParser(inputStream).vL();
        }
    }

    public /* synthetic */ vh mo4436b(Object obj, int i, int i2) throws IOException {
        return m14119a((wk) obj, i, i2);
    }

    public yw(un<wk, Bitmap> unVar, un<InputStream, yl> unVar2, vl vlVar) {
        this(unVar, unVar2, vlVar, aFi, aFj);
    }

    yw(un<wk, Bitmap> unVar, un<InputStream, yl> unVar2, vl vlVar, C4236b c4236b, C4235a c4235a) {
        this.aFk = unVar;
        this.aFl = unVar2;
        this.axR = vlVar;
        this.aFm = c4236b;
        this.aFn = c4235a;
    }

    public vh<yu> m14119a(wk wkVar, int i, int i2) throws IOException {
        abe wT = abe.wT();
        byte[] bytes = wT.getBytes();
        try {
            yu a = m14115a(wkVar, i, i2, bytes);
            return a != null ? new yv(a) : null;
        } finally {
            wT.L(bytes);
        }
    }

    private yu m14115a(wk wkVar, int i, int i2, byte[] bArr) throws IOException {
        if (wkVar.vu() != null) {
            return m14117b(wkVar, i, i2, bArr);
        }
        return m14116b(wkVar, i, i2);
    }

    private yu m14117b(wk wkVar, int i, int i2, byte[] bArr) throws IOException {
        InputStream b = this.aFn.m14113b(wkVar.vu(), bArr);
        b.mark(2048);
        ImageType f = this.aFm.m14114f(b);
        b.reset();
        yu yuVar = null;
        if (f == ImageType.GIF) {
            yuVar = m14118c(b, i, i2);
        }
        if (yuVar == null) {
            return m14116b(new wk(b, wkVar.vv()), i, i2);
        }
        return yuVar;
    }

    private yu m14118c(InputStream inputStream, int i, int i2) throws IOException {
        vh b = this.aFl.mo4436b(inputStream, i, i2);
        if (b == null) {
            return null;
        }
        yl ylVar = (yl) b.get();
        if (ylVar.getFrameCount() > 1) {
            return new yu(null, b);
        }
        return new yu(new xp(ylVar.vU(), this.axR), null);
    }

    private yu m14116b(wk wkVar, int i, int i2) throws IOException {
        vh b = this.aFk.mo4436b(wkVar, i, i2);
        if (b != null) {
            return new yu(b, null);
        }
        return null;
    }

    public String getId() {
        if (this.id == null) {
            this.id = this.aFl.getId() + this.aFk.getId();
        }
        return this.id;
    }
}
