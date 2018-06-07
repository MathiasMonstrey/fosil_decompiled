package com.google.common.collect;

import com.fossil.cck;
import com.fossil.ccn;
import com.fossil.cco;
import com.fossil.ccw;
import com.fossil.ccx;
import com.fossil.cds;
import com.google.common.collect.Sets.C4278a;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Maps {

    static abstract class C4279a<K, V> extends C4278a<Entry<K, V>> {
        abstract Map<K, V> Ug();

        C4279a() {
        }

        public int size() {
            return Ug().size();
        }

        public void clear() {
            Ug().clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            Object a = Maps.m14453a(Ug(), key);
            if (!ccn.equal(a, entry.getValue())) {
                return false;
            }
            if (a != null || Ug().containsKey(key)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return Ug().isEmpty();
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            return Ug().keySet().remove(((Entry) obj).getKey());
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) cco.ce(collection));
            } catch (UnsupportedOperationException e) {
                return Sets.m14481a((Set) this, collection.iterator());
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) cco.ce(collection));
            } catch (UnsupportedOperationException e) {
                Collection iN = Sets.iN(collection.size());
                for (Object next : collection) {
                    if (contains(next)) {
                        iN.add(((Entry) next).getKey());
                    }
                }
                return Ug().keySet().retainAll(iN);
            }
        }
    }

    static abstract class C4282d<K, V> extends AbstractMap<K, V> {
        private transient Set<Entry<K, V>> entrySet;
        private transient Set<K> keySet;
        private transient Collection<V> values;

        abstract Set<Entry<K, V>> Uf();

        C4282d() {
        }

        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            set = Uf();
            this.entrySet = set;
            return set;
        }

        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            set = createKeySet();
            this.keySet = set;
            return set;
        }

        Set<K> createKeySet() {
            return new C4285b(this);
        }

        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            collection = createValues();
            this.values = collection;
            return collection;
        }

        Collection<V> createValues() {
            return new C4345c(this);
        }
    }

    public static class C4285b<K, V> extends C4278a<K> {
        final Map<K, V> map;

        public C4285b(Map<K, V> map) {
            this.map = (Map) cco.ce(map);
        }

        Map<K, V> Ug() {
            return this.map;
        }

        public Iterator<K> iterator() {
            return Maps.m14461m(Ug().entrySet().iterator());
        }

        public int size() {
            return Ug().size();
        }

        public boolean isEmpty() {
            return Ug().isEmpty();
        }

        public boolean contains(Object obj) {
            return Ug().containsKey(obj);
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            Ug().remove(obj);
            return true;
        }

        public void clear() {
            Ug().clear();
        }
    }

    static class C43421 extends cds<K, Entry<K, V>> {
        final /* synthetic */ cck bNa;

        /* synthetic */ Object cu(Object obj) {
            return cv(obj);
        }

        Entry<K, V> cv(K k) {
            return Maps.m14452B(k, this.bNa.apply(k));
        }
    }

    enum EntryFunction implements cck<Entry<?, ?>, Object> {
        KEY {
            public Object apply(Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE {
            public Object apply(Entry<?, ?> entry) {
                return entry.getValue();
            }
        }
    }

    static class C4345c<K, V> extends AbstractCollection<V> {
        final Map<K, V> map;

        C4345c(Map<K, V> map) {
            this.map = (Map) cco.ce(map);
        }

        final Map<K, V> Ug() {
            return this.map;
        }

        public Iterator<V> iterator() {
            return Maps.m14462n(Ug().entrySet().iterator());
        }

        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException e) {
                for (Entry entry : Ug().entrySet()) {
                    if (ccn.equal(obj, entry.getValue())) {
                        Ug().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) cco.ce(collection));
            } catch (UnsupportedOperationException e) {
                Collection VC = Sets.VC();
                for (Entry entry : Ug().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        VC.add(entry.getKey());
                    }
                }
                return Ug().keySet().removeAll(VC);
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) cco.ce(collection));
            } catch (UnsupportedOperationException e) {
                Collection VC = Sets.VC();
                for (Entry entry : Ug().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        VC.add(entry.getKey());
                    }
                }
                return Ug().keySet().retainAll(VC);
            }
        }

        public int size() {
            return Ug().size();
        }

        public boolean isEmpty() {
            return Ug().isEmpty();
        }

        public boolean contains(Object obj) {
            return Ug().containsValue(obj);
        }

        public void clear() {
            Ug().clear();
        }
    }

    static <K> cck<Entry<K, ?>, K> Vs() {
        return EntryFunction.KEY;
    }

    static <V> cck<Entry<?, V>, V> Vt() {
        return EntryFunction.VALUE;
    }

    static <K, V> Iterator<K> m14461m(Iterator<Entry<K, V>> it) {
        return Iterators.m14360a((Iterator) it, Vs());
    }

    public static <K, V> Iterator<V> m14462n(Iterator<Entry<K, V>> it) {
        return Iterators.m14360a((Iterator) it, Vt());
    }

    public static <K, V> HashMap<K, V> Vu() {
        return new HashMap();
    }

    public static <K, V> HashMap<K, V> iB(int i) {
        return new HashMap(iC(i));
    }

    static int iC(int i) {
        if (i < 3) {
            ccw.n(i, "expectedSize");
            return i + 1;
        } else if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static <K, V> LinkedHashMap<K, V> iD(int i) {
        return new LinkedHashMap(iC(i));
    }

    public static <K, V> Entry<K, V> m14452B(K k, V v) {
        return new ImmutableEntry(k, v);
    }

    static <V> V m14453a(Map<?, V> map, Object obj) {
        V v = null;
        cco.ce(map);
        try {
            v = map.get(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return v;
    }

    static boolean m14455b(Map<?, ?> map, Object obj) {
        boolean z = false;
        cco.ce(map);
        try {
            z = map.containsKey(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return z;
    }

    static <V> V m14456c(Map<?, V> map, Object obj) {
        V v = null;
        cco.ce(map);
        try {
            v = map.remove(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return v;
    }

    public static boolean m14457d(Map<?, ?> map, Object obj) {
        return Iterators.m14362a(m14461m(map.entrySet().iterator()), obj);
    }

    public static boolean m14458e(Map<?, ?> map, Object obj) {
        return Iterators.m14362a(m14462n(map.entrySet().iterator()), obj);
    }

    public static boolean m14459f(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return map.entrySet().equals(((Map) obj).entrySet());
    }

    public static String m14463t(Map<?, ?> map) {
        StringBuilder append = ccx.iu(map.size()).append('{');
        Object obj = 1;
        for (Entry entry : map.entrySet()) {
            if (obj == null) {
                append.append(", ");
            }
            obj = null;
            append.append(entry.getKey()).append('=').append(entry.getValue());
        }
        return append.append('}').toString();
    }

    public static <K, V> void m14454b(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Entry entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    static <E> ImmutableMap<E, Integer> m14460h(Collection<E> collection) {
        ImmutableMap$a immutableMap$a = new ImmutableMap$a(collection.size());
        int i = 0;
        for (E z : collection) {
            int i2 = i + 1;
            immutableMap$a.m14325z(z, Integer.valueOf(i));
            i = i2;
        }
        return immutableMap$a.UJ();
    }
}
