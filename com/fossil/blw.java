package com.fossil;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;

public final class blw implements bup {
    public final atw<Status> mo1390a(atv com_fossil_atv, bus com_fossil_bus) {
        return com_fossil_atv.mo1335d(new bly(this, com_fossil_atv, com_fossil_bus));
    }

    public final atw<Status> mo1391a(atv com_fossil_atv, LocationRequest locationRequest, bus com_fossil_bus) {
        awa.m4640p(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
        return com_fossil_atv.mo1335d(new blx(this, com_fossil_atv, locationRequest, com_fossil_bus));
    }

    public final Location mo1392g(atv com_fossil_atv) {
        try {
            return but.m5695i(com_fossil_atv).OI();
        } catch (Exception e) {
            return null;
        }
    }
}
