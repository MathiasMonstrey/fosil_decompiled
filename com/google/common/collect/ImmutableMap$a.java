package com.google.common.collect;

import com.fossil.ccw;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class ImmutableMap$a<K, V> {
    Comparator<? super V> bMB;
    Object[] bMC;
    boolean bMD;
    int size;

    public ImmutableMap$a() {
        this(4);
    }

    ImmutableMap$a(int i) {
        this.bMC = new Object[(i * 2)];
        this.size = 0;
        this.bMD = false;
    }

    private void ensureCapacity(int i) {
        if (i * 2 > this.bMC.length) {
            this.bMC = Arrays.copyOf(this.bMC, ImmutableCollection$b.bQ(this.bMC.length, i * 2));
            this.bMD = false;
        }
    }

    public ImmutableMap$a<K, V> m14325z(K k, V v) {
        ensureCapacity(this.size + 1);
        ccw.w(k, v);
        this.bMC[this.size * 2] = k;
        this.bMC[(this.size * 2) + 1] = v;
        this.size++;
        return this;
    }

    public ImmutableMap$a<K, V> m14322e(Entry<? extends K, ? extends V> entry) {
        return m14325z(entry.getKey(), entry.getValue());
    }

    public ImmutableMap$a<K, V> m14324s(Map<? extends K, ? extends V> map) {
        return m14323i(map.entrySet());
    }

    public ImmutableMap$a<K, V> m14323i(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
        if (iterable instanceof Collection) {
            ensureCapacity(((Collection) iterable).size() + this.size);
        }
        for (Entry e : iterable) {
            m14322e(e);
        }
        return this;
    }

    public ImmutableMap<K, V> UJ() {
        UK();
        this.bMD = true;
        return RegularImmutableMap.create(this.size, this.bMC);
    }

    void UK() {
        int i = 0;
        if (this.bMB != null) {
            if (this.bMD) {
                this.bMC = Arrays.copyOf(this.bMC, this.size * 2);
            }
            Entry[] entryArr = new Entry[this.size];
            for (int i2 = 0; i2 < this.size; i2++) {
                entryArr[i2] = new SimpleImmutableEntry(this.bMC[i2 * 2], this.bMC[(i2 * 2) + 1]);
            }
            Arrays.sort(entryArr, 0, this.size, Ordering.from(this.bMB).onResultOf(Maps.Vt()));
            while (i < this.size) {
                this.bMC[i * 2] = entryArr[i].getKey();
                this.bMC[(i * 2) + 1] = entryArr[i].getValue();
                i++;
            }
        }
    }
}
