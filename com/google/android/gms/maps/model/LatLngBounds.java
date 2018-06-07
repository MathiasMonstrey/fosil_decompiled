package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.fossil.arv.d;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.avx;
import com.fossil.awa;
import com.fossil.bzc;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;

public final class LatLngBounds extends auq implements ReflectedParcelable {
    public static final Creator<LatLngBounds> CREATOR = new bzc();
    public final LatLng bJo;
    public final LatLng bJp;

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        awa.p(latLng, "null southwest");
        awa.p(latLng2, "null northeast");
        awa.b(latLng2.latitude >= latLng.latitude, "southern latitude exceeds northern latitude (%s > %s)", new Object[]{Double.valueOf(latLng.latitude), Double.valueOf(latLng2.latitude)});
        this.bJo = latLng;
        this.bJp = latLng2;
    }

    public static LatLngBounds m14277g(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, d.MapAttrs);
        Float valueOf = obtainAttributes.hasValue(d.MapAttrs_latLngBoundsSouthWestLatitude) ? Float.valueOf(obtainAttributes.getFloat(d.MapAttrs_latLngBoundsSouthWestLatitude, 0.0f)) : null;
        Float valueOf2 = obtainAttributes.hasValue(d.MapAttrs_latLngBoundsSouthWestLongitude) ? Float.valueOf(obtainAttributes.getFloat(d.MapAttrs_latLngBoundsSouthWestLongitude, 0.0f)) : null;
        Float valueOf3 = obtainAttributes.hasValue(d.MapAttrs_latLngBoundsNorthEastLatitude) ? Float.valueOf(obtainAttributes.getFloat(d.MapAttrs_latLngBoundsNorthEastLatitude, 0.0f)) : null;
        Float valueOf4 = obtainAttributes.hasValue(d.MapAttrs_latLngBoundsNorthEastLongitude) ? Float.valueOf(obtainAttributes.getFloat(d.MapAttrs_latLngBoundsNorthEastLongitude, 0.0f)) : null;
        return (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null) ? null : new LatLngBounds(new LatLng((double) valueOf.floatValue(), (double) valueOf2.floatValue()), new LatLng((double) valueOf3.floatValue(), (double) valueOf4.floatValue()));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.bJo.equals(latLngBounds.bJo) && this.bJp.equals(latLngBounds.bJp);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.bJo, this.bJp});
    }

    public final String toString() {
        return avx.bN(this).b("southwest", this.bJo).b("northeast", this.bJp).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.a(parcel, 2, this.bJo, i, false);
        aus.a(parcel, 3, this.bJp, i, false);
        aus.G(parcel, A);
    }
}
