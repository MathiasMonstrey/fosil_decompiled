package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.fossil.auq;
import com.fossil.aus;
import com.fossil.avx;
import com.fossil.bwt;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.portfolio.platform.response.user.MFGetWechatUserInfoResponse;
import java.util.Arrays;
import java.util.List;

public class AutocompleteFilter extends auq implements ReflectedParcelable {
    public static final Creator<AutocompleteFilter> CREATOR = new bwt();
    private boolean bGG;
    private List<Integer> bGH;
    private String bGI;
    private int bGJ;
    private int ber;

    public static final class C4252a {
        private boolean bGG = false;
        private String bGI = "";
        private int bGJ = 0;

        public final AutocompleteFilter SK() {
            return new AutocompleteFilter(1, false, Arrays.asList(new Integer[]{Integer.valueOf(this.bGJ)}), this.bGI);
        }
    }

    public AutocompleteFilter(int i, boolean z, List<Integer> list, String str) {
        boolean z2 = false;
        this.ber = i;
        this.bGH = list;
        int intValue = (list == null || list.isEmpty()) ? 0 : ((Integer) list.iterator().next()).intValue();
        this.bGJ = intValue;
        this.bGI = str;
        if (this.ber <= 0) {
            if (!z) {
                z2 = true;
            }
            this.bGG = z2;
            return;
        }
        this.bGG = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompleteFilter)) {
            return false;
        }
        AutocompleteFilter autocompleteFilter = (AutocompleteFilter) obj;
        return this.bGJ == autocompleteFilter.bGJ && this.bGG == autocompleteFilter.bGG && this.bGI == autocompleteFilter.bGI;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.bGG), Integer.valueOf(this.bGJ), this.bGI});
    }

    public String toString() {
        return avx.bN(this).b("includeQueryPredictions", Boolean.valueOf(this.bGG)).b("typeFilter", Integer.valueOf(this.bGJ)).b(MFGetWechatUserInfoResponse.COUNTRY, this.bGI).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int A = aus.A(parcel);
        aus.a(parcel, 1, this.bGG);
        aus.a(parcel, 2, this.bGH, false);
        aus.a(parcel, 3, this.bGI, false);
        aus.c(parcel, 1000, this.ber);
        aus.G(parcel, A);
    }
}
