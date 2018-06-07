package com.fossil;

public final class amn<T> {
    private amn<T> aVM;
    private final T value;

    public amn(T t, amn<T> com_fossil_amn_T) {
        this.value = t;
        this.aVM = com_fossil_amn_T;
    }

    public void m3883a(amn<T> com_fossil_amn_T) {
        if (this.aVM != null) {
            throw new IllegalStateException();
        }
        this.aVM = com_fossil_amn_T;
    }

    public amn<T> Hm() {
        return this.aVM;
    }

    public T Hn() {
        return this.value;
    }

    public static <ST> boolean m3882a(amn<ST> com_fossil_amn_ST, ST st) {
        while (com_fossil_amn_ST != null) {
            if (com_fossil_amn_ST.Hn() == st) {
                return true;
            }
            com_fossil_amn_ST = com_fossil_amn_ST.Hm();
        }
        return false;
    }
}
