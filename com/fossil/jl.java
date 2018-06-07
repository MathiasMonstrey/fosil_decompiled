package com.fossil;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class jl<K, V> extends jv<K, V> implements Map<K, V> {
    js<K, V> PW;

    class C37561 extends js<K, V> {
        final /* synthetic */ jl PX;

        C37561(jl jlVar) {
            this.PX = jlVar;
        }

        protected int jn() {
            return this.PX.mSize;
        }

        protected Object mo3247y(int i, int i2) {
            return this.PX.Qg[(i << 1) + i2];
        }

        protected int ab(Object obj) {
            return this.PX.indexOfKey(obj);
        }

        protected int ac(Object obj) {
            return this.PX.indexOfValue(obj);
        }

        protected Map<K, V> jo() {
            return this.PX;
        }

        protected void mo3243c(K k, V v) {
            this.PX.put(k, v);
        }

        protected V mo3239a(int i, V v) {
            return this.PX.setValueAt(i, v);
        }

        protected void bh(int i) {
            this.PX.removeAt(i);
        }

        protected void jp() {
            this.PX.clear();
        }
    }

    public jl(int i) {
        super(i);
    }

    public jl(jv jvVar) {
        super(jvVar);
    }

    private js<K, V> jm() {
        if (this.PW == null) {
            this.PW = new C37561(this);
        }
        return this.PW;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean retainAll(Collection<?> collection) {
        return js.m11879c((Map) this, (Collection) collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return jm().jt();
    }

    public Set<K> keySet() {
        return jm().getKeySet();
    }

    public Collection<V> values() {
        return jm().ju();
    }
}
