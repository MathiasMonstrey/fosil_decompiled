package com.fossil;

import com.google.android.gms.common.data.DataHolder;

public final class cbg extends aul implements cas {
    private final int bKV;

    public cbg(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.bKV = i2;
    }

    public final cau TT() {
        return new cbk(this.bgD, this.bgT, this.bKV);
    }

    public final /* synthetic */ Object freeze() {
        return new cbf(this);
    }

    public final int getType() {
        return getInteger("event_type");
    }

    public final String toString() {
        String str = getType() == 1 ? "changed" : getType() == 2 ? "deleted" : "unknown";
        String valueOf = String.valueOf(TT());
        return new StringBuilder((String.valueOf(str).length() + 32) + String.valueOf(valueOf).length()).append("DataEventRef{ type=").append(str).append(", dataitem=").append(valueOf).append(" }").toString();
    }
}
