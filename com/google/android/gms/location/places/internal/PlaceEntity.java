package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.avx;
import com.fossil.buy;
import com.fossil.bvk;
import com.fossil.bvl;
import com.fossil.bvq;
import com.fossil.bvs;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.portfolio.platform.model.PhoneFavoritesContact;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class PlaceEntity extends auq implements buy, ReflectedParcelable {
    public static final Creator<PlaceEntity> CREATOR = new bvk();
    private Locale bGW;
    private final Bundle bGX;
    @Deprecated
    private final bvq bGY;
    private final LatLng bGZ;
    private final float bHa;
    private final LatLngBounds bHb;
    private final String bHc;
    private final Uri bHd;
    private final boolean bHe;
    private final float bHf;
    private final int bHg;
    private final List<Integer> bHh;
    private final List<Integer> bHi;
    private final String bHj;
    private final String bHk;
    private final String bHl;
    private final List<String> bHm;
    private final bvs bHn;
    private final bvl bHo;
    private final Map<Integer, String> bHp;
    private final TimeZone bHq;
    private final String beB;
    private final String mName;

    public PlaceEntity(String str, List<Integer> list, List<Integer> list2, Bundle bundle, String str2, String str3, String str4, String str5, List<String> list3, LatLng latLng, float f, LatLngBounds latLngBounds, String str6, Uri uri, boolean z, float f2, int i, bvq com_fossil_bvq, bvs com_fossil_bvs, bvl com_fossil_bvl) {
        List emptyList;
        this.beB = str;
        this.bHi = Collections.unmodifiableList(list);
        this.bHh = list2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.bGX = bundle;
        this.mName = str2;
        this.bHj = str3;
        this.bHk = str4;
        this.bHl = str5;
        if (list3 == null) {
            emptyList = Collections.emptyList();
        }
        this.bHm = emptyList;
        this.bGZ = latLng;
        this.bHa = f;
        this.bHb = latLngBounds;
        if (str6 == null) {
            str6 = "UTC";
        }
        this.bHc = str6;
        this.bHd = uri;
        this.bHe = z;
        this.bHf = f2;
        this.bHg = i;
        this.bHp = Collections.unmodifiableMap(new HashMap());
        this.bHq = null;
        this.bGW = null;
        this.bGY = com_fossil_bvq;
        this.bHn = com_fossil_bvs;
        this.bHo = com_fossil_bvl;
    }

    public final List<Integer> SM() {
        return this.bHi;
    }

    public final LatLngBounds SN() {
        return this.bHb;
    }

    public final Uri SO() {
        return this.bHd;
    }

    public final int SP() {
        return this.bHg;
    }

    public final /* synthetic */ CharSequence SQ() {
        return this.bHk;
    }

    public final /* synthetic */ CharSequence SR() {
        return this.bHj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceEntity)) {
            return false;
        }
        PlaceEntity placeEntity = (PlaceEntity) obj;
        return this.beB.equals(placeEntity.beB) && avx.equal(this.bGW, placeEntity.bGW);
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final String getId() {
        return this.beB;
    }

    public final LatLng getLatLng() {
        return this.bGZ;
    }

    public final /* synthetic */ CharSequence getName() {
        return this.mName;
    }

    public final float getRating() {
        return this.bHf;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.beB, this.bGW});
    }

    public final void setLocale(Locale locale) {
        this.bGW = locale;
    }

    @SuppressLint({"DefaultLocale"})
    public final String toString() {
        return avx.bN(this).m4608b("id", this.beB).m4608b("placeTypes", this.bHi).m4608b("locale", this.bGW).m4608b("name", this.mName).m4608b("address", this.bHj).m4608b(PhoneFavoritesContact.COLUMN_PHONE_NUMBER, this.bHk).m4608b("latlng", this.bGZ).m4608b("viewport", this.bHb).m4608b("websiteUri", this.bHd).m4608b("isPermanentlyClosed", Boolean.valueOf(this.bHe)).m4608b("priceLevel", Integer.valueOf(this.bHg)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 1, getId(), false);
        aus.m4545a(parcel, 2, this.bGX, false);
        aus.m4548a(parcel, 3, this.bGY, i, false);
        aus.m4548a(parcel, 4, getLatLng(), i, false);
        aus.m4543a(parcel, 5, this.bHa);
        aus.m4548a(parcel, 6, SN(), i, false);
        aus.m4554a(parcel, 7, this.bHc, false);
        aus.m4548a(parcel, 8, SO(), i, false);
        aus.m4556a(parcel, 9, this.bHe);
        aus.m4543a(parcel, 10, getRating());
        aus.m4565c(parcel, 11, SP());
        aus.m4555a(parcel, 13, this.bHh, false);
        aus.m4554a(parcel, 14, (String) SR(), false);
        aus.m4554a(parcel, 15, (String) SQ(), false);
        aus.m4554a(parcel, 16, this.bHl, false);
        aus.m4564b(parcel, 17, this.bHm, false);
        aus.m4554a(parcel, 19, (String) getName(), false);
        aus.m4555a(parcel, 20, SM(), false);
        aus.m4548a(parcel, 21, this.bHn, i, false);
        aus.m4548a(parcel, 22, this.bHo, i, false);
        aus.m4540G(parcel, A);
    }
}
