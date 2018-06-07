package com.fossil.wearables.fsl.dial;

public class ValueItem {
    public boolean disabled;
    public String displayName;
    public int displayNameResId;
    public int imageResId;
    public String value;

    public ValueItem(String str, int i) {
        this.displayName = str;
        this.imageResId = i;
        this.value = str;
    }

    public ValueItem(String str, String str2, int i) {
        this.displayName = str;
        this.imageResId = i;
        this.value = str2;
    }

    public ValueItem(int i, String str, int i2) {
        this.displayNameResId = i;
        this.imageResId = i2;
        this.value = str;
    }
}
