package com.fossil;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

abstract class bdj extends bdi {
    protected final cah<Void> bre;

    public bdj(int i, cah<Void> com_fossil_cah_java_lang_Void) {
        super(i);
        this.bre = com_fossil_cah_java_lang_Void;
    }

    public void mo1269a(ben com_fossil_ben, boolean z) {
    }

    public final void mo1270a(bfu<?> com_fossil_bfu_) throws DeadObjectException {
        try {
            mo1272b(com_fossil_bfu_);
        } catch (RemoteException e) {
            mo1271h(bdi.m4884a(e));
            throw e;
        } catch (RemoteException e2) {
            mo1271h(bdi.m4884a(e2));
        }
    }

    protected abstract void mo1272b(bfu<?> com_fossil_bfu_) throws RemoteException;

    public void mo1271h(Status status) {
        this.bre.m5863i(new ApiException(status));
    }
}
