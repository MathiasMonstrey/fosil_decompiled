package com.fossil;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public class cat extends aup<cas> implements atz {
    private final Status mStatus;

    public cat(DataHolder dataHolder) {
        super(dataHolder);
        this.mStatus = new Status(dataHolder.getStatusCode());
    }

    protected final String KO() {
        return "path";
    }

    public Status Ka() {
        return this.mStatus;
    }

    protected final /* synthetic */ Object bI(int i, int i2) {
        return new cbg(this.bgD, i, i2);
    }
}
