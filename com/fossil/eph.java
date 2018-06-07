package com.fossil;

public class eph {
    public final String dPZ;
    public final String dQa;
    public final boolean dQb;
    public final epf dQc;
    public final String identifier;
    public final String url;

    public eph(String str, String str2, String str3, String str4, boolean z, epf com_fossil_epf) {
        this.identifier = str;
        this.dPZ = str2;
        this.url = str3;
        this.dQa = str4;
        this.dQb = z;
        this.dQc = com_fossil_epf;
    }
}
