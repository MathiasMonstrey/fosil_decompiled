package com.google.common.collect;

import com.fossil.cdt;
import java.io.Serializable;
import java.util.Map.Entry;

final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    private final ImmutableMap<K, V> map;

    class C43011 extends cdt<V> {
        final cdt<Entry<K, V>> bMI = ImmutableMapValues.this.map.entrySet().iterator();

        C43011() {
        }

        public boolean hasNext() {
            return this.bMI.hasNext();
        }

        public V next() {
            return ((Entry) this.bMI.next()).getValue();
        }
    }

    static class SerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<?, V> map;

        SerializedForm(ImmutableMap<?, V> immutableMap) {
            this.map = immutableMap;
        }

        Object readResolve() {
            return this.map.values();
        }
    }

    ImmutableMapValues(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    public int size() {
        return this.map.size();
    }

    public cdt<V> iterator() {
        return new C43011();
    }

    public boolean contains(Object obj) {
        return obj != null && Iterators.m14362a(iterator(), obj);
    }

    boolean isPartialView() {
        return true;
    }

    public ImmutableList<V> asList() {
        final ImmutableList asList = this.map.entrySet().asList();
        return new ImmutableList<V>() {
            public V get(int i) {
                return ((Entry) asList.get(i)).getValue();
            }

            boolean isPartialView() {
                return true;
            }

            public int size() {
                return asList.size();
            }
        };
    }

    Object writeReplace() {
        return new SerializedForm(this.map);
    }
}
