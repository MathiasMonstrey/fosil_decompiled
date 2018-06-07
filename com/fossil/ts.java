package com.fossil;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.fossil.tz.C4127d;
import java.io.InputStream;

public class ts<ModelType> extends tr<ModelType, Bitmap> {
    private final wp<ModelType, InputStream> axW;
    private final wp<ModelType, ParcelFileDescriptor> axX;
    private final tx axY;
    private final C4127d axZ;

    private static <A, R> aaa<A, wk, Bitmap, R> m13728a(tx txVar, wp<A, InputStream> wpVar, wp<A, ParcelFileDescriptor> wpVar2, Class<R> cls, zd<Bitmap, R> zdVar) {
        if (wpVar == null && wpVar2 == null) {
            return null;
        }
        if (zdVar == null) {
            zdVar = txVar.m13761a(Bitmap.class, (Class) cls);
        }
        return new aaa(new wj(wpVar, wpVar2), zdVar, txVar.m13763b(wk.class, Bitmap.class));
    }

    ts(tv<ModelType, ?, ?, ?> tvVar, wp<ModelType, InputStream> wpVar, wp<ModelType, ParcelFileDescriptor> wpVar2, C4127d c4127d) {
        super(m13728a(tvVar.axY, wpVar, wpVar2, Bitmap.class, null), Bitmap.class, tvVar);
        this.axW = wpVar;
        this.axX = wpVar2;
        this.axY = tvVar.axY;
        this.axZ = c4127d;
    }
}
