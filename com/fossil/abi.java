package com.fossil;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class abi<T, Y> {
    private int Qq;
    private final int aCw;
    private final LinkedHashMap<T, Y> aHa = new LinkedHashMap(100, 0.75f, true);
    private int qo = 0;

    public abi(int i) {
        this.aCw = i;
        this.Qq = i;
    }

    protected int bg(Y y) {
        return 1;
    }

    protected void m2859h(T t, Y y) {
    }

    public int wW() {
        return this.qo;
    }

    public Y get(T t) {
        return this.aHa.get(t);
    }

    public Y put(T t, Y y) {
        if (bg(y) >= this.Qq) {
            m2859h(t, y);
            return null;
        }
        Y put = this.aHa.put(t, y);
        if (y != null) {
            this.qo += bg(y);
        }
        if (put != null) {
            this.qo -= bg(put);
        }
        ve();
        return put;
    }

    public Y remove(T t) {
        Y remove = this.aHa.remove(t);
        if (remove != null) {
            this.qo -= bg(remove);
        }
        return remove;
    }

    public void tN() {
        trimToSize(0);
    }

    protected void trimToSize(int i) {
        while (this.qo > i) {
            Entry entry = (Entry) this.aHa.entrySet().iterator().next();
            Object value = entry.getValue();
            this.qo -= bg(value);
            Object key = entry.getKey();
            this.aHa.remove(key);
            m2859h(key, value);
        }
    }

    private void ve() {
        trimToSize(this.Qq);
    }
}
