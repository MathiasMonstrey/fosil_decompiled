package com.fossil.wearables.fsl.keyvalue;

import com.fossil.wearables.fsl.shared.BaseModel;
import com.j256.ormlite.field.DatabaseField;

public class KeyValue extends BaseModel {
    @DatabaseField
    private String key;
    @DatabaseField
    private String value;

    public KeyValue(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }
}
