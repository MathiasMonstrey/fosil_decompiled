package com.fossil;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

@Deprecated
public final class bmz extends aum<bmy> implements atz {
    private final Status mStatus;

    public bmz(DataHolder dataHolder) {
        this(dataHolder, bvf.io(dataHolder.getStatusCode()));
    }

    private bmz(DataHolder dataHolder, Status status) {
        super(dataHolder, bmy.CREATOR);
        boolean z = dataHolder == null || dataHolder.getStatusCode() == status.getStatusCode();
        awa.aY(z);
        this.mStatus = status;
    }

    public final Status Ka() {
        return this.mStatus;
    }
}
