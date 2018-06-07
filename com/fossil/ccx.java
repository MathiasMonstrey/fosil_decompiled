package com.fossil;

import java.util.Collection;

public final class ccx {
    public static boolean m6001a(Collection<?> collection, Object obj) {
        boolean z = false;
        cco.ce(collection);
        try {
            z = collection.contains(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return z;
    }

    static boolean m6002a(Collection<?> collection, Collection<?> collection2) {
        for (Object contains : collection2) {
            if (!collection.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    static String m6004f(Collection<?> collection) {
        StringBuilder append = iu(collection.size()).append('[');
        Object obj = 1;
        for (Collection<?> next : collection) {
            if (obj == null) {
                append.append(", ");
            }
            obj = null;
            if (next == collection) {
                append.append("(this Collection)");
            } else {
                append.append(next);
            }
        }
        return append.append(']').toString();
    }

    public static StringBuilder iu(int i) {
        ccw.m5998n(i, "size");
        return new StringBuilder((int) Math.min(((long) i) * 8, 1073741824));
    }

    public static <T> Collection<T> m6003c(Iterable<T> iterable) {
        return (Collection) iterable;
    }
}
