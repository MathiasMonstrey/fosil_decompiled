package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.bbv;
import com.google.android.gms.gcm.Task.a;

public class OneoffTask extends Task {
    public static final Creator<OneoffTask> CREATOR = new bbv();
    private final long bpn;
    private final long bpo;

    @Deprecated
    private OneoffTask(Parcel parcel) {
        super(parcel);
        this.bpn = parcel.readLong();
        this.bpo = parcel.readLong();
    }

    private OneoffTask(a aVar) {
        super((a) aVar);
        this.bpn = a.a(aVar);
        this.bpo = a.b(aVar);
    }

    public long Mu() {
        return this.bpn;
    }

    public long Mv() {
        return this.bpo;
    }

    public void mo3497o(Bundle bundle) {
        super.mo3497o(bundle);
        bundle.putLong("window_start", this.bpn);
        bundle.putLong("window_end", this.bpo);
    }

    public String toString() {
        String valueOf = String.valueOf(super.toString());
        long Mu = Mu();
        return new StringBuilder(String.valueOf(valueOf).length() + 64).append(valueOf).append(" windowStart=").append(Mu).append(" windowEnd=").append(Mv()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.bpn);
        parcel.writeLong(this.bpo);
    }
}
