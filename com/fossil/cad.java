package com.fossil;

import android.content.Context;
import android.os.Looper;
import com.fossil.ats.C1888f;
import com.fossil.ats.C1890b;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.fossil.bzp.C1973a;
import com.google.android.gms.plus.internal.PlusCommonExtras;

final class cad extends C1890b<bzv, C1973a> {
    cad() {
    }

    public final /* synthetic */ C1888f mo1176a(Context context, Looper looper, awy com_fossil_awy, Object obj, C1898b c1898b, C1899c c1899c) {
        C1973a c1973a = (C1973a) obj;
        if (c1973a == null) {
            c1973a = new C1973a();
        }
        return new bzv(context, looper, com_fossil_awy, new bzy(com_fossil_awy.Lt().name, axv.m4687g(com_fossil_awy.Lv()), (String[]) c1973a.bJX.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()), c1898b, c1899c);
    }

    public final int getPriority() {
        return 2;
    }
}
