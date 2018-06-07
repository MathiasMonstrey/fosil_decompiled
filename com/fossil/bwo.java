package com.fossil;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;

public interface bwo extends IInterface {
    void mo1493a(String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter, bvx com_fossil_bvx, bwq com_fossil_bwq) throws RemoteException;
}
