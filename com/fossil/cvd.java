package com.fossil;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.fossil.cvc.C2364a;
import com.fossil.cvc.C2365b;
import com.fossil.os.a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge.TYPE;
import com.portfolio.platform.data.model.buddychallenge.BCInvitation;
import com.portfolio.platform.data.model.buddychallenge.BCOpponent;
import com.portfolio.platform.data.model.buddychallenge.BCPlayer;
import com.portfolio.platform.ui.buddychallenge.activity.BCFindOpponentActivity;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.FossilCircleImageView;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.TypeCastException;

public final class cvd extends drl implements C2365b {
    private static final String TAG = cvd.class.getSimpleName();
    private static final String cGE = cGE;
    private static final String cGS = cGS;
    private static final String cGT = cGT;
    private static final String cGU = cGU;
    private static final String cGV = cGV;
    public static final C2366a cGW = new C2366a();
    private C2160d cEN = new ckn(this);
    private dqo<ckz> cEY;
    private C2364a cGN;
    private BCChallenge cGO;
    private BCOpponent cGP;
    private BCInvitation cGQ;
    private C2367b cGR;

    public static final class C2366a {
        private C2366a() {
        }

        public final String getTAG() {
            return cvd.TAG;
        }

        public final String ahB() {
            return cvd.cGE;
        }

        public final String ahW() {
            return cvd.cGS;
        }

        public final String ahX() {
            return cvd.cGT;
        }

        public final String ahY() {
            return cvd.cGU;
        }

        public final String ahZ() {
            return cvd.cGV;
        }

        public final cvd m7624a(int i, boolean z, BCOpponent bCOpponent, BCChallenge bCChallenge, BCInvitation bCInvitation) {
            cvd com_fossil_cvd = new cvd();
            Bundle bundle = new Bundle();
            bundle.putInt(ahB(), i);
            bundle.putBoolean(ahW(), z);
            if (bCChallenge != null) {
                bundle.putParcelable(ahY(), bCChallenge);
            }
            if (bCOpponent != null) {
                bundle.putParcelable(ahX(), bCOpponent);
            }
            if (bCInvitation != null) {
                bundle.putParcelable(ahZ(), bCInvitation);
            }
            com_fossil_cvd.setArguments(bundle);
            return com_fossil_cvd;
        }
    }

    public interface C2367b {
        void mo2103v(int i, String str);
    }

    static final class C2368c implements OnClickListener {
        final /* synthetic */ cvd cGX;

        C2368c(cvd com_fossil_cvd) {
            this.cGX = com_fossil_cvd;
        }

        public final void onClick(View view) {
            Object obj = null;
            if (this.cGX.cGR != null) {
                C2367b a = this.cGX.cGR;
                if (a != null) {
                    BCChallenge b = this.cGX.cGO;
                    a.mo2103v(0, b != null ? b.getChallengeId() : null);
                }
            }
            switch (this.cGX.auT()) {
                case 3:
                case 4:
                case 5:
                    cmj bs = cmj.bs(this.cGX.getContext());
                    String str = "stats_bc_ignore";
                    String str2 = "Challenge";
                    BCInvitation c = this.cGX.cGQ;
                    if (c != null) {
                        obj = Integer.valueOf(c.getChallengeType());
                    }
                    bs.m7086l(str, str2, String.valueOf(obj));
                    break;
                default:
                    cmj.bs(this.cGX.getContext()).logEvent("stats_bc_info_close");
                    break;
            }
            this.cGX.dismiss();
        }
    }

    static final class C2369d implements OnClickListener {
        final /* synthetic */ cvd cGX;

        C2369d(cvd com_fossil_cvd) {
            this.cGX = com_fossil_cvd;
        }

        public final void onClick(View view) {
            this.cGX.dismiss();
        }
    }

    static final class C2370e implements OnClickListener {
        final /* synthetic */ cvd cGX;

        C2370e(cvd com_fossil_cvd) {
            this.cGX = com_fossil_cvd;
        }

        public final void onClick(View view) {
            this.cGX.cm(false);
        }
    }

    static final class C2371f implements OnClickListener {
        final /* synthetic */ cvd cGX;

        C2371f(cvd com_fossil_cvd) {
            this.cGX = com_fossil_cvd;
        }

        public final void onClick(View view) {
            this.cGX.cm(true);
        }
    }

    static final class C2372g implements OnClickListener {
        final /* synthetic */ cvd cGX;

        C2372g(cvd com_fossil_cvd) {
            this.cGX = com_fossil_cvd;
        }

        public final void onClick(View view) {
            this.cGX.ahR();
        }
    }

    static final class C2373h implements OnClickListener {
        final /* synthetic */ cvd cGX;

        C2373h(cvd com_fossil_cvd) {
            this.cGX = com_fossil_cvd;
        }

        public final void onClick(View view) {
            this.cGX.ahP();
        }
    }

    static final class C2374i implements OnClickListener {
        final /* synthetic */ cvd cGX;

        C2374i(cvd com_fossil_cvd) {
            this.cGX = com_fossil_cvd;
        }

        public final void onClick(View view) {
            this.cGX.ahP();
        }
    }

    static final class C2375j implements OnClickListener {
        final /* synthetic */ cvd cGX;

        C2375j(cvd com_fossil_cvd) {
            this.cGX = com_fossil_cvd;
        }

        public final void onClick(View view) {
            this.cGX.ahP();
        }
    }

    static final class C2376k implements OnClickListener {
        final /* synthetic */ os cGJ;
        final /* synthetic */ cvd cGX;

        C2376k(cvd com_fossil_cvd, os osVar) {
            this.cGX = com_fossil_cvd;
            this.cGJ = osVar;
        }

        public final void onClick(View view) {
            cvd.m7638f(this.cGX).mo2096c(this.cGX.cGO);
            this.cGJ.dismiss();
        }
    }

    static final class C2377l implements OnClickListener {
        final /* synthetic */ os cGJ;

        C2377l(os osVar) {
            this.cGJ = osVar;
        }

        public final void onClick(View view) {
            this.cGJ.dismiss();
        }
    }

    public static final /* synthetic */ C2364a m7638f(cvd com_fossil_cvd) {
        C2364a c2364a = com_fossil_cvd.cGN;
        if (c2364a == null) {
            esl.mF("mPresenter");
        }
        return c2364a;
    }

    public /* synthetic */ void cK(Object obj) {
        m7639a((C2364a) obj);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, R.style.BottomSheetTheme);
        lC(getArguments().getInt(cGW.ahB()));
        this.cGP = (BCOpponent) getArguments().getParcelable(cGW.ahX());
        this.cGO = (BCChallenge) getArguments().getParcelable(cGW.ahY());
        this.cGQ = (BCInvitation) getArguments().getParcelable(cGW.ahZ());
        this.cGN = new cve(this);
    }

    public void m7639a(C2364a c2364a) {
        esl.m11128j(c2364a, "presenter");
        this.cGN = c2364a;
    }

    public boolean isActive() {
        return isAdded();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        dro com_fossil_dro = new dro(getContext(), getTheme());
        com_fossil_dro.lE(auU());
        ckz com_fossil_ckz = (ckz) C3311e.m10386a(LayoutInflater.from(getContext()), R.layout.fragment_bc_main, null, false, this.cEN);
        com_fossil_ckz.crK.setOnClickListener(new C2368c(this));
        com_fossil_ckz.crM.setOnClickListener(new C2369d(this));
        FlexibleButton flexibleButton = com_fossil_ckz.cry;
        if (flexibleButton != null) {
            flexibleButton.setOnClickListener(new C2370e(this));
        }
        flexibleButton = com_fossil_ckz.crw;
        if (flexibleButton != null) {
            flexibleButton.setOnClickListener(new C2371f(this));
        }
        flexibleButton = com_fossil_ckz.crx;
        if (flexibleButton != null) {
            flexibleButton.setOnClickListener(new C2372g(this));
        }
        this.cEY = new dqo(this, com_fossil_ckz);
        com_fossil_ckz.dz().setLayoutParams(new LayoutParams(-1, auU()));
        com_fossil_dro.setContentView(com_fossil_ckz.dz());
        return com_fossil_dro;
    }

    public void onResume() {
        super.onResume();
        C2364a c2364a = this.cGN;
        if (c2364a == null) {
            esl.mF("mPresenter");
        }
        c2364a.start();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void mo2093u(int i, String str) {
        if (this.cGR != null) {
            C2367b c2367b = this.cGR;
            if (c2367b != null) {
                c2367b.mo2103v(i, str);
            }
        }
        dismiss();
    }

    public void fo() {
        MFLogger.m12670d(cGW.getTAG(), "BCMainFragment challenge:" + String.valueOf(this.cGO) + "opponent:" + String.valueOf(this.cGP));
        int auT = auT();
        Object valueOf;
        dqo com_fossil_dqo;
        ckz com_fossil_ckz;
        FlexibleTextView flexibleTextView;
        if (auT == 3 || auT == 4 || auT == 5) {
            if (this.cGQ != null) {
                BCInvitation bCInvitation = this.cGQ;
                valueOf = bCInvitation != null ? Integer.valueOf(bCInvitation.getStatus()) : null;
                if (esl.m11125C(valueOf, Integer.valueOf(0))) {
                    com_fossil_dqo = this.cEY;
                    if (com_fossil_dqo == null) {
                        esl.mF("mBinding");
                    }
                    com_fossil_ckz = (ckz) com_fossil_dqo.get();
                    if (com_fossil_ckz != null) {
                        flexibleTextView = com_fossil_ckz.crC;
                        if (flexibleTextView != null) {
                            flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Status_Label_Waiting_on_response));
                        }
                    }
                } else if (esl.m11125C(valueOf, Integer.valueOf(1))) {
                    com_fossil_dqo = this.cEY;
                    if (com_fossil_dqo == null) {
                        esl.mF("mBinding");
                    }
                    com_fossil_ckz = (ckz) com_fossil_dqo.get();
                    if (com_fossil_ckz != null) {
                        flexibleTextView = com_fossil_ckz.crC;
                        if (flexibleTextView != null) {
                            flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Status_Label_Challenge_starts_at_1200am_tomorrow));
                        }
                    }
                }
            }
        } else if (auT == TYPE.TYPE_CHALLENGE_ONE.getValue() || auT == TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue() || auT == TYPE.TYPE_CHALLENGE_THREE.getValue() || auT == TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue() || auT == TYPE.TYPE_CHALLENGE_FIVE.getValue() || auT == TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue()) {
            if (this.cGO != null) {
                BCChallenge bCChallenge = this.cGO;
                valueOf = bCChallenge != null ? Integer.valueOf(bCChallenge.getStatus()) : null;
                if (esl.m11125C(valueOf, Integer.valueOf(1))) {
                    com_fossil_dqo = this.cEY;
                    if (com_fossil_dqo == null) {
                        esl.mF("mBinding");
                    }
                    com_fossil_ckz = (ckz) com_fossil_dqo.get();
                    if (com_fossil_ckz != null) {
                        flexibleTextView = com_fossil_ckz.crC;
                        if (flexibleTextView != null) {
                            flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Status_Label_Keep_Going));
                        }
                    }
                } else if (esl.m11125C(valueOf, Integer.valueOf(0))) {
                    com_fossil_dqo = this.cEY;
                    if (com_fossil_dqo == null) {
                        esl.mF("mBinding");
                    }
                    com_fossil_ckz = (ckz) com_fossil_dqo.get();
                    if (com_fossil_ckz != null) {
                        flexibleTextView = com_fossil_ckz.crC;
                        if (flexibleTextView != null) {
                            flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Status_Label_Challenge_starts_at_1200am_tomorrow));
                        }
                    }
                }
            }
        } else if (auT == 6) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crC;
                if (flexibleTextView != null) {
                    flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Win_Header_You_Win));
                }
            }
        } else if (auT == 7) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crC;
                if (flexibleTextView != null) {
                    flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Lose_Header_You_Lose));
                }
            }
        } else if (auT == 8) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crC;
                if (flexibleTextView != null) {
                    flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Draw_Text_Its_a_draw));
                }
            }
        } else if (auT == 9) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crC;
                if (flexibleTextView != null) {
                    flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Tie_Text_Its_a_tie));
                }
            }
        }
        auT = auT();
        if (auT == TYPE.TYPE_CHALLENGE_ONE.getValue() || auT == TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue()) {
            ahG();
        } else if (auT == TYPE.TYPE_CHALLENGE_THREE.getValue() || auT == TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue()) {
            ahH();
        } else if (auT == TYPE.TYPE_CHALLENGE_FIVE.getValue() || auT == TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue()) {
            ahI();
        } else if (auT == 3) {
            ahJ();
        } else if (auT == 4) {
            ahK();
        } else if (auT == 5) {
            ahL();
        } else if (auT == 7) {
            ahN();
        } else if (auT == 6) {
            ahM();
        } else {
            if (auT != 8) {
                if (auT == 9) {
                }
            }
            ahO();
        }
        if (this.cGQ != null) {
            C2364a c2364a = this.cGN;
            if (c2364a == null) {
                esl.mF("mPresenter");
            }
            if (c2364a == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.buddychallenge.BCMainPresenter");
            }
            cve com_fossil_cve = (cve) c2364a;
            BCInvitation bCInvitation2 = this.cGQ;
            if (bCInvitation2 == null) {
                esl.aGW();
            }
            com_fossil_cve.aC(bCInvitation2.getSender(), "");
        }
    }

    private final void m7632a(BCPlayer bCPlayer, FossilCircleImageView fossilCircleImageView) {
        if (TextUtils.isEmpty(bCPlayer.getProfilePicture())) {
            if (fossilCircleImageView != null) {
                fossilCircleImageView.m12734a(bCPlayer.getProfilePicture(), bCPlayer.getUserName(), tx.t(this));
            }
            if (fossilCircleImageView != null) {
                fossilCircleImageView.setBorderWidth(3);
            }
            if (fossilCircleImageView != null) {
                fossilCircleImageView.setBorderColor(gn.m10634e(getContext(), R.color.coolGrey));
            }
            if (fossilCircleImageView != null) {
                fossilCircleImageView.setBackgroundColor(gn.m10634e(getContext(), R.color.coolGrey));
            }
            if (fossilCircleImageView != null) {
                fossilCircleImageView.setBackground(gn.m10632c(getContext(), R.drawable.oval_solid_light_grey));
                return;
            }
            return;
        }
        if (fossilCircleImageView != null) {
            fossilCircleImageView.setBorderWidth(3);
        }
        if (fossilCircleImageView != null) {
            fossilCircleImageView.setBorderColor(gn.m10634e(getContext(), R.color.transparent));
        }
        if (fossilCircleImageView != null) {
            fossilCircleImageView.m12733a(bCPlayer.getProfilePicture(), tx.t(this));
        }
    }

    private final void m7631a(BCOpponent bCOpponent, FossilCircleImageView fossilCircleImageView) {
        String str = null;
        BCOpponent bCOpponent2;
        if (TextUtils.isEmpty(bCOpponent != null ? bCOpponent.getProfilePicture() : null)) {
            if (fossilCircleImageView != null) {
                String profilePicture;
                bCOpponent2 = this.cGP;
                if (bCOpponent2 != null) {
                    profilePicture = bCOpponent2.getProfilePicture();
                } else {
                    profilePicture = null;
                }
                bCOpponent2 = this.cGP;
                if (bCOpponent2 != null) {
                    str = bCOpponent2.getUserName();
                }
                fossilCircleImageView.m12734a(profilePicture, str, tx.t(this));
            }
            if (fossilCircleImageView != null) {
                fossilCircleImageView.setBorderWidth(3);
            }
            if (fossilCircleImageView != null) {
                fossilCircleImageView.setBorderColor(gn.m10634e(getContext(), R.color.coolGrey));
            }
            if (fossilCircleImageView != null) {
                fossilCircleImageView.setBackground(gn.m10632c(getContext(), R.drawable.oval_solid_light_grey));
                return;
            }
            return;
        }
        if (fossilCircleImageView != null) {
            fossilCircleImageView.setBorderWidth(3);
        }
        if (fossilCircleImageView != null) {
            fossilCircleImageView.setBorderColor(gn.m10634e(getContext(), R.color.transparent));
        }
        if (fossilCircleImageView != null) {
            bCOpponent2 = this.cGP;
            if (bCOpponent2 != null) {
                str = bCOpponent2.getProfilePicture();
            }
            fossilCircleImageView.m12733a(str, tx.t(this));
        }
    }

    public void ahG() {
        View dz;
        clu com_fossil_clu;
        FossilCircleImageView fossilCircleImageView;
        ImageView imageView;
        BCChallenge bCChallenge;
        String challengeId;
        FlexibleTextView flexibleTextView;
        esm com_fossil_esm;
        Object[] objArr;
        Object obj = null;
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckz com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            cls com_fossil_cls = com_fossil_ckz.crE;
            if (com_fossil_cls != null) {
                dz = com_fossil_cls.dz();
                if (dz != null) {
                    dz.setVisibility(8);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            clt com_fossil_clt = com_fossil_ckz.crF;
            if (com_fossil_clt != null) {
                dz = com_fossil_clt.dz();
                if (dz != null) {
                    dz.setVisibility(8);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            com_fossil_clu = com_fossil_ckz.crG;
            if (com_fossil_clu != null) {
                dz = com_fossil_clu.dz();
                if (dz != null) {
                    dz.setVisibility(0);
                }
            }
        }
        BCPlayer adI = cnq.acd().acw().adI();
        if (adI != null) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clu = com_fossil_ckz.crG;
                if (com_fossil_clu != null) {
                    fossilCircleImageView = com_fossil_clu.csJ;
                    m7632a(adI, fossilCircleImageView);
                }
            }
            fossilCircleImageView = null;
            m7632a(adI, fossilCircleImageView);
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            com_fossil_clu = com_fossil_ckz.crG;
            if (com_fossil_clu != null) {
                imageView = com_fossil_clu.cwm;
                if (imageView != null) {
                    imageView.setVisibility(4);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            com_fossil_clu = com_fossil_ckz.crG;
            if (com_fossil_clu != null) {
                imageView = com_fossil_clu.cwl;
                if (imageView != null) {
                    imageView.setVisibility(4);
                }
            }
        }
        String str = "";
        if (this.cGO != null) {
            Object userId;
            if (adI != null) {
                userId = adI.getUserId();
            } else {
                userId = null;
            }
            BCChallenge bCChallenge2 = this.cGO;
            if (esl.m11125C(userId, bCChallenge2 != null ? bCChallenge2.getReceiverId() : null)) {
                bCChallenge = this.cGO;
                if (bCChallenge != null) {
                    str = bCChallenge.getSenderId();
                } else {
                    str = null;
                }
                if (str == null) {
                    esl.aGW();
                }
            } else {
                bCChallenge = this.cGO;
                str = bCChallenge != null ? bCChallenge.getReceiverId() : null;
                if (str == null) {
                    esl.aGW();
                }
            }
            m7637e(this.cGO);
            C2364a c2364a = this.cGN;
            if (c2364a == null) {
                esl.mF("mPresenter");
            }
            bCChallenge2 = this.cGO;
            if (bCChallenge2 != null) {
                challengeId = bCChallenge2.getChallengeId();
            } else {
                challengeId = null;
            }
            c2364a.hO(challengeId);
        }
        challengeId = str;
        if (this.cGP != null) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clu = com_fossil_ckz.crG;
                if (com_fossil_clu != null) {
                    FlexibleTextView flexibleTextView2 = com_fossil_clu.cwp;
                    if (flexibleTextView2 != null) {
                        BCOpponent bCOpponent = this.cGP;
                        if (bCOpponent != null) {
                            str = bCOpponent.getUserName();
                        } else {
                            str = null;
                        }
                        flexibleTextView2.setText(str);
                    }
                }
            }
            BCOpponent bCOpponent2 = this.cGP;
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clu = com_fossil_ckz.crG;
                if (com_fossil_clu != null) {
                    fossilCircleImageView = com_fossil_clu.cwn;
                    m7631a(bCOpponent2, fossilCircleImageView);
                }
            }
            fossilCircleImageView = null;
            m7631a(bCOpponent2, fossilCircleImageView);
        } else {
            C2364a c2364a2 = this.cGN;
            if (c2364a2 == null) {
                esl.mF("mPresenter");
            }
            if (c2364a2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.buddychallenge.BCMainPresenter");
            }
            cve com_fossil_cve = (cve) c2364a2;
            BCChallenge bCChallenge3 = this.cGO;
            com_fossil_cve.aC(challengeId, bCChallenge3 != null ? bCChallenge3.getChallengeId() : null);
        }
        bCChallenge = this.cGO;
        if (bCChallenge != null) {
            obj = Integer.valueOf(bCChallenge.getType());
        }
        if (esl.m11125C(obj, Integer.valueOf(TYPE.TYPE_CHALLENGE_ONE.getValue()))) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crr;
                if (flexibleTextView != null) {
                    com_fossil_esm = esm.dSO;
                    str = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_First_to__Steps);
                    esl.m11127i(str, "LanguageHelper.getString…_BC_Text_First_to__Steps)");
                    objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
                    str = String.format(str, Arrays.copyOf(objArr, objArr.length));
                    esl.m11127i(str, "java.lang.String.format(format, *args)");
                    flexibleTextView.setText(str);
                }
            }
        } else if (esl.m11125C(obj, Integer.valueOf(TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue()))) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crr;
                if (flexibleTextView != null) {
                    com_fossil_esm = esm.dSO;
                    str = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_First_to__Steps) + " debug";
                    objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
                    str = String.format(str, Arrays.copyOf(objArr, objArr.length));
                    esl.m11127i(str, "java.lang.String.format(format, *args)");
                    flexibleTextView.setText(str);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crp;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_Text_You_have_one_day_to));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crk;
            if (flexibleTextView != null) {
                com_fossil_esm = esm.dSO;
                str = arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_First_To);
                esl.m11127i(str, "LanguageHelper.getString…e_First_To_List_First_To)");
                objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
                str = String.format(str, Arrays.copyOf(objArr, objArr.length));
                esl.m11127i(str, "java.lang.String.format(format, *args)");
                flexibleTextView.setText(str);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crl;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_Start_Time_1200_AM_the));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crm;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_End_Time_1159_PM_the));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crn;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_Results_will_be_posted_at));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            LinearLayout linearLayout = com_fossil_ckz.cru;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
        if (!ahQ()) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                FlexibleButton flexibleButton = com_fossil_ckz.crx;
                if (flexibleButton != null) {
                    flexibleButton.setVisibility(8);
                }
            }
        }
    }

    public void ahH() {
        clt com_fossil_clt;
        View dz;
        FossilCircleImageView fossilCircleImageView;
        Object userId;
        BCChallenge bCChallenge;
        BCChallenge bCChallenge2;
        String challengeId;
        FlexibleTextView flexibleTextView;
        C2364a c2364a;
        String str = null;
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckz com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            com_fossil_clt = com_fossil_ckz.crF;
            if (com_fossil_clt != null) {
                dz = com_fossil_clt.dz();
                if (dz != null) {
                    dz.setVisibility(0);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            cls com_fossil_cls = com_fossil_ckz.crE;
            if (com_fossil_cls != null) {
                dz = com_fossil_cls.dz();
                if (dz != null) {
                    dz.setVisibility(8);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            clu com_fossil_clu = com_fossil_ckz.crG;
            if (com_fossil_clu != null) {
                dz = com_fossil_clu.dz();
                if (dz != null) {
                    dz.setVisibility(8);
                }
            }
        }
        BCPlayer adI = cnq.acd().acw().adI();
        if (adI != null) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clt = com_fossil_ckz.crF;
                if (com_fossil_clt != null) {
                    fossilCircleImageView = com_fossil_clt.cwg;
                    m7632a(adI, fossilCircleImageView);
                }
            }
            fossilCircleImageView = null;
            m7632a(adI, fossilCircleImageView);
        }
        String str2 = "";
        if (this.cGO != null) {
            if (adI != null) {
                userId = adI.getUserId();
            } else {
                userId = null;
            }
            bCChallenge = this.cGO;
            if (esl.m11125C(userId, bCChallenge != null ? bCChallenge.getReceiverId() : null)) {
                bCChallenge2 = this.cGO;
                if (bCChallenge2 != null) {
                    str2 = bCChallenge2.getSenderId();
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    esl.aGW();
                }
            } else {
                bCChallenge2 = this.cGO;
                str2 = bCChallenge2 != null ? bCChallenge2.getReceiverId() : null;
                if (str2 == null) {
                    esl.aGW();
                }
            }
            m7637e(this.cGO);
            C2364a c2364a2 = this.cGN;
            if (c2364a2 == null) {
                esl.mF("mPresenter");
            }
            bCChallenge = this.cGO;
            if (bCChallenge != null) {
                challengeId = bCChallenge.getChallengeId();
            } else {
                challengeId = null;
            }
            c2364a2.hO(challengeId);
        }
        challengeId = str2;
        if (this.cGP != null) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clt = com_fossil_ckz.crF;
                if (com_fossil_clt != null) {
                    flexibleTextView = com_fossil_clt.cwb;
                    if (flexibleTextView != null) {
                        BCOpponent bCOpponent = this.cGP;
                        if (bCOpponent != null) {
                            str2 = bCOpponent.getUserName();
                        } else {
                            str2 = null;
                        }
                        flexibleTextView.setText(str2);
                    }
                }
            }
            BCOpponent bCOpponent2 = this.cGP;
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clt = com_fossil_ckz.crF;
                if (com_fossil_clt != null) {
                    fossilCircleImageView = com_fossil_clt.cwc;
                    m7631a(bCOpponent2, fossilCircleImageView);
                }
            }
            fossilCircleImageView = null;
            m7631a(bCOpponent2, fossilCircleImageView);
        } else {
            c2364a = this.cGN;
            if (c2364a == null) {
                esl.mF("mPresenter");
            }
            if (c2364a == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.buddychallenge.BCMainPresenter");
            }
            cve com_fossil_cve = (cve) c2364a;
            BCChallenge bCChallenge3 = this.cGO;
            com_fossil_cve.aC(challengeId, bCChallenge3 != null ? bCChallenge3.getChallengeId() : null);
        }
        bCChallenge2 = this.cGO;
        if (bCChallenge2 != null) {
            userId = Integer.valueOf(bCChallenge2.getType());
        } else {
            userId = null;
        }
        esm com_fossil_esm;
        Object[] objArr;
        if (esl.m11125C(userId, Integer.valueOf(TYPE.TYPE_CHALLENGE_THREE.getValue()))) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crr;
                if (flexibleTextView != null) {
                    com_fossil_esm = esm.dSO;
                    str2 = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of);
                    esl.m11127i(str2, "LanguageHelper.getString…Activity_BC_Text_Best_of)");
                    objArr = new Object[]{Integer.valueOf(3)};
                    str2 = String.format(str2, Arrays.copyOf(objArr, objArr.length));
                    esl.m11127i(str2, "java.lang.String.format(format, *args)");
                    flexibleTextView.setText(str2);
                }
            }
        } else if (esl.m11125C(userId, Integer.valueOf(TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue()))) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crr;
                if (flexibleTextView != null) {
                    com_fossil_esm = esm.dSO;
                    str2 = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of) + " debug";
                    objArr = new Object[]{Integer.valueOf(3)};
                    str2 = String.format(str2, Arrays.copyOf(objArr, objArr.length));
                    esl.m11127i(str2, "java.lang.String.format(format, *args)");
                    flexibleTextView.setText(str2);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crp;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_Text_Show_your_opponent_you_can));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crk;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_First_To));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crl;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_Tie_Breaker_Opponent_who_takes));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crm;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_Start_Time_1200_AM_the));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crn;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_End_Time_1159_PM_the));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.cro;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_Results_will_be_posted_at));
            }
        }
        if (!ahQ()) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                FlexibleButton flexibleButton = com_fossil_ckz.crx;
                if (flexibleButton != null) {
                    flexibleButton.setVisibility(8);
                }
            }
        }
        c2364a = this.cGN;
        if (c2364a == null) {
            esl.mF("mPresenter");
        }
        bCChallenge = this.cGO;
        if (bCChallenge != null) {
            str = bCChallenge.getChallengeId();
        }
        c2364a.hO(str);
    }

    public void ahI() {
        clt com_fossil_clt;
        View dz;
        FossilCircleImageView fossilCircleImageView;
        Object userId;
        BCChallenge bCChallenge;
        BCChallenge bCChallenge2;
        String challengeId;
        FlexibleTextView flexibleTextView;
        C2364a c2364a;
        String str = null;
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckz com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            com_fossil_clt = com_fossil_ckz.crF;
            if (com_fossil_clt != null) {
                dz = com_fossil_clt.dz();
                if (dz != null) {
                    dz.setVisibility(0);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            cls com_fossil_cls = com_fossil_ckz.crE;
            if (com_fossil_cls != null) {
                dz = com_fossil_cls.dz();
                if (dz != null) {
                    dz.setVisibility(8);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            clu com_fossil_clu = com_fossil_ckz.crG;
            if (com_fossil_clu != null) {
                dz = com_fossil_clu.dz();
                if (dz != null) {
                    dz.setVisibility(8);
                }
            }
        }
        BCPlayer adI = cnq.acd().acw().adI();
        if (adI != null) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clt = com_fossil_ckz.crF;
                if (com_fossil_clt != null) {
                    fossilCircleImageView = com_fossil_clt.cwg;
                    m7632a(adI, fossilCircleImageView);
                }
            }
            fossilCircleImageView = null;
            m7632a(adI, fossilCircleImageView);
        }
        String str2 = "";
        if (this.cGO != null) {
            if (adI != null) {
                userId = adI.getUserId();
            } else {
                userId = null;
            }
            bCChallenge = this.cGO;
            if (esl.m11125C(userId, bCChallenge != null ? bCChallenge.getReceiverId() : null)) {
                bCChallenge2 = this.cGO;
                if (bCChallenge2 != null) {
                    str2 = bCChallenge2.getSenderId();
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    esl.aGW();
                }
            } else {
                bCChallenge2 = this.cGO;
                str2 = bCChallenge2 != null ? bCChallenge2.getReceiverId() : null;
                if (str2 == null) {
                    esl.aGW();
                }
            }
            m7637e(this.cGO);
            C2364a c2364a2 = this.cGN;
            if (c2364a2 == null) {
                esl.mF("mPresenter");
            }
            bCChallenge = this.cGO;
            if (bCChallenge != null) {
                challengeId = bCChallenge.getChallengeId();
            } else {
                challengeId = null;
            }
            c2364a2.hO(challengeId);
        }
        challengeId = str2;
        if (this.cGP != null) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clt = com_fossil_ckz.crF;
                if (com_fossil_clt != null) {
                    flexibleTextView = com_fossil_clt.cwb;
                    if (flexibleTextView != null) {
                        BCOpponent bCOpponent = this.cGP;
                        if (bCOpponent != null) {
                            str2 = bCOpponent.getUserName();
                        } else {
                            str2 = null;
                        }
                        flexibleTextView.setText(str2);
                    }
                }
            }
            BCOpponent bCOpponent2 = this.cGP;
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clt = com_fossil_ckz.crF;
                if (com_fossil_clt != null) {
                    fossilCircleImageView = com_fossil_clt.cwc;
                    m7631a(bCOpponent2, fossilCircleImageView);
                }
            }
            fossilCircleImageView = null;
            m7631a(bCOpponent2, fossilCircleImageView);
        } else {
            c2364a = this.cGN;
            if (c2364a == null) {
                esl.mF("mPresenter");
            }
            if (c2364a == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.buddychallenge.BCMainPresenter");
            }
            cve com_fossil_cve = (cve) c2364a;
            BCChallenge bCChallenge3 = this.cGO;
            com_fossil_cve.aC(challengeId, bCChallenge3 != null ? bCChallenge3.getChallengeId() : null);
        }
        bCChallenge2 = this.cGO;
        if (bCChallenge2 != null) {
            userId = Integer.valueOf(bCChallenge2.getType());
        } else {
            userId = null;
        }
        esm com_fossil_esm;
        Object[] objArr;
        if (esl.m11125C(userId, Integer.valueOf(TYPE.TYPE_CHALLENGE_FIVE.getValue()))) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crr;
                if (flexibleTextView != null) {
                    com_fossil_esm = esm.dSO;
                    str2 = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of);
                    esl.m11127i(str2, "LanguageHelper.getString…Activity_BC_Text_Best_of)");
                    objArr = new Object[]{Integer.valueOf(5)};
                    str2 = String.format(str2, Arrays.copyOf(objArr, objArr.length));
                    esl.m11127i(str2, "java.lang.String.format(format, *args)");
                    flexibleTextView.setText(str2);
                }
            }
        } else if (esl.m11125C(userId, Integer.valueOf(TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue()))) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crr;
                if (flexibleTextView != null) {
                    com_fossil_esm = esm.dSO;
                    str2 = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of) + " debug";
                    objArr = new Object[]{Integer.valueOf(5)};
                    str2 = String.format(str2, Arrays.copyOf(objArr, objArr.length));
                    esl.m11127i(str2, "java.lang.String.format(format, *args)");
                    flexibleTextView.setText(str2);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crp;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_Text_Step_to_and_show_your));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crk;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_First_To));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crl;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_Tie_Breaker_Opponent_who_takes));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crm;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_Start_Time_1200_AM_the));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crn;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_End_Time_1159_PM_the));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.cro;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_Results_will_be_posted_at));
            }
        }
        if (!ahQ()) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                FlexibleButton flexibleButton = com_fossil_ckz.crx;
                if (flexibleButton != null) {
                    flexibleButton.setVisibility(8);
                }
            }
        }
        c2364a = this.cGN;
        if (c2364a == null) {
            esl.mF("mPresenter");
        }
        bCChallenge = this.cGO;
        if (bCChallenge != null) {
            str = bCChallenge.getChallengeId();
        }
        c2364a.hO(str);
    }

    public void ahJ() {
        cls com_fossil_cls;
        View dz;
        BCInvitation bCInvitation;
        String sender;
        FlexibleTextView flexibleTextView;
        esm com_fossil_esm;
        Object[] objArr;
        Object obj = null;
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckz com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            com_fossil_cls = com_fossil_ckz.crE;
            if (com_fossil_cls != null) {
                dz = com_fossil_cls.dz();
                if (dz != null) {
                    dz.setVisibility(0);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            clt com_fossil_clt = com_fossil_ckz.crF;
            if (com_fossil_clt != null) {
                dz = com_fossil_clt.dz();
                if (dz != null) {
                    dz.setVisibility(8);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            clu com_fossil_clu = com_fossil_ckz.crG;
            if (com_fossil_clu != null) {
                dz = com_fossil_clu.dz();
                if (dz != null) {
                    dz.setVisibility(8);
                }
            }
        }
        BCPlayer adI = cnq.acd().acw().adI();
        if (adI != null) {
            FossilCircleImageView fossilCircleImageView;
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_cls = com_fossil_ckz.crE;
                if (com_fossil_cls != null) {
                    fossilCircleImageView = com_fossil_cls.cvY;
                    m7632a(adI, fossilCircleImageView);
                }
            }
            fossilCircleImageView = null;
            m7632a(adI, fossilCircleImageView);
        }
        if (this.cGQ != null) {
            Object userId;
            String str;
            if (adI != null) {
                userId = adI.getUserId();
            } else {
                userId = null;
            }
            BCInvitation bCInvitation2 = this.cGQ;
            if (esl.m11125C(userId, bCInvitation2 != null ? bCInvitation2.getReceiver() : null)) {
                bCInvitation = this.cGQ;
                if (bCInvitation == null) {
                    esl.aGW();
                }
                sender = bCInvitation.getSender();
                esl.m11127i(sender, "mInvitation!!.sender");
                str = sender;
            } else {
                bCInvitation = this.cGQ;
                if (bCInvitation == null) {
                    esl.aGW();
                }
                sender = bCInvitation.getReceiver();
                esl.m11127i(sender, "mInvitation!!.receiver");
                str = sender;
            }
            C2364a c2364a = this.cGN;
            if (c2364a == null) {
                esl.mF("mPresenter");
            }
            if (c2364a == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.buddychallenge.BCMainPresenter");
            }
            cve com_fossil_cve = (cve) c2364a;
            BCInvitation bCInvitation3 = this.cGQ;
            com_fossil_cve.aC(str, bCInvitation3 != null ? bCInvitation3.getChallengeId() : null);
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            FlexibleButton flexibleButton = com_fossil_ckz.crx;
            if (flexibleButton != null) {
                flexibleButton.setVisibility(8);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            RelativeLayout relativeLayout = com_fossil_ckz.crJ;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        }
        bCInvitation = this.cGQ;
        if (bCInvitation != null) {
            obj = Integer.valueOf(bCInvitation.getChallengeType());
        }
        if (esl.m11125C(obj, Integer.valueOf(TYPE.TYPE_CHALLENGE_ONE.getValue()))) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crr;
                if (flexibleTextView != null) {
                    com_fossil_esm = esm.dSO;
                    sender = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_First_to__Steps);
                    esl.m11127i(sender, "LanguageHelper.getString…_BC_Text_First_to__Steps)");
                    objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
                    sender = String.format(sender, Arrays.copyOf(objArr, objArr.length));
                    esl.m11127i(sender, "java.lang.String.format(format, *args)");
                    flexibleTextView.setText(sender);
                }
            }
        } else if (esl.m11125C(obj, Integer.valueOf(TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue()))) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crr;
                if (flexibleTextView != null) {
                    com_fossil_esm = esm.dSO;
                    sender = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_First_to__Steps) + " debug";
                    objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
                    sender = String.format(sender, Arrays.copyOf(objArr, objArr.length));
                    esl.m11127i(sender, "java.lang.String.format(format, *args)");
                    flexibleTextView.setText(sender);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crp;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_Text_You_have_one_day_to));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crk;
            if (flexibleTextView != null) {
                com_fossil_esm = esm.dSO;
                sender = arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_First_To);
                esl.m11127i(sender, "LanguageHelper.getString…e_First_To_List_First_To)");
                objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
                sender = String.format(sender, Arrays.copyOf(objArr, objArr.length));
                esl.m11127i(sender, "java.lang.String.format(format, *args)");
                flexibleTextView.setText(sender);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crl;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_Start_Time_1200_AM_the));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crm;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_End_Time_1159_PM_the));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crn;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_First_To_List_Results_will_be_posted_at));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            LinearLayout linearLayout = com_fossil_ckz.cru;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }
    }

    public void ahK() {
        cls com_fossil_cls;
        View dz;
        BCInvitation bCInvitation;
        FlexibleTextView flexibleTextView;
        Object obj = null;
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckz com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            com_fossil_cls = com_fossil_ckz.crE;
            if (com_fossil_cls != null) {
                dz = com_fossil_cls.dz();
                if (dz != null) {
                    dz.setVisibility(0);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            clt com_fossil_clt = com_fossil_ckz.crF;
            if (com_fossil_clt != null) {
                dz = com_fossil_clt.dz();
                if (dz != null) {
                    dz.setVisibility(8);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            clu com_fossil_clu = com_fossil_ckz.crG;
            if (com_fossil_clu != null) {
                dz = com_fossil_clu.dz();
                if (dz != null) {
                    dz.setVisibility(8);
                }
            }
        }
        BCPlayer adI = cnq.acd().acw().adI();
        if (adI != null) {
            FossilCircleImageView fossilCircleImageView;
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_cls = com_fossil_ckz.crE;
                if (com_fossil_cls != null) {
                    fossilCircleImageView = com_fossil_cls.cvY;
                    m7632a(adI, fossilCircleImageView);
                }
            }
            fossilCircleImageView = null;
            m7632a(adI, fossilCircleImageView);
        }
        String str = "";
        if (this.cGQ != null) {
            Object userId;
            String str2;
            if (adI != null) {
                userId = adI.getUserId();
            } else {
                userId = null;
            }
            BCInvitation bCInvitation2 = this.cGQ;
            if (esl.m11125C(userId, bCInvitation2 != null ? bCInvitation2.getReceiver() : null)) {
                bCInvitation = this.cGQ;
                if (bCInvitation == null) {
                    esl.aGW();
                }
                str = bCInvitation.getSender();
                esl.m11127i(str, "mInvitation!!.sender");
                str2 = str;
            } else {
                bCInvitation = this.cGQ;
                if (bCInvitation == null) {
                    esl.aGW();
                }
                str = bCInvitation.getReceiver();
                esl.m11127i(str, "mInvitation!!.receiver");
                str2 = str;
            }
            C2364a c2364a = this.cGN;
            if (c2364a == null) {
                esl.mF("mPresenter");
            }
            if (c2364a == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.buddychallenge.BCMainPresenter");
            }
            cve com_fossil_cve = (cve) c2364a;
            BCInvitation bCInvitation3 = this.cGQ;
            com_fossil_cve.aC(str2, bCInvitation3 != null ? bCInvitation3.getChallengeId() : null);
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            FlexibleButton flexibleButton = com_fossil_ckz.crx;
            if (flexibleButton != null) {
                flexibleButton.setVisibility(8);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            RelativeLayout relativeLayout = com_fossil_ckz.crJ;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        }
        bCInvitation = this.cGQ;
        if (bCInvitation != null) {
            obj = Integer.valueOf(bCInvitation.getChallengeType());
        }
        esm com_fossil_esm;
        Object[] objArr;
        if (esl.m11125C(obj, Integer.valueOf(TYPE.TYPE_CHALLENGE_THREE.getValue()))) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crr;
                if (flexibleTextView != null) {
                    com_fossil_esm = esm.dSO;
                    str = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of);
                    esl.m11127i(str, "LanguageHelper.getString…Activity_BC_Text_Best_of)");
                    objArr = new Object[]{Integer.valueOf(3)};
                    str = String.format(str, Arrays.copyOf(objArr, objArr.length));
                    esl.m11127i(str, "java.lang.String.format(format, *args)");
                    flexibleTextView.setText(str);
                }
            }
        } else if (esl.m11125C(obj, Integer.valueOf(TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue()))) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crr;
                if (flexibleTextView != null) {
                    com_fossil_esm = esm.dSO;
                    str = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of) + " debug";
                    objArr = new Object[]{Integer.valueOf(3)};
                    str = String.format(str, Arrays.copyOf(objArr, objArr.length));
                    esl.m11127i(str, "java.lang.String.format(format, *args)");
                    flexibleTextView.setText(str);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crp;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_Text_Show_your_opponent_you_can));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crk;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_First_To));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crl;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_Tie_Breaker_Opponent_who_takes));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crm;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_Start_Time_1200_AM_the));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crn;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_End_Time_1159_PM_the));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.cro;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Three_List_Results_will_be_posted_at));
            }
        }
    }

    public void ahL() {
        cls com_fossil_cls;
        View dz;
        BCInvitation bCInvitation;
        FlexibleTextView flexibleTextView;
        Object obj = null;
        dqo com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        ckz com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            com_fossil_cls = com_fossil_ckz.crE;
            if (com_fossil_cls != null) {
                dz = com_fossil_cls.dz();
                if (dz != null) {
                    dz.setVisibility(0);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            clt com_fossil_clt = com_fossil_ckz.crF;
            if (com_fossil_clt != null) {
                dz = com_fossil_clt.dz();
                if (dz != null) {
                    dz.setVisibility(8);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            clu com_fossil_clu = com_fossil_ckz.crG;
            if (com_fossil_clu != null) {
                dz = com_fossil_clu.dz();
                if (dz != null) {
                    dz.setVisibility(8);
                }
            }
        }
        BCPlayer adI = cnq.acd().acw().adI();
        if (adI != null) {
            FossilCircleImageView fossilCircleImageView;
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_cls = com_fossil_ckz.crE;
                if (com_fossil_cls != null) {
                    fossilCircleImageView = com_fossil_cls.cvY;
                    m7632a(adI, fossilCircleImageView);
                }
            }
            fossilCircleImageView = null;
            m7632a(adI, fossilCircleImageView);
        }
        String str = "";
        if (this.cGQ != null) {
            Object userId;
            String str2;
            if (adI != null) {
                userId = adI.getUserId();
            } else {
                userId = null;
            }
            BCInvitation bCInvitation2 = this.cGQ;
            if (esl.m11125C(userId, bCInvitation2 != null ? bCInvitation2.getReceiver() : null)) {
                bCInvitation = this.cGQ;
                if (bCInvitation == null) {
                    esl.aGW();
                }
                str = bCInvitation.getSender();
                esl.m11127i(str, "mInvitation!!.sender");
                str2 = str;
            } else {
                bCInvitation = this.cGQ;
                if (bCInvitation == null) {
                    esl.aGW();
                }
                str = bCInvitation.getReceiver();
                esl.m11127i(str, "mInvitation!!.receiver");
                str2 = str;
            }
            C2364a c2364a = this.cGN;
            if (c2364a == null) {
                esl.mF("mPresenter");
            }
            if (c2364a == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.ui.buddychallenge.BCMainPresenter");
            }
            cve com_fossil_cve = (cve) c2364a;
            BCInvitation bCInvitation3 = this.cGQ;
            com_fossil_cve.aC(str2, bCInvitation3 != null ? bCInvitation3.getChallengeId() : null);
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            FlexibleButton flexibleButton = com_fossil_ckz.crx;
            if (flexibleButton != null) {
                flexibleButton.setVisibility(8);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            RelativeLayout relativeLayout = com_fossil_ckz.crJ;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        }
        bCInvitation = this.cGQ;
        if (bCInvitation != null) {
            obj = Integer.valueOf(bCInvitation.getChallengeType());
        }
        esm com_fossil_esm;
        Object[] objArr;
        if (esl.m11125C(obj, Integer.valueOf(TYPE.TYPE_CHALLENGE_FIVE.getValue()))) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crr;
                if (flexibleTextView != null) {
                    com_fossil_esm = esm.dSO;
                    str = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of);
                    esl.m11127i(str, "LanguageHelper.getString…Activity_BC_Text_Best_of)");
                    objArr = new Object[]{Integer.valueOf(5)};
                    str = String.format(str, Arrays.copyOf(objArr, objArr.length));
                    esl.m11127i(str, "java.lang.String.format(format, *args)");
                    flexibleTextView.setText(str);
                }
            }
        } else if (esl.m11125C(obj, Integer.valueOf(TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue()))) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleTextView = com_fossil_ckz.crr;
                if (flexibleTextView != null) {
                    com_fossil_esm = esm.dSO;
                    str = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of) + " debug";
                    objArr = new Object[]{Integer.valueOf(5)};
                    str = String.format(str, Arrays.copyOf(objArr, objArr.length));
                    esl.m11127i(str, "java.lang.String.format(format, *args)");
                    flexibleTextView.setText(str);
                }
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crp;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_Text_Step_to_and_show_your));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crk;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_First_To));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crl;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_Tie_Breaker_Opponent_who_takes));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crm;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_Start_Time_1200_AM_the));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.crn;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_End_Time_1159_PM_the));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_ckz = (ckz) com_fossil_dqo.get();
        if (com_fossil_ckz != null) {
            flexibleTextView = com_fossil_ckz.cro;
            if (flexibleTextView != null) {
                flexibleTextView.setText(arp.m4318u(getContext(), R.string.Stats_BC_Challenge_Best_Of_Five_List_Results_will_be_posted_at));
            }
        }
    }

    public void ahM() {
        if (this.cGO != null) {
            dqo com_fossil_dqo;
            ckz com_fossil_ckz;
            FlexibleButton flexibleButton;
            m7637e(this.cGO);
            cmj.bs(getContext()).m7086l("stats_bc_results", "Result", "Win");
            BCChallenge bCChallenge = this.cGO;
            Object valueOf = bCChallenge != null ? Integer.valueOf(bCChallenge.getType()) : null;
            if (esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_ONE.getValue())) || esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue()))) {
                clu com_fossil_clu;
                ImageView imageView;
                ahG();
                com_fossil_dqo = this.cEY;
                if (com_fossil_dqo == null) {
                    esl.mF("mBinding");
                }
                com_fossil_ckz = (ckz) com_fossil_dqo.get();
                if (com_fossil_ckz != null) {
                    com_fossil_clu = com_fossil_ckz.crG;
                    if (com_fossil_clu != null) {
                        imageView = com_fossil_clu.cwm;
                        if (imageView != null) {
                            imageView.setVisibility(0);
                        }
                    }
                }
                com_fossil_dqo = this.cEY;
                if (com_fossil_dqo == null) {
                    esl.mF("mBinding");
                }
                com_fossil_ckz = (ckz) com_fossil_dqo.get();
                if (com_fossil_ckz != null) {
                    com_fossil_clu = com_fossil_ckz.crG;
                    if (com_fossil_clu != null) {
                        imageView = com_fossil_clu.cwl;
                        if (imageView != null) {
                            imageView.setVisibility(4);
                        }
                    }
                }
            } else if (esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_THREE.getValue())) || esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue()))) {
                ahH();
            } else {
                if (!esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_FIVE.getValue()))) {
                    if (esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue()))) {
                    }
                }
                ahI();
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                FlexibleButton flexibleButton2 = com_fossil_ckz.crx;
                if (flexibleButton2 != null) {
                    flexibleButton2.setVisibility(0);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleButton = com_fossil_ckz.crx;
                if (flexibleButton != null) {
                    flexibleButton.setText(arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_BC_Win_CTA_REMATCH));
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleButton = com_fossil_ckz.crx;
                if (flexibleButton != null) {
                    flexibleButton.setOnClickListener(new C2375j(this));
                    return;
                }
                return;
            }
            return;
        }
        dismiss();
    }

    public void ahN() {
        if (this.cGO != null) {
            dqo com_fossil_dqo;
            ckz com_fossil_ckz;
            FlexibleButton flexibleButton;
            m7637e(this.cGO);
            cmj.bs(getContext()).m7086l("stats_bc_results", "Result", "Lose");
            BCChallenge bCChallenge = this.cGO;
            Object valueOf = bCChallenge != null ? Integer.valueOf(bCChallenge.getType()) : null;
            if (esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_ONE.getValue())) || esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue()))) {
                clu com_fossil_clu;
                ImageView imageView;
                ahG();
                com_fossil_dqo = this.cEY;
                if (com_fossil_dqo == null) {
                    esl.mF("mBinding");
                }
                com_fossil_ckz = (ckz) com_fossil_dqo.get();
                if (com_fossil_ckz != null) {
                    com_fossil_clu = com_fossil_ckz.crG;
                    if (com_fossil_clu != null) {
                        imageView = com_fossil_clu.cwm;
                        if (imageView != null) {
                            imageView.setVisibility(4);
                        }
                    }
                }
                com_fossil_dqo = this.cEY;
                if (com_fossil_dqo == null) {
                    esl.mF("mBinding");
                }
                com_fossil_ckz = (ckz) com_fossil_dqo.get();
                if (com_fossil_ckz != null) {
                    com_fossil_clu = com_fossil_ckz.crG;
                    if (com_fossil_clu != null) {
                        imageView = com_fossil_clu.cwl;
                        if (imageView != null) {
                            imageView.setVisibility(0);
                        }
                    }
                }
            } else if (esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_THREE.getValue())) || esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue()))) {
                ahH();
            } else {
                if (!esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_FIVE.getValue()))) {
                    if (esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue()))) {
                    }
                }
                ahI();
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                FlexibleButton flexibleButton2 = com_fossil_ckz.crx;
                if (flexibleButton2 != null) {
                    flexibleButton2.setVisibility(0);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleButton = com_fossil_ckz.crx;
                if (flexibleButton != null) {
                    flexibleButton.setText(arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_BC_Win_CTA_REMATCH));
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleButton = com_fossil_ckz.crx;
                if (flexibleButton != null) {
                    flexibleButton.setOnClickListener(new C2374i(this));
                    return;
                }
                return;
            }
            return;
        }
        dismiss();
    }

    public void ahO() {
        if (this.cGO != null) {
            dqo com_fossil_dqo;
            ckz com_fossil_ckz;
            FlexibleButton flexibleButton;
            m7637e(this.cGO);
            BCChallenge bCChallenge = this.cGO;
            Object valueOf = bCChallenge != null ? Integer.valueOf(bCChallenge.getType()) : null;
            if (esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_ONE.getValue())) || esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue()))) {
                clu com_fossil_clu;
                ImageView imageView;
                ahG();
                com_fossil_dqo = this.cEY;
                if (com_fossil_dqo == null) {
                    esl.mF("mBinding");
                }
                com_fossil_ckz = (ckz) com_fossil_dqo.get();
                if (com_fossil_ckz != null) {
                    com_fossil_clu = com_fossil_ckz.crG;
                    if (com_fossil_clu != null) {
                        imageView = com_fossil_clu.cwm;
                        if (imageView != null) {
                            imageView.setVisibility(4);
                        }
                    }
                }
                com_fossil_dqo = this.cEY;
                if (com_fossil_dqo == null) {
                    esl.mF("mBinding");
                }
                com_fossil_ckz = (ckz) com_fossil_dqo.get();
                if (com_fossil_ckz != null) {
                    com_fossil_clu = com_fossil_ckz.crG;
                    if (com_fossil_clu != null) {
                        imageView = com_fossil_clu.cwl;
                        if (imageView != null) {
                            imageView.setVisibility(4);
                        }
                    }
                }
            } else if (esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_THREE.getValue())) || esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue()))) {
                ahH();
            } else {
                if (!esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_FIVE.getValue()))) {
                    if (esl.m11125C(valueOf, Integer.valueOf(TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue()))) {
                    }
                }
                ahI();
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                FlexibleButton flexibleButton2 = com_fossil_ckz.crx;
                if (flexibleButton2 != null) {
                    flexibleButton2.setVisibility(0);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleButton = com_fossil_ckz.crx;
                if (flexibleButton != null) {
                    flexibleButton.setText(arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_BC_Win_CTA_REMATCH));
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                flexibleButton = com_fossil_ckz.crx;
                if (flexibleButton != null) {
                    flexibleButton.setOnClickListener(new C2373h(this));
                    return;
                }
                return;
            }
            return;
        }
        dismiss();
    }

    public void mo2084a(BCOpponent bCOpponent, String str) {
        if (this.cGO != null) {
            m7637e(this.cGO);
        }
        int auT = auT();
        dqo com_fossil_dqo;
        ckz com_fossil_ckz;
        FossilCircleImageView fossilCircleImageView;
        FlexibleTextView flexibleTextView;
        String userName;
        if (auT == TYPE.TYPE_CHALLENGE_ONE.getValue() || auT == TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue()) {
            clu com_fossil_clu;
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clu = com_fossil_ckz.crG;
                if (com_fossil_clu != null) {
                    fossilCircleImageView = com_fossil_clu.cwn;
                    m7631a(bCOpponent, fossilCircleImageView);
                    com_fossil_dqo = this.cEY;
                    if (com_fossil_dqo == null) {
                        esl.mF("mBinding");
                    }
                    com_fossil_ckz = (ckz) com_fossil_dqo.get();
                    if (com_fossil_ckz != null) {
                        com_fossil_clu = com_fossil_ckz.crG;
                        if (com_fossil_clu != null) {
                            flexibleTextView = com_fossil_clu.cwp;
                            if (flexibleTextView != null) {
                                if (bCOpponent == null) {
                                    userName = bCOpponent.getUserName();
                                } else {
                                    userName = null;
                                }
                                flexibleTextView.setText(userName);
                            }
                        }
                    }
                }
            }
            fossilCircleImageView = null;
            m7631a(bCOpponent, fossilCircleImageView);
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clu = com_fossil_ckz.crG;
                if (com_fossil_clu != null) {
                    flexibleTextView = com_fossil_clu.cwp;
                    if (flexibleTextView != null) {
                        if (bCOpponent == null) {
                            userName = null;
                        } else {
                            userName = bCOpponent.getUserName();
                        }
                        flexibleTextView.setText(userName);
                    }
                }
            }
        } else if (auT == 3 || auT == 4 || auT == 5) {
            cls com_fossil_cls;
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_cls = com_fossil_ckz.crE;
                if (com_fossil_cls != null) {
                    fossilCircleImageView = com_fossil_cls.cvX;
                    if (fossilCircleImageView != null) {
                        fossilCircleImageView.setImageResource(R.drawable.ic_unknown_opponent);
                    }
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_cls = com_fossil_ckz.crE;
                if (com_fossil_cls != null) {
                    flexibleTextView = com_fossil_cls.cvW;
                    if (flexibleTextView != null) {
                        if (bCOpponent != null) {
                            userName = bCOpponent.getUserName();
                        } else {
                            userName = null;
                        }
                        flexibleTextView.setText(userName);
                    }
                }
            }
        } else {
            clt com_fossil_clt;
            if (!(auT == TYPE.TYPE_CHALLENGE_THREE.getValue() || auT == TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue() || auT == TYPE.TYPE_CHALLENGE_FIVE.getValue())) {
                if (auT != TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue()) {
                    return;
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clt = com_fossil_ckz.crF;
                if (com_fossil_clt != null) {
                    fossilCircleImageView = com_fossil_clt.cwc;
                    m7631a(bCOpponent, fossilCircleImageView);
                    com_fossil_dqo = this.cEY;
                    if (com_fossil_dqo == null) {
                        esl.mF("mBinding");
                    }
                    com_fossil_ckz = (ckz) com_fossil_dqo.get();
                    if (com_fossil_ckz != null) {
                        com_fossil_clt = com_fossil_ckz.crF;
                        if (com_fossil_clt != null) {
                            flexibleTextView = com_fossil_clt.cwb;
                            if (flexibleTextView != null) {
                                if (bCOpponent == null) {
                                    userName = bCOpponent.getUserName();
                                } else {
                                    userName = null;
                                }
                                flexibleTextView.setText(userName);
                            }
                        }
                    }
                }
            }
            fossilCircleImageView = null;
            m7631a(bCOpponent, fossilCircleImageView);
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clt = com_fossil_ckz.crF;
                if (com_fossil_clt != null) {
                    flexibleTextView = com_fossil_clt.cwb;
                    if (flexibleTextView != null) {
                        if (bCOpponent == null) {
                            userName = null;
                        } else {
                            userName = bCOpponent.getUserName();
                        }
                        flexibleTextView.setText(userName);
                    }
                }
            }
        }
    }

    public void mo2085d(BCChallenge bCChallenge) {
        if (bCChallenge != null) {
            this.cGO = bCChallenge;
            if (auT() != TYPE.TYPE_CHALLENGE_FIVE.getValue() && auT() != TYPE.TYPE_CHALLENGE_THREE.getValue() && auT() != TYPE.TYPE_CHALLENGE_ONE.getValue() && auT() != TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue() && auT() != TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue() && auT() != TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue()) {
                return;
            }
            if (bCChallenge.getStatus() == 0 || bCChallenge.getStatus() == 2 || bCChallenge.getStatus() == 3) {
                dqo com_fossil_dqo = this.cEY;
                if (com_fossil_dqo == null) {
                    esl.mF("mBinding");
                }
                ckz com_fossil_ckz = (ckz) com_fossil_dqo.get();
                if (com_fossil_ckz != null) {
                    FlexibleButton flexibleButton = com_fossil_ckz.crx;
                    if (flexibleButton != null) {
                        flexibleButton.setVisibility(4);
                    }
                }
            } else if (bCChallenge.getStatus() == 1 && this.cGO != null) {
                m7637e(this.cGO);
            }
        }
    }

    private final void m7637e(BCChallenge bCChallenge) {
        Object obj = null;
        if (bCChallenge != null) {
            int w;
            int w2;
            int receiverScore;
            int i;
            BCPlayer adI = cnq.acd().acw().adI();
            if (bCChallenge.getStatus() != 0) {
                int senderScore;
                ArrayList receiverStepsDays;
                List senderStepsDays;
                if (esl.m11125C(adI != null ? adI.getUserId() : null, bCChallenge.getReceiverId())) {
                    receiverStepsDays = bCChallenge.getReceiverStepsDays();
                    if (receiverStepsDays == null) {
                        esl.aGW();
                    }
                    w = esb.m11118w(receiverStepsDays);
                    senderStepsDays = bCChallenge.getSenderStepsDays();
                    if (senderStepsDays == null) {
                        esl.aGW();
                    }
                    w2 = esb.m11118w(senderStepsDays);
                    receiverScore = bCChallenge.getReceiverScore();
                    senderScore = bCChallenge.getSenderScore();
                } else {
                    senderStepsDays = bCChallenge.getSenderStepsDays();
                    if (senderStepsDays == null) {
                        esl.aGW();
                    }
                    w = esb.m11118w(senderStepsDays);
                    receiverStepsDays = bCChallenge.getReceiverStepsDays();
                    if (receiverStepsDays == null) {
                        esl.aGW();
                    }
                    w2 = esb.m11118w(receiverStepsDays);
                    receiverScore = bCChallenge.getSenderScore();
                    senderScore = bCChallenge.getReceiverScore();
                }
                i = w;
                w = w2;
                w2 = receiverScore;
                receiverScore = senderScore;
            } else {
                receiverScore = 0;
                w2 = 0;
                w = 0;
                i = 0;
            }
            BCChallenge bCChallenge2 = this.cGO;
            if (bCChallenge2 != null) {
                obj = Integer.valueOf(bCChallenge2.getType());
            }
            dqo com_fossil_dqo;
            ckz com_fossil_ckz;
            FlexibleTextView flexibleTextView;
            esm com_fossil_esm;
            String u;
            Object[] objArr;
            if (esl.m11125C(obj, Integer.valueOf(TYPE.TYPE_CHALLENGE_ONE.getValue())) || esl.m11125C(obj, Integer.valueOf(TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue()))) {
                clu com_fossil_clu;
                ProgressBar progressBar;
                com_fossil_dqo = this.cEY;
                if (com_fossil_dqo == null) {
                    esl.mF("mBinding");
                }
                com_fossil_ckz = (ckz) com_fossil_dqo.get();
                if (com_fossil_ckz != null) {
                    com_fossil_clu = com_fossil_ckz.crG;
                    if (com_fossil_clu != null) {
                        progressBar = com_fossil_clu.cwu;
                        if (progressBar != null) {
                            progressBar.setProgress((i * 100) / bCChallenge.getGoal());
                        }
                    }
                }
                com_fossil_dqo = this.cEY;
                if (com_fossil_dqo == null) {
                    esl.mF("mBinding");
                }
                com_fossil_ckz = (ckz) com_fossil_dqo.get();
                if (com_fossil_ckz != null) {
                    com_fossil_clu = com_fossil_ckz.crG;
                    if (com_fossil_clu != null) {
                        progressBar = com_fossil_clu.cwq;
                        if (progressBar != null) {
                            progressBar.setProgress((w * 100) / bCChallenge.getGoal());
                        }
                    }
                }
                com_fossil_dqo = this.cEY;
                if (com_fossil_dqo == null) {
                    esl.mF("mBinding");
                }
                com_fossil_ckz = (ckz) com_fossil_dqo.get();
                if (com_fossil_ckz != null) {
                    com_fossil_clu = com_fossil_ckz.crG;
                    if (com_fossil_clu != null) {
                        flexibleTextView = com_fossil_clu.cwv;
                        if (flexibleTextView != null) {
                            com_fossil_esm = esm.dSO;
                            u = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_BC_Lose_Text_Steps);
                            esl.m11127i(u, "LanguageHelper.getString…Stats_BC_Lose_Text_Steps)");
                            objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(i))};
                            u = String.format(u, Arrays.copyOf(objArr, objArr.length));
                            esl.m11127i(u, "java.lang.String.format(format, *args)");
                            flexibleTextView.setText(u);
                        }
                    }
                }
                com_fossil_dqo = this.cEY;
                if (com_fossil_dqo == null) {
                    esl.mF("mBinding");
                }
                com_fossil_ckz = (ckz) com_fossil_dqo.get();
                if (com_fossil_ckz != null) {
                    com_fossil_clu = com_fossil_ckz.crG;
                    if (com_fossil_clu != null) {
                        flexibleTextView = com_fossil_clu.cwr;
                        if (flexibleTextView != null) {
                            com_fossil_esm = esm.dSO;
                            u = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_BC_Lose_Text_Steps);
                            esl.m11127i(u, "LanguageHelper.getString…Stats_BC_Lose_Text_Steps)");
                            objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(w))};
                            u = String.format(u, Arrays.copyOf(objArr, objArr.length));
                            esl.m11127i(u, "java.lang.String.format(format, *args)");
                            flexibleTextView.setText(u);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            clt com_fossil_clt;
            if (!(esl.m11125C(obj, Integer.valueOf(TYPE.TYPE_CHALLENGE_THREE.getValue())) || esl.m11125C(obj, Integer.valueOf(TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue())) || esl.m11125C(obj, Integer.valueOf(TYPE.TYPE_CHALLENGE_FIVE.getValue())))) {
                if (!esl.m11125C(obj, Integer.valueOf(TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue()))) {
                    return;
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clt = com_fossil_ckz.crF;
                if (com_fossil_clt != null) {
                    flexibleTextView = com_fossil_clt.cwj;
                    if (flexibleTextView != null) {
                        flexibleTextView.setText(String.valueOf(w2));
                    }
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clt = com_fossil_ckz.crF;
                if (com_fossil_clt != null) {
                    flexibleTextView = com_fossil_clt.cwe;
                    if (flexibleTextView != null) {
                        flexibleTextView.setText(String.valueOf(receiverScore));
                    }
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clt = com_fossil_ckz.crF;
                if (com_fossil_clt != null) {
                    flexibleTextView = com_fossil_clt.cwk;
                    if (flexibleTextView != null) {
                        com_fossil_esm = esm.dSO;
                        u = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_BC_Lose_Text_Steps);
                        esl.m11127i(u, "LanguageHelper.getString…Stats_BC_Lose_Text_Steps)");
                        objArr = new Object[]{Integer.valueOf(i)};
                        u = String.format(u, Arrays.copyOf(objArr, objArr.length));
                        esl.m11127i(u, "java.lang.String.format(format, *args)");
                        flexibleTextView.setText(u);
                    }
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_ckz = (ckz) com_fossil_dqo.get();
            if (com_fossil_ckz != null) {
                com_fossil_clt = com_fossil_ckz.crF;
                if (com_fossil_clt != null) {
                    flexibleTextView = com_fossil_clt.cwf;
                    if (flexibleTextView != null) {
                        com_fossil_esm = esm.dSO;
                        u = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_BC_Lose_Text_Steps);
                        esl.m11127i(u, "LanguageHelper.getString…Stats_BC_Lose_Text_Steps)");
                        objArr = new Object[]{Integer.valueOf(w)};
                        u = String.format(u, Arrays.copyOf(objArr, objArr.length));
                        esl.m11127i(u, "java.lang.String.format(format, *args)");
                        flexibleTextView.setText(u);
                    }
                }
            }
        }
    }

    public void jV(int i) {
        dqw.m9419a(i, getChildFragmentManager());
    }

    private final void ahP() {
        cmj.bs(getContext()).logEvent("stats_bc_rematch");
        Context context = getContext();
        BCChallenge bCChallenge = this.cGO;
        if (bCChallenge == null) {
            esl.aGW();
        }
        BCFindOpponentActivity.b(context, bCChallenge.getType(), true);
        dismiss();
    }

    private final boolean ahQ() {
        String str = null;
        if (this.cGO == null) {
            return true;
        }
        String startTime;
        long currentTimeMillis = System.currentTimeMillis();
        BCChallenge bCChallenge = this.cGO;
        if (bCChallenge != null) {
            startTime = bCChallenge.getStartTime();
        } else {
            startTime = null;
        }
        long gp = cnf.gp(startTime);
        bCChallenge = this.cGO;
        if (bCChallenge != null) {
            str = bCChallenge.getEndTime();
        }
        long gp2 = cnf.gp(str);
        if (currentTimeMillis < gp) {
            return false;
        }
        Object obj;
        if (gp > currentTimeMillis || currentTimeMillis > gp2) {
            obj = null;
        } else {
            obj = 1;
        }
        return obj != null;
    }

    private final void ahR() {
        MFLogger.m12670d(cGW.getTAG(), "showQuitChallengeConfirmation");
        a aVar = new a(getContext());
        View inflate = View.inflate(getContext(), R.layout.popup_bc_confirm_quit, null);
        aVar.bm(inflate);
        aVar.R(false);
        os ln = aVar.ln();
        inflate.findViewById(R.id.fbtn_ok).setOnClickListener(new C2376k(this, ln));
        inflate.findViewById(R.id.fbtn_cancel).setOnClickListener(new C2377l(ln));
        ln.show();
    }

    private final void cm(boolean z) {
        Object obj = null;
        cmj bs;
        String str;
        String str2;
        BCInvitation bCInvitation;
        if (z) {
            bs = cmj.bs(getContext());
            str = "stats_bc_accept";
            str2 = "Challenge";
            bCInvitation = this.cGQ;
            if (bCInvitation != null) {
                obj = Integer.valueOf(bCInvitation.getChallengeType());
            }
            bs.m7086l(str, str2, String.valueOf(obj));
        } else {
            bs = cmj.bs(getContext());
            str = "stats_bc_reject";
            str2 = "Challenge";
            bCInvitation = this.cGQ;
            if (bCInvitation != null) {
                obj = Integer.valueOf(bCInvitation.getChallengeType());
            }
            bs.m7086l(str, str2, String.valueOf(obj));
        }
        C2364a c2364a = this.cGN;
        if (c2364a == null) {
            esl.mF("mPresenter");
        }
        c2364a.mo2094a(this.cGQ, z);
    }

    public boolean lM() {
        if (this.cGR != null) {
            C2367b c2367b = this.cGR;
            if (c2367b != null) {
                BCChallenge bCChallenge = this.cGO;
                c2367b.mo2103v(0, bCChallenge != null ? bCChallenge.getChallengeId() : null);
            }
        }
        dismiss();
        return false;
    }

    public void show(fa faVar, String str) {
        esl.m11128j(faVar, "manager");
        esl.m11128j(str, "tag");
        MFLogger.m12670d(cGW.getTAG(), "show - tag: " + str);
        fg hW = faVar.hW();
        Fragment W = faVar.mo3086W(str);
        if (W != null) {
            hW.mo2967a(W);
        }
        hW.mo2968a((Fragment) this, str);
        hW.commitAllowingStateLoss();
    }

    public final void m7640a(C2367b c2367b) {
        esl.m11128j(c2367b, "listener");
        this.cGR = c2367b;
    }
}
