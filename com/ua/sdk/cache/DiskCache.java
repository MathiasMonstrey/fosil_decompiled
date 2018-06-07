package com.ua.sdk.cache;

import com.fossil.ecj;
import com.fossil.ecm;

public interface DiskCache<T extends ecm> {

    public enum State {
        NONE,
        CREATED,
        MODIFIED,
        SYNCED,
        DELETED
    }

    void m16156a(long j, T t);

    T m16157b(ecj com_fossil_ecj);

    long m16158c(ecj com_fossil_ecj);

    void m16159c(T t);

    long m16160d(T t);
}
