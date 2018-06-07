package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.avx;
import com.fossil.awa;
import com.fossil.byu;
import com.fossil.byu.a;
import com.fossil.bzf;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;

public class StreetViewPanoramaCamera extends auq implements ReflectedParcelable {
    public static final Creator<StreetViewPanoramaCamera> CREATOR = new bzf();
    private byu bJC;
    public final float bJh;
    public final float bJi;
    public final float bJj;

    public StreetViewPanoramaCamera(float f, float f2, float f3) {
        boolean z = -90.0f <= f2 && f2 <= 90.0f;
        awa.b(z, "Tilt needs to be between -90 and 90 inclusive: " + f2);
        if (((double) f) <= 0.0d) {
            f = 0.0f;
        }
        this.bJh = f;
        this.bJi = f2 + 0.0f;
        this.bJj = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
        this.bJC = new a().af(f2).ag(f3).TE();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.bJh) == Float.floatToIntBits(streetViewPanoramaCamera.bJh) && Float.floatToIntBits(this.bJi) == Float.floatToIntBits(streetViewPanoramaCamera.bJi) && Float.floatToIntBits(this.bJj) == Float.floatToIntBits(streetViewPanoramaCamera.bJj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.bJh), Float.valueOf(this.bJi), Float.valueOf(this.bJj)});
    }

    public String toString() {
        return avx.bN(this).b("zoom", Float.valueOf(this.bJh)).b("tilt", Float.valueOf(this.bJi)).b("bearing", Float.valueOf(this.bJj)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.a(parcel, 2, this.bJh);
        aus.a(parcel, 3, this.bJi);
        aus.a(parcel, 4, this.bJj);
        aus.G(parcel, A);
    }
}
