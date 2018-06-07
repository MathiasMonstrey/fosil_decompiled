package com.fossil;

import com.ua.sdk.UaException;
import com.ua.sdk.cache.DiskCache;
import java.util.concurrent.ExecutorService;

public class efk extends eij<efd> implements efj {
    public efk(egi com_fossil_egi, egh com_fossil_egh, DiskCache<efd> diskCache, eiq<efd> com_fossil_eiq_com_fossil_efd, ExecutorService executorService) {
        super(com_fossil_egi, com_fossil_egh, diskCache, com_fossil_eiq_com_fossil_efd, executorService);
    }

    public efe aCQ() {
        return new eff();
    }

    public efd mo2835a(efd com_fossil_efd) throws UaException {
        m10593b(com_fossil_efd);
        return (efd) m10504g(com_fossil_efd);
    }

    private void m10593b(efd com_fossil_efd) {
        eiy.dd(com_fossil_efd.aCM());
        eiy.dd(com_fossil_efd.aCN());
    }
}
