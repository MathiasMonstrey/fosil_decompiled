package com.fossil;

public class jq<E> implements Cloneable {
    private static final Object Ql = new Object();
    private boolean Qm;
    private long[] Qn;
    private Object[] Qo;
    private int mSize;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return js();
    }

    public jq() {
        this(10);
    }

    public jq(int i) {
        this.Qm = false;
        if (i == 0) {
            this.Qn = jn.Qj;
            this.Qo = jn.Qk;
        } else {
            int bk = jn.bk(i);
            this.Qn = new long[bk];
            this.Qo = new Object[bk];
        }
        this.mSize = 0;
    }

    public jq<E> js() {
        try {
            jq<E> jqVar = (jq) super.clone();
            try {
                jqVar.Qn = (long[]) this.Qn.clone();
                jqVar.Qo = (Object[]) this.Qo.clone();
                return jqVar;
            } catch (CloneNotSupportedException e) {
                return jqVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E get(long j) {
        return get(j, null);
    }

    public E get(long j, E e) {
        int a = jn.m11894a(this.Qn, this.mSize, j);
        return (a < 0 || this.Qo[a] == Ql) ? e : this.Qo[a];
    }

    public void delete(long j) {
        int a = jn.m11894a(this.Qn, this.mSize, j);
        if (a >= 0 && this.Qo[a] != Ql) {
            this.Qo[a] = Ql;
            this.Qm = true;
        }
    }

    public void remove(long j) {
        delete(j);
    }

    public void removeAt(int i) {
        if (this.Qo[i] != Ql) {
            this.Qo[i] = Ql;
            this.Qm = true;
        }
    }

    private void gc() {
        int i = this.mSize;
        long[] jArr = this.Qn;
        Object[] objArr = this.Qo;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != Ql) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.Qm = false;
        this.mSize = i2;
    }

    public void put(long j, E e) {
        int a = jn.m11894a(this.Qn, this.mSize, j);
        if (a >= 0) {
            this.Qo[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.mSize || this.Qo[a] != Ql) {
            if (this.Qm && this.mSize >= this.Qn.length) {
                gc();
                a = jn.m11894a(this.Qn, this.mSize, j) ^ -1;
            }
            if (this.mSize >= this.Qn.length) {
                int bk = jn.bk(this.mSize + 1);
                Object obj = new long[bk];
                Object obj2 = new Object[bk];
                System.arraycopy(this.Qn, 0, obj, 0, this.Qn.length);
                System.arraycopy(this.Qo, 0, obj2, 0, this.Qo.length);
                this.Qn = obj;
                this.Qo = obj2;
            }
            if (this.mSize - a != 0) {
                System.arraycopy(this.Qn, a, this.Qn, a + 1, this.mSize - a);
                System.arraycopy(this.Qo, a, this.Qo, a + 1, this.mSize - a);
            }
            this.Qn[a] = j;
            this.Qo[a] = e;
            this.mSize++;
            return;
        }
        this.Qn[a] = j;
        this.Qo[a] = e;
    }

    public int size() {
        if (this.Qm) {
            gc();
        }
        return this.mSize;
    }

    public long keyAt(int i) {
        if (this.Qm) {
            gc();
        }
        return this.Qn[i];
    }

    public E valueAt(int i) {
        if (this.Qm) {
            gc();
        }
        return this.Qo[i];
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
            jq valueAt = valueAt(i);
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
