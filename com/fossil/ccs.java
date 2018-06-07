package com.fossil;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Map.Entry;

public abstract class ccs<K, V> implements Entry<K, V> {
    public abstract K getKey();

    public abstract V getValue();

    protected ccs() {
    }

    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (ccn.equal(getKey(), entry.getKey()) && ccn.equal(getValue(), entry.getValue())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        Object key = getKey();
        Object value = getValue();
        int hashCode = key == null ? 0 : key.hashCode();
        if (value != null) {
            i = value.hashCode();
        }
        return i ^ hashCode;
    }

    public String toString() {
        return getKey() + SimpleComparison.EQUAL_TO_OPERATION + getValue();
    }
}
