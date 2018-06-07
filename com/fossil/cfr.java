package com.fossil;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map.Entry;
import java.util.Set;

public final class cfr extends cfp {
    private final LinkedTreeMap<String, cfp> bRk = new LinkedTreeMap();

    public void m6212a(String str, cfp com_fossil_cfp) {
        if (com_fossil_cfp == null) {
            com_fossil_cfp = cfq.bRj;
        }
        this.bRk.put(str, com_fossil_cfp);
    }

    public cfp fp(String str) {
        return (cfp) this.bRk.remove(str);
    }

    public void ak(String str, String str2) {
        m6212a(str, cG(str2));
    }

    private cfp cG(Object obj) {
        return obj == null ? cfq.bRj : new cft(obj);
    }

    public Set<Entry<String, cfp>> entrySet() {
        return this.bRk.entrySet();
    }

    public cfp fq(String str) {
        return (cfp) this.bRk.get(str);
    }

    public cfr fr(String str) {
        return (cfr) this.bRk.get(str);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof cfr) && ((cfr) obj).bRk.equals(this.bRk));
    }

    public int hashCode() {
        return this.bRk.hashCode();
    }
}
