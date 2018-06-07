package com.google.common.collect;

import com.fossil.ccs;
import com.fossil.cdt;
import java.util.Iterator;
import java.util.Map.Entry;

final class ImmutableMap$MapViewOfValuesAsSingletonSets extends ImmutableMap$IteratorBasedImmutableMap<K, ImmutableSet<V>> {
    final /* synthetic */ ImmutableMap this$0;

    private ImmutableMap$MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap) {
        this.this$0 = immutableMap;
    }

    public int size() {
        return this.this$0.size();
    }

    ImmutableSet<K> createKeySet() {
        return this.this$0.keySet();
    }

    public boolean containsKey(Object obj) {
        return this.this$0.containsKey(obj);
    }

    public ImmutableSet<V> get(Object obj) {
        Object obj2 = this.this$0.get(obj);
        return obj2 == null ? null : ImmutableSet.of(obj2);
    }

    boolean isPartialView() {
        return this.this$0.isPartialView();
    }

    public int hashCode() {
        return this.this$0.hashCode();
    }

    boolean isHashCodeFast() {
        return this.this$0.isHashCodeFast();
    }

    cdt<Entry<K, ImmutableSet<V>>> entryIterator() {
        final Iterator it = this.this$0.entrySet().iterator();
        return new cdt<Entry<K, ImmutableSet<V>>>(this) {
            final /* synthetic */ ImmutableMap$MapViewOfValuesAsSingletonSets bMF;

            public /* synthetic */ Object next() {
                return jv();
            }

            public boolean hasNext() {
                return it.hasNext();
            }

            public Entry<K, ImmutableSet<V>> jv() {
                final Entry entry = (Entry) it.next();
                return new ccs<K, ImmutableSet<V>>(this) {
                    final /* synthetic */ C43001 bMH;

                    public /* synthetic */ Object getValue() {
                        return UL();
                    }

                    public K getKey() {
                        return entry.getKey();
                    }

                    public ImmutableSet<V> UL() {
                        return ImmutableSet.of(entry.getValue());
                    }
                };
            }
        };
    }
}
