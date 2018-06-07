package com.fossil.wearables.fsl.appfilter;

import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.j256.ormlite.field.DatabaseField;

public class AppFilter extends BaseFeatureModel {
    public static final String COLUMN_DEVICE_FAMILY = "deviceFamily";
    public static final String COLUMN_HOUR = "hour";
    public static final String COLUMN_IS_VIBRATION_ONLY = "isVibrationOnly";
    public static final String COMLUMN_TYPE = "type";
    @DatabaseField
    private int deviceFamily;
    @DatabaseField
    private String type;

    public AppFilter(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public int getDeviceFamily() {
        return this.deviceFamily;
    }

    public void setDeviceFamily(int i) {
        this.deviceFamily = i;
    }
}
