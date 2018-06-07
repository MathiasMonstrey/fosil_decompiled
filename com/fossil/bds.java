package com.fossil;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.fossil.ats.C1887c;
import com.fossil.ats.C1892d;
import com.google.android.gms.common.api.Status;

public abstract class bds<R extends atz, A extends C1887c> extends bdy<R> implements bdt<R> {
    private final ats<?> bfV;
    private final C1892d<A> brv;

    protected bds(ats<?> com_fossil_ats_, atv com_fossil_atv) {
        super((atv) awa.m4640p(com_fossil_atv, "GoogleApiClient must not be null"));
        this.brv = com_fossil_ats_.Kx();
        this.bfV = com_fossil_ats_;
    }

    private final void m4408c(RemoteException remoteException) {
        m4411i(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    public final ats<?> KA() {
        return this.bfV;
    }

    public final C1892d<A> Kx() {
        return this.brv;
    }

    protected abstract void mo1171a(A a) throws RemoteException;

    public /* synthetic */ void aV(Object obj) {
        super.m4406d((atz) obj);
    }

    public final void m4410b(A a) throws DeadObjectException {
        try {
            mo1171a(a);
        } catch (RemoteException e) {
            m4408c(e);
            throw e;
        } catch (RemoteException e2) {
            m4408c(e2);
        }
    }

    public final void m4411i(Status status) {
        awa.m4637b(!status.Kb(), "Failed result must not be success");
        m4406d(mo1172c(status));
    }
}
