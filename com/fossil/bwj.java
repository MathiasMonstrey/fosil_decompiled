package com.fossil;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompleteFilter.a;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Locale;

public final class bwj extends axg<bwo> {
    private final bvx bHB;

    private bwj(Context context, Looper looper, awy com_fossil_awy, C1898b c1898b, C1899c c1899c, String str, bve com_fossil_bve) {
        super(context, looper, 65, com_fossil_awy, c1898b, c1899c);
        this.bHB = new bvx(str, Locale.getDefault(), com_fossil_awy.KQ() != null ? com_fossil_awy.KQ().name : null, null, 0);
    }

    protected final String Kh() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    protected final String Ki() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }

    public final void m5737a(bwv com_fossil_bwv, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) throws RemoteException {
        awa.m4640p(com_fossil_bwv, "callback == null");
        ((bwo) Lm()).mo1493a(str == null ? "" : str, latLngBounds, autocompleteFilter == null ? new a().SK() : autocompleteFilter, this.bHB, com_fossil_bwv);
    }

    protected final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        return queryLocalInterface instanceof bwo ? (bwo) queryLocalInterface : new bwp(iBinder);
    }
}
