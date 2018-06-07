package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

public final class bzv extends axg<bzt> {
    private caa bKf;
    private final bzy bKg;

    public bzv(Context context, Looper looper, awy com_fossil_awy, bzy com_fossil_bzy, C1898b c1898b, C1899c c1899c) {
        super(context, looper, 2, com_fossil_awy, c1898b, c1899c);
        this.bKg = com_fossil_bzy;
    }

    protected final Bundle JJ() {
        Bundle TP = this.bKg.TP();
        TP.putStringArray("request_visible_actions", this.bKg.TN());
        TP.putString("auth_package", this.bKg.TO());
        return TP;
    }

    protected final String Kh() {
        return "com.google.android.gms.plus.service.START";
    }

    protected final String Ki() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public final boolean Ky() {
        Set d = LC().m4659d(bzp.bfF);
        return (d == null || d.isEmpty()) ? false : (d.size() == 1 && d.contains(new Scope("plus_one_placeholder_scope"))) ? false : true;
    }

    public final caa TM() {
        Ll();
        return this.bKf;
    }

    protected final void mo1585a(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.bKf = btf.al(bundle.getByteArray("loaded_person"));
        }
        super.mo1585a(i, iBinder, bundle, i2);
    }

    protected final /* synthetic */ IInterface mo1165f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
        return queryLocalInterface instanceof bzt ? (bzt) queryLocalInterface : new bzu(iBinder);
    }
}
