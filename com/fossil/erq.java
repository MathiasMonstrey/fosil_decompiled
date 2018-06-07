package com.fossil;

public final class erq<T> {
    int Qq;
    final float bNT;
    T[] keys;
    int mask;
    int size;

    public erq() {
        this(16, 0.75f);
    }

    public erq(int i, float f) {
        this.bNT = f;
        int pp = err.pp(i);
        this.mask = pp - 1;
        this.Qq = (int) (((float) pp) * f);
        this.keys = new Object[pp];
    }

    public boolean add(T t) {
        Object[] objArr = this.keys;
        int i = this.mask;
        int po = po(t.hashCode()) & i;
        Object obj = objArr[po];
        if (obj != null) {
            if (obj.equals(t)) {
                return false;
            }
            do {
                po = (po + 1) & i;
                obj = objArr[po];
                if (obj == null) {
                }
            } while (!obj.equals(t));
            return false;
        }
        objArr[po] = t;
        po = this.size + 1;
        this.size = po;
        if (po >= this.Qq) {
            rehash();
        }
        return true;
    }

    public boolean remove(T t) {
        Object[] objArr = this.keys;
        int i = this.mask;
        int po = po(t.hashCode()) & i;
        Object obj = objArr[po];
        if (obj == null) {
            return false;
        }
        if (obj.equals(t)) {
            return m11103a(po, objArr, i);
        }
        do {
            po = (po + 1) & i;
            obj = objArr[po];
            if (obj == null) {
                return false;
            }
        } while (!obj.equals(t));
        return m11103a(po, objArr, i);
    }

    boolean m11103a(int i, T[] tArr, int i2) {
        this.size--;
        while (true) {
            Object obj;
            int i3 = (i + 1) & i2;
            while (true) {
                obj = tArr[i3];
                if (obj == null) {
                    tArr[i] = null;
                    return true;
                }
                int po = po(obj.hashCode()) & i2;
                if (i <= i3) {
                    if (i >= po || po > i3) {
                        break;
                    }
                    i3 = (i3 + 1) & i2;
                } else {
                    if (i >= po && po > i3) {
                        break;
                    }
                    i3 = (i3 + 1) & i2;
                }
            }
            tArr[i] = obj;
            i = i3;
        }
    }

    void rehash() {
        Object[] objArr = this.keys;
        int length = objArr.length;
        int i = length << 1;
        int i2 = i - 1;
        Object[] objArr2 = new Object[i];
        int i3 = length;
        length = this.size;
        while (true) {
            int i4 = length - 1;
            if (length != 0) {
                do {
                    i3--;
                } while (objArr[i3] == null);
                length = po(objArr[i3].hashCode()) & i2;
                if (objArr2[length] != null) {
                    do {
                        length = (length + 1) & i2;
                    } while (objArr2[length] != null);
                }
                objArr2[length] = objArr[i3];
                length = i4;
            } else {
                this.mask = i2;
                this.Qq = (int) (((float) i) * this.bNT);
                this.keys = objArr2;
                return;
            }
        }
    }

    static int po(int i) {
        int i2 = -1640531527 * i;
        return i2 ^ (i2 >>> 16);
    }

    public Object[] aGU() {
        return this.keys;
    }
}
