package com.fossil;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.fossil.arw.C1877a;
import java.math.BigInteger;
import java.util.Locale;

final class bow extends bqi {
    static final Pair<String, Long> bzU = new Pair("", Long.valueOf(0));
    public final boz bAa = new boz(this, "last_delete_stale", 0);
    public final boz bAb = new boz(this, "midnight_offset", 0);
    public final boz bAc = new boz(this, "first_open_time", 0);
    public final bpb bAd = new bpb(this, "app_instance_id", null);
    private String bAe;
    private boolean bAf;
    private long bAg;
    private String bAh;
    private long bAi;
    private final Object bAj = new Object();
    public final boz bAk = new boz(this, "time_before_start", 10000);
    public final boz bAl = new boz(this, "session_timeout", 1800000);
    public final boy bAm = new boy(this, "start_new_session", true);
    public final boz bAn = new boz(this, "last_pause_time", 0);
    public final boz bAo = new boz(this, "time_active", 0);
    public boolean bAp;
    private SharedPreferences bzV;
    public final bpa bzW = new bpa(this, "health_monitor", bnm.Qo());
    public final boz bzX = new boz(this, "last_upload", 0);
    public final boz bzY = new boz(this, "last_upload_attempt", 0);
    public final boz bzZ = new boz(this, "backoff", 0);

    bow(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
    }

    private final SharedPreferences Rm() {
        OP();
        RA();
        return this.bzV;
    }

    protected final void PH() {
        this.bzV = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.bAp = this.bzV.getBoolean("has_been_opened", false);
        if (!this.bAp) {
            Editor edit = this.bzV.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }

    final String Rn() {
        OP();
        return Rm().getString("gmp_app_id", null);
    }

    final String Ro() {
        String str;
        synchronized (this.bAj) {
            if (Math.abs(OX().elapsedRealtime() - this.bAi) < 1000) {
                str = this.bAh;
            } else {
                str = null;
            }
        }
        return str;
    }

    final Boolean Rp() {
        OP();
        return !Rm().contains("use_service") ? null : Boolean.valueOf(Rm().getBoolean("use_service", false));
    }

    final void Rq() {
        boolean z = true;
        OP();
        Pf().Ri().log("Clearing collection preferences.");
        boolean contains = Rm().contains("measurement_enabled");
        if (contains) {
            z = be(true);
        }
        Editor edit = Rm().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            setMeasurementEnabled(z);
        }
    }

    protected final String Rr() {
        OP();
        String string = Rm().getString("previous_os_version", null);
        OU().RA();
        String str = VERSION.RELEASE;
        if (!(TextUtils.isEmpty(str) || str.equals(string))) {
            Editor edit = Rm().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    final void bd(boolean z) {
        OP();
        Pf().Ri().m5439d("Setting useService", Boolean.valueOf(z));
        Editor edit = Rm().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    final boolean be(boolean z) {
        OP();
        return Rm().getBoolean("measurement_enabled", z);
    }

    final Pair<String, Boolean> ek(String str) {
        OP();
        long elapsedRealtime = OX().elapsedRealtime();
        if (this.bAe != null && elapsedRealtime < this.bAg) {
            return new Pair(this.bAe, Boolean.valueOf(this.bAf));
        }
        this.bAg = elapsedRealtime + Ph().m5333a(str, bob.byA);
        arw.aV(true);
        try {
            C1877a ag = arw.ag(getContext());
            if (ag != null) {
                this.bAe = ag.getId();
                this.bAf = ag.JI();
            }
            if (this.bAe == null) {
                this.bAe = "";
            }
        } catch (Throwable th) {
            Pf().Rh().m5439d("Unable to get advertising id", th);
            this.bAe = "";
        }
        arw.aV(false);
        return new Pair(this.bAe, Boolean.valueOf(this.bAf));
    }

    final String el(String str) {
        OP();
        String str2 = (String) ek(str).first;
        if (bsk.eG("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, bsk.eG("MD5").digest(str2.getBytes()))});
    }

    final void em(String str) {
        OP();
        Editor edit = Rm().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    final void en(String str) {
        synchronized (this.bAj) {
            this.bAh = str;
            this.bAi = OX().elapsedRealtime();
        }
    }

    final void setMeasurementEnabled(boolean z) {
        OP();
        Pf().Ri().m5439d("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = Rm().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }
}
