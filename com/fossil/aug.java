package com.fossil;

import com.google.android.gms.common.data.DataHolder;
import java.util.Iterator;

public abstract class aug<T> implements auh<T> {
    protected final DataHolder bgD;

    protected aug(DataHolder dataHolder) {
        this.bgD = dataHolder;
    }

    @Deprecated
    public final void close() {
        release();
    }

    public int getCount() {
        return this.bgD == null ? 0 : this.bgD.bgJ;
    }

    public Iterator<T> iterator() {
        return new auk(this);
    }

    public void release() {
        if (this.bgD != null) {
            this.bgD.close();
        }
    }
}
