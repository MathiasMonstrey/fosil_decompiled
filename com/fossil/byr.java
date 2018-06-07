package com.fossil;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class byr {
    private static byv bJf;

    private static byv Tt() {
        return (byv) awa.m4640p(bJf, "IBitmapDescriptorFactory is not initialized");
    }

    public static void m5819a(byv com_fossil_byv) {
        if (bJf == null) {
            bJf = (byv) awa.bO(com_fossil_byv);
        }
    }

    public static byq m5820q(Bitmap bitmap) {
        try {
            return new byq(Tt().mo1549r(bitmap));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
