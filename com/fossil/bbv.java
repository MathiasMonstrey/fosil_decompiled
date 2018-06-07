package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.gcm.OneoffTask;

public final class bbv implements Creator<OneoffTask> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new OneoffTask(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new OneoffTask[i];
    }
}
