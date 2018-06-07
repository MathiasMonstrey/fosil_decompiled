package com.fossil;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

public final class bdl extends bdj {
    private bgn<?> brg;

    public bdl(bgn<?> com_fossil_bgn_, cah<Void> com_fossil_cah_java_lang_Void) {
        super(4, com_fossil_cah_java_lang_Void);
        this.brg = com_fossil_bgn_;
    }

    public final /* bridge */ /* synthetic */ void mo1269a(ben com_fossil_ben, boolean z) {
    }

    public final void mo1272b(bfu<?> com_fossil_bfu_) throws RemoteException {
        bgs com_fossil_bgs = (bgs) com_fossil_bfu_.NZ().remove(this.brg);
        if (com_fossil_bgs != null) {
            com_fossil_bgs.buI.m5177b(com_fossil_bfu_.Nq(), this.bre);
            com_fossil_bgs.buH.Op();
            return;
        }
        Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", new Exception());
        this.bre.m5863i(new ApiException(Status.bgy));
    }

    public final /* bridge */ /* synthetic */ void mo1271h(Status status) {
        super.mo1271h(status);
    }
}
