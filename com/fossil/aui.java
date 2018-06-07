package com.fossil;

import java.util.ArrayList;

public final class aui {
    public static <T, E extends auj<T>> ArrayList<T> m4499a(auh<E> com_fossil_auh_E) {
        ArrayList<T> arrayList = new ArrayList(com_fossil_auh_E.getCount());
        try {
            for (E freeze : com_fossil_auh_E) {
                arrayList.add(freeze.freeze());
            }
            return arrayList;
        } finally {
            com_fossil_auh_E.close();
        }
    }
}
