package com.fossil;

public final class dux {
    private final String dqH;
    private final String duP;

    public dux(String str, String str2) {
        this.dqH = str;
        this.duP = str2;
    }

    public String getScheme() {
        return this.dqH;
    }

    public String getRealm() {
        return this.duP;
    }

    public boolean equals(Object obj) {
        return (obj instanceof dux) && dvw.equal(this.dqH, ((dux) obj).dqH) && dvw.equal(this.duP, ((dux) obj).duP);
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.duP != null) {
            hashCode = this.duP.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + 899) * 31;
        if (this.dqH != null) {
            i = this.dqH.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return this.dqH + " realm=\"" + this.duP + "\"";
    }
}
