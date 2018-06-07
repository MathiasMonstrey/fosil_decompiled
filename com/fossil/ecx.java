package com.fossil;

import com.misfit.frameworks.common.constants.Constants;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.DiskCache;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class ecx extends eij<ect> implements ecw {
    private ekv dDK;
    private ejy dDL;

    public ecx(ekv com_fossil_ekv, egi com_fossil_egi, egh com_fossil_egh, DiskCache<ect> diskCache, eiq<ect> com_fossil_eiq_com_fossil_ect, ExecutorService executorService) {
        super(com_fossil_egi, com_fossil_egh, diskCache, com_fossil_eiq_com_fossil_ect, executorService);
        this.dDK = com_fossil_ekv;
    }

    public void mo2805a(ejy com_fossil_ejy) {
        this.dDL = com_fossil_ejy;
    }

    public ect mo2804a(ece<eju> com_fossil_ece_com_fossil_eju) throws UaException {
        if (!(com_fossil_ece_com_fossil_eju instanceof ekc) || ((ekc) com_fossil_ece_com_fossil_eju).aCM() == null || ((ekc) com_fossil_ece_com_fossil_eju).aCM().equals("")) {
            return (ect) m10504g(m10506a(Constants.ACTIVITY, this.dDL.mo2902b(com_fossil_ece_com_fossil_eju)));
        }
        return (ect) m10504g(m10507a(Constants.ACTIVITY, (ekc) com_fossil_ece_com_fossil_eju));
    }

    private ect m10506a(String str, eju com_fossil_eju) {
        Object com_fossil_ecu = new ecu();
        List arrayList = new ArrayList();
        if (str.equals("sleep")) {
            arrayList.add(com_fossil_eju.aCM());
            com_fossil_ecu.aF(arrayList);
        } else {
            arrayList.add(com_fossil_eju.aCM());
            com_fossil_ecu.aE(arrayList);
        }
        return com_fossil_ecu;
    }

    private ect m10507a(String str, ekc com_fossil_ekc) {
        Object com_fossil_ecu = new ecu();
        List arrayList = new ArrayList();
        if (str.equals("sleep")) {
            arrayList.add(com_fossil_ekc.aCM());
            com_fossil_ecu.aF(arrayList);
        } else {
            arrayList.add(com_fossil_ekc.aCM());
            com_fossil_ecu.aE(arrayList);
        }
        return com_fossil_ecu;
    }
}
