package com.fossil;

import android.content.Context;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge.TYPE;
import com.portfolio.platform.data.model.buddychallenge.BCOpponent;
import com.portfolio.platform.data.model.buddychallenge.BCPlayer;
import com.portfolio.platform.ui.view.MyChallengeView;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class cvn extends C1234a<C2400a> {
    private final int cHj = 123456789;
    private final int cHk = 987654321;
    private ArrayList<BCChallenge> cHm;
    private OnClickListener cHs;
    private Context mContext;

    public static final class C2400a extends C1264v {
        public C2400a(View view) {
            esl.m11128j(view, "itemView");
            super(view);
        }
    }

    public cvn(Context context, ArrayList<BCChallenge> arrayList, OnClickListener onClickListener) {
        esl.m11128j(context, "context");
        esl.m11128j(arrayList, "challenges");
        esl.m11128j(onClickListener, "clickListener");
        this.cHm = arrayList;
        this.mContext = context;
        this.cHs = onClickListener;
    }

    public /* synthetic */ C1264v mo1090c(ViewGroup viewGroup, int i) {
        return m7689l(viewGroup, i);
    }

    public C2400a m7689l(ViewGroup viewGroup, int i) {
        return new C2400a(new MyChallengeView(this.mContext));
    }

    public void m7686a(C2400a c2400a, int i) {
        Object obj = this.cHm.get(i);
        esl.m11127i(obj, "mChallengeList[position]");
        m7687a((MyChallengeView) (c2400a != null ? c2400a.arT : null), (BCChallenge) obj);
    }

    public final void m7687a(MyChallengeView myChallengeView, BCChallenge bCChallenge) {
        int w;
        int w2;
        String receiverId;
        esl.m11128j(bCChallenge, "challenge");
        BCPlayer adI = cnq.acd().acw().adI();
        ArrayList receiverStepsDays;
        List senderStepsDays;
        if (esl.m11125C(bCChallenge.getSenderId(), adI.getUserId())) {
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
            receiverId = bCChallenge.getReceiverId();
            esl.m11127i(receiverId, "challenge.receiverId");
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
            receiverId = bCChallenge.getSenderId();
            esl.m11127i(receiverId, "challenge.senderId");
        }
        BCOpponent hb = cnq.acd().acw().hb(receiverId);
        if (hb != null) {
            if (myChallengeView != null) {
                myChallengeView.setOpponentName(hb.getUserName());
            }
            if (myChallengeView != null) {
                myChallengeView.aJ(hb.getProfilePicture(), hb.getUserName());
            }
            if (myChallengeView != null) {
                myChallengeView.setTag(this.cHj, hb);
            }
        } else if (myChallengeView != null) {
            myChallengeView.setTag(this.cHj, null);
        }
        if (myChallengeView != null) {
            myChallengeView.setDetailPressed(this.cHs);
        }
        if (myChallengeView != null) {
            myChallengeView.aI(adI.getProfilePicture(), adI.getUserName());
        }
        int type = bCChallenge.getType();
        if (type == TYPE.TYPE_CHALLENGE_ONE.getValue() || type == TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue()) {
            if (myChallengeView != null) {
                esm com_fossil_esm = esm.dSO;
                receiverId = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_First_to__Steps);
                esl.m11127i(receiverId, "LanguageHelper.getString…_BC_Text_First_to__Steps)");
                Object[] objArr = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
                receiverId = String.format(receiverId, Arrays.copyOf(objArr, objArr.length));
                esl.m11127i(receiverId, "java.lang.String.format(format, *args)");
                myChallengeView.setChallengeTitle(receiverId);
            }
            if (myChallengeView != null) {
                myChallengeView.atZ();
            }
            if (bCChallenge.getStatus() != 0) {
                if (myChallengeView != null) {
                    myChallengeView.setUserProgress((w2 * 100) / bCChallenge.getGoal());
                }
                if (myChallengeView != null) {
                    myChallengeView.setOpponentProgress((w * 100) / bCChallenge.getGoal());
                }
            } else {
                if (myChallengeView != null) {
                    myChallengeView.setUserProgress(0);
                }
                if (myChallengeView != null) {
                    myChallengeView.setOpponentProgress(0);
                }
            }
        } else {
            if (!(type == TYPE.TYPE_CHALLENGE_THREE.getValue() || type == TYPE.TYPE_CHALLENGE_FIVE.getValue() || type == TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue())) {
                if (type == TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue()) {
                }
            }
            if (myChallengeView != null) {
                myChallengeView.setUserProgress(0);
            }
            if (myChallengeView != null) {
                myChallengeView.setOpponentProgress(0);
            }
            if (myChallengeView != null) {
                myChallengeView.setUserSteps(w2);
            }
            if (myChallengeView != null) {
                myChallengeView.setOpponentSteps(w);
            }
        }
        if (myChallengeView != null) {
            myChallengeView.setTag(this.cHk, bCChallenge);
        }
        type = bCChallenge.getType();
        Object[] objArr2;
        if (type == TYPE.TYPE_CHALLENGE_ONE.getValue()) {
            if (myChallengeView != null) {
                com_fossil_esm = esm.dSO;
                receiverId = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_First_to__Steps);
                esl.m11127i(receiverId, "LanguageHelper.getString…_BC_Text_First_to__Steps)");
                objArr2 = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
                receiverId = String.format(receiverId, Arrays.copyOf(objArr2, objArr2.length));
                esl.m11127i(receiverId, "java.lang.String.format(format, *args)");
                myChallengeView.setChallengeTitle(receiverId);
            }
        } else if (type == TYPE.TYPE_CHALLENGE_THREE.getValue()) {
            if (myChallengeView != null) {
                com_fossil_esm = esm.dSO;
                receiverId = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of);
                esl.m11127i(receiverId, "LanguageHelper.getString…Activity_BC_Text_Best_of)");
                objArr2 = new Object[]{Integer.valueOf(3)};
                receiverId = String.format(receiverId, Arrays.copyOf(objArr2, objArr2.length));
                esl.m11127i(receiverId, "java.lang.String.format(format, *args)");
                myChallengeView.setChallengeTitle(receiverId);
            }
        } else if (type == TYPE.TYPE_CHALLENGE_FIVE.getValue()) {
            if (myChallengeView != null) {
                com_fossil_esm = esm.dSO;
                receiverId = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of);
                esl.m11127i(receiverId, "LanguageHelper.getString…Activity_BC_Text_Best_of)");
                objArr2 = new Object[]{Integer.valueOf(5)};
                receiverId = String.format(receiverId, Arrays.copyOf(objArr2, objArr2.length));
                esl.m11127i(receiverId, "java.lang.String.format(format, *args)");
                myChallengeView.setChallengeTitle(receiverId);
            }
        } else if (type == TYPE.TYPE_CHALLENGE_ONE_DEBUG.getValue()) {
            if (myChallengeView != null) {
                com_fossil_esm = esm.dSO;
                receiverId = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_First_to__Steps) + " debug";
                objArr2 = new Object[]{NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(3500))};
                receiverId = String.format(receiverId, Arrays.copyOf(objArr2, objArr2.length));
                esl.m11127i(receiverId, "java.lang.String.format(format, *args)");
                myChallengeView.setChallengeTitle(receiverId);
            }
        } else if (type == TYPE.TYPE_CHALLENGE_THREE_DEBUG.getValue()) {
            if (myChallengeView != null) {
                com_fossil_esm = esm.dSO;
                receiverId = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of) + " debug";
                objArr2 = new Object[]{Integer.valueOf(3)};
                receiverId = String.format(receiverId, Arrays.copyOf(objArr2, objArr2.length));
                esl.m11127i(receiverId, "java.lang.String.format(format, *args)");
                myChallengeView.setChallengeTitle(receiverId);
            }
        } else if (type == TYPE.TYPE_CHALLENGE_FIVE_DEBUG.getValue() && myChallengeView != null) {
            com_fossil_esm = esm.dSO;
            receiverId = arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_BC_Text_Best_of) + " debug";
            objArr2 = new Object[]{Integer.valueOf(5)};
            receiverId = String.format(receiverId, Arrays.copyOf(objArr2, objArr2.length));
            esl.m11127i(receiverId, "java.lang.String.format(format, *args)");
            myChallengeView.setChallengeTitle(receiverId);
        }
    }

    public int getItemCount() {
        return this.cHm.size();
    }
}
