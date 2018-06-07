package com.fossil;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class apg<K, V> {
    public final Map<K, List<V>> aZV = new HashMap();
    private int f1445b;

    public final void HJ() {
        this.aZV.clear();
    }

    public final List<V> bH(K k) {
        if (k == null) {
            return Collections.emptyList();
        }
        List<V> p = m4166p(k, false);
        if (p == null) {
            return Collections.emptyList();
        }
        return p;
    }

    public final List<V> m4166p(K k, boolean z) {
        List<V> list = (List) this.aZV.get(k);
        if (z && list == null) {
            if (this.f1445b > 0) {
                list = new ArrayList(this.f1445b);
            } else {
                list = new ArrayList();
            }
            this.aZV.put(k, list);
        }
        return list;
    }

    public final void m4164n(K k, V v) {
        if (k != null) {
            m4166p(k, true).add(v);
        }
    }

    public final boolean m4165o(K k, V v) {
        boolean z = false;
        if (k != null) {
            List p = m4166p(k, false);
            if (p != null) {
                z = p.remove(v);
                if (p.size() == 0) {
                    this.aZV.remove(k);
                }
            }
        }
        return z;
    }

    public final boolean bI(K k) {
        if (k == null) {
            return false;
        }
        return ((List) this.aZV.remove(k)) != null;
    }

    public final Collection<Entry<K, V>> IU() {
        Collection arrayList = new ArrayList();
        for (Entry entry : this.aZV.entrySet()) {
            for (Object simpleImmutableEntry : (List) entry.getValue()) {
                arrayList.add(new SimpleImmutableEntry(entry.getKey(), simpleImmutableEntry));
            }
        }
        return arrayList;
    }
}
