package com.fossil;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;

public final class brp implements ServiceConnection, awo, awp {
    final /* synthetic */ brc bCU;
    private volatile boolean bDb;
    private volatile bok bDc;

    protected brp(brc com_fossil_brc) {
        this.bCU = com_fossil_brc;
    }

    public final void Sb() {
        this.bCU.OP();
        Context context = this.bCU.getContext();
        synchronized (this) {
            if (this.bDb) {
                this.bCU.Pf().Ri().log("Connection attempt already in progress");
            } else if (this.bDc != null) {
                this.bCU.Pf().Ri().log("Already awaiting connection attempt");
            } else {
                this.bDc = new bok(context, Looper.getMainLooper(), this, this);
                this.bCU.Pf().Ri().log("Connecting to remote service");
                this.bDb = true;
                this.bDc.Li();
            }
        }
    }

    public final void mo1194a(atn com_fossil_atn) {
        awa.dg("MeasurementServiceConnection.onConnectionFailed");
        bol RC = this.bCU.zzboe.RC();
        if (RC != null) {
            RC.Re().m5439d("Service connection failed", com_fossil_atn);
        }
        synchronized (this) {
            this.bDb = false;
            this.bDc = null;
        }
        this.bCU.Pe().m5469h(new bru(this));
    }

    public final void hr(int i) {
        awa.dg("MeasurementServiceConnection.onConnectionSuspended");
        this.bCU.Pf().Rh().log("Service connection suspended");
        this.bCU.Pe().m5469h(new brt(this));
    }

    public final void m5569i(Intent intent) {
        this.bCU.OP();
        Context context = this.bCU.getContext();
        axh LD = axh.LD();
        synchronized (this) {
            if (this.bDb) {
                this.bCU.Pf().Ri().log("Connection attempt already in progress");
                return;
            }
            this.bDb = true;
            LD.m4677a(context, intent, this.bCU.bCN, 129);
        }
    }

    public final void mo1193l(Bundle bundle) {
        awa.dg("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                bod com_fossil_bod = (bod) this.bDc.Lm();
                this.bDc = null;
                this.bCU.Pe().m5469h(new brs(this, com_fossil_bod));
            } catch (DeadObjectException e) {
                this.bDc = null;
                this.bDb = false;
            } catch (IllegalStateException e2) {
                this.bDc = null;
                this.bDb = false;
            }
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        awa.dg("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.bDb = false;
                this.bCU.Pf().Rc().log("Service connected with null binder");
                return;
            }
            bod com_fossil_bod;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    if (iBinder == null) {
                        com_fossil_bod = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                        com_fossil_bod = queryLocalInterface instanceof bod ? (bod) queryLocalInterface : new bof(iBinder);
                    }
                    try {
                        this.bCU.Pf().Ri().log("Bound to IMeasurementService interface");
                    } catch (RemoteException e) {
                        this.bCU.Pf().Rc().log("Service connect failed to get IMeasurementService");
                        if (com_fossil_bod != null) {
                            this.bDb = false;
                            try {
                                axh.LD();
                                this.bCU.getContext().unbindService(this.bCU.bCN);
                            } catch (IllegalArgumentException e2) {
                            }
                        } else {
                            this.bCU.Pe().m5469h(new brq(this, com_fossil_bod));
                        }
                    }
                    if (com_fossil_bod != null) {
                        this.bDb = false;
                        axh.LD();
                        this.bCU.getContext().unbindService(this.bCU.bCN);
                    } else {
                        this.bCU.Pe().m5469h(new brq(this, com_fossil_bod));
                    }
                }
                this.bCU.Pf().Rc().m5439d("Got binder with a wrong descriptor", interfaceDescriptor);
                com_fossil_bod = null;
                if (com_fossil_bod != null) {
                    this.bCU.Pe().m5469h(new brq(this, com_fossil_bod));
                } else {
                    this.bDb = false;
                    axh.LD();
                    this.bCU.getContext().unbindService(this.bCU.bCN);
                }
            } catch (RemoteException e3) {
                com_fossil_bod = null;
                this.bCU.Pf().Rc().log("Service connect failed to get IMeasurementService");
                if (com_fossil_bod != null) {
                    this.bCU.Pe().m5469h(new brq(this, com_fossil_bod));
                } else {
                    this.bDb = false;
                    axh.LD();
                    this.bCU.getContext().unbindService(this.bCU.bCN);
                }
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        awa.dg("MeasurementServiceConnection.onServiceDisconnected");
        this.bCU.Pf().Rh().log("Service disconnected");
        this.bCU.Pe().m5469h(new brr(this, componentName));
    }
}
