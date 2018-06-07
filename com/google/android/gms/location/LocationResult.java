package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.bxf;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult extends auq implements ReflectedParcelable {
    public static final Creator<LocationResult> CREATOR = new bxf();
    public static final List<Location> bGB = Collections.emptyList();
    private final List<Location> bGC;

    public LocationResult(List<Location> list) {
        this.bGC = list;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.bGC.size() != this.bGC.size()) {
            return false;
        }
        Iterator it = this.bGC.iterator();
        for (Location time : locationResult.bGC) {
            if (((Location) it.next()).getTime() != time.getTime()) {
                return false;
            }
        }
        return true;
    }

    public final List<Location> getLocations() {
        return this.bGC;
    }

    public final int hashCode() {
        int i = 17;
        for (Location time : this.bGC) {
            long time2 = time.getTime();
            i = ((int) (time2 ^ (time2 >>> 32))) + (i * 31);
        }
        return i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.bGC);
        return new StringBuilder(String.valueOf(valueOf).length() + 27).append("LocationResult[locations: ").append(valueOf).append("]").toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.c(parcel, 1, getLocations(), false);
        aus.G(parcel, A);
    }
}
