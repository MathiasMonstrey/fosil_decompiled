package org.parceler;

import java.util.ArrayList;
import java.util.List;

public final class IdentityCollection {
    private static final Object RESERVATION = new Object();
    private final List<Object> values = new ArrayList();

    public IdentityCollection() {
        put(null);
    }

    public boolean containsKey(int i) {
        return i < this.values.size();
    }

    public int reserve() {
        return put(RESERVATION);
    }

    public boolean isReserved(int i) {
        return this.values.get(i) == RESERVATION;
    }

    public void put(int i, Object obj) {
        this.values.remove(i);
        this.values.add(i, obj);
    }

    public int put(Object obj) {
        this.values.add(obj);
        return this.values.size() - 1;
    }

    public <T> T get(int i) {
        return this.values.get(i);
    }

    public int getKey(Object obj) {
        for (int i = 0; i < this.values.size(); i++) {
            if (this.values.get(i) == obj) {
                return i;
            }
        }
        return -1;
    }
}
