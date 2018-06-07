package com.portfolio.platform.data.model.microapp.goaltracking;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class GoalTrackingSettings$1 implements Creator<GoalTrackingSettings> {
    GoalTrackingSettings$1() {
    }

    public GoalTrackingSettings createFromParcel(Parcel parcel) {
        return new GoalTrackingSettings(parcel, null);
    }

    public GoalTrackingSettings[] newArray(int i) {
        return new GoalTrackingSettings[i];
    }
}
