package com.fossil;

import com.ua.sdk.cache.CachePolicy;

public class egi {
    private final long dGL;
    private final CachePolicy dGM;

    public egi(CachePolicy cachePolicy, long j) {
        this.dGM = (CachePolicy) eiy.dd(cachePolicy);
        this.dGL = j;
    }

    public long aDc() {
        return this.dGL;
    }

    public CachePolicy aDd() {
        return this.dGM;
    }
}
