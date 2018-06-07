package com.ua.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fossil.cfn;
import com.fossil.cfo;
import com.fossil.cfp;
import com.fossil.cft;
import com.fossil.cfu;
import com.fossil.cfv;
import com.google.gson.JsonParseException;
import com.ua.sdk.UaException;
import com.ua.sdk.net.json.Iso8601PeriodFormat;
import java.lang.reflect.Type;

public class Period implements Parcelable {
    public static Creator<Period> CREATOR = new C50721();
    public static final Period dIE = new Period("P1D");
    public static final Period dIF = new Period("P1W");
    public static final Period dIG = new Period("P1M");
    public static final Period dIH = new Period("P1Y");
    final String dII;

    static class C50721 implements Creator<Period> {
        C50721() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aW(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return os(i);
        }

        public Period aW(Parcel parcel) {
            return new Period(parcel);
        }

        public Period[] os(int i) {
            return new Period[i];
        }
    }

    public static class PeriodAdapter implements cfo<Period>, cfv<Period> {
        public /* synthetic */ Object deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
            return m16204H(com_fossil_cfp, type, com_fossil_cfn);
        }

        public Period m16204H(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException {
            try {
                return new Period(Iso8601PeriodFormat.lL(com_fossil_cfp.getAsString()));
            } catch (UaException e) {
                return null;
            }
        }

        public cfp m16205a(Period period, Type type, cfu com_fossil_cfu) {
            return new cft(period.dII);
        }
    }

    private Period(String str) {
        this.dII = str;
    }

    private Period(Iso8601PeriodFormat iso8601PeriodFormat) {
        this(iso8601PeriodFormat.toString());
    }

    private Period(Parcel parcel) {
        this.dII = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dII);
    }

    public String toString() {
        return this.dII;
    }
}
