package com.fossil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;

public class enc {
    private final epb aHm;
    private final Context context;

    public enc(Context context) {
        this.context = context.getApplicationContext();
        this.aHm = new epc(context, "TwitterAdvertisingInfoPreferences");
    }

    public enb aFg() {
        enb aFh = aFh();
        if (m10958c(aFh)) {
            emm.aEU().mo2950d("Fabric", "Using AdvertisingInfo from Preference Store");
            m10955a(aFh);
            return aFh;
        }
        aFh = aFk();
        m10957b(aFh);
        return aFh;
    }

    private void m10955a(final enb com_fossil_enb) {
        new Thread(new enh(this) {
            final /* synthetic */ enc dNC;

            public void yH() {
                enb a = this.dNC.aFk();
                if (!com_fossil_enb.equals(a)) {
                    emm.aEU().mo2950d("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    this.dNC.m10957b(a);
                }
            }
        }).start();
    }

    @SuppressLint({"CommitPrefEdits"})
    private void m10957b(enb com_fossil_enb) {
        if (m10958c(com_fossil_enb)) {
            this.aHm.mo2992b(this.aHm.edit().putString("advertising_id", com_fossil_enb.aHT).putBoolean("limit_ad_tracking_enabled", com_fossil_enb.dNA));
        } else {
            this.aHm.mo2992b(this.aHm.edit().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    protected enb aFh() {
        return new enb(this.aHm.aGu().getString("advertising_id", ""), this.aHm.aGu().getBoolean("limit_ad_tracking_enabled", false));
    }

    public enf aFi() {
        return new end(this.context);
    }

    public enf aFj() {
        return new ene(this.context);
    }

    private boolean m10958c(enb com_fossil_enb) {
        return (com_fossil_enb == null || TextUtils.isEmpty(com_fossil_enb.aHT)) ? false : true;
    }

    private enb aFk() {
        enb aFg = aFi().aFg();
        if (m10958c(aFg)) {
            emm.aEU().mo2950d("Fabric", "Using AdvertisingInfo from Reflection Provider");
        } else {
            aFg = aFj().aFg();
            if (m10958c(aFg)) {
                emm.aEU().mo2950d("Fabric", "Using AdvertisingInfo from Service Provider");
            } else {
                emm.aEU().mo2950d("Fabric", "AdvertisingInfo not present");
            }
        }
        return aFg;
    }
}
