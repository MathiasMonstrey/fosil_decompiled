package com.fossil;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public class buz extends aug<buy> implements atz {
    private final String bGK;
    private final Status mStatus;

    public buz(DataHolder dataHolder) {
        super(dataHolder);
        this.mStatus = bvf.io(dataHolder.getStatusCode());
        if (dataHolder == null || dataHolder.KN() == null) {
            this.bGK = null;
        } else {
            this.bGK = dataHolder.KN().getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    public Status Ka() {
        return this.mStatus;
    }

    public /* synthetic */ Object get(int i) {
        return im(i);
    }

    public buy im(int i) {
        return new bvw(this.bgD, i);
    }
}
