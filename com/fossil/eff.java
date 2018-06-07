package com.fossil;

import java.util.UUID;

public class eff implements efe {
    String dDM = null;
    String dFC = null;
    elw dFD = null;
    elv dFE = null;
    elw dFF = null;
    elu dFG = null;
    elw dFH = null;
    elu dFI = null;

    public /* synthetic */ efe mo2826a(long j, double d) {
        return m10583c(j, d);
    }

    public /* synthetic */ efd aCO() {
        return aCP();
    }

    public /* synthetic */ efe mo2828b(long j, double d) {
        return m10584d(j, d);
    }

    public /* synthetic */ efe mo2829c(long j, int i) {
        return m10585d(j, i);
    }

    public /* synthetic */ efe lr(String str) {
        return lt(str);
    }

    public /* synthetic */ efe ls(String str) {
        return lu(str);
    }

    public eff lt(String str) {
        this.dDM = str;
        return this;
    }

    public eff lu(String str) {
        this.dFC = str;
        return this;
    }

    public eff m10585d(long j, int i) {
        if (this.dFD == null) {
            this.dFD = new elw();
            this.dFE = new elv();
        }
        this.dFD.add(j);
        this.dFE.oV(i);
        return this;
    }

    public eff m10583c(long j, double d) {
        if (this.dFF == null) {
            this.dFF = new elw();
            this.dFG = new elu();
        }
        this.dFF.add(j);
        this.dFG.add(d);
        return this;
    }

    public eff m10584d(long j, double d) {
        if (this.dFH == null) {
            this.dFH = new elw();
            this.dFI = new elu();
        }
        this.dFH.add(j);
        this.dFI.add(d);
        return this;
    }

    public efg aCP() {
        if (this.dDM == null) {
            throw new IllegalArgumentException("recorderTypeKey must be set.");
        }
        if (this.dFC == null) {
            this.dFC = UUID.randomUUID().toString();
        }
        return new efg(this);
    }
}
