package com.fossil;

public final class boc<V> {
    private final String bvf;
    private final V bzg;
    private final bhk<V> bzh;

    private boc(String str, bhk<V> com_fossil_bhk_V, V v) {
        awa.bO(com_fossil_bhk_V);
        this.bzh = com_fossil_bhk_V;
        this.bzg = v;
        this.bvf = str;
    }

    static boc<Long> m5378a(String str, long j, long j2) {
        return new boc(str, bhk.m5180a(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    static boc<Boolean> m5379b(String str, boolean z, boolean z2) {
        return new boc(str, bhk.m5181k(str, z2), Boolean.valueOf(z));
    }

    static boc<String> m5380f(String str, String str2, String str3) {
        return new boc(str, bhk.m5178P(str, str3), str2);
    }

    static boc<Integer> m5381q(String str, int i, int i2) {
        return new boc(str, bhk.m5179a(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    public final V get() {
        return this.bzg;
    }

    public final V get(V v) {
        return v != null ? v : this.bzg;
    }

    public final String getKey() {
        return this.bvf;
    }
}
