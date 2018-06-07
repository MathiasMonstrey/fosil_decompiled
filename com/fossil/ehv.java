package com.fossil;

import android.os.Parcel;

public class ehv implements ehu<Object> {
    public String name;
    private Object value;

    public String getName() {
        return this.name;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.value);
    }
}
