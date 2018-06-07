package com.fossil;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import java.util.Comparator;

public class bvc extends aug<bvb> implements atz {
    private static final Comparator<bvn> bGL = new bwu();
    private final String bGK;
    private final int bGM;
    private final Status mStatus;

    public bvc(DataHolder dataHolder, int i) {
        super(dataHolder);
        this.mStatus = bvf.io(dataHolder.getStatusCode());
        switch (i) {
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
                this.bGM = i;
                if (dataHolder == null || dataHolder.KN() == null) {
                    this.bGK = null;
                    return;
                } else {
                    this.bGK = dataHolder.KN().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
                    return;
                }
            default:
                throw new IllegalArgumentException("invalid source: " + i);
        }
    }

    public static int m5717A(Bundle bundle) {
        return bundle.getInt("com.google.android.gms.location.places.PlaceLikelihoodBuffer.SOURCE_EXTRA_KEY");
    }

    public Status Ka() {
        return this.mStatus;
    }

    public /* synthetic */ Object get(int i) {
        return in(i);
    }

    public bvb in(int i) {
        return new bvp(this.bgD, i);
    }

    public String toString() {
        return avx.bN(this).m4608b("status", Ka()).m4608b("attributions", this.bGK).toString();
    }
}
