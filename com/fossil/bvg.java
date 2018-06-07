package com.fossil;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.style.CharacterStyle;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class bvg extends auq implements buv {
    public static final Creator<bvg> CREATOR = new bwc();
    private static final List<bwb> bHt = Collections.emptyList();
    private List<bwb> bHA;
    private List<Integer> bHi;
    private String bHu;
    private List<bwb> bHv;
    private int bHw;
    private String bHx;
    private List<bwb> bHy;
    private String bHz;
    private String bwK;

    bvg(String str, List<Integer> list, int i, String str2, List<bwb> list2, String str3, List<bwb> list3, String str4, List<bwb> list4) {
        this.bwK = str;
        this.bHi = list;
        this.bHw = i;
        this.bHu = str2;
        this.bHv = list2;
        this.bHx = str3;
        this.bHy = list3;
        this.bHz = str4;
        this.bHA = list4;
    }

    public final CharSequence mo1489a(CharacterStyle characterStyle) {
        return bwg.m5733a(this.bHu, this.bHv, characterStyle);
    }

    public final CharSequence mo1490b(CharacterStyle characterStyle) {
        return bwg.m5733a(this.bHx, this.bHy, characterStyle);
    }

    public final CharSequence mo1491c(CharacterStyle characterStyle) {
        return bwg.m5733a(this.bHz, this.bHA, characterStyle);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bvg)) {
            return false;
        }
        bvg com_fossil_bvg = (bvg) obj;
        return avx.equal(this.bwK, com_fossil_bvg.bwK) && avx.equal(this.bHi, com_fossil_bvg.bHi) && avx.equal(Integer.valueOf(this.bHw), Integer.valueOf(com_fossil_bvg.bHw)) && avx.equal(this.bHu, com_fossil_bvg.bHu) && avx.equal(this.bHv, com_fossil_bvg.bHv) && avx.equal(this.bHx, com_fossil_bvg.bHx) && avx.equal(this.bHy, com_fossil_bvg.bHy) && avx.equal(this.bHz, com_fossil_bvg.bHz) && avx.equal(this.bHA, com_fossil_bvg.bHA);
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.bwK, this.bHi, Integer.valueOf(this.bHw), this.bHu, this.bHv, this.bHx, this.bHy, this.bHz, this.bHA});
    }

    public final String toString() {
        return avx.bN(this).m4608b("placeId", this.bwK).m4608b("placeTypes", this.bHi).m4608b("fullText", this.bHu).m4608b("fullTextMatchedSubstrings", this.bHv).m4608b("primaryText", this.bHx).m4608b("primaryTextMatchedSubstrings", this.bHy).m4608b("secondaryText", this.bHz).m4608b("secondaryTextMatchedSubstrings", this.bHA).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int A = aus.m4537A(parcel);
        aus.m4554a(parcel, 1, this.bHu, false);
        aus.m4554a(parcel, 2, this.bwK, false);
        aus.m4555a(parcel, 3, this.bHi, false);
        aus.m4566c(parcel, 4, this.bHv, false);
        aus.m4565c(parcel, 5, this.bHw);
        aus.m4554a(parcel, 6, this.bHx, false);
        aus.m4566c(parcel, 7, this.bHy, false);
        aus.m4554a(parcel, 8, this.bHz, false);
        aus.m4566c(parcel, 9, this.bHA, false);
        aus.m4540G(parcel, A);
    }
}
