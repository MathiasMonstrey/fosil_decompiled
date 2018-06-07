package com.fossil;

public class enb {
    public final String aHT;
    public final boolean dNA;

    enb(String str, boolean z) {
        this.aHT = str;
        this.dNA = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        enb com_fossil_enb = (enb) obj;
        if (this.dNA != com_fossil_enb.dNA) {
            return false;
        }
        if (this.aHT != null) {
            if (this.aHT.equals(com_fossil_enb.aHT)) {
                return true;
            }
        } else if (com_fossil_enb.aHT == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.aHT != null) {
            hashCode = this.aHT.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.dNA) {
            i = 1;
        }
        return hashCode + i;
    }
}
