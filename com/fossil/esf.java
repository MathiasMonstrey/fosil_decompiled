package com.fossil;

import java.util.Map;
import java.util.NoSuchElementException;

class esf {
    public static final <K, V> V m11121g(Map<K, ? extends V> map, K k) {
        esl.m11128j(map, "$receiver");
        if (map instanceof esd) {
            return ((esd) map).dk(k);
        }
        V v = map.get(k);
        if (v != null || map.containsKey(k)) {
            return v;
        }
        throw new NoSuchElementException("Key " + k + " is missing in the map.");
    }
}
