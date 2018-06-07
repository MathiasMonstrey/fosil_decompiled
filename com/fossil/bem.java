package com.fossil;

import android.util.Log;
import com.google.android.gms.common.api.zza;
import java.util.Collections;

final class bem implements caf<Void> {
    private /* synthetic */ bej bsy;
    private bgv bsz;

    bem(bej com_fossil_bej, bgv com_fossil_bgv) {
        this.bsy = com_fossil_bej;
        this.bsz = com_fossil_bgv;
    }

    public final void mo1301a(cag<Void> com_fossil_cag_java_lang_Void) {
        this.bsy.bsg.lock();
        try {
            if (this.bsy.bst) {
                if (com_fossil_cag_java_lang_Void.TQ()) {
                    this.bsy.bsv = new jl(this.bsy.bsm.size());
                    for (bei KB : this.bsy.bsm.values()) {
                        this.bsy.bsv.put(KB.KB(), atn.bfH);
                    }
                } else if (com_fossil_cag_java_lang_Void.getException() instanceof zza) {
                    zza com_google_android_gms_common_api_zza = (zza) com_fossil_cag_java_lang_Void.getException();
                    if (this.bsy.bsr) {
                        this.bsy.bsv = new jl(this.bsy.bsm.size());
                        for (bei com_fossil_bei : this.bsy.bsm.values()) {
                            bdn KB2 = com_fossil_bei.KB();
                            atn zza = com_google_android_gms_common_api_zza.zza(com_fossil_bei);
                            if (this.bsy.m4961a(com_fossil_bei, zza)) {
                                this.bsy.bsv.put(KB2, new atn(16));
                            } else {
                                this.bsy.bsv.put(KB2, zza);
                            }
                        }
                    } else {
                        this.bsy.bsv = com_google_android_gms_common_api_zza.zzpf();
                    }
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", com_fossil_cag_java_lang_Void.getException());
                    this.bsy.bsv = Collections.emptyMap();
                }
                if (this.bsy.isConnected()) {
                    this.bsy.bsu.putAll(this.bsy.bsv);
                    if (this.bsy.Nu() == null) {
                        this.bsy.Ns();
                        this.bsy.Nt();
                        this.bsy.bsp.signalAll();
                    }
                }
                this.bsz.Kg();
                this.bsy.bsg.unlock();
                return;
            }
            this.bsz.Kg();
        } finally {
            this.bsy.bsg.unlock();
        }
    }

    final void cancel() {
        this.bsz.Kg();
    }
}
