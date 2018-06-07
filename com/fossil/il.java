package com.fossil;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.fossil.im.C3728a;
import java.util.ArrayList;
import java.util.List;

public class il {

    public static final class C3723a implements Parcelable {
        public static final Creator<C3723a> CREATOR = new C37221();
        private final ia Nv;
        private final long OW;
        private Object OX;

        static class C37221 implements Creator<C3723a> {
            C37221() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m11822n(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return aY(i);
            }

            public C3723a m11822n(Parcel parcel) {
                return new C3723a(parcel);
            }

            public C3723a[] aY(int i) {
                return new C3723a[i];
            }
        }

        private C3723a(Object obj, ia iaVar, long j) {
            if (iaVar == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            } else {
                this.Nv = iaVar;
                this.OW = j;
                this.OX = obj;
            }
        }

        C3723a(Parcel parcel) {
            this.Nv = (ia) ia.CREATOR.createFromParcel(parcel);
            this.OW = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.Nv.writeToParcel(parcel, i);
            parcel.writeLong(this.OW);
        }

        public int describeContents() {
            return 0;
        }

        public static C3723a m11823H(Object obj) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            return new C3723a(obj, ia.m11723r(C3728a.m11829K(obj)), C3728a.m11830L(obj));
        }

        public static List<C3723a> m11824p(List<?> list) {
            if (list == null || VERSION.SDK_INT < 21) {
                return null;
            }
            List<C3723a> arrayList = new ArrayList();
            for (Object H : list) {
                arrayList.add(C3723a.m11823H(H));
            }
            return arrayList;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.Nv + ", Id=" + this.OW + " }";
        }
    }

    static final class C3725b implements Parcelable {
        public static final Creator<C3725b> CREATOR = new C37241();
        private ResultReceiver OY;

        static class C37241 implements Creator<C3725b> {
            C37241() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m11825o(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return aZ(i);
            }

            public C3725b m11825o(Parcel parcel) {
                return new C3725b(parcel);
            }

            public C3725b[] aZ(int i) {
                return new C3725b[i];
            }
        }

        C3725b(Parcel parcel) {
            this.OY = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.OY.writeToParcel(parcel, i);
        }
    }

    public static final class C3727c implements Parcelable {
        public static final Creator<C3727c> CREATOR = new C37261();
        private final ih OB;
        private final Object OZ;

        static class C37261 implements Creator<C3727c> {
            C37261() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m11826p(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return ba(i);
            }

            public C3727c m11826p(Parcel parcel) {
                Object readParcelable;
                if (VERSION.SDK_INT >= 21) {
                    readParcelable = parcel.readParcelable(null);
                } else {
                    readParcelable = parcel.readStrongBinder();
                }
                return new C3727c(readParcelable);
            }

            public C3727c[] ba(int i) {
                return new C3727c[i];
            }
        }

        C3727c(Object obj) {
            this(obj, null);
        }

        C3727c(Object obj, ih ihVar) {
            this.OZ = obj;
            this.OB = ihVar;
        }

        public static C3727c m11827I(Object obj) {
            return C3727c.m11828a(obj, null);
        }

        public static C3727c m11828a(Object obj, ih ihVar) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            return new C3727c(im.m11831J(obj), ihVar);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.OZ, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.OZ);
            }
        }

        public int hashCode() {
            if (this.OZ == null) {
                return 0;
            }
            return this.OZ.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C3727c)) {
                return false;
            }
            C3727c c3727c = (C3727c) obj;
            if (this.OZ == null) {
                if (c3727c.OZ != null) {
                    return false;
                }
                return true;
            } else if (c3727c.OZ == null) {
                return false;
            } else {
                return this.OZ.equals(c3727c.OZ);
            }
        }

        public Object jg() {
            return this.OZ;
        }

        public ih jh() {
            return this.OB;
        }
    }
}
