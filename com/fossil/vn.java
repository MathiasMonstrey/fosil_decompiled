package com.fossil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class vn<K extends vq, V> {
    private final C4160a<K, V> aCp = new C4160a();
    private final Map<K, C4160a<K, V>> aCq = new HashMap();

    static class C4160a<K, V> {
        C4160a<K, V> aCr;
        C4160a<K, V> aCs;
        private final K key;
        private List<V> values;

        public C4160a() {
            this(null);
        }

        public C4160a(K k) {
            this.aCs = this;
            this.aCr = this;
            this.key = k;
        }

        public V removeLast() {
            int size = size();
            return size > 0 ? this.values.remove(size - 1) : null;
        }

        public int size() {
            return this.values != null ? this.values.size() : 0;
        }

        public void add(V v) {
            if (this.values == null) {
                this.values = new ArrayList();
            }
            this.values.add(v);
        }
    }

    vn() {
    }

    public void m13932a(K k, V v) {
        C4160a c4160a = (C4160a) this.aCq.get(k);
        if (c4160a == null) {
            c4160a = new C4160a(k);
            m13929b(c4160a);
            this.aCq.put(k, c4160a);
        } else {
            k.va();
        }
        c4160a.add(v);
    }

    public V m13933b(K k) {
        C4160a c4160a = (C4160a) this.aCq.get(k);
        if (c4160a == null) {
            c4160a = new C4160a(k);
            this.aCq.put(k, c4160a);
        } else {
            k.va();
        }
        m13928a(c4160a);
        return c4160a.removeLast();
    }

    public V removeLast() {
        for (C4160a c4160a = this.aCp.aCs; !c4160a.equals(this.aCp); c4160a = c4160a.aCs) {
            V removeLast = c4160a.removeLast();
            if (removeLast != null) {
                return removeLast;
            }
            m13931d(c4160a);
            this.aCq.remove(c4160a.key);
            ((vq) c4160a.key).va();
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GroupedLinkedMap( ");
        Object obj = null;
        for (C4160a c4160a = this.aCp.aCr; !c4160a.equals(this.aCp); c4160a = c4160a.aCr) {
            obj = 1;
            stringBuilder.append('{').append(c4160a.key).append(':').append(c4160a.size()).append("}, ");
        }
        if (obj != null) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        return stringBuilder.append(" )").toString();
    }

    private void m13928a(C4160a<K, V> c4160a) {
        m13931d(c4160a);
        c4160a.aCs = this.aCp;
        c4160a.aCr = this.aCp.aCr;
        m13930c(c4160a);
    }

    private void m13929b(C4160a<K, V> c4160a) {
        m13931d(c4160a);
        c4160a.aCs = this.aCp.aCs;
        c4160a.aCr = this.aCp;
        m13930c(c4160a);
    }

    private static <K, V> void m13930c(C4160a<K, V> c4160a) {
        c4160a.aCr.aCs = c4160a;
        c4160a.aCs.aCr = c4160a;
    }

    private static <K, V> void m13931d(C4160a<K, V> c4160a) {
        c4160a.aCs.aCr = c4160a.aCr;
        c4160a.aCr.aCs = c4160a.aCs;
    }
}
