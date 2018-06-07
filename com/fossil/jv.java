package com.fossil;

import java.util.Map;

public class jv<K, V> {
    static Object[] QE;
    static int QF;
    static Object[] QG;
    static int QH;
    int[] Qf;
    Object[] Qg;
    int mSize;

    int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int a = jn.m11893a(this.Qf, i2, i);
        if (a < 0 || obj.equals(this.Qg[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.Qf[i3] == i) {
            if (obj.equals(this.Qg[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.Qf[a] == i) {
            if (obj.equals(this.Qg[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    int jq() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int a = jn.m11893a(this.Qf, i, 0);
        if (a < 0 || this.Qg[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.Qf[i2] == 0) {
            if (this.Qg[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.Qf[a] == 0) {
            if (this.Qg[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private void bi(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (jl.class) {
                if (QG != null) {
                    objArr = QG;
                    this.Qg = objArr;
                    QG = (Object[]) objArr[0];
                    this.Qf = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    QH--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (jl.class) {
                if (QE != null) {
                    objArr = QE;
                    this.Qg = objArr;
                    QE = (Object[]) objArr[0];
                    this.Qf = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    QF--;
                    return;
                }
            }
        }
        this.Qf = new int[i];
        this.Qg = new Object[(i << 1)];
    }

    private static void m11887a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (jl.class) {
                if (QH < 10) {
                    objArr[0] = QG;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    QG = objArr;
                    QH++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (jl.class) {
                if (QF < 10) {
                    objArr[0] = QE;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    QE = objArr;
                    QF++;
                }
            }
        }
    }

    public jv() {
        this.Qf = jn.Qi;
        this.Qg = jn.Qk;
        this.mSize = 0;
    }

    public jv(int i) {
        if (i == 0) {
            this.Qf = jn.Qi;
            this.Qg = jn.Qk;
        } else {
            bi(i);
        }
        this.mSize = 0;
    }

    public jv(jv jvVar) {
        this();
        if (jvVar != null) {
            m11888b(jvVar);
        }
    }

    public void clear() {
        if (this.mSize != 0) {
            m11887a(this.Qf, this.Qg, this.mSize);
            this.Qf = jn.Qi;
            this.Qg = jn.Qk;
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
                System.arraycopy(obj2, 0, this.Qg, 0, this.mSize << 1);
            }
            m11887a(obj, obj2, this.mSize);
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public int indexOfKey(Object obj) {
        return obj == null ? jq() : indexOf(obj, obj.hashCode());
    }

    int indexOfValue(Object obj) {
        int i = 1;
        int i2 = this.mSize * 2;
        Object[] objArr = this.Qg;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public V get(Object obj) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? this.Qg[(indexOfKey << 1) + 1] : null;
    }

    public K keyAt(int i) {
        return this.Qg[i << 1];
    }

    public V valueAt(int i) {
        return this.Qg[(i << 1) + 1];
    }

    public V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.Qg[i2];
        this.Qg[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public V put(K k, V v) {
        int jq;
        int i;
        int i2 = 8;
        if (k == null) {
            jq = jq();
            i = 0;
        } else {
            i = k.hashCode();
            jq = indexOf(k, i);
        }
        if (jq >= 0) {
            int i3 = (jq << 1) + 1;
            V v2 = this.Qg[i3];
            this.Qg[i3] = v;
            return v2;
        }
        jq ^= -1;
        if (this.mSize >= this.Qf.length) {
            if (this.mSize >= 8) {
                i2 = this.mSize + (this.mSize >> 1);
            } else if (this.mSize < 4) {
                i2 = 4;
            }
            Object obj = this.Qf;
            Object obj2 = this.Qg;
            bi(i2);
            if (this.Qf.length > 0) {
                System.arraycopy(obj, 0, this.Qf, 0, obj.length);
                System.arraycopy(obj2, 0, this.Qg, 0, obj2.length);
            }
            m11887a(obj, obj2, this.mSize);
        }
        if (jq < this.mSize) {
            System.arraycopy(this.Qf, jq, this.Qf, jq + 1, this.mSize - jq);
            System.arraycopy(this.Qg, jq << 1, this.Qg, (jq + 1) << 1, (this.mSize - jq) << 1);
        }
        this.Qf[jq] = i;
        this.Qg[jq << 1] = k;
        this.Qg[(jq << 1) + 1] = v;
        this.mSize++;
        return null;
    }

    public void m11888b(jv<? extends K, ? extends V> jvVar) {
        int i = 0;
        int i2 = jvVar.mSize;
        ensureCapacity(this.mSize + i2);
        if (this.mSize != 0) {
            while (i < i2) {
                put(jvVar.keyAt(i), jvVar.valueAt(i));
                i++;
            }
        } else if (i2 > 0) {
            System.arraycopy(jvVar.Qf, 0, this.Qf, 0, i2);
            System.arraycopy(jvVar.Qg, 0, this.Qg, 0, i2 << 1);
            this.mSize = i2;
        }
    }

    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i) {
        int i2 = 8;
        V v = this.Qg[(i << 1) + 1];
        if (this.mSize <= 1) {
            m11887a(this.Qf, this.Qg, this.mSize);
            this.Qf = jn.Qi;
            this.Qg = jn.Qk;
            this.mSize = 0;
        } else if (this.Qf.length <= 8 || this.mSize >= this.Qf.length / 3) {
            this.mSize--;
            if (i < this.mSize) {
                System.arraycopy(this.Qf, i + 1, this.Qf, i, this.mSize - i);
                System.arraycopy(this.Qg, (i + 1) << 1, this.Qg, i << 1, (this.mSize - i) << 1);
            }
            this.Qg[this.mSize << 1] = null;
            this.Qg[(this.mSize << 1) + 1] = null;
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
                System.arraycopy(obj2, 0, this.Qg, 0, i << 1);
            }
            if (i < this.mSize) {
                System.arraycopy(obj, i + 1, this.Qf, i, this.mSize - i);
                System.arraycopy(obj2, (i + 1) << 1, this.Qg, i << 1, (this.mSize - i) << 1);
            }
        }
        return v;
    }

    public int size() {
        return this.mSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        int i;
        Object keyAt;
        Object valueAt;
        Object obj2;
        if (obj instanceof jv) {
            jv jvVar = (jv) obj;
            if (size() != jvVar.size()) {
                return false;
            }
            i = 0;
            while (i < this.mSize) {
                try {
                    keyAt = keyAt(i);
                    valueAt = valueAt(i);
                    obj2 = jvVar.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !jvVar.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
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
        } else if (!(obj instanceof Map)) {
            return false;
        } else {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            i = 0;
            while (i < this.mSize) {
                try {
                    keyAt = keyAt(i);
                    valueAt = valueAt(i);
                    obj2 = map.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !map.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e3) {
                    return false;
                } catch (ClassCastException e4) {
                    return false;
                }
            }
            return true;
        }
    }

    public int hashCode() {
        int[] iArr = this.Qf;
        Object[] objArr = this.Qg;
        int i = this.mSize;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            jv keyAt = keyAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            keyAt = valueAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
