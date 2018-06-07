package com.fossil;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.portfolio.platform.service.microapp.enums.ServiceStatus;

public abstract class csy extends Service {
    protected static cta cDT;
    protected int cDU;
    protected ServiceStatus cDV = ServiceStatus.NOT_START;

    public abstract void aft();

    public IBinder onBind(Intent intent) {
        return null;
    }

    protected void afr() {
        if (cDT != null && this.cDV != ServiceStatus.RUNNING) {
            this.cDV = ServiceStatus.RUNNING;
            cDT.mo1890a(this.cDU, ServiceStatus.RUNNING);
            cDT.mo1891a(this);
        }
    }

    public static void m7492a(cta com_fossil_cta) {
        cDT = com_fossil_cta;
    }

    public void finish() {
        if (cDT != null && this.cDV != ServiceStatus.FINISHED) {
            this.cDV = ServiceStatus.FINISHED;
            cDT.mo1890a(this.cDU, ServiceStatus.FINISHED);
            cDT.mo1892b(this);
        }
    }

    public int afs() {
        return this.cDU;
    }
}
