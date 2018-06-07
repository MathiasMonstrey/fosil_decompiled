package com.fossil;

import java.util.List;

public final class bjf {
    public static <T> int m5226a(T t, List<T> list) {
        if (t == null) {
            return -1;
        }
        int indexOf = list.indexOf(t);
        if (indexOf >= 0) {
            return indexOf;
        }
        list.add(t);
        return list.size() - 1;
    }
}
