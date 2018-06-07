package com.misfit.frameworks.buttonservice.model.microapp.mapping.customization;

import android.os.Parcel;
import com.misfit.ble.setting.uapp.files.customization.UAppCustomizationFrame;

public class BLENonCustomization extends BLECustomization {
    public BLENonCustomization() {
        super(0);
    }

    protected BLENonCustomization(Parcel parcel) {
        super(parcel);
    }

    public UAppCustomizationFrame getCustomizationFrame() {
        return null;
    }

    public String getHash() {
        return this.mType + ":non";
    }
}
