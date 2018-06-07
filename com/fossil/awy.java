package com.fossil;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class awy {
    private final Account beU;
    private final Set<Scope> bge;
    private final int bgg;
    private final View bgh;
    private final String bgi;
    private final String bgj;
    private final Set<Scope> biD;
    private final Map<ats<?>, awz> biE;
    private final btv biF;
    private Integer biG;

    public awy(Account account, Set<Scope> set, Map<ats<?>, awz> map, int i, View view, String str, String str2, btv com_fossil_btv) {
        Map map2;
        this.beU = account;
        this.bge = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.biE = map2;
        this.bgh = view;
        this.bgg = i;
        this.bgi = str;
        this.bgj = str2;
        this.biF = com_fossil_btv;
        Set hashSet = new HashSet(this.bge);
        for (awz com_fossil_awz : this.biE.values()) {
            hashSet.addAll(com_fossil_awz.bfc);
        }
        this.biD = Collections.unmodifiableSet(hashSet);
    }

    public final Account KQ() {
        return this.beU;
    }

    public final Integer LA() {
        return this.biG;
    }

    @Deprecated
    public final String Ls() {
        return this.beU != null ? this.beU.name : null;
    }

    public final Account Lt() {
        return this.beU != null ? this.beU : new Account("<<default account>>", "com.google");
    }

    public final Set<Scope> Lu() {
        return this.bge;
    }

    public final Set<Scope> Lv() {
        return this.biD;
    }

    public final Map<ats<?>, awz> Lw() {
        return this.biE;
    }

    public final String Lx() {
        return this.bgi;
    }

    public final String Ly() {
        return this.bgj;
    }

    public final btv Lz() {
        return this.biF;
    }

    public final void m4658b(Integer num) {
        this.biG = num;
    }

    public final Set<Scope> m4659d(ats<?> com_fossil_ats_) {
        awz com_fossil_awz = (awz) this.biE.get(com_fossil_ats_);
        if (com_fossil_awz == null || com_fossil_awz.bfc.isEmpty()) {
            return this.bge;
        }
        Set<Scope> hashSet = new HashSet(this.bge);
        hashSet.addAll(com_fossil_awz.bfc);
        return hashSet;
    }
}
