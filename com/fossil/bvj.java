package com.fossil;

import android.content.Context;
import android.os.Looper;
import com.fossil.ats.C1888f;
import com.fossil.ats.C1890b;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.fossil.bve.C1963a;

public final class bvj extends C1890b<bvh, bve> {
    public final /* synthetic */ C1888f mo1176a(Context context, Looper looper, awy com_fossil_awy, Object obj, C1898b c1898b, C1899c c1899c) {
        bve com_fossil_bve = (bve) obj;
        return new bvh(context, looper, com_fossil_awy, c1898b, c1899c, context.getPackageName(), com_fossil_bve == null ? new C1963a().SL() : com_fossil_bve);
    }
}
