package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ech implements Parcelable {
    public static Creator<ech> CREATOR = new C33132();
    private static final ThreadLocal<SimpleDateFormat> cxW = new C33121();
    private int dDs;
    private int month;
    private int year;

    static class C33121 extends ThreadLocal<SimpleDateFormat> {
        C33121() {
        }

        public /* synthetic */ Object get() {
            return aCx();
        }

        public SimpleDateFormat aCx() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    }

    static class C33132 implements Creator<ech> {
        C33132() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m10472G(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return mX(i);
        }

        public ech m10472G(Parcel parcel) {
            return new ech(parcel);
        }

        public ech[] mX(int i) {
            return new ech[i];
        }
    }

    public ech(int i, int i2, int i3) {
        if (i2 < 0 || i2 > 11) {
            throw new IllegalArgumentException("month must be a value 0 - 11");
        }
        this.year = i;
        this.month = i2;
        this.dDs = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
        parcel.writeInt(this.dDs);
    }

    private ech(Parcel parcel) {
        this.year = parcel.readInt();
        this.month = parcel.readInt();
        this.dDs = parcel.readInt();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(10);
        stringBuilder.append(this.year);
        stringBuilder.append('-');
        if (this.month < 9) {
            stringBuilder.append('0');
        }
        stringBuilder.append(this.month + 1);
        stringBuilder.append('-');
        if (this.dDs < 10) {
            stringBuilder.append('0');
        }
        stringBuilder.append(this.dDs);
        return stringBuilder.toString();
    }

    public static final ech lm(String str) {
        if (str == null) {
            return null;
        }
        try {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) cxW.get();
            simpleDateFormat.parse(str);
            return m10473k(simpleDateFormat.getCalendar());
        } catch (Throwable e) {
            ecq.m10490e("Error parsing LocalDate", e);
            return null;
        }
    }

    public static final ech m10473k(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        return new ech(calendar.get(1), calendar.get(2), calendar.get(5));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ech)) {
            return false;
        }
        ech com_fossil_ech = (ech) obj;
        if (this.dDs != com_fossil_ech.dDs) {
            return false;
        }
        if (this.month != com_fossil_ech.month) {
            return false;
        }
        if (this.year != com_fossil_ech.year) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.year * 31) + this.month) * 31) + this.dDs;
    }
}
