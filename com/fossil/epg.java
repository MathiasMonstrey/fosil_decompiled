package com.fossil;

import java.util.Collection;

public class epg {
    public final String aHF;
    public final String aIr;
    public final String aIs;
    public final String appId;
    public final String dPU;
    public final String dPV;
    public final String dPW;
    public final epq dPX;
    public final Collection<emt> dPY;
    public final String name;
    public final int source;

    public epg(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8, epq com_fossil_epq, Collection<emt> collection) {
        this.aHF = str;
        this.appId = str2;
        this.aIr = str3;
        this.aIs = str4;
        this.dPU = str5;
        this.name = str6;
        this.source = i;
        this.dPV = str7;
        this.dPW = str8;
        this.dPX = com_fossil_epq;
        this.dPY = collection;
    }
}
