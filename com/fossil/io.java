package com.fossil;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.fossil.ip.C3733a;
import java.util.ArrayList;
import java.util.List;

public final class io implements Parcelable {
    public static final Creator<io> CREATOR = new C37301();
    final Bundle KV;
    final long Pf;
    final long Pg;
    final float Ph;
    final long Pi;
    final CharSequence Pj;
    final long Pk;
    List<C3732a> Pl;
    final long Pm;
    private Object Pn;
    final int mErrorCode;
    final int mState;

    static class C37301 implements Creator<io> {
        C37301() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m11833r(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return bc(i);
        }

        public io m11833r(Parcel parcel) {
            return new io(parcel);
        }

        public io[] bc(int i) {
            return new io[i];
        }
    }

    public static final class C3732a implements Parcelable {
        public static final Creator<C3732a> CREATOR = new C37311();
        private final Bundle KV;
        private final String Po;
        private final CharSequence Pp;
        private final int Pq;
        private Object Pr;

        static class C37311 implements Creator<C3732a> {
            C37311() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m11834s(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return bd(i);
            }

            public C3732a m11834s(Parcel parcel) {
                return new C3732a(parcel);
            }

            public C3732a[] bd(int i) {
                return new C3732a[i];
            }
        }

        C3732a(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.Po = str;
            this.Pp = charSequence;
            this.Pq = i;
            this.KV = bundle;
        }

        C3732a(Parcel parcel) {
            this.Po = parcel.readString();
            this.Pp = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.Pq = parcel.readInt();
            this.KV = parcel.readBundle();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.Po);
            TextUtils.writeToParcel(this.Pp, parcel, i);
            parcel.writeInt(this.Pq);
            parcel.writeBundle(this.KV);
        }

        public int describeContents() {
            return 0;
        }

        public static C3732a m11835N(Object obj) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            C3732a c3732a = new C3732a(C3733a.m11837X(obj), C3733a.m11838Y(obj), C3733a.m11839Z(obj), C3733a.m11840y(obj));
            c3732a.Pr = obj;
            return c3732a;
        }

        public String toString() {
            return "Action:mName='" + this.Pp + ", mIcon=" + this.Pq + ", mExtras=" + this.KV;
        }
    }

    io(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<C3732a> list, long j5, Bundle bundle) {
        this.mState = i;
        this.Pf = j;
        this.Pg = j2;
        this.Ph = f;
        this.Pi = j3;
        this.mErrorCode = i2;
        this.Pj = charSequence;
        this.Pk = j4;
        this.Pl = new ArrayList(list);
        this.Pm = j5;
        this.KV = bundle;
    }

    io(Parcel parcel) {
        this.mState = parcel.readInt();
        this.Pf = parcel.readLong();
        this.Ph = parcel.readFloat();
        this.Pk = parcel.readLong();
        this.Pg = parcel.readLong();
        this.Pi = parcel.readLong();
        this.Pj = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.Pl = parcel.createTypedArrayList(C3732a.CREATOR);
        this.Pm = parcel.readLong();
        this.KV = parcel.readBundle();
        this.mErrorCode = parcel.readInt();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.mState);
        stringBuilder.append(", position=").append(this.Pf);
        stringBuilder.append(", buffered position=").append(this.Pg);
        stringBuilder.append(", speed=").append(this.Ph);
        stringBuilder.append(", updated=").append(this.Pk);
        stringBuilder.append(", actions=").append(this.Pi);
        stringBuilder.append(", error code=").append(this.mErrorCode);
        stringBuilder.append(", error message=").append(this.Pj);
        stringBuilder.append(", custom actions=").append(this.Pl);
        stringBuilder.append(", active item id=").append(this.Pm);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mState);
        parcel.writeLong(this.Pf);
        parcel.writeFloat(this.Ph);
        parcel.writeLong(this.Pk);
        parcel.writeLong(this.Pg);
        parcel.writeLong(this.Pi);
        TextUtils.writeToParcel(this.Pj, parcel, i);
        parcel.writeTypedList(this.Pl);
        parcel.writeLong(this.Pm);
        parcel.writeBundle(this.KV);
        parcel.writeInt(this.mErrorCode);
    }

    public static io m11836M(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> V = ip.m11848V(obj);
        List list = null;
        if (V != null) {
            list = new ArrayList(V.size());
            for (Object N : V) {
                list.add(C3732a.m11835N(N));
            }
        }
        io ioVar = new io(ip.m11841O(obj), ip.m11842P(obj), ip.m11843Q(obj), ip.m11844R(obj), ip.m11845S(obj), 0, ip.m11846T(obj), ip.m11847U(obj), list, ip.m11849W(obj), VERSION.SDK_INT >= 22 ? iq.m11850y(obj) : null);
        ioVar.Pn = obj;
        return ioVar;
    }
}
