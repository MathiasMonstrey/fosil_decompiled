package com.fossil;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

public final class hx {
    static final boolean DEBUG = Log.isLoggable("MediaBrowserCompat", 3);

    public static class C3658a implements Parcelable {
        public static final Creator<C3658a> CREATOR = new C36571();
        private final int JM;
        private final ia Nv;

        static class C36571 implements Creator<C3658a> {
            C36571() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m11668j(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return aS(i);
            }

            public C3658a m11668j(Parcel parcel) {
                return new C3658a(parcel);
            }

            public C3658a[] aS(int i) {
                return new C3658a[i];
            }
        }

        C3658a(Parcel parcel) {
            this.JM = parcel.readInt();
            this.Nv = (ia) ia.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.JM);
            this.Nv.writeToParcel(parcel, i);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaItem{");
            stringBuilder.append("mFlags=").append(this.JM);
            stringBuilder.append(", mDescription=").append(this.Nv);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
}
