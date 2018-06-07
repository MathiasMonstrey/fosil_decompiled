package com.fossil;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

final class bhx extends bhr {
    private final bdt<Status> bvl;

    public bhx(bdt<Status> com_fossil_bdt_com_google_android_gms_common_api_Status) {
        this.bvl = com_fossil_bdt_com_google_android_gms_common_api_Status;
    }

    public final void mo1350if(int i) throws RemoteException {
        this.bvl.aV(new Status(i));
    }
}
