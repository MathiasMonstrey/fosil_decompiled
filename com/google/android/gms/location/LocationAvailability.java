package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.bxd;
import com.fossil.bxh;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;

public final class LocationAvailability extends auq implements ReflectedParcelable {
    public static final Creator<LocationAvailability> CREATOR = new bxd();
    @Deprecated
    private int bGp;
    @Deprecated
    private int bGq;
    private long bGr;
    private int bGs;
    private bxh[] bGt;

    public LocationAvailability(int i, int i2, int i3, long j, bxh[] com_fossil_bxhArr) {
        this.bGs = i;
        this.bGp = i2;
        this.bGq = i3;
        this.bGr = j;
        this.bGt = com_fossil_bxhArr;
    }

    public final boolean SI() {
        return this.bGs < 1000;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability) obj;
        return this.bGp == locationAvailability.bGp && this.bGq == locationAvailability.bGq && this.bGr == locationAvailability.bGr && this.bGs == locationAvailability.bGs && Arrays.equals(this.bGt, locationAvailability.bGt);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.bGs), Integer.valueOf(this.bGp), Integer.valueOf(this.bGq), Long.valueOf(this.bGr), this.bGt});
    }

    public final String toString() {
        return "LocationAvailability[isLocationAvailable: " + SI() + "]";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4565c(parcel, 1, this.bGp);
        aus.m4565c(parcel, 2, this.bGq);
        aus.m4544a(parcel, 3, this.bGr);
        aus.m4565c(parcel, 4, this.bGs);
        aus.m4560a(parcel, 5, this.bGt, i, false);
        aus.m4540G(parcel, A);
    }
}
