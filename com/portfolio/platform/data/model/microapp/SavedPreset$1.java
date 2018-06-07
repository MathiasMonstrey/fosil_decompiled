package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class SavedPreset$1 implements Creator<SavedPreset> {
    SavedPreset$1() {
    }

    public SavedPreset createFromParcel(Parcel parcel) {
        return new SavedPreset(parcel);
    }

    public SavedPreset[] newArray(int i) {
        return new SavedPreset[i];
    }
}
