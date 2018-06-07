package com.fossil;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import java.io.OutputStream;

public class xo implements uo<Bitmap> {
    private CompressFormat aDQ;
    private int quality;

    public xo() {
        this(null, 90);
    }

    public xo(CompressFormat compressFormat, int i) {
        this.aDQ = compressFormat;
        this.quality = i;
    }

    public boolean m14040a(vh<Bitmap> vhVar, OutputStream outputStream) {
        Bitmap bitmap = (Bitmap) vhVar.get();
        long wV = abh.wV();
        CompressFormat m = m14039m(bitmap);
        bitmap.compress(m, this.quality, outputStream);
        if (Log.isLoggable("BitmapEncoder", 2)) {
            Log.v("BitmapEncoder", "Compressed with type: " + m + " of size " + abl.p(bitmap) + " in " + abh.v(wV));
        }
        return true;
    }

    public String getId() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    private CompressFormat m14039m(Bitmap bitmap) {
        if (this.aDQ != null) {
            return this.aDQ;
        }
        if (bitmap.hasAlpha()) {
            return CompressFormat.PNG;
        }
        return CompressFormat.JPEG;
    }
}
