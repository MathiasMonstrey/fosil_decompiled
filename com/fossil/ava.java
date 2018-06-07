package com.fossil;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;

public final class ava {
    private final String bhl;
    private final String bhm;
    private final ComponentName bhn = null;

    public ava(String str, String str2) {
        this.bhl = awa.df(str);
        this.bhm = awa.df(str2);
    }

    public final Intent KU() {
        return this.bhl != null ? new Intent(this.bhl).setPackage(this.bhm) : new Intent().setComponent(this.bhn);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ava)) {
            return false;
        }
        ava com_fossil_ava = (ava) obj;
        return avx.equal(this.bhl, com_fossil_ava.bhl) && avx.equal(this.bhm, com_fossil_ava.bhm) && avx.equal(this.bhn, com_fossil_ava.bhn);
    }

    public final ComponentName getComponentName() {
        return this.bhn;
    }

    public final String getPackage() {
        return this.bhm;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.bhl, this.bhm, this.bhn});
    }

    public final String toString() {
        return this.bhl == null ? this.bhn.flattenToString() : this.bhl;
    }
}
