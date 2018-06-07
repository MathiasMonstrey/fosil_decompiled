package com.fossil;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class jm<E> implements Collection<E>, Set<E> {
    private static final int[] PY = new int[0];
    private static final Object[] PZ = new Object[0];
    static Object[] Qa;
    static int Qb;
    static Object[] Qc;
    static int Qd;
    js<E, E> PW;
    final boolean Qe;
    int[] Qf;
    Object[] Qg;
    int mSize;

    class C37571 extends js<E, E> {
        final /* synthetic */ jm Qh;

        C37571(jm jmVar) {
            this.Qh = jmVar;
        }

        protected int jn() {
            return this.Qh.mSize;
        }

        protected Object mo3247y(int i, int i2) {
            return this.Qh.Qg[i];
        }

        protected int ab(Object obj) {
            return this.Qh.indexOf(obj);
        }

        protected int ac(Object obj) {
            return this.Qh.indexOf(obj);
        }

        protected Map<E, E> jo() {
            throw new UnsupportedOperationException("not a map");
        }

        protected void mo3243c(E e, E e2) {
            this.Qh.add(e);
        }

        protected E mo3239a(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }

        protected void bh(int i) {
            this.Qh.removeAt(i);
        }

        protected void jp() {
            this.Qh.clear();
        }
    }

    private int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int a = jn.m11893a(this.Qf, i2, i);
        if (a < 0 || obj.equals(this.Qg[a])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.Qf[i3] == i) {
            if (obj.equals(this.Qg[i3])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.Qf[a] == i) {
            if (obj.equals(this.Qg[a])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    private int jq() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int a = jn.m11893a(this.Qf, i, 0);
        if (a < 0 || this.Qg[a] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.Qf[i2] == 0) {
            if (this.Qg[i2] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.Qf[a] == 0) {
            if (this.Qg[a] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private void bi(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (jm.class) {
                if (Qc != null) {
                    objArr = Qc;
                    this.Qg = objArr;
                    Qc = (Object[]) objArr[0];
                    this.Qf = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    Qd--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (jm.class) {
                if (Qa != null) {
                    objArr = Qa;
                    this.Qg = objArr;
                    Qa = (Object[]) objArr[0];
                    this.Qf = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    Qb--;
                    return;
                }
            }
        }
        this.Qf = new int[i];
        this.Qg = new Object[i];
    }

    private static void m11892a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (jm.class) {
                if (Qd < 10) {
                    objArr[0] = Qc;
                    objArr[1] = iArr;
                    for (i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    Qc = objArr;
                    Qd++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (jm.class) {
                if (Qb < 10) {
                    objArr[0] = Qa;
                    objArr[1] = iArr;
                    for (i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    Qa = objArr;
                    Qb++;
                }
            }
        }
    }

    public jm() {
        this(0, false);
    }

    public jm(int i, boolean z) {
        this.Qe = z;
        if (i == 0) {
            this.Qf = PY;
            this.Qg = PZ;
        } else {
            bi(i);
        }
        this.mSize = 0;
    }

    public void clear() {
        if (this.mSize != 0) {
            m11892a(this.Qf, this.Qg, this.mSize);
            this.Qf = PY;
            this.Qg = PZ;
            this.mSize = 0;
        }
    }

    public void ensureCapacity(int i) {
        if (this.Qf.length < i) {
            Object obj = this.Qf;
            Object obj2 = this.Qg;
            bi(i);
            if (this.mSize > 0) {
                System.arraycopy(obj, 0, this.Qf, 0, this.mSize);
                System.arraycopy(obj2, 0, this.Qg, 0, this.mSize);
            }
            m11892a(obj, obj2, this.mSize);
        }
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return jq();
        }
        return indexOf(obj, this.Qe ? System.identityHashCode(obj) : obj.hashCode());
    }

    public E valueAt(int i) {
        return this.Qg[i];
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public boolean add(E e) {
        int jq;
        int i;
        if (e == null) {
            jq = jq();
            i = 0;
        } else {
            jq = this.Qe ? System.identityHashCode(e) : e.hashCode();
            i = jq;
            jq = indexOf(e, jq);
        }
        if (jq >= 0) {
            return false;
        }
        int i2 = jq ^ -1;
        if (this.mSize >= this.Qf.length) {
            jq = this.mSize >= 8 ? this.mSize + (this.mSize >> 1) : this.mSize >= 4 ? 8 : 4;
            Object obj = this.Qf;
            Object obj2 = this.Qg;
            bi(jq);
            if (this.Qf.length > 0) {
                System.arraycopy(obj, 0, this.Qf, 0, obj.length);
                System.arraycopy(obj2, 0, this.Qg, 0, obj2.length);
            }
            m11892a(obj, obj2, this.mSize);
        }
        if (i2 < this.mSize) {
            System.arraycopy(this.Qf, i2, this.Qf, i2 + 1, this.mSize - i2);
            System.arraycopy(this.Qg, i2, this.Qg, i2 + 1, this.mSize - i2);
        }
        this.Qf[i2] = i;
        this.Qg[i2] = e;
        this.mSize++;
        return true;
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public E removeAt(int i) {
        int i2 = 8;
        E e = this.Qg[i];
        if (this.mSize <= 1) {
            m11892a(this.Qf, this.Qg, this.mSize);
            this.Qf = PY;
            this.Qg = PZ;
            this.mSize = 0;
        } else if (this.Qf.length <= 8 || this.mSize >= this.Qf.length / 3) {
            this.mSize--;
            if (i < this.mSize) {
                System.arraycopy(this.Qf, i + 1, this.Qf, i, this.mSize - i);
                System.arraycopy(this.Qg, i + 1, this.Qg, i, this.mSize - i);
            }
            this.Qg[this.mSize] = null;
        } else {
            if (this.mSize > 8) {
                i2 = this.mSize + (this.mSize >> 1);
            }
            Object obj = this.Qf;
            Object obj2 = this.Qg;
            bi(i2);
            this.mSize--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.Qf, 0, i);
                System.arraycopy(obj2, 0, this.Qg, 0, i);
            }
            if (i < this.mSize) {
                System.arraycopy(obj, i + 1, this.Qf, i, this.mSize - i);
                System.arraycopy(obj2, i + 1, this.Qg, i, this.mSize - i);
            }
        }
        return e;
    }

    public int size() {
        return this.mSize;
    }

    public Object[] toArray() {
        Object obj = new Object[this.mSize];
        System.arraycopy(this.Qg, 0, obj, 0, this.mSize);
        return obj;
    }

    public <T> T[] toArray(T[] tArr) {
        Object obj;
        if (tArr.length < this.mSize) {
            obj = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize);
        } else {
            obj = tArr;
        }
        System.arraycopy(this.Qg, 0, obj, 0, this.mSize);
        if (obj.length > this.mSize) {
            obj[this.mSize] = null;
        }
        return obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        int i = 0;
        while (i < this.mSize) {
            try {
                if (!set.contains(valueAt(i))) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        int[] iArr = this.Qf;
        int i2 = 0;
        while (i < this.mSize) {
            i2 += iArr[i];
            i++;
        }
        return i2;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 14);
        stringBuilder.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            jm valueAt = valueAt(i);
            if (valueAt != this) {
                stringBuilder.append(valueAt);
            } else {
                stringBuilder.append("(this Set)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    private js<E, E> jm() {
        if (this.PW == null) {
            this.PW = new C37571(this);
        }
        return this.PW;
    }

    public Iterator<E> iterator() {
        return jm().getKeySet().iterator();
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        ensureCapacity(this.mSize + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.mSize - 1; i >= 0; i--) {
            if (!collection.contains(this.Qg[i])) {
                removeAt(i);
                z = true;
            }
        }
        return z;
    }
}
