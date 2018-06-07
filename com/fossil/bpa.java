package com.fossil;

import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.misfit.frameworks.buttonservice.ButtonService;

public final class bpa {
    private /* synthetic */ bow bAt;
    private String bAw;
    private final String bAx;
    private final String bAy;
    private final long bAz;

    private bpa(bow com_fossil_bow, String str, long j) {
        this.bAt = com_fossil_bow;
        awa.df(str);
        awa.aY(j > 0);
        this.bAw = String.valueOf(str).concat(":start");
        this.bAx = String.valueOf(str).concat(":count");
        this.bAy = String.valueOf(str).concat(":value");
        this.bAz = j;
    }

    private final void Rs() {
        this.bAt.OP();
        long currentTimeMillis = this.bAt.OX().currentTimeMillis();
        Editor edit = this.bAt.bzV.edit();
        edit.remove(this.bAx);
        edit.remove(this.bAy);
        edit.putLong(this.bAw, currentTimeMillis);
        edit.apply();
    }

    private final long Ru() {
        return this.bAt.Rm().getLong(this.bAw, 0);
    }

    public final Pair<String, Long> Rt() {
        this.bAt.OP();
        this.bAt.OP();
        long Ru = Ru();
        if (Ru == 0) {
            Rs();
            Ru = 0;
        } else {
            Ru = Math.abs(Ru - this.bAt.OX().currentTimeMillis());
        }
        if (Ru < this.bAz) {
            return null;
        }
        if (Ru > (this.bAz << 1)) {
            Rs();
            return null;
        }
        String string = this.bAt.Rm().getString(this.bAy, null);
        long j = this.bAt.Rm().getLong(this.bAx, 0);
        Rs();
        return (string == null || j <= 0) ? bow.bzU : new Pair(string, Long.valueOf(j));
    }

    public final void m5451f(String str, long j) {
        this.bAt.OP();
        if (Ru() == 0) {
            Rs();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.bAt.bzV.getLong(this.bAx, 0);
        if (j2 <= 0) {
            Editor edit = this.bAt.bzV.edit();
            edit.putString(this.bAy, str);
            edit.putLong(this.bAx, 1);
            edit.apply();
            return;
        }
        Object obj = (this.bAt.Pb().Sj().nextLong() & ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD) < ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD / (j2 + 1) ? 1 : null;
        Editor edit2 = this.bAt.bzV.edit();
        if (obj != null) {
            edit2.putString(this.bAy, str);
        }
        edit2.putLong(this.bAx, j2 + 1);
        edit2.apply();
    }
}
