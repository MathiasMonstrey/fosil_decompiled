package com.fossil;

import com.google.android.gms.common.api.Status;

final class bfk implements aua<Status> {
    private /* synthetic */ bfg btu;
    private /* synthetic */ bha btw;
    private /* synthetic */ boolean bty;
    private /* synthetic */ atv btz;

    bfk(bfg com_fossil_bfg, bha com_fossil_bha, boolean z, atv com_fossil_atv) {
        this.btu = com_fossil_bfg;
        this.btw = com_fossil_bha;
        this.bty = z;
        this.btz = com_fossil_atv;
    }

    public final /* synthetic */ void mo1184a(atz com_fossil_atz) {
        Status status = (Status) com_fossil_atz;
        atb.ai(this.btu.mContext).Kq();
        if (status.Kb() && this.btu.isConnected()) {
            this.btu.reconnect();
        }
        this.btw.m4406d(status);
        if (this.bty) {
            this.btz.disconnect();
        }
    }
}
