package com.fossil;

import com.ua.sdk.UaException;
import com.ua.sdk.cache.CachePolicy;
import com.ua.sdk.cache.DiskCache;
import java.util.concurrent.ExecutorService;

public abstract class eij<T extends ecm> {
    protected final egh dHZ;
    protected final DiskCache<T> dIa;
    protected final eiq<T> dIb;
    protected final egi dIc;
    protected final ExecutorService dwX;

    protected eij(egi com_fossil_egi, egh com_fossil_egh, DiskCache<T> diskCache, eiq<T> com_fossil_eiq_T, ExecutorService executorService) {
        this.dIc = (egi) eiy.dd(com_fossil_egi);
        if (diskCache == null) {
            this.dIa = new egj();
        } else {
            this.dIa = diskCache;
        }
        if (com_fossil_egh == null) {
            this.dHZ = new egk();
        } else {
            this.dHZ = com_fossil_egh;
        }
        this.dwX = executorService;
        this.dIb = com_fossil_eiq_T;
    }

    public T m10504g(T t) throws UaException {
        eiy.dd(t);
        long d = this.dIa.d(t);
        ecm h = mo2939h(this.dIb.mo2818g(t));
        this.dIa.a(d, h);
        this.dHZ.mo2861b(h);
        return h;
    }

    protected T mo2939h(T t) throws UaException {
        return t;
    }

    public T m10503e(ecj com_fossil_ecj) throws UaException {
        return m10501a(com_fossil_ecj, this.dIc.aDd());
    }

    protected T m10501a(ecj com_fossil_ecj, CachePolicy cachePolicy) throws UaException {
        return m10502a(com_fossil_ecj, cachePolicy, true);
    }

    protected T m10502a(ecj com_fossil_ecj, CachePolicy cachePolicy, boolean z) throws UaException {
        if (com_fossil_ecj == null) {
            throw new UaException("ref can't be null");
        }
        if (cachePolicy == null) {
            cachePolicy = this.dIc.aDd();
        }
        T t = null;
        if (cachePolicy.checkCacheFirst()) {
            long c;
            if (z) {
                c = this.dHZ.mo2862c(com_fossil_ecj);
                if (cachePolicy.ignoreAge() || (c >= 0 && c <= this.dIc.aDc())) {
                    t = this.dHZ.mo2860b(com_fossil_ecj);
                    if (t != null) {
                        return t;
                    }
                }
            }
            c = this.dIa.c(com_fossil_ecj);
            if (cachePolicy.ignoreAge() || (c >= 0 && c <= this.dIc.aDc())) {
                t = this.dIa.b(com_fossil_ecj);
                if (t != null) {
                    this.dHZ.mo2861b((ecm) t);
                    return t;
                }
            }
        }
        if (!cachePolicy.checkNetwork()) {
            return t;
        }
        try {
            ecm a = mo2936a(com_fossil_ecj, this.dIb.mo2817e(com_fossil_ecj));
            if (a == null) {
                return a;
            }
            this.dIa.c(a);
            this.dHZ.mo2861b(a);
            return a;
        } catch (UaException e) {
            if (cachePolicy.checkNetworkFirst() && cachePolicy.checkCache()) {
                return m10502a(com_fossil_ecj, CachePolicy.CACHE_ONLY, z);
            }
            throw e;
        }
    }

    protected T mo2936a(ecj com_fossil_ecj, T t) throws UaException {
        return t;
    }
}
