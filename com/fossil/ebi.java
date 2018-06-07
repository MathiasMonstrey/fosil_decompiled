package com.fossil;

import android.net.wifi.ScanResult;
import java.util.Comparator;

final class ebi implements Comparator<ScanResult> {
    ebi() {
    }

    public final int m10454a(ScanResult scanResult, ScanResult scanResult2) {
        int abs = Math.abs(scanResult.level);
        int abs2 = Math.abs(scanResult2.level);
        return abs > abs2 ? 1 : abs == abs2 ? 0 : -1;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return m10454a((ScanResult) obj, (ScanResult) obj2);
    }
}
