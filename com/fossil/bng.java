package com.fossil;

import android.text.TextUtils;

final class bng {
    private String bwS;
    private String bwT;
    private String bwU;
    private String bwV;
    private long bwW;
    private long bwX;
    private long bwY;
    private String bwZ;
    private long bxa;
    private String bxb;
    private long bxc;
    private long bxd;
    private boolean bxe;
    private long bxf;
    private long bxg;
    private long bxh;
    private long bxi;
    private long bxj;
    private long bxk;
    private long bxl;
    private String bxm;
    private boolean bxn;
    private long bxo;
    private long bxp;
    private final String mAppId;
    private final bpk zzboe;

    bng(bpk com_fossil_bpk, String str) {
        awa.bO(com_fossil_bpk);
        awa.df(str);
        this.zzboe = com_fossil_bpk;
        this.mAppId = str;
        this.zzboe.Pe().OP();
    }

    public final long PA() {
        this.zzboe.Pe().OP();
        return this.bxi;
    }

    public final long PB() {
        this.zzboe.Pe().OP();
        return this.bxj;
    }

    public final long PC() {
        this.zzboe.Pe().OP();
        return this.bxl;
    }

    public final long PD() {
        this.zzboe.Pe().OP();
        return this.bxk;
    }

    public final String PE() {
        this.zzboe.Pe().OP();
        return this.bxm;
    }

    public final String PF() {
        this.zzboe.Pe().OP();
        String str = this.bxm;
        dU(null);
        return str;
    }

    public final long PG() {
        this.zzboe.Pe().OP();
        return this.bxf;
    }

    public final void Pi() {
        this.zzboe.Pe().OP();
        this.bxn = false;
    }

    public final String Pj() {
        this.zzboe.Pe().OP();
        return this.mAppId;
    }

    public final String Pk() {
        this.zzboe.Pe().OP();
        return this.bwU;
    }

    public final String Pl() {
        this.zzboe.Pe().OP();
        return this.bwV;
    }

    public final long Pm() {
        this.zzboe.Pe().OP();
        return this.bwX;
    }

    public final long Pn() {
        this.zzboe.Pe().OP();
        return this.bwY;
    }

    public final String Po() {
        this.zzboe.Pe().OP();
        return this.bwZ;
    }

    public final long Pp() {
        this.zzboe.Pe().OP();
        return this.bxa;
    }

    public final String Pq() {
        this.zzboe.Pe().OP();
        return this.bxb;
    }

    public final long Pr() {
        this.zzboe.Pe().OP();
        return this.bxc;
    }

    public final long Ps() {
        this.zzboe.Pe().OP();
        return this.bxd;
    }

    public final boolean Pt() {
        this.zzboe.Pe().OP();
        return this.bxe;
    }

    public final long Pu() {
        this.zzboe.Pe().OP();
        return this.bwW;
    }

    public final long Pv() {
        this.zzboe.Pe().OP();
        return this.bxo;
    }

    public final long Pw() {
        this.zzboe.Pe().OP();
        return this.bxp;
    }

    public final void Px() {
        this.zzboe.Pe().OP();
        long j = this.bwW + 1;
        if (j > 2147483647L) {
            this.zzboe.Pf().Re().m5439d("Bundle index overflow. appId", bol.ei(this.mAppId));
            j = 0;
        }
        this.bxn = true;
        this.bwW = j;
    }

    public final long Py() {
        this.zzboe.Pe().OP();
        return this.bxg;
    }

    public final long Pz() {
        this.zzboe.Pe().OP();
        return this.bxh;
    }

    public final void m5318U(long j) {
        this.zzboe.Pe().OP();
        this.bxn = (this.bwX != j ? 1 : 0) | this.bxn;
        this.bwX = j;
    }

    public final void m5319V(long j) {
        this.zzboe.Pe().OP();
        this.bxn = (this.bwY != j ? 1 : 0) | this.bxn;
        this.bwY = j;
    }

    public final void m5320W(long j) {
        this.zzboe.Pe().OP();
        this.bxn = (this.bxa != j ? 1 : 0) | this.bxn;
        this.bxa = j;
    }

    public final void m5321X(long j) {
        this.zzboe.Pe().OP();
        this.bxn = (this.bxc != j ? 1 : 0) | this.bxn;
        this.bxc = j;
    }

    public final void m5322Y(long j) {
        this.zzboe.Pe().OP();
        this.bxn = (this.bxd != j ? 1 : 0) | this.bxn;
        this.bxd = j;
    }

    public final void m5323Z(long j) {
        int i = 1;
        awa.aY(j >= 0);
        this.zzboe.Pe().OP();
        boolean z = this.bxn;
        if (this.bwW == j) {
            i = 0;
        }
        this.bxn = z | i;
        this.bwW = j;
    }

    public final void aa(long j) {
        this.zzboe.Pe().OP();
        this.bxn = (this.bxo != j ? 1 : 0) | this.bxn;
        this.bxo = j;
    }

    public final void ab(long j) {
        this.zzboe.Pe().OP();
        this.bxn = (this.bxp != j ? 1 : 0) | this.bxn;
        this.bxp = j;
    }

    public final void ac(long j) {
        this.zzboe.Pe().OP();
        this.bxn = (this.bxg != j ? 1 : 0) | this.bxn;
        this.bxg = j;
    }

    public final void ad(long j) {
        this.zzboe.Pe().OP();
        this.bxn = (this.bxh != j ? 1 : 0) | this.bxn;
        this.bxh = j;
    }

    public final void ae(long j) {
        this.zzboe.Pe().OP();
        this.bxn = (this.bxi != j ? 1 : 0) | this.bxn;
        this.bxi = j;
    }

    public final void af(long j) {
        this.zzboe.Pe().OP();
        this.bxn = (this.bxj != j ? 1 : 0) | this.bxn;
        this.bxj = j;
    }

    public final void ag(long j) {
        this.zzboe.Pe().OP();
        this.bxn = (this.bxl != j ? 1 : 0) | this.bxn;
        this.bxl = j;
    }

    public final void ah(long j) {
        this.zzboe.Pe().OP();
        this.bxn = (this.bxk != j ? 1 : 0) | this.bxn;
        this.bxk = j;
    }

    public final void ai(long j) {
        this.zzboe.Pe().OP();
        this.bxn = (this.bxf != j ? 1 : 0) | this.bxn;
        this.bxf = j;
    }

    public final void dP(String str) {
        this.zzboe.Pe().OP();
        this.bxn = (!bsk.ae(this.bwS, str) ? 1 : 0) | this.bxn;
        this.bwS = str;
    }

    public final void dQ(String str) {
        this.zzboe.Pe().OP();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.bxn = (!bsk.ae(this.bwT, str) ? 1 : 0) | this.bxn;
        this.bwT = str;
    }

    public final void dR(String str) {
        this.zzboe.Pe().OP();
        this.bxn = (!bsk.ae(this.bwU, str) ? 1 : 0) | this.bxn;
        this.bwU = str;
    }

    public final void dS(String str) {
        this.zzboe.Pe().OP();
        this.bxn = (!bsk.ae(this.bwV, str) ? 1 : 0) | this.bxn;
        this.bwV = str;
    }

    public final void dT(String str) {
        this.zzboe.Pe().OP();
        this.bxn = (!bsk.ae(this.bxb, str) ? 1 : 0) | this.bxn;
        this.bxb = str;
    }

    public final void dU(String str) {
        this.zzboe.Pe().OP();
        this.bxn = (!bsk.ae(this.bxm, str) ? 1 : 0) | this.bxn;
        this.bxm = str;
    }

    public final String getAppInstanceId() {
        this.zzboe.Pe().OP();
        return this.bwS;
    }

    public final String getGmpAppId() {
        this.zzboe.Pe().OP();
        return this.bwT;
    }

    public final void setAppVersion(String str) {
        this.zzboe.Pe().OP();
        this.bxn = (!bsk.ae(this.bwZ, str) ? 1 : 0) | this.bxn;
        this.bwZ = str;
    }

    public final void setMeasurementEnabled(boolean z) {
        this.zzboe.Pe().OP();
        this.bxn = (this.bxe != z ? 1 : 0) | this.bxn;
        this.bxe = z;
    }
}
