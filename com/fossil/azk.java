package com.fossil;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.c;
import com.google.android.gms.dynamite.DynamiteModule.zzc;

public final class azk implements c {
    public final azn m4748a(Context context, String str, azm com_fossil_azm) throws zzc {
        azn com_fossil_azn = new azn();
        com_fossil_azn.bkg = com_fossil_azm.mo1237q(context, str);
        if (com_fossil_azn.bkg != 0) {
            com_fossil_azn.bkh = com_fossil_azm.mo1236b(context, str, false);
        } else {
            com_fossil_azn.bkh = com_fossil_azm.mo1236b(context, str, true);
        }
        if (com_fossil_azn.bkg == 0 && com_fossil_azn.bkh == 0) {
            com_fossil_azn.bki = 0;
        } else if (com_fossil_azn.bkh >= com_fossil_azn.bkg) {
            com_fossil_azn.bki = 1;
        } else {
            com_fossil_azn.bki = -1;
        }
        return com_fossil_azn;
    }
}
