package com.fossil;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class bxm {
    private static boolean initialized = false;

    public static synchronized int aS(Context context) {
        int i = 0;
        synchronized (bxm.class) {
            awa.m4640p(context, "Context is null");
            if (!initialized) {
                try {
                    byl aT = byk.aT(context);
                    bxk.m5764a(aT.Tr());
                    byr.m5819a(aT.Ts());
                    initialized = true;
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                    i = e2.errorCode;
                }
            }
        }
        return i;
    }
}
