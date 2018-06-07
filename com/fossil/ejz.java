package com.fossil;

import com.ua.sdk.UaException;
import com.ua.sdk.cache.DiskCache;
import java.util.concurrent.ExecutorService;

public class ejz extends eij<eju> implements ejy {
    private ecw dJb;

    public ejz(ecw com_fossil_ecw, egi com_fossil_egi, egh com_fossil_egh, DiskCache<eju> diskCache, eiq<eju> com_fossil_eiq_com_fossil_eju, ExecutorService executorService) {
        super(com_fossil_egi, com_fossil_egh, diskCache, com_fossil_eiq_com_fossil_eju, executorService);
        this.dJb = com_fossil_ecw;
    }

    public eju mo2902b(ece<eju> com_fossil_ece_com_fossil_eju) throws UaException {
        return (eju) m10503e(com_fossil_ece_com_fossil_eju);
    }

    public void mo2903c(ece<eju> com_fossil_ece_com_fossil_eju) throws UaException {
        this.dJb.mo2804a((ece) com_fossil_ece_com_fossil_eju);
    }
}
