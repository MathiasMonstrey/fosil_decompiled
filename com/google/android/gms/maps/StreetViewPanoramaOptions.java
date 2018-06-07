package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.avx;
import com.fossil.bya;
import com.fossil.bzi;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions extends auq implements ReflectedParcelable {
    public static final Creator<StreetViewPanoramaOptions> CREATOR = new bzi();
    private StreetViewPanoramaCamera bIN;
    private String bIO;
    private LatLng bIP;
    private Integer bIQ;
    private Boolean bIR = Boolean.valueOf(true);
    private Boolean bIS = Boolean.valueOf(true);
    private Boolean bIT = Boolean.valueOf(true);
    private Boolean bIo;
    private Boolean bIu = Boolean.valueOf(true);

    public StreetViewPanoramaOptions(StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5) {
        this.bIN = streetViewPanoramaCamera;
        this.bIP = latLng;
        this.bIQ = num;
        this.bIO = str;
        this.bIR = bya.f(b);
        this.bIu = bya.f(b2);
        this.bIS = bya.f(b3);
        this.bIT = bya.f(b4);
        this.bIo = bya.f(b5);
    }

    public final StreetViewPanoramaCamera Tk() {
        return this.bIN;
    }

    public final LatLng Tl() {
        return this.bIP;
    }

    public final Integer Tm() {
        return this.bIQ;
    }

    public final String Tn() {
        return this.bIO;
    }

    public final String toString() {
        return avx.bN(this).b("PanoramaId", this.bIO).b("Position", this.bIP).b("Radius", this.bIQ).b("StreetViewPanoramaCamera", this.bIN).b("UserNavigationEnabled", this.bIR).b("ZoomGesturesEnabled", this.bIu).b("PanningGesturesEnabled", this.bIS).b("StreetNamesEnabled", this.bIT).b("UseViewLifecycleInFragment", this.bIo).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.a(parcel, 2, Tk(), i, false);
        aus.a(parcel, 3, Tn(), false);
        aus.a(parcel, 4, Tl(), i, false);
        aus.a(parcel, 5, Tm(), false);
        aus.a(parcel, 6, bya.b(this.bIR));
        aus.a(parcel, 7, bya.b(this.bIu));
        aus.a(parcel, 8, bya.b(this.bIS));
        aus.a(parcel, 9, bya.b(this.bIT));
        aus.a(parcel, 10, bya.b(this.bIo));
        aus.G(parcel, A);
    }
}
