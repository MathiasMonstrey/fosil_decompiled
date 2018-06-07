package com.portfolio.platform.receiver;

import com.fossil.ckb.a;
import com.fossil.ckb.c;
import com.fossil.ckb.d;
import com.misfit.frameworks.common.log.MFLogger;

class NetworkChangedReceiver$1 implements d<c, a> {
    final /* synthetic */ NetworkChangedReceiver cBF;

    NetworkChangedReceiver$1(NetworkChangedReceiver networkChangedReceiver) {
        this.cBF = networkChangedReceiver;
    }

    public /* synthetic */ void onError(Object obj) {
        m15636a((a) obj);
    }

    public /* synthetic */ void onSuccess(Object obj) {
        m15637a((c) obj);
    }

    public void m15637a(c cVar) {
        MFLogger.d(NetworkChangedReceiver.access$000(), "pushPendingData - onSuccess");
        NetworkChangedReceiver.a(this.cBF, false);
    }

    public void m15636a(a aVar) {
        MFLogger.d(NetworkChangedReceiver.access$000(), "pushPendingData - onError");
        NetworkChangedReceiver.a(this.cBF, false);
    }
}
