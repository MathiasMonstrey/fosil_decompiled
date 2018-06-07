package com.fossil;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.fossil.tz.C4127d;
import java.io.File;
import java.io.InputStream;

public class tu<ModelType> extends tt<ModelType> {
    private final wp<ModelType, InputStream> axW;
    private final wp<ModelType, ParcelFileDescriptor> axX;
    private final C4127d axZ;

    private static <A, Z, R> aaa<A, wk, Z, R> m13749a(tx txVar, wp<A, InputStream> wpVar, wp<A, ParcelFileDescriptor> wpVar2, Class<Z> cls, Class<R> cls2, zd<Z, R> zdVar) {
        if (wpVar == null && wpVar2 == null) {
            return null;
        }
        if (zdVar == null) {
            zdVar = txVar.m13761a((Class) cls, (Class) cls2);
        }
        return new aaa(new wj(wpVar, wpVar2), zdVar, txVar.m13763b(wk.class, (Class) cls));
    }

    tu(Class<ModelType> cls, wp<ModelType, InputStream> wpVar, wp<ModelType, ParcelFileDescriptor> wpVar2, Context context, tx txVar, zs zsVar, zm zmVar, C4127d c4127d) {
        super(context, cls, m13749a(txVar, wpVar, wpVar2, yu.class, yf.class, null), txVar, zsVar, zmVar);
        this.axW = wpVar;
        this.axX = wpVar2;
        this.axZ = c4127d;
    }

    public ts<ModelType> tA() {
        return (ts) this.axZ.m13769e(new ts(this, this.axW, this.axX, this.axZ));
    }

    public aac<File> bb(int i, int i2) {
        return tB().bb(i, i2);
    }

    private tw<ModelType, InputStream, File> tB() {
        return (tw) this.axZ.m13769e(new tw(File.class, this, this.axW, InputStream.class, File.class, this.axZ));
    }
}
