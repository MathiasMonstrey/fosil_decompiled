package com.google.common.collect;

import com.fossil.cci;
import com.fossil.ccm;
import com.fossil.ccm.a;
import com.fossil.cco;
import com.google.common.base.Equivalence;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class MapMaker {
    boolean bNg;
    int bNh = -1;
    int concurrencyLevel = -1;
    Equivalence<Object> keyEquivalence;
    Strength keyStrength;
    Strength valueStrength;

    enum Dummy {
        VALUE
    }

    MapMaker m14379a(Equivalence<Object> equivalence) {
        cco.b(this.keyEquivalence == null, "key equivalence was already set to %s", this.keyEquivalence);
        this.keyEquivalence = (Equivalence) cco.ce(equivalence);
        this.bNg = true;
        return this;
    }

    Equivalence<Object> UV() {
        return (Equivalence) ccm.r(this.keyEquivalence, UZ().defaultEquivalence());
    }

    public MapMaker iz(int i) {
        boolean z = true;
        cco.b(this.bNh == -1, "initial capacity was already set to %s", this.bNh);
        if (i < 0) {
            z = false;
        }
        cco.bz(z);
        this.bNh = i;
        return this;
    }

    int UW() {
        return this.bNh == -1 ? 16 : this.bNh;
    }

    public MapMaker iA(int i) {
        boolean z = true;
        cco.b(this.concurrencyLevel == -1, "concurrency level was already set to %s", this.concurrencyLevel);
        if (i <= 0) {
            z = false;
        }
        cco.bz(z);
        this.concurrencyLevel = i;
        return this;
    }

    int UX() {
        return this.concurrencyLevel == -1 ? 4 : this.concurrencyLevel;
    }

    public MapMaker UY() {
        return m14380a(Strength.WEAK);
    }

    MapMaker m14380a(Strength strength) {
        cco.b(this.keyStrength == null, "Key strength was already set to %s", this.keyStrength);
        this.keyStrength = (Strength) cco.ce(strength);
        if (strength != Strength.STRONG) {
            this.bNg = true;
        }
        return this;
    }

    Strength UZ() {
        return (Strength) ccm.r(this.keyStrength, Strength.STRONG);
    }

    MapMaker m14381b(Strength strength) {
        cco.b(this.valueStrength == null, "Value strength was already set to %s", this.valueStrength);
        this.valueStrength = (Strength) cco.ce(strength);
        if (strength != Strength.STRONG) {
            this.bNg = true;
        }
        return this;
    }

    Strength Va() {
        return (Strength) ccm.r(this.valueStrength, Strength.STRONG);
    }

    public <K, V> ConcurrentMap<K, V> Vb() {
        if (this.bNg) {
            return MapMakerInternalMap.create(this);
        }
        return new ConcurrentHashMap(UW(), 0.75f, UX());
    }

    public String toString() {
        a cb = ccm.cb(this);
        if (this.bNh != -1) {
            cb.v("initialCapacity", this.bNh);
        }
        if (this.concurrencyLevel != -1) {
            cb.v("concurrencyLevel", this.concurrencyLevel);
        }
        if (this.keyStrength != null) {
            cb.h("keyStrength", cci.toLowerCase(this.keyStrength.toString()));
        }
        if (this.valueStrength != null) {
            cb.h("valueStrength", cci.toLowerCase(this.valueStrength.toString()));
        }
        if (this.keyEquivalence != null) {
            cb.cc("keyEquivalence");
        }
        return cb.toString();
    }
}
