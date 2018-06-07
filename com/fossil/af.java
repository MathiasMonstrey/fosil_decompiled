package com.fossil;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.fossil.ae.C1616a;

public class af extends Service {
    private C1616a tD = new C16181(this);

    class C16181 extends C1616a {
        final /* synthetic */ af tE;

        C16181(af afVar) {
            this.tE = afVar;
        }

        public void mo845b(ac acVar, Bundle bundle) throws RemoteException {
            acVar.mo803a(bundle);
        }

        public void mo846b(ac acVar, String str, Bundle bundle) throws RemoteException {
            acVar.mo805d(str, bundle);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.tD;
    }
}
