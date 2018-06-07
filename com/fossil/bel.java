package com.fossil;

import android.util.Log;
import com.google.android.gms.common.api.zza;
import java.util.Collections;

final class bel implements caf<Void> {
    private /* synthetic */ bej bsy;

    private bel(bej com_fossil_bej) {
        this.bsy = com_fossil_bej;
    }

    public final void mo1301a(cag<Void> com_fossil_cag_java_lang_Void) {
        this.bsy.bsg.lock();
        try {
            if (this.bsy.bst) {
                if (com_fossil_cag_java_lang_Void.TQ()) {
                    this.bsy.bsu = new jl(this.bsy.bsl.size());
                    for (bei KB : this.bsy.bsl.values()) {
                        this.bsy.bsu.put(KB.KB(), atn.bfH);
                    }
                } else if (com_fossil_cag_java_lang_Void.getException() instanceof zza) {
                    zza com_google_android_gms_common_api_zza = (zza) com_fossil_cag_java_lang_Void.getException();
                    if (this.bsy.bsr) {
                        this.bsy.bsu = new jl(this.bsy.bsl.size());
                        for (bei com_fossil_bei : this.bsy.bsl.values()) {
                            bdn KB2 = com_fossil_bei.KB();
                            atn zza = com_google_android_gms_common_api_zza.zza(com_fossil_bei);
                            if (this.bsy.m4961a(com_fossil_bei, zza)) {
                                this.bsy.bsu.put(KB2, new atn(16));
                            } else {
                                this.bsy.bsu.put(KB2, zza);
                            }
                        }
                    } else {
                        this.bsy.bsu = com_google_android_gms_common_api_zza.zzpf();
                    }
                    this.bsy.bsx = this.bsy.Nu();
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", com_fossil_cag_java_lang_Void.getException());
                    this.bsy.bsu = Collections.emptyMap();
                    this.bsy.bsx = new atn(8);
                }
                if (this.bsy.bsv != null) {
                    this.bsy.bsu.putAll(this.bsy.bsv);
                    this.bsy.bsx = this.bsy.Nu();
                }
                if (this.bsy.bsx == null) {
                    this.bsy.Ns();
                    this.bsy.Nt();
                } else {
                    this.bsy.bst = false;
                    this.bsy.bso.mo1296g(this.bsy.bsx);
                }
                this.bsy.bsp.signalAll();
                this.bsy.bsg.unlock();
            }
        } finally {
            this.bsy.bsg.unlock();
        }
    }
}
