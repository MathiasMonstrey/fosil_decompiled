package com.fossil;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class dxv {
    private static dxv dAB = null;
    private int f1465b = 0;
    private Context dAA = null;
    private Map<Integer, dxu> dAz = null;

    private dxv(Context context) {
        this.dAA = context.getApplicationContext();
        this.dAz = new HashMap(3);
        this.dAz.put(Integer.valueOf(1), new dxt(context));
        this.dAz.put(Integer.valueOf(2), new dxq(context));
        this.dAz.put(Integer.valueOf(4), new dxs(context));
    }

    private dxr aC(List<Integer> list) {
        if (list.size() >= 0) {
            for (Integer num : list) {
                dxu com_fossil_dxu = (dxu) this.dAz.get(num);
                if (com_fossil_dxu != null) {
                    dxr aBz = com_fossil_dxu.aBz();
                    if (aBz != null && dxw.cn(aBz.aWS)) {
                        return aBz;
                    }
                }
            }
        }
        return new dxr();
    }

    public static synchronized dxv dk(Context context) {
        dxv com_fossil_dxv;
        synchronized (dxv.class) {
            if (dAB == null) {
                dAB = new dxv(context);
            }
            com_fossil_dxv = dAB;
        }
        return com_fossil_dxv;
    }

    public final dxr aBA() {
        return aC(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4)})));
    }

    public final void cg(String str) {
        dxr aBA = aBA();
        aBA.aWS = str;
        if (!dxw.la(aBA.aWB)) {
            aBA.aWB = dxw.m10268Y(this.dAA);
        }
        if (!dxw.la(aBA.aWR)) {
            aBA.aWR = dxw.aa(this.dAA);
        }
        aBA.dAy = System.currentTimeMillis();
        for (Entry value : this.dAz.entrySet()) {
            ((dxu) value.getValue()).m10267a(aBA);
        }
    }
}
