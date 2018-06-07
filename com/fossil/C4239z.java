package com.fossil;

import android.app.Service;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.fossil.ad.a;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class C4239z extends Service {
    private final Map<IBinder, DeathRecipient> tr = new jl();
    private a ts = new C42381(this);

    class C42381 extends a {
        final /* synthetic */ C4239z tu;

        C42381(C4239z c4239z) {
            this.tu = c4239z;
        }

        public boolean m14132h(long j) {
            return this.tu.m14141h(j);
        }

        public boolean m14127a(ac acVar) {
            boolean z = false;
            final ab abVar = new ab(acVar);
            try {
                DeathRecipient c42371 = new DeathRecipient(this) {
                    final /* synthetic */ C42381 tw;

                    public void binderDied() {
                        this.tw.tu.m14135a(abVar);
                    }
                };
                synchronized (this.tu.tr) {
                    acVar.asBinder().linkToDeath(c42371, 0);
                    this.tu.tr.put(acVar.asBinder(), c42371);
                }
                z = this.tu.m14140b(abVar);
            } catch (RemoteException e) {
            }
            return z;
        }

        public boolean m14129a(ac acVar, Uri uri, Bundle bundle, List<Bundle> list) {
            return this.tu.m14137a(new ab(acVar), uri, bundle, list);
        }

        public Bundle m14131b(String str, Bundle bundle) {
            return this.tu.m14139b(str, bundle);
        }

        public boolean m14130a(ac acVar, Bundle bundle) {
            return this.tu.m14138a(new ab(acVar), bundle);
        }

        public boolean m14128a(ac acVar, Uri uri) {
            return this.tu.m14136a(new ab(acVar), uri);
        }

        public int m14126a(ac acVar, String str, Bundle bundle) {
            return this.tu.m14134a(new ab(acVar), str, bundle);
        }
    }

    protected abstract int m14134a(ab abVar, String str, Bundle bundle);

    protected abstract boolean m14136a(ab abVar, Uri uri);

    protected abstract boolean m14137a(ab abVar, Uri uri, Bundle bundle, List<Bundle> list);

    protected abstract boolean m14138a(ab abVar, Bundle bundle);

    protected abstract Bundle m14139b(String str, Bundle bundle);

    protected abstract boolean m14140b(ab abVar);

    protected abstract boolean m14141h(long j);

    protected boolean m14135a(ab abVar) {
        try {
            synchronized (this.tr) {
                IBinder eS = abVar.eS();
                eS.unlinkToDeath((DeathRecipient) this.tr.get(eS), 0);
                this.tr.remove(eS);
            }
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
