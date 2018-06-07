package com.google.common.collect;

import com.fossil.cco;
import com.fossil.ccw;
import com.fossil.cdf;
import com.fossil.cdt;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Map.Entry;

final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap(null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    private final transient Object[] bMC;
    private final transient int[] bNW;
    private final transient int size;

    static class EntrySet<K, V> extends ImmutableSet<Entry<K, V>> {
        private final transient Object[] bMC;
        private final transient int bNX;
        private final transient ImmutableMap<K, V> map;
        private final transient int size;

        class C43631 extends ImmutableList<Entry<K, V>> {
            C43631() {
            }

            public Entry<K, V> get(int i) {
                cco.bO(i, EntrySet.this.size);
                return new SimpleImmutableEntry(EntrySet.this.bMC[(i * 2) + EntrySet.this.bNX], EntrySet.this.bMC[(i * 2) + (EntrySet.this.bNX ^ 1)]);
            }

            public int size() {
                return EntrySet.this.size;
            }

            public boolean isPartialView() {
                return true;
            }
        }

        EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i, int i2) {
            this.map = immutableMap;
            this.bMC = objArr;
            this.bNX = i;
            this.size = i2;
        }

        public cdt<Entry<K, V>> iterator() {
            return asList().iterator();
        }

        ImmutableList<Entry<K, V>> createAsList() {
            return new C43631();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.map.get(key))) {
                return false;
            }
            return true;
        }

        boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.size;
        }
    }

    static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableList<K> bNY;
        private final transient ImmutableMap<K, ?> map;

        KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.map = immutableMap;
            this.bNY = immutableList;
        }

        public cdt<K> iterator() {
            return asList().iterator();
        }

        public ImmutableList<K> asList() {
            return this.bNY;
        }

        public boolean contains(Object obj) {
            return this.map.get(obj) != null;
        }

        boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.map.size();
        }
    }

    static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] bMC;
        private final transient int offset;
        private final transient int size;

        KeysOrValuesAsList(Object[] objArr, int i, int i2) {
            this.bMC = objArr;
            this.offset = i;
            this.size = i2;
        }

        public Object get(int i) {
            cco.bO(i, this.size);
            return this.bMC[(i * 2) + this.offset];
        }

        boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.size;
        }
    }

    static <K, V> RegularImmutableMap<K, V> create(int i, Object[] objArr) {
        if (i == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i == 1) {
            ccw.w(objArr[0], objArr[1]);
            return new RegularImmutableMap(null, objArr, 1);
        }
        cco.bP(i, objArr.length >> 1);
        return new RegularImmutableMap(createHashTable(objArr, i, ImmutableSet.chooseTableSize(i), 0), objArr, i);
    }

    static int[] createHashTable(Object[] objArr, int i, int i2, int i3) {
        if (i == 1) {
            ccw.w(objArr[i3], objArr[i3 ^ 1]);
            return null;
        }
        int i4 = i2 - 1;
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[(i5 * 2) + i3];
            Object obj2 = objArr[(i5 * 2) + (i3 ^ 1)];
            ccw.w(obj, obj2);
            int iv = cdf.iv(obj.hashCode());
            while (true) {
                iv &= i4;
                int i6 = iArr[iv];
                if (i6 == -1) {
                    break;
                } else if (objArr[i6].equals(obj)) {
                    throw new IllegalArgumentException("Multiple entries with same key: " + obj + SimpleComparison.EQUAL_TO_OPERATION + obj2 + " and " + objArr[i6] + SimpleComparison.EQUAL_TO_OPERATION + objArr[i6 ^ 1]);
                } else {
                    iv++;
                }
            }
            iArr[iv] = (i5 * 2) + i3;
        }
        return iArr;
    }

    private RegularImmutableMap(int[] iArr, Object[] objArr, int i) {
        this.bNW = iArr;
        this.bMC = objArr;
        this.size = i;
    }

    public int size() {
        return this.size;
    }

    public V get(Object obj) {
        return get(this.bNW, this.bMC, this.size, 0, obj);
    }

    static Object get(int[] iArr, Object[] objArr, int i, int i2, Object obj) {
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[i2].equals(obj)) {
                return objArr[i2 ^ 1];
            }
            return null;
        } else if (iArr == null) {
            return null;
        } else {
            int length = iArr.length - 1;
            int iv = cdf.iv(obj.hashCode());
            while (true) {
                iv &= length;
                int i3 = iArr[iv];
                if (i3 == -1) {
                    return null;
                }
                if (objArr[i3].equals(obj)) {
                    return objArr[i3 ^ 1];
                }
                iv++;
            }
        }
    }

    ImmutableSet<Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.bMC, 0, this.size);
    }

    ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.bMC, 0, this.size));
    }

    ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.bMC, 1, this.size);
    }

    boolean isPartialView() {
        return false;
    }
}
