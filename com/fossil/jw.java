package com.fossil;

public class jw<E> implements Cloneable {
    private static final Object Ql = new Object();
    private int[] QI;
    private boolean Qm;
    private Object[] Qo;
    private int mSize;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return jw();
    }

    public jw() {
        this(10);
    }

    public jw(int i) {
        this.Qm = false;
        if (i == 0) {
            this.QI = jn.Qi;
            this.Qo = jn.Qk;
        } else {
            int bj = jn.bj(i);
            this.QI = new int[bj];
            this.Qo = new Object[bj];
        }
        this.mSize = 0;
    }

    public jw<E> jw() {
        try {
            jw<E> jwVar = (jw) super.clone();
            try {
                jwVar.QI = (int[]) this.QI.clone();
                jwVar.Qo = (Object[]) this.Qo.clone();
                return jwVar;
            } catch (CloneNotSupportedException e) {
                return jwVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E get(int i) {
        return get(i, null);
    }

    public E get(int i, E e) {
        int a = jn.m11893a(this.QI, this.mSize, i);
        return (a < 0 || this.Qo[a] == Ql) ? e : this.Qo[a];
    }

    public void delete(int i) {
        int a = jn.m11893a(this.QI, this.mSize, i);
        if (a >= 0 && this.Qo[a] != Ql) {
            this.Qo[a] = Ql;
            this.Qm = true;
        }
    }

    public void remove(int i) {
        delete(i);
    }

    public void removeAt(int i) {
        if (this.Qo[i] != Ql) {
            this.Qo[i] = Ql;
            this.Qm = true;
        }
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.QI;
        Object[] objArr = this.Qo;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != Ql) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.Qm = false;
        this.mSize = i2;
    }

    public void put(int i, E e) {
        int a = jn.m11893a(this.QI, this.mSize, i);
        if (a >= 0) {
            this.Qo[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.mSize || this.Qo[a] != Ql) {
            if (this.Qm && this.mSize >= this.QI.length) {
                gc();
                a = jn.m11893a(this.QI, this.mSize, i) ^ -1;
            }
            if (this.mSize >= this.QI.length) {
                int bj = jn.bj(this.mSize + 1);
                Object obj = new int[bj];
                Object obj2 = new Object[bj];
                System.arraycopy(this.QI, 0, obj, 0, this.QI.length);
                System.arraycopy(this.Qo, 0, obj2, 0, this.Qo.length);
                this.QI = obj;
                this.Qo = obj2;
            }
            if (this.mSize - a != 0) {
                System.arraycopy(this.QI, a, this.QI, a + 1, this.mSize - a);
                System.arraycopy(this.Qo, a, this.Qo, a + 1, this.mSize - a);
            }
            this.QI[a] = i;
            this.Qo[a] = e;
            this.mSize++;
            return;
        }
        this.QI[a] = i;
        this.Qo[a] = e;
    }

    public int size() {
        if (this.Qm) {
            gc();
        }
        return this.mSize;
    }

    public int keyAt(int i) {
        if (this.Qm) {
            gc();
        }
        return this.QI[i];
    }

    public E valueAt(int i) {
        if (this.Qm) {
            gc();
        }
        return this.Qo[i];
    }

    public int indexOfKey(int i) {
        if (this.Qm) {
            gc();
        }
        return jn.m11893a(this.QI, this.mSize, i);
    }

    public void clear() {
        int i = this.mSize;
        Object[] objArr = this.Qo;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.Qm = false;
    }

    public void append(int i, E e) {
        if (this.mSize == 0 || i > this.QI[this.mSize - 1]) {
            if (this.Qm && this.mSize >= this.QI.length) {
                gc();
            }
            int i2 = this.mSize;
            if (i2 >= this.QI.length) {
                int bj = jn.bj(i2 + 1);
                Object obj = new int[bj];
                Object obj2 = new Object[bj];
                System.arraycopy(this.QI, 0, obj, 0, this.QI.length);
                System.arraycopy(this.Qo, 0, obj2, 0, this.Qo.length);
                this.QI = obj;
                this.Qo = obj2;
            }
            this.QI[i2] = i;
            this.Qo[i2] = e;
            this.mSize = i2 + 1;
            return;
        }
        put(i, e);
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(keyAt(i));
            stringBuilder.append('=');
            jw valueAt = valueAt(i);
            if (valueAt != this) {
                stringBuilder.append(valueAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
