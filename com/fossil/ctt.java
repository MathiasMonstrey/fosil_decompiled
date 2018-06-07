package com.fossil;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C1250k;
import android.support.v8.renderscript.Allocation;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ProgressBar;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.ari.C1856a;
import com.fossil.cloudimagelib.Constants.DeviceType;
import com.fossil.cts.C2310a;
import com.fossil.cts.C2311b;
import com.fossil.dau.C2614b;
import com.fossil.dbx.C2639b;
import com.fossil.dha.C2764b;
import com.fossil.drk.C2333c;
import com.fossil.dse.C3168a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge.TYPE;
import com.portfolio.platform.data.model.buddychallenge.BCInvitation;
import com.portfolio.platform.data.model.buddychallenge.BCNotifications;
import com.portfolio.platform.data.model.buddychallenge.BCOpponent;
import com.portfolio.platform.data.model.buddychallenge.BCPlayer;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.helper.DeviceHelper.ImageStyle;
import com.portfolio.platform.ui.MainActivity;
import com.portfolio.platform.ui.device.DeviceActivity;
import com.portfolio.platform.ui.device.link.PairDeviceStartActivity;
import com.portfolio.platform.ui.profile.main.MainProfileActivity;
import com.portfolio.platform.util.URLHelper;
import com.portfolio.platform.util.URLHelper.StaticPage;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.FossilCircleImageView;
import com.portfolio.platform.view.FossilPopupWindow;
import com.sina.weibo.sdk.api.CmdObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;

public final class ctt extends ctn implements C2311b, C2333c {
    private static final String cFk = cFk;
    public static final C2312a cFl = new C2312a();
    public dbc cEU;
    public dhd cEV;
    public dcb cEW;
    public dlg cEX;
    private dqo<clh> cEY;
    private C2310a cEZ;
    private int cFa;
    private int cFb;
    private boolean cFc;
    private boolean cFd;
    private C3168a cFe;
    private ArrayList<FossilPopupWindow> cFf = new ArrayList();
    private final ArrayList<BCNotifications> cFg = new ArrayList();
    public cnr cFh;
    private final ArrayList<Fragment> cFi = new ArrayList();
    private final C2332t cFj = new C2332t(this);

    public static final class C2312a {
        private C2312a() {
        }

        public final String getTAG() {
            String simpleName = ctt.class.getSimpleName();
            esl.m11127i(simpleName, "MainFragment::class.java.simpleName");
            return simpleName;
        }

        public final ctt agH() {
            return new ctt();
        }
    }

    static final class C2313b implements OnClickListener {
        final /* synthetic */ ctt cFm;

        C2313b(ctt com_fossil_ctt) {
            this.cFm = com_fossil_ctt;
        }

        public final void onClick(View view) {
            if (this.cFm.agG()) {
                HashMap hashMap = new HashMap();
                hashMap.put("Screen", this.cFm.jU(this.cFm.cFa));
                hashMap.put("Dest", "Home");
                this.cFm.m7518f("explore_footer", hashMap);
            } else {
                this.cFm.hB(CmdObject.CMD_HOME);
            }
            this.cFm.jT(0);
            ctt.m7549d(this.cFm).jR(0);
        }
    }

    static final class C2314c implements OnClickListener {
        final /* synthetic */ ctt cFm;

        C2314c(ctt com_fossil_ctt) {
            this.cFm = com_fossil_ctt;
        }

        public final void onClick(View view) {
            this.cFm.cFc = true;
            this.cFm.agn();
        }
    }

    static final class C2315d implements OnClickListener {
        public static final C2315d cFn = new C2315d();

        C2315d() {
        }

        public final void onClick(View view) {
        }
    }

    static final class C2316e implements OnClickListener {
        final /* synthetic */ ctt cFm;

        C2316e(ctt com_fossil_ctt) {
            this.cFm = com_fossil_ctt;
        }

        public final void onClick(View view) {
            if (this.cFm.agG()) {
                HashMap hashMap = new HashMap();
                hashMap.put("Screen", this.cFm.jU(this.cFm.cFa));
                hashMap.put("Dest", "Device");
                this.cFm.m7518f("explore_footer", hashMap);
            } else {
                this.cFm.hB(Constants.DEVICE);
            }
            this.cFm.jT(1);
            ctt.m7549d(this.cFm).jR(1);
        }
    }

    static final class C2317f implements OnClickListener {
        final /* synthetic */ ctt cFm;

        C2317f(ctt com_fossil_ctt) {
            this.cFm = com_fossil_ctt;
        }

        public final void onClick(View view) {
            if (this.cFm.agG()) {
                HashMap hashMap = new HashMap();
                hashMap.put("Screen", this.cFm.jU(this.cFm.cFa));
                hashMap.put("Dest", "Notifications");
                this.cFm.m7518f("explore_footer", hashMap);
            } else {
                this.cFm.hB("notifications");
            }
            this.cFm.jT(2);
            ctt.m7549d(this.cFm).jR(2);
        }
    }

    static final class C2318g implements OnClickListener {
        final /* synthetic */ ctt cFm;

        C2318g(ctt com_fossil_ctt) {
            this.cFm = com_fossil_ctt;
        }

        public final void onClick(View view) {
            if (this.cFm.agG()) {
                HashMap hashMap = new HashMap();
                hashMap.put("Screen", this.cFm.jU(this.cFm.cFa));
                hashMap.put("Dest", "Stats");
                this.cFm.m7518f("explore_footer", hashMap);
            } else {
                this.cFm.hB("stats");
            }
            this.cFm.jT(3);
            ctt.m7549d(this.cFm).jR(3);
        }
    }

    static final class C2319h implements OnClickListener {
        final /* synthetic */ ctt cFm;

        C2319h(ctt com_fossil_ctt) {
            this.cFm = com_fossil_ctt;
        }

        public final void onClick(View view) {
            PairDeviceStartActivity.bF(this.cFm.getActivity());
        }
    }

    static final class C2320i implements OnClickListener {
        final /* synthetic */ ctt cFm;

        C2320i(ctt com_fossil_ctt) {
            this.cFm = com_fossil_ctt;
        }

        public final void onClick(View view) {
            this.cFm.jT(0);
        }
    }

    static final class C2321j implements OnClickListener {
        final /* synthetic */ ctt cFm;

        C2321j(ctt com_fossil_ctt) {
            this.cFm = com_fossil_ctt;
        }

        public final void onClick(View view) {
            cmj.bs(PortfolioApp.ZQ()).logEvent(Constants.USER_SETTING);
            clh com_fossil_clh = (clh) ctt.m7550e(this.cFm).get();
            ProgressBar progressBar = com_fossil_clh != null ? com_fossil_clh.cuK : null;
            if (progressBar == null) {
                esl.aGW();
            }
            if (progressBar.getVisibility() == 0) {
                C3168a f = ctt.m7551f(this.cFm);
                if (f != null) {
                    f.show();
                }
                this.cFm.cFd = true;
                return;
            }
            DeviceActivity.bF(this.cFm.getContext());
        }
    }

    static final class C2322k implements OnClickListener {
        final /* synthetic */ ctt cFm;

        C2322k(ctt com_fossil_ctt) {
            this.cFm = com_fossil_ctt;
        }

        public final void onClick(View view) {
            this.cFm.hB("profile");
            MainProfileActivity.bF(this.cFm.getContext());
        }
    }

    static final class C2323l implements Runnable {
        final /* synthetic */ ctt cFm;
        final /* synthetic */ BCNotifications cFo;

        C2323l(ctt com_fossil_ctt, BCNotifications bCNotifications) {
            this.cFm = com_fossil_ctt;
            this.cFo = bCNotifications;
        }

        public final void run() {
            this.cFm.hK(this.cFo.getId());
            if (this.cFm.agB() != null) {
                this.cFm.agB().m8971f(this.cFo);
            }
        }
    }

    static final class C2324m implements OnClickListener {
        final /* synthetic */ ctt cFm;
        final /* synthetic */ FossilPopupWindow cFp;

        C2324m(ctt com_fossil_ctt, FossilPopupWindow fossilPopupWindow) {
            this.cFm = com_fossil_ctt;
            this.cFp = fossilPopupWindow;
        }

        public final void onClick(View view) {
            this.cFp.dismiss();
            this.cFm.cFf.remove(this.cFp);
        }
    }

    static final class C2326n implements OnClickListener {
        final /* synthetic */ ctt cFm;
        final /* synthetic */ BCNotifications cFo;
        final /* synthetic */ FossilPopupWindow cFp;
        final /* synthetic */ BCChallenge cFq;
        final /* synthetic */ BCOpponent cFr;

        C2326n(ctt com_fossil_ctt, BCNotifications bCNotifications, BCChallenge bCChallenge, BCOpponent bCOpponent, FossilPopupWindow fossilPopupWindow) {
            this.cFm = com_fossil_ctt;
            this.cFo = bCNotifications;
            this.cFq = bCChallenge;
            this.cFr = bCOpponent;
            this.cFp = fossilPopupWindow;
        }

        public final void onClick(View view) {
            MFLogger.m12670d(ctt.cFl.getTAG(), "View button clicked!!!");
            String challengeId;
            switch (this.cFo.getType()) {
                case 0:
                case 1:
                case 11:
                    this.cFm.mo2031a(this.cFo);
                    break;
                case 2:
                    challengeId = this.cFo.getChallengeId();
                    esl.m11127i(challengeId, "notification.challengeId");
                    ctt.m7549d(this.cFm).mo2063a(this.cFo, this.cFr, challengeId);
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                    challengeId = this.cFo.getId();
                    esl.m11127i(challengeId, "notification.id");
                    if (this.cFq != null) {
                        this.cFm.mo2032a(this.cFo, this.cFq, this.cFr);
                    } else {
                        this.cFm.mo2031a(this.cFo);
                    }
                    ctt.m7549d(this.cFm).hH(challengeId);
                    break;
            }
            this.cFp.setOnDismissListener(new OnDismissListener() {
                public final void onDismiss() {
                    BCNotifications bCNotifications = (BCNotifications) this.cFp.getTag();
                    this.cFm.hM(bCNotifications != null ? bCNotifications.getId() : null);
                }
            });
            this.cFp.dismiss();
            this.cFm.cFf.remove(this.cFp);
        }
    }

    static final class C2327o implements Runnable {
        final /* synthetic */ ctt cFm;
        final /* synthetic */ BCNotifications cFo;
        final /* synthetic */ BCChallenge cFq;
        final /* synthetic */ BCOpponent cFr;

        C2327o(ctt com_fossil_ctt, BCNotifications bCNotifications, BCChallenge bCChallenge, BCOpponent bCOpponent) {
            this.cFm = com_fossil_ctt;
            this.cFo = bCNotifications;
            this.cFq = bCChallenge;
            this.cFr = bCOpponent;
        }

        public final void run() {
            this.cFm.afU();
            this.cFm.agB().m8969b(this.cFo, this.cFq, this.cFr);
        }
    }

    static final class C2328p implements C1856a {
        final /* synthetic */ ctt cFm;
        final /* synthetic */ clh cFt;
        final /* synthetic */ String cFu;

        C2328p(clh com_fossil_clh, ctt com_fossil_ctt, String str) {
            this.cFt = com_fossil_clh;
            this.cFm = com_fossil_ctt;
            this.cFu = str;
        }

        public final void mo1879C(String str, String str2) {
            if (this.cFm.isActive()) {
                tx.t(this.cFm).l(new File(str2)).c(DiskCacheStrategy.RESULT).c(this.cFt.cuC);
            }
        }
    }

    public static final class C2329q implements C1250k {
        C2329q() {
        }

        public void mo2030b(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        public void as(boolean z) {
        }

        public boolean mo2028a(RecyclerView recyclerView, MotionEvent motionEvent) {
            return true;
        }
    }

    public static final class C2330r implements C1250k {
        C2330r() {
        }

        public void mo2030b(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        public void as(boolean z) {
        }

        public boolean mo2028a(RecyclerView recyclerView, MotionEvent motionEvent) {
            return true;
        }
    }

    public static final class C2331s implements C1250k {
        C2331s() {
        }

        public void mo2030b(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        public void as(boolean z) {
        }

        public boolean mo2028a(RecyclerView recyclerView, MotionEvent motionEvent) {
            return true;
        }
    }

    public static final class C2332t extends BroadcastReceiver {
        final /* synthetic */ ctt cFm;

        C2332t(ctt com_fossil_ctt) {
            this.cFm = com_fossil_ctt;
        }

        public void onReceive(Context context, Intent intent) {
            esl.m11128j(context, "context");
            MFLogger.m12670d(ctt.cFl.getTAG(), "onReceive notification broadcast");
            if (intent != null) {
                Boolean bool = clw.cwB;
                esl.m11127i(bool, "Constants.IS_ENABLE_BC");
                if (bool.booleanValue()) {
                    ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("BC_SHOW_NOTIFICATION_CHALLENGES");
                    ArrayList parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("BC_SHOW_NOTIFICATION_INVITATIONS");
                    BCNotifications bCNotifications = (BCNotifications) intent.getParcelableExtra("BC_SHOW_NOTIFICATION_NOTIFICATIONS");
                    BCPlayer adI = cnq.acd().acw().adI();
                    ctt com_fossil_ctt;
                    String str;
                    if (parcelableArrayListExtra2 != null) {
                        Iterator it = parcelableArrayListExtra2.iterator();
                        while (it.hasNext()) {
                            BCInvitation bCInvitation = (BCInvitation) it.next();
                            MFLogger.m12670d(ctt.cFl.getTAG(), "handle notification for invitation " + bCInvitation.toString());
                            com_fossil_ctt = this.cFm;
                            String invitationId = bCInvitation.getInvitationId();
                            esl.m11127i(invitationId, "invite.invitationId");
                            if (com_fossil_ctt.hL(invitationId)) {
                                MFLogger.m12670d(ctt.cFl.getTAG(), "handle notification for invitation: invitation is showing");
                                this.cFm.hM(bCInvitation.getInvitationId());
                            } else {
                                BCNotifications bCNotifications2 = new BCNotifications();
                                str = "";
                                if (bCInvitation.getStatus() == 0) {
                                    if (!esl.m11125C(bCInvitation.getSender(), adI.getUserId())) {
                                        bCNotifications2.setType(0);
                                        str = bCInvitation.getSender();
                                        esl.m11127i(str, "invite.sender");
                                    } else {
                                        return;
                                    }
                                } else if (bCInvitation.getStatus() == 1) {
                                    if (!esl.m11125C(bCInvitation.getReceiver(), adI.getUserId())) {
                                        bCNotifications2.setType(2);
                                        str = bCInvitation.getReceiver();
                                        esl.m11127i(str, "invite.receiver");
                                    } else {
                                        return;
                                    }
                                }
                                bCNotifications2.setId(bCInvitation.getInvitationId());
                                bCNotifications2.setSender(bCInvitation.getSender());
                                bCNotifications2.setReceiver(bCInvitation.getReceiver());
                                bCNotifications2.setChallengeType(bCInvitation.getChallengeType());
                                bCNotifications2.setChallengeId(bCInvitation.getChallengeId());
                                ctt.m7549d(this.cFm).mo2064a(str, bCNotifications2, bCInvitation, null);
                            }
                        }
                    } else if (parcelableArrayListExtra != null) {
                        Iterator it2 = parcelableArrayListExtra.iterator();
                        while (it2.hasNext()) {
                            BCChallenge bCChallenge = (BCChallenge) it2.next();
                            MFLogger.m12670d(ctt.cFl.getTAG(), "handle notification for challenge " + bCChallenge.toString());
                            if (!((esl.m11125C(adI.getUserId(), bCChallenge.getReceiverId()) && bCChallenge.isReceiverViewedAfterClosed()) || (esl.m11125C(adI.getUserId(), bCChallenge.getSenderId()) && bCChallenge.isSenderViewedAfterClosed()))) {
                                com_fossil_ctt = this.cFm;
                                String challengeId = bCChallenge.getChallengeId();
                                esl.m11127i(challengeId, "challenge.challengeId");
                                if (com_fossil_ctt.hL(challengeId)) {
                                    MFLogger.m12670d(ctt.cFl.getTAG(), "handle notification for invitation: invitation is showing");
                                    this.cFm.hM(bCChallenge.getChallengeId());
                                } else {
                                    if (esl.m11125C(bCChallenge.getSenderId(), adI.getUserId())) {
                                        challengeId = bCChallenge.getReceiverId();
                                    } else {
                                        challengeId = bCChallenge.getSenderId();
                                    }
                                    BCNotifications bCNotifications3 = new BCNotifications();
                                    if (esl.m11125C(bCChallenge.getWinner(), adI.getUserId())) {
                                        bCNotifications3.setType(7);
                                    } else if (esl.m11125C(bCChallenge.getWinner(), challengeId)) {
                                        bCNotifications3.setType(8);
                                    } else if (bCChallenge.getType() == TYPE.TYPE_CHALLENGE_ONE.getValue() || bCChallenge.getType() == TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue()) {
                                        List senderStepsDays = bCChallenge.getSenderStepsDays();
                                        if (senderStepsDays == null) {
                                            esl.aGW();
                                        }
                                        int w = esb.m11118w(senderStepsDays);
                                        parcelableArrayListExtra = bCChallenge.getReceiverStepsDays();
                                        if (parcelableArrayListExtra == null) {
                                            esl.aGW();
                                        }
                                        if (w != esb.m11118w(parcelableArrayListExtra) || esb.m11118w(bCChallenge.getSenderStepsDays()) < bCChallenge.getGoal()) {
                                            bCNotifications3.setType(9);
                                        } else {
                                            bCNotifications3.setType(10);
                                        }
                                    } else if (bCChallenge.getSenderScore() != bCChallenge.getReceiverScore() || bCChallenge.getSenderScore() <= 0) {
                                        bCNotifications3.setType(9);
                                    } else {
                                        bCNotifications3.setType(10);
                                    }
                                    bCNotifications3.setId(bCChallenge.getChallengeId());
                                    bCNotifications3.setSender(bCChallenge.getSenderId());
                                    bCNotifications3.setReceiver(bCChallenge.getReceiverId());
                                    bCNotifications3.setChallengeType(bCChallenge.getType());
                                    bCNotifications3.setChallengeId(bCChallenge.getChallengeId());
                                    BCOpponent hb = cnq.acd().acw().hb(challengeId);
                                    bCChallenge = cnq.acd().acw().ha(bCChallenge.getChallengeId());
                                    if (hb != null && bCChallenge != null) {
                                        this.cFm.mo2033a(bCNotifications3, null, bCChallenge, hb);
                                    } else if (hb == null) {
                                        ctt.m7549d(this.cFm).mo2064a(challengeId, bCNotifications3, null, bCChallenge);
                                    }
                                }
                            }
                        }
                    } else if (bCNotifications != null) {
                        MFLogger.m12670d(ctt.cFl.getTAG(), "handle notification for notification " + bCNotifications.toString());
                        if (bCNotifications.getType() != 11) {
                            if (esl.m11125C(bCNotifications.getSender(), adI.getUserId())) {
                                str = bCNotifications.getReceiver();
                            } else {
                                str = bCNotifications.getSender();
                            }
                            ctt.m7549d(this.cFm).mo2064a(str, bCNotifications, null, null);
                            return;
                        }
                        this.cFm.mo2033a(bCNotifications, null, null, null);
                    }
                }
            }
        }
    }

    private final void hM(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.ctt.hM(java.lang.String):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:356)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 5 more
*/
        /*
        r0 = this;
        r0 = r6;
        r0 = (java.lang.CharSequence) r0;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = r5.cFg;
        r0 = (java.lang.Iterable) r0;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r1 = (java.util.Collection) r1;
        r3 = r0.iterator();
    L_0x001a:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0044;
    L_0x0020:
        r2 = r3.next();
        r0 = r2;
        r0 = (com.portfolio.platform.data.model.buddychallenge.BCNotifications) r0;
        r4 = r0.getId();
        r4 = com.fossil.esl.m11125C(r4, r6);
        if (r4 != 0) goto L_0x003b;
    L_0x0031:
        r0 = r0.getChallengeId();
        r0 = com.fossil.esl.m11125C(r0, r6);
        if (r0 == 0) goto L_0x0042;
    L_0x003b:
        r0 = 1;
    L_0x003c:
        if (r0 == 0) goto L_0x001a;
    L_0x003e:
        r1.add(r2);
        goto L_0x001a;
    L_0x0042:
        r0 = 0;
        goto L_0x003c;
    L_0x0044:
        r1 = (java.util.List) r1;
        r1 = (java.lang.Iterable) r1;
        r1 = r1.iterator();
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0066;
    L_0x0053:
        r0 = r1.next();
        r0 = (com.portfolio.platform.data.model.buddychallenge.BCNotifications) r0;
        r2 = r5.cFg;
        r3 = r5.cFg;
        r0 = r3.indexOf(r0);
        r2.remove(r0);
        goto L_0x004d;
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.ctt.hM(java.lang.String):void");
    }

    public void mo2033a(com.portfolio.platform.data.model.buddychallenge.BCNotifications r1, com.portfolio.platform.data.model.buddychallenge.BCInvitation r2, com.portfolio.platform.data.model.buddychallenge.BCChallenge r3, com.portfolio.platform.data.model.buddychallenge.BCOpponent r4) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.ctt.a(com.portfolio.platform.data.model.buddychallenge.BCNotifications, com.portfolio.platform.data.model.buddychallenge.BCInvitation, com.portfolio.platform.data.model.buddychallenge.BCChallenge, com.portfolio.platform.data.model.buddychallenge.BCOpponent):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:360)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 5 more
*/
        /*
        r0 = this;
        r0 = "notification";
        com.fossil.esl.m11128j(r9, r0);
        r0 = cFl;
        r0 = r0.getTAG();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "showBCPopup notification:";
        r1 = r1.append(r2);
        r2 = r9.toString();
        r1 = r1.append(r2);
        r2 = "\ninvitation:";
        r1 = r1.append(r2);
        r2 = java.lang.String.valueOf(r10);
        r1 = r1.append(r2);
        r2 = "\nchallenge:";
        r1 = r1.append(r2);
        r2 = java.lang.String.valueOf(r11);
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.misfit.frameworks.common.log.MFLogger.m12670d(r0, r1);
        r0 = com.fossil.cnq.acd();
        r0 = r0.ace();
        if (r0 == 0) goto L_0x0079;
    L_0x004b:
        r0 = r0.getCurrentUser();
        r2 = r0;
    L_0x0050:
        r5 = new com.portfolio.platform.view.FossilPopupWindow;
        r5.<init>();
        r0 = 0;
        r5.setFocusable(r0);
        r0 = 0;
        r5.setOutsideTouchable(r0);
        r0 = -1;
        r5.setWidth(r0);
        r0 = -2;
        r5.setHeight(r0);
        r0 = 0;
        r0 = (android.view.View) r0;
        r1 = r8.getContext();	 Catch:{ Exception -> 0x007c }
        r3 = 2130968773; // 0x7f0400c5 float:1.754621E38 double:1.052838463E-314;	 Catch:{ Exception -> 0x007c }
        r4 = 0;	 Catch:{ Exception -> 0x007c }
        r0 = android.view.View.inflate(r1, r3, r4);	 Catch:{ Exception -> 0x007c }
        r6 = r0;
    L_0x0076:
        if (r6 != 0) goto L_0x0082;
    L_0x0078:
        return;
    L_0x0079:
        r0 = 0;
        r2 = r0;
        goto L_0x0050;
    L_0x007c:
        r1 = move-exception;
        r1.printStackTrace();
        r6 = r0;
        goto L_0x0076;
    L_0x0082:
        r0 = r9.getType();
        switch(r0) {
            case 0: goto L_0x04ae;
            case 1: goto L_0x0528;
            case 2: goto L_0x03a5;
            case 3: goto L_0x0089;
            case 4: goto L_0x0089;
            case 5: goto L_0x0089;
            case 6: goto L_0x0089;
            case 7: goto L_0x00fe;
            case 8: goto L_0x01ea;
            case 9: goto L_0x02b9;
            case 10: goto L_0x058e;
            case 11: goto L_0x055b;
            default: goto L_0x0089;
        };
    L_0x0089:
        r0 = 2131755407; // 0x7f10018f float:1.9141692E38 double:1.053227112E-314;
        r1 = r6.findViewById(r0);
        r0 = new com.fossil.ctt$m;
        r0.<init>(r8, r5);
        r0 = (android.view.View.OnClickListener) r0;
        r1.setOnClickListener(r0);
        r0 = 2131755892; // 0x7f100374 float:1.9142676E38 double:1.0532273516E-314;
        r7 = r6.findViewById(r0);
        r0 = new com.fossil.ctt$n;
        r1 = r8;
        r2 = r9;
        r3 = r11;
        r4 = r12;
        r0.<init>(r1, r2, r3, r4, r5);
        r0 = (android.view.View.OnClickListener) r0;
        r7.setOnClickListener(r0);
        r5.setContentView(r6);
        r0 = 0;
        r5.ao(r0);
        r0 = r8.cEY;
        if (r0 != 0) goto L_0x00bf;
    L_0x00ba:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x00bf:
        r0 = r0.get();
        r0 = (com.fossil.clh) r0;
        if (r0 == 0) goto L_0x00f1;
    L_0x00c7:
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 24;
        if (r1 < r2) goto L_0x067a;
    L_0x00cd:
        r1 = 2;
        r1 = new int[r1];
        r2 = r0.cqd;
        r2.getLocationInWindow(r1);
        r2 = r8.getActivity();
        r2 = r2.getWindow();
        r2 = r2.getDecorView();
        r3 = 0;
        r4 = 0;
        r6 = 1;
        r1 = r1[r6];
        r0 = r0.cqd;
        r0 = r0.getHeight();
        r0 = r0 + r1;
        r5.showAtLocation(r2, r3, r4, r0);
    L_0x00f1:
        r5.update();
        r5.setTag(r9);
        r0 = r8.cFf;
        r0.add(r5);
        goto L_0x0078;
    L_0x00fe:
        if (r2 == 0) goto L_0x011d;
    L_0x0100:
        r0 = r2.getProfilePicture();
    L_0x0104:
        r0 = (java.lang.CharSequence) r0;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0146;
    L_0x010c:
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x011f;
    L_0x0115:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView";
        r0.<init>(r1);
        throw r0;
    L_0x011d:
        r0 = 0;
        goto L_0x0104;
    L_0x011f:
        r0 = (com.portfolio.platform.view.FossilCircleImageView) r0;
        r1 = 2;
        r0.setBorderWidth(r1);
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x0136;
    L_0x012e:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView";
        r0.<init>(r1);
        throw r0;
    L_0x0136:
        r0 = (com.portfolio.platform.view.FossilCircleImageView) r0;
        r1 = r8.getContext();
        r3 = 2131624017; // 0x7f0e0051 float:1.8875202E38 double:1.0531621966E-314;
        r1 = com.fossil.gn.m10634e(r1, r3);
        r0.setBorderColor(r1);
    L_0x0146:
        r0 = 2131755891; // 0x7f100373 float:1.9142674E38 double:1.053227351E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x0157;
    L_0x014f:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FlexibleTextView";
        r0.<init>(r1);
        throw r0;
    L_0x0157:
        r0 = (com.portfolio.platform.view.FlexibleTextView) r0;
        r1 = com.portfolio.platform.PortfolioApp.ZQ();
        r1 = (android.content.Context) r1;
        r3 = 2131296819; // 0x7f090233 float:1.8211565E38 double:1.0530005394E-314;
        r1 = com.fossil.arp.m4318u(r1, r3);
        r1 = (java.lang.CharSequence) r1;
        r0.setText(r1);
        r0 = r8;
        r0 = (android.support.v4.app.Fragment) r0;
        r1 = com.fossil.tx.t(r0);
        r0 = new com.fossil.cmg;
        r0.<init>();
        r0 = (com.fossil.xe) r0;
        r3 = r1.a(r0);
        r4 = new com.fossil.cmb;
        if (r2 == 0) goto L_0x01db;
    L_0x0181:
        r0 = r2.getProfilePicture();
    L_0x0185:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        if (r2 == 0) goto L_0x01dd;
    L_0x018c:
        r1 = r2.getFirstName();
    L_0x0190:
        r1 = r7.append(r1);
        r7 = " ";
        r7 = r1.append(r7);
        if (r2 == 0) goto L_0x01df;
    L_0x019c:
        r1 = r2.getLastName();
    L_0x01a0:
        r1 = r7.append(r1);
        r1 = r1.toString();
        r4.<init>(r0, r1);
        r1 = r3.bc(r4);
        r0 = 1;
        r2 = new com.fossil.up[r0];
        r3 = 0;
        r0 = new com.fossil.cmc;
        r4 = r8.getContext();
        r0.<init>(r4);
        r0 = (com.fossil.up) r0;
        r2[r3] = r0;
        r0 = r1.c(r2);
        r1 = com.bumptech.glide.load.engine.DiskCacheStrategy.RESULT;
        r1 = r0.c(r1);
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x01e1;
    L_0x01d3:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView";
        r0.<init>(r1);
        throw r0;
    L_0x01db:
        r0 = 0;
        goto L_0x0185;
    L_0x01dd:
        r1 = 0;
        goto L_0x0190;
    L_0x01df:
        r1 = 0;
        goto L_0x01a0;
    L_0x01e1:
        r0 = (com.portfolio.platform.view.FossilCircleImageView) r0;
        r0 = (android.widget.ImageView) r0;
        r1.c(r0);
        goto L_0x0089;
    L_0x01ea:
        r0 = 2131755891; // 0x7f100373 float:1.9142674E38 double:1.053227351E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x01fb;
    L_0x01f3:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FlexibleTextView";
        r0.<init>(r1);
        throw r0;
    L_0x01fb:
        r0 = (com.portfolio.platform.view.FlexibleTextView) r0;
        r1 = com.portfolio.platform.PortfolioApp.ZQ();
        r1 = (android.content.Context) r1;
        r2 = 2131296788; // 0x7f090214 float:1.8211503E38 double:1.053000524E-314;
        r1 = com.fossil.arp.m4318u(r1, r2);
        r1 = (java.lang.CharSequence) r1;
        r0.setText(r1);
        if (r12 == 0) goto L_0x022e;
    L_0x0211:
        r0 = r12.getProfilePicture();
    L_0x0215:
        r0 = (java.lang.CharSequence) r0;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0257;
    L_0x021d:
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x0230;
    L_0x0226:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView";
        r0.<init>(r1);
        throw r0;
    L_0x022e:
        r0 = 0;
        goto L_0x0215;
    L_0x0230:
        r0 = (com.portfolio.platform.view.FossilCircleImageView) r0;
        r1 = 2;
        r0.setBorderWidth(r1);
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x0247;
    L_0x023f:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView";
        r0.<init>(r1);
        throw r0;
    L_0x0247:
        r0 = (com.portfolio.platform.view.FossilCircleImageView) r0;
        r1 = r8.getContext();
        r2 = 2131624017; // 0x7f0e0051 float:1.8875202E38 double:1.0531621966E-314;
        r1 = com.fossil.gn.m10634e(r1, r2);
        r0.setBorderColor(r1);
    L_0x0257:
        r0 = r8;
        r0 = (android.support.v4.app.Fragment) r0;
        r1 = com.fossil.tx.t(r0);
        r0 = new com.fossil.cmg;
        r0.<init>();
        r0 = (com.fossil.xe) r0;
        r2 = r1.a(r0);
        r3 = new com.fossil.cmb;
        if (r12 == 0) goto L_0x02ab;
    L_0x026d:
        r0 = r12.getProfilePicture();
        r1 = r0;
    L_0x0272:
        if (r12 == 0) goto L_0x02ae;
    L_0x0274:
        r0 = r12.getUserName();
    L_0x0278:
        r3.<init>(r1, r0);
        r1 = r2.bc(r3);
        r0 = 1;
        r2 = new com.fossil.up[r0];
        r3 = 0;
        r0 = new com.fossil.cmc;
        r4 = r8.getContext();
        r0.<init>(r4);
        r0 = (com.fossil.up) r0;
        r2[r3] = r0;
        r0 = r1.c(r2);
        r1 = com.bumptech.glide.load.engine.DiskCacheStrategy.RESULT;
        r1 = r0.c(r1);
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x02b0;
    L_0x02a3:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView";
        r0.<init>(r1);
        throw r0;
    L_0x02ab:
        r0 = 0;
        r1 = r0;
        goto L_0x0272;
    L_0x02ae:
        r0 = 0;
        goto L_0x0278;
    L_0x02b0:
        r0 = (com.portfolio.platform.view.FossilCircleImageView) r0;
        r0 = (android.widget.ImageView) r0;
        r1.c(r0);
        goto L_0x0089;
    L_0x02b9:
        r0 = 2131755891; // 0x7f100373 float:1.9142674E38 double:1.053227351E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x02ca;
    L_0x02c2:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FlexibleTextView";
        r0.<init>(r1);
        throw r0;
    L_0x02ca:
        r0 = (com.portfolio.platform.view.FlexibleTextView) r0;
        r1 = com.portfolio.platform.PortfolioApp.ZQ();
        r1 = (android.content.Context) r1;
        r3 = 2131296782; // 0x7f09020e float:1.821149E38 double:1.053000521E-314;
        r1 = com.fossil.arp.m4318u(r1, r3);
        r1 = (java.lang.CharSequence) r1;
        r0.setText(r1);
        if (r2 == 0) goto L_0x02fd;
    L_0x02e0:
        r0 = r2.getProfilePicture();
    L_0x02e4:
        r0 = (java.lang.CharSequence) r0;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0326;
    L_0x02ec:
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x02ff;
    L_0x02f5:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView";
        r0.<init>(r1);
        throw r0;
    L_0x02fd:
        r0 = 0;
        goto L_0x02e4;
    L_0x02ff:
        r0 = (com.portfolio.platform.view.FossilCircleImageView) r0;
        r1 = 2;
        r0.setBorderWidth(r1);
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x0316;
    L_0x030e:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView";
        r0.<init>(r1);
        throw r0;
    L_0x0316:
        r0 = (com.portfolio.platform.view.FossilCircleImageView) r0;
        r1 = r8.getContext();
        r3 = 2131624017; // 0x7f0e0051 float:1.8875202E38 double:1.0531621966E-314;
        r1 = com.fossil.gn.m10634e(r1, r3);
        r0.setBorderColor(r1);
    L_0x0326:
        r0 = r8;
        r0 = (android.support.v4.app.Fragment) r0;
        r1 = com.fossil.tx.t(r0);
        r0 = new com.fossil.cmg;
        r0.<init>();
        r0 = (com.fossil.xe) r0;
        r3 = r1.a(r0);
        r4 = new com.fossil.cmb;
        if (r2 == 0) goto L_0x0396;
    L_0x033c:
        r0 = r2.getProfilePicture();
    L_0x0340:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        if (r2 == 0) goto L_0x0398;
    L_0x0347:
        r1 = r2.getFirstName();
    L_0x034b:
        r1 = r7.append(r1);
        r7 = " ";
        r7 = r1.append(r7);
        if (r2 == 0) goto L_0x039a;
    L_0x0357:
        r1 = r2.getLastName();
    L_0x035b:
        r1 = r7.append(r1);
        r1 = r1.toString();
        r4.<init>(r0, r1);
        r1 = r3.bc(r4);
        r0 = 1;
        r2 = new com.fossil.up[r0];
        r3 = 0;
        r0 = new com.fossil.cmc;
        r4 = r8.getContext();
        r0.<init>(r4);
        r0 = (com.fossil.up) r0;
        r2[r3] = r0;
        r0 = r1.c(r2);
        r1 = com.bumptech.glide.load.engine.DiskCacheStrategy.RESULT;
        r1 = r0.c(r1);
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x039c;
    L_0x038e:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView";
        r0.<init>(r1);
        throw r0;
    L_0x0396:
        r0 = 0;
        goto L_0x0340;
    L_0x0398:
        r1 = 0;
        goto L_0x034b;
    L_0x039a:
        r1 = 0;
        goto L_0x035b;
    L_0x039c:
        r0 = (com.portfolio.platform.view.FossilCircleImageView) r0;
        r0 = (android.widget.ImageView) r0;
        r1.c(r0);
        goto L_0x0089;
    L_0x03a5:
        r0 = r8.getContext();
        r0 = com.fossil.cmj.bs(r0);
        r1 = "stats_bc_accept";
        r2 = "Challenge";
        r3 = r9.getChallengeType();
        r3 = java.lang.String.valueOf(r3);
        r0.m7086l(r1, r2, r3);
        r0 = 2131755891; // 0x7f100373 float:1.9142674E38 double:1.053227351E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x03cd;
    L_0x03c5:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FlexibleTextView";
        r0.<init>(r1);
        throw r0;
    L_0x03cd:
        r0 = (com.portfolio.platform.view.FlexibleTextView) r0;
        r1 = com.fossil.esm.dSO;
        r1 = com.portfolio.platform.PortfolioApp.ZQ();
        r1 = (android.content.Context) r1;
        r2 = 2131296760; // 0x7f0901f8 float:1.8211446E38 double:1.05300051E-314;
        r2 = com.fossil.arp.m4318u(r1, r2);
        r1 = "LanguageHelper.getString…Buddy_Challenge_Accepted)";
        com.fossil.esl.m11127i(r2, r1);
        r1 = 1;
        r3 = new java.lang.Object[r1];
        r4 = 0;
        if (r12 == 0) goto L_0x0421;
    L_0x03e9:
        r1 = r12.getUserName();
    L_0x03ed:
        r3[r4] = r1;
        r1 = r3.length;
        r1 = java.util.Arrays.copyOf(r3, r1);
        r1 = java.lang.String.format(r2, r1);
        r2 = "java.lang.String.format(format, *args)";
        com.fossil.esl.m11127i(r1, r2);
        r1 = (java.lang.CharSequence) r1;
        r0.setText(r1);
        if (r12 == 0) goto L_0x0423;
    L_0x0404:
        r0 = r12.getProfilePicture();
    L_0x0408:
        r0 = (java.lang.CharSequence) r0;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x044c;
    L_0x0410:
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x0425;
    L_0x0419:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView";
        r0.<init>(r1);
        throw r0;
    L_0x0421:
        r1 = 0;
        goto L_0x03ed;
    L_0x0423:
        r0 = 0;
        goto L_0x0408;
    L_0x0425:
        r0 = (com.portfolio.platform.view.FossilCircleImageView) r0;
        r1 = 2;
        r0.setBorderWidth(r1);
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x043c;
    L_0x0434:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView";
        r0.<init>(r1);
        throw r0;
    L_0x043c:
        r0 = (com.portfolio.platform.view.FossilCircleImageView) r0;
        r1 = r8.getContext();
        r2 = 2131624017; // 0x7f0e0051 float:1.8875202E38 double:1.0531621966E-314;
        r1 = com.fossil.gn.m10634e(r1, r2);
        r0.setBorderColor(r1);
    L_0x044c:
        r0 = r8;
        r0 = (android.support.v4.app.Fragment) r0;
        r1 = com.fossil.tx.t(r0);
        r0 = new com.fossil.cmg;
        r0.<init>();
        r0 = (com.fossil.xe) r0;
        r2 = r1.a(r0);
        r3 = new com.fossil.cmb;
        if (r12 == 0) goto L_0x04a0;
    L_0x0462:
        r0 = r12.getProfilePicture();
        r1 = r0;
    L_0x0467:
        if (r12 == 0) goto L_0x04a3;
    L_0x0469:
        r0 = r12.getUserName();
    L_0x046d:
        r3.<init>(r1, r0);
        r1 = r2.bc(r3);
        r0 = 1;
        r2 = new com.fossil.up[r0];
        r3 = 0;
        r0 = new com.fossil.cmc;
        r4 = r8.getContext();
        r0.<init>(r4);
        r0 = (com.fossil.up) r0;
        r2[r3] = r0;
        r0 = r1.c(r2);
        r1 = com.bumptech.glide.load.engine.DiskCacheStrategy.RESULT;
        r1 = r0.c(r1);
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x04a5;
    L_0x0498:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView";
        r0.<init>(r1);
        throw r0;
    L_0x04a0:
        r0 = 0;
        r1 = r0;
        goto L_0x0467;
    L_0x04a3:
        r0 = 0;
        goto L_0x046d;
    L_0x04a5:
        r0 = (com.portfolio.platform.view.FossilCircleImageView) r0;
        r0 = (android.widget.ImageView) r0;
        r1.c(r0);
        goto L_0x0089;
    L_0x04ae:
        r0 = r8.getContext();
        r0 = com.fossil.cmj.bs(r0);
        r1 = "stats_bc_being_challenged";
        r2 = "Challenge";
        r3 = r9.getChallengeType();
        r3 = java.lang.String.valueOf(r3);
        r0.m7086l(r1, r2, r3);
        r0 = 2131755891; // 0x7f100373 float:1.9142674E38 double:1.053227351E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x04d6;
    L_0x04ce:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FlexibleTextView";
        r0.<init>(r1);
        throw r0;
    L_0x04d6:
        r0 = (com.portfolio.platform.view.FlexibleTextView) r0;
        r1 = com.fossil.esm.dSO;
        r1 = com.portfolio.platform.PortfolioApp.ZQ();
        r1 = (android.content.Context) r1;
        r2 = 2131296813; // 0x7f09022d float:1.8211553E38 double:1.0530005364E-314;
        r2 = com.fossil.arp.m4318u(r1, r2);
        r1 = "LanguageHelper.getString…_have_been_challenged_by)";
        com.fossil.esl.m11127i(r2, r1);
        r1 = 1;
        r3 = new java.lang.Object[r1];
        r4 = 0;
        if (r12 == 0) goto L_0x051c;
    L_0x04f2:
        r1 = r12.getUserName();
    L_0x04f6:
        r3[r4] = r1;
        r1 = r3.length;
        r1 = java.util.Arrays.copyOf(r3, r1);
        r1 = java.lang.String.format(r2, r1);
        r2 = "java.lang.String.format(format, *args)";
        com.fossil.esl.m11127i(r1, r2);
        r1 = (java.lang.CharSequence) r1;
        r0.setText(r1);
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x051e;
    L_0x0514:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type android.widget.ImageView";
        r0.<init>(r1);
        throw r0;
    L_0x051c:
        r1 = 0;
        goto L_0x04f6;
    L_0x051e:
        r0 = (android.widget.ImageView) r0;
        r1 = 2130837796; // 0x7f020124 float:1.7280556E38 double:1.052773752E-314;
        r0.setImageResource(r1);
        goto L_0x0089;
    L_0x0528:
        r0 = 2131755891; // 0x7f100373 float:1.9142674E38 double:1.053227351E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x0539;
    L_0x0531:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FlexibleTextView";
        r0.<init>(r1);
        throw r0;
    L_0x0539:
        r0 = (com.portfolio.platform.view.FlexibleTextView) r0;
        r1 = com.portfolio.platform.PortfolioApp.ZQ();
        r1 = (android.content.Context) r1;
        r2 = 2131296785; // 0x7f090211 float:1.8211496E38 double:1.0530005226E-314;
        r1 = com.fossil.arp.m4318u(r1, r2);
        r1 = (java.lang.CharSequence) r1;
        r0.setText(r1);
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x0089;
    L_0x055b:
        r0 = 2131755891; // 0x7f100373 float:1.9142674E38 double:1.053227351E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x056c;
    L_0x0564:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FlexibleTextView";
        r0.<init>(r1);
        throw r0;
    L_0x056c:
        r0 = (com.portfolio.platform.view.FlexibleTextView) r0;
        r1 = com.portfolio.platform.PortfolioApp.ZQ();
        r1 = (android.content.Context) r1;
        r2 = 2131296785; // 0x7f090211 float:1.8211496E38 double:1.0530005226E-314;
        r1 = com.fossil.arp.m4318u(r1, r2);
        r1 = (java.lang.CharSequence) r1;
        r0.setText(r1);
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x0089;
    L_0x058e:
        r0 = 2131755891; // 0x7f100373 float:1.9142674E38 double:1.053227351E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x059f;
    L_0x0597:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FlexibleTextView";
        r0.<init>(r1);
        throw r0;
    L_0x059f:
        r0 = (com.portfolio.platform.view.FlexibleTextView) r0;
        r1 = com.portfolio.platform.PortfolioApp.ZQ();
        r1 = (android.content.Context) r1;
        r3 = 2131296817; // 0x7f090231 float:1.8211561E38 double:1.0530005384E-314;
        r1 = com.fossil.arp.m4318u(r1, r3);
        r1 = (java.lang.CharSequence) r1;
        r0.setText(r1);
        if (r2 == 0) goto L_0x05d2;
    L_0x05b5:
        r0 = r2.getProfilePicture();
    L_0x05b9:
        r0 = (java.lang.CharSequence) r0;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x05fb;
    L_0x05c1:
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x05d4;
    L_0x05ca:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView";
        r0.<init>(r1);
        throw r0;
    L_0x05d2:
        r0 = 0;
        goto L_0x05b9;
    L_0x05d4:
        r0 = (com.portfolio.platform.view.FossilCircleImageView) r0;
        r1 = 2;
        r0.setBorderWidth(r1);
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x05eb;
    L_0x05e3:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView";
        r0.<init>(r1);
        throw r0;
    L_0x05eb:
        r0 = (com.portfolio.platform.view.FossilCircleImageView) r0;
        r1 = r8.getContext();
        r3 = 2131624017; // 0x7f0e0051 float:1.8875202E38 double:1.0531621966E-314;
        r1 = com.fossil.gn.m10634e(r1, r3);
        r0.setBorderColor(r1);
    L_0x05fb:
        r0 = r8;
        r0 = (android.support.v4.app.Fragment) r0;
        r1 = com.fossil.tx.t(r0);
        r0 = new com.fossil.cmg;
        r0.<init>();
        r0 = (com.fossil.xe) r0;
        r3 = r1.a(r0);
        r4 = new com.fossil.cmb;
        if (r2 == 0) goto L_0x066b;
    L_0x0611:
        r0 = r2.getProfilePicture();
    L_0x0615:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        if (r2 == 0) goto L_0x066d;
    L_0x061c:
        r1 = r2.getFirstName();
    L_0x0620:
        r1 = r7.append(r1);
        r7 = " ";
        r7 = r1.append(r7);
        if (r2 == 0) goto L_0x066f;
    L_0x062c:
        r1 = r2.getLastName();
    L_0x0630:
        r1 = r7.append(r1);
        r1 = r1.toString();
        r4.<init>(r0, r1);
        r1 = r3.bc(r4);
        r0 = 1;
        r2 = new com.fossil.up[r0];
        r3 = 0;
        r0 = new com.fossil.cmc;
        r4 = r8.getContext();
        r0.<init>(r4);
        r0 = (com.fossil.up) r0;
        r2[r3] = r0;
        r0 = r1.c(r2);
        r1 = com.bumptech.glide.load.engine.DiskCacheStrategy.RESULT;
        r1 = r0.c(r1);
        r0 = 2131755432; // 0x7f1001a8 float:1.9141743E38 double:1.0532271243E-314;
        r0 = r6.findViewById(r0);
        if (r0 != 0) goto L_0x0671;
    L_0x0663:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView";
        r0.<init>(r1);
        throw r0;
    L_0x066b:
        r0 = 0;
        goto L_0x0615;
    L_0x066d:
        r1 = 0;
        goto L_0x0620;
    L_0x066f:
        r1 = 0;
        goto L_0x0630;
    L_0x0671:
        r0 = (com.portfolio.platform.view.FossilCircleImageView) r0;
        r0 = (android.widget.ImageView) r0;
        r1.c(r0);
        goto L_0x0089;
    L_0x067a:
        r0 = r0.cqd;
        r0 = (android.view.View) r0;
        r5.showAsDropDown(r0);
        goto L_0x00f0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.ctt.a(com.portfolio.platform.data.model.buddychallenge.BCNotifications, com.portfolio.platform.data.model.buddychallenge.BCInvitation, com.portfolio.platform.data.model.buddychallenge.BCChallenge, com.portfolio.platform.data.model.buddychallenge.BCOpponent):void");
    }

    @android.annotation.TargetApi(21)
    public void mo2055c(com.portfolio.platform.data.model.MFUser r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.ctt.c(com.portfolio.platform.data.model.MFUser):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:356)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 5 more
*/
        /*
        r0 = this;
        r2 = 0;
        r0 = r7.cEY;
        if (r0 != 0) goto L_0x000a;
    L_0x0005:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x000a:
        r0 = r0.get();
        r0 = (com.fossil.clh) r0;
        if (r0 == 0) goto L_0x0043;
    L_0x0012:
        if (r8 == 0) goto L_0x0044;
    L_0x0014:
        r1 = r8.getProfilePicture();
    L_0x0018:
        r1 = (java.lang.CharSequence) r1;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x0046;
    L_0x0020:
        r3 = r0.cuD;
        if (r8 == 0) goto L_0x0028;
    L_0x0024:
        r2 = r8.getProfilePicture();
    L_0x0028:
        r1 = r7;
        r1 = (android.support.v4.app.Fragment) r1;
        r1 = com.fossil.tx.t(r1);
        r3.m12733a(r2, r1);
        r0 = r0.cuD;
        r1 = r7.getContext();
        r2 = 2131624138; // 0x7f0e00ca float:1.8875447E38 double:1.0531622564E-314;
        r1 = com.fossil.gn.m10634e(r1, r2);
        r0.setBorderColor(r1);
    L_0x0043:
        return;
    L_0x0044:
        r1 = r2;
        goto L_0x0018;
    L_0x0046:
        r1 = r7;
        r1 = (android.support.v4.app.Fragment) r1;
        r3 = com.fossil.tx.t(r1);
        r1 = new com.fossil.cmg;
        r1.<init>();
        r1 = (com.fossil.xe) r1;
        r3 = r3.a(r1);
        r4 = new com.fossil.cmb;
        r5 = "";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        if (r8 == 0) goto L_0x00e1;
    L_0x0063:
        r1 = r8.getFirstName();
        r1 = r6.append(r1);
        r6 = " ";
        r6 = r1.append(r6);
        if (r8 == 0) goto L_0x00e3;
    L_0x0073:
        r1 = r8.getLastName();
        r1 = r6.append(r1);
        r1 = r1.toString();
        r4.<init>(r5, r1);
        r3 = r3.bc(r4);
        r1 = 1;
        r4 = new com.fossil.up[r1];
        r5 = 0;
        r1 = new com.fossil.cmc;
        r6 = r7.getContext();
        r1.<init>(r6);
        r1 = (com.fossil.up) r1;
        r4[r5] = r1;
        r3 = r3.c(r4);
        r1 = r7.cEY;
        if (r1 != 0) goto L_0x00a4;
    L_0x009f:
        r4 = "mBinding";
        com.fossil.esl.mF(r4);
    L_0x00a4:
        r1 = r1.get();
        r1 = (com.fossil.clh) r1;
        if (r1 == 0) goto L_0x00e5;
    L_0x00ac:
        r1 = r1.cuD;
        r1 = (android.widget.ImageView) r1;
        r3.c(r1);
        r1 = r0.cuD;
        if (r1 == 0) goto L_0x00c5;
    L_0x00b7:
        r2 = r7.getContext();
        r3 = 2131624045; // 0x7f0e006d float:1.8875259E38 double:1.0531622105E-314;
        r2 = com.fossil.gn.m10634e(r2, r3);
        r1.setBorderColor(r2);
    L_0x00c5:
        r1 = r0.cuD;
        if (r1 == 0) goto L_0x00cd;
    L_0x00c9:
        r2 = 3;
        r1.setBorderWidth(r2);
    L_0x00cd:
        r0 = r0.cuD;
        if (r0 == 0) goto L_0x0042;
    L_0x00d1:
        r1 = r7.getContext();
        r2 = 2130837842; // 0x7f020152 float:1.728065E38 double:1.0527737746E-314;
        r1 = com.fossil.gn.m10632c(r1, r2);
        r0.setBackground(r1);
        goto L_0x0042;
    L_0x00e1:
        r1 = r2;
        goto L_0x0067;
    L_0x00e3:
        r1 = r2;
        goto L_0x0077;
    L_0x00e5:
        r1 = r2;
        goto L_0x00ae;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.ctt.c(com.portfolio.platform.data.model.MFUser):void");
    }

    public void jS(int r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.fossil.ctt.jS(int):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:356)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 5 more
*/
        /*
        r0 = this;
        r0 = r3.cEY;
        if (r0 != 0) goto L_0x0009;
    L_0x0004:
        r1 = "mBinding";
        com.fossil.esl.mF(r1);
    L_0x0009:
        r0 = r0.get();
        r0 = (com.fossil.clh) r0;
        if (r0 == 0) goto L_0x0035;
    L_0x0011:
        r1 = r0.cuK;
        if (r1 == 0) goto L_0x0019;
    L_0x0015:
        r2 = 0;
        r1.setVisibility(r2);
    L_0x0019:
        r0 = r0.cuK;
        if (r0 == 0) goto L_0x0020;
    L_0x001d:
        r0.setProgress(r4);
    L_0x0020:
        r0 = r3.getActivity();
        r0 = r0.getWindow();
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r0.addFlags(r1);
        r0 = r3.cFc;
        if (r0 != 0) goto L_0x0034;
    L_0x0031:
        r3.agm();
    L_0x0035:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.ctt.jS(int):void");
    }

    public static final /* synthetic */ C2310a m7549d(ctt com_fossil_ctt) {
        C2310a c2310a = com_fossil_ctt.cEZ;
        if (c2310a == null) {
            esl.mF("mPresenter");
        }
        return c2310a;
    }

    public static final /* synthetic */ dqo m7550e(ctt com_fossil_ctt) {
        dqo com_fossil_dqo = com_fossil_ctt.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        return com_fossil_dqo;
    }

    public static final /* synthetic */ C3168a m7551f(ctt com_fossil_ctt) {
        C3168a c3168a = com_fossil_ctt.cFe;
        if (c3168a == null) {
            esl.mF("mOtaTooltip");
        }
        return c3168a;
    }

    public /* synthetic */ void cK(Object obj) {
        m7553a((C2310a) obj);
    }

    public final dlg agB() {
        dlg com_fossil_dlg = this.cEX;
        if (com_fossil_dlg == null) {
            esl.mF("mStatsPresenter");
        }
        return com_fossil_dlg;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getContext().registerReceiver(this.cFj, new IntentFilter("BC_SHOW_NOTIFICATION_ACTION"));
    }

    public void onDestroy() {
        super.onDestroy();
        getContext().unregisterReceiver(this.cFj);
    }

    @SuppressLint({"SwitchIntDef"})
    private final String jU(int i) {
        switch (i) {
            case 1:
                return "Device";
            case 2:
                return "Notifications";
            case 3:
                return "Stats";
            default:
                return "Home";
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        clh com_fossil_clh = (clh) C3311e.m10386a(layoutInflater, R.layout.main_fragment, viewGroup, false, this.cEN);
        com_fossil_clh.cuH.setOnClickListener(new C2313b(this));
        com_fossil_clh.cuG.setOnClickListener(new C2316e(this));
        com_fossil_clh.cuI.setOnClickListener(new C2317f(this));
        com_fossil_clh.cuJ.setOnClickListener(new C2318g(this));
        com_fossil_clh.cuA.setOnClickListener(new C2319h(this));
        com_fossil_clh.cuE.setOnClickListener(new C2320i(this));
        com_fossil_clh.cuC.setOnClickListener(new C2321j(this));
        com_fossil_clh.cuD.setOnClickListener(new C2322k(this));
        this.cEY = new dqo(this, com_fossil_clh);
        C3168a a = new C3168a(com_fossil_clh.cuK).m9610a(R.string.Stats_Activity_Onboarding_Edit_CTA_OK, new C2314c(this)).mi(R.string.Onboarding_Pair_Onboarding_Text_Your_device_is_still_updating).m9610a(R.string.Stats_Activity_Onboarding_Edit_CTA_OK, C2315d.cFn);
        esl.m11127i(a, "FossilTooltip.Builder(bi…boarding_Edit_CTA_OK) { }");
        this.cFe = a;
        return com_fossil_clh.dz();
    }

    public void onViewCreated(View view, Bundle bundle) {
        C2310a c2310a;
        esl.m11128j(view, "view");
        super.onViewCreated(view, bundle);
        if (TextUtils.isEmpty(PortfolioApp.ZQ().YV().getUserAccessToken())) {
            this.cFb = 0;
        } else if (TextUtils.isEmpty(PortfolioApp.ZQ().aaa())) {
            this.cFb = 1;
        } else {
            this.cFb = 2;
        }
        agC();
        if (bundle != null) {
            c2310a = this.cEZ;
        } else {
            c2310a = this.cEZ;
        }
        if (c2310a == null) {
            esl.mF("mPresenter");
        }
        c2310a.jR(this.cFa);
    }

    public void onResume() {
        super.onResume();
        C2310a c2310a = this.cEZ;
        if (c2310a == null) {
            esl.mF("mPresenter");
        }
        c2310a.start();
    }

    public void onPause() {
        super.onPause();
        C2310a c2310a = this.cEZ;
        if (c2310a == null) {
            esl.mF("mPresenter");
        }
        c2310a.stop();
        getActivity().getWindow().clearFlags(Allocation.USAGE_SHARED);
    }

    public void onStop() {
        MFLogger.m12670d(cFl.getTAG(), "onStop()");
        super.onStop();
    }

    public void m7553a(C2310a c2310a) {
        esl.m11128j(c2310a, "presenter");
        this.cEZ = c2310a;
    }

    public void hI(String str) {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clh com_fossil_clh = (clh) com_fossil_dqo.get();
        if (com_fossil_clh != null) {
            com_fossil_clh.cuC.setVisibility(0);
            com_fossil_clh.cuA.setVisibility(8);
            ari.Jl().ad(getContext()).cG(str).cH(DeviceHelper.gi(str)).m4283a(DeviceType.TYPE_SMALL).m4280a(com_fossil_clh.cuC, DeviceHelper.a(str, ImageStyle.SMALL)).m4281a((C1856a) new C2328p(com_fossil_clh, this, str)).Jm();
        }
    }

    public void ags() {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clh com_fossil_clh = (clh) com_fossil_dqo.get();
        if (com_fossil_clh != null) {
            com_fossil_clh.cuC.setVisibility(8);
        }
    }

    public void agl() {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clh com_fossil_clh = (clh) com_fossil_dqo.get();
        if (com_fossil_clh != null) {
            ProgressBar progressBar = com_fossil_clh.cuK;
            if (progressBar != null) {
                progressBar.setVisibility(4);
            }
        }
        getActivity().getWindow().clearFlags(Allocation.USAGE_SHARED);
    }

    public void agm() {
        MFLogger.m12670d(cFl.getTAG(), "Inside .showToolTipTutorial mIsDialogAlreadyShowed=" + this.cFd);
        if (!this.cFd) {
            C3168a c3168a = this.cFe;
            if (c3168a == null) {
                esl.mF("mOtaTooltip");
            }
            c3168a.show();
            this.cFd = true;
        }
    }

    public void agn() {
        this.cFd = false;
        dse.hide();
    }

    public void agt() {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clh com_fossil_clh = (clh) com_fossil_dqo.get();
        if (com_fossil_clh != null) {
            FossilCircleImageView fossilCircleImageView = com_fossil_clh.cuD;
            if (fossilCircleImageView != null) {
                fossilCircleImageView.setVisibility(0);
            }
        }
    }

    public void agu() {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clh com_fossil_clh = (clh) com_fossil_dqo.get();
        if (com_fossil_clh != null) {
            FossilCircleImageView fossilCircleImageView = com_fossil_clh.cuD;
            if (fossilCircleImageView != null) {
                fossilCircleImageView.setVisibility(8);
            }
        }
    }

    public void agv() {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clh com_fossil_clh = (clh) com_fossil_dqo.get();
        if (com_fossil_clh != null) {
            FlexibleButton flexibleButton = com_fossil_clh.cuA;
            if (flexibleButton != null) {
                flexibleButton.setVisibility(0);
            }
        }
    }

    public void agw() {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clh com_fossil_clh = (clh) com_fossil_dqo.get();
        if (com_fossil_clh != null) {
            FlexibleButton flexibleButton = com_fossil_clh.cuA;
            if (flexibleButton != null) {
                flexibleButton.setVisibility(8);
            }
        }
    }

    public void ago() {
        this.cFc = false;
        if (isActive()) {
            dqw.m9427c(getChildFragmentManager());
        }
    }

    public void agp() {
        this.cFc = false;
        if (isActive()) {
            dqw.m9413E(getChildFragmentManager());
        }
    }

    public void jT(int i) {
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clh com_fossil_clh = (clh) com_fossil_dqo.get();
        if (com_fossil_clh != null) {
            int e = gn.m10634e(getContext(), R.color.fossilOrange);
            int e2 = gn.m10634e(getContext(), R.color.fossilCoolGray);
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(e, Mode.SRC_ATOP);
            PorterDuffColorFilter porterDuffColorFilter2 = new PorterDuffColorFilter(e2, Mode.SRC_ATOP);
            MFLogger.m12670d(cFl.getTAG(), "Show tab with mode=" + this.cFb + ", tab=" + i);
            switch (this.cFb) {
                case 0:
                    switch (i) {
                        case 0:
                            com_fossil_clh.cux.setVisibility(0);
                            com_fossil_clh.cuw.setVisibility(8);
                            break;
                        case 1:
                        case 2:
                        case 3:
                            com_fossil_clh.cux.setVisibility(8);
                            com_fossil_clh.cuw.setVisibility(0);
                            break;
                    }
                    MFLogger.m12670d(cFl.getTAG(), "Show tab with mode=" + this.cFb + ", tab=" + i);
                    com_fossil_clh.cuL.dg(i);
                    break;
                case 1:
                    switch (i) {
                        case 0:
                            com_fossil_clh.cux.setVisibility(0);
                            com_fossil_clh.cuw.setVisibility(8);
                            break;
                        case 1:
                        case 2:
                            com_fossil_clh.cux.setVisibility(8);
                            com_fossil_clh.cuw.setVisibility(0);
                            break;
                        case 3:
                            com_fossil_clh.cux.setVisibility(0);
                            com_fossil_clh.cuw.setVisibility(8);
                            break;
                    }
                    com_fossil_clh.cuL.dg(i);
                    break;
                case 2:
                    com_fossil_clh.cux.setVisibility(0);
                    com_fossil_clh.cuw.setVisibility(8);
                    MFLogger.m12670d(cFl.getTAG(), "Show tab with mode=" + this.cFb + ", tab=" + i);
                    com_fossil_clh.cuL.dg(i);
                    break;
            }
            com_fossil_clh.cur.getDrawable().setColorFilter(porterDuffColorFilter2);
            com_fossil_clh.cqm.getDrawable().setColorFilter(porterDuffColorFilter2);
            com_fossil_clh.cuu.getDrawable().setColorFilter(porterDuffColorFilter2);
            com_fossil_clh.cuv.getDrawable().setColorFilter(porterDuffColorFilter2);
            com_fossil_clh.cuy.setTextColor(e2);
            com_fossil_clh.cra.setTextColor(e2);
            com_fossil_clh.cuz.setTextColor(e2);
            com_fossil_clh.cuB.setTextColor(e2);
            switch (i) {
                case 0:
                    com_fossil_clh.cur.getDrawable().setColorFilter(porterDuffColorFilter);
                    com_fossil_clh.cuy.setTextColor(e);
                    break;
                case 1:
                    com_fossil_clh.cqm.getDrawable().setColorFilter(porterDuffColorFilter);
                    com_fossil_clh.cra.setTextColor(e);
                    break;
                case 2:
                    com_fossil_clh.cuu.getDrawable().setColorFilter(porterDuffColorFilter);
                    com_fossil_clh.cuz.setTextColor(e);
                    break;
                case 3:
                    com_fossil_clh.cuv.getDrawable().setColorFilter(porterDuffColorFilter);
                    com_fossil_clh.cuB.setTextColor(e);
                    break;
            }
            this.cFa = i;
            cnr YV = PortfolioApp.ZQ().YV();
            if (YV != null) {
                YV.jG(this.cFa);
            }
            C2310a c2310a = this.cEZ;
            if (c2310a == null) {
                esl.mF("mPresenter");
            }
            c2310a.jR(this.cFa);
        }
    }

    public void mo2057d(HashMap<String, String> hashMap) {
        String str;
        String str2 = null;
        String str3 = hashMap != null ? (String) hashMap.get("view") : null;
        if (hashMap != null) {
            str = (String) hashMap.get("subView");
        } else {
            str = null;
        }
        if (hashMap != null) {
            str2 = (String) hashMap.get("id");
        }
        if (!TextUtils.isEmpty(str3) && str3 != null) {
            C2310a c2310a;
            switch (str3.hashCode()) {
                case -1665655619:
                    if (str3.equals("microApp")) {
                        jT(1);
                        c2310a = this.cEZ;
                        if (c2310a == null) {
                            esl.mF("mPresenter");
                        }
                        c2310a.jR(1);
                        dhd com_fossil_dhd = this.cEV;
                        if (com_fossil_dhd == null) {
                            esl.mF("mShortcutPresenter");
                        }
                        com_fossil_dhd.aE(str, str2);
                        return;
                    }
                    return;
                case 109757599:
                    if (str3.equals("stats")) {
                        jT(3);
                        c2310a = this.cEZ;
                        if (c2310a == null) {
                            esl.mF("mPresenter");
                        }
                        c2310a.jR(3);
                        return;
                    }
                    return;
                case 1272354024:
                    if (str3.equals("notifications")) {
                        jT(2);
                        c2310a = this.cEZ;
                        if (c2310a == null) {
                            esl.mF("mPresenter");
                        }
                        c2310a.jR(2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void agC() {
        switch (this.cFb) {
            case 0:
                agE();
                return;
            case 1:
                agD();
                return;
            case 2:
                agF();
                return;
            default:
                return;
        }
    }

    public void agD() {
        Fragment fragment = null;
        MFLogger.m12670d(cFl.getTAG(), "Inside .showNoActiveDeviceFlow");
        Fragment W = getChildFragmentManager().mo3086W(ddn.TAG);
        if (!(W instanceof ddn)) {
            W = null;
        }
        Object obj = (ddn) W;
        Fragment W2 = getChildFragmentManager().mo3086W(ddq.TAG);
        if (!(W2 instanceof ddq)) {
            W2 = null;
        }
        Object obj2 = (ddq) W2;
        Fragment W3 = getChildFragmentManager().mo3086W(ddp.TAG);
        if (W3 instanceof ddp) {
            fragment = W3;
        }
        Object obj3 = (ddp) fragment;
        Object W4 = getChildFragmentManager().mo3086W(dks.cYO.getTAG());
        Fragment W5 = getChildFragmentManager().mo3086W(dav.TAG);
        Fragment W6 = getChildFragmentManager().mo3086W(dhb.TAG);
        Fragment W7 = getChildFragmentManager().mo3086W(dby.TAG);
        if (W5 == null) {
            W5 = dav.akZ();
        }
        if (W6 == null) {
            W6 = dhb.aov();
        }
        if (W7 == null) {
            W7 = dby.alv();
        }
        if (W4 == null) {
            W4 = dks.cYO.ard();
        }
        if (obj == null) {
            obj = ddn.amN();
        }
        if (obj2 == null) {
            obj2 = ddq.amP();
        }
        if (obj3 == null) {
            obj3 = ddp.amO();
        }
        this.cFi.clear();
        ArrayList arrayList = this.cFi;
        if (obj == null) {
            esl.aGW();
        }
        arrayList.add(obj);
        ArrayList arrayList2 = this.cFi;
        if (obj2 == null) {
            esl.aGW();
        }
        arrayList2.add(obj2);
        arrayList2 = this.cFi;
        if (obj3 == null) {
            esl.aGW();
        }
        arrayList2.add(obj3);
        this.cFi.add(W4);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clh com_fossil_clh = (clh) com_fossil_dqo.get();
        if (com_fossil_clh != null) {
            com_fossil_clh.cuL.setAdapter(new dsc(getChildFragmentManager(), this.cFi));
            com_fossil_clh.cuL.setItemViewCacheSize(4);
            com_fossil_clh.cuL.a(new C2331s());
        }
        ciy aam = PortfolioApp.ZQ().aam();
        if (W5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.home.HomeFragment");
        }
        C2614b c2614b = (dav) W5;
        if (W6 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.shortcuts.ShortcutFragment");
        }
        C2764b c2764b = (dhb) W6;
        if (W7 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.notifications.NotificationsFragment");
        }
        C2639b c2639b = (dby) W7;
        if (W4 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.stats.StatsFragment");
        }
        aam.mo1793a(new cub(c2614b, c2764b, c2639b, (dks) W4, PortfolioApp.ZQ().aaa(), getActivity().getSupportLoaderManager(), Calendar.getInstance().getTime())).mo1784a(this);
    }

    public void agE() {
        Object amN;
        Object amQ;
        MFLogger.m12670d(cFl.getTAG(), "Inside .showExploreFlow");
        Fragment W = getChildFragmentManager().mo3086W(ddn.TAG);
        Object W2 = getChildFragmentManager().mo3086W(ddq.TAG);
        Object W3 = getChildFragmentManager().mo3086W(ddp.TAG);
        Fragment W4 = getChildFragmentManager().mo3086W(ddr.TAG);
        if (W == null) {
            amN = ddn.amN();
        } else {
            Fragment fragment = W;
        }
        if (W2 == null) {
            W2 = ddq.amP();
        }
        if (W3 == null) {
            W3 = ddp.amO();
        }
        if (W4 == null) {
            amQ = ddr.amQ();
        } else {
            W = W4;
        }
        this.cFi.clear();
        ArrayList arrayList = this.cFi;
        if (amN == null) {
            esl.aGW();
        }
        arrayList.add(amN);
        arrayList = this.cFi;
        if (W2 == null) {
            esl.aGW();
        }
        arrayList.add(W2);
        arrayList = this.cFi;
        if (W3 == null) {
            esl.aGW();
        }
        arrayList.add(W3);
        arrayList = this.cFi;
        if (amQ == null) {
            esl.aGW();
        }
        arrayList.add(amQ);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clh com_fossil_clh = (clh) com_fossil_dqo.get();
        if (com_fossil_clh != null) {
            com_fossil_clh.cuL.setAdapter(new dsc(getChildFragmentManager(), this.cFi));
            com_fossil_clh.cuL.setItemViewCacheSize(4);
            com_fossil_clh.cuL.a(new C2329q());
        }
    }

    public void agF() {
        MFLogger.m12670d(cFl.getTAG(), "Inside .showMainFlow");
        Object W = getChildFragmentManager().mo3086W(dav.TAG);
        Object W2 = getChildFragmentManager().mo3086W(dhb.TAG);
        Object W3 = getChildFragmentManager().mo3086W(dby.TAG);
        Object W4 = getChildFragmentManager().mo3086W(dks.cYO.getTAG());
        if (W == null) {
            W = dav.akZ();
        }
        if (W2 == null) {
            W2 = dhb.aov();
        }
        if (W3 == null) {
            W3 = dby.alv();
        }
        if (W4 == null) {
            W4 = dks.cYO.ard();
        }
        this.cFi.add(W);
        this.cFi.add(W2);
        this.cFi.add(W3);
        this.cFi.add(W4);
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clh com_fossil_clh = (clh) com_fossil_dqo.get();
        if (com_fossil_clh != null) {
            com_fossil_clh.cuL.setAdapter(new dsc(getChildFragmentManager(), this.cFi));
            com_fossil_clh.cuL.setItemViewCacheSize(4);
            com_fossil_clh.cuL.a(new C2330r());
        }
        ciy aam = PortfolioApp.ZQ().aam();
        if (W == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.home.HomeFragment");
        }
        C2614b c2614b = (dav) W;
        if (W2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.shortcuts.ShortcutFragment");
        }
        C2764b c2764b = (dhb) W2;
        if (W3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.notifications.NotificationsFragment");
        }
        C2639b c2639b = (dby) W3;
        if (W4 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.stats.StatsFragment");
        }
        aam.mo1793a(new cub(c2614b, c2764b, c2639b, (dks) W4, PortfolioApp.ZQ().aaa(), getActivity().getSupportLoaderManager(), Calendar.getInstance().getTime())).mo1784a(this);
    }

    public void onDetach() {
        if (this.cFf != null && this.cFf.size() > 0) {
            Iterator it = this.cFf.iterator();
            while (it.hasNext()) {
                ((FossilPopupWindow) it.next()).dismiss();
            }
        }
        super.onDetach();
    }

    public void hJ(String str) {
        if (!TextUtils.isEmpty(str) && str != null) {
            switch (str.hashCode()) {
                case 1454808128:
                    if (str.equals("DEVICE_CONNECTED")) {
                        MFLogger.m12670d(cFl.getTAG(), "Inside .onDismiss reset temp fw version");
                        cnr com_fossil_cnr = this.cFh;
                        if (com_fossil_cnr == null) {
                            esl.mF("mSharePrefManager");
                        }
                        com_fossil_cnr.gN(PortfolioApp.ZQ().aaa());
                        return;
                    }
                    return;
                case 1925385819:
                    if (str.equals("DEVICE_CONNECT_FAILED")) {
                        MainActivity.bF(getActivity());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void mo1746a(String str, int i, Intent intent) {
        esl.m11128j(str, "tag");
        super.mo1746a(str, i, intent);
        MFLogger.m12670d(cFl.getTAG(), "Inside .onDialogFragmentResult with TAG=" + str);
        switch (str.hashCode()) {
            case -2028477080:
                if (str.equals("REQUEST_NOTIFICATION_ACCESS")) {
                    switch (i) {
                        case R.id.ftv_go_to_setting:
                            startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
                            return;
                        default:
                            return;
                    }
                }
                break;
            case -1391436191:
                if (str.equals("SYNC_FAILED")) {
                    if (i == R.id.fb_help && isActive()) {
                        dqw.bS(getContext());
                    }
                    if (i == R.id.fb_tryagain) {
                        MFLogger.m12670d(cFl.getTAG(), "onDialogFragmentResult, try again, call pull-sync");
                        PortfolioApp.ZQ().m12698e(false, 12);
                        return;
                    }
                    return;
                }
                break;
            case 481776726:
                if (str.equals("UPDATE_FW_FAIL")) {
                    switch (i) {
                        case R.id.fb_help:
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(URLHelper.a(StaticPage.SUPPORT, null))));
                            return;
                        case R.id.ftv_desc_2:
                            if (isActive()) {
                                dqw.m9447w(getChildFragmentManager());
                                return;
                            }
                            return;
                        case R.id.fb_tryagain:
                            C2310a c2310a = this.cEZ;
                            if (c2310a == null) {
                                esl.mF("mPresenter");
                            }
                            c2310a.agk();
                            return;
                        default:
                            return;
                    }
                }
                break;
            case 1925385819:
                if (str.equals("DEVICE_CONNECT_FAILED")) {
                    switch (i) {
                        case R.id.fb_help:
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(URLHelper.a(StaticPage.SUPPORT, null))));
                            return;
                        case R.id.ftv_desc_2:
                            if (isActive()) {
                                dqw.m9447w(getChildFragmentManager());
                                return;
                            }
                            return;
                        case R.id.fb_tryagain:
                            MainActivity.bF(getActivity());
                            return;
                        default:
                            return;
                    }
                }
                break;
        }
        ew activity = getActivity();
        if (activity == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.BaseActivity");
        }
        ((ctj) activity).mo1746a(str, i, intent);
    }

    public void agr() {
        if (isActive()) {
            dqw.m9443s(getChildFragmentManager());
        }
    }

    public void age() {
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
        }
    }

    public void agf() {
    }

    public void agg() {
    }

    public void agh() {
        C2310a c2310a = this.cEZ;
        if (c2310a == null) {
            esl.mF("mPresenter");
        }
        c2310a.agj();
    }

    public void agi() {
    }

    public void mo2031a(BCNotifications bCNotifications) {
        MFLogger.m12670d(cFl.getTAG(), " showBCNotificationView notification:" + String.valueOf(bCNotifications));
        cpj ace = cnq.acd().ace();
        if ((ace != null ? ace.getCurrentUser() : null) != null && bCNotifications != null) {
            afT();
            this.cFg.add(bCNotifications);
            jT(3);
            new Handler().postDelayed(new C2323l(this, bCNotifications), 500);
        }
    }

    public void mo2032a(BCNotifications bCNotifications, BCChallenge bCChallenge, BCOpponent bCOpponent) {
        esl.m11128j(bCNotifications, "notification");
        esl.m11128j(bCChallenge, "challenge");
        MFLogger.m12670d(cFl.getTAG(), "showChallengeDetails notification:" + bCNotifications.toString() + " \nchallenge:" + bCChallenge.toString());
        afT();
        jT(3);
        new Handler().postDelayed(new C2327o(this, bCNotifications, bCChallenge, bCOpponent), 500);
    }

    private final void hK(String str) {
        if (!TextUtils.isEmpty(str)) {
            Iterator it = this.cFf.iterator();
            esl.m11127i(it, "mPopupList.iterator()");
            while (it.hasNext()) {
                FossilPopupWindow fossilPopupWindow = (FossilPopupWindow) it.next();
                BCNotifications bCNotifications = (BCNotifications) fossilPopupWindow.getTag();
                if (bCNotifications != null && esl.m11125C(bCNotifications.getId(), str)) {
                    fossilPopupWindow.dismiss();
                    it.remove();
                }
            }
        }
    }

    private final boolean hL(String str) {
        for (BCNotifications bCNotifications : this.cFg) {
            Object obj;
            if (esl.m11125C(bCNotifications.getId(), str) || esl.m11125C(bCNotifications.getChallengeId(), str)) {
                obj = 1;
                continue;
            } else {
                obj = null;
                continue;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public void agx() {
        if (isActive()) {
            dqw.m9447w(getChildFragmentManager());
        }
    }

    public void agq() {
        if (isActive()) {
            dqw.m9446v(getChildFragmentManager());
        }
    }

    public void agy() {
        MFLogger.m12670d(cFl.getTAG(), "showLowBattery");
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clh com_fossil_clh = (clh) com_fossil_dqo.get();
        if (com_fossil_clh != null) {
            AppCompatImageView appCompatImageView = com_fossil_clh.cut;
            if (appCompatImageView != null) {
                appCompatImageView.setVisibility(0);
            }
        }
    }

    public void agz() {
        MFLogger.m12670d(cFl.getTAG(), "hideLowBattery");
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        clh com_fossil_clh = (clh) com_fossil_dqo.get();
        if (com_fossil_clh != null) {
            AppCompatImageView appCompatImageView = com_fossil_clh.cut;
            if (appCompatImageView != null) {
                appCompatImageView.setVisibility(8);
            }
        }
    }

    public void restart() {
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            MainActivity.bF(getActivity());
        }
    }

    private final boolean agG() {
        return TextUtils.isEmpty((CharSequence) PortfolioApp.ZQ().aaa()) && PortfolioApp.ZQ().aad() != null;
    }

    public void agA() {
        if (isActive()) {
            dqw.m9430f(getChildFragmentManager());
        }
    }
}
