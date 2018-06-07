package com.ua.sdk.group.objective;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.ehu;
import com.fossil.ehw;

public class SortCriteriaItem implements ehu<String> {
    public static final Creator<SortCriteriaItem> CREATOR = new C50711();
    private String value;

    static class C50711 implements Creator<SortCriteriaItem> {
        C50711() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aN(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return of(i);
        }

        public SortCriteriaItem aN(Parcel parcel) {
            return new SortCriteriaItem(parcel);
        }

        public SortCriteriaItem[] of(int i) {
            return new SortCriteriaItem[i];
        }
    }

    public enum Value {
        ASC,
        DESC
    }

    private SortCriteriaItem(Parcel parcel) {
        this.value = parcel.readString();
    }

    public String getName() {
        return ehw.dHL;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        if (str != null) {
            for (Value value : Value.values()) {
                if (str.equalsIgnoreCase(value.toString())) {
                    m16194a(value);
                    return;
                }
            }
            throw new EnumConstantNotPresentException(Value.class, "Unable to set value: " + str);
        }
    }

    public void m16194a(Value value) {
        if (value != null) {
            this.value = value.toString().toLowerCase();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.value);
    }
}
