package com.fossil;

public class epr {
    public final String dQo;
    public final boolean dQp;
    public final String dQq;
    public final boolean dQr;
    public final String dQs;
    public final String message;
    public final String title;

    public epr(String str, String str2, String str3, boolean z, String str4, boolean z2, String str5) {
        this.title = str;
        this.message = str2;
        this.dQo = str3;
        this.dQp = z;
        this.dQq = str4;
        this.dQr = z2;
        this.dQs = str5;
    }
}
