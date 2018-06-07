package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import com.fossil.cvg.C2382a;
import com.fossil.dkr.C2907a;
import com.fossil.dkr.C2908b;
import com.fossil.dlj.C2919a;
import com.fossil.dlq.C2920a;
import com.fossil.dlx.C2921a;
import com.fossil.dmh.C2922a;
import com.fossil.dmo.C2923a;
import com.fossil.dmv.C2924a;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge;
import com.portfolio.platform.data.model.buddychallenge.BCInvitation;
import com.portfolio.platform.data.model.buddychallenge.BCNotifications;
import com.portfolio.platform.data.model.buddychallenge.BCOpponent;
import com.portfolio.platform.response.buddychallenge.MFGetInvitationResponse;
import com.portfolio.platform.ui.view.MyChallengeView;
import java.util.Date;

public class dlg implements C2382a, C2907a, C2919a, C2920a, C2921a, C2922a, C2923a, C2924a {
    private static final String TAG = dlg.class.getSimpleName();
    private final gy cEa;
    private final BroadcastReceiver cFN = new C29141(this);
    private PortfolioApp cIo;
    private dmq cYA;
    private dnc cYB;
    private dmx cYC;
    private cvh cYE;
    private dll cYv;
    private dls cYw;
    private dme cYx;
    private dlz cYy;
    private dmj cYz;
    private final C2908b cZk;
    private int cZl;
    private Date mDate;
    private final cnr mSharedPreferencesManager;

    class C29141 extends BroadcastReceiver {
        final /* synthetic */ dlg cZm;

        C29141(dlg com_fossil_dlg) {
            this.cZm = com_fossil_dlg;
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("SERIAL");
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(PortfolioApp.ZQ().aaa())) {
                MFLogger.m12670d(dlg.TAG, "Inside .syncReceiver syncResult=" + intent.getIntExtra("sync_result", 3) + ",  serial=" + stringExtra);
                this.cZm.cZk.cD(false);
            }
        }
    }

    dlg(PortfolioApp portfolioApp, C2908b c2908b, Date date, cnr com_fossil_cnr, gy gyVar) {
        this.cIo = portfolioApp;
        this.cZk = c2908b;
        this.mDate = date;
        this.mSharedPreferencesManager = com_fossil_cnr;
        this.cEa = gyVar;
    }

    public void ahu() {
        this.cZk.cK(this);
    }

    public void start() {
        MFLogger.m12670d(TAG, "start");
        this.cEa.m11537a(this.cFN, new IntentFilter("BROADCAST_SYNC_COMPLETE"));
        if (this.cZk.isActive()) {
            this.cZk.cD(TextUtils.isEmpty(this.cIo.aaa()));
            this.cZk.jT(this.cZl);
        }
        if (PortfolioApp.cmB) {
            this.mDate = new Date();
            arM();
        }
    }

    public void stop() {
        this.cEa.unregisterReceiver(this.cFN);
    }

    public void mo2526a(dll com_fossil_dll, dls com_fossil_dls, dme com_fossil_dme, dlz com_fossil_dlz, dmj com_fossil_dmj, dmq com_fossil_dmq, dnc com_fossil_dnc, dmx com_fossil_dmx, cvh com_fossil_cvh) {
        this.cYv = com_fossil_dll;
        this.cYw = com_fossil_dls;
        this.cYx = com_fossil_dme;
        this.cYy = com_fossil_dlz;
        this.cYz = com_fossil_dmj;
        this.cYA = com_fossil_dmq;
        this.cYB = com_fossil_dnc;
        this.cYC = com_fossil_dmx;
        this.cYE = com_fossil_cvh;
        this.cYv.setDate(this.mDate);
        this.cYx.m9067z(this.mDate);
        this.cYw.m9035x(this.mDate);
        this.cYz.setDate(this.mDate);
        this.cYB.m9146z(this.mDate);
        this.cYA.m9114x(this.mDate);
    }

    public void lk(int i) {
        if (this.cZl != i) {
            this.cZl = i;
            this.cZk.jT(i);
        }
    }

    public void sync() {
        MFLogger.m12670d(TAG, "sync, call pull-sync");
        this.cIo.m12698e(false, 12);
    }

    public void aqU() {
        if (this.cZl == 0) {
            arB();
        } else {
            this.cYz.arI();
        }
    }

    public void arw() {
        this.cZk.aqW();
    }

    public void arx() {
        this.cYy.setDate(this.mDate);
        this.cZk.aqX();
    }

    public void ary() {
        this.cYC.setDate(this.mDate);
        this.cZk.aqY();
        this.cYC.arL();
    }

    public void arz() {
        this.cYw.m9035x(this.mDate);
        this.cZk.aqZ();
    }

    public void arA() {
        this.cYA.m9114x(this.mDate);
        this.cZk.ara();
    }

    public void arB() {
        switch (this.mSharedPreferencesManager.acR()) {
            case 0:
            case 1:
            case 2:
                this.cZk.arb();
                break;
        }
        this.cYv.arB();
    }

    public void arC() {
        this.cYv.arC();
    }

    public void arD() {
        this.cYv.arD();
    }

    public void arE() {
        this.cYv.arE();
    }

    public void arF() {
        this.cYv.arF();
    }

    public void arG() {
        this.cYw.arG();
    }

    public void mo2525a(int i, Date date) {
        this.mDate = date;
        arM();
        this.cYv.arB();
        this.cYx.asc();
    }

    public void mo2546s(Date date) {
        this.cYw.mo2546s(date);
    }

    public void arH() {
    }

    public void arI() {
        this.cYz.arI();
    }

    public void arJ() {
        this.cYz.arJ();
    }

    public void arK() {
        this.cYA.arK();
    }

    public void mo2544b(int i, Date date) {
        this.mDate = date;
        arM();
        this.cYz.arI();
        this.cYB.asn();
    }

    public void mo2548t(Date date) {
        this.cYA.mo2548t(date);
    }

    public void arL() {
    }

    private void arM() {
        this.cYv.setDate(this.mDate);
        this.cYx.m9067z(this.mDate);
        this.cYw.m9035x(this.mDate);
        this.cYz.setDate(this.mDate);
        this.cYB.m9146z(this.mDate);
        this.cYA.m9114x(this.mDate);
    }

    public void jX(int i) {
        this.cYE.jX(i);
    }

    public void aia() {
        this.cYE.aia();
    }

    public void hO(String str) {
        this.cYE.hO(str);
    }

    public void iQ(final String str) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqx(PortfolioApp.ZQ(), str), new MFServerResultCallback(this) {
            final /* synthetic */ dlg cZm;

            public void onSuccess(MFResponse mFResponse) {
                MFLogger.m12670d("StatsPresenter", "getInvitation onSuccess");
                final BCInvitation invitation = ((MFGetInvitationResponse) mFResponse).getInvitation();
                if (invitation != null && invitation.getInvitationId().equals(str) && invitation.getStatus() == 0) {
                    new Handler().postDelayed(new Runnable(this) {
                        final /* synthetic */ C29162 cZp;

                        public void run() {
                            if (this.cZp.cZm.cZk.isActive()) {
                                this.cZp.cZm.cYE.m7667d(invitation);
                                this.cZp.cZm.cZk.afM();
                            }
                        }
                    }, 500);
                } else if (invitation != null && invitation.getInvitationId().equals(str) && invitation.getStatus() == 4 && this.cZm.cZk.isActive()) {
                    this.cZm.cZk.aqV();
                    this.cZm.cZk.afM();
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.m12670d("StatsPresenter", "getInvitation onFailed");
                if (this.cZm.cZk.isActive()) {
                    this.cZm.cZk.afM();
                }
            }
        });
    }

    public void m8971f(final BCNotifications bCNotifications) {
        MFLogger.m12670d("StatsPresenter", "handleNotification ");
        this.cZk.arc();
        Handler handler = new Handler();
        switch (bCNotifications.getType()) {
            case 0:
                iQ(bCNotifications.getId());
                return;
            case 2:
                handler.postDelayed(new Runnable(this) {
                    final /* synthetic */ dlg cZm;

                    public void run() {
                        this.cZm.cYE.m7666c(bCNotifications);
                    }
                }, 500);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
                handler.postDelayed(new Runnable(this) {
                    final /* synthetic */ dlg cZm;

                    public void run() {
                        this.cZm.m8970d(bCNotifications);
                    }
                }, 500);
                return;
            default:
                this.cZk.afM();
                return;
        }
    }

    public void jY(int i) {
        this.cYE.jY(i);
    }

    public void mo2098a(MyChallengeView myChallengeView) {
        this.cYE.mo2098a(myChallengeView);
    }

    public void m8969b(BCNotifications bCNotifications, BCChallenge bCChallenge, BCOpponent bCOpponent) {
        if (this.cZk.isActive()) {
            this.cZk.arc();
            this.cYE.m7665b(bCNotifications, bCChallenge, bCOpponent);
        }
    }

    public void m8970d(BCNotifications bCNotifications) {
        this.cYE.m7668d(bCNotifications);
    }
}
