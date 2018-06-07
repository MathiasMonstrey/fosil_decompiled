package com.fossil;

import android.text.TextUtils;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.cvg.C2382a;
import com.fossil.cvg.C2383b;
import com.fossil.dpd.C3049a;
import com.fossil.dpd.C3050b;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge;
import com.portfolio.platform.data.model.buddychallenge.BCInvitation;
import com.portfolio.platform.data.model.buddychallenge.BCNotifications;
import com.portfolio.platform.data.model.buddychallenge.BCOpponent;
import com.portfolio.platform.data.model.buddychallenge.BCPlayer;
import com.portfolio.platform.response.buddychallenge.MFGetChallengeListResponse;
import com.portfolio.platform.response.buddychallenge.MFGetChallengeResponse;
import com.portfolio.platform.ui.view.MyChallengeView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class cvh extends cvf implements C2382a {
    private static final String TAG = cvh.class.getSimpleName();
    private BCPlayer cGy = null;
    private C2383b cHb;
    private final dpd cHc;
    private ckc mUseCaseHandler;

    class C23852 implements Comparator<BCChallenge> {
        final /* synthetic */ cvh cHe;

        C23852(cvh com_fossil_cvh) {
            this.cHe = com_fossil_cvh;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7657a((BCChallenge) obj, (BCChallenge) obj2);
        }

        public int m7657a(BCChallenge bCChallenge, BCChallenge bCChallenge2) {
            return (int) (cnf.gp(bCChallenge.getStartTime()) - cnf.gp(bCChallenge2.getStartTime()));
        }
    }

    class C23874 implements MFServerResultCallback {
        final /* synthetic */ cvh cHe;

        C23874(cvh com_fossil_cvh) {
            this.cHe = com_fossil_cvh;
        }

        public void onSuccess(MFResponse mFResponse) {
            String receiverId;
            MFLogger.m12670d(cvh.TAG, "MFGetChallengeRequest onSuccess");
            BCChallenge challenge = ((MFGetChallengeResponse) mFResponse).getChallenge();
            if (cnq.acd().acw().adI().getUserId().equals(challenge.getSenderId())) {
                receiverId = challenge.getReceiverId();
            } else {
                receiverId = challenge.getSenderId();
            }
            BCOpponent hb = cnq.acd().acw().hb(receiverId);
            if (this.cHe.cHb.isActive()) {
                this.cHe.cHb.mo2104a(challenge, hb, challenge.getType());
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            MFLogger.m12670d(cvh.TAG, "MFGetChallengeRequest onFailed");
            if (this.cHe.cHb.isActive()) {
                this.cHe.cHb.afM();
            }
        }
    }

    cvh(C2383b c2383b, ckc com_fossil_ckc, dpd com_fossil_dpd) {
        this.cHb = (C2383b) emj.ce(c2383b);
        this.mUseCaseHandler = (ckc) emj.ce(com_fossil_ckc);
        this.cHc = com_fossil_dpd;
    }

    public void ahu() {
        this.cHb.cK(this);
    }

    public void start() {
    }

    public void stop() {
    }

    public void jX(final int i) {
        this.mUseCaseHandler.m6886a(this.cHc, new C3049a(new Date()), new C2126d<C3050b, C2131a>(this) {
            final /* synthetic */ cvh cHe;

            public /* synthetic */ void onError(Object obj) {
                m7655a((C2131a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m7656a((C3050b) obj);
            }

            public void m7656a(C3050b c3050b) {
                this.cHe.cHb.bW(i, c3050b.getStepGoal());
            }

            public void m7655a(C2131a c2131a) {
            }
        });
    }

    public void aia() {
        final Comparator c23852 = new C23852(this);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(cnq.acd().acw().adK());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            BCChallenge bCChallenge = (BCChallenge) it.next();
            if (bCChallenge.getStatus() == 3 || bCChallenge.getStatus() == 4) {
                it.remove();
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, c23852);
        }
        this.cHb.mo2111k(arrayList);
        it = arrayList.iterator();
        while (it.hasNext()) {
            String receiverId;
            bCChallenge = (BCChallenge) it.next();
            if (bCChallenge.getSenderId().equals(this.cGy.getUserId())) {
                receiverId = bCChallenge.getReceiverId();
            } else {
                receiverId = bCChallenge.getSenderId();
            }
            aC(receiverId, bCChallenge.getChallengeId());
        }
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqt(PortfolioApp.ZQ()), new MFServerResultCallback(this) {
            final /* synthetic */ cvh cHe;

            public void onSuccess(MFResponse mFResponse) {
                MFLogger.m12670d(cvh.TAG, " getChallengeResultList onSuccess");
                List<BCChallenge> adK = cnq.acd().acw().adK();
                ArrayList challengeList = ((MFGetChallengeListResponse) mFResponse).getChallengeList();
                if (challengeList.size() > 1) {
                    Collections.sort(challengeList, c23852);
                }
                for (BCChallenge bCChallenge : adK) {
                    BCChallenge bCChallenge2;
                    int i;
                    Iterator it = challengeList.iterator();
                    while (it.hasNext()) {
                        if (((BCChallenge) it.next()).getChallengeId().equals(bCChallenge2.getChallengeId())) {
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        cnq.acd().acw().mo1929b(bCChallenge2);
                    }
                }
                Iterator it2 = challengeList.iterator();
                while (it2.hasNext()) {
                    String receiverId;
                    bCChallenge2 = (BCChallenge) it2.next();
                    for (BCChallenge bCChallenge3 : adK) {
                        if (!bCChallenge2.getChallengeId().equals(bCChallenge3.getChallengeId()) || cnf.gp(bCChallenge2.getUpdatedAt()) >= cnf.gp(bCChallenge3.getUpdatedAt())) {
                            bCChallenge2.setPinType(0);
                        } else {
                            bCChallenge2.setReceiverStepsDays(bCChallenge3.getReceiverStepsDays());
                            bCChallenge2.setSenderStepsDays(bCChallenge3.getSenderStepsDays());
                            bCChallenge2.setUpdatedAt(bCChallenge3.getUpdatedAt());
                            bCChallenge2.setPinType(2);
                            challengeList.set(challengeList.indexOf(bCChallenge2), bCChallenge2);
                        }
                    }
                    cnq.acd().acw().mo1921a(bCChallenge2);
                    if (bCChallenge2.getSenderId().equals(this.cHe.cGy.getUserId())) {
                        receiverId = bCChallenge2.getReceiverId();
                    } else {
                        receiverId = bCChallenge2.getSenderId();
                    }
                    this.cHe.aC(receiverId, bCChallenge2.getChallengeId());
                }
                if (this.cHe.cHb.isActive()) {
                    this.cHe.cHb.mo2111k(challengeList);
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.m12670d(cvh.TAG, " getChallengeResultList onFailed");
            }
        });
    }

    public void jY(int i) {
        if (aib()) {
            this.cHb.jZ(i);
        } else {
            this.cHb.ka(i);
        }
    }

    public void mo2098a(MyChallengeView myChallengeView) {
        this.cHb.mo2107b(myChallengeView);
    }

    public void m7666c(BCNotifications bCNotifications) {
        hO(bCNotifications.getChallengeId());
    }

    public void m7665b(BCNotifications bCNotifications, BCChallenge bCChallenge, BCOpponent bCOpponent) {
        if (!this.cHb.isActive()) {
            return;
        }
        if (bCNotifications != null) {
            switch (bCNotifications.getType()) {
                case 0:
                    this.cHb.mo2104a(bCChallenge, bCOpponent, bCChallenge.getType());
                    return;
                case 2:
                    this.cHb.mo2104a(bCChallenge, bCOpponent, bCChallenge.getType());
                    return;
                case 7:
                    this.cHb.mo2104a(bCChallenge, bCOpponent, 6);
                    return;
                case 8:
                    this.cHb.mo2104a(bCChallenge, bCOpponent, 7);
                    return;
                case 9:
                    this.cHb.mo2104a(bCChallenge, bCOpponent, 8);
                    return;
                case 10:
                    this.cHb.mo2104a(bCChallenge, bCOpponent, 9);
                    return;
                default:
                    return;
            }
        }
        this.cHb.mo2104a(bCChallenge, bCOpponent, bCChallenge.getType());
    }

    public void m7667d(BCInvitation bCInvitation) {
        if (this.cHb.isActive()) {
            this.cHb.mo2109c(bCInvitation);
        }
    }

    public void mo2095a(BCOpponent bCOpponent, String str) {
        if (this.cHb.isActive()) {
            this.cHb.mo2106b(bCOpponent, str);
        }
    }

    public void hO(String str) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqu(PortfolioApp.ZQ(), str), new C23874(this));
    }

    public void m7668d(final BCNotifications bCNotifications) {
        BCChallenge ha = cnq.acd().acw().ha(bCNotifications.getId());
        if (ha != null) {
            m7660a(bCNotifications, ha);
            return;
        }
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqu(PortfolioApp.ZQ(), bCNotifications.getId()), new MFServerResultCallback(this) {
            final /* synthetic */ cvh cHe;

            public void onSuccess(MFResponse mFResponse) {
                String receiverId;
                MFLogger.m12670d(cvh.TAG, "MFGetChallengeRequest onSuccess");
                BCChallenge challenge = ((MFGetChallengeResponse) mFResponse).getChallenge();
                if (cnq.acd().acw().adI().getUserId().equals(challenge.getSenderId())) {
                    receiverId = challenge.getReceiverId();
                } else {
                    receiverId = challenge.getSenderId();
                }
                BCOpponent hb = cnq.acd().acw().hb(receiverId);
                if (this.cHe.cHb.isActive()) {
                    this.cHe.cHb.mo2104a(challenge, hb, this.cHe.m7662e(bCNotifications));
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.m12670d(cvh.TAG, "MFGetChallengeRequest onFailed");
                if (this.cHe.cHb.isActive()) {
                    this.cHe.cHb.afM();
                }
            }
        });
    }

    private void m7660a(BCNotifications bCNotifications, BCChallenge bCChallenge) {
        String sender;
        BCPlayer adI = cnq.acd().acw().adI();
        if (adI == null || !adI.getUserId().equals(bCNotifications.getSender())) {
            sender = bCNotifications.getSender();
        } else {
            sender = bCNotifications.getReceiver();
        }
        this.cHb.mo2104a(bCChallenge, cnq.acd().acw().hb(sender), m7662e(bCNotifications));
    }

    private int m7662e(BCNotifications bCNotifications) {
        switch (bCNotifications.getType()) {
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 8;
            case 10:
                return 9;
            default:
                return -1;
        }
    }

    private boolean aib() {
        if (this.cGy == null || TextUtils.isEmpty(this.cGy.getUserName())) {
            this.cGy = cnq.acd().acw().adI();
        }
        return (this.cGy == null || TextUtils.isEmpty(this.cGy.getUserName())) ? false : true;
    }
}
