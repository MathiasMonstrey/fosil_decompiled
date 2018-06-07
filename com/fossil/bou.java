package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class bou extends BroadcastReceiver {
    private static String bzQ = bou.class.getName();
    private boolean Ox;
    private boolean bzR;
    private final bpk zzboe;

    bou(bpk com_fossil_bpk) {
        awa.bO(com_fossil_bpk);
        this.zzboe = com_fossil_bpk;
    }

    public final void Rl() {
        this.zzboe.RA();
        this.zzboe.Pe().OP();
        if (!this.Ox) {
            this.zzboe.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.bzR = this.zzboe.RG().Rk();
            this.zzboe.Pf().Ri().m5439d("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.bzR));
            this.Ox = true;
        }
    }

    public void onReceive(Context context, Intent intent) {
        this.zzboe.RA();
        String action = intent.getAction();
        this.zzboe.Pf().Ri().m5439d("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean Rk = this.zzboe.RG().Rk();
            if (this.bzR != Rk) {
                this.bzR = Rk;
                this.zzboe.Pe().m5469h(new bov(this, Rk));
                return;
            }
            return;
        }
        this.zzboe.Pf().Re().m5439d("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void unregister() {
        this.zzboe.RA();
        this.zzboe.Pe().OP();
        this.zzboe.Pe().OP();
        if (this.Ox) {
            this.zzboe.Pf().Ri().log("Unregistering connectivity change receiver");
            this.Ox = false;
            this.bzR = false;
            try {
                this.zzboe.getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzboe.Pf().Rc().m5439d("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
