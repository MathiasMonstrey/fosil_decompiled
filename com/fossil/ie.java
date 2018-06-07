package com.fossil;

import android.annotation.TargetApi;
import android.media.MediaMetadata;
import android.os.Parcel;

@TargetApi(21)
class ie {
    public static void m11744a(Object obj, Parcel parcel, int i) {
        ((MediaMetadata) obj).writeToParcel(parcel, i);
    }
}
