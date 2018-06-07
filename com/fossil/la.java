package com.fossil;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class la {
    private final DataSetObservable RI = new DataSetObservable();
    private DataSetObserver RJ;

    public abstract boolean mo1707a(View view, Object obj);

    public abstract int getCount();

    public void mo1710e(ViewGroup viewGroup) {
        m6426K(viewGroup);
    }

    public Object mo1709d(ViewGroup viewGroup, int i) {
        return m6438k(viewGroup, i);
    }

    public void mo1706a(ViewGroup viewGroup, int i, Object obj) {
        m6430a((View) viewGroup, i, obj);
    }

    public void mo1708b(ViewGroup viewGroup, int i, Object obj) {
        m6433b((View) viewGroup, i, obj);
    }

    public void mo1711f(ViewGroup viewGroup) {
        m6427L(viewGroup);
    }

    @Deprecated
    public void m6426K(View view) {
    }

    @Deprecated
    public Object m6438k(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void m6430a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    @Deprecated
    public void m6433b(View view, int i, Object obj) {
    }

    @Deprecated
    public void m6427L(View view) {
    }

    public Parcelable ip() {
        return null;
    }

    public void mo1705a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public int ae(Object obj) {
        return -1;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.RI.registerObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.RI.unregisterObserver(dataSetObserver);
    }

    public void m6428a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.RJ = dataSetObserver;
        }
    }

    public CharSequence bo(int i) {
        return null;
    }

    public float bp(int i) {
        return 1.0f;
    }
}
