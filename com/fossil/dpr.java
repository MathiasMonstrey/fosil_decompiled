package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.service.BackendFitnessService;
import java.util.Calendar;

public class dpr extends ckb<C2132b, C2133c, C2131a> {
    private boolean dde = false;
    private boolean ddf = false;
    private BroadcastReceiver ddg = new C30691(this);
    private BroadcastReceiver ddh = new C30702(this);

    class C30691 extends BroadcastReceiver {
        final /* synthetic */ dpr ddi;

        C30691(dpr com_fossil_dpr) {
            this.ddi = com_fossil_dpr;
        }

        public void onReceive(Context context, Intent intent) {
            this.ddi.dde = true;
            if (this.ddi.atN()) {
                this.ddi.abr().onSuccess(null);
            }
        }
    }

    class C30702 extends BroadcastReceiver {
        final /* synthetic */ dpr ddi;

        C30702(dpr com_fossil_dpr) {
            this.ddi = com_fossil_dpr;
        }

        public void onReceive(Context context, Intent intent) {
            this.ddi.ddf = true;
            if (this.ddi.atN()) {
                this.ddi.abr().onSuccess(null);
            }
        }
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return atM();
    }

    public dpr atM() {
        dpr com_fossil_dpr = new dpr();
        com_fossil_dpr.dde = this.dde;
        com_fossil_dpr.ddf = this.ddf;
        return com_fossil_dpr;
    }

    private boolean atN() {
        return this.ddf && this.dde;
    }

    protected void mo2022b(C2132b c2132b) {
        BackendFitnessService.c(PortfolioApp.ZQ(), cmq.m7132j(Calendar.getInstance().getTime()));
        BackendFitnessService.bC(PortfolioApp.ZQ());
    }

    public void ajd() {
        gy.m11536p(PortfolioApp.ZQ()).m11537a(this.ddg, new IntentFilter("action.download.sampleday.success"));
        gy.m11536p(PortfolioApp.ZQ()).m11537a(this.ddh, new IntentFilter("action.download.sleepday.success"));
    }

    public void aje() {
        gy.m11536p(PortfolioApp.ZQ()).unregisterReceiver(this.ddg);
        gy.m11536p(PortfolioApp.ZQ()).unregisterReceiver(this.ddh);
    }
}
