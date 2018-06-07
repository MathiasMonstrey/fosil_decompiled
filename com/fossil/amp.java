package com.fossil;

import java.lang.reflect.Array;
import java.util.List;

public final class amp {
    private int _size;
    private amn<Object[]> aVS;
    private amn<Object[]> aVT;
    private Object[] aVU;

    public Object[] Ho() {
        Hr();
        if (this.aVU == null) {
            return new Object[12];
        }
        return this.aVU;
    }

    public Object[] m3889c(Object[] objArr) {
        amn com_fossil_amn = new amn(objArr, null);
        if (this.aVS == null) {
            this.aVT = com_fossil_amn;
            this.aVS = com_fossil_amn;
        } else {
            this.aVT.m3883a(com_fossil_amn);
            this.aVT = com_fossil_amn;
        }
        int length = objArr.length;
        this._size += length;
        if (length < 16384) {
            length += length;
        } else if (length < 262144) {
            length += length >> 2;
        }
        return new Object[length];
    }

    public Object[] m3890c(Object[] objArr, int i) {
        int i2 = this._size + i;
        Object obj = new Object[i2];
        m3886a(obj, i2, objArr, i);
        return obj;
    }

    public <T> T[] m3888a(Object[] objArr, int i, Class<T> cls) {
        int i2 = i + this._size;
        Object[] objArr2 = (Object[]) Array.newInstance(cls, i2);
        m3886a(objArr2, i2, objArr, i);
        Hr();
        return objArr2;
    }

    public void m3887a(Object[] objArr, int i, List<Object> list) {
        for (amn com_fossil_amn = this.aVS; com_fossil_amn != null; com_fossil_amn = com_fossil_amn.Hm()) {
            for (Object add : (Object[]) com_fossil_amn.Hn()) {
                list.add(add);
            }
        }
        for (int i2 = 0; i2 < i; i2++) {
            list.add(objArr[i2]);
        }
    }

    public int Hp() {
        return this.aVU == null ? 0 : this.aVU.length;
    }

    public int Hq() {
        return this._size;
    }

    protected void Hr() {
        if (this.aVT != null) {
            this.aVU = (Object[]) this.aVT.Hn();
        }
        this.aVT = null;
        this.aVS = null;
        this._size = 0;
    }

    protected final void m3886a(Object obj, int i, Object[] objArr, int i2) {
        int i3 = 0;
        for (amn com_fossil_amn = this.aVS; com_fossil_amn != null; com_fossil_amn = com_fossil_amn.Hm()) {
            Object[] objArr2 = (Object[]) com_fossil_amn.Hn();
            int length = objArr2.length;
            System.arraycopy(objArr2, 0, obj, i3, length);
            i3 += length;
        }
        System.arraycopy(objArr, 0, obj, i3, i2);
        int i4 = i3 + i2;
        if (i4 != i) {
            throw new IllegalStateException("Should have gotten " + i + " entries, got " + i4);
        }
    }
}
