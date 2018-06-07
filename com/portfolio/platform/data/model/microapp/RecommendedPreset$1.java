package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class RecommendedPreset$1 implements Creator<RecommendedPreset> {
    RecommendedPreset$1() {
    }

    public RecommendedPreset createFromParcel(Parcel parcel) {
        return new RecommendedPreset(parcel, null);
    }

    public RecommendedPreset[] newArray(int i) {
        return new RecommendedPreset[i];
    }
}
