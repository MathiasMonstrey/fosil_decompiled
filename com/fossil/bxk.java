package com.fossil;

import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class bxk {
    private static bxr bIk;

    private static bxr Td() {
        return (bxr) awa.m4640p(bIk, "CameraUpdateFactory is not initialized");
    }

    public static bxj m5762Y(float f) {
        try {
            return new bxj(Td().ab(f));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static bxj m5763a(LatLng latLng, float f) {
        try {
            return new bxj(Td().mo1500b(latLng, f));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static void m5764a(bxr com_fossil_bxr) {
        bIk = (bxr) awa.bO(com_fossil_bxr);
    }
}
