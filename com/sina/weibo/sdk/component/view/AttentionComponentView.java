package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fossil.dsp;
import com.fossil.dsx;
import com.fossil.dth;
import com.fossil.dtj;
import com.fossil.dtj.a;
import com.fossil.dtn;
import com.fossil.dto;
import com.fossil.dtq;
import com.fossil.duj;
import com.fossil.dum;
import com.fossil.duq;
import com.fossil.wearables.fsl.goaltracking.GoalTracking;
import com.misfit.frameworks.common.constants.Constants;
import com.sina.weibo.sdk.exception.WeiboException;
import org.json.JSONException;
import org.json.JSONObject;

public class AttentionComponentView extends FrameLayout {
    private static final String TAG = AttentionComponentView.class.getName();
    private C5056a drO;
    private volatile boolean drP = false;
    private FrameLayout drQ;
    private TextView drR;
    private ProgressBar drS;

    class C50521 implements OnClickListener {
        final /* synthetic */ AttentionComponentView drT;

        C50521(AttentionComponentView attentionComponentView) {
            this.drT = attentionComponentView;
        }

        public void onClick(View view) {
            this.drT.axl();
        }
    }

    class C50542 implements dto {
        final /* synthetic */ AttentionComponentView drT;

        C50542(AttentionComponentView attentionComponentView) {
            this.drT = attentionComponentView;
        }

        public void m16057a(WeiboException weiboException) {
            duj.d(AttentionComponentView.TAG, "error : " + weiboException.getMessage());
            this.drT.drP = false;
        }

        public void jP(String str) {
            duj.d(AttentionComponentView.TAG, "json : " + str);
            try {
                final JSONObject optJSONObject = new JSONObject(str).optJSONObject(GoalTracking.COLUMN_TARGET);
                this.drT.getHandler().post(new Runnable(this) {
                    final /* synthetic */ C50542 drU;

                    public void run() {
                        if (optJSONObject != null) {
                            this.drU.drT.dv(optJSONObject.optBoolean("followed_by", false));
                        }
                        this.drU.drT.drP = false;
                    }
                });
            } catch (JSONException e) {
            }
        }
    }

    class C50553 implements a {
        final /* synthetic */ AttentionComponentView drT;

        C50553(AttentionComponentView attentionComponentView) {
            this.drT = attentionComponentView;
        }

        public void jV(String str) {
            Object string = duq.ks(str).getString(Constants.RESULT);
            if (!TextUtils.isEmpty(string)) {
                try {
                    long parseInt = (long) Integer.parseInt(string);
                    if (parseInt == 1) {
                        this.drT.dv(true);
                    } else if (parseInt == 0) {
                        this.drT.dv(false);
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
    }

    public static class C5056a {
        private String dqh;
        private String dqm;
        private String drW;
        private String drX;
        private dsp drY;

        private boolean axn() {
            if (TextUtils.isEmpty(this.dqm)) {
                return false;
            }
            return true;
        }
    }

    public AttentionComponentView(Context context) {
        super(context);
        init(context);
    }

    public AttentionComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public AttentionComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        Drawable g = dum.g(context, "common_button_white.9.png", "common_button_white_highlighted.9.png");
        this.drQ = new FrameLayout(context);
        this.drQ.setBackgroundDrawable(g);
        this.drQ.setPadding(0, dum.I(getContext(), 6), dum.I(getContext(), 2), dum.I(getContext(), 6));
        this.drQ.setLayoutParams(new LayoutParams(dum.I(getContext(), 66), -2));
        addView(this.drQ);
        this.drR = new TextView(getContext());
        this.drR.setIncludeFontPadding(false);
        this.drR.setSingleLine(true);
        this.drR.setTextSize(2, 13.0f);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.drR.setLayoutParams(layoutParams);
        this.drQ.addView(this.drR);
        this.drS = new ProgressBar(getContext(), null, 16842873);
        this.drS.setVisibility(8);
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.drS.setLayoutParams(layoutParams);
        this.drQ.addView(this.drS);
        this.drQ.setOnClickListener(new C50521(this));
        dv(false);
    }

    public void setAttentionParam(C5056a c5056a) {
        this.drO = c5056a;
        if (c5056a.axn()) {
            m16064a(c5056a);
        }
    }

    private void startLoading() {
        this.drQ.setEnabled(false);
        this.drR.setVisibility(8);
        this.drS.setVisibility(0);
    }

    private void stopLoading() {
        this.drQ.setEnabled(true);
        this.drR.setVisibility(0);
        this.drS.setVisibility(8);
    }

    private void dv(boolean z) {
        stopLoading();
        if (z) {
            this.drR.setText(dum.c(getContext(), "Following", "已关注", "已關注"));
            this.drR.setTextColor(-13421773);
            this.drR.setCompoundDrawablesWithIntrinsicBounds(dum.O(getContext(), "timeline_relationship_icon_attention.png"), null, null, null);
            this.drQ.setEnabled(false);
            return;
        }
        this.drR.setText(dum.c(getContext(), "Follow", "关注", "關注"));
        this.drR.setTextColor(-32256);
        this.drR.setCompoundDrawablesWithIntrinsicBounds(dum.O(getContext(), "timeline_relationship_icon_addattention.png"), null, null, null);
        this.drQ.setEnabled(true);
    }

    private void m16064a(C5056a c5056a) {
        if (!this.drP) {
            dsx.L(getContext(), c5056a.dqh).awO();
            this.drP = true;
            startLoading();
            dtq com_fossil_dtq = new dtq(c5056a.dqh);
            com_fossil_dtq.put("access_token", c5056a.dqm);
            com_fossil_dtq.put("target_id", c5056a.drW);
            com_fossil_dtq.put("target_screen_name", c5056a.drX);
            dtn.a(getContext(), "https://api.weibo.com/2/friendships/show.json", com_fossil_dtq, "GET", new C50542(this));
        }
    }

    private void axl() {
        dtj com_fossil_dtj = new dtj(getContext());
        com_fossil_dtj.setUrl("http://widget.weibo.com/relationship/followsdk.php");
        com_fossil_dtj.jG(dum.c(getContext(), "Follow", "关注", "關注"));
        com_fossil_dtj.jU(this.drO.dqh);
        com_fossil_dtj.jQ(this.drO.drW);
        com_fossil_dtj.c(this.drO.drY);
        com_fossil_dtj.setToken(this.drO.dqm);
        com_fossil_dtj.a(new C50553(this));
        Bundle awS = com_fossil_dtj.awS();
        Intent intent = new Intent(getContext(), dth.class);
        intent.putExtras(awS);
        getContext().startActivity(intent);
    }
}
