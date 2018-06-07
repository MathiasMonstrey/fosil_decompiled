package com.fossil;

import android.os.RemoteException;
import com.fossil.ats.C1887c;
import com.fossil.bwv.C1965a;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;

final class bwi extends C1965a<bwj> {
    private /* synthetic */ String NY;
    private /* synthetic */ LatLngBounds bHY;
    private /* synthetic */ AutocompleteFilter bHZ;

    bwi(bwh com_fossil_bwh, ats com_fossil_ats, atv com_fossil_atv, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) {
        this.NY = str;
        this.bHY = latLngBounds;
        this.bHZ = autocompleteFilter;
        super(com_fossil_ats, com_fossil_atv);
    }

    protected final /* synthetic */ void mo1171a(C1887c c1887c) throws RemoteException {
        ((bwj) c1887c).m5737a(new bwv(this), this.NY, this.bHY, this.bHZ);
    }
}
