package com.google.android.gms.location.places.internal;

import android.net.Uri;
import com.fossil.bvl;
import com.fossil.bvq;
import com.fossil.bvs;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;

public class PlaceEntity$a {
    private LatLng bGZ;
    private float bHa;
    private LatLngBounds bHb;
    private Uri bHd;
    private boolean bHe;
    private float bHf = -1.0f;
    private int bHg = -1;
    private String bHj;
    private String bHk;
    private List<String> bHm;
    private bvs bHn;
    private List<Integer> bHr;
    private bvl bHs;
    private String beB;
    private String mName;

    public final PlaceEntity$a m14250C(List<Integer> list) {
        this.bHr = list;
        return this;
    }

    public final PlaceEntity$a m14251D(List<String> list) {
        this.bHm = list;
        return this;
    }

    public final PlaceEntity SS() {
        String str = this.beB;
        List list = this.bHr;
        List emptyList = Collections.emptyList();
        return new PlaceEntity(str, list, emptyList, null, this.mName, this.bHj, this.bHk, null, this.bHm, this.bGZ, this.bHa, this.bHb, null, this.bHd, this.bHe, this.bHf, this.bHg, new bvq(this.mName, this.bHj, this.bHk, null, this.bHm), this.bHn, this.bHs);
    }

    public final PlaceEntity$a m14252W(float f) {
        this.bHa = f;
        return this;
    }

    public final PlaceEntity$a m14253X(float f) {
        this.bHf = f;
        return this;
    }

    public final PlaceEntity$a m14254a(bvl com_fossil_bvl) {
        this.bHs = com_fossil_bvl;
        return this;
    }

    public final PlaceEntity$a m14255a(bvs com_fossil_bvs) {
        this.bHn = com_fossil_bvs;
        return this;
    }

    public final PlaceEntity$a m14256a(LatLng latLng) {
        this.bGZ = latLng;
        return this;
    }

    public final PlaceEntity$a m14257a(LatLngBounds latLngBounds) {
        this.bHb = latLngBounds;
        return this;
    }

    public final PlaceEntity$a bk(boolean z) {
        this.bHe = z;
        return this;
    }

    public final PlaceEntity$a eP(String str) {
        this.beB = str;
        return this;
    }

    public final PlaceEntity$a eQ(String str) {
        this.mName = str;
        return this;
    }

    public final PlaceEntity$a eR(String str) {
        this.bHj = str;
        return this;
    }

    public final PlaceEntity$a eS(String str) {
        this.bHk = str;
        return this;
    }

    public final PlaceEntity$a ip(int i) {
        this.bHg = i;
        return this;
    }

    public final PlaceEntity$a m14258k(Uri uri) {
        this.bHd = uri;
        return this;
    }
}
