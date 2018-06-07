package com.fossil;

public final class bon {
    private final int Ll;
    private /* synthetic */ bol bzD;
    private final boolean bzE;
    private final boolean bzF;

    bon(bol com_fossil_bol, int i, boolean z, boolean z2) {
        this.bzD = com_fossil_bol;
        this.Ll = i;
        this.bzE = z;
        this.bzF = z2;
    }

    public final void m5437a(String str, Object obj, Object obj2) {
        this.bzD.m5435a(this.Ll, this.bzE, this.bzF, str, obj, obj2, null);
    }

    public final void m5438a(String str, Object obj, Object obj2, Object obj3) {
        this.bzD.m5435a(this.Ll, this.bzE, this.bzF, str, obj, obj2, obj3);
    }

    public final void m5439d(String str, Object obj) {
        this.bzD.m5435a(this.Ll, this.bzE, this.bzF, str, obj, null, null);
    }

    public final void log(String str) {
        this.bzD.m5435a(this.Ll, this.bzE, this.bzF, str, null, null, null);
    }
}
