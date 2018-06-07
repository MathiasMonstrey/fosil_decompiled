package com.fossil.wearables.fsl.shared;

import com.j256.ormlite.field.DatabaseField;

public abstract class BaseFeatureModel extends BaseModel {
    public static final String COLUMN_COLOR = "color";
    public static final String COLUMN_ENABLED = "enabled";
    public static final String COLUMN_HAPTIC = "haptic";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    @DatabaseField
    private String color;
    @DatabaseField
    private boolean enabled = true;
    @DatabaseField
    private String haptic;
    @DatabaseField
    private int hour;
    @DatabaseField
    private boolean isVibrationOnly;
    @DatabaseField
    private String name;
    @DatabaseField
    private long timestamp;

    public String getColor() {
        return this.color;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public String getHaptic() {
        return this.haptic;
    }

    public void setHaptic(String str) {
        this.haptic = str;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int i) {
        this.hour = i;
    }

    public boolean isVibrationOnly() {
        return this.isVibrationOnly;
    }

    public void setVibrationOnly(boolean z) {
        this.isVibrationOnly = z;
    }
}
