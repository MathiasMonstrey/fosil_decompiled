package com.misfit.frameworks.buttonservice.model.microapp.mapping.customization;

import android.os.Parcel;
import com.misfit.ble.setting.uapp.files.customization.UAppCustomizationFrame;
import com.misfit.ble.setting.uapp.files.customization.UAppCustomizationGoalTracking;

public class BLEGoalTrackingCustomization extends BLECustomization {
    private int goalId;

    public BLEGoalTrackingCustomization(int i) {
        super(1);
        this.goalId = i;
    }

    protected BLEGoalTrackingCustomization(Parcel parcel) {
        super(parcel);
        this.goalId = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.goalId);
    }

    public UAppCustomizationFrame getCustomizationFrame() {
        return new UAppCustomizationGoalTracking((byte) this.goalId);
    }

    public String getHash() {
        return this.mType + ":" + this.goalId;
    }

    public int getGoalId() {
        return this.goalId;
    }

    public void setGoalId(int i) {
        this.goalId = i;
    }
}
