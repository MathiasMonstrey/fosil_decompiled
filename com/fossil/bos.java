package com.fossil;

import java.util.List;
import java.util.Map;

final class bos implements Runnable {
    private final String bhE;
    private final int but;
    private final bor bzH;
    private final Throwable bzI;
    private final byte[] bzJ;
    private final Map<String, List<String>> bzK;

    private bos(String str, bor com_fossil_bor, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        awa.bO(com_fossil_bor);
        this.bzH = com_fossil_bor;
        this.but = i;
        this.bzI = th;
        this.bzJ = bArr;
        this.bhE = str;
        this.bzK = map;
    }

    public final void run() {
        this.bzH.mo1446a(this.bhE, this.but, this.bzI, this.bzJ, this.bzK);
    }
}
