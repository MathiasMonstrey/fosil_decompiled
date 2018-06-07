package com.fossil;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.fossil.ats.C1888f;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

public abstract class axg<T extends IInterface> extends awm<T> implements C1888f, auy {
    private final Account beU;
    private final Set<Scope> bfc;
    private final awy biS;

    protected axg(Context context, Looper looper, int i, awy com_fossil_awy, C1898b c1898b, C1899c c1899c) {
        this(context, looper, auz.an(context), atp.Ku(), i, com_fossil_awy, (C1898b) awa.bO(c1898b), (C1899c) awa.bO(c1899c));
    }

    private axg(Context context, Looper looper, auz com_fossil_auz, atp com_fossil_atp, int i, awy com_fossil_awy, C1898b c1898b, C1899c c1899c) {
        super(context, looper, com_fossil_auz, com_fossil_atp, i, c1898b == null ? null : new auv(c1898b), c1899c == null ? null : new auw(c1899c), com_fossil_awy.Ly());
        this.biS = com_fossil_awy;
        this.beU = com_fossil_awy.KQ();
        Set Lv = com_fossil_awy.Lv();
        Set<Scope> f = mo1363f(Lv);
        for (Scope contains : f) {
            if (!Lv.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.bfc = f;
    }

    public final Account KQ() {
        return this.beU;
    }

    protected final awy LC() {
        return this.biS;
    }

    public ayc[] Lk() {
        return new ayc[0];
    }

    protected final Set<Scope> Lo() {
        return this.bfc;
    }

    protected Set<Scope> mo1363f(Set<Scope> set) {
        return set;
    }
}
