package com.ua.sdk.net.json;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ua.sdk.UaException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Iso8601PeriodFormat implements Parcelable {
    public static Creator<Iso8601PeriodFormat> CREATOR = new C50731();
    final List<C5077b> dJk;

    static class C50731 implements Creator<Iso8601PeriodFormat> {
        C50731() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return aZ(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return ov(i);
        }

        public Iso8601PeriodFormat aZ(Parcel parcel) {
            return new Iso8601PeriodFormat(parcel);
        }

        public Iso8601PeriodFormat[] ov(int i) {
            return new Iso8601PeriodFormat[i];
        }
    }

    enum Interval {
        DAYS("D", 0),
        WEEKS("W", 1),
        MONTHS("M", 2),
        YEARS("Y", 3);
        
        String name;
        int weight;

        private Interval(String str, int i) {
            this.name = str;
            this.weight = i;
        }

        public static Interval parse(String str) throws UaException {
            for (Interval interval : values()) {
                if (interval.name.equalsIgnoreCase(str)) {
                    return interval;
                }
            }
            throw new UaException(str + " is currently not supported!");
        }

        public String toString() {
            return this.name;
        }
    }

    static class C5075a {
        final List<C5077b> dJk = new ArrayList();
        final Set<Interval> dJl = Collections.synchronizedSet(EnumSet.noneOf(Interval.class));

        class C50741 implements Comparator<C5077b> {
            final /* synthetic */ C5075a dJm;

            C50741(C5075a c5075a) {
                this.dJm = c5075a;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return m16217a((C5077b) obj, (C5077b) obj2);
            }

            public int m16217a(C5077b c5077b, C5077b c5077b2) {
                if (c5077b2.dJo.weight > c5077b.dJo.weight) {
                    return 1;
                }
                return c5077b2.dJo.weight == c5077b.dJo.weight ? 0 : -1;
            }
        }

        public C5075a m16218a(C5077b c5077b) {
            if (this.dJl.add(c5077b.dJo)) {
                this.dJk.add(c5077b);
            }
            return this;
        }

        public Iso8601PeriodFormat aDZ() {
            Collections.sort(this.dJk, new C50741(this));
            return new Iso8601PeriodFormat();
        }
    }

    static class C5077b implements Parcelable {
        public static Creator<C5077b> CREATOR = new C50761();
        final int dJn;
        final Interval dJo;

        static class C50761 implements Creator<C5077b> {
            C50761() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return ba(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return ow(i);
            }

            public C5077b ba(Parcel parcel) {
                return new C5077b(parcel);
            }

            public C5077b[] ow(int i) {
                return new C5077b[i];
            }
        }

        public C5077b(int i, Interval interval) {
            this.dJn = i;
            this.dJo = interval;
        }

        private C5077b(Parcel parcel) {
            this.dJn = parcel.readInt();
            this.dJo = (Interval) parcel.readValue(Interval.class.getClassLoader());
        }

        public String toString() {
            return this.dJn + this.dJo.toString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dJn);
            parcel.writeValue(this.dJo);
        }
    }

    private Iso8601PeriodFormat(C5075a c5075a) {
        this.dJk = new ArrayList();
        this.dJk.addAll(c5075a.dJk);
    }

    private Iso8601PeriodFormat(Parcel parcel) {
        this.dJk = new ArrayList();
        this.dJk.addAll(parcel.readArrayList(C5077b.class.getClassLoader()));
    }

    public static Iso8601PeriodFormat lL(String str) throws UaException {
        try {
            str = str.toUpperCase();
            String[] split = str.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            if (split.length == 0 || !split[0].equalsIgnoreCase("P") || split.length % 2 == 0) {
                throw new UaException("Unable to parse '" + str + "'");
            }
            C5075a c5075a = new C5075a();
            for (int i = 1; i < split.length; i += 2) {
                c5075a.m16218a(new C5077b(Integer.valueOf(split[i]).intValue(), Interval.parse(split[i + 1])));
            }
            return c5075a.aDZ();
        } catch (Throwable e) {
            throw new UaException("Unable to parse '" + str + "'", e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.dJk);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("P");
        for (C5077b c5077b : this.dJk) {
            stringBuilder.append(c5077b.toString());
        }
        return stringBuilder.toString().toUpperCase();
    }
}
