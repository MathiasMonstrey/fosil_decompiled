package com.fossil;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;
import java.util.Map;

public final class bmj {
    private final bmu<bmh> bwg;
    private ContentProviderClient bwl = null;
    private boolean bwm = false;
    private final Map<bgn<bus>, bmn> bwn = new HashMap();
    private final Map<bgn<bur>, bmk> bwo = new HashMap();
    private final Context mContext;

    public bmj(Context context, bmu<bmh> com_fossil_bmu_com_fossil_bmh) {
        this.mContext = context;
        this.bwg = com_fossil_bmu_com_fossil_bmh;
    }

    private final bmn m5293a(bgl<bus> com_fossil_bgl_com_fossil_bus) {
        bmn com_fossil_bmn;
        synchronized (this.bwn) {
            com_fossil_bmn = (bmn) this.bwn.get(com_fossil_bgl_com_fossil_bus.On());
            if (com_fossil_bmn == null) {
                com_fossil_bmn = new bmn(com_fossil_bgl_com_fossil_bus);
            }
            this.bwn.put(com_fossil_bgl_com_fossil_bus.On(), com_fossil_bmn);
        }
        return com_fossil_bmn;
    }

    public final Location OI() {
        this.bwg.Ll();
        try {
            return ((bmh) this.bwg.Lm()).dO(this.mContext.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final void OJ() {
        if (this.bwm) {
            try {
                bc(false);
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public final void m5294a(bgn<bus> com_fossil_bgn_com_fossil_bus, bme com_fossil_bme) throws RemoteException {
        this.bwg.Ll();
        awa.m4640p(com_fossil_bgn_com_fossil_bus, "Invalid null listener key");
        synchronized (this.bwn) {
            bxa com_fossil_bxa = (bmn) this.bwn.remove(com_fossil_bgn_com_fossil_bus);
            if (com_fossil_bxa != null) {
                com_fossil_bxa.release();
                ((bmh) this.bwg.Lm()).mo1395a(bms.m5306a(com_fossil_bxa, com_fossil_bme));
            }
        }
    }

    public final void m5295a(LocationRequest locationRequest, bgl<bus> com_fossil_bgl_com_fossil_bus, bme com_fossil_bme) throws RemoteException {
        this.bwg.Ll();
        ((bmh) this.bwg.Lm()).mo1395a(new bms(1, bmq.m5304a(locationRequest), m5293a(com_fossil_bgl_com_fossil_bus).asBinder(), null, null, com_fossil_bme != null ? com_fossil_bme.asBinder() : null));
    }

    public final void bc(boolean z) throws RemoteException {
        this.bwg.Ll();
        ((bmh) this.bwg.Lm()).bc(z);
        this.bwm = z;
    }

    public final void removeAllListeners() {
        try {
            synchronized (this.bwn) {
                for (bxa com_fossil_bxa : this.bwn.values()) {
                    if (com_fossil_bxa != null) {
                        ((bmh) this.bwg.Lm()).mo1395a(bms.m5306a(com_fossil_bxa, null));
                    }
                }
                this.bwn.clear();
            }
            synchronized (this.bwo) {
                for (bwx com_fossil_bwx : this.bwo.values()) {
                    if (com_fossil_bwx != null) {
                        ((bmh) this.bwg.Lm()).mo1395a(bms.m5305a(com_fossil_bwx, null));
                    }
                }
                this.bwo.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
