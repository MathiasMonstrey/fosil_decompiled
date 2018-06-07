package com.fossil;

import android.content.Context;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.tz.C4127d;
import java.io.File;

public class tw<ModelType, DataType, ResourceType> extends tv<ModelType, DataType, ResourceType, ResourceType> {
    private final C4127d axZ;
    private final wp<ModelType, DataType> ayD;
    private final Class<ResourceType> ayE;
    private final Class<DataType> dataClass;

    private static <A, T, Z, R> aab<A, T, Z, R> m13750a(tx txVar, wp<A, T> wpVar, Class<T> cls, Class<Z> cls2, zd<Z, R> zdVar) {
        return new aaa(wpVar, zdVar, txVar.m13763b((Class) cls, (Class) cls2));
    }

    tw(Class<ResourceType> cls, tv<ModelType, ?, ?, ?> tvVar, wp<ModelType, DataType> wpVar, Class<DataType> cls2, Class<ResourceType> cls3, C4127d c4127d) {
        super(m13750a(tvVar.axY, wpVar, cls2, cls3, zf.wh()), cls, tvVar);
        this.ayD = wpVar;
        this.dataClass = cls2;
        this.ayE = cls3;
        this.axZ = c4127d;
    }

    tw(Context context, tx txVar, Class<ModelType> cls, wp<ModelType, DataType> wpVar, Class<DataType> cls2, Class<ResourceType> cls3, zs zsVar, zm zmVar, C4127d c4127d) {
        super(context, cls, m13750a(txVar, wpVar, cls2, cls3, zf.wh()), cls3, txVar, zsVar, zmVar);
        this.ayD = wpVar;
        this.dataClass = cls2;
        this.ayE = cls3;
        this.axZ = c4127d;
    }

    public aac<File> bb(int i, int i2) {
        return tD().bc(i, i2);
    }

    private tv<ModelType, DataType, File, File> tD() {
        return this.axZ.m13769e(new tv(new aaa(this.ayD, zf.wh(), this.axY.m13763b(this.dataClass, File.class)), File.class, this)).mo4165b(Priority.LOW).mo4166b(DiskCacheStrategy.SOURCE).az(true);
    }
}
